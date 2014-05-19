/**
 */
package org.nasdanika.examples.bank.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.examples.bank.Account;
import org.nasdanika.examples.bank.BankFactory;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Checking;
import org.nasdanika.examples.bank.CreditCard;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.examples.bank.DepositAccount;
import org.nasdanika.examples.bank.ExternalTransaction;
import org.nasdanika.examples.bank.InternalTransaction;
import org.nasdanika.examples.bank.LoanAccount;
import org.nasdanika.examples.bank.Mortgage;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.Savings;
import org.nasdanika.examples.bank.Statement;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.examples.bank.Transaction;
import org.nasdanika.examples.bank.TransactionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BankFactoryImpl extends EFactoryImpl implements BankFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BankFactory init() {
		try {
			BankFactory theBankFactory = (BankFactory)EPackage.Registry.INSTANCE.getEFactory(BankPackage.eNS_URI);
			if (theBankFactory != null) {
				return theBankFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BankFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BankFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BankPackage.SYSTEM_OF_RECORDS: return (EObject)createSystemOfRecords();
			case BankPackage.CUSTOMER: return (EObject)createCustomer();
			case BankPackage.ACCOUNT: return (EObject)createAccount();
			case BankPackage.TRANSACTION: return (EObject)createTransaction();
			case BankPackage.INTERNAL_TRANSACTION: return (EObject)createInternalTransaction();
			case BankPackage.EXTERNAL_TRANSACTION: return (EObject)createExternalTransaction();
			case BankPackage.PRODUCT: return (EObject)createProduct();
			case BankPackage.DEPOSIT_ACCOUNT: return (EObject)createDepositAccount();
			case BankPackage.LOAN_ACCOUNT: return (EObject)createLoanAccount();
			case BankPackage.CHECKING: return (EObject)createChecking();
			case BankPackage.SAVINGS: return (EObject)createSavings();
			case BankPackage.CREDIT_CARD: return (EObject)createCreditCard();
			case BankPackage.MORTGAGE: return (EObject)createMortgage();
			case BankPackage.STATEMENT: return (EObject)createStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case BankPackage.TRANSACTION_TYPE:
				return createTransactionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case BankPackage.TRANSACTION_TYPE:
				return convertTransactionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemOfRecords createSystemOfRecords() {
		SystemOfRecordsImpl systemOfRecords = new SystemOfRecordsImpl();
		return systemOfRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Customer createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Account createAccount() {
		AccountImpl account = new AccountImpl();
		return account;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transaction createTransaction() {
		TransactionImpl transaction = new TransactionImpl();
		return transaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalTransaction createInternalTransaction() {
		InternalTransactionImpl internalTransaction = new InternalTransactionImpl();
		return internalTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalTransaction createExternalTransaction() {
		ExternalTransactionImpl externalTransaction = new ExternalTransactionImpl();
		return externalTransaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Product createProduct() {
		ProductImpl product = new ProductImpl();
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DepositAccount createDepositAccount() {
		DepositAccountImpl depositAccount = new DepositAccountImpl();
		return depositAccount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoanAccount createLoanAccount() {
		LoanAccountImpl loanAccount = new LoanAccountImpl();
		return loanAccount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Checking createChecking() {
		CheckingImpl checking = new CheckingImpl();
		return checking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Savings createSavings() {
		SavingsImpl savings = new SavingsImpl();
		return savings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreditCard createCreditCard() {
		CreditCardImpl creditCard = new CreditCardImpl();
		return creditCard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mortgage createMortgage() {
		MortgageImpl mortgage = new MortgageImpl();
		return mortgage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionType createTransactionTypeFromString(EDataType eDataType, String initialValue) {
		TransactionType result = TransactionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransactionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BankPackage getBankPackage() {
		return (BankPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BankPackage getPackage() {
		return BankPackage.eINSTANCE;
	}

} //BankFactoryImpl
