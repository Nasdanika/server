package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.Route;

public class CDOViewJsonExtensionRoute implements Route {

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {
		CDOView view = (CDOView) context.getTarget();
		
		
		// TODO Security checks
		final JSONObject viewInfo = new JSONObject();
		
		JSONArray elementsInfo = new JSONArray();
		for (CDOResourceNode e: view.getElements()) {
			elementsInfo.put(e.getName());
		}
		viewInfo.put("elements", elementsInfo);
		
		JSONObject packagesInfo = new JSONObject();
		for (String pi: view.getSession().getPackageRegistry().keySet()) {
			packagesInfo.put(pi, context.getSessionStore().put(pi));
		}
		viewInfo.put("packages", packagesInfo);
		
		return new Action() {

			@Override
			public Object execute() throws Exception {						
				return viewInfo;
			}

			@Override
			public void close() throws Exception {
				// NOP.					
			}
			
		};
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
