/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Transaction;
import org.nasdanika.examples.bank.TransactionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.TransactionImpl#getAmount <em>Amount</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.TransactionImpl#getDate <em>Date</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.TransactionImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.TransactionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.TransactionImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransactionImpl extends CDOObjectImpl implements Transaction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getAmount() {
		return (BigDecimal)eGet(BankPackage.Literals.TRANSACTION__AMOUNT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmount(BigDecimal newAmount) {
		eSet(BankPackage.Literals.TRANSACTION__AMOUNT, newAmount);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getDate() {
		return (Date)eGet(BankPackage.Literals.TRANSACTION__DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDate(Date newDate) {
		eSet(BankPackage.Literals.TRANSACTION__DATE, newDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return (String)eGet(BankPackage.Literals.TRANSACTION__COMMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		eSet(BankPackage.Literals.TRANSACTION__COMMENT, newComment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return (String)eGet(BankPackage.Literals.TRANSACTION__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(BankPackage.Literals.TRANSACTION__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionType getType() {
		return (TransactionType)eGet(BankPackage.Literals.TRANSACTION__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TransactionType newType) {
		eSet(BankPackage.Literals.TRANSACTION__TYPE, newType);
	}

} //TransactionImpl
