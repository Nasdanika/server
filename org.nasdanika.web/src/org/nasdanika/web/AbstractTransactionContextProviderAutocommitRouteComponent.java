package org.nasdanika.web;

import org.nasdanika.core.TransactionContext;

/**
 * Abstract base for route components which open and commit/rollback provided transaction context for each 
 * request (no conversational state).
 * @author Pavel
 *
 */
public abstract class AbstractTransactionContextProviderAutocommitRouteComponent<C extends TransactionContext, MC extends WebContext> extends AbstractContextProviderAutocloseRouteComponent<C, MC> {

	@Override
	public Action execute(WebContext webContext, Object... args) throws Exception {
		try (MC mergedContext = mergeContexts(webContext, getContextProvider().createContext())) {	
			try {
				return route(mergedContext);
			} catch (Exception e) {
				((TransactionContext) mergedContext).setRollbackOnly();
				throw e;
			}
		}			
	}

}
