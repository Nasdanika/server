/**
 */
package org.nasdanika.examples.bank;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.cdo.security.User;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.Customer#getAccounts <em>Accounts</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Customer#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Customer#getLogin <em>Login</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Customer#getPasswordHash <em>Password Hash</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends User {
	/**
	 * Returns the value of the '<em><b>Accounts</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.examples.bank.Account}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accounts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accounts</em>' containment reference list.
	 * @see org.nasdanika.examples.bank.BankPackage#getCustomer_Accounts()
	 * @model containment="true"
	 * @generated
	 */
	EList<Account> getAccounts();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getCustomer_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Customer#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Login</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Login</em>' attribute.
	 * @see #setLogin(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getCustomer_Login()
	 * @model id="true"
	 * @generated
	 */
	String getLogin();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Customer#getLogin <em>Login</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Login</em>' attribute.
	 * @see #getLogin()
	 * @generated
	 */
	void setLogin(String value);

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
	 * @see org.nasdanika.examples.bank.BankPackage#getCustomer_PasswordHash()
	 * @model
	 * @generated
	 */
	byte[] getPasswordHash();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Customer#getPasswordHash <em>Password Hash</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password Hash</em>' attribute.
	 * @see #getPasswordHash()
	 * @generated
	 */
	void setPasswordHash(byte[] value);
	
	/**
	 * Computes password hash from login and password. This method must be 
	 * invoked after login name is set.
	 * @param password
	 */
	void setPassword(String password) throws Exception;

} // Customer
