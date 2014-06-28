/**
 */
package org.nasdanika.cdo.flow;

import org.nasdanika.core.Context;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Then Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.ThenReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getThenReference()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface ThenReference<R, R1, C extends Context> extends Then<R, R1, C> {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Then)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getThenReference_Target()
	 * @model
	 * @generated
	 */
	Then<R, R1, C> getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.ThenReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Then<R, R1, C> value);

} // ThenReference
