/**
 */
package org.nasdanika.examples.bank;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.InternalTransaction#getOtherAccount <em>Other Account</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getInternalTransaction()
 * @model
 * @generated
 */
public interface InternalTransaction extends Transaction {
	/**
	 * Returns the value of the '<em><b>Other Account</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Other Account</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Account</em>' reference.
	 * @see #setOtherAccount(Account)
	 * @see org.nasdanika.examples.bank.BankPackage#getInternalTransaction_OtherAccount()
	 * @model
	 * @generated
	 */
	Account getOtherAccount();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.InternalTransaction#getOtherAccount <em>Other Account</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other Account</em>' reference.
	 * @see #getOtherAccount()
	 * @generated
	 */
	void setOtherAccount(Account value);

} // InternalTransaction
