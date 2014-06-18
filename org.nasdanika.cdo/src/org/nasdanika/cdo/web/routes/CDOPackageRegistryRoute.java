package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.common.model.CDOPackageInfo;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.json.JSONArray;
import org.nasdanika.web.Action;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.ProcessingError;
import org.nasdanika.web.Route;

public class CDOPackageRegistryRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final CDOPackageRegistry registry = (CDOPackageRegistry) context.getTarget();
		if (context.getPath().length==1) {
			return new Action() {
				
				@Override
				public void close() throws Exception {
					// NOP					
				}
				
				@Override
				public Object execute() throws Exception {
					if (context.authorize(registry, "read", null, null)) {
						JSONArray piArray = new JSONArray();
						for (CDOPackageInfo pi: registry.getPackageInfos()) {
							piArray.put(pi.getPackageURI());
						}
						return piArray;
					}
					return ProcessingError.FORBIDDEN;
				}
			}; 
		}
		
		int idx = Integer.parseInt(context.getPath()[1]);
		CDOPackageInfo pi = registry.getPackageInfos()[idx];
		return context.getAction(pi.getEPackage(), 1);
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
