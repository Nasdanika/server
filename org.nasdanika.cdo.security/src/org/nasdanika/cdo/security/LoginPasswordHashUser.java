/**
 */
package org.nasdanika.cdo.security;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Login Password Hash User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.LoginPasswordHashUser#getPasswordHash <em>Password Hash</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getLoginPasswordHashUser()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LoginPasswordHashUser extends LoginUser {
	/**
	 * Returns the value of the '<em><b>Password Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Password Hash</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Password Hash</em>' attribute.
	 * @see #setPasswordHash(byte[])
	 * @see org.nasdanika.cdo.security.SecurityPackage#getLoginPasswordHashUser_PasswordHash()
	 * @model
	 * @generated
	 */
	byte[] getPasswordHash();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.LoginPasswordHashUser#getPasswordHash <em>Password Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Hash</em>' attribute.
	 * @see #getPasswordHash()
	 * @generated
	 */
	void setPasswordHash(byte[] value);

} // LoginPasswordHashUser
