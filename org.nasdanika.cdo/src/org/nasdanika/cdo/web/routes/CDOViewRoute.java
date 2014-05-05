package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.web.CDOTransactionHttpContext;
import org.nasdanika.cdo.web.CDOViewHttpContext;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOViewRoute implements Route {

	@Override
	public Action execute(WebContext context) throws Exception {
		CDOView view;
		if (context instanceof CDOViewHttpContext) {
			view = ((CDOViewHttpContext) context).getView();
		} else if (context instanceof CDOTransactionHttpContext) {
			view = ((CDOTransactionHttpContext) context).getTransaction();
		} else {
			return Action.INTERNAL_SERVER_ERROR;
		}
		
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(view, "read")) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(view, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			return Action.NOT_FOUND;
		} 
		
		if ("$packageRegistry".equals(context.getPath()[1])) {
			Action prAction = context.getAction(view.getSession().getPackageRegistry(), 1);
			return prAction==null ? Action.NOT_FOUND : prAction;
		}
		
		for (CDOResourceNode e: view.getElements()) {
			if (e.getName().equals(context.getPath()[1])) {
				final Action eAction = context.getAction(e, 1);
				return eAction==null ? Action.NOT_FOUND : eAction;
			}
		}
		
		return Action.NOT_FOUND;
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
