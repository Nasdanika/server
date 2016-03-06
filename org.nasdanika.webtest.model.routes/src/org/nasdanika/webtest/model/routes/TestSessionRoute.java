package org.nasdanika.webtest.model.routes;

import org.nasdanika.cdo.web.routes.EDispatchingRoute;
import org.nasdanika.webtest.model.TestSession;
import org.osgi.framework.BundleContext;

/**
 * Provides Web UI for {@link TestSession}.
 * @author Pavel Vlasov
 *
 */
public class TestSessionRoute extends EDispatchingRoute {

	protected TestSessionRoute(BundleContext bundleContext) throws Exception {
		super(bundleContext);
	}

}
