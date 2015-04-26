/**
 */
package org.nasdanika.cdo.promise;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.scheduler.Scheduler;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Promise</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.promise.Promise#getChildren <em>Children</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.Promise#getThens <em>Thens</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.Promise#getState <em>State</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.Promise#getFulfillmentValue <em>Fulfillment Value</em>}</li>
 *   <li>{@link org.nasdanika.cdo.promise.Promise#getRejectionReason <em>Rejection Reason</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.promise.PromisePackage#getPromise()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Promise<CR, F, R, N> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.promise.Promise}&lt;CR, ?, ?, ?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.cdo.promise.PromisePackage#getPromise_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Promise<CR, ?, ?, ?>> getChildren();

	/**
	 * Returns the value of the '<em><b>Thens</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.promise.Promise}&lt;CR, ?, ?, ?>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thens</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thens</em>' containment reference list.
	 * @see org.nasdanika.cdo.promise.PromisePackage#getPromise_Thens()
	 * @model containment="true"
	 * @generated
	 */
	EList<Promise<CR, ?, ?, ?>> getThens();

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.nasdanika.cdo.promise.PromiseState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.nasdanika.cdo.promise.PromiseState
	 * @see #setState(PromiseState)
	 * @see org.nasdanika.cdo.promise.PromisePackage#getPromise_State()
	 * @model
	 * @generated
	 */
	PromiseState getState();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.promise.Promise#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.nasdanika.cdo.promise.PromiseState
	 * @see #getState()
	 * @generated
	 */
	void setState(PromiseState value);

	/**
	 * Returns the value of the '<em><b>Fulfillment Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fulfillment Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fulfillment Value</em>' containment reference.
	 * @see #setFulfillmentValue(EObject)
	 * @see org.nasdanika.cdo.promise.PromisePackage#getPromise_FulfillmentValue()
	 * @model containment="true"
	 * @generated
	 */
	EObject getFulfillmentValue();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.promise.Promise#getFulfillmentValue <em>Fulfillment Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fulfillment Value</em>' containment reference.
	 * @see #getFulfillmentValue()
	 * @generated
	 */
	void setFulfillmentValue(EObject value);

	/**
	 * Returns the value of the '<em><b>Rejection Reason</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rejection Reason</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rejection Reason</em>' containment reference.
	 * @see #setRejectionReason(EObject)
	 * @see org.nasdanika.cdo.promise.PromisePackage#getPromise_RejectionReason()
	 * @model containment="true"
	 * @generated
	 */
	EObject getRejectionReason();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.promise.Promise#getRejectionReason <em>Rejection Reason</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rejection Reason</em>' containment reference.
	 * @see #getRejectionReason()
	 * @generated
	 */
	void setRejectionReason(EObject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model schedulerDataType="org.nasdanika.cdo.promise.Scheduler<CR, org.nasdanika.cdo.promise.CDOObject>" timeUnitDataType="org.nasdanika.cdo.promise.TimeUnit"
	 * @generated
	 */
	<TR> Promise<CR, F, TR, N> timeout(Scheduler<CR, CDOObject> scheduler, long timeout, TimeUnit timeUnit, TR reason);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model schedulerDataType="org.nasdanika.cdo.promise.Scheduler<CR, org.nasdanika.cdo.promise.CDOObject>" timeUnitDataType="org.nasdanika.cdo.promise.TimeUnit"
	 * @generated
	 */
	Promise<CR, F, R, N> delay(Scheduler<CR, CDOObject> scheduler, long delay, TimeUnit timeUnit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void resolve(F value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reject(R reason);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void notify(N progress);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model onFulfillDataType="org.nasdanika.cdo.promise.CDOTransactionContextCommand<CR, ? super F, TF>" onRejectDataType="org.nasdanika.cdo.promise.CDOTransactionContextCommand<CR, ? super R, TR>" onNotifyDataType="org.nasdanika.cdo.promise.CDOTransactionContextCommand<CR, ? super N, TN>"
	 * @generated
	 */
	<TF, TR, TN> Promise<CR, TF, TR, TN> then(CDOTransactionContextCommand<CR, ? super F, TF> onFulfill, CDOTransactionContextCommand<CR, ? super R, TR> onReject, CDOTransactionContextCommand<CR, ? super N, TN> onNotify);

} // Promise
