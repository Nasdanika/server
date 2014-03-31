/**
 */
package org.nasdanika.examples.bank;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.ExternalTransaction#getProcessor <em>Processor</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.ExternalTransaction#getExternalAccount <em>External Account</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.ExternalTransaction#getExternalId <em>External Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getExternalTransaction()
 * @model
 * @generated
 */
public interface ExternalTransaction extends Transaction {
	/**
	 * Returns the value of the '<em><b>Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor</em>' attribute.
	 * @see #setProcessor(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getExternalTransaction_Processor()
	 * @model
	 * @generated
	 */
	String getProcessor();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.ExternalTransaction#getProcessor <em>Processor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor</em>' attribute.
	 * @see #getProcessor()
	 * @generated
	 */
	void setProcessor(String value);

	/**
	 * Returns the value of the '<em><b>External Account</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Account</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Account</em>' attribute.
	 * @see #setExternalAccount(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getExternalTransaction_ExternalAccount()
	 * @model
	 * @generated
	 */
	String getExternalAccount();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.ExternalTransaction#getExternalAccount <em>External Account</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Account</em>' attribute.
	 * @see #getExternalAccount()
	 * @generated
	 */
	void setExternalAccount(String value);

	/**
	 * Returns the value of the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Id</em>' attribute.
	 * @see #setExternalId(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getExternalTransaction_ExternalId()
	 * @model
	 * @generated
	 */
	String getExternalId();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.ExternalTransaction#getExternalId <em>External Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Id</em>' attribute.
	 * @see #getExternalId()
	 * @generated
	 */
	void setExternalId(String value);

} // ExternalTransaction
