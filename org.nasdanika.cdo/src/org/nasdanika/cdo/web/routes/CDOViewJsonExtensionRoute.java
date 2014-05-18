package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.json.JSONArray;
import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOViewJsonExtensionRoute implements Route {

	@Override
	public Action execute(WebContext context) throws Exception {
		CDOView view = (CDOView) context.getTarget();
		
		final JSONArray viewInfo = new JSONArray();
		for (CDOResourceNode e: view.getElements()) {
			viewInfo.put(e.getName());
		}
		
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
