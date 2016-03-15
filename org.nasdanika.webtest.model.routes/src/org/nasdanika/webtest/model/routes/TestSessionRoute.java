package org.nasdanika.webtest.model.routes;

import org.nasdanika.core.ContextParameter;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RouteMethod;
import org.nasdanika.webtest.model.TestSession;

/**
 * Provides Web UI for {@link TestSession}.
 * @author Pavel Vlasov
 *
 */
public class TestSessionRoute extends RouteBase {
	
	public TestSessionRoute() throws Exception {
		super();
	}	
	
	@RouteMethod
	public Object getIndexHtml(@ContextParameter HttpServletRequestContext context) {
		return "Here we go: "+((TestSession) context.getTarget()).getNode();
	}

}
