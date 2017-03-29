package org.nasdanika.cdo.web.routes;

import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;

/**
 * Redirects to the principal's index.html page.
 * @author Pavel Vlasov
 *
 */
public class RedirectToPrincipalHomeRoute implements Route {

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		if (context instanceof CDOViewContext) {
			Principal principal = ((CDOViewContext<?,?>) context).getPrincipal();
			if (principal != null) {
				String principalHome = context.getObjectPath(principal)+"/index.html";
				String queryString = context.getRequest().getQueryString();
				context.getResponse().sendRedirect(queryString == null ? principalHome : principalHome + "?" + queryString);
				return Action.NOP;
			}
		}
		return Action.FORBIDDEN;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
