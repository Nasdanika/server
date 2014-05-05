package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class EAttributeClosure implements EStructuralFeatureClosure<EObject, EAttribute> {

	private EAttribute attr;
	private EObject obj;

	public EAttributeClosure(EObject obj, EAttribute attr) {
		super();
		this.obj = obj;
		this.attr = attr;
	}

	@Override
	public EObject getObject() {
		return obj;
	}

	@Override
	public EAttribute getFeature() {
		return attr;
	}


}
