/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;
import org.nasdanika.cdo.flow.InvocableThen;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invocable Then</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.InvocableThenImpl#getOnFulfilled <em>On Fulfilled</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.InvocableThenImpl#getOnRejected <em>On Rejected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocableThenImpl<R, R1, C extends Context> extends CDOObjectImpl implements InvocableThen<R, R1, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvocableThenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.INVOCABLE_THEN;
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
	public Invocable<R1, C> getOnFulfilled() {
		return (Invocable<R1, C>)eGet(FlowPackage.Literals.INVOCABLE_THEN__ON_FULFILLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnFulfilled(Invocable<R1, C> newOnFulfilled) {
		eSet(FlowPackage.Literals.INVOCABLE_THEN__ON_FULFILLED, newOnFulfilled);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invocable<Exception, C> getOnRejected() {
		return (Invocable<Exception, C>)eGet(FlowPackage.Literals.INVOCABLE_THEN__ON_REJECTED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejected(Invocable<Exception, C> newOnRejected) {
		eSet(FlowPackage.Literals.INVOCABLE_THEN__ON_REJECTED, newOnRejected);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public R1 onFulfilled(R value, C context) throws Exception {
		return getOnFulfilled()==null ? (R1) value : getOnFulfilled().invoke(context, ECollections.<Object>singletonEList(value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Exception onRejected(Exception reason, C context) throws Exception {
		return getOnRejected()==null ? reason : onRejected(reason, context);
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
			case FlowPackage.INVOCABLE_THEN___ON_FULFILLED__OBJECT_CONTEXT:
				try {
					return onFulfilled((R)arguments.get(0), (C)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.INVOCABLE_THEN___ON_REJECTED__EXCEPTION_CONTEXT:
				try {
					return onRejected((Exception)arguments.get(0), (C)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //InvocableThenImpl
