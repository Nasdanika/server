package org.nasdanika.cdo.web.routes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.EAttributeClosure;
import org.nasdanika.cdo.EOperationClosure;
import org.nasdanika.cdo.EReferenceClosure;
import org.nasdanika.web.Action;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.routes.ObjectRoute;

public class EObjectRoute extends ObjectRoute {

	/**
	 * EObject route. Has feature, operation, resource, and code sub-routes.
	 */
	@Override
	public Action execute(final WebContext context) throws Exception {
		final EObject eObject = (EObject) context.getTarget();
										
		if (context.getPath().length>=2 && ("container".equals(context.getPath()[1]) || context.getPath()[1].startsWith("container.")) ) {
			return context.getAction(eObject.eContainer(), 1);
		}
		
		if (context.getPath().length>2) {
			switch (context.getPath()[1]) {			
			case "feature":
				String featureName = context.getPath()[2];
				int idx = featureName.lastIndexOf('.');
				if (idx!=-1) {
					featureName = featureName.substring(0, idx);
				}
		
				EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureName);
				if (feature instanceof EReference) {
					return context.getAction(new EReferenceClosure<EObject>(eObject, (EReference) feature), 2);
				}
				if (feature instanceof EAttribute) {
					return context.getAction(new EAttributeClosure<EObject>(eObject, (EAttribute) feature), 2);
				}
				return Action.NOT_FOUND;
			case "operation":
				String operationName = context.getPath()[2];
				for (EOperation op: eObject.eClass().getEAllOperations()) {
					if (operationName.equals(op.getName()) && op.getEParameters().size()<=context.getPath().length-3) {
						return context.getAction(new EOperationClosure<EObject>(eObject, op), 2);
					}
				}
				return Action.NOT_FOUND;
			}			
		}
		return super.execute(context);
	}

}
