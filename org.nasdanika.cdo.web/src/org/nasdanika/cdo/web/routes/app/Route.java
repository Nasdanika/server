package org.nasdanika.cdo.web.routes.app;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.AuthorizationProvider.StandardAction;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Color;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
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
import org.nasdanika.html.Modal;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.TextArea;
import org.nasdanika.html.Theme;
import org.nasdanika.html.UIElement;
import org.nasdanika.web.Action;
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
	public Object getIndexHtml(
			@ContextParameter C context, 
			@TargetParameter T target) throws Exception {
		
		EClass targetEClass = target.eClass();
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
		Fragment content = getHTMLFactory(context).fragment();
		
		// Documentation modals
		Modal classDocModal = renderDocumentationModal(context, targetEClass);
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		Map<EStructuralFeature, Modal> featureDocModals = renderVisibleFeaturesDocModals(context, target);
		for (Modal fdm: featureDocModals.values()) {
			content.content(fdm);
		}
		
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
		Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, classDocModal));
		content.content(objectHeader);
		
		// view 
		if (!isViewItem(context, target)) {
			content.content(renderView(context, target, featureDocModals));
		}
		
		content.content(renderFeatureItemsContainer(context, target, featureDocModals));
		
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
	protected Object renderPage(C context, T obj, String title, Object content) throws Exception {
		Map<String, Object> env = createRenderPageEnvironment(context);

		env.put(PageTemplateTokens.TITLE.literal, title == null ? "" : title);
		
		Object head = renderHead(context, obj);
		env.put(PageTemplateTokens.HEAD.literal, head == null ? "" : head);

		Object header = renderHeader(context, obj);
		env.put(PageTemplateTokens.HEADER.literal, header == null ? "" : header);
				
		Object leftPanel = renderLeftPanel(context, obj);
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
			Tag leftPanelDiv = bodyDiv.getFactory().div(leftPanel);
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
		leftPanel.bootstrap().grid().col(2);
		content.bootstrap().grid().col(10);
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
			
			// Breadcrumbs
			Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
			renderObjectPath(context, target, renderNamedElementIconAndLabel(context, tsf)+" / "+getResourceString(context, "select", true), breadCrumbs);
			if (!breadCrumbs.isEmpty()) {
				content.content(breadCrumbs);
			}
			
			// Object header
			Modal classDocModal = renderDocumentationModal(context, target.eClass());
			if (classDocModal != null) {
				content.content(classDocModal);
			}
			
			Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, classDocModal));
			content.content(objectHeader);				
			
			boolean horizontalForm = !"false".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.HORIZONTAL_FORM));
			boolean noValidate = "true".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.NO_VALIDATE));
			Form editForm = renderFeatureEditForm(context, target, tsf, diagnosticConsumer.getNamedElementValidationResults().get(tsf), horizontalForm)
				.novalidate(noValidate)
				.action("select.html")				
				.method(Method.post);
			
			configureForm(editForm, horizontalForm);
			
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
	
	@SuppressWarnings("unchecked")
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "feature/{feature}/create/{epackage}/{eclass}",
			action = "create",
			qualifier = "{feature}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type = Type.WRITE), 
			comment="Renders a page for creating an object and adding it to a containment feature.")
	public Object createContainementFeatureElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter(REFERRER_HEADER) String referrerHeader,			
			@PathParameter("feature") String feature,
			@PathParameter("epackage") String epackage,
			@PathParameter("eclass") String eclass,
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {

		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature);
		if (tsf instanceof EReference && context instanceof CDOViewContext) {
			String ePackageNsURI = new String(Hex.decodeHex(epackage.toCharArray()));
			EPackage ePackage = ((CDOViewContext<CDOView, ?>) context).getView().getSession().getPackageRegistry().getEPackage(ePackageNsURI);
			if (ePackage != null) {
				EClassifier eClassifier = ePackage.getEClassifier(eclass.substring(0, eclass.length() - EXTENSION_HTML.length()));
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
						
						// Adding the new instance to the object graph for selectors to work. 
						if (tsf.isMany()) {
							((Collection<Object>) target.eGet(tsf)).add(instance);
						} else {
							target.eSet(tsf, instance);
						}					
						
						// Set for GET from query parameters and for POST from form inputs. Display validation results only for POST.
						boolean setSuccessful = renderer.setEditableFeatures(context, instance, diagnosticConsumer);
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
								referrer += "context-feature="+URLEncoder.encode(feature, "UTF-8");
								((HttpServletRequestContext) context).getResponse().sendRedirect(referrer);
								return Action.NOP;
							}
							
							return "Update successful";
						} 
						
						// Rollback transaction to remove the instance.
						if (context instanceof TransactionContext) {
							((TransactionContext) context).setRollbackOnly();
						}
	
						HTMLFactory htmlFactory = getHTMLFactory(context);
						String title = StringEscapeUtils.escapeHtml4(renderer.nameToLabel(eClass.getName()));
						Fragment content = htmlFactory.fragment();
						
						// Breadcrumbs
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						renderFeaturePath(context, target, tsf, renderer.getResourceString(context, "create", true) + " / " + renderNamedElementIconAndLabel(context, eClass), breadCrumbs);
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
						
						// Object header
						Modal classDocModal = renderer.renderDocumentationModal(context, eClass);
						if (classDocModal != null) {
							content.content(classDocModal);
						}
						
						Tag objectHeader = content.getFactory().tag(TagName.h3, renderer.renderObjectHeader(context, instance, classDocModal));
						content.content(objectHeader);
																
						boolean horizontalForm = !"false".equals(renderer.getRenderAnnotation(context, eClass, RenderAnnotation.HORIZONTAL_FORM));
						boolean noValidate = "true".equals(renderer.getRenderAnnotation(context, eClass, RenderAnnotation.NO_VALIDATE));
						Form editForm = renderer.renderEditForm(context, instance, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getNamedElementValidationResults(), horizontalForm)
							.novalidate(noValidate)
							.action(eclass)
							.method(Method.post);
						
						configureForm(editForm, horizontalForm);
						
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
						return renderPage(context, target, title, content);
					}
				}							
			}
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
		
		if (getTypedElementLocation(context, sf) == TypedElementLocation.item) {
			context.getResponse().sendRedirect(context.getObjectPath(target)+"/"+INDEX_HTML+"?context-feature="+URLEncoder.encode(feature, "UTF-8"));
			return Action.NOP;
		}
		
		EClass targetEClass = target.eClass();
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(targetEClass.getName()));
		Fragment content = getHTMLFactory(context).fragment();
		
		// Documentation modals
		Modal classDocModal = renderDocumentationModal(context, targetEClass);
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderFeaturePath(context, target, sf, null, breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
				
//		if (modelElement instanceof EClass) {
//			return RenderUtil.getRenderAnnotation((EClass) modelElement, key);
//		}
				
		// Headers
		Tag featureHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, sf));
		Modal fdm = renderDocumentationModal(context, sf);
		if (fdm != null) {
			content.content(fdm);
		}
		Tag featureDocIcon = renderDocumentationIcon(context, sf, fdm, true);
		if (featureDocIcon != null) {
			featureHeader.content(featureDocIcon);
		}

		content.content(featureHeader);
		
		Tag objectHeader = content.getFactory().tag(TagName.h4, renderObjectHeader(context, target, classDocModal));
		content.content(objectHeader);
		
		// view 
		content.content(renderTypedElementView(context, target, sf, target.eGet(sf), true, null, null));
		
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
			@PathParameter("element") String element,
			@TargetParameter T target) throws Exception {
		
		// TODO
		return "Edit "+feature+" "+element;		
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
		
		if (context.getMethod() == RequestMethod.POST) {
			boolean versionMatch = true;
			if (target instanceof CDOObject) {
				CDORevision revision = ((CDOObject) target).cdoRevision();
				if (revision != null && objectVersionParameter != null && revision.getVersion() != Integer.parseInt(objectVersionParameter)) {
					versionMatch = compareEditableFeatures(context, target, diagnosticConsumer);
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
		Fragment content = htmlFactory.fragment();
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, getResourceString(context, "edit", true), breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		// Object header
		Modal classDocModal = renderDocumentationModal(context, target.eClass());
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, classDocModal));
		content.content(objectHeader);				
		
		boolean horizontalForm = !"false".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.HORIZONTAL_FORM));
		boolean noValidate = "true".equals(getRenderAnnotation(context, targetEClass, RenderAnnotation.NO_VALIDATE));
		Form editForm = renderEditForm(context, target, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getNamedElementValidationResults(), horizontalForm)
			.novalidate(noValidate)
			.action("edit.html")
			.method(Method.post);
		
		configureForm(editForm, horizontalForm);
		
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
		
		EcoreUtil.delete(target, true);
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
			redirectURL += "context-feature="+URLEncoder.encode(feature, "UTF-8");
			
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
			redirectURL += "context-feature="+URLEncoder.encode(feature, "UTF-8");
			
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
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, "XPath Evaluator", breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		// Object header
		Modal classDocModal = renderDocumentationModal(context, target.eClass());
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		Tag objectHeader = content.getFactory().tag(
				TagName.h3, 
				renderObjectHeader(context, target, classDocModal), 
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
							Object resultClassDocIcon = renderDocumentationIcon(context, eClass, null, true);
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
								Object resultClassDocIcon = renderDocumentationIcon(context, eClass, null, true);
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
					String principalHome = context.getObjectPath(authenticatedPrincipals.get(0))+"/index.html";
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
		context.getResponse().sendRedirect(referrer);
		return Action.NOP;
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
					String action = (String) webOperationAnnotation.get("action");
					if (action == null) {
						action = AuthorizationProvider.StandardAction.execute.name();
					}
					String qualifier = (String) webOperationAnnotation.get("qualifier");
					if (qualifier == null) {
						qualifier = eOperation.getName();
					}					
					if (context.authorize(context.getTarget(), action, qualifier, null)) {
						Map<EParameter, Object> parameterBindings = new HashMap<>();
						for (EParameter eParameter: eOperation.getEParameters()) {
							Object bindingAnnotation = getYamlRenderAnnotation((C) context, eParameter, RenderAnnotation.BIND);
							if (bindingAnnotation != null) {
								parameterBindings.put(eParameter, bindingAnnotation);
							}
						}
						
						ret.add(new EOperationTarget<C,T>(this, eOperation, webOperationAnnotation, parameterBindings));
					}
				}
			}
		}		
		
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
		String contentType = context.getRequest().getContentType();
		boolean isMultiPart = context.getMethod() == RequestMethod.POST && contentType != null && contentType.startsWith(Form.EncType.multipart.literal+";");
		if (isMultiPart) {
			String multipartConfigElementKey = "org.eclipse.jetty.multipartConfig";
			if (context.getRequest().getAttribute(multipartConfigElementKey) == null) {
				context.getRequest().setAttribute(multipartConfigElementKey, new MultipartConfigElement((String) null));
			};	
		}
		if (bindingSpec instanceof String) {
			switch ((String) bindingSpec) {
			case "body":
				if (WebMethodCommand.JSON_CONTENT_TYPE.equals(contentType)) {
					if (parameterType == JSONArray.class) {
						return new EParameterBinding(eParameter, new JSONArray(new JSONTokener(context.getRequest().getReader())));
					}
					
					if (parameterType == JSONObject.class) {
						return new EParameterBinding(eParameter, new JSONObject(new JSONTokener(context.getRequest().getReader())));
					}			
				}
				
				return new EParameterBinding(eParameter, context.convert(context.getRequest().getInputStream(), parameterType));
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
					for (Cookie cookie: context.getRequest().getCookies()) {
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
						for (String str: Collections.list(context.getRequest().getHeaders((String) be.getValue()))) {
							ret.add(parseTypedElementValue((C) context, eParameter, str));
						}
						return new EParameterBinding(eParameter, ret);
					}
					return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, context.getRequest().getHeader((String) be.getValue())));					
				case "part":
					if (isMultiPart) {
						BasicEList<Object> partValues = ECollections.newBasicEList();
						String partName = (String) be.getValue();
						for (Part part: context.getRequest().getParts()) {
							if (partName.equals(part.getName())) {
								if (parameterType.isAssignableFrom(Part.class)) {
									partValues.add(part);
								} else if (parameterType.isAssignableFrom(InputStream.class)) {
									partValues.add(part.getInputStream());
								} else {
									Object val = context.convert(part.getInputStream(), parameterType);
									if (val == null) {
										throw new IllegalArgumentException("Parameter type "+parameterType+" is not assignable from "+Part.class);
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
						for (Part part: context.getRequest().getParts()) {
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
						for (Part part: context.getRequest().getParts()) {
							if (partName.equals(part.getName())) {
								parameterValues.add(parseTypedElementValue((C) context, eParameter, CoreUtil.stringify(part.getInputStream())));
							}
						}
						return new EParameterBinding(eParameter, eParameter.isMany() ? parameterValues : parameterValues.isEmpty() ? null : parameterValues.get(0));
					}
				case "query":
					if (eParameter.isMany()) {
						BasicEList<Object> ret = ECollections.newBasicEList();
						for (String str: context.getRequest().getParameterValues((String) be.getValue())) {
							ret.add(parseTypedElementValue((C) context, eParameter, str));
						}
						return new EParameterBinding(eParameter, ret);
					}
					return new EParameterBinding(eParameter, parseTypedElementValue((C) context, eParameter, context.getRequest().getParameter((String) be.getValue())));
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
	protected Object executeEOperation(C context, EOperationTarget<C, T> eOperationTarget, Map<String, String> pathParameters, Object[] arguments) throws Exception {
		EOperation eOperation = eOperationTarget.getEOperation();				
		@SuppressWarnings("unchecked")
		T target = (T) context.getTarget();
		
		String methodName = (String) eOperationTarget.getSpec().get("method");
		String featureName = (String) eOperationTarget.getSpec().get("feature");
		if (featureName == null) {
			featureName = (String) eOperationTarget.getSpec().get("feature-value");
		}
		EStructuralFeature operationFeature = featureName == null ? null : target.eClass().getEStructuralFeature(featureName);
		
		String contentType = context.getRequest().getContentType();
		boolean isMultiPart = context.getMethod() == RequestMethod.POST && contentType != null && contentType.startsWith(Form.EncType.multipart.literal+";");
		String originalReferrer = context.getRequest().getParameter(REFERRER_KEY);
		if (isMultiPart) {
			for (Part part: context.getRequest().getParts()) {
				if (REFERRER_KEY.equals(part.getName())) {
					originalReferrer = CoreUtil.stringify(part.getInputStream());
				}
			}
		}
		if (originalReferrer == null) {
			originalReferrer = context.getRequest().getHeader(REFERRER_HEADER);
		}
		
		if (methodName == null) {
			HTMLFactory htmlFactory = getHTMLFactory(context);
			
			String title = StringEscapeUtils.escapeHtml4(nameToLabel(target.eClass().getName())+" :: "+nameToLabel(eOperation.getName()));
			Fragment content = htmlFactory.fragment();
			
			Modal eOperationDocModal = renderDocumentationModal(context, eOperation);
			if (eOperationDocModal != null) {
				content.content(eOperationDocModal);
			}
			
			if (context.getMethod() == RequestMethod.GET) {
				if (eOperationTarget.hasFormParameters()) {					
					// Render form
					Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
					String inputFormStr = "Input form"; // TODO - resource string
						
					String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(inputFormStr).style().color().bootstrapColor(Color.INFO);
					if (operationFeature == null) {
						renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
					} else {
						renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
					}
					if (!breadCrumbs.isEmpty()) {
						content.content(breadCrumbs);
					}
							
					Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
					content.content(objectHeader);							
					
					content.content(htmlFactory.tag(TagName.h4, inputFormStr).style().color().bootstrapColor(Color.INFO));
					
					boolean horizontalForm = !"false".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.HORIZONTAL_FORM));
					boolean noValidate = "true".equals(getRenderAnnotation(context, eOperation, RenderAnnotation.NO_VALIDATE));
					Map<EParameter, Object> formParameters = new LinkedHashMap<EParameter, Object>();
					for (EParameter eParameter: eOperation.getEParameters()) {
						if (eOperationTarget.isFormParameter(eParameter)) {
							formParameters.put(eParameter, getRenderAnnotation(context, eParameter, RenderAnnotation.DEFAULT_VALUE));
						}
					}
					Form inputForm = renderInputForm(context, target, formParameters, Collections.emptyList(), Collections.emptyMap(), horizontalForm)
						.novalidate(noValidate)
						.action(context.getRequest().getRequestURL())
						.method(Method.post);
					
					if (eOperationTarget.hasPartParameters()) {
						inputForm.enctype(EncType.multipart);
					}
					
					if (originalReferrer != null) {
						inputForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
					}							
					
					configureForm(inputForm, horizontalForm);
					Tag buttonBar = htmlFactory.div().style().text().align().right();
					
					Button executeButton = htmlFactory.button(renderNamedElementIconAndLabel(context, eOperation)).style(Style.PRIMARY);
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
						
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						String invalidInputStr = "Invalid input"; // TODO - resource string
						String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(invalidInputStr).style().color().bootstrapColor(Color.DANGER);
						if (operationFeature == null) {
							renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
						} else {
							renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
						}						
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
								
						Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
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
								context.getResponse().sendRedirect(originalReferrer);
								return Action.NOP;
							}
							
							// Breadcrumbs
							Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
							String resultStr = "Result"; // TODO - resource string
							String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(resultStr).style().color().bootstrapColor(Color.SUCCESS);
							if (operationFeature == null) {
								renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
							} else {
								renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
							}						
							if (!breadCrumbs.isEmpty()) {
								content.content(breadCrumbs);
							}
									
							Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
							content.content(objectHeader);							
							
							if (result == null) {
								content.content(htmlFactory.tag(TagName.h4, resultStr, ": ", renderTrue(context)).style().color().bootstrapColor(Color.SUCCESS));
							} else {
								content.content(htmlFactory.tag(TagName.h4, resultStr).style().color().bootstrapColor(Color.SUCCESS));
								content.content(renderTypedElementView(context, target, eOperation, result, false, null, null));					
							}
						} catch (Exception e) {
							// Breadcrumbs
							Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
							String errorStr = "Error"; // TODO - resource string
							String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(errorStr).style().color().bootstrapColor(Color.DANGER);
							if (operationFeature == null) {
								renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
							} else {
								renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
							}						
							if (!breadCrumbs.isEmpty()) {
								content.content(breadCrumbs);
							}
									
							Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
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
					
					Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
					String invalidInputStr = "Invalid input"; // TODO - resource string
					String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(invalidInputStr).style().color().bootstrapColor(Color.DANGER);
					if (operationFeature == null) {
						renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
					} else {
						renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
					}						
					if (!breadCrumbs.isEmpty()) {
						content.content(breadCrumbs);
					}
							
					Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
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
					Form inputForm = renderInputForm(context, target, formParameters, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getNamedElementValidationResults(), horizontalForm)
						.novalidate(noValidate)
						.action(context.getRequest().getRequestURL())
						.method(Method.post);
					
					if (eOperationTarget.hasPartParameters()) {
						inputForm.enctype(EncType.multipart);
					}
					
					if (originalReferrer != null) {
						inputForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
					}							
					
					configureForm(inputForm, horizontalForm);
					Tag buttonBar = htmlFactory.div().style().text().align().right();
					
					Button executeButton = htmlFactory.button(renderNamedElementIconAndLabel(context, eOperation)).style(Style.PRIMARY);
					executeButton.type(org.nasdanika.html.Button.Type.SUBMIT);
					buttonBar.content(executeButton.style().margin().right("5px"));
					
					buttonBar.content(renderCancelButton(context, target));
					inputForm.content(buttonBar);
					
					content.content(inputForm);					
				} else {
					try {
						Object result = eOperationTarget.invoke(context, bindings);			
						
						if (result == null && originalReferrer != null) {
							context.getResponse().sendRedirect(originalReferrer);
							return Action.NOP;
						}						
						
						// Breadcrumbs
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						String resultStr = "Result"; // TODO - resource string
						String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(resultStr).style().color().bootstrapColor(Color.SUCCESS);
						if (operationFeature == null) {
							renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
						} else {
							renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
						}						
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
								
						Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
						content.content(objectHeader);							
						
						if (result == null) {
							content.content(htmlFactory.tag(TagName.h4, resultStr, ": ", renderTrue(context)).style().color().bootstrapColor(Color.SUCCESS));
						} else {
							content.content(htmlFactory.tag(TagName.h4, resultStr).style().color().bootstrapColor(Color.SUCCESS));
							content.content(renderTypedElementValue(context, eOperation, result));					
						}
					} catch (Exception e) {
						// Breadcrumbs
						Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
						String errorStr = "Error"; // TODO - resource string
						String breadcrumbAction = renderNamedElementIconAndLabel(context, eOperation) + " / "+htmlFactory.span(errorStr).style().color().bootstrapColor(Color.DANGER);
						if (operationFeature == null) {
							renderObjectPath(context, target, breadcrumbAction, breadCrumbs);
						} else {
							renderFeaturePath(context, target, operationFeature, breadcrumbAction, breadCrumbs);						
						}						
						if (!breadCrumbs.isEmpty()) {
							content.content(breadCrumbs);
						}
								
						Tag objectHeader = content.getFactory().tag(TagName.h3, renderNamedElementIconAndLabel(context, eOperation), renderDocumentationIcon(context, eOperation, eOperationDocModal, true)); 
						content.content(objectHeader);							
						
						content.content(htmlFactory.tag(TagName.h4, errorStr).style().color().bootstrapColor(Color.DANGER)); 
						content.content(htmlFactory.alert(Style.DANGER, false, e.toString()));
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
			context.getResponse().sendError(HttpServletResponse.SC_BAD_REQUEST, msg.toString());
			return Action.NOP;
		}
		
		return filterEOperationResult(context, eOperation, eOperationTarget.invoke(context, bindings));				
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

	/**
	 * Configures form appearance
	 * @param form
	 * @param horizontalForm
	 */
	protected void configureForm(Form form, boolean horizontalForm) {
		form
			.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 9)
			.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 7);
	
		if (horizontalForm) {
			form
				.horizontal(Bootstrap.DeviceSize.EXTRA_SMALL, 6)
				.horizontal(Bootstrap.DeviceSize.SMALL, 5)
				.horizontal(Bootstrap.DeviceSize.MEDIUM, 4)
				.horizontal(Bootstrap.DeviceSize.LARGE, 3);						
		}		
	}
		
}
