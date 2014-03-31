/**
 */
package org.nasdanika.examples.bank.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.Account;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.InternalTransaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Internal Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.InternalTransactionImpl#getOtherAccount <em>Other Account</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InternalTransactionImpl extends TransactionImpl implements InternalTransaction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InternalTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.INTERNAL_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Account getOtherAccount() {
		return (Account)eGet(BankPackage.Literals.INTERNAL_TRANSACTION__OTHER_ACCOUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherAccount(Account newOtherAccount) {
		eSet(BankPackage.Literals.INTERNAL_TRANSACTION__OTHER_ACCOUNT, newOtherAccount);
	}

} //InternalTransactionImpl
