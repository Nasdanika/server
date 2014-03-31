/**
 */
package org.nasdanika.examples.bank;

import java.math.BigDecimal;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loan Account</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.LoanAccount#getRate <em>Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getLoanAccount()
 * @model
 * @generated
 */
public interface LoanAccount extends Account {

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rate</em>' attribute.
	 * @see #setRate(BigDecimal)
	 * @see org.nasdanika.examples.bank.BankPackage#getLoanAccount_Rate()
	 * @model
	 * @generated
	 */
	BigDecimal getRate();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.LoanAccount#getRate <em>Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rate</em>' attribute.
	 * @see #getRate()
	 * @generated
	 */
	void setRate(BigDecimal value);
} // LoanAccount
