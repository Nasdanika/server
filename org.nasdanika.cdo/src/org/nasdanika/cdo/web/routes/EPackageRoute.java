package org.nasdanika.cdo.web.routes;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.ecore.EPackage;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class EPackageRoute implements Route {

	@Override
	public Action execute(WebContext context) throws Exception {
		final EPackage ePackage = (EPackage) context.getTarget();
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(ePackage, "read", null, null)) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(ePackage, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			return Action.NOT_FOUND;
		} 
		
		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(ePackage)+".html", StringEscapeUtils.escapeHtml4(ePackage.getName()));

		String className = context.getPath()[1];
		int idx = className.lastIndexOf('.');
		if (idx!=-1) {
			className = className.substring(0, idx);
		}
		return context.getAction(ePackage.getEClassifier(className), 1);
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
