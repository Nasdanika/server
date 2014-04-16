package org.nasdanika.web;

import org.nasdanika.core.Context;

/**
 * Abstract base for route components which open and close provided context for each request (no conversational state).
 * @author Pavel
 *
 */
public abstract class AbstractContextProviderAutocloseRouteComponent<C extends Context, MC extends WebContext> extends AbstractContextProviderRouteComponent<C, MC> {

	@Override
	public Action execute(WebContext webContext) throws Exception {
		try (MC mergedContext = mergeContexts(webContext, getContextProvider().createContext())) {			
			return route(mergedContext);
		}			
	}

	/**
	 * Perform routing.
	 * @param mergedContext
	 * @return
	 */
	protected abstract Action route(MC mergedContext) throws Exception;

}
