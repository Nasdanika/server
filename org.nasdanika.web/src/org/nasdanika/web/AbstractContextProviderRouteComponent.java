package org.nasdanika.web;

import org.nasdanika.core.Context;
import org.nasdanika.core.ContextProvider;
import org.nasdanika.core.FacadeContextProvider;

/**
 * Abstract base for route components which use context providers.
 * @author Pavel
 *
 */
public abstract class AbstractContextProviderRouteComponent<C extends Context, MC extends WebContext> implements Route {

	private ContextProvider<C> contextProvider;
	private FacadeContextProvider<C> facadeContextProvider;
	
	protected ContextProvider<C> getContextProvider(final WebContext webContext) {
		if (facadeContextProvider!=null) {
			return new ContextProvider<C>() {

				@Override
				public C createContext() {
					return facadeContextProvider.createContext(webContext);
				}
			};
		}
		return contextProvider;
	}
	
	public void setContextProvider(ContextProvider<C> contextProvider) {
		this.contextProvider = contextProvider;
	}
			
	public void clearContextProvider(ContextProvider<C> contextProvider) {
		this.contextProvider = null;
	}
	
	public void setFacadeContextProvider(FacadeContextProvider<C> facadeContextProvider) {
		this.facadeContextProvider = facadeContextProvider;
	}
	
	public void clearFacadeContextProvider(FacadeContextProvider<C> facadeContextProvider) {
		this.facadeContextProvider = null;
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
