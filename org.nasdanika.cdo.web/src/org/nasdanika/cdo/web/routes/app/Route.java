package org.nasdanika.cdo.web.routes.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Resource;
import org.nasdanika.web.RouteMethod;
import org.osgi.framework.BundleContext;

/**
 * Application route providing CRUD operations for the underlying EObject.
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

	protected Route(BundleContext bundleContext, Object... targets) throws Exception {
		super(bundleContext, targets);
	} 

	/**
	 * Renders object view page - single value features in a table with two columns 
	 * and "many" features in tabs. 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RouteMethod
	public Object getIndexHtml(@ContextParameter HttpServletRequestContext context) throws Exception {
		String title = StringEscapeUtils.escapeHtml4(nameToLabel(((EObject) context.getTarget()).eClass().getName()));
		Fragment content = HTMLFactory.INSTANCE.fragment();
		
		// Breadcrumbs
		Breadcrumbs breadCrumbs = content.getFactory().breadcrumbs();
		renderObjectPath((C) context, (T) context.getTarget(), breadCrumbs);
		if (!breadCrumbs.isEmpty()) {
			content.content(breadCrumbs);
		}
		
		// !many features - label, question mark, tooltip, modal.
		
		// many features => tabs
		
		// page template
		
		Map<String, Object> env = new HashMap<>();
		env.put("title", title);
		env.put("content", content);
		return HTMLFactory.INSTANCE.interpolate(getPageTemplate(), env);		
		
	}
	
	/**
	 * @return page template which takes <code>template</code> and <code>content</code> tokens for interpolation.
	 * This implementation returns a minimalistic page template with Bootstrap, Knockout, require.js, jquery.js and knockout.js scripts.
	 * 
	 */
	protected Object getPageTemplate() {
		return Route.class.getResource("page-template.html");
	}
	
	
	// Object diagram png
	
}
