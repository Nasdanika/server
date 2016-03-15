package org.nasdanika.webtest.model.routes;

import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * Base route with resource annotations
 * @author Pavel Vlasov
 *
 */
// TODO - resource mappings for knockout, jQuery, Bootstrap
public class RouteBase extends EDispatchingRoute {
	
	protected RouteBase() throws Exception {
		// Assuming that org.nasdanika.cdo.web is activated.
		this(FrameworkUtil.getBundle(EDispatchingRoute.class).getBundleContext());
	}	
	
	
	protected RouteBase(BundleContext bundleContext, Object... targets) throws Exception {
		super(bundleContext, targets);
	}

}
