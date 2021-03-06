package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.nasdanika.web.Action;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;

public class ResourceRoute implements Route {

	@Override
	public Action execute(final HttpServletRequestContext context, Object... args) throws Exception {
		final Resource resource = (Resource) context.getTarget();
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorizeRead(resource, null, null)) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(resource, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete, update
			
			return Action.NOT_FOUND;
		} 
		
		String objId = context.getPath()[1];
		int idx = objId.lastIndexOf('.');
		if (idx!=-1) {
			objId = objId.substring(0, idx);
		}
		
		if (Character.isDigit(objId.charAt(0))) {
			// Index in content
			return context.getAction(resource.getContents().get(Integer.parseInt(objId)), 1, null, context.getPath()[1]);
		}
		
		// CDO ID / uriFragment
		EObject eObj = resource.getEObject(objId);
		if (eObj==null) {
			return Action.NOT_FOUND;
		}
		return context.getAction(eObj, 1, null, context.getPath()[1]);
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
