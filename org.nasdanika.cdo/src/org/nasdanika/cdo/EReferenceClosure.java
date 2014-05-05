package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class EReferenceClosure implements EStructuralFeatureClosure<EObject, EReference> {

	private EReference ref;
	private EObject obj;

	public EReferenceClosure(EObject obj, EReference ref) {
		super();
		this.obj = obj;
		this.ref = ref;
	}

	@Override
	public EObject getObject() {
		return obj;
	}

	@Override
	public EReference getFeature() {
		return ref;
	}


}
