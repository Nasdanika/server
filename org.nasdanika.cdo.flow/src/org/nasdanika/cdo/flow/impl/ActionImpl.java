/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.flow.Action;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.ActionImpl#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ActionImpl<R, C extends Context> extends CDOObjectImpl implements Action<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<String, Invocable> getOutputs() {
		return (EMap<String, Invocable>)eGet(FlowPackage.Literals.ACTION__OUTPUTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R invoke(C context, EList<Object> arguments) throws Exception {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean accept(C context, EList<Object> arguments) throws Exception {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlowPackage.ACTION___INVOKE__CONTEXT_ELIST:
				try {
					return invoke((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.ACTION___ACCEPT__CONTEXT_ELIST:
				try {
					return accept((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //ActionImpl
