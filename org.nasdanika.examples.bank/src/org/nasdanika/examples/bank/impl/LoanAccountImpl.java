/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.LoanAccount;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loan Account</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.LoanAccountImpl#getRate <em>Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoanAccountImpl extends AccountImpl implements LoanAccount {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoanAccountImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.LOAN_ACCOUNT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getRate() {
		return (BigDecimal)eGet(BankPackage.Literals.LOAN_ACCOUNT__RATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRate(BigDecimal newRate) {
		eSet(BankPackage.Literals.LOAN_ACCOUNT__RATE, newRate);
	}

} //LoanAccountImpl
