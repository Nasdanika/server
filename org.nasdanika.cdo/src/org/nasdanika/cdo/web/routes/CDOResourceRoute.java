package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.web.Action;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;

public class CDOResourceRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final CDOResource cdoResource = (CDOResource) context.getTarget();
		if (context.getPath().length==1) {
			if (RequestMethod.GET.equals(context.getMethod())) {
				return new Action() {
	
					@Override
					public void close() throws Exception {
						// NOP						
					}
	
					@Override
					public Object execute() throws Exception {
						JSONArray ret = new JSONArray();
						for (EObject e: cdoResource.getContents()) {
							ret.put(context.convert(e, JSONObject.class));
						}
						return ret;
					}
					
				};
			} else if (RequestMethod.POST.equals(context.getMethod())) {
				// TODO - create EObject and put it to content. 
			}
			return Action.NOT_FOUND;
		}
		
		if (Character.isDigit(context.getPath()[1].charAt(0))) {
			// Index in content
			return context.getAction(cdoResource.getContents().get(Integer.parseInt(context.getPath()[1])), 1);
		}
		
		// CDO ID / uriFragment
		EObject eObj = cdoResource.getEObject(context.getPath()[1]);
		if (eObj==null) {
			return Action.NOT_FOUND;
		}
		return context.getAction(eObj, 1);
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
