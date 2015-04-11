package org.nasdanika.cdo.web;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.web.AbstractContextProviderAutocloseRouteComponent;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.WebContext;

public class CDOTransactionContextAutocloseRouteComponent<CR> extends AbstractContextProviderAutocloseRouteComponent<CDOTransactionContext<CR>, CDOTransactionHttpContextImpl<CR>> {

	@Override
	protected Action route(CDOTransactionHttpContextImpl<CR> mergedContext) throws Exception {
		try (Action action = mergedContext.getAction(mergedContext.getView(), 0)) {
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

	@Override
	protected CDOTransactionHttpContextImpl<CR> mergeContexts(WebContext webContext, CDOTransactionContext<CR> context) throws Exception {
		if (webContext instanceof HttpContextImpl) {
			HttpContextImpl httpContext = (HttpContextImpl) webContext;
			CDOTransactionHttpContextImpl<CR> mergedContext = new CDOTransactionHttpContextImpl<CR>(
					httpContext.getPath(), 
					httpContext.getTarget(), 
					httpContext.getExtensionManager(), 
					httpContext,
					null,
					httpContext.getRequest(), 
					httpContext.getResponse(), 
					httpContext.getContextURL(),
					null,
					context);
						
			String viewPath = httpContext.getPath()[0];
			int idx = viewPath.lastIndexOf('.');
			if (idx!=-1) {
				viewPath = viewPath.substring(0, idx);
			}
			
			mergedContext.getRootObjectsPaths().put(context.getView(), httpContext.getContextURL()+"/"+viewPath);

			return mergedContext;
		}
		throw new IllegalArgumentException("Unsupported context type: "+context);										
	}

}
