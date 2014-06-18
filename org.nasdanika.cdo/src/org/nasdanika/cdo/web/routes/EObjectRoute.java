package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.EAttributeClosure;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.RequestMethod;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

public class EObjectRoute implements Route {

	@Override
	public Action execute(final WebContext context) throws Exception {
		final EObject eObject = (EObject) context.getTarget();
		if (context.getPath().length==1) { 
			if (RequestMethod.GET.equals(context.getMethod())) {
				if (context.authorize(eObject, "read", null, null)) {
					int dotIdx = context.getPath()[0].lastIndexOf(".");
					String extension = dotIdx==-1 ? "json" : context.getPath()[0].substring(dotIdx+1); // json is "default" extension
					Action extensionAction = context.getExtensionAction(eObject, extension);
					return extensionAction==null ? Action.NOT_FOUND : extensionAction;
				} 
				return Action.FORBIDDEN;
			}
			
			// TODO - delete, update
			
			return Action.NOT_FOUND;
		} 

		// Router path
		context.addPathTraceEntry("#router/main"+context.getObjectPath(eObject)+".html", context.toHTML(eObject, "label", null));

		String featureName = context.getPath()[1];
		int idx = featureName.lastIndexOf('.');
		if (idx!=-1) {
			featureName = featureName.substring(0, idx);
		}

		// getStructuralFeature doesn't work for some reason
		for (EStructuralFeature sf: eObject.eClass().getEAllStructuralFeatures()) {
			if (featureName.equals(sf.getName())) {
				
			}
		}
		EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
		if (feature instanceof EReference) {
			return context.getAction(new EReferenceClosure<EObject>(eObject, (EReference) feature), 1);
		}
		if (feature instanceof EAttribute) {
			return context.getAction(new EAttributeClosure<EObject>(eObject, (EAttribute) feature), 1);
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
