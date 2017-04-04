/**
 */
package org.nasdanika.cdo.security;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protected Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Permission owned by a protected object to execute action by the referenced principal.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.ProtectedPermission#getPrincipal <em>Principal</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectedPermission()
 * @model
 * @generated
 */
public interface ProtectedPermission extends Permission {
	/**
	 * Returns the value of the '<em><b>Principal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Target object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Principal</em>' reference.
	 * @see #setPrincipal(Principal)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectedPermission_Principal()
	 * @model
	 * @generated
	 */
	Principal getPrincipal();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ProtectedPermission#getPrincipal <em>Principal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Principal</em>' reference.
	 * @see #getPrincipal()
	 * @generated
	 */
	void setPrincipal(Principal value);

} // ProtectedPermission
