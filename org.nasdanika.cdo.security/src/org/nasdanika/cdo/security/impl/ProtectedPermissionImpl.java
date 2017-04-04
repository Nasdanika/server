/**
 */
package org.nasdanika.cdo.security.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectedPermission;
import org.nasdanika.cdo.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protected Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.ProtectedPermissionImpl#getPrincipal <em>Principal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtectedPermissionImpl extends PermissionImpl implements ProtectedPermission {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProtectedPermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.PROTECTED_PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Principal getPrincipal() {
		return (Principal)eGet(SecurityPackage.Literals.PROTECTED_PERMISSION__PRINCIPAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrincipal(Principal newPrincipal) {
		eSet(SecurityPackage.Literals.PROTECTED_PERMISSION__PRINCIPAL, newPrincipal);
	}
	
	@Override
	public EObject getTarget() {
		return eContainer();
	}

} //ProtectedPermissionImpl
