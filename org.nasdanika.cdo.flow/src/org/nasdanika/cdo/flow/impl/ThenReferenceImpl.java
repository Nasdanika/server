/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Then;
import org.nasdanika.cdo.flow.ThenReference;

import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Then Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.ThenReferenceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThenReferenceImpl<R, R1, C extends Context> extends CDOObjectImpl implements ThenReference<R, R1, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThenReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.THEN_REFERENCE;
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
	public Then<R, R1, C> getTarget() {
		return (Then<R, R1, C>)eGet(FlowPackage.Literals.THEN_REFERENCE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Then<R, R1, C> newTarget) {
		eSet(FlowPackage.Literals.THEN_REFERENCE__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R1 onFulfilled(R value, C context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception onRejected(Exception reason, C context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object onFulfilled(Object value, ConverterContext context) {
		return getTarget().onFulfilled(value, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object onRejected(Object reason, ConverterContext context) {
		return getTarget().onRejected(reason, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object onNotified(Object progress, ConverterContext context) {
		return getTarget().onNotified(progress, context);
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
			case FlowPackage.THEN_REFERENCE___ON_FULFILLED__OBJECT_CONTEXT:
				return onFulfilled((R)arguments.get(0), (C)arguments.get(1));
			case FlowPackage.THEN_REFERENCE___ON_REJECTED__EXCEPTION_CONTEXT:
				return onRejected((Exception)arguments.get(0), (C)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ThenReferenceImpl
