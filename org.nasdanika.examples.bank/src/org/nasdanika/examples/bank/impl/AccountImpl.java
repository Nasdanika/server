/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.examples.bank.Account;
import org.nasdanika.examples.bank.BankFactory;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.ExternalTransaction;
import org.nasdanika.examples.bank.PaymentProcessor;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.Statement;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.examples.bank.TransactionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Account</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.AccountImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.AccountImpl#getProduct <em>Product</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.AccountImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.AccountImpl#getBalance <em>Balance</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.AccountImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.AccountImpl#getPeriodStart <em>Period Start</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AccountImpl extends CDOObjectImpl implements Account {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccountImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.ACCOUNT;
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
	@SuppressWarnings("unchecked")
	public EList<Statement> getStatements() {
		return (EList<Statement>)eGet(BankPackage.Literals.ACCOUNT__STATEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product getProduct() {
		return (Product)eGet(BankPackage.Literals.ACCOUNT__PRODUCT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProduct(Product newProduct) {
		eSet(BankPackage.Literals.ACCOUNT__PRODUCT, newProduct);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNumber() {
		return (String)eGet(BankPackage.Literals.ACCOUNT__NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(String newNumber) {
		eSet(BankPackage.Literals.ACCOUNT__NUMBER, newNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getBalance() {
		return (BigDecimal)eGet(BankPackage.Literals.ACCOUNT__BALANCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBalance(BigDecimal newBalance) {
		eSet(BankPackage.Literals.ACCOUNT__BALANCE, newBalance);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(BankPackage.Literals.ACCOUNT__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(BankPackage.Literals.ACCOUNT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPeriodStart() {
		return (Integer)eGet(BankPackage.Literals.ACCOUNT__PERIOD_START, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodStart(int newPeriodStart) {
		eSet(BankPackage.Literals.ACCOUNT__PERIOD_START, newPeriodStart);
	}

//	@Override
//	public Transaction transfer(
//			TransactionType type,
//			Account otherAccount, 
//			BigDecimal amount, 
//			String comment) {
//		if (eResource().equals(otherAccount.eResource())) {
//			InternalTransaction ret = BankFactory.eINSTANCE.createInternalTransaction();
//			ret.setId(EcoreUtil.generateUUID());
//			// Create dual trans with same ID.
//			ret.setComment(comment);
//			ret.setDate(new Date());
//			ret.setAmount(amount);
//			InternalTransaction dual = EcoreUtil.copy(ret);
//			ret.setOtherAccount(otherAccount);
//			dual.setOtherAccount(this);
//			if (TransactionType.CREDIT.equals(type)) {
//				ret.setType(TransactionType.CREDIT);
//				dual.setType(TransactionType.DEBIT);			
//				setBalance(getBalance().add(amount));
//				otherAccount.setBalance(otherAccount.getBalance().subtract(amount));
//			} else {
//				ret.setType(TransactionType.DEBIT);
//				dual.setType(TransactionType.CREDIT);			
//				setBalance(getBalance().subtract(amount));
//				otherAccount.setBalance(otherAccount.getBalance().add(amount));			
//			}
//			getTransactions().add(ret);
//			otherAccount.getTransactions().add(dual);
//			return ret;
//		}
//		
//		// Problem - CDO nullifies cross-repository references, we have to use external transactions.
//		ExternalTransaction ret = BankFactory.eINSTANCE.createExternalTransaction();
//		ret.setId(EcoreUtil.generateUUID());
//		// Create dual trans with same ID.
//		ret.setComment(comment);
//		ret.setDate(new Date());
//		ret.setAmount(amount);
//		ExternalTransaction dual = EcoreUtil.copy(ret);
//		ret.setExternalAccount(((SystemOfRecords) otherAccount.eContainer().eContainer()).getId()+"/"+otherAccount.getNumber());
//		dual.setExternalAccount(((SystemOfRecords) eContainer().eContainer()).getId()+"/"+getNumber());
//		if (TransactionType.CREDIT.equals(type)) {
//			ret.setType(TransactionType.CREDIT);
//			dual.setType(TransactionType.DEBIT);			
//			setBalance(getBalance().add(amount));
//			otherAccount.setBalance(otherAccount.getBalance().subtract(amount));
//		} else {
//			ret.setType(TransactionType.DEBIT);
//			dual.setType(TransactionType.CREDIT);			
//			setBalance(getBalance().subtract(amount));
//			otherAccount.setBalance(otherAccount.getBalance().add(amount));			
//		}
//		getTransactions().add(ret);
//		otherAccount.getTransactions().add(dual);
//		return ret;
//	}

	@Override
	public ExternalTransaction transfer(
			TransactionType type,
			PaymentProcessor processor, 
			String externalAccount,
			Date date,
			BigDecimal amount, 
			String comment) {
		ExternalTransaction ret = BankFactory.eINSTANCE.createExternalTransaction();	
		ret.setDate(date);
		ret.setType(type);
		Statement statement = getStatement(midnight(date));
		if (compare(date, statement)!=0) {
			throw new IllegalStateException("Invalid statement");
		}
		if (statement.getOpeningDate().after(date)) {
			if (compare(date, statement)!=0) {
				throw new IllegalStateException("Invalid statement");
			}
			throw new IllegalStateException("Invalid statement: "+date+"/"+statement.getOpeningDate());			
		}
		statement.getTransactions().add(ret);
		SystemOfRecords sr = (SystemOfRecords) eContainer().eContainer();
		ret.setProcessor(processor.getId());
		ret.setId(EcoreUtil.generateUUID());
		String aid = sr.getId()+"/"+getNumber();
		ret.setComment(comment);
		ret.setAmount(amount);
		
		if (TransactionType.CREDIT.equals(type)) {
			setBalance(getBalance().add(amount));
			statement.setClosingBalance(statement.getClosingBalance().add(amount));			
			ret.setExternalId(processor.transfer(TransactionType.DEBIT, aid, externalAccount, amount, ret.getId(), comment));			
		} else {
			setBalance(getBalance().subtract(amount));
			statement.setClosingBalance(statement.getClosingBalance().subtract(amount));			
			ret.setExternalId(processor.transfer(TransactionType.CREDIT, aid, externalAccount, amount, ret.getId(), comment));			
		}
		
		return ret;
	}
	
	private Date closingDate(Statement statement) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(statement.getOpeningDate());
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		return cal.getTime();		
	}
	
	/**
	 * @param date
	 * @param statement
	 * @return -1 if date is before statement opening date, 0 if date belongs to the statement, and 1 if it is after the statement.
	 */
	private int compare(Date date, Statement statement) {
		Date mdate = midnight(date);
		if (mdate.getTime()<statement.getOpeningDate().getTime()) {
			return -1;
		}
		
		if (mdate.getTime()>closingDate(statement).getTime()) {
			return 1;
		}
		
		if (statement.getOpeningDate().after(mdate)) {
			throw new IllegalStateException();
		}
		
		return 0; 
	}
	
	private Date midnight(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * Returns statement for date. Creates if necessary.
	 * @param date
	 * @return
	 */
	private Statement getStatement(Date date) {
		
		List<Statement> statements = new ArrayList<>(getStatements());
		Collections.sort(statements, new Comparator<Statement>() {

			@Override
			public int compare(Statement o1, Statement o2) {
				return o1.getOpeningDate().compareTo(o2.getOpeningDate());
			}
		});
		
		BigDecimal lastClosingBalance = getBalance();
		Statement lastStatement = null;
		for (Statement st: statements) {
			if (lastStatement!=null && lastStatement.getOpeningDate().equals(st.getOpeningDate())) {
				throw new IllegalStateException("Duplicate statement");
			}
			
			int cmpr = compare(date, st);
			if (cmpr<0) {
				throw new IllegalStateException("Statements are not correctly ordered");
			}
			
			if (cmpr == 0) {
				return st;
			}
			
			st.setClosingDate(closingDate(st));
			lastClosingBalance = st.getClosingBalance();
			lastStatement = st;
		}
		
		Statement ret = BankFactory.eINSTANCE.createStatement();
		ret.setOpeningBalance(lastClosingBalance);
		ret.setClosingBalance(lastClosingBalance);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(midnight(date));
		calendar.set(Calendar.DAY_OF_MONTH, getPeriodStart());
		
		if (calendar.getTime().getTime()>date.getTime()) {
			calendar.add(Calendar.MONTH, -1);
		}
		
		ret.setOpeningDate(calendar.getTime());
		if (lastStatement!=null && ret.getOpeningDate().equals(lastStatement.getOpeningDate())) {
			throw new IllegalStateException("Duplicate statement");
		}
		
		if (lastStatement!=null && lastStatement.getClosingDate()==null) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			lastStatement.setClosingDate(closingDate(lastStatement));
		}
		
		getStatements().add(ret);
		return ret;
	}

} //AccountImpl
