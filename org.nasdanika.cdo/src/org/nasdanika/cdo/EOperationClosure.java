package org.nasdanika.cdo;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

public class EOperationClosure<O extends EObject> {

	private EOperation op;
	private O obj;

	public EOperationClosure(O obj, EOperation op) {
		super();
		this.obj = obj;
		this.op = op;
	}

	public O getObject() {
		return obj;
	}

	public EOperation getOperation() {
		return op;
	}

	public Object invoke(EList<?> arguments) throws InvocationTargetException {
		return obj.eInvoke(op, arguments);
	}

}
