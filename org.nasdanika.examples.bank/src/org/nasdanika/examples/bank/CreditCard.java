/**
 */
package org.nasdanika.examples.bank;

import java.math.BigDecimal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Credit Card</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.CreditCard#getCreditLimit <em>Credit Limit</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.CreditCard#getGracePeriod <em>Grace Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getCreditCard()
 * @model
 * @generated
 */
public interface CreditCard extends LoanAccount {

	/**
	 * Returns the value of the '<em><b>Credit Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Credit Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Credit Limit</em>' attribute.
	 * @see #setCreditLimit(BigDecimal)
	 * @see org.nasdanika.examples.bank.BankPackage#getCreditCard_CreditLimit()
	 * @model
	 * @generated
	 */
	BigDecimal getCreditLimit();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.CreditCard#getCreditLimit <em>Credit Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Credit Limit</em>' attribute.
	 * @see #getCreditLimit()
	 * @generated
	 */
	void setCreditLimit(BigDecimal value);

	/**
	 * Returns the value of the '<em><b>Grace Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grace Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grace Period</em>' attribute.
	 * @see #setGracePeriod(int)
	 * @see org.nasdanika.examples.bank.BankPackage#getCreditCard_GracePeriod()
	 * @model
	 * @generated
	 */
	int getGracePeriod();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.CreditCard#getGracePeriod <em>Grace Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grace Period</em>' attribute.
	 * @see #getGracePeriod()
	 * @generated
	 */
	void setGracePeriod(int value);
} // CreditCard
