/**
 */
package org.nasdanika.cdo.security.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Login User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginUserImpl#getLogin <em>Login</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LoginUserImpl<CR> extends UserImpl<CR> implements LoginUser<CR> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoginUserImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.LOGIN_USER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLogin() {
		return (String)eGet(SecurityPackage.Literals.LOGIN_USER__LOGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogin(String newLogin) {
		eSet(SecurityPackage.Literals.LOGIN_USER__LOGIN, newLogin);
	}

} //LoginUserImpl
