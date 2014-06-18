package org.nasdanika.cdo.web.routes;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class CDOResourceFolderRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final CDOResourceFolder folder = (CDOResourceFolder) context.getTarget();
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(folder, "read", null, null)) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(folder, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete, update
			
			return Action.NOT_FOUND;
		} 
		
		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(folder)+".html", StringEscapeUtils.escapeHtml4(folder.getName()));
		
		for (CDOResourceNode n: folder.getNodes()) {
			if (context.getPath()[1].equals(n.getName())) {
				return context.getAction(n, 1);
			}
			
			// TODO - create resource in folder.
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
