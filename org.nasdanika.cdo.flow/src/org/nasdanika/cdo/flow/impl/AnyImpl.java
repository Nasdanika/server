/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.flow.Any;
import org.nasdanika.cdo.flow.Executor;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Promise;
import org.nasdanika.cdo.flow.PromiseState;
import org.nasdanika.cdo.flow.Then;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.AnyImpl#isDone <em>Done</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.AnyImpl#getExpires <em>Expires</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnyImpl<R, C extends Context> extends CDOObjectImpl implements Any<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.ANY;
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
	public boolean isDone() {
		return (Boolean)eGet(FlowPackage.Literals.PROMISE__DONE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDone(boolean newDone) {
		eSet(FlowPackage.Literals.PROMISE__DONE, newDone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getExpires() {
		return (Date)eGet(FlowPackage.Literals.PROMISE__EXPIRES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpires(Date newExpires) {
		eSet(FlowPackage.Literals.PROMISE__EXPIRES, newExpires);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void init(EList<Promise<R, C>> promises, Executor<C> executor) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R1> Promise<R1, C> then(Then<R, R1, C> then, C context, Executor<C> executor) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R getFulfillmentValue(C context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception getRejectionReason(C context) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseState getState() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean cancel() {
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
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlowPackage.ANY___INIT__ELIST_EXECUTOR:
				init((EList<Promise<R, C>>)arguments.get(0), (Executor<C>)arguments.get(1));
				return null;
			case FlowPackage.ANY___THEN__THEN_CONTEXT_EXECUTOR:
				return then((Then)arguments.get(0), (C)arguments.get(1), (Executor<C>)arguments.get(2));
			case FlowPackage.ANY___GET_FULFILLMENT_VALUE__CONTEXT:
				return getFulfillmentValue((C)arguments.get(0));
			case FlowPackage.ANY___GET_REJECTION_REASON__CONTEXT:
				return getRejectionReason((C)arguments.get(0));
			case FlowPackage.ANY___GET_STATE:
				return getState();
			case FlowPackage.ANY___CANCEL:
				return cancel();
		}
		return super.eInvoke(operationID, arguments);
	}

} //AnyImpl
