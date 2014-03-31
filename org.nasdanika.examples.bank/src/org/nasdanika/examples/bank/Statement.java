/**
 */
package org.nasdanika.examples.bank;

import java.math.BigDecimal;

import java.util.Date;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.Statement#getTransactions <em>Transactions</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Statement#getOpeningBalance <em>Opening Balance</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Statement#getOpeningDate <em>Opening Date</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Statement#getClosingBalance <em>Closing Balance</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.Statement#getClosingDate <em>Closing Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getStatement()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Statement extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Transactions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.examples.bank.Transaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transactions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transactions</em>' containment reference list.
	 * @see org.nasdanika.examples.bank.BankPackage#getStatement_Transactions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transaction> getTransactions();

	/**
	 * Returns the value of the '<em><b>Opening Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opening Balance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opening Balance</em>' attribute.
	 * @see #setOpeningBalance(BigDecimal)
	 * @see org.nasdanika.examples.bank.BankPackage#getStatement_OpeningBalance()
	 * @model
	 * @generated
	 */
	BigDecimal getOpeningBalance();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Statement#getOpeningBalance <em>Opening Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opening Balance</em>' attribute.
	 * @see #getOpeningBalance()
	 * @generated
	 */
	void setOpeningBalance(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Opening Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opening Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opening Date</em>' attribute.
	 * @see #setOpeningDate(Date)
	 * @see org.nasdanika.examples.bank.BankPackage#getStatement_OpeningDate()
	 * @model
	 * @generated
	 */
	Date getOpeningDate();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Statement#getOpeningDate <em>Opening Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opening Date</em>' attribute.
	 * @see #getOpeningDate()
	 * @generated
	 */
	void setOpeningDate(Date value);

	/**
	 * Returns the value of the '<em><b>Closing Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closing Balance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closing Balance</em>' attribute.
	 * @see #setClosingBalance(BigDecimal)
	 * @see org.nasdanika.examples.bank.BankPackage#getStatement_ClosingBalance()
	 * @model
	 * @generated
	 */
	BigDecimal getClosingBalance();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Statement#getClosingBalance <em>Closing Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closing Balance</em>' attribute.
	 * @see #getClosingBalance()
	 * @generated
	 */
	void setClosingBalance(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Closing Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Closing Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Closing Date</em>' attribute.
	 * @see #setClosingDate(Date)
	 * @see org.nasdanika.examples.bank.BankPackage#getStatement_ClosingDate()
	 * @model
	 * @generated
	 */
	Date getClosingDate();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.Statement#getClosingDate <em>Closing Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Closing Date</em>' attribute.
	 * @see #getClosingDate()
	 * @generated
	 */
	void setClosingDate(Date value);

} // Statement
