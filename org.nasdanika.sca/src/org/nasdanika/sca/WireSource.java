/**
 */
package org.nasdanika.sca;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wire Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.WireSource#getWireTarget <em>Wire Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getWireSource()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface WireSource extends Wireable {
	/**
	 * Returns the value of the '<em><b>Wire Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wire Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wire Target</em>' reference.
	 * @see #setWireTarget(WireTarget)
	 * @see org.nasdanika.sca.ScaPackage#getWireSource_WireTarget()
	 * @model
	 * @generated
	 */
	WireTarget getWireTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.WireSource#getWireTarget <em>Wire Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wire Target</em>' reference.
	 * @see #getWireTarget()
	 * @generated
	 */
	void setWireTarget(WireTarget value);

} // WireSource
