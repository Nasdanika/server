package org.nasdanika.cdo.web.routes.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringEscapeUtils;
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
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Form;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.FormGroup.Status;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
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
	private static final String EXTENSION_HTML = ".html";
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
		if (!isViewTab(context, target)) {
			content.content(renderView(context, target, featureDocModals));
		}
		
		Tabs tabs = content.getFactory().tabs();
		renderTabs(context, target, tabs, featureDocModals);
				
		if (!tabs.isEmpty()) {
			content.content(tabs);
		}
		
		return renderPage(context, title, content, null);
		
	}
		
	/**
	 * Renders page using page template and bootstrap theme.
	 * @param context
	 * @param title
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	protected Object renderPage(C context, String title, Object content, Consumer<Map<String,Object>> environmentCustomizer) throws Exception {
		Map<String, Object> env = createRenderPageEnvironment(context);

		env.put(PageTemplateTokens.TITLE.literal, title == null ? "" : title);
		
		Object head = renderHead(context);
		env.put(PageTemplateTokens.HEAD.literal, head == null ? "" : head);

		Object header = renderHeader(context);
		env.put(PageTemplateTokens.HEADER.literal, header == null ? "" : header);
		
		Object leftPanel = renderLeftPanel(context);
		env.put(PageTemplateTokens.LEFT_PANEL.literal, leftPanel == null ? "" : leftPanel);

		env.put(PageTemplateTokens.CONTENT.literal, content == null ? "" : content);
		
		Object footer = renderFooter(context);
		env.put(PageTemplateTokens.FOOTER.literal, footer == null ? "" : footer);
		
		env.put(PageTemplateTokens.BODY.literal, renderBody(context, header, leftPanel, content, footer));
		
		if (environmentCustomizer != null) {
			environmentCustomizer.accept(env);
		}
				
		Theme theme = getTheme(context);
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
	protected Fragment renderBody(C context, Object header, Object leftPanel, Object content, Object footer) throws Exception {
		Fragment bodyFragment = getHTMLFactory(context).fragment();		
		if (header != null) {
			bodyFragment.content(bodyFragment.getFactory().div(header));
		}
		
		Tag contentDiv = bodyFragment.getFactory().div(content);
		if (leftPanel == null) {
			bodyFragment.content(contentDiv);			
		} else {			
			Tag leftPanelDiv = bodyFragment.getFactory().div(leftPanel);
			setLeftPanelAndContentColSizes(context, leftPanelDiv, contentDiv);
			bodyFragment.content(bodyFragment.getFactory().div(leftPanelDiv, contentDiv).bootstrap().grid().row());			
		}
		
		if (footer != null) {
			bodyFragment.content(bodyFragment.getFactory().div(footer));
		}		
		
		return bodyFragment;
	}

	/**
	 * Override to provide additional interpolation tokens used by your page template.
	 * renderPage() adds title and content tokens to the environment before passing it to interpolate();
	 * @param context
	 * @return Map containing tokens to use for interpolation of the page template.
	 */
	protected HashMap<String, Object> createRenderPageEnvironment(C context) {
		HashMap<String, Object> ret = new HashMap<>();
		ret.put(PageTemplateTokens.RESOURCES_PATH.literal, "resources");
		return ret;
	}
	
//	protected  
	
	/**
	 * @param context
	 * @return Bootstrap/Bootswatch theme to use for rendering. 
	 */
	protected Theme getTheme(C context) {
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
	protected Object renderHead(C context) throws Exception {
		return getResource(context, "page.head");
	}	

	/**
	 * Renders an optional page header. This implementation returns ``page.header`` resource. 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderHeader(C context) throws Exception {
		return getResource(context, "page.header");
	}

	/**
	 * Renders an optional page footer. This implementation returns ``page.footer`` resource.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderFooter(C context) throws Exception {
		return getResource(context, "page.footer");
	}
	
	/**
	 * Renders an optional page header. This implementation returns ``page.left-panel`` resource.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderLeftPanel(C context) throws Exception {
		return getResource(context, "page.left-panel");
	}
	
	/**
	 * Sets left panel and content sizes.
	 */
	protected void setLeftPanelAndContentColSizes(C context, UIElement<?> leftPanel,  UIElement<?> content) {
		leftPanel.bootstrap().grid().col(1);
		content.bootstrap().grid().col(11);
	}
	
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "select/{feature}",
			action = "update",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Renders a page for adding a reference to a non-containment feature.")
	public Object selectReferenceFeatureElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter("referer") String referrerHeader,			
			@PathParameter("feature") String feature,
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {

		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature.substring(0, feature.length() - EXTENSION_HTML.length()));
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
			Form editForm = renderFeatureEditForm(context, target, tsf, diagnosticConsumer.getFeatureValidationResults().get(tsf), horizontalForm)
		//		.novalidate()
				.action(feature)
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
			
			return renderPage(context, title, content, env -> env.put(PageTemplateTokens.RESOURCES_PATH.literal, "../"+env.get(PageTemplateTokens.RESOURCES_PATH.literal)));		
		}
		
		return Action.BAD_REQUEST;				
	}
	
	@SuppressWarnings("unchecked")
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "create/{feature}/{epackage}/{eclass}",
			action = "create",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Renders a page for creating an object and adding it to a containment feature.")
	public Object createContainementFeatureElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter("referer") String referrerHeader,			
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
				if (eClassifier instanceof EClass && ((EReference) tsf).getEReferenceType().isSuperTypeOf((EClass) eClassifier)) {
					EClass eClass = (EClass) eClassifier;					
					EObject instance = ePackage.getEFactoryInstance().create(eClass);
					Renderer<C, EObject> renderer = getReferenceRenderer((EReference) tsf, instance);
					
					ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
						
						@Override
						protected String getResourceString(EStructuralFeature feature, String key) throws Exception {
							return Route.this.getResourceString(context, (ENamedElement) (feature == null ? eClass : feature), key, true);
						}
						
					};
					
					if (context.getMethod() == RequestMethod.POST) {			
						if (renderer.setEditableFeatures(context, instance, diagnosticConsumer)) {							
							// Success - add/set instance to the feature and then redirect to referrer parameter or referer header or the view.
							if (tsf.isMany()) {
								((Collection<Object>) target.eGet(tsf)).add(instance);
							} else {
								target.eSet(tsf, instance);
							}
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

					HTMLFactory htmlFactory = getHTMLFactory(context);
					String title = StringEscapeUtils.escapeHtml4(renderer.nameToLabel(eClass.getName()));
					Fragment content = htmlFactory.fragment();
					
					// Breadcrumbs
					Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
					renderer.renderObjectPath(context, target, renderNamedElementIconAndLabel(context, target.eClass().getEStructuralFeature(feature))+" / "+renderer.getResourceString(context, "create", true), breadCrumbs);
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
					Form editForm = renderer.renderEditForm(context, instance, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getFeatureValidationResults(), horizontalForm)
				//		.novalidate()
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
					
					return renderPage(context, title, content, env -> env.put(PageTemplateTokens.RESOURCES_PATH.literal, "../../../"+env.get(PageTemplateTokens.RESOURCES_PATH.literal)));							
				}							
			}
		}
		
		return Action.BAD_REQUEST;		
	}
	
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST },
			action = "update",
			qualifier = "{feature}",
			path = "edit/{feature}",
			produces = "text/html",
			comment="Renders an edit/select page for a single-value feature.")
	public Object editFeature(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		
		return "Edit "+feature;
		
	}
		
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			action = "update",
			qualifier = "{feature}",
			path = "edit/{feature}/{element}",
			produces = "text/html",
			comment="Renders an edit/select page for an element of multi-value feature.")
	public Object editFeatureElement(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@PathParameter("element") String element,
			@TargetParameter T target) throws Exception {
		
		
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
			@HeaderParameter("referer") String referrerHeader,			
			@QueryParameter(REFERRER_KEY) String referrerParameter) throws Exception {
		
		EClass targetEClass = target.eClass();
		HTMLFactory htmlFactory = getHTMLFactory(context);
		ValidationResultsDiagnostiConsumer diagnosticConsumer = new ValidationResultsDiagnostiConsumer() {
			
			@Override
			protected String getResourceString(EStructuralFeature feature, String key) throws Exception {
				return Route.this.getResourceString(context, (ENamedElement) (feature == null ? targetEClass : feature), key, true);
			}
			
		};
		
		if (context.getMethod() == RequestMethod.POST) {			
			if (setEditableFeatures(context, target, diagnosticConsumer)) {
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
		Form editForm = renderEditForm(context, target, diagnosticConsumer.getValidationResults(), diagnosticConsumer.getFeatureValidationResults(), horizontalForm)
	//		.novalidate()
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
		
		Tag buttonBar = htmlFactory.div().style().text().align().right();
		buttonBar.content(renderSaveButton(context, target).style().margin().right("5px"));
		buttonBar.content(renderCancelButton(context, target));
		editForm.content(buttonBar);
		
		content.content(editForm);
		
		return renderPage(context, title, content, null);		
	}				
	
	@RouteMethod(
			comment="Deletes this element and redirects either to the referrer or to the parent index if the referrer is one of 'this' object pages.",
			lock = @RouteMethod.Lock(type=Type.WRITE), 
			action = "delete")
	public Object getDeleteHtml(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter("referer") String referrer) throws Exception {
		
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
			path = "delete/{feature}",
			action = "delete",
			qualifier = "{feature}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type=Type.WRITE), 
			comment="Clears single-value feature and redirects to the referrer.")
	public Object deleteFeature(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter("referer") String referrer,
			@PathParameter("feature") String feature) throws Exception {
		
		EStructuralFeature tsf = target.eClass().getEStructuralFeature(feature.substring(0, feature.length() - EXTENSION_HTML.length()));
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
			path = "delete/{feature}/{element}",
			action = "delete",
			qualifier = "{feature}",
			produces = "text/html",
			lock = @RouteMethod.Lock(type=Type.WRITE), 
			comment="Removes an element from a multi-value feature and redirects to the referrer.")
	public Object deleteFeatureElement(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter("referer") String referrer,
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
			
			int idx = Integer.parseInt(element.substring(0, element.length() - EXTENSION_HTML.length()));
			
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
	
}
