package org.nasdanika.webtest.model.routes;

import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.webtest.model.TestSession;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * Provides Web UI for {@link TestSession}.
 * @author Pavel Vlasov
 *
 */
public class TestSessionRoute extends EDispatchingRoute {

	protected TestSessionRoute(BundleContext bundleContext) throws Exception {
		super(bundleContext);
	}
	
	public TestSessionRoute() throws Exception {
		// Assuming that org.nasdanika.cdo.web is activated.
		this(FrameworkUtil.getBundle(EDispatchingRoute.class).getBundleContext());
	}	
	
	@RouteMethod
	public Object getIndexHtml(@ContextParameter HttpServletRequestContext context) {
		return "Here we go: "+((TestSession) context.getTarget()).getNode();
	}

}
