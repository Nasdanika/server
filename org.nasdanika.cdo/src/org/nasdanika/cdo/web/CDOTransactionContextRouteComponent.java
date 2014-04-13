package org.nasdanika.cdo.web;

import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOTransactionContextRouteComponent implements Route {
	
	private CDOTransactionContextProvider contextProvider;
	
	public void setContextProvider(CDOTransactionContextProvider contextProvider) {
		this.contextProvider = contextProvider;
	}
	
	public void clearContextProvider(CDOTransactionContextProvider contextProvider) {
		this.contextProvider = null;
	}

	@Override
	public Action execute(WebContext context) throws Exception {
		if (context instanceof HttpContextImpl) {
			HttpContextImpl httpContext = (HttpContextImpl) context;
			try (CDOTransactionHttpContextImpl cdoTransactionContext = new CDOTransactionHttpContextImpl(
					httpContext.getPrincipal(), 
					httpContext.getPath(), 
					httpContext.getTarget(), 
					httpContext.getExtensionManager(), 
					httpContext.getRequest(), 
					httpContext.getResponse(), 
					contextProvider.createContext())) {
				
				try (Action action = cdoTransactionContext.getAction(cdoTransactionContext.getTransaction(), 0)) {
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
