/**
 */
package org.nasdanika.examples.bank;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.Account#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Account#getProduct <em>Product</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Account#getNumber <em>Number</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Account#getBalance <em>Balance</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Account#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Account#getPeriodStart <em>Period Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getAccount()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Account extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.examples.bank.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see org.nasdanika.examples.bank.BankPackage#getAccount_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

	/**
	 * Returns the value of the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product</em>' reference.
	 * @see #setProduct(Product)
	 * @see org.nasdanika.examples.bank.BankPackage#getAccount_Product()
	 * @model
	 * @generated
	 */
	Product getProduct();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Account#getProduct <em>Product</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product</em>' reference.
	 * @see #getProduct()
	 * @generated
	 */
	void setProduct(Product value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getAccount_Number()
	 * @model id="true"
	 * @generated
	 */
	String getNumber();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Account#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(String value);

	/**
	 * Returns the value of the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Balance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balance</em>' attribute.
	 * @see #setBalance(BigDecimal)
	 * @see org.nasdanika.examples.bank.BankPackage#getAccount_Balance()
	 * @model
	 * @generated
	 */
	BigDecimal getBalance();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Account#getBalance <em>Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balance</em>' attribute.
	 * @see #getBalance()
	 * @generated
	 */
	void setBalance(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getAccount_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Account#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);
	
	/**
	 * Returns the value of the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period Start</em>' attribute.
	 * @see #setPeriodStart(int)
	 * @see org.nasdanika.examples.bank.BankPackage#getAccount_PeriodStart()
	 * @model
	 * @generated
	 */
	int getPeriodStart();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Account#getPeriodStart <em>Period Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Start</em>' attribute.
	 * @see #getPeriodStart()
	 * @generated
	 */
	void setPeriodStart(int value);

	// --- Transfer methods ---
//	Transaction transfer(
//			TransactionType type,
//			Account otherAccount,
//			BigDecimal amount,
//			String comment);
	
	ExternalTransaction transfer(
			TransactionType type,
			PaymentProcessor processor,
			String externalAccount,
			Date date,
			BigDecimal amount,
			String comment);

} // Account
