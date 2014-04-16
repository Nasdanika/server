package org.nasdanika.web;

import org.nasdanika.core.Context;
import org.nasdanika.core.ContextProvider;

/**
 * Abstract base for route components which use context providers.
 * @author Pavel
 *
 */
public abstract class AbstractContextProviderRouteComponent<C extends Context, MC extends WebContext> implements Route {

	private ContextProvider<C> contextProvider;
	
	public ContextProvider<C> getContextProvider() {
		return contextProvider;
	}
	
	public void setContextProvider(ContextProvider<C> contextProvider) {
		this.contextProvider = contextProvider;
	}
	
	public void clearContextProvider(ContextProvider<C> contextProvider) {
		this.contextProvider = null;
	}
	
	/**
	 * Creates a new context by merging/facading web context and provided context.
	 * @param webContext
	 * @param context
	 * @return
	 * @throws Exception 
	 */
	protected abstract MC mergeContexts(WebContext webContext, C context) throws Exception;

	@Override
	public boolean canExecute() {
		return contextProvider!=null;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
