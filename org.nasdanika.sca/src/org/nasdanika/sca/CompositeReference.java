/**
 */
package org.nasdanika.sca;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.CompositeReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getCompositeReference()
 * @model
 * @generated
 */
public interface CompositeReference extends AbstractComponent {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Composite)
	 * @see org.nasdanika.sca.ScaPackage#getCompositeReference_Target()
	 * @model
	 * @generated
	 */
	Composite getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.CompositeReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Composite value);

} // CompositeReference
