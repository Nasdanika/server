/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Promise</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.Promise#isDone <em>Done</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getPromise()
 * @model interface="true" abstract="true" CBounds="org.nasdanika.cdo.flow.Context"
 * @extends CDOObject
 * @generated
 */
public interface Promise<R, C extends Context> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Done</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Done</em>' attribute.
	 * @see #setDone(boolean)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getPromise_Done()
	 * @model
	 * @generated
	 */
	boolean isDone();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.Promise#isDone <em>Done</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Done</em>' attribute.
	 * @see #isDone()
	 * @generated
	 */
	void setDone(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	<R1> Promise<R1, C> then(Then<R, R1, C> then, C context, Executor<C> executor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	R getFulfillmentValue(C context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.cdo.flow.Exception"
	 * @generated
	 */
	Exception getRejectionReason(C context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	PromiseState getState();

} // Promise
