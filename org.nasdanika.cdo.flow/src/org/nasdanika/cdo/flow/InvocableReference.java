/**
 */
package org.nasdanika.cdo.flow;

import org.nasdanika.core.Context;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.InvocableReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getInvocableReference()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface InvocableReference<R, C extends Context> extends Invocable<R, C> {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Invocable)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getInvocableReference_Target()
	 * @model
	 * @generated
	 */
	Invocable<R, C> getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.InvocableReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Invocable<R, C> value);

} // InvocableReference
