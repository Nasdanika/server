package org.nasdanika.cdo.web.routes;

import java.util.List;

import org.nasdanika.cdo.EAttributeClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class EAttributeClosureRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final EAttributeClosure<?> eAttributeClosure = (EAttributeClosure<?>) context.getTarget();
		
		// Handle many
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(eAttributeClosure.getObject(), "read", "feature/"+eAttributeClosure.getFeature().getName(), null)) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(eAttributeClosure, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete, update
			
			return Action.NOT_FOUND;
		} 

		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(eAttributeClosure)+".html", context.toHTML(eAttributeClosure, "label", null));

		if (eAttributeClosure.getFeature().isMany()) {		
			String index = context.getPath()[1];
			int idx = index.lastIndexOf('.');
			if (idx!=-1) {
				index = index.substring(0, idx);
			}
			Object element = ((List<?>) eAttributeClosure.getValue()).get(Integer.parseInt(index));
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
