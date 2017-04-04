/**
 */
package org.nasdanika.cdo.security.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.PrincipalPermission;
import org.nasdanika.cdo.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Principal Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.PrincipalPermissionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrincipalPermissionImpl extends PermissionImpl implements PrincipalPermission {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrincipalPermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.PRINCIPAL_PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(SecurityPackage.Literals.PRINCIPAL_PERMISSION__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(SecurityPackage.Literals.PRINCIPAL_PERMISSION__TARGET, newTarget);
	}
	
	@Override
	public Principal getPrincipal() {
		return (Principal) eContainer();
	}

} //PrincipalPermissionImpl
