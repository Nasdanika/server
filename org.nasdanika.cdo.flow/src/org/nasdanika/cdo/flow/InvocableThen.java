/**
 */
package org.nasdanika.cdo.flow;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocable Then</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.InvocableThen#getOnFulfilled <em>On Fulfilled</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.InvocableThen#getOnRejected <em>On Rejected</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getInvocableThen()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface InvocableThen<R, R1, C extends Context> extends Then<R, R1, C> {
	/**
	 * Returns the value of the '<em><b>On Fulfilled</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Fulfilled</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Fulfilled</em>' containment reference.
	 * @see #setOnFulfilled(Invocable)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getInvocableThen_OnFulfilled()
	 * @model containment="true"
	 * @generated
	 */
	Invocable<R1, C> getOnFulfilled();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.InvocableThen#getOnFulfilled <em>On Fulfilled</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Fulfilled</em>' containment reference.
	 * @see #getOnFulfilled()
	 * @generated
	 */
	void setOnFulfilled(Invocable<R1, C> value);

	/**
	 * Returns the value of the '<em><b>On Rejected</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Rejected</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Rejected</em>' containment reference.
	 * @see #setOnRejected(Invocable)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getInvocableThen_OnRejected()
	 * @model type="org.nasdanika.cdo.flow.Invocable<org.nasdanika.cdo.flow.Exception, C>" containment="true"
	 * @generated
	 */
	Invocable<Exception, C> getOnRejected();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.InvocableThen#getOnRejected <em>On Rejected</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Rejected</em>' containment reference.
	 * @see #getOnRejected()
	 * @generated
	 */
	void setOnRejected(Invocable<Exception, C> value);

} // InvocableThen
