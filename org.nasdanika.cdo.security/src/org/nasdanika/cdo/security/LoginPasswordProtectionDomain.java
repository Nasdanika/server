/**
 */
package org.nasdanika.cdo.security;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Login Password Protection Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getLoginPasswordProtectionDomain()
 * @model abstract="true" superTypes="org.nasdanika.cdo.security.ProtectionDomain<org.nasdanika.cdo.security.LoginPasswordCredentials>"
 * @generated
 */
public interface LoginPasswordProtectionDomain extends ProtectionDomain<LoginPasswordCredentials> {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setPasswordHash(LoginPasswordHashUser user, String password);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	User getUser(String login);
} // LoginPasswordProtectionDomain
