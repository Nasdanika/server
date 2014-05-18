package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class EReferenceClosure<O extends EObject> implements EStructuralFeatureClosure<O, EReference> {

	private EReference ref;
	private O obj;

	public EReferenceClosure(O obj, EReference ref) {
		super();
		this.obj = obj;
		this.ref = ref;
	}

	@Override
	public O getObject() {
		return obj;
	}

	@Override
	public EReference getFeature() {
		return ref;
	}

	@Override
	public Object getValue() {
		return obj.eGet(ref);
	}
	
}
