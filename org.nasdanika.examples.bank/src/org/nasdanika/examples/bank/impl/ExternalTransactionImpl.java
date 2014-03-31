/**
 */
package org.nasdanika.examples.bank.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.ExternalTransaction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>External Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.ExternalTransactionImpl#getProcessor <em>Processor</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.ExternalTransactionImpl#getExternalAccount <em>External Account</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.ExternalTransactionImpl#getExternalId <em>External Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalTransactionImpl extends TransactionImpl implements ExternalTransaction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExternalTransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.EXTERNAL_TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessor() {
		return (String)eGet(BankPackage.Literals.EXTERNAL_TRANSACTION__PROCESSOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessor(String newProcessor) {
		eSet(BankPackage.Literals.EXTERNAL_TRANSACTION__PROCESSOR, newProcessor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalAccount() {
		return (String)eGet(BankPackage.Literals.EXTERNAL_TRANSACTION__EXTERNAL_ACCOUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalAccount(String newExternalAccount) {
		eSet(BankPackage.Literals.EXTERNAL_TRANSACTION__EXTERNAL_ACCOUNT, newExternalAccount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExternalId() {
		return (String)eGet(BankPackage.Literals.EXTERNAL_TRANSACTION__EXTERNAL_ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExternalId(String newExternalId) {
		eSet(BankPackage.Literals.EXTERNAL_TRANSACTION__EXTERNAL_ID, newExternalId);
	}

} //ExternalTransactionImpl
