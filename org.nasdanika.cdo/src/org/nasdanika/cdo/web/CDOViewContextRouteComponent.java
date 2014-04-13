package org.nasdanika.cdo.web;

import org.nasdanika.cdo.CDOViewContextProvider;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOViewContextRouteComponent implements Route {

	private CDOViewContextProvider contextProvider;
	
	public void setContextProvider(CDOViewContextProvider contextProvider) {
		this.contextProvider = contextProvider;
	}
	
	public void clearContextProvider(CDOViewContextProvider contextProvider) {
		this.contextProvider = null;
	}

	@Override
	public Action execute(WebContext context) throws Exception {
		if (context instanceof HttpContextImpl) {
			HttpContextImpl httpContext = (HttpContextImpl) context;
			try (CDOViewHttpContextImpl cdoViewContext = new CDOViewHttpContextImpl(
					httpContext.getPrincipal(), 
					httpContext.getPath(), 
					httpContext.getTarget(), 
					httpContext.getExtensionManager(), 
					httpContext.getRequest(), 
					httpContext.getResponse(), 
					contextProvider.createContext())) {
			
				try (Action action = cdoViewContext.getAction(cdoViewContext.getView(), 0)) {
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
