package org.nasdanika.cdo.web.routes;

import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class EReferenceClosureRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final EReferenceClosure<?> eReferenceClosure = (EReferenceClosure<?>) context.getTarget();
		
		// Handle many
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(eReferenceClosure.getObject(), "read", "feature/"+eReferenceClosure.getFeature().getName(), null)) {					
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(eReferenceClosure, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete - clear, post - add(many)/set(one) - return path - authorize, use CDOWebUtil
			
			return Action.NOT_FOUND;
		} 

		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(eReferenceClosure)+".html", context.toHTML(eReferenceClosure, "label", null));

		if (eReferenceClosure.getFeature().isMany()) {		
			String index = context.getPath()[1];
			int idx = index.lastIndexOf('.');
			if (idx!=-1) {
				index = index.substring(0, idx);
			}
									
			List<?> value = (List<?>) eReferenceClosure.getValue();
			// TODO - DELETE - remove, PUT - set, return path, authorize
			// EMap - try as a key first
			if (value instanceof EMap) {				
				Object element = ((EMap<?,?>) value).get(index);
				if (element!=null) {
					return context.getAction(element, 1);
				}
			}
			Object element = value.get(Integer.parseInt(index));
			return context.getAction(element, 1);
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
