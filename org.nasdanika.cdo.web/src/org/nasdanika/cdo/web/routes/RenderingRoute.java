package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.web.CDOTransactionHttpServletRequestContext;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.web.TargetParameter;
import org.osgi.framework.BundleContext;

/**
 * Base class for routes which use HTML renderers to generate Web UI.
 * @author Pavel Vlasov
 *
 */
public class RenderingRoute<T extends CDOObject, C extends CDOTransactionHttpServletRequestContext<?>> extends EDispatchingRoute {

	protected RenderingRoute(BundleContext bundleContext) throws Exception {
		super(bundleContext);
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
		return "Hello "+target;
	}
	

}
