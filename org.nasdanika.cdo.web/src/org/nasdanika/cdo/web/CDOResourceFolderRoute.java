package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.json.JSONArray;
import org.nasdanika.web.Action;
import org.nasdanika.web.Context;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;

public class CDOResourceFolderRoute implements Route {

	@Override
	public Action navigate(final Context context) throws Exception {
		final CDOResourceFolder folder = (CDOResourceFolder) context.getTarget();
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
						for (CDOResourceNode n: folder.getNodes()) {
							ret.put(n.getName());
						}
						return ret;
					}
					
				};
			}
			return Action.NOT_FOUND;
		} 
		for (CDOResourceNode n: folder.getNodes()) {
			if (context.getPath()[1].equals(n.getName())) {
				return context.getAction(n, 1);
			}
		}
		return Action.NOT_FOUND;
	}

}
