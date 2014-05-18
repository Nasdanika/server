package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.cdo.common.model.CDOPackageInfo;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.cdo.util.NasdanikaCDOUtil;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOViewRoute implements Route {

	@Override
	public Action execute(WebContext context) throws Exception {
		CDOView view = (CDOView) context.getTarget();
		
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
		
		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(view)+".html", "CDO View");
		
		if ("packages".equals(context.getPath()[1])) {
			String nsURI = (String) context.getSessionStore().get(NasdanikaCDOUtil.stripExtension(context.getPath()[2]));
			EPackage ePackage = view.getSession().getPackageRegistry().getEPackage(nsURI);
			if (ePackage == null) {
				// put packages to store
				for (CDOPackageInfo pi: view.getSession().getPackageRegistry().getPackageInfos()) {
					context.getSessionStore().put(pi.getEPackage().getNsURI());
				}
				nsURI = (String) context.getSessionStore().get(NasdanikaCDOUtil.stripExtension(context.getPath()[2]));
				ePackage = view.getSession().getPackageRegistry().getEPackage(nsURI);
				if (ePackage == null) {
					return Action.NOT_FOUND;
				}
			}
			Action prAction = context.getAction(ePackage, 2);
			return prAction==null ? Action.NOT_FOUND : prAction;
		}
		
		if ("elements".equals(context.getPath()[1])) {
			for (CDOResourceNode e: view.getElements()) {
				if (e.getName().equals(NasdanikaCDOUtil.stripExtension(context.getPath()[2]))) {
					final Action eAction = context.getAction(e, 2);
					return eAction==null ? Action.NOT_FOUND : eAction;
				}
			}	
			
			// TODO - create resources.
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
