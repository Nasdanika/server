package org.nasdanika.cdo.web.routes.app;

import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.lock.CDOLockUtil;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.net4j.util.concurrent.IRWLockManager.LockType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.Deletable;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.web.CDOIDCodec;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.cdo.web.routes.app.EOperationTargetInfo.Role;
import org.nasdanika.core.AuthorizationProvider.StandardAction;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.html.Bootstrap.Color;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
import org.nasdanika.html.Container;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Form;
import org.nasdanika.html.Form.EncType;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormGroup.Status;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.ListGroup;
import org.nasdanika.html.NamedItemsContainer;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.TextArea;
import org.nasdanika.html.Theme;
import org.nasdanika.html.UIElement;
import org.nasdanika.web.Action;
import org.nasdanika.web.BodyParameter;
import org.nasdanika.web.HeaderParameter;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.PathParameter;
import org.nasdanika.web.QueryParameter;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Resource;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.RouteMethod.Lock.Type;
import org.nasdanika.web.TargetParameter;
import org.nasdanika.web.WebMethodCommand;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

/**
 * Application route providing CRUD operations for the underlying EObject.
 * Target object specific render methods shall be in renderers, and non-object specific render methods 
 * shall be in routes.  
 * 
 * This implementation uses simplest Web mechanisms possible in order to make its workings easier to understand
 * and customize and to avoid coupling with a particular JavaScript UI framework such as Knockout.js or Angular.js. 
 * For example, it uses GET and redirects for deletion in order to keep the client-side JavaScript simple.
 * 
 * The assumption behind this design is that a typical web application compiles with 80/20 (or maybe even 90/10) principle
 *  - 80% of traffic goes through 20% of pages. Therefore, the most popular pages may be customized, generated, or hand-crafted to leverage
 *  modern techniques such as AJAX and data bindings, while the rest of pages stay simple waiting for their turn to be customized.  
 *  
 * @author Pavel
 *
 * @param <T>
 */
@Resource(
		value="/", 
		bundle="org.nasdanika.web.resources", 
		path="resources/", 
		comment="Web resources")
@Resource(
		value="/", 
		bundle="org.nasdanika.icons", 
		path="icons/", 
		comment="Icons library")
public class Route<C extends HttpServletRequestContext, T extends EObject> extends EDispatchingRoute implements Renderer<C, T> {
	
	/**
	 * If request attribute with this name is set to ``false`` then left panel is not rendered.
	 */
	public static final String LEFT_PANEL_GUARD_KEY = Route.class.getName()+":left-panel";

	/**
	 * Interpolation tokens used by the page template
	 * @author Pavel
	 *
	 */
	public enum PageTemplateTokens {
		
		RESOURCES_PATH("resources-path"),
		OBJECT_PATH("object-path"),
		CONTEXT_PATH("context-path"),
		TITLE("title"),
		HEAD("head"),
		HEADER("header"),
		LEFT_PANEL("left-panel"),
		CONTENT("content"),
		FOOTER("footer"),
		BODY("body");

		public final String literal;

		private PageTemplateTokens(String literal) {
			this.literal = literal;
		}
		
	}
	private static final String BOOTSTRAP_THEME_TOKEN = "bootstrap-theme";
	protected BundleContext bundleContext;

	protected Route(BundleContext bundleContext, Object... targets) throws Exception {
		super(bundleContext == null ? FrameworkUtil.getBundle(Route.class).getBundleContext() : bundleContext, targets);
		this.bundleContext = bundleContext == null ? FrameworkUtil.getBundle(Route.class).getBundleContext() : bundleContext;
	} 

	/**
	 * Renders object view page - single value features in a table with two columns 
	 * and "many" features in tabs. 
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment="Renders object view with breadcrumbs, single features in a table, edit button, and many features in tabs with add/edit/delete controls")
	public Object getIndexHtml(@ContextParameter C context,	@TargetParameter T target) throws Exception {
		EClass targetEClass = target.eClass();
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment content = htmlFactory.fragment();
		Fragment appConsumer = htmlFactory.fragment();
		content.content(appConsumer);
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, null, breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
				
//		if (modelElement instanceof EClass) {
//			return RenderUtil.getRenderAnnotation((EClass) modelElement, key);
//		}
				
		// Object header
		Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, appConsumer));
		content.content(objectHeader);
		
		// view 
		if (!isViewItem(context, target)) {
			content.content(renderView(context, target, appConsumer));
		}
		
		NamedItemsContainer<?, ?> featureItemsContainer = renderFeatureItemsContainer(context, target, appConsumer);
		if (!featureItemsContainer.isEmpty()) {
			content.content(featureItemsContainer);
		}
						
		return renderPage(context, target, title, content);		
	}
	
	/**
	 * Renders user home page - a list of root objects which are readable by the current user. 
	 * @throws Exception
	 */
	@RouteMethod(comment="Renders user home page - a list of root objects which are readable by the current user.")
	public Object getHomeHtml(@ContextParameter C context,	@TargetParameter T target) throws Exception {
		EClass targetEClass = target.eClass();
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment content = htmlFactory.fragment();
		Fragment appConsumer = htmlFactory.fragment();
		content.content(appConsumer);
		
		// Object header
		Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, appConsumer));
		content.content(objectHeader);		
						
		EObject root = EcoreUtil.getRootContainer(target);		
		List<EObject> entryPoints = new ArrayList<>();
		if (context.authorizeRead(root, null, null)) {
			entryPoints.add(root);
		} else {
			TreeIterator<EObject> cit = root.eAllContents();
			while (cit.hasNext()) {
				EObject next = cit.next();
				if (context.authorizeRead(next, null, null)) {
					if (context instanceof CDOViewContext) {
						if (((CDOViewContext<?,?>) context).getPrincipals().contains(next)) {
							continue;
						}
					}
					entryPoints.add(next);
					cit.prune();
				}
			}
		}
		
		// Single entry point (e.g. root) - redirect to it.
		if (entryPoints.size() == 1) {
			context.getResponse().sendRedirect(context.getObjectPath(entryPoints.iterator().next())+"/"+INDEX_HTML);
			return Action.NOP;
		}
		
		// Rendering entry points tree
		Comparator<? super EObject> labelComparator = (e1, e2) -> {
			try {
				Object l1 = getRenderer(e1).renderLabel(context, e1);
				Object l2 = getRenderer(e2).renderLabel(context, e2);					
				return Jsoup.parse(String.valueOf(l1)).text().compareTo(Jsoup.parse(String.valueOf(l2)).text());
			} catch (Exception e) {
				return e1.hashCode() - e2.hashCode();
			}
		};		
		
		// Finds the common root for all entry points.
		List<EObject> roots = new ArrayList<>(entryPoints);
		for (int i=0; i < roots.size() - 1; ++i) {
			for (EObject eObj = roots.get(i); eObj != null; eObj = eObj.eContainer()) {
				roots.set(i, eObj);
				if (i < roots.size() - 1) {
					ListIterator<EObject> nrit = roots.listIterator(i + 1);
					while (nrit.hasNext()) {
						if (EcoreUtil.isAncestor(eObj, nrit.next())) {
							nrit.remove();
						}
					}
				} 
				if (i == roots.size() - 1) {
					break;
				}
			}
		}
		if (roots.size() > 1) {
			Collections.sort(roots, labelComparator);				
		}
				
		class EntryPointsRenderer {
			
			void render(EObject obj, boolean includingThis, Container<?> container) throws Exception {
				if (includingThis) {
					Tag li = htmlFactory.tag(TagName.li);
					container.content(li);
					if (entryPoints.contains(obj)) {
						li.content(getRenderer(obj).renderLink(context, obj, false));
					} else {
						li.content(getRenderer(obj).renderIconAndLabel(context, obj));
						Tag ul = htmlFactory.tag(TagName.ul);
						for (EReference ref: obj.eClass().getEAllReferences()) {
							if (ref.isContainment()) {
								render(obj, ref, ul);
							}
						}
						if (!ul.isEmpty()) {
							li.content(ul);
						}						
					}
				} else {
					for (EReference ref: obj.eClass().getEAllReferences()) {
						if (ref.isContainment()) {
							render(obj, ref, container);
						}
					}
				}
			}
			
			@SuppressWarnings("unchecked")
			void render(EObject obj, EReference ref, Container<?> container) throws Exception {
				Collection<EObject> refElements = new ArrayList<>();
				if (ref.isMany()) {
					refElements.addAll((Collection<EObject>) obj.eGet(ref));
				} else {
					refElements.add((EObject) obj.eGet(ref));
				}
				Iterator<EObject> rit = refElements.iterator();
				Z: while (rit.hasNext()) {
					EObject re = rit.next();
					for (EObject ch: entryPoints) {
						if (EcoreUtil.isAncestor(re, ch)) {
							continue Z;
						}
					}
					rit.remove();
				}
				if (!refElements.isEmpty()) {
					if (refElements.size() > 1) {
						Collections.sort(roots, labelComparator);					
					}
					Tag li = htmlFactory.tag(TagName.li);
					li.content(getRenderer(obj).renderNamedElementIconAndLabel(context, ref));
					Tag ul = htmlFactory.tag(TagName.ul);
					for (EObject re: refElements) {
						render(re, true, ul);
					}
					if (!ul.isEmpty()) {
						li.content(ul);
						container.content(li);
					}
				}
			}
			
		}	
		
		EntryPointsRenderer epr = new EntryPointsRenderer();
		for (EObject rt: roots) {
			epr.render(rt, roots.size() > 1, content);
		}
						
		return renderPage(context, target, title, content);				
	}	
		
	/**
	 * Renders page using page template and bootstrap theme.
	 * @param context
	 * @param title
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	public Object renderPage(C context, T obj, String title, Object content) throws Exception {
		Map<String, Object> env = createRenderPageEnvironment(context);

		env.put(PageTemplateTokens.TITLE.literal, title == null ? "" : title);
		
		Object head = renderHead(context, obj);
		env.put(PageTemplateTokens.HEAD.literal, head == null ? "" : head);

		Object header = renderHeader(context, obj);
		env.put(PageTemplateTokens.HEADER.literal, header == null ? "" : header);
				
		Object leftPanel = Boolean.FALSE.equals(context.getRequest().getAttribute(LEFT_PANEL_GUARD_KEY)) ? null : renderLeftPanel(context, obj);
		env.put(PageTemplateTokens.LEFT_PANEL.literal, leftPanel == null ? "" : leftPanel);

		env.put(PageTemplateTokens.CONTENT.literal, content == null ? "" : content);
		
		Object footer = renderFooter(context, obj);
		env.put(PageTemplateTokens.FOOTER.literal, footer == null ? "" : footer);
		
		env.put(PageTemplateTokens.BODY.literal, renderBody(context, header, leftPanel, content, footer));
		
		Theme theme = getTheme(context, obj);
		if (theme == null) {
			theme = Theme.Default;
		}
		switch (theme) {
		case None:
			env.put(BOOTSTRAP_THEME_TOKEN, "");
			break;
		case Default:
			env.put(BOOTSTRAP_THEME_TOKEN, "<link href=\""+env.get(PageTemplateTokens.RESOURCES_PATH.literal)+"/bootstrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\">");
			break;
		default:
			env.put(BOOTSTRAP_THEME_TOKEN, "<link href=\""+env.get(PageTemplateTokens.RESOURCES_PATH.literal)+"/bootstrap/css/bootstrap-"+theme.name().toLowerCase()+".min.css\" rel=\"stylesheet\">");							
		}
		
		return HTMLFactory.INSTANCE.interpolate(getPageTemplate(context), env);		
	}
//	{{resources-path}}	
	/**
	 * Renders body from header, left panel, content, and footer.
	 * 
	 * @param context
	 * @param header
	 * @param leftPanel
	 * @param content
	 * @param footer
	 * @return
	 * @throws Exception 
	 */
	protected Tag renderBody(C context, Object header, Object leftPanel, Object content, Object footer) throws Exception {
		Tag bodyDiv = getHTMLFactory(context).div().style().margin("5px");		
		if (header != null) {
			bodyDiv.content(bodyDiv.getFactory().div(header));
		}
		
		Tag contentDiv = bodyDiv.getFactory().div(content);
		if (leftPanel == null) {
			bodyDiv.content(contentDiv);			
		} else {			
			Tag leftPanelDiv = bodyDiv.getFactory().div(leftPanel)
					.style("overflow-x", "scroll")
					.style().border().right("solid silver 1px");
			setLeftPanelAndContentColSizes(context, leftPanelDiv, contentDiv);
			bodyDiv.content(bodyDiv.getFactory().div(leftPanelDiv, contentDiv).bootstrap().grid().row());			
		}
		
		if (footer != null) {
			bodyDiv.content(bodyDiv.getFactory().div(footer));
		}		
		
		return bodyDiv;
	}

	/**
	 * Override to provide additional interpolation tokens used by your page template.
	 * renderPage() adds title and content tokens to the environment before passing it to interpolate();
	 * @param context
	 * @return Map containing tokens to use for interpolation of the page template.
	 */
	protected Map<String, Object> createRenderPageEnvironment(C context) throws Exception {
		HashMap<String, Object> ret = new HashMap<>();		
		ret.put(PageTemplateTokens.RESOURCES_PATH.literal, context.getObjectPath(context.getTarget())+"/resources");
		ret.put(PageTemplateTokens.CONTEXT_PATH.literal, context.getRequest().getContextPath());
		ret.put(PageTemplateTokens.OBJECT_PATH.literal, context.getObjectPath(context.getTarget()));
		return ret;
	}
	
//	protected  
	
	/**
	 * @param context
	 * @return Bootstrap/Bootswatch theme to use for rendering. 
	 */
	protected Theme getTheme(C context, T obj) throws Exception {
		return Theme.Default;
	}

	/**
	 * @return page template which takes <code>title</code>, <code>bootstrap-theme</code>, and <code>content</code> tokens for interpolation.
	 * This implementation returns resource string ``page.template``, which resolves to ``page-template.html`` resource - 
	 * a minimalistic page template with Bootstrap, Knockout, require.js, jquery.js and knockout.js scripts.
	 * @throws Exception 
	 * 
	 */
	protected Object getPageTemplate(C context) throws Exception {
		return getResource(context, "page.template");
	}
	
	@Override
	protected String getApiDocPath() {
		return "api.html";
	}
	

	/**
	 * Renders optional page head tag declarations, e.g. additional scripts and stylesheets. This implementation returns ``page.head`` resource. 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderHead(C context, T obj) throws Exception {
		return getResource(context, "page.head");
	}	

	/**
	 * Renders an optional page header. This implementation returns ``page.header`` resource. 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderHeader(C context, T obj) throws Exception {
		return getResource(context, "page.header");
	}

	/**
	 * Renders an optional page footer. This implementation returns ``page.footer`` resource.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderFooter(C context, T obj) throws Exception {
		return getResource(context, "page.footer");
	}
	
	/**
	 * Sets left panel and content sizes.
	 */
	protected void setLeftPanelAndContentColSizes(C context, UIElement<?> leftPanel,  UIElement<?> content) {
		leftPanel.bootstrap().grid().col(3);
		content.bootstrap().grid().col(9);
	}
	
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "feature/{feature}/select.html",
			action = "update",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Renders a page for adding a reference to a non-containment feature.")
	public Object selectReferenceFeatureElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,			
			@PathParameter("feature") String feature,
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {

		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature);
		if (tsf != null) {
			EClass targetEClass = target.eClass();
			HTMLFactory htmlFactory = getHTMLFactory(context);
			ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
				
				@Override
				protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
					return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? targetEClass : namedElement), key, true);
				}
				
			};
			
			if (context.getMethod() == RequestMethod.POST) {	
				try {
					setFeatureValue(context, target, tsf);
				} catch (Exception e) {
					diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.ERROR, getClass().getName(), 0, e.getMessage(), new Object[] { target, tsf, e }));
				}
				Diagnostic vr = validate(context, target);
				for (Diagnostic vc: vr.getChildren()) {
					diagnosticConsumer.accept(vc);
				}
				
				boolean ok = true;
				List<ValidationResult> featureValidationResults = diagnosticConsumer.getNamedElementValidationResults().get(tsf);
				if (featureValidationResults != null) {
					for (ValidationResult validationResult: featureValidationResults) {
						if (validationResult.status == Status.ERROR) {
							ok = false;
						}
					}
				}
				
				if (ok) { // We are only concerned about this particular feature
					// Success - redirect to referrer parameter or referer header or the view.
					if (context instanceof HttpServletRequestContext) {
						String referrer = referrerParameter;
						if (referrer == null) {
							referrer = referrerHeader;
						}
						if (referrer == null) {
							referrer = ((HttpServletRequestContext) context).getObjectPath(target)+"/"+INDEX_HTML;
						}
						((HttpServletRequestContext) context).getResponse().sendRedirect(referrer);
						return Action.NOP;
					}
					
					return "Update successful";
				}
				
				if (context instanceof TransactionContext) {
					((TransactionContext) context).setRollbackOnly();
				}
			}
					
			String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
			Fragment content = htmlFactory.fragment();
			Fragment appConsumer = htmlFactory.fragment();
			content.content(appConsumer);
			
			// Breadcrumbs
			Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
			renderObjectPath(context, target, renderNamedElementIconAndLabel(context, tsf)+" / "+getResourceString(context, "select", true), breadCrumbs);
			if (!breadCrumbs.isEmpty()) {
				content.content(breadCrumbs);
			}
			
			Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, appConsumer));
			content.content(objectHeader);				
			
			boolean horizontalForm = !"false".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.HORIZONTAL_FORM));
			boolean noValidate = "true".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.NO_VALIDATE));
			Form editForm = renderFeatureEditForm(
					context, 
					target, 
					tsf, 
					diagnosticConsumer.getNamedElementValidationResults().get(tsf), 
					horizontalForm,
					null,
					appConsumer)
				.novalidate(noValidate)
				.action("select.html")				
				.method(Method.post);
			
			configureForm(editForm, horizontalForm, ModalType.NONE);
			
			String originalReferrer = referrerParameter;
			if (originalReferrer == null) {
				originalReferrer = referrerHeader;
			}
			if (originalReferrer != null) {
				editForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
			}		
			
			Tag buttonBar = htmlFactory.div().style().text().align().right();
			buttonBar.content(renderSaveButton(context, target).style().margin().right("5px"));
			buttonBar.content(renderCancelButton(context, target));
			editForm.content(buttonBar);
			
			content.content(editForm);
			
			return renderPage(context, target, title, content);		
		}
		
		return Action.BAD_REQUEST;				
	}
	
	/**
	 * @param context
	 * @param target
	 * @param referrerHeader
	 * @param reference
	 * @param epackage
	 * @param eclass
	 * @param referrerParameter
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "reference/{reference}/create/{epackage}/{eclass}",
			action = "create",
			qualifier = "{reference}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type = Type.WRITE), 
			comment="Renders a page for creating an object and adding it to a containment reference.")
	public Object createContainementReferenceElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,			
			@PathParameter("reference") String reference,
			@PathParameter("epackage") String epackage,
			@PathParameter("eclass") String eclass,
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {
		
		EStructuralFeature tsf = target.eClass().getEStructuralFeature(reference);
		HttpServletRequest request = context.getRequest();
		request.setAttribute(CONTEXT_ESTRUCTURAL_FEATURE_KEY, tsf);
		if (tsf instanceof EReference && context instanceof CDOViewContext) {
			String ePackageNsURI = new String(Hex.decodeHex(epackage.toCharArray()));
			EPackage ePackage = ((CDOViewContext<CDOView, ?>) context).getView().getSession().getPackageRegistry().getEPackage(ePackageNsURI);
			if (ePackage != null) {
				boolean isJSON = CONTENT_TYPE_APPLICATION_JSON.equals(request.getContentType());
				EClassifier eClassifier = ePackage.getEClassifier(eclass.substring(0, eclass.length() - (isJSON ? EXTENSION_JSON : EXTENSION_HTML).length()));
				EClass eReferenceType = ((EReference) tsf).getEReferenceType();
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;					
					EObject instance = ePackage.getEFactoryInstance().create(eClass);
					if (eReferenceType.isInstance(instance)) {
						Renderer<C, EObject> renderer = getReferenceRenderer((EReference) tsf, instance);
						
						ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
							
							@Override
							protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
								return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? eClass : namedElement), key, true);
							}
							
							@Override
							public void accept(Diagnostic diagnostic) {
								// Ignore in GET
								if (context.getMethod() == RequestMethod.POST) {
									super.accept(diagnostic);
								}
							}
							
						};
						
						Object featureValue = target.eGet(tsf);
						// Adding the new instance to the object graph for selectors to work. 
						if (tsf.isMany()) {
							((Collection<Object>) featureValue).add(instance);
						} else {
							target.eSet(tsf, instance);
						}					
						
						// Set for GET from query parameters and for POST from form inputs. Display validation results only for POST.
						boolean setSuccessful = renderer.setEditableFeatures(context, instance, diagnosticConsumer);
						if (context.getMethod() == RequestMethod.POST) {
							if (isJSON) {
								// AJAX 
								if (setSuccessful) {
									if (getRenderer(instance).isViewOnCreate(context, instance)) {
										
										// Rendering response post-commit to get permanent CDOID
										return new Action() {

											@Override
											public void close() throws Exception {
												// NOP												
											}

											@Override
											public Object execute() throws Exception {
//												context.getResponse().setContentType(CONTENT_TYPE_APPLICATION_JSON);
												JSONObject result = new JSONObject();
												result.put("location", context.getObjectPath(instance)+"/"+INDEX_HTML);
												return result;
											}
											
										};
									} else {
//										context.getResponse().setContentType(CONTENT_TYPE_APPLICATION_JSON);
										JSONObject result = new JSONObject();
										String referrer = referrerParameter;
										if (referrer == null) {
											referrer = referrerHeader;
										}
										if (referrer == null) {
											referrer = context.getObjectPath(target)+"/"+INDEX_HTML;
										}
										int referrerQueryStart = referrer.indexOf("?");
										if (referrerQueryStart == -1) {
											referrer +=  "?";
										} else {
											StringBuilder queryBuilder = new StringBuilder();
											for (String qe: referrer.substring(referrerQueryStart+1).split("&")) {
												if (!qe.startsWith("context-feature=")) {
													queryBuilder.append(qe).append("&");
												}
											}
											referrer = referrer.substring(0, referrerQueryStart+1)+queryBuilder;
										}
										referrer += "context-feature="+URLEncoder.encode(reference, StandardCharsets.UTF_8.name());
										result.put("location", referrer);
										return result;
									} 
								} else {
									JSONObject result = new JSONObject();
									result.put("validationResults", diagnosticConsumer.toJSON());
									
									// Removing the new instance from the object graph. 
									if (tsf.isMany()) {
										((Collection<Object>) featureValue).remove(instance);
									} else {
										target.eSet(tsf, featureValue);
									}
									
									return result;
								}
							} else if (setSuccessful) {
								// Success - add/set instance to the feature and then redirect to referrer parameter or referer header or the view.
								if (renderer.isViewOnCreate(context, instance)) {
									return new Action() {

										@Override
										public void close() throws Exception {
											// NOP											
										}

										@Override
										public Object execute() throws Exception {
											context.getResponse().sendRedirect(context.getObjectPath(instance)+"/"+INDEX_HTML);
											return null;
										}
										
									};
								}
								
								String referrer = referrerParameter;
								if (referrer == null) {
									referrer = referrerHeader;
								}
								if (referrer == null) {
									referrer = ((HttpServletRequestContext) context).getObjectPath(target)+"/"+INDEX_HTML;
								}
								int referrerQueryStart = referrer.indexOf("?");
								if (referrerQueryStart == -1) {
									referrer +=  "?";
								} else {
									StringBuilder queryBuilder = new StringBuilder();
									for (String qe: referrer.substring(referrerQueryStart+1).split("&")) {
										if (!qe.startsWith("context-feature=")) {
											queryBuilder.append(qe).append("&");
										}
									}
									referrer = referrer.substring(0, referrerQueryStart+1)+queryBuilder;
								}
								referrer += "context-feature="+URLEncoder.encode(reference, StandardCharsets.UTF_8.name());
								context.getResponse().sendRedirect(referrer);
								return Action.NOP;
							}
						} 
						
						HTMLFactory htmlFactory = getHTMLFactory(context);
						String title = StringEscapeUtils.escapeHtml4(renderer.nameToLabel(eClass.getName()));
						Fragment content = htmlFactory.fragment();
						Fragment appConsumer = htmlFactory.fragment();
						content.content(appConsumer);
						
						// Breadcrumbs
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						renderFeaturePath(context, target, tsf, renderer.getResourceString(context, "create", true) + " / " + renderNamedElementIconAndLabel(context, eClass), breadCrumbs);
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
						
						// Object header
						Tag classDocIcon = renderer.renderDocumentationIcon(context, eClass, appConsumer, true);		
						
						Tag objectHeader = content.getFactory().tag(TagName.h3, getResourceString(context, "create"), " ", renderer.renderNamedElementIconAndLabel(context, eClass), classDocIcon);
						content.content(objectHeader);
																
						boolean horizontalForm = !"false".equals(renderer.getRenderAnnotation(context, eClass, RenderAnnotation.HORIZONTAL_FORM));
						boolean noValidate = "true".equals(renderer.getRenderAnnotation(context, eClass, RenderAnnotation.NO_VALIDATE));
						Form editForm = renderer.renderEditForm(
								context, 
								instance, 
								diagnosticConsumer.getValidationResults(), 
								diagnosticConsumer.getNamedElementValidationResults(), 
								horizontalForm,
								null,
								content)
							.novalidate(noValidate)
							.action(eclass)
							.method(Method.post);
						
						configureForm(editForm, horizontalForm, ModalType.NONE);
						
						String originalReferrer = referrerParameter;
						if (originalReferrer == null) {
							originalReferrer = referrerHeader;
						}
						if (originalReferrer != null) {
							editForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
						}		
						
						Tag buttonBar = htmlFactory.div().style().text().align().right();
						buttonBar.content(renderer.renderSaveButton(context, instance).style().margin().right("5px"));
						buttonBar.content(renderer.renderCancelButton(context, instance));
						editForm.content(buttonBar);
						
						content.content(editForm);	
						
						// Removing the new instance from the object graph. 
						if (tsf.isMany()) {
							((Collection<Object>) featureValue).remove(instance);
						} else {
							target.eSet(tsf, featureValue);
						}					
	
						return renderPage(context, target, title, content);
					}
				}							
			}
		}
		
		return Action.BAD_REQUEST;		
	}
	
	
	@SuppressWarnings("unchecked")
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "attribute/{attribute}/add.html",
			action = "update",
			qualifier = "{attribute}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type = Type.WRITE), 
			comment="Renders a page for adding a new element to a muliti-value attribute.")
	public Object addAttributeElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,			
			@PathParameter("attribute") String attribute,
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {

		EStructuralFeature tsf = target.eClass().getEStructuralFeature(attribute);
		if (tsf instanceof EAttribute && tsf.isMany()) {
			ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
				
				@Override
				protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
					return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? target.eClass() : namedElement), key, true);
				}
				
				@Override
				public void accept(Diagnostic diagnostic) {
					// Ignore in GET
					if (context.getMethod() == RequestMethod.POST) {
						super.accept(diagnostic);
					}
				}
				
			};
			
			boolean setSuccessful = true;
			// Adding the new value to the attribute.
			String value = context.getRequest().getParameter(tsf.getName());
			if (value == null) {
				diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.ERROR, getClass().getName(), 0, "Required value", new Object[] { target, tsf }));
				setSuccessful = false;
			} else {
				try {
					((Collection<Object>) target.eGet(tsf)).add(parseTypedElementValue(context, tsf, value));
				} catch (Exception e) {
					Throwable rootCause = e;
					while (rootCause.getCause() != null) {
						rootCause = rootCause.getCause();
					}
					setSuccessful = false;
					if (diagnosticConsumer != null) {
						String rootCauseMessage = rootCause.getMessage() == null ? rootCause.toString() : rootCause.getMessage();
						diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.ERROR, getClass().getName(), 0, rootCauseMessage, new Object[] { target, tsf, e }));
					}
				}
				Diagnostic vr = validate(context, target);
				for (Diagnostic vc: vr.getChildren()) {
					List<?> vcData = vc.getData();
					if (!vcData.isEmpty() 
							&& vcData.get(0) == target 
							&& (vcData.size() == 1 || tsf == vcData.get(1))) {

						if (vc.getSeverity() == Diagnostic.ERROR) {
							setSuccessful = false;
						}
						
						diagnosticConsumer.accept(vc);
					}
				}
			}
			
			if (context.getMethod() == RequestMethod.POST && setSuccessful) {			
				// Success - add/set instance to the feature and then redirect to referrer parameter or referer header or the view.
				if (context instanceof HttpServletRequestContext) {
					String referrer = referrerParameter;
					if (referrer == null) {
						referrer = referrerHeader;
					}
					if (referrer == null) {
						referrer = ((HttpServletRequestContext) context).getObjectPath(target)+"/"+INDEX_HTML;
					}
					int referrerQueryStart = referrer.indexOf("?");
					if (referrerQueryStart == -1) {
						referrer +=  "?";
					} else {
						StringBuilder queryBuilder = new StringBuilder();
						for (String qe: referrer.substring(referrerQueryStart+1).split("&")) {
							if (!qe.startsWith("context-feature=")) {
								queryBuilder.append(qe).append("&");
							}
						}
						referrer = referrer.substring(0, referrerQueryStart+1)+queryBuilder;
					}
					referrer += "context-feature="+URLEncoder.encode(attribute, StandardCharsets.UTF_8.name());
					((HttpServletRequestContext) context).getResponse().sendRedirect(referrer);
					return Action.NOP;
				}
				
				return "Update successful";
			} 
			
			// Rollback transaction to undo the change.
			if (context instanceof TransactionContext) {
				((TransactionContext) context).setRollbackOnly();
			}

			HTMLFactory htmlFactory = getHTMLFactory(context);
			String title = StringEscapeUtils.escapeHtml4(nameToLabel(tsf.getName())+" - add value");
			Fragment content = htmlFactory.fragment();
			Fragment appConsumer = htmlFactory.fragment();
			content.content(appConsumer);
			
			// Breadcrumbs
			Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
			String addResourceString = getResourceString(context, "add", true);
			renderFeaturePath(context, target, tsf, addResourceString, breadCrumbs);
			if (!breadCrumbs.isEmpty()) {
				content.content(breadCrumbs);
			}
			
			// Object header
			
			Tag attributeHeader = content.getFactory().tag(TagName.h3,
					addResourceString, 
					" ", 
					renderNamedElementIconAndLabel(context, tsf), 
					renderDocumentationIcon(context, tsf, appConsumer, true));
			content.content(attributeHeader);
			
			Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, appConsumer));
			content.content(objectHeader);
													
			boolean horizontalForm = !"false".equals(getRenderAnnotation(context, tsf, RenderAnnotation.HORIZONTAL_FORM));
			boolean noValidate = "true".equals(getRenderAnnotation(context, tsf, RenderAnnotation.NO_VALIDATE));
			Form addForm = htmlFactory.form();
			
			ListGroup errorList = htmlFactory.listGroup();
			for (ValidationResult vr: diagnosticConsumer.getValidationResults()) {
				errorList.item(vr.message, vr.status.toStyle());			
			}
			
			if (horizontalForm) {
				for (Entry<ENamedElement, List<ValidationResult>> fe: diagnosticConsumer.getNamedElementValidationResults().entrySet()) {
					for (ValidationResult fvr: fe.getValue()) {
						Object featureNameLabel = renderNamedElementIconAndLabel(context, fe.getKey());
						errorList.item(htmlFactory.label(fvr.status.toStyle(), featureNameLabel) + " " + fvr.message, fvr.status.toStyle());											
					}
				}
			}
			
			if (!errorList.isEmpty()) {
				addForm.content(errorList);
			}
			
			renderTypedElementFormGroup(
					context, 
					target, 
					tsf, 
					Collections.singletonList(tsf), 
					value, 
					addForm, 
					diagnosticConsumer.getNamedElementValidationResults().get(tsf), 
					horizontalForm,
					null,
					appConsumer);
			
			addForm
				.novalidate(noValidate)
				.action("add.html")
				.method(Method.post);
			
			configureForm(addForm, horizontalForm, ModalType.NONE);
			
			String originalReferrer = referrerParameter;
			if (originalReferrer == null) {
				originalReferrer = referrerHeader;
			}
			if (originalReferrer != null) {
				addForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
			}		
			
			Tag buttonBar = htmlFactory.div().style().text().align().right();
			
			Button addButton = htmlFactory.button(renderAddIcon(context).style().margin().right("5px"), addResourceString)
					.style(Style.PRIMARY)
					.style().margin().right("5px");
			
			addButton.type(org.nasdanika.html.Button.Type.SUBMIT);
			buttonBar.content(addButton, renderCancelButton(context, target));
			addForm.content(buttonBar);
			
			content.content(addForm);		
			return renderPage(context, target, title, content);
		}
		
		return Action.BAD_REQUEST;		
	}			
		
	@RouteMethod(
			value = RequestMethod.GET,
			qualifier = "{feature}",
			path = "feature/{feature}/view.html",
			produces = "text/html",
			comment="Renders a feature view page.")
	public Object viewFeature(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		EStructuralFeature sf = target.eClass().getEStructuralFeature(feature);
		if (sf == null) {
			return Action.NOT_FOUND;
		}
		
		if (!getVisibleFeatures(context, target, null).contains(sf)) {
			context.getResponse().sendRedirect("../../index.html"); // For conditionally visible features if the condition has changed.
			return Action.NOP;
		}
		
		EClass targetEClass = target.eClass();
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment content = htmlFactory.fragment();
		Fragment appConsumer = htmlFactory.fragment();
		content.content(appConsumer);
				
		Fragment editAppsAccumulator = htmlFactory.fragment();
		content.content(editAppsAccumulator);			
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderFeaturePath(context, target, sf, null, breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
				
		// Headers
		Tag featureHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, sf));
		Tag featureDocIcon = renderDocumentationIcon(context, sf, appConsumer, true);
		if (featureDocIcon != null) {
			featureHeader.content(featureDocIcon);
		}

		content.content(featureHeader);
		
		Tag objectHeader = content.getFactory().tag(TagName.h4, renderObjectHeader(context, target, appConsumer));
		content.content(objectHeader);
		
		// Applies filter-<view feature name>-<column feature name>=control value filters		
		FeatureTableFilterManager<C, T> featureTableFilterManager = sf.getEType() instanceof EClass ? new FeatureTableFilterManager<C, T>(context, sf, this, null, appConsumer) : null; 
		
		// view 
		content.content(renderTypedElementView(context, target, sf, target.eGet(sf), true, featureTableFilterManager, null, featureTableFilterManager, appConsumer));
		
		context.getRequest().setAttribute(CONTEXT_ESTRUCTURAL_FEATURE_KEY, sf);
		return renderPage(context, target, title, content);
	}	
	
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST },
			action = "update",
			qualifier = "{feature}",
			path = "feature/{feature}/edit.html",
			produces = "text/html",
			comment="Renders an edit/select page for a single-value feature.")
	public Object editFeature(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		// TODO
		return "Edit "+feature;
		
	}
		
	@SuppressWarnings("unchecked")
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			action = "update",
			qualifier = "{feature}",
			path = "feature/{feature}/{element}/edit.html",
			produces = "text/html",
			comment="Renders an edit/select page for an element of multi-value feature.")
	public Object editFeatureElement(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@PathParameter("element") int element,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,			
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {
		
		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature);
		
		// Supporting only attributes - references shall be edited using their edit route, although it is possible to do it here as well, if needed.  
		if (tsf instanceof EAttribute && tsf.isMany()) {
			ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
				
				@Override
				protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
					return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? target.eClass() : namedElement), key, true);
				}
				
				@Override
				public void accept(Diagnostic diagnostic) {
					// Ignore in GET
					if (context.getMethod() == RequestMethod.POST) {
						super.accept(diagnostic);
					}
				}
				
			};

			List<Object> attributeValues = (List<Object>) target.eGet(tsf);
			if (element < 0 || attributeValues.size() <= element) {
				return Action.BAD_REQUEST;
			}
			
			if (context.getMethod() == RequestMethod.POST) {
				boolean setSuccessful = true;
				// Adding the new value to the attribute.
				String value = context.getRequest().getParameter(tsf.getName());
				if (value == null) {
					diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.ERROR, getClass().getName(), 0, "Required value", new Object[] { target, tsf }));
					setSuccessful = false;
				} else {
					try {
						attributeValues.set(element, parseTypedElementValue(context, tsf, value));
					} catch (Exception e) {
						Throwable rootCause = e;
						while (rootCause.getCause() != null) {
							rootCause = rootCause.getCause();
						}
						setSuccessful = false;
						if (diagnosticConsumer != null) {
							String rootCauseMessage = rootCause.getMessage() == null ? rootCause.toString() : rootCause.getMessage();
							diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.ERROR, getClass().getName(), 0, rootCauseMessage, new Object[] { target, tsf, e }));
						}
					}
					Diagnostic vr = validate(context, target);
					for (Diagnostic vc: vr.getChildren()) {
						List<?> vcData = vc.getData();
						if (!vcData.isEmpty() 
								&& vcData.get(0) == target 
								&& (vcData.size() == 1 || tsf == vcData.get(1))) {

							if (vc.getSeverity() == Diagnostic.ERROR) {
								setSuccessful = false;
							}
							
							diagnosticConsumer.accept(vc);
						}
					}
				}
								
				// Success - add/set instance to the feature and then redirect to referrer parameter or referer header or the view.
				if (setSuccessful) {
					if (context instanceof HttpServletRequestContext) {
						String referrer = referrerParameter;
						if (referrer == null) {
							referrer = referrerHeader;
						}
						if (referrer == null) {
							referrer = ((HttpServletRequestContext) context).getObjectPath(target)+"/"+INDEX_HTML;
						}
						int referrerQueryStart = referrer.indexOf("?");
						if (referrerQueryStart == -1) {
							referrer +=  "?";
						} else {
							StringBuilder queryBuilder = new StringBuilder();
							for (String qe: referrer.substring(referrerQueryStart+1).split("&")) {
								if (!qe.startsWith("context-feature=")) {
									queryBuilder.append(qe).append("&");
								}
							}
							referrer = referrer.substring(0, referrerQueryStart+1)+queryBuilder;
						}
						referrer += "context-feature="+URLEncoder.encode(feature, StandardCharsets.UTF_8.name());
						((HttpServletRequestContext) context).getResponse().sendRedirect(referrer);
						return Action.NOP;
					}
					
					return "Update successful";
				}
			} 
			
			// Rollback transaction to undo the change.
			if (context instanceof TransactionContext) {
				((TransactionContext) context).setRollbackOnly();
			}

			HTMLFactory htmlFactory = getHTMLFactory(context);
			String title = StringEscapeUtils.escapeHtml4(nameToLabel(tsf.getName())+" - edit value");
			Fragment content = htmlFactory.fragment();
			Fragment appConsumer = htmlFactory.fragment();
			content.content(appConsumer);
			
			// Breadcrumbs
			Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
			String addResourceString = getResourceString(context, "edit", true);
			renderFeaturePath(context, target, tsf, addResourceString, breadCrumbs);
			if (!breadCrumbs.isEmpty()) {
				content.content(breadCrumbs);
			}
			
			Tag attributeHeader = content.getFactory().tag(TagName.h3,
					addResourceString, 
					" ", 
					renderNamedElementIconAndLabel(context, tsf), 
					renderDocumentationIcon(context, tsf, appConsumer, true));
			content.content(attributeHeader);
			
			Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, appConsumer));
			content.content(objectHeader);
													
			boolean horizontalForm = !"false".equals(getRenderAnnotation(context, tsf, RenderAnnotation.HORIZONTAL_FORM));
			boolean noValidate = "true".equals(getRenderAnnotation(context, tsf, RenderAnnotation.NO_VALIDATE));
			Form editForm = htmlFactory.form();
			
			ListGroup errorList = htmlFactory.listGroup();
			for (ValidationResult vr: diagnosticConsumer.getValidationResults()) {
				errorList.item(vr.message, vr.status.toStyle());			
			}
			
			if (horizontalForm) {
				for (Entry<ENamedElement, List<ValidationResult>> fe: diagnosticConsumer.getNamedElementValidationResults().entrySet()) {
					for (ValidationResult fvr: fe.getValue()) {
						Object featureNameLabel = renderNamedElementIconAndLabel(context, fe.getKey());
						errorList.item(htmlFactory.label(fvr.status.toStyle(), featureNameLabel) + " " + fvr.message, fvr.status.toStyle());											
					}
				}
			}
			
			if (!errorList.isEmpty()) {
				editForm.content(errorList);
			}
			
			renderTypedElementFormGroup(
					context, 
					target, 
					tsf, 
					Collections.singletonList(tsf), 
					attributeValues.get(element), 
					editForm, 
					diagnosticConsumer.getNamedElementValidationResults().get(tsf), 
					horizontalForm,
					null,
					appConsumer);
			
			editForm
				.novalidate(noValidate)
				.action("edit.html")
				.method(Method.post);
			
			configureForm(editForm, horizontalForm, ModalType.NONE);
			
			String originalReferrer = referrerParameter;
			if (originalReferrer == null) {
				originalReferrer = referrerHeader;
			}
			if (originalReferrer != null) {
				editForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
			}		
			
			Tag buttonBar = htmlFactory.div().style().text().align().right();
			
			Button saveButton = htmlFactory.button(renderSaveIcon(context).style().margin().right("5px"), getResourceString(context, "save", true))
					.style(Style.PRIMARY)
					.style().margin().right("5px");
			
			saveButton.type(org.nasdanika.html.Button.Type.SUBMIT);
			buttonBar.content(saveButton, renderCancelButton(context, target));
			editForm.content(buttonBar);
			
			content.content(editForm);		
			return renderPage(context, target, title, content);
		}
		
		return Action.BAD_REQUEST;		
	}
	
	/**
	 * Renders and processes edit form. The form is horizontal by default, set ``horizontal-form`` annotation on the target EClass to ``false`` to override.
	 * @param context
	 * @param target
	 * @param referrerParameter
	 * @param referrerHeader
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(
			comment="Renders object edit form.",
			action = "update",
			value = { RequestMethod.GET, RequestMethod.POST },
			path = "edit.html")
	public Object edit(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,			
			@QueryParameter(REFERRER_KEY) String referrerParameter,
			@QueryParameter(OBJECT_VERSION_KEY) String objectVersionParameter) throws Exception {
		
		EClass targetEClass = target.eClass();
		HTMLFactory htmlFactory = getHTMLFactory(context);
		ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
			
			@Override
			protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
				return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? targetEClass : namedElement), key, true);
			}
			
		};
		
		Fragment content = htmlFactory.fragment();
		Fragment appConsumer = htmlFactory.fragment();
		content.content(appConsumer);

		
		if (context.getMethod() == RequestMethod.POST) {
			boolean versionMatch = true;
			if (target instanceof CDOObject) {
				CDORevision revision = ((CDOObject) target).cdoRevision();
				if (revision != null && objectVersionParameter != null && revision.getVersion() != Integer.parseInt(objectVersionParameter)) {
					versionMatch = compareEditableFeatures(context, target, diagnosticConsumer, appConsumer);
					if (!versionMatch) {
						diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.WARNING, getClass().getName(), 0, getResourceString(context, "concurrentModification.object"), new Object[] { target }));
					}
				}
			}
			
			if (versionMatch && setEditableFeatures(context, target, diagnosticConsumer)) {
				// Success - redirect to referrer parameter or referer header or the view.
				if (context instanceof HttpServletRequestContext) {
					String referrer = referrerParameter;
					if (referrer == null) {
						referrer = referrerHeader;
					}
					if (referrer == null) {
						referrer = ((HttpServletRequestContext) context).getObjectPath(target)+"/"+INDEX_HTML;
					}
					((HttpServletRequestContext) context).getResponse().sendRedirect(referrer);
					return Action.NOP;
				}
				
				return "Update successful";
			}
			
			if (context instanceof TransactionContext) {
				((TransactionContext) context).setRollbackOnly();
			}
		}
				
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, getResourceString(context, "edit", true), breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, appConsumer));
		content.content(objectHeader);				
		
		boolean horizontalForm = !"false".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.HORIZONTAL_FORM));
		boolean noValidate = "true".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.NO_VALIDATE));
		Form editForm = renderEditForm(
				context, 
				target, 
				diagnosticConsumer.getValidationResults(), 
				diagnosticConsumer.getNamedElementValidationResults(), 
				horizontalForm,
				null,
				content)
			.novalidate(noValidate)
			.action("edit.html")
			.method(Method.post);
		
		configureForm(editForm, horizontalForm, ModalType.NONE);
		
		String originalReferrer = referrerParameter;
		if (originalReferrer == null) {
			originalReferrer = referrerHeader;
		}
		if (originalReferrer != null) {
			editForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
		}	

		// Optimistic locking
		if (target instanceof CDOObject) {
			CDORevision revision = ((CDOObject) target).cdoRevision();
			if (revision != null) {
				editForm.content(htmlFactory.input(InputType.hidden).name(OBJECT_VERSION_KEY).value(revision.getVersion()));
			}
		}
		
		Tag buttonBar = htmlFactory.div().style().text().align().right();
		buttonBar.content(renderSaveButton(context, target).style().margin().right("5px"));
		buttonBar.content(renderCancelButton(context, target));
		editForm.content(buttonBar);
		
		content.content(editForm);
		
		return renderPage(context, target, title, content);		
	}		
	
	/**
	 * Processes AJAX update.
	 * @param context
	 * @param target
	 * @param referrerParameter
	 * @param referrerHeader
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(
			comment = "Processes AJAX update.",
			consumes = CONTENT_TYPE_APPLICATION_JSON,
			produces = CONTENT_TYPE_APPLICATION_JSON,
			lock = @RouteMethod.Lock(type = Type.WRITE))
	public Object putUpdate(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,	
			@BodyParameter JSONObject data) throws Exception {
		
		context.getRequest().setAttribute(JSON_DATA_REQUEST_ATTRIBUTE_KEY, data); // To avoid repeat attempt to parse body.		
		
		EClass targetEClass = target.eClass();
		ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
			
			@Override
			protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
				return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? targetEClass : namedElement), key, true);
			}
			
		};
		
		boolean versionMatch = true;
		if (target instanceof CDOObject) {
			CDORevision revision = ((CDOObject) target).cdoRevision();
			if (revision != null && data.has(OBJECT_VERSION_KEY) && revision.getVersion() != data.getInt(OBJECT_VERSION_KEY)) {
				Consumer<Object> appConsumer = new Consumer<Object>() {
					
					@Override
					public void accept(Object content) {
						// NOP						
					}
					
				};
				versionMatch = compareEditableFeatures(context, target, diagnosticConsumer, appConsumer);
				if (!versionMatch) {
					diagnosticConsumer.accept(new BasicDiagnostic(Diagnostic.WARNING, getClass().getName(), 0, getResourceString(context, "concurrentModification.object"), new Object[] { target }));
				}
			}
		}
		
		if (versionMatch && setEditableFeatures(context, target, diagnosticConsumer)) {
			JSONObject result = new JSONObject();
			String referrer = referrerHeader;
			if (referrer == null) {
				referrer = ((HttpServletRequestContext) context).getObjectPath(target)+"/"+INDEX_HTML;
			}
			String containerContextKey = ".container-context";
			boolean containerContext = data.has(containerContextKey) ? data.getBoolean(containerContextKey) : false;
			if (containerContext) {
				int referrerQueryStart = referrer.indexOf("?");
				if (referrerQueryStart == -1) {
					referrer +=  "?";
				} else {
					StringBuilder queryBuilder = new StringBuilder();
					for (String qe: referrer.substring(referrerQueryStart+1).split("&")) {
						if (!qe.startsWith("context-feature=")) {
							queryBuilder.append(qe).append("&");
						}
					}
					referrer = referrer.substring(0, referrerQueryStart+1)+queryBuilder;
				}
				referrer += "context-feature="+URLEncoder.encode(target.eContainmentFeature().getName(), StandardCharsets.UTF_8.name());
			}
			result.put("location", referrer);
			return result;
		}
		
		JSONObject result = new JSONObject();
		result.put("validationResults", diagnosticConsumer.toJSON());
		
		if (context instanceof TransactionContext) {
			((TransactionContext) context).setRollbackOnly();
		}
		
		return result;
	}		
		
	@SuppressWarnings("unchecked")
	@RouteMethod(
			comment="Deletes this element and redirects either to the referrer or to the parent's index.html if the referrer is one of 'this' object pages.",
			lock = @RouteMethod.Lock(type=Type.WRITE, path=".."), 
			action = "delete")
	public Object getDeleteHtml(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrer) throws Exception {
		
		String redirectURL;
		if (CoreUtil.isBlank(referrer)) {
			if (target.eContainer() == null) {
				redirectURL = null;
			} else {
				String containerURI = getRenderer(target.eContainer().eClass()).getObjectURI(context, target.eContainer());
				if (containerURI == null) {
					redirectURL = null;
				} else {
					redirectURL = containerURI+"/index.html";
				}
			}
		} else {
			String rurl = context.getRequest().getRequestURL().toString();
			int dIdx = rurl.lastIndexOf("/");
			int rIdx = referrer.lastIndexOf("/");
			if (dIdx == rIdx && dIdx != -1 && rurl.substring(0, dIdx).equals(referrer.substring(0, rIdx))) {
				// "Self-destruction"
				String containerURI = getRenderer(target.eContainer().eClass()).getObjectURI(context, target.eContainer());
				if (containerURI == null) {
					redirectURL = null;
				} else {
					redirectURL = containerURI+"/index.html";
				}				
			} else {
				redirectURL = referrer;
			}
		}
		
		if (target instanceof Deletable && context instanceof CDOTransactionContext) {
			((Deletable<CDOTransactionContext<?>>) target).delete((CDOTransactionContext<?>) context);
		} else {
			EcoreUtil.delete(target, true);
		}
		if (redirectURL == null) {
			return "Deleted";
		}
		
		context.getResponse().sendRedirect(redirectURL);
		
		return Action.NOP; 
	}		
		
	@RouteMethod(
			value = RequestMethod.GET,
			path = "feature/{feature}/delete.html",
			action = "delete",
			qualifier = "{feature}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type=Type.WRITE), 
			comment="Clears single-value feature and redirects to the referrer.")
	public Object deleteFeature(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrer,
			@PathParameter("feature") String feature) throws Exception {
		
		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature);
		if (tsf != null) {
			String redirectURL;
			if (CoreUtil.isBlank(referrer)) {
				String targetURI = getObjectURI(context, target);
				if (targetURI == null) {
					redirectURL = null;
				} else {
					redirectURL = targetURI+"/index.html";
				}
			} else {
				redirectURL = referrer;
			}
			
			target.eUnset(tsf);
			if (redirectURL == null) {
				return "Cleared";
			}
			
			int redirectQueryStart = redirectURL.indexOf("?");
			if (redirectQueryStart == -1) {
				redirectURL +=  "?";
			} else {
				StringBuilder queryBuilder = new StringBuilder();
				for (String qe: redirectURL.substring(redirectQueryStart+1).split("&")) {
					if (!qe.startsWith("context-feature=")) {
						queryBuilder.append(qe).append("&");
					}
				}
				redirectURL = redirectURL.substring(0, redirectQueryStart+1)+queryBuilder;
			}
			redirectURL += "context-feature="+URLEncoder.encode(feature, StandardCharsets.UTF_8.name());
			
			context.getResponse().sendRedirect(redirectURL);
			
			return Action.NOP;
		}
		
		return Action.BAD_REQUEST;
	}
		
	@RouteMethod(
			value = RequestMethod.GET,
			path = "feature/{feature}/{element}/delete.html",
			action = "delete",
			qualifier = "{feature}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type=Type.WRITE), 
			comment="Removes an element from a multi-value feature and redirects to the referrer.")
	public Object deleteFeatureElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrer,
			@PathParameter("feature") String feature,
			@PathParameter("element") String element) throws Exception {
		
		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature);
		if (tsf != null) {
			String redirectURL;
			if (CoreUtil.isBlank(referrer)) {
				String targetURI = getObjectURI(context, target);
				if (targetURI == null) {
					redirectURL = null;
				} else {
					redirectURL = targetURI+"/index.html";
				}
			} else {
				redirectURL = referrer;
			}
			
			int idx = Integer.parseInt(element);
			
			((List<?>) target.eGet(tsf)).remove(idx);
			if (redirectURL == null) {
				return "Removed "+idx;
			}
			
			int redirectQueryStart = redirectURL.indexOf("?");
			if (redirectQueryStart == -1) {
				redirectURL +=  "?";
			} else {
				StringBuilder queryBuilder = new StringBuilder();
				for (String qe: redirectURL.substring(redirectQueryStart+1).split("&")) {
					if (!qe.startsWith("context-feature=")) {
						queryBuilder.append(qe).append("&");
					}
				}
				redirectURL = redirectURL.substring(0, redirectQueryStart+1)+queryBuilder;
			}
			redirectURL += "context-feature="+URLEncoder.encode(feature, StandardCharsets.UTF_8.name());
			
			context.getResponse().sendRedirect(redirectURL);
			
			return Action.NOP;
		}
		
		return Action.BAD_REQUEST;
		
	}
	
	// TODO - trace
	
	
	// Object diagram png

	/**
	 * Renders and processes a form for evaluating XPath expressions. 
	 * This route method is intended to be used by application/model developers. To hide this route method override it without adding
	 * {@link RouteMethod} annotation.
	 * @param context
	 * @param target
	 * @param referrerParameter
	 * @param referrerHeader
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(
			comment="Helper page for evaluation of XPath expressions.",
			action = "read",
			value = { RequestMethod.GET, RequestMethod.POST },
			path = "XPathEvaluator.html")
	public Object xPathEvaluator(
			@ContextParameter C context,
			@TargetParameter T target,						
			@QueryParameter("xpath") String xpath,
			@QueryParameter("type") String type) throws Exception {
	
		if (!(target instanceof CDOObject)) {
			return Action.NOT_FOUND;
		}
		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		Fragment content = htmlFactory.fragment();
		Fragment appConsumer = htmlFactory.fragment();
		content.content(appConsumer);
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, "XPath Evaluator", breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		// Object header
		Tag objectHeader = content.getFactory().tag(
				TagName.h3, 
				renderObjectHeader(context, target, appConsumer), 
				" - ", 
				// TODO - doc system article and link to the article.
				htmlFactory.link("https://commons.apache.org/proper/commons-jxpath/users-guide.html", "XPath").attribute("title", "Use ecore:eClassName() and ecore:ePackageNsURI() functions to compute EClass details"), 
				" Evaluator");
		content.content(objectHeader);				
		
		Form form = htmlFactory.form().action("XPathEvaluator.html").method(Method.post).style().margin().bottom("5px");
		
		TextArea xPathTextArea = htmlFactory.textArea().required().rows(10).name("xpath");
		if (xpath != null) {
			xPathTextArea.content(StringEscapeUtils.escapeHtml4(xpath));
		}
		FormGroup<?> xPathFormGroup = form.formGroup("XPath*", xPathTextArea, "XPath expression to evaluate");
		Input valueTypeRadio = htmlFactory.input(InputType.radio).name("type").value("value");
		form.radio("Value", valueTypeRadio, true);
		Input iteratorTypeRadio = htmlFactory.input(InputType.radio).name("type").value("iterator");
		form.radio("Iterator", iteratorTypeRadio, true);
		boolean isValue = type == null || "value".equals(type);
		(isValue ? valueTypeRadio : iteratorTypeRadio).attribute("checked", "true"); 	
		form.content(htmlFactory.tag(TagName.hr));
		form.button("Evaluate").type(Button.Type.SUBMIT).style(Style.PRIMARY);
		
		content.content(form);
		
		if (context.getMethod() == RequestMethod.POST) {
			try {
				JXPathContext jxPathContext = RenderUtil.newJXPathContext(context, (CDOObject) target);
				if (isValue) {
					Object value = jxPathContext.getValue(xpath);
					if (value == null) {
						content.content(htmlFactory.label(Style.SUCCESS, "No result")); 
					} else {
						if (value instanceof EObject) {
							EObject eObject = (EObject) value;
							Renderer<C, EObject> re = getRenderer(eObject);
							EClass eClass = eObject.eClass();
							Object resultClassDocIcon = renderDocumentationIcon(context, eClass, appConsumer, true);
							if (resultClassDocIcon == null) {
								resultClassDocIcon = "";
							}
							String header = "Result - " + (re == null ? this : re).renderNamedElementLabel(context, eClass) + resultClassDocIcon +" ("+eObject.getClass().getName()+")";
							Object footer = re == null ? null : re.renderLink(context, eObject, true);
							content.content(htmlFactory.panel(Style.SUCCESS, header, StringEscapeUtils.escapeHtml4(eObject.toString()), footer));
						} else {
							content.content(htmlFactory.panel(Style.SUCCESS, "Result - "+value.getClass().getName(), StringEscapeUtils.escapeHtml4(value.toString()), null));							
						}
					}
				} else {
					Table resultsTable = htmlFactory.table().bordered();
					Iterator<?> rit = jxPathContext.iterate(xpath);
					while (rit.hasNext()) {
						Object value = rit.next();
						if (value == null) {
							resultsTable.row(htmlFactory.label(Style.SUCCESS, "No result"), "", ""); 
						} else {
							if (value instanceof EObject) {
								EObject eObject = (EObject) value;
								Renderer<C, EObject> re = getRenderer(eObject);
								EClass eClass = eObject.eClass();
								Object resultClassDocIcon = renderDocumentationIcon(context, eClass, appConsumer, true);
								if (resultClassDocIcon == null) {
									resultClassDocIcon = "";
								}
								String typeInfo = String.valueOf((re == null ? this : re).renderNamedElementLabel(context, eClass)) + resultClassDocIcon +" ("+eObject.getClass().getName()+")";
								Object link = re == null ? "" : re.renderLink(context, eObject, true);
								resultsTable.row(typeInfo, StringEscapeUtils.escapeHtml4(eObject.toString()), link);
							} else {
								resultsTable.row(value.getClass().getName(), StringEscapeUtils.escapeHtml4(value.toString()), "");							
							}
						}
						
					}
					content.content(htmlFactory.panel(Style.SUCCESS, "Results", resultsTable, null));
				}
			} catch (Exception e) {
				xPathFormGroup.status(Status.ERROR);
				content.content(htmlFactory.label(Style.DANGER, "ERROR: "+e));
				e.printStackTrace();
			}
		}		
		
		return renderPage(context, target, "XPath Evaluator", content);				
	}
	
	/**
	 * Processes login. If isPost is true, checks that login and password are not blank and authenticates
	 * the user. If authentication is successful, redirects to the returnURL or to the authenticated principal home page.   
	 * @param context Context.
	 * @param returnURL URL to redirect to upon successful authentication. If null, this method redirects to the authenticated principal home.
	 * @param login Login.
	 * @param password Password
	 * @return null if authentication was successful and a redirect has been sent to the returnURL or the authenticated principal home page..
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Form processLogin(C context, String returnURL, String login, String password) throws Exception {	
		List<String> errorMessages = new ArrayList<>();
		boolean invalidLogin = false;
		boolean invalidPassword = false;
		if (context.getMethod() == RequestMethod.POST) {
			if (CoreUtil.isBlank(login)) {
				errorMessages.add(getResourceString(context, "blankLogin"));
				invalidLogin = true;
			}
			if (CoreUtil.isBlank(password)) {
				errorMessages.add(getResourceString(context, "blankPassword"));
				invalidPassword = true;
			}
			if (errorMessages.isEmpty()) {
				List<Principal> authenticatedPrincipals = ((CDOViewContext<?, LoginPasswordCredentials>) context).authenticate(new LoginPasswordCredentials() {
					
					@Override
					public String getPassword() {
						return password;
					}
					
					@Override
					public String getLogin() {				
						return login;
					}
				});
				if (authenticatedPrincipals.isEmpty()) {
					errorMessages.add(getResourceString(context, "invalidLoginPasswordCombination"));
					invalidLogin = true;
					invalidPassword = true;
				} else {
					String principalHome = context.getObjectPath(authenticatedPrincipals.get(0))+"/home.html";
					context.getResponse().sendRedirect(CoreUtil.isBlank(returnURL) ? principalHome : returnURL);
					return null;
				}
			}			
		}
				
		HTMLFactory htmlFactory = getHTMLFactory(context);
		
		Form loginForm = htmlFactory.form().method(Method.post); // Action

		if (!errorMessages.isEmpty()) {
			ListGroup errorLg = htmlFactory.listGroup();
			loginForm.content(errorLg);
			for (String em: errorMessages) {
				errorLg.item(em, Style.DANGER);
			}
		}		
		
		Input loginInput = InputType.text.create().required().name("login").placeholder(getResourceString(context, "loginHint"));
		if (login != null) {
			loginInput.value(login);
		}
		FormInputGroup lfig = loginForm.formInputGroup(getResourceString(context, "login"), loginInput, getResourceString(context, "loginHint")).leftAddOn(htmlFactory.fontAwesome().webApplication(WebApplication.user));
		if (invalidLogin) {
			lfig.status(Status.ERROR);
		}
		
		Input passwordInput = InputType.password.create().required().name("password").placeholder(getResourceString(context, "passwordHint"));
		if (password != null) {
			passwordInput.value(password);
		}
		FormInputGroup pfig = loginForm.formInputGroup(getResourceString(context, "password"), passwordInput, getResourceString(context, "passwordHint")).leftAddOn(htmlFactory.fontAwesome().webApplication(WebApplication.key));
		if (invalidPassword) {
			pfig.status(Status.ERROR);
		}
		
		if (returnURL != null) {
			loginForm.content(htmlFactory.input(InputType.hidden).name("url").value(returnURL));
		}	
		
		loginForm.button(getResourceString(context, "logIn")).type(Button.Type.SUBMIT).style(Style.PRIMARY);
		return loginForm;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment="Invalidates session")
	public Object getLogoutHtml(@ContextParameter C context, @HeaderParameter(REFERRER_HEADER) String referrer) throws Exception {
		context.getRequest().getSession().invalidate();
		if (referrer == null) {
			return "Log out successful";
		}
		context.getResponse().sendRedirect(context.getRequest().getContextPath()+"/index.html");
		return Action.NOP;
	}
	
	/**
	 * @return
	 * @throws Exception
	 */
	@RouteMethod(comment="Exports the current object to XMI")
	public void getExportXml(@ContextParameter C context, @TargetParameter T target) throws Exception {
		if (target instanceof CDOObject) {
			ResourceSet resourceSet = new ResourceSetImpl();
			CDOObject cdoTarget = (CDOObject) target;
			CDOView view = cdoTarget.cdoView();
			Set<CDOObject> toLock = Collections.singleton(cdoTarget);
			view.lockObjects(toLock, LockType.READ, TimeUnit.MINUTES.toMillis(1), true);
			try {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(org.eclipse.emf.ecore.resource.Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());			
				String targetID = CDOIDCodec.INSTANCE.encode(context, cdoTarget.cdoID());
				URI sourceURI = URI.createFileURI(File.createTempFile(targetID+"-export-", ".xml").getAbsolutePath());
				org.eclipse.emf.ecore.resource.Resource resource = resourceSet.createResource(sourceURI);
				resource.getContents().add(EcoreUtil.copy(target));	
				HttpServletResponse response = context.getResponse();
				response.setContentType("text/xml");
				response.setHeader("Content-Disposition", "attachment; filename="+target.eClass().getName()+"-"+targetID+"-"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+".xml");
				resource.save(response.getOutputStream(), null);
			} finally {
				view.unlockObjects(toLock, LockType.READ, true);
			}
		}
	}

	// --- Web Operations ---

	@SuppressWarnings("unchecked")
	protected List<? extends Target> getTargets(HttpServletRequestContext context) throws Exception {
		List<Target> ret = new ArrayList<>(super.getTargets(context));
		Object target = context.getTarget();
		if (target instanceof EObject) {
			for (EOperation eOperation: ((EObject) target).eClass().getEAllOperations()) {
				Map<String, Object> webOperationAnnotation = (Map<String, Object>) getYamlRenderAnnotation((C) context, eOperation, RenderAnnotation.WEB_OPERATION);
				if (webOperationAnnotation != null) {
					EOperationTarget<C, T> eOperationTarget = new EOperationTarget<C,T>((C) context, this, eOperation, webOperationAnnotation);
					if (context.authorize(context.getTarget(), eOperationTarget.getAction(), eOperationTarget.getQualifier(), null)) {
						ret.add(eOperationTarget);
					}
				}
			}
		}		
		
		ret.addAll(getActions((C) context, (T) context.getTarget()));
		
		return ret;
	}	
	
	/**
	 * Binds EParameter to a value from the context/request. This implementation binds according to the {@link RenderAnnotation}.BIND specification.
	 * @param context
	 * @param pathParameters
	 * @param eParameter
	 * @param bindingSpec
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected EParameterBinding bindEParameter(C context, Map<String, String> pathParameters, EParameter eParameter, Object bindingSpec) throws Exception {		
		Class<?> parameterType = eParameter.isMany() ? EList.class : eParameter.getEType().getInstanceClass();
		if (bindingSpec == null) {
			bindingSpec = "form";
		}
		HttpServletRequest request = context.getRequest();
		String contentType = request.getContentType();
		boolean isMultiPart = context.getMethod() == RequestMethod.POST && contentType != null && contentType.startsWith(Form.EncType.multipart.literal+";");
		if (isMultiPart) {
			String multipartConfigElementKey = "org.eclipse.jetty.multipartConfig";
			if (request.getAttribute(multipartConfigElementKey) == null) {
				request.setAttribute(multipartConfigElementKey, new MultipartConfigElement((String) null));
			};	
		}
		JSONObject jsonData = null;
		if (CONTENT_TYPE_APPLICATION_JSON.equals(request.getContentType())) {
			// Cache in request to avoid multiple parsing attempts.
			jsonData = (JSONObject) request.getAttribute(JSON_DATA_REQUEST_ATTRIBUTE_KEY);
			if (jsonData == null) {
				try (InputStream in = request.getInputStream()) {
					jsonData = new JSONObject(new JSONTokener(in));
				}
				request.setAttribute(JSON_DATA_REQUEST_ATTRIBUTE_KEY, jsonData);
			}
		}
		
		if (bindingSpec instanceof String) {
			switch ((String) bindingSpec) {
			case "body":
				if (WebMethodCommand.JSON_CONTENT_TYPE.equals(contentType)) {
					if (parameterType == JSONArray.class) {
						return new EParameterBinding(eParameter, new JSONArray(new JSONTokener(request.getReader())));
					}
					
					if (parameterType == JSONObject.class) {
						return new EParameterBinding(eParameter, new JSONObject(new JSONTokener(request.getReader())));
					}			
				}
				
				return new EParameterBinding(eParameter, context.convert(request.getInputStream(), parameterType));
			case "cookie":
			case "header":
			case "form":
			case "part":
			case "path":
			case "query":				
				bindingSpec = Collections.singletonMap((String) bindingSpec, eParameter.getName()); 
				break;
			case "null":
				return null;
			case "service":
				bindingSpec = Collections.singletonMap((String) bindingSpec, null); 
				break;				
			default:
				throw new IllegalArgumentException("Unsupported single-value parameter binding: "+bindingSpec);
			}
		} 
		
		if (bindingSpec instanceof Map) {
			for (Entry<String, Object> be: ((Map<String, Object>) bindingSpec).entrySet()) {
				switch (be.getKey()) {
				case "cookie":
					BasicEList<Object> cookieList = ECollections.newBasicEList();
					for (Cookie cookie: request.getCookies()) {
						if (be.getValue().equals(cookie.getName())) {
							if (parameterType.isAssignableFrom(Cookie.class)) {
								if (eParameter.isMany()) {
									cookieList.add(cookie);									
								} else {
									return new EParameterBinding(eParameter, cookie);
								}
							}
						} else {
							if (parameterType.isAssignableFrom(Cookie.class)) {
								if (eParameter.isMany()) {
									cookieList.add(parseTypedElementValue((C) context, eParameter, cookie.getValue()));									
								} else {
									return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, cookie.getValue()));
								}
							}							
						}
					}
					return new EParameterBinding(eParameter, cookieList);
				case "expression":
					Object target = context.getTarget();
					if (target instanceof CDOObject) {
						JXPathContext jxPathContext = RenderUtil.newJXPathContext(context, (CDOObject) target);
						if (eParameter.isMany()) {
							BasicEList<Object> values = ECollections.newBasicEList();							
							Iterator<?> cit = jxPathContext.iterate((String) be.getValue());
							while (cit.hasNext()) {
								Object value = cit.next();
								if (!(value instanceof CDOObject) || context.authorize(value, StandardAction.read, null, null)) {
									values.add(value);
								}
							}
							return new EParameterBinding(eParameter, values);
						}
						return new EParameterBinding(eParameter, jxPathContext.getValue((String) be.getValue(), parameterType)); 
					}
					return null;
				case "extension":
					Map<String,String> extensionConfig = (Map<String,String>) be.getValue();
					BasicEList<Object> extensions = ECollections.newBasicEList();												
					for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor(extensionConfig.get("point"))) {
						if (extensionConfig.get("configuration-element").equals(ce.getName())) {	
							String classAttribute = extensionConfig.get("class-attribute");
							Object ev = ce.createExecutableExtension(classAttribute == null ? "class" : classAttribute);
							CoreUtil.injectProperties(ce, ev);
							if (eParameter.isMany()) {
								extensions.add(ev);
							} else {
								return new EParameterBinding(eParameter, ev);
							}
						}					
					}
					return new EParameterBinding(eParameter, extensions);
				case "header":
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();
						for (String str: Collections.list(request.getHeaders((String) be.getValue()))) {
							ret.add(parseTypedElementValue((C) context, eParameter, str));
						}
						return new EParameterBinding(eParameter, ret);
					}
					return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, request.getHeader((String) be.getValue())));					
				case "part":
					if (isMultiPart) {
						BasicEList<Object> partValues = ECollections.newBasicEList();
						String partName = (String) be.getValue();
						for (Part part: request.getParts()) {
							if (partName.equals(part.getName())) {
								if (parameterType.isAssignableFrom(Part.class)) {
									partValues.add(part);
								} else if (parameterType.isAssignableFrom(InputStream.class)) {
									partValues.add(part.getInputStream());
								} else {
									Object val = context.convert(part, parameterType);
									if (val == null) {
										val = context.convert(part.getInputStream(), parameterType);
									}
									if (val == null) {
										throw new IllegalArgumentException("Neither "+Part.class+" or "+InputStream.class+" can be conveted to parameter type "+parameterType);
									}									
									partValues.add(val);
								}
							}
						}
						return new EParameterBinding(eParameter, eParameter.isMany() ? partValues : partValues.isEmpty() ? null : partValues.get(0));
					}
					return new EParameterBinding(eParameter, null);
				case "part-file-name":
					if (isMultiPart) {
						BasicEList<Object> partFileNames = ECollections.newBasicEList();
						String partName = (String) be.getValue();
						for (Part part: request.getParts()) {
							if (partName.equals(part.getName())) {
								partFileNames.add(part.getSubmittedFileName());
							}
						}
						return new EParameterBinding(eParameter, eParameter.isMany() ? partFileNames : partFileNames.isEmpty() ? null : partFileNames.get(0));
					}
					return new EParameterBinding(eParameter, null);
				case "path":
					return new EParameterBinding(eParameter, pathParameters.get(be.getValue()));
				case "form":
					if (context.getMethod() != RequestMethod.POST) {
						return new EParameterBinding(eParameter, null);
					}
					if (isMultiPart) {
						BasicEList<Object> parameterValues = ECollections.newBasicEList();
						String partName = (String) be.getValue();
						for (Part part: request.getParts()) {
							if (partName.equals(part.getName())) {
								parameterValues.add(parseTypedElementValue((C) context, eParameter, CoreUtil.stringify(part.getInputStream())));
							}
						}
						return new EParameterBinding(eParameter, eParameter.isMany() ? parameterValues : parameterValues.isEmpty() ? null : parameterValues.get(0));
					}
				case "query":
					if (jsonData == null) {
						if (eParameter.isMany()) {
							BasicEList<Object> ret = ECollections.newBasicEList();
							for (String str: request.getParameterValues((String) be.getValue())) {
								ret.add(parseTypedElementValue((C) context, eParameter, str));
							}
							return new EParameterBinding(eParameter, ret);
						}
						String parameterValue = request.getParameter((String) be.getValue());
						return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, parameterValue));
					}
					if (jsonData.has((String) be.getValue())) {
						if (eParameter.isMany()) {
							BasicEList<Object> ret = ECollections.newBasicEList();
							JSONArray var = jsonData.getJSONArray((String) be.getValue());
							for (int i=0; i < var.length(); ++i) {
								ret.add(parseTypedElementValue((C) context, eParameter, var.get(i)));
							}
							return new EParameterBinding(eParameter, ret);
						}
						return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, jsonData.get((String) be.getValue())));						
					}					
					return new EParameterBinding(eParameter, null);					
				case "service":
					Collection<ServiceReference<Object>> srs = bundleContext.getServiceReferences((Class<Object>) parameterType, (String) be.getValue());
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();
						for (ServiceReference<Object> sr: srs) {
							ret.add(bundleContext.getService(sr));
						}
						return new EParameterBinding(eParameter, ret) {
							
							public void close() throws Exception {
								for (ServiceReference<Object> sr: srs) {
									bundleContext.ungetService(sr);
								}
							};
							
						};
					}
					ServiceReference<Object> sr = srs.isEmpty() ? null : srs.iterator().next();
					return new EParameterBinding(eParameter, sr == null ? null : bundleContext.getService(sr)) {
						
						@Override
						public void close() throws Exception {
							if (sr != null) {
								bundleContext.ungetService(sr);
							}
						}
						
					};					
				case "value":
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();						
						if (be.getValue() instanceof Collection) {
							for (String bev: (Collection<String>) be.getValue()) {
								 ret.add(parseTypedElementValue((C) context, eParameter, bev));
							}
						} else {
							 ret.add(parseTypedElementValue((C) context, eParameter, (String) be.getValue()));
						}
						return new EParameterBinding(eParameter, ret);
					}
					return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, (String) be.getValue()));
				default:
					throw new IllegalArgumentException("Unsupported parameter binding: "+be.getKey());
				}				
			}			
		}
		throw new IllegalArgumentException("Unsupported parameter binding type: "+bindingSpec);
	}
	
	/**
	 * Executes EOperation. This method is invoked by {@link EOperationTarget}
	 * @param context
	 * @param eOperation
	 * @param pathParameters
	 * @param arguments
	 * @param spec Web operation specification from {@link RenderAnnotation}.WEB_OPERATION annotation.
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Object executeEOperation(C context, EOperationTarget<C, T> eOperationTarget, Map<String, String> pathParameters, Object[] arguments) throws Exception {
		EOperation eOperation = eOperationTarget.getEOperation();				
		@SuppressWarnings("unchecked")
		T target = (T) context.getTarget();
		
		String methodName = (String) eOperationTarget.getSpec().get("method");

		HttpServletRequest request = context.getRequest();
		String contextObjectID = request.getParameter("context-object");
		EObject contextObject = target;
		String featureName = (String) eOperationTarget.getSpec().get("feature");
		if (featureName == null) {
			featureName = (String) eOperationTarget.getSpec().get("feature-value");
			if (featureName != null) {
				if (contextObjectID != null && context instanceof CDOViewContext) {
					contextObject = ((CDOViewContext<?, ?>) context).getView().getObject(CDOIDCodec.INSTANCE.decode(context, contextObjectID));
					featureName = null;
					request.setAttribute(LEFT_PANEL_GUARD_KEY, false);
				}
			}
		}
		
		EStructuralFeature operationFeature = featureName == null ? null : target.eClass().getEStructuralFeature(featureName);
		
		if (operationFeature != null) {
			if (getTypedElementLocation(context, operationFeature) == TypedElementLocation.item) {
				operationFeature = null;
			}
		}
		
		String contentType = request.getContentType();
		boolean isMultiPart = context.getMethod() == RequestMethod.POST && contentType != null && contentType.startsWith(Form.EncType.multipart.literal+";");
		String originalReferrer = request.getParameter(REFERRER_KEY);
		if (isMultiPart) {
			String multipartConfigElementKey = "org.eclipse.jetty.multipartConfig";
			if (request.getAttribute(multipartConfigElementKey) == null) {
				request.setAttribute(multipartConfigElementKey, new MultipartConfigElement((String) null));
			};	
			
			for (Part part: request.getParts()) {
				if (REFERRER_KEY.equals(part.getName())) {
					originalReferrer = CoreUtil.stringify(part.getInputStream());
				}
			}
		}
		if (originalReferrer == null) {
			originalReferrer = request.getHeader(REFERRER_HEADER);
		}
		
		// Location to load in the page when eoperation dialog closes.
		String location = originalReferrer;
		// TODO - context feature injection
//		if (referrer == null) {
//			referrer = referrerHeader;
//		}
		if (location == null) {
			location = context.getObjectPath(target)+"/"+INDEX_HTML;
		}
//		int referrerQueryStart = referrer.indexOf("?");
//		if (referrerQueryStart == -1) {
//			referrer +=  "?";
//		} else {
//			StringBuilder queryBuilder = new StringBuilder();
//			for (String qe: referrer.substring(referrerQueryStart+1).split("&")) {
//				if (!qe.startsWith("context-feature=")) {
//					queryBuilder.append(qe).append("&");
//				}
//			}
//			referrer = referrer.substring(0, referrerQueryStart+1)+queryBuilder;
//		}
//		referrer += "context-feature="+URLEncoder.encode(reference, StandardCharsets.UTF_8.name());
		
		HttpServletResponse response = context.getResponse();
		if (methodName == null) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			
			String title = StringEscapeUtils.escapeHtml4(nameToLabel(target.eClass().getName())+" :: "+nameToLabel(eOperation.getName()));
			Fragment content = htmlFactory.fragment();
			Fragment appConsumer = htmlFactory.fragment();
			content.content(appConsumer);
			
			if (context.getMethod() == RequestMethod.GET) {
				if (eOperationTarget.hasFormParameters()) {					
					// Render form
					Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
					String inputFormStr = "Input form"; // TODO - resource string
						
					String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(inputFormStr).style().color().bootstrapColor(Color.INFO);
					if (operationFeature == null) {
						getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
					} else {
						renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
					}
					if (!breadCrumbs.isEmpty()) {
						content.content(breadCrumbs);
					}
							
					Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
					content.content(objectHeader);							
					
					content.content(htmlFactory.tag(TagName.h4, inputFormStr).style().color().bootstrapColor(Color.INFO));
					
					boolean horizontalForm = !"false".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.HORIZONTAL_FORM));
					boolean noValidate = "true".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.NO_VALIDATE));
					Form inputForm = renderInputForm(context, target, getParameterValues(context, target, eOperation), Collections.emptyList(), Collections.emptyMap(), horizontalForm, null, appConsumer)
						.novalidate(noValidate)
						.action(request.getRequestURL())
						.method(Method.post);
					
					for (EParameter eParameter: eOperation.getEParameters()) {
						String queryParameterName = eOperationTarget.getQueryParameterName(eParameter);
						if (queryParameterName != null) {
							String queryParameterValue = request.getParameter(queryParameterName);
							if (queryParameterValue != null) {
								Input queryParameterInput = htmlFactory.input(InputType.hidden)
										.name(queryParameterName)
										.value(queryParameterValue);
								inputForm.content(queryParameterInput);
							}
						}
					}														
					
					if (eOperationTarget.hasPartParameters()) {
						inputForm.enctype(EncType.multipart);
					}
					
					if (originalReferrer != null) {
						inputForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
					}		
					if (contextObjectID != null) {
						inputForm.content(htmlFactory.input(InputType.hidden).name("context-object").value(contextObjectID)); // encode?						
					}					
					
					configureForm(inputForm, horizontalForm, ModalType.NONE);
					Tag buttonBar = htmlFactory.div().style().text().align().right();
					
					Object buttonContent = eOperationTarget.getRole() == Role.operation ? renderNamedElementIconAndLabel(context, eOperation) : htmlFactory.fragment(renderSaveIcon(context).style().margin().right("5px"), getResourceString(context, "save"));
					Button executeButton = htmlFactory.button(buttonContent).style(Style.PRIMARY);
					executeButton.type(org.nasdanika.html.Button.Type.SUBMIT);
					buttonBar.content(executeButton.style().margin().right("5px"));
					
					buttonBar.content(renderCancelButton(context, target));
					inputForm.content(buttonBar);
					
					content.content(inputForm);					
				} else {
					// Validate, invoke, render result
					EList<EParameterBinding> bindings = ECollections.newBasicEList();
					for (EParameter eParameter: eOperation.getEParameters()) {
						bindings.add(eOperationTarget.bind(context, pathParameters, eParameter));
					}
					Map<String, Object> args = new HashMap<>();
					for (EParameterBinding binding: bindings) {
						args.put(binding.getEParameter().getName(), binding.getValue());
					}
					Diagnostic diagnostic = validate(context, (T) context.getTarget(), eOperation, args);
					if (diagnostic.getSeverity() == Diagnostic.ERROR) {
						ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
							
							@Override
							protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
								return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? eOperation : namedElement), key, true);
							}
							
						};
						
						for (Diagnostic dc: diagnostic.getChildren()) {
							diagnosticConsumer.accept(dc);
						}
						
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						String invalidInputStr = "Invalid input"; // TODO - resource string
						String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(invalidInputStr).style().color().bootstrapColor(Color.DANGER);
						if (operationFeature == null) {
							getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
						} else {
							renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
						}						
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
								
						Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
						content.content(objectHeader);							
						
						content.content(htmlFactory.tag(TagName.h4, invalidInputStr).style().color().bootstrapColor(Color.DANGER)); 
						ListGroup errorList = htmlFactory.listGroup();
						content.content(errorList);
						for (ValidationResult vr: diagnosticConsumer.getValidationResults()) {
							errorList.item(vr.message, vr.status.toStyle());			
						}
						
						for (Entry<ENamedElement, List<ValidationResult>> fe: diagnosticConsumer.getNamedElementValidationResults().entrySet()) {
							for (ValidationResult nevr: fe.getValue()) {
								Object nameLabel = renderNamedElementIconAndLabel(context, fe.getKey());
								errorList.item(htmlFactory.label(nevr.status.toStyle(), nameLabel) + " " + nevr.message, nevr.status.toStyle());											
							}
						}			
					} else {
						try {
							Object result = eOperationTarget.invoke(context, bindings);	
							
							if (result == null && originalReferrer != null) {
								response.sendRedirect(originalReferrer);
								return Action.NOP;
							}
							
							if (result instanceof Diagnostic && ((Diagnostic) result).getSeverity() == Diagnostic.ERROR) {
								ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
									
									@Override
									protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
										return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? eOperation : namedElement), key, true);
									}
									
								};
								
								if (((Diagnostic) result).getChildren().isEmpty()) {
									diagnosticConsumer.accept((Diagnostic) result); // Single diagnostic
								} else {
									for (Diagnostic dc: ((Diagnostic) result).getChildren()) { // Multi-diagnostic
										diagnosticConsumer.accept(dc);
									}
								}
								
								Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
								String invalidInputStr = "Invalid input"; // TODO - resource string
								String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(invalidInputStr).style().color().bootstrapColor(Color.DANGER);
								if (operationFeature == null) {
									getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
								} else {
									renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
								}						
								if (!breadCrumbs.isEmpty()) {
									content.content(breadCrumbs);
								}
										
								Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
								content.content(objectHeader);							
								
								content.content(htmlFactory.tag(TagName.h4, invalidInputStr).style().color().bootstrapColor(Color.DANGER)); 
								ListGroup errorList = htmlFactory.listGroup();
								content.content(errorList);
								for (ValidationResult vr: diagnosticConsumer.getValidationResults()) {
									errorList.item(vr.message, vr.status.toStyle());			
								}
								
								for (Entry<ENamedElement, List<ValidationResult>> fe: diagnosticConsumer.getNamedElementValidationResults().entrySet()) {
									for (ValidationResult nevr: fe.getValue()) {
										Object nameLabel = renderNamedElementIconAndLabel(context, fe.getKey());
										errorList.item(htmlFactory.label(nevr.status.toStyle(), nameLabel) + " " + nevr.message, nevr.status.toStyle());											
									}
								}			
							} else {
								// Factory operation returning constructed object - add/set feature, redirect to the referrer or object home.
								if (eOperationTarget.getRole() == Role.factory && featureName != null) {
									EStructuralFeature opFeature = target.eClass().getEStructuralFeature(featureName);
									if (opFeature != null && opFeature.getEType().getInstanceClass().isInstance(result)) {
										if (opFeature.isMany()) {
											((Collection<Object>) target.eGet(opFeature)).add(result);
										} else {
											target.eSet(opFeature, result);
										}
										response.sendRedirect(location);
										return Action.NOP;
									}
								}
								
								// Breadcrumbs
								Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
								String resultStr = "Result"; // TODO - resource string
								String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(resultStr).style().color().bootstrapColor(Color.SUCCESS);
								if (operationFeature == null) {
									getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
								} else {
									renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
								}						
								if (!breadCrumbs.isEmpty()) {
									content.content(breadCrumbs);
								}
										
								Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
								content.content(objectHeader);							
								
								if (result == null) {
									content.content(htmlFactory.tag(TagName.h4, resultStr, ": ", renderTrue(context)).style().color().bootstrapColor(Color.SUCCESS));
								} else {
									content.content(htmlFactory.tag(TagName.h4, resultStr).style().color().bootstrapColor(Color.SUCCESS));
									content.content(renderTypedElementView(context, target, eOperation, result, false, null, null, null, appConsumer)); // TODO - render Diagnostic as a UL					
								}
							}
						} catch (Exception e) {
							// Breadcrumbs
							Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
							String errorStr = "Error"; // TODO - resource string
							String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(errorStr).style().color().bootstrapColor(Color.DANGER);
							if (operationFeature == null) {
								getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
							} else {
								renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
							}						
							if (!breadCrumbs.isEmpty()) {
								content.content(breadCrumbs);
							}
									
							Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
							content.content(objectHeader);							
							
							Throwable rootCause = e;
							while (rootCause.getCause() != null) {
								rootCause = rootCause.getCause();
							}
							
							content.content(htmlFactory.tag(TagName.h4, errorStr, ": ", rootCause.toString()).style().color().bootstrapColor(Color.DANGER));
							StringWriter sw = new StringWriter();
							try (PrintWriter pw = new PrintWriter(sw)) {
								rootCause.printStackTrace(pw);
							}
							content.content(htmlFactory.div(sw.toString()).style().whiteSpace().pre().style().color().bootstrapColor(Color.DANGER));
							rootCause.printStackTrace(); // To console for troubleshooting.
						}
					}
				}				
			} else {
				boolean isJSON = CONTENT_TYPE_APPLICATION_JSON.equals(request.getContentType());
				
				// POST - validate, re-render form if failure, invoke and render result or error if validation passed.
				EList<EParameterBinding> bindings = ECollections.newBasicEList();
				for (EParameter eParameter: eOperation.getEParameters()) {
					bindings.add(eOperationTarget.bind(context, pathParameters, eParameter));
				}
				Map<String, Object> args = new HashMap<>();
				for (EParameterBinding binding: bindings) {
					args.put(binding.getEParameter().getName(), binding.getValue());
				}
				@SuppressWarnings("unchecked")
				Diagnostic diagnostic = validate(context, (T) context.getTarget(), eOperation, args);
				if (diagnostic.getSeverity() == Diagnostic.ERROR) {
					ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
						
						@Override
						protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
							return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? eOperation : namedElement), key, true);
						}
						
					};
					
					for (Diagnostic dc: diagnostic.getChildren()) {
						diagnosticConsumer.accept(dc);
					}
					
					if (isJSON) {						
						JSONObject result = new JSONObject();
						result.put("validationResults", diagnosticConsumer.toJSON());						
						return result;
					}
					
					Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
					String invalidInputStr = "Invalid input"; // TODO - resource string
					String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(invalidInputStr).style().color().bootstrapColor(Color.DANGER);
					if (operationFeature == null) {
						getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
					} else {
						renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
					}						
					if (!breadCrumbs.isEmpty()) {
						content.content(breadCrumbs);
					}
							
					Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
					content.content(objectHeader);							
					
					content.content(htmlFactory.tag(TagName.h4, invalidInputStr).style().color().bootstrapColor(Color.DANGER)); 
					
					boolean horizontalForm = !"false".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.HORIZONTAL_FORM));
					boolean noValidate = "true".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.NO_VALIDATE));
					Map<EParameter, Object> formParameters = new LinkedHashMap<EParameter, Object>();
					for (EParameter eParameter: eOperation.getEParameters()) {
						if (eOperationTarget.isFormParameter(eParameter)) {
							formParameters.put(eParameter, args.get(eParameter.getName()));
						}
					}
					Form inputForm = renderInputForm(context, target, formParameters, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getNamedElementValidationResults(), horizontalForm, null, appConsumer)
						.novalidate(noValidate)
						.action(request.getRequestURL())
						.method(Method.post);
					
					for (EParameter eParameter: eOperation.getEParameters()) {
						String queryParameterName = eOperationTarget.getQueryParameterName(eParameter);
						if (queryParameterName != null) {
							String queryParameterValue = request.getParameter(queryParameterName);
							if (queryParameterValue != null) {
								Input queryParameterInput = htmlFactory.input(InputType.hidden)
										.name(queryParameterName)
										.value(queryParameterValue);
								inputForm.content(queryParameterInput);
							}
						}
					}					
					
					if (eOperationTarget.hasPartParameters()) {
						inputForm.enctype(EncType.multipart);
					}
					
					if (originalReferrer != null) {
						inputForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
					}							
					if (contextObjectID != null) {
						inputForm.content(htmlFactory.input(InputType.hidden).name("context-object").value(contextObjectID)); // encode?						
					}					
					
					configureForm(inputForm, horizontalForm, ModalType.NONE);
					Tag buttonBar = htmlFactory.div().style().text().align().right();
					
					Object buttonContent = eOperationTarget.getRole() == Role.operation ? renderNamedElementIconAndLabel(context, eOperation) : htmlFactory.fragment(renderSaveIcon(context).style().margin().right("5px"), getResourceString(context, "save"));
					Button executeButton = htmlFactory.button(buttonContent).style(Style.PRIMARY);
					executeButton.type(org.nasdanika.html.Button.Type.SUBMIT);
					buttonBar.content(executeButton.style().margin().right("5px"));
					
					buttonBar.content(renderCancelButton(context, target));
					inputForm.content(buttonBar);
					
					content.content(inputForm);					
				} else {
					try {
						Object result = eOperationTarget.invoke(context, bindings);													
						if (result == null && originalReferrer != null) {
							if (isJSON) {
								JSONObject jsonResult = new JSONObject();
								jsonResult.put("location", location);
								return jsonResult;
							} 
							
							response.sendRedirect(originalReferrer);
							return Action.NOP;
						}
						
						if (result instanceof Diagnostic && ((Diagnostic) result).getSeverity() == Diagnostic.ERROR) {
							ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
								
								@Override
								protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
									return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? eOperation : namedElement), key, true);
								}
								
							};
							
							if (((Diagnostic) result).getChildren().isEmpty()) {
								diagnosticConsumer.accept((Diagnostic) result); // Single result
							} else {
								for (Diagnostic dc: ((Diagnostic) result).getChildren()) { // Multi-result
									diagnosticConsumer.accept(dc);
								}
							}
							
							if (isJSON) {						
								JSONObject jsonResult = new JSONObject();
								jsonResult.put("validationResults", diagnosticConsumer.toJSON());						
								return jsonResult;
							}
							
							Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
							String invalidInputStr = "Invalid input"; // TODO - resource string
							String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(invalidInputStr).style().color().bootstrapColor(Color.DANGER);
							if (operationFeature == null) {
								getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
							} else {
								renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
							}						
							if (!breadCrumbs.isEmpty()) {
								content.content(breadCrumbs);
							}
									
							Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
							content.content(objectHeader);							
							
							content.content(htmlFactory.tag(TagName.h4, invalidInputStr).style().color().bootstrapColor(Color.DANGER)); 
							
							boolean horizontalForm = !"false".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.HORIZONTAL_FORM));
							boolean noValidate = "true".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.NO_VALIDATE));
							Map<EParameter, Object> formParameters = new LinkedHashMap<EParameter, Object>();
							for (EParameter eParameter: eOperation.getEParameters()) {
								if (eOperationTarget.isFormParameter(eParameter)) {
									formParameters.put(eParameter, args.get(eParameter.getName()));
								}
							}
							Form inputForm = renderInputForm(context, target, formParameters, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getNamedElementValidationResults(), horizontalForm, null, appConsumer)
								.novalidate(noValidate)
								.action(request.getRequestURL())
								.method(Method.post);
							
							for (EParameter eParameter: eOperation.getEParameters()) {
								String queryParameterName = eOperationTarget.getQueryParameterName(eParameter);
								if (queryParameterName != null) {
									String queryParameterValue = request.getParameter(queryParameterName);
									if (queryParameterValue != null) {
										Input queryParameterInput = htmlFactory.input(InputType.hidden)
												.name(queryParameterName)
												.value(queryParameterValue);
										inputForm.content(queryParameterInput);
									}
								}
							}					
							
							if (eOperationTarget.hasPartParameters()) {
								inputForm.enctype(EncType.multipart);
							}
							
							if (originalReferrer != null) {
								inputForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
							}							
							if (contextObjectID != null) {
								inputForm.content(htmlFactory.input(InputType.hidden).name("context-object").value(contextObjectID)); // encode?						
							}					
							
							configureForm(inputForm, horizontalForm, ModalType.NONE);
							Tag buttonBar = htmlFactory.div().style().text().align().right();
							
							Object buttonContent = eOperationTarget.getRole() == Role.operation ? renderNamedElementIconAndLabel(context, eOperation) : htmlFactory.fragment(renderSaveIcon(context).style().margin().right("5px"), getResourceString(context, "save"));
							Button executeButton = htmlFactory.button(buttonContent).style(Style.PRIMARY);
							executeButton.type(org.nasdanika.html.Button.Type.SUBMIT);
							buttonBar.content(executeButton.style().margin().right("5px"));
							
							buttonBar.content(renderCancelButton(context, target));
							inputForm.content(buttonBar);
							
							content.content(inputForm);												
						} else {	
							// Factory operation returning constructed object - add/set feature, redirect to the referrer or object home.
							if (eOperationTarget.getRole() == Role.factory && featureName != null) {
								EStructuralFeature opFeature = target.eClass().getEStructuralFeature(featureName);
								if (opFeature != null && opFeature.getEType().getInstanceClass().isInstance(result)) {
									if (opFeature.isMany()) {
										((Collection<Object>) target.eGet(opFeature)).add(result);
									} else {
										target.eSet(opFeature, result);
									}
									if (isJSON) {
										JSONObject jsonResult = new JSONObject();
										jsonResult.put("location", location);
										return jsonResult;
									}  
									response.sendRedirect(location);
									return Action.NOP;
								}
							}
							
							String resultStr = "Result"; // TODO - resource string
							Fragment renderedResult = htmlFactory.fragment();						
							if (result == null) {
								renderedResult.content(htmlFactory.tag(TagName.h4, resultStr, ": ", renderTrue(context)).style().color().bootstrapColor(Color.SUCCESS));
							} else {
								renderedResult.content(htmlFactory.tag(TagName.h4, resultStr).style().color().bootstrapColor(Color.SUCCESS));
								renderedResult.content(renderTypedElementView(context, target, eOperation, result, false, null, null, null, appConsumer)); // TODO - render diagnostic as UL (in renderer)					
							}
							if (isJSON) {
								JSONObject jsonResult = new JSONObject();
								jsonResult.put("result", renderedResult);
								jsonResult.put("location", location);
								return jsonResult;
							}  
							
							// Breadcrumbs
							Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
							String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(resultStr).style().color().bootstrapColor(Color.SUCCESS);
							if (operationFeature == null) {
								getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
							} else {
								renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
							}						
							if (!breadCrumbs.isEmpty()) {
								content.content(breadCrumbs);
							}
									
							Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
							content.content(objectHeader);							
							
							content.content(renderedResult);
						}
					} catch (Exception e) {
						Throwable rootCause = e;
						while (rootCause.getCause() != null) {
							rootCause = rootCause.getCause();
						}
						
						StringWriter sw = new StringWriter();
						try (PrintWriter pw = new PrintWriter(sw)) {
							rootCause.printStackTrace(pw);
						}
						Tag renderedException = htmlFactory.div(sw.toString()).style().whiteSpace().pre().style().color().bootstrapColor(Color.DANGER);
						
						if (isJSON) {
							JSONObject jsonResult = new JSONObject();
							jsonResult.put("result", renderedException);
							jsonResult.put("location", location);
							return jsonResult;
						}												
						
						// Breadcrumbs
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						String errorStr = "Error"; // TODO - resource string
						String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(errorStr).style().color().bootstrapColor(Color.DANGER);
						if (operationFeature == null) {
							getRenderer(contextObject).renderObjectPath(context, contextObject, breadcrumbAction, breadCrumbs);
						} else {
							renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
						}						
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
								
						Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, appConsumer, true)); 
						content.content(objectHeader);							
						
						content.content(htmlFactory.tag(TagName.h4, errorStr).style().color().bootstrapColor(Color.DANGER));

						content.content(renderedException);						
						rootCause.printStackTrace();
					}
				}								
			}
						
			return renderPage(context, target, title, content);					
		}
		
		// API invocation - no UI rendering.
		
		// Validate and invoke		
		EList<EParameterBinding> bindings = ECollections.newBasicEList();
		for (EParameter eParameter: eOperation.getEParameters()) {
			bindings.add(eOperationTarget.bind(context, pathParameters, eParameter));
		}
		Map<String, Object> args = new HashMap<>();
		for (EParameterBinding binding: bindings) {
			args.put(binding.getEParameter().getName(), binding.getValue());
		}
		Diagnostic diagnostic = validate(context, (T) context.getTarget(), eOperation, args);
		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
				
				@Override
				protected String getResourceString(ENamedElement namedElement, String key) throws Exception {
					return Route.this.getResourceString(context, (ENamedElement) (namedElement == null ? eOperation : namedElement), key, true);
				}
				
			};
			
			for (Diagnostic dc: diagnostic.getChildren()) {
				diagnosticConsumer.accept(dc);
			}
			
			JSONArray msg = new JSONArray();
			for (ValidationResult vr: diagnosticConsumer.getValidationResults()) {
				JSONObject jvr = new JSONObject();
				msg.put(jvr);
				jvr.put("message", vr.message);
				jvr.put("status", vr.status.name());			
			}
			
			for (Entry<ENamedElement, List<ValidationResult>> nevre: diagnosticConsumer.getNamedElementValidationResults().entrySet()) {
				JSONObject nejvr = new JSONObject();
				nejvr.put("name", nevre.getKey().getName());
				msg.put(nejvr);
				JSONArray jDiagnostic = new JSONArray();
				nejvr.put("diagnostic", jDiagnostic);
				for (ValidationResult nevr: nevre.getValue()) {
					JSONObject jvr = new JSONObject();
					jDiagnostic.put(jvr);
					jvr.put("message", nevr.message);
					jvr.put("status", nevr.status.name());			
				}
			}
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, msg.toString());
			return Action.NOP;
		}
		
		Object result = eOperationTarget.invoke(context, bindings);
		// Factory operation returning constructed object - add/set feature.
		if (eOperationTarget.getRole() == Role.factory && featureName != null) {
			EStructuralFeature opFeature = target.eClass().getEStructuralFeature(featureName);
			if (opFeature != null && opFeature.getEType().getInstanceClass().isInstance(result)) {
				if (opFeature.isMany()) {
					((Collection<Object>) target.eGet(opFeature)).add(result);
				} else {
					target.eSet(opFeature, result);
				}
				return filterEOperationResult(context, eOperation, null);								
			}
		}
		
		return filterEOperationResult(context, eOperation, result);				
	}
		
	/**
	 * Override to replace eOperation result with something else if needed. 
	 * @param context
	 * @param eOperation
	 * @param result
	 * @return
	 * @throws Exception
	 */
	public Object filterEOperationResult(C context, EOperation eOperation, Object result) throws Exception {
		return result;
	}
	
}
