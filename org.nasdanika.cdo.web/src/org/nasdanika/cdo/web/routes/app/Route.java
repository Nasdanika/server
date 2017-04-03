package org.nasdanika.cdo.web.routes.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
import org.nasdanika.html.FontAwesome.WebApplication;
import org.nasdanika.html.Form;
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
import org.osgi.framework.BundleContext;

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
public class Route<C extends HttpServletRequestContext, T extends EObject> extends EDispatchingRoute implements Renderer<C, T> {


	/**
	 * Interpolation tokens used by the page template
	 * @author Pavel
	 *
	 */
	public enum PageTemplateTokens {
		
		RESOURCES_PATH("resources-path"),
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

	protected Route(BundleContext bundleContext, Object... targets) throws Exception {
		super(bundleContext, targets);
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
	protected HashMap<String, Object> createRenderPageEnvironment(C context) throws Exception {
		HashMap<String, Object> ret = new HashMap<>();		
		ret.put(PageTemplateTokens.RESOURCES_PATH.literal, context.getObjectPath(context.getTarget())+"/resources");
		return ret;
	}
	
//	protected  
	
	/**
	 * @param context
	 * @return Bootstrap/Bootswatch theme to use for rendering. 
	 */
	protected Theme getTheme(C context, T obj) {
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
				protected String getResourceString(EStructuralFeature feature, String key) throws Exception {
					return Route.this.getResourceString(context, (ENamedElement) (feature == null ? targetEClass : feature), key, true);
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
				List<ValidationResult> featureValidationResults = diagnosticConsumer.getFeatureValidationResults().get(tsf);
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
			Form editForm = renderFeatureEditForm(context, target, tsf, diagnosticConsumer.getFeatureValidationResults().get(tsf), horizontalForm)
				.novalidate(noValidate)
				.action("select.html")				
				.method(Method.post)
				.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
				.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
				.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 9)
				.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 7);
			
			if (horizontalForm) {
				editForm
					.horizontal(Bootstrap.DeviceSize.EXTRA_SMALL, 6)
					.horizontal(Bootstrap.DeviceSize.SMALL, 5)
					.horizontal(Bootstrap.DeviceSize.MEDIUM, 4)
					.horizontal(Bootstrap.DeviceSize.LARGE, 3);
				
			}
			
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
							protected String getResourceString(EStructuralFeature feature, String key) throws Exception {
								return Route.this.getResourceString(context, (ENamedElement) (feature == null ? eClass : feature), key, true);
							}
							
						};
						
						// Adding the new instance to the object graph for selectors to work. 
						if (tsf.isMany()) {
							((Collection<Object>) target.eGet(tsf)).add(instance);
						} else {
							target.eSet(tsf, instance);
						}					
						
						if (context.getMethod() == RequestMethod.POST) {			
							if (renderer.setEditableFeatures(context, instance, diagnosticConsumer)) {							
								// Success - add/set instance to the feature and then redirect to referrer parameter or referer header or the view.
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
						Form editForm = renderer.renderEditForm(context, instance, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getFeatureValidationResults(), horizontalForm)
							.novalidate(noValidate)
							.action(eclass)
							.method(Method.post)
							.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
							.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
							.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 9)
							.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 7);
						
						if (horizontalForm) {
							editForm
								.horizontal(Bootstrap.DeviceSize.EXTRA_SMALL, 6)
								.horizontal(Bootstrap.DeviceSize.SMALL, 5)
								.horizontal(Bootstrap.DeviceSize.MEDIUM, 4)
								.horizontal(Bootstrap.DeviceSize.LARGE, 3);
							
						}
						
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
		content.content(renderFeatureView(context, target, sf, true, null, null));
		
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
			protected String getResourceString(EStructuralFeature feature, String key) throws Exception {
				return Route.this.getResourceString(context, (ENamedElement) (feature == null ? targetEClass : feature), key, true);
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
		Form editForm = renderEditForm(context, target, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getFeatureValidationResults(), horizontalForm)
			.novalidate(noValidate)
			.action("edit.html")
			.method(Method.post)
			.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
			.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 9)
			.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 7);
		
		if (horizontalForm) {
			editForm
				.horizontal(Bootstrap.DeviceSize.EXTRA_SMALL, 6)
				.horizontal(Bootstrap.DeviceSize.SMALL, 5)
				.horizontal(Bootstrap.DeviceSize.MEDIUM, 4)
				.horizontal(Bootstrap.DeviceSize.LARGE, 3);
			
		}
		
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
			comment="Deletes this element and redirects either to the referrer or to the parent index if the referrer is one of 'this' object pages.",
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
				Principal authenticatedPrincipal = ((CDOViewContext<?, LoginPasswordCredentials>) context).authenticate(new LoginPasswordCredentials() {
					
					@Override
					public String getPassword() {
						return password;
					}
					
					@Override
					public String getLogin() {				
						return login;
					}
				});
				if (authenticatedPrincipal==null) {
					errorMessages.add(getResourceString(context, "invalidLoginPasswordCombination"));
					invalidLogin = true;
					invalidPassword = true;
				} else {
					String principalHome = context.getObjectPath(authenticatedPrincipal)+"/index.html";
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

	
}
