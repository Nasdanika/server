package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class EAttributeClosure<O extends EObject> implements EStructuralFeatureClosure<O, EAttribute> {

	private EAttribute attr;
	private O obj;

	public EAttributeClosure(O obj, EAttribute attr) {
		super();
		this.obj = obj;
		this.attr = attr;
	}

	@Override
	public O getObject() {
		return obj;
	}

	@Override
	public EAttribute getFeature() {
		return attr;
	}

	@Override
	public Object getValue() {
		return obj.eGet(attr);
	}

}
