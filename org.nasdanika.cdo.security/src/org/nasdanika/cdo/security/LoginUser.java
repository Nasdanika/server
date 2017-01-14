/**
 */
package org.nasdanika.cdo.security;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Login User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Login user is a principal identified by a login string. 
 * Login user does not necessarily have a password. The realm performs only authorization, with authentication already performed by other layers.
 * 
 * For example:
 * 
 * * A web application may transparently authenticate users against a Windows domain with Waffle or Apache NTML module. In this case the realm receives the name of already authenticated.
 * * Two-way certificate authentication - the realm receives cn of the client certificate.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.LoginUser#getLogin <em>Login</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getLoginUser()
 * @model abstract="true"
 * @generated
 */
public interface LoginUser<CR> extends User<CR> {
	/**
	 * Returns the value of the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A unique string identifying the user.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Login</em>' attribute.
	 * @see #setLogin(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getLoginUser_Login()
	 * @model id="true"
	 * @generated
	 */
	String getLogin();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.LoginUser#getLogin <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login</em>' attribute.
	 * @see #getLogin()
	 * @generated
	 */
	void setLogin(String value);

} // LoginUser
