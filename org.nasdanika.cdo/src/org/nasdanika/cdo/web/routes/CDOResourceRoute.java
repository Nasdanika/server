package org.nasdanika.cdo.web.routes;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOResourceRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final CDOResource cdoResource = (CDOResource) context.getTarget();
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(cdoResource, "read")) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(cdoResource, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete, update
			
			return Action.NOT_FOUND;
		} 

		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(cdoResource)+".html", StringEscapeUtils.escapeHtml4(cdoResource.getName()));
		
		String objId = context.getPath()[1];
		int idx = objId.lastIndexOf('.');
		if (idx!=-1) {
			objId = objId.substring(0, idx);
		}
		
		if (Character.isDigit(objId.charAt(0))) {
			// Index in content
			return context.getAction(cdoResource.getContents().get(Integer.parseInt(objId)), 1);
		}
		
		// CDO ID / uriFragment
		EObject eObj = cdoResource.getEObject(objId);
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
