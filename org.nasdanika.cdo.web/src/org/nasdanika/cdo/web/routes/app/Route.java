package org.nasdanika.cdo.web.routes.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Form;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
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
		
		// Header
		Tag header = content.getFactory().tag(TagName.h3, renderNamedElementLabel(context, target.eClass()), " ", renderLabel(context, target));
		Tag classDocIcon = renderDocumentationIcon(context, target.eClass(), classDocModal);
		if (classDocIcon != null) {
			header.content(classDocIcon);
		}
		content.content(header);
		
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
		Map<String, Object> env = new HashMap<>();
		env.put("title", title);
		
		Fragment contentFragment = getHTMLFactory(context).fragment();		
		Object header = renderHeader(context);
		if (header != null) {
			contentFragment.content(contentFragment.getFactory().div(header));
		}
		
		Object leftPanel = renderLeftPanel(context);
		Tag contentDiv = contentFragment.getFactory().div(content);
		if (leftPanel == null) {
			contentFragment.content(contentDiv);			
		} else {			
			Tag leftPanelDiv = contentFragment.getFactory().div(leftPanel);
			setLeftPanelAndContentColSizes(context, leftPanelDiv, contentDiv);
			contentFragment.content(contentFragment.getFactory().div(leftPanelDiv, contentDiv).bootstrap().grid().row());			
		}
		
		Object footer = renderFooter(context);
		if (footer != null) {
			contentFragment.content(contentFragment.getFactory().div(footer));
		}		
		
		env.put("content", contentFragment);
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
		return HTMLFactory.INSTANCE.interpolate(getPageTemplate(), env);		
	}
	
	/**
	 * @param context
	 * @return Bootstrap/Bootswatch theme to use for rendering. 
	 */
	protected Theme getTheme(C context) {
		return Theme.Default;
	}

	/**
	 * @return page template which takes <code>title</code>, <code>bootstrap-theme</code>, and <code>content</code> tokens for interpolation.
	 * This implementation returns a minimalistic page template with Bootstrap, Knockout, require.js, jquery.js and knockout.js scripts.
	 * 
	 */
	protected Object getPageTemplate() {
		return Route.class.getResource("page-template.html");
	}
	
	@Override
	protected String getApiDocPath() {
		return "api.html";
	}

	/**
	 * Renders an optional page header.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderHeader(C context) throws Exception {
		return null;
	}

	/**
	 * Renders an optional page footer.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderFooter(C context) throws Exception {
		return null;
	}
	
	/**
	 * Renders an optional page header.
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected Object renderLeftPanel(C context) throws Exception {
		return null;
	}
	
	/**
	 * Sets left panel and content sizes.
	 */
	protected void setLeftPanelAndContentColSizes(C context, UIElement<?> leftPanel,  UIElement<?> content) {
		leftPanel.bootstrap().grid().col(1);
		content.bootstrap().grid().col(11);
	}
	
	@RouteMethod(
			value = RequestMethod.GET,
			path = "add/{feature}",
			action = "create",
			qualifier = "{feature}",
			produces = "text/html",
			comment="Renders a page for adding or creating object for a particular feature.")
	public Object addFeature(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		
		return "Add "+feature;
		
	}
	
	@RouteMethod(
			value = RequestMethod.GET,
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
			value = RequestMethod.GET,
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
	
	// TODO - support both get and post, validate on post 
	@RouteMethod(
			comment="Renders object edit form.",
			action = "update")
	public Object getEditHtml(
			@ContextParameter C context,
			@TargetParameter T target,
			@HeaderParameter("referer") String referrer) throws Exception {
		
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(((EObject) context.getTarget()).eClass().getName()));
		HTMLFactory htmlFactory = getHTMLFactory(context);
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
		
		Form editForm = htmlFactory.form()
//				.novalidate()
				.action("edit.html")
				.bootstrap().grid().col(Bootstrap.DeviceSize.EXTRA_SMALL, 12)
				.bootstrap().grid().col(Bootstrap.DeviceSize.SMALL, 12)
				.bootstrap().grid().col(Bootstrap.DeviceSize.MEDIUM, 8)
				.bootstrap().grid().col(Bootstrap.DeviceSize.LARGE, 5);

		content.content(editForm);
		
		Map<EStructuralFeature, String> errorMessages = new HashMap<>();
		
		errorMessages.put(SecurityPackage.Literals.LOGIN_USER__LOGIN, "Too short"); // For testing.
				
		renderEditableFeaturesFormGroups(context, target, editForm, featureDocModals, errorMessages);
		
		
		
		
//		// Header
//		Tag header = content.getFactory().tag(TagName.h3, renderNamedElementLabel(context, target.eClass()), " ", renderLabel(context, target));
//		Tag classDocIcon = renderDocumentationIcon(context, target.eClass(), classDocModal);
//		if (classDocIcon != null) {
//			header.content(classDocIcon);
//		}
//		content.content(header);
//		
//		// view 
//		if (!isViewTab(context, target)) {
//			content.content(renderView(context, target, featureDocModals));
//		}
//		
//		Tabs tabs = content.getFactory().tabs();
//		renderTabs(context, target, tabs, featureDocModals);
//				
//		if (!tabs.isEmpty()) {
//			content.content(tabs);
//		}
		
		// TODO - Cancel button navigates to referrer upon confirmation.
		
//		content.content("Edit "+renderLabel(context, target)+" <- "+referrer);
		
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
