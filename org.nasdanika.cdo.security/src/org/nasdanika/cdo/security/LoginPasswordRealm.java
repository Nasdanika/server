/**
 */
package org.nasdanika.cdo.security;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Login Password Protection Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Realm which supports user authentication with user name and password.
 * <!-- end-model-doc -->
 *
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getLoginPasswordRealm()
 * @model abstract="true" superTypes="org.nasdanika.cdo.security.Realm&lt;org.nasdanika.cdo.security.LoginPasswordCredentials&gt;"
 * @generated
 */
public interface LoginPasswordRealm extends Realm<LoginPasswordCredentials> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets user password hash.
	 * @param user User to set password hash.
	 * @param password Password to compute password hash from.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void setPasswordHash(LoginPasswordHashUser user, String password);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * finds user by login name.
	 * @param login User login.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	LoginPasswordHashUser getUser(String login);
} // LoginPasswordRealm
