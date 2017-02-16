package org.nasdanika.cdo.web.routes.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.Theme;
import org.nasdanika.html.UIElement;
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
		Fragment content = HTMLFactory.INSTANCE.fragment();
		
		// Documentation modals
		Modal classDocModal = renderDocumentationModal(context, target.eClass());
		if (classDocModal != null) {
			content.content(classDocModal);
		}
		
		Map<EStructuralFeature, Modal> featureDocModals = renderFeatureDocModals(context, target);
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
			produces = "text/html",
			comment="Renders a page for adding or creating object for a particular feature.")
	public Object addFeature(
			@ContextParameter C context,
			@PathParameter("feature") String feature,
			@TargetParameter T target) throws Exception {
		
		
		return feature;
		
	}
	
	// edit
	// edit/feature[/index]
	// delete
	// delete/feature[/index]
	// clear
	
	// Delete.html (GET) - redirect to referrer if the referrer is not own index.html, then redirect to the container
//	EcoreUtil.delete(target, true);
	
	// TODO - trace
	
	
	// Object diagram png
	
}
