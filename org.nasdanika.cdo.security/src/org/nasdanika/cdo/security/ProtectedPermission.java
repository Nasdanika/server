/**
 */
package org.nasdanika.cdo.security;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;

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
 * @model annotation="org.nasdanika.cdo.web.render icon='fa fa-key' sort='principal'"
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
	 * @model required="true"
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Validates element.
	 * @param diagnostics Diagnostics to add validation messages to.
	 * @param context Validation context.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ProtectedPermission
