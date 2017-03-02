package org.nasdanika.cdo.web.routes.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.TransactionContext;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Form;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormGroup.Status;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.ListGroup;
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
 *  modern techniques such as AJAX and data bindings, while the rest of pages stay simple waiting for their turn to be 
 *  customized.  
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
		
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(((EObject) context.getTarget()).eClass().getName()));
		Fragment content = getHTMLFactory(context).fragment();
		
		// Documentation modals
		Modal classDocModal = renderDocumentationModal(context, target.eClass());
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
		
		return renderPage(context, title, content);
		
	}
		
	/**
	 * Renders page using page template and bootstrap theme.
	 * @param context
	 * @param title
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	protected Object renderPage(C context, String title, Object content) throws Exception {
		Map<String, Object> env = createRenderPageEnvironment(context);

		env.put("title", title == null ? "" : title);
		
		Object head = renderHead(context);
		env.put("head", head == null ? "" : head);

		Object header = renderHeader(context);
		env.put("header", header == null ? "" : header);
		
		Object leftPanel = renderLeftPanel(context);
		env.put("left-panel", leftPanel == null ? "" : leftPanel);

		env.put("content", content == null ? "" : content);
		
		Object footer = renderFooter(context);
		env.put("footer", footer == null ? "" : footer);
		
		env.put("body", renderBody(context, header, leftPanel, content, footer));
		
		Theme theme = getTheme(context);
		switch (theme) {
		case None:
			env.put(BOOTSTRAP_THEME_TOKEN, "");
			break;
		case Default:
			env.put(BOOTSTRAP_THEME_TOKEN, "<link href=\"resources/bootstrap/css/bootstrap-theme.min.css\" rel=\"stylesheet\">");
			break;
		default:
			env.put(BOOTSTRAP_THEME_TOKEN, "<link href=\"resources/bootstrap/css/bootstrap-"+theme.name().toLowerCase()+".min.css\" rel=\"stylesheet\">");							
		}
		return HTMLFactory.INSTANCE.interpolate(getPageTemplate(context), env);		
	}
	
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
		return new HashMap<>();
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
			path = "add/{feature}",
			action = "create",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Renders a page for adding a reference to a non-containment feature.")
	public Object addReferenceFeatureElement(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		return "Add reference "+feature;
		
	}
	
	@RouteMethod(
			value = { RequestMethod.GET, RequestMethod.POST }, 
			path = "create/{feature}/{epackage}/{eclass}",
			action = "create",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Renders a page for creating an object and adding it to a containment feature.")
	public Object createContainementFeatureElement(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@PathParameter("epackage") String epackage,
			@PathParameter("eclass") String eclass,
			@TargetParameter T target) throws Exception {
		
//		Hex.encodeHexString(eClassifier.getEPackage().getNsURI().getBytes(/* UTF-8? */))		
		return "Add containment "+feature;
		
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
			@QueryParameter(REFERRER_KEY) String referrerParameter,
			@HeaderParameter("referer") String referrerHeader) throws Exception {
		
		boolean horizontalForm = !"false".equals(getRenderAnnotation(context, target.eClass(), "horizontal-form"));
		Map<EStructuralFeature, ValidationResult> validationResults = new HashMap<>();		
		HTMLFactory htmlFactory = getHTMLFactory(context);
		ListGroup errorList = htmlFactory.listGroup();
		
		if (context.getMethod() == RequestMethod.POST) {
			Consumer<Diagnostic> diagnosticConsumer = (diagnostic) -> {
				List<?> dData = diagnostic.getData();
				EStructuralFeature esf = dData.size() > 1 && dData.get(1) instanceof EStructuralFeature ? (EStructuralFeature) dData.get(1) : null;
				FormGroup.Status status;
				switch (diagnostic.getSeverity()) {
				case Diagnostic.ERROR:
					status = Status.ERROR;
					break;
				case Diagnostic.WARNING:
					status = Status.WARNING;
					break;
				default:
					status = Status.SUCCESS;
				}
				Style style = status.toStyle();
				String message = diagnostic.getMessage();
				String escapedMessage = CoreUtil.isBlank(message) ? status.name() : StringEscapeUtils.escapeHtml4(message);
				if (esf == null) {
					errorList.item(escapedMessage, style);
				} else {
					validationResults.put(esf, new ValidationResult(status, escapedMessage));
					if (horizontalForm) {
						Object featureNameLabel;
						try {
							featureNameLabel = renderNamedElementLabel(context, esf);
						} catch (Exception e) {
							featureNameLabel = esf.getName();
						}
						errorList.item(htmlFactory.label(style, featureNameLabel) + " " + escapedMessage, style);						
					}
				}
			};
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
		
		
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(((EObject) context.getTarget()).eClass().getName()));
		Fragment content = htmlFactory.fragment();
		
		// Documentation modals
		Modal classDocModal = renderDocumentationModal(context, target.eClass());
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		Map<EStructuralFeature, Modal> featureDocModals = renderEditableFeaturesDocModals(context, target);
		for (Modal fdm: featureDocModals.values()) {
			content.content(fdm);
		}
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath(context, target, "Edit", breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		// Object header
		Tag objectHeader = content.getFactory().tag(TagName.h3, renderObjectHeader(context, target, classDocModal));
		content.content(objectHeader);		
		
		Form editForm = htmlFactory.form()
//				.novalidate()
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
		
		content.content(editForm);
		
		if (!errorList.isEmpty()) {
			editForm.content(errorList);
		}
				
		renderEditableFeaturesFormGroups(context, target, editForm, featureDocModals, validationResults, horizontalForm).forEach((fg) -> fg.feedback(!horizontalForm));
		
		String originalReferrer = referrerParameter;
		if (originalReferrer == null) {
			originalReferrer = referrerHeader;
		}
		if (originalReferrer != null) {
			editForm.content(htmlFactory.input(InputType.hidden).name(REFERRER_KEY).value(originalReferrer)); // encode?
		}		
		
		Tag buttonBar = content.getFactory().div().style().text().align().right();
		buttonBar.content(renderSaveButton(context, target).style().margin().right("5px"));
		buttonBar.content(renderCancelButton(context, target));
		editForm.content(buttonBar);
		
		return renderPage(context, title, content);		
	}				
	
	@RouteMethod(
			comment="Deletes this element and redirects either to the referrer or to the parent index if the referrer is one of 'this' object pages.",
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
			comment="Clears single-value feature and redirects to the referrer.")
	public Object deleteFeature(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		
		// TODO
		return "To implement - Clear "+feature;
		
	}
		
	@RouteMethod(
			value = RequestMethod.GET,
			path = "delete/{feature}/{element}",
			action = "delete",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Removes an element from a multi-value feature and redirects to the referrer.")
	public Object deleteFeatureElement(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@PathParameter("element") String element,
			@TargetParameter T target) throws Exception {
		
		
		// TODO
		return "To implement - Delete "+feature+" "+element;
		
	}
	
	// TODO - trace
	
	
	// Object diagram png
	
}
