/**
 */
package org.nasdanika.cdo.promise.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.promise.Promise;
import org.nasdanika.cdo.promise.PromisePackage;
import org.nasdanika.cdo.promise.PromiseState;
import org.nasdanika.cdo.scheduler.Scheduler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Promise</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.promise.impl.PromiseImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.impl.PromiseImpl#getThens <em>Thens</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.impl.PromiseImpl#getState <em>State</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.impl.PromiseImpl#getFulfillmentValue <em>Fulfillment Value</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.impl.PromiseImpl#getRejectionReason <em>Rejection Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PromiseImpl<CR, F, R, N> extends CDOObjectImpl implements Promise<CR, F, R, N> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PromiseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PromisePackage.Literals.PROMISE;
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
	public EList<Promise<CR, ?, ?, ?>> getChildren() {
		return (EList<Promise<CR, ?, ?, ?>>)eGet(PromisePackage.Literals.PROMISE__CHILDREN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Promise<CR, ?, ?, ?>> getThens() {
		return (EList<Promise<CR, ?, ?, ?>>)eGet(PromisePackage.Literals.PROMISE__THENS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseState getState() {
		return (PromiseState)eGet(PromisePackage.Literals.PROMISE__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(PromiseState newState) {
		eSet(PromisePackage.Literals.PROMISE__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getFulfillmentValue() {
		return (EObject)eGet(PromisePackage.Literals.PROMISE__FULFILLMENT_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFulfillmentValue(EObject newFulfillmentValue) {
		eSet(PromisePackage.Literals.PROMISE__FULFILLMENT_VALUE, newFulfillmentValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRejectionReason() {
		return (EObject)eGet(PromisePackage.Literals.PROMISE__REJECTION_REASON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRejectionReason(EObject newRejectionReason) {
		eSet(PromisePackage.Literals.PROMISE__REJECTION_REASON, newRejectionReason);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TR> Promise<CR, F, TR, N> timeout(Scheduler<CR, CDOObject> scheduler, long timeout, TimeUnit timeUnit, TR reason) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Promise<CR, F, R, N> delay(Scheduler<CR, CDOObject> scheduler, long delay, TimeUnit timeUnit) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void resolve(F value) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void reject(R reason) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notify(N progress) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <TF, TR, TN> Promise<CR, TF, TR, TN> then(CDOTransactionContextCommand<CR, ? super F, TF> onFulfill, CDOTransactionContextCommand<CR, ? super R, TR> onReject, CDOTransactionContextCommand<CR, ? super N, TN> onNotify) {
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
			case PromisePackage.PROMISE___TIMEOUT__SCHEDULER_LONG_TIMEUNIT_OBJECT:
				return timeout((Scheduler<CR, CDOObject>)arguments.get(0), (Long)arguments.get(1), (TimeUnit)arguments.get(2), arguments.get(3));
			case PromisePackage.PROMISE___DELAY__SCHEDULER_LONG_TIMEUNIT:
				return delay((Scheduler<CR, CDOObject>)arguments.get(0), (Long)arguments.get(1), (TimeUnit)arguments.get(2));
			case PromisePackage.PROMISE___RESOLVE__OBJECT:
				resolve((F)arguments.get(0));
				return null;
			case PromisePackage.PROMISE___REJECT__OBJECT:
				reject((R)arguments.get(0));
				return null;
			case PromisePackage.PROMISE___NOTIFY__OBJECT:
				notify((N)arguments.get(0));
				return null;
			case PromisePackage.PROMISE___THEN__CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND:
				return then((CDOTransactionContextCommand)arguments.get(0), (CDOTransactionContextCommand)arguments.get(1), (CDOTransactionContextCommand)arguments.get(2));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PromiseImpl
