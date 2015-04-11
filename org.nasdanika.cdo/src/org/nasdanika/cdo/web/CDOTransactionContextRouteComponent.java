package org.nasdanika.cdo.web;

import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.nasdanika.core.Context;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOTransactionContextRouteComponent<CR, MC extends Context> implements Route {
	
	private CDOTransactionContextProvider<CR> contextProvider;
	
	public void setContextProvider(CDOTransactionContextProvider<CR> contextProvider) {
		this.contextProvider = contextProvider;
	}
	
	public void clearContextProvider(CDOTransactionContextProvider<CR> contextProvider) {
		this.contextProvider = null;
	}

	@Override
	public Action execute(WebContext context, Object... args) throws Exception {
		if (context instanceof HttpContextImpl) {
			HttpContextImpl httpContext = (HttpContextImpl) context;
			try (CDOTransactionHttpContextImpl<CR> cdoTransactionContext = new CDOTransactionHttpContextImpl<CR>(
					httpContext.getPath(), 
					httpContext.getTarget(), 
					httpContext.getExtensionManager(), 
					httpContext,
					null, 
					httpContext.getRequest(), 
					httpContext.getResponse(), 
					httpContext.getContextURL(),
					null,
					contextProvider.createContext(context))) {
				
				try (Action action = cdoTransactionContext.getAction(cdoTransactionContext.getView(), 0)) {
					if (action == null) {
						return Action.NOT_FOUND;
					}
					
					final Object result = action.execute();
					return new Action() {
	
						@Override
						public void close() throws Exception {
							// NOP							
						}
	
						@Override
						public Object execute() throws Exception {
							return result;
						}
						
					};
				}
			}
			
		}
		throw new IllegalArgumentException("Unsupported context type: "+context);
	}

	@Override
	public boolean canExecute() {
		return contextProvider!=null;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
