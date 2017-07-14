package org.nasdanika.cdo.web.routes;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;

/**
 * Redirects to the first subject's principal's home.html page.
 * @author Pavel Vlasov
 *
 */
public class RedirectToPrincipalHomeRoute implements Route {

	@SuppressWarnings("unchecked")
	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		if (context instanceof CDOViewContext) {
			for (Principal principal: ((CDOViewContext<?,?>) context).getPrincipals()) {
				if (((CDOViewContext<?,?>) context).getView() instanceof CDOTransaction && principal.cdoID().isTemporary()) {
					((CDOViewContext<CDOTransaction,?>) context).getView().addTransactionHandler(new CDOTransactionHandler2() {

						@Override
						public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
							try {
								String principalHome = context.getObjectPath(principal)+"/home.html";
								String queryString = context.getRequest().getQueryString();
								context.getResponse().sendRedirect(queryString == null ? principalHome : principalHome + "?" + queryString);
							} catch (Exception e) {
								e.printStackTrace();
								try {
									context.getResponse().sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
								} catch (IOException ioe) {
									ioe.printStackTrace();
								}
							}
						}

						@Override
						public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
							// NOP
							
						}

						@Override
						public void rolledBackTransaction(CDOTransaction transaction) {
							// NOP
							
						}
						
					});
				} else {
					String principalHome = context.getObjectPath(principal)+"/home.html";
					String queryString = context.getRequest().getQueryString();
					context.getResponse().sendRedirect(queryString == null ? principalHome : principalHome + "?" + queryString);					
				}
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
