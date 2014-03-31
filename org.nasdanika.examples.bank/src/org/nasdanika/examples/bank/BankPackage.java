/**
 */
package org.nasdanika.examples.bank;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nasdanika.examples.bank.BankFactory
 * @model kind="package"
 * @generated
 */
public interface BankPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "bank";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.examples.bank";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bank";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BankPackage eINSTANCE = org.nasdanika.examples.bank.impl.BankPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl <em>System Of Records</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.SystemOfRecordsImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getSystemOfRecords()
	 * @generated
	 */
	int SYSTEM_OF_RECORDS = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OF_RECORDS__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OF_RECORDS__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OF_RECORDS__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Customers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OF_RECORDS__CUSTOMERS = 3;

	/**
	 * The feature id for the '<em><b>Products</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OF_RECORDS__PRODUCTS = 4;

	/**
	 * The number of structural features of the '<em>System Of Records</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OF_RECORDS_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.CustomerImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 1;

	/**
	 * The feature id for the '<em><b>Accounts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ACCOUNTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Login</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LOGIN = 2;

	/**
	 * The feature id for the '<em><b>Password Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__PASSWORD_HASH = 3;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.AccountImpl <em>Account</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.AccountImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getAccount()
	 * @generated
	 */
	int ACCOUNT = 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__STATEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__PRODUCT = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__NUMBER = 2;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__BALANCE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT__PERIOD_START = 5;

	/**
	 * The number of structural features of the '<em>Account</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCOUNT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.TransactionImpl <em>Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.TransactionImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getTransaction()
	 * @generated
	 */
	int TRANSACTION = 3;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__AMOUNT = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__DATE = 1;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__COMMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__ID = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TYPE = 4;

	/**
	 * The number of structural features of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.InternalTransactionImpl <em>Internal Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.InternalTransactionImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getInternalTransaction()
	 * @generated
	 */
	int INTERNAL_TRANSACTION = 4;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION__AMOUNT = TRANSACTION__AMOUNT;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION__DATE = TRANSACTION__DATE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION__COMMENT = TRANSACTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION__ID = TRANSACTION__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION__TYPE = TRANSACTION__TYPE;

	/**
	 * The feature id for the '<em><b>Other Account</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION__OTHER_ACCOUNT = TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Internal Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_TRANSACTION_FEATURE_COUNT = TRANSACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.ExternalTransactionImpl <em>External Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.ExternalTransactionImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getExternalTransaction()
	 * @generated
	 */
	int EXTERNAL_TRANSACTION = 5;

	/**
	 * The feature id for the '<em><b>Amount</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__AMOUNT = TRANSACTION__AMOUNT;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__DATE = TRANSACTION__DATE;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__COMMENT = TRANSACTION__COMMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__ID = TRANSACTION__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__TYPE = TRANSACTION__TYPE;

	/**
	 * The feature id for the '<em><b>Processor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__PROCESSOR = TRANSACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>External Account</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__EXTERNAL_ACCOUNT = TRANSACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION__EXTERNAL_ID = TRANSACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>External Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TRANSACTION_FEATURE_COUNT = TRANSACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.ProductImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Applies To Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__APPLIES_TO_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__PROPERTIES = 3;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__IS_ABSTRACT = 4;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__CHILDREN = 5;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.DepositAccountImpl <em>Deposit Account</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.DepositAccountImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getDepositAccount()
	 * @generated
	 */
	int DEPOSIT_ACCOUNT = 7;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT__STATEMENTS = ACCOUNT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT__PRODUCT = ACCOUNT__PRODUCT;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT__NUMBER = ACCOUNT__NUMBER;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT__BALANCE = ACCOUNT__BALANCE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT__DESCRIPTION = ACCOUNT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT__PERIOD_START = ACCOUNT__PERIOD_START;

	/**
	 * The number of structural features of the '<em>Deposit Account</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOSIT_ACCOUNT_FEATURE_COUNT = ACCOUNT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.LoanAccountImpl <em>Loan Account</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.LoanAccountImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getLoanAccount()
	 * @generated
	 */
	int LOAN_ACCOUNT = 8;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__STATEMENTS = ACCOUNT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__PRODUCT = ACCOUNT__PRODUCT;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__NUMBER = ACCOUNT__NUMBER;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__BALANCE = ACCOUNT__BALANCE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__DESCRIPTION = ACCOUNT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__PERIOD_START = ACCOUNT__PERIOD_START;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT__RATE = ACCOUNT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loan Account</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAN_ACCOUNT_FEATURE_COUNT = ACCOUNT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.CheckingImpl <em>Checking</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.CheckingImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getChecking()
	 * @generated
	 */
	int CHECKING = 9;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING__STATEMENTS = DEPOSIT_ACCOUNT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING__PRODUCT = DEPOSIT_ACCOUNT__PRODUCT;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING__NUMBER = DEPOSIT_ACCOUNT__NUMBER;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING__BALANCE = DEPOSIT_ACCOUNT__BALANCE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING__DESCRIPTION = DEPOSIT_ACCOUNT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING__PERIOD_START = DEPOSIT_ACCOUNT__PERIOD_START;

	/**
	 * The number of structural features of the '<em>Checking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECKING_FEATURE_COUNT = DEPOSIT_ACCOUNT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.SavingsImpl <em>Savings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.SavingsImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getSavings()
	 * @generated
	 */
	int SAVINGS = 10;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS__STATEMENTS = DEPOSIT_ACCOUNT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS__PRODUCT = DEPOSIT_ACCOUNT__PRODUCT;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS__NUMBER = DEPOSIT_ACCOUNT__NUMBER;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS__BALANCE = DEPOSIT_ACCOUNT__BALANCE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS__DESCRIPTION = DEPOSIT_ACCOUNT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS__PERIOD_START = DEPOSIT_ACCOUNT__PERIOD_START;

	/**
	 * The number of structural features of the '<em>Savings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAVINGS_FEATURE_COUNT = DEPOSIT_ACCOUNT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.CreditCardImpl <em>Credit Card</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.CreditCardImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getCreditCard()
	 * @generated
	 */
	int CREDIT_CARD = 11;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__STATEMENTS = LOAN_ACCOUNT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__PRODUCT = LOAN_ACCOUNT__PRODUCT;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__NUMBER = LOAN_ACCOUNT__NUMBER;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__BALANCE = LOAN_ACCOUNT__BALANCE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__DESCRIPTION = LOAN_ACCOUNT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__PERIOD_START = LOAN_ACCOUNT__PERIOD_START;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__RATE = LOAN_ACCOUNT__RATE;

	/**
	 * The feature id for the '<em><b>Credit Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__CREDIT_LIMIT = LOAN_ACCOUNT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grace Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD__GRACE_PERIOD = LOAN_ACCOUNT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Credit Card</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CREDIT_CARD_FEATURE_COUNT = LOAN_ACCOUNT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.MortgageImpl <em>Mortgage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.MortgageImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getMortgage()
	 * @generated
	 */
	int MORTGAGE = 12;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__STATEMENTS = LOAN_ACCOUNT__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Product</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__PRODUCT = LOAN_ACCOUNT__PRODUCT;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__NUMBER = LOAN_ACCOUNT__NUMBER;

	/**
	 * The feature id for the '<em><b>Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__BALANCE = LOAN_ACCOUNT__BALANCE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__DESCRIPTION = LOAN_ACCOUNT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Period Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__PERIOD_START = LOAN_ACCOUNT__PERIOD_START;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE__RATE = LOAN_ACCOUNT__RATE;

	/**
	 * The number of structural features of the '<em>Mortgage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MORTGAGE_FEATURE_COUNT = LOAN_ACCOUNT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.impl.StatementImpl
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 13;

	/**
	 * The feature id for the '<em><b>Transactions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__TRANSACTIONS = 0;

	/**
	 * The feature id for the '<em><b>Opening Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__OPENING_BALANCE = 1;

	/**
	 * The feature id for the '<em><b>Opening Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__OPENING_DATE = 2;

	/**
	 * The feature id for the '<em><b>Closing Balance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__CLOSING_BALANCE = 3;

	/**
	 * The feature id for the '<em><b>Closing Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__CLOSING_DATE = 4;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.nasdanika.examples.bank.TransactionType <em>Transaction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.examples.bank.TransactionType
	 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getTransactionType()
	 * @generated
	 */
	int TRANSACTION_TYPE = 14;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.SystemOfRecords <em>System Of Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Of Records</em>'.
	 * @see org.nasdanika.examples.bank.SystemOfRecords
	 * @generated
	 */
	EClass getSystemOfRecords();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.SystemOfRecords#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.nasdanika.examples.bank.SystemOfRecords#getId()
	 * @see #getSystemOfRecords()
	 * @generated
	 */
	EAttribute getSystemOfRecords_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.SystemOfRecords#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.examples.bank.SystemOfRecords#getName()
	 * @see #getSystemOfRecords()
	 * @generated
	 */
	EAttribute getSystemOfRecords_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.SystemOfRecords#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.examples.bank.SystemOfRecords#getDescription()
	 * @see #getSystemOfRecords()
	 * @generated
	 */
	EAttribute getSystemOfRecords_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.examples.bank.SystemOfRecords#getCustomers <em>Customers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Customers</em>'.
	 * @see org.nasdanika.examples.bank.SystemOfRecords#getCustomers()
	 * @see #getSystemOfRecords()
	 * @generated
	 */
	EReference getSystemOfRecords_Customers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.examples.bank.SystemOfRecords#getProducts <em>Products</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Products</em>'.
	 * @see org.nasdanika.examples.bank.SystemOfRecords#getProducts()
	 * @see #getSystemOfRecords()
	 * @generated
	 */
	EReference getSystemOfRecords_Products();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see org.nasdanika.examples.bank.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.examples.bank.Customer#getAccounts <em>Accounts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Accounts</em>'.
	 * @see org.nasdanika.examples.bank.Customer#getAccounts()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Accounts();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Customer#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.examples.bank.Customer#getName()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Customer#getLogin <em>Login</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login</em>'.
	 * @see org.nasdanika.examples.bank.Customer#getLogin()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_Login();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Customer#getPasswordHash <em>Password Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Hash</em>'.
	 * @see org.nasdanika.examples.bank.Customer#getPasswordHash()
	 * @see #getCustomer()
	 * @generated
	 */
	EAttribute getCustomer_PasswordHash();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Account <em>Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Account</em>'.
	 * @see org.nasdanika.examples.bank.Account
	 * @generated
	 */
	EClass getAccount();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.examples.bank.Account#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.nasdanika.examples.bank.Account#getStatements()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Statements();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.examples.bank.Account#getProduct <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Product</em>'.
	 * @see org.nasdanika.examples.bank.Account#getProduct()
	 * @see #getAccount()
	 * @generated
	 */
	EReference getAccount_Product();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Account#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see org.nasdanika.examples.bank.Account#getNumber()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_Number();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Account#getBalance <em>Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Balance</em>'.
	 * @see org.nasdanika.examples.bank.Account#getBalance()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_Balance();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Account#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.examples.bank.Account#getDescription()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Account#getPeriodStart <em>Period Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period Start</em>'.
	 * @see org.nasdanika.examples.bank.Account#getPeriodStart()
	 * @see #getAccount()
	 * @generated
	 */
	EAttribute getAccount_PeriodStart();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Transaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction</em>'.
	 * @see org.nasdanika.examples.bank.Transaction
	 * @generated
	 */
	EClass getTransaction();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Transaction#getAmount <em>Amount</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Amount</em>'.
	 * @see org.nasdanika.examples.bank.Transaction#getAmount()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Amount();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Transaction#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.nasdanika.examples.bank.Transaction#getDate()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Transaction#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.nasdanika.examples.bank.Transaction#getComment()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Comment();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Transaction#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.nasdanika.examples.bank.Transaction#getId()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Transaction#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.examples.bank.Transaction#getType()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_Type();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.InternalTransaction <em>Internal Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Transaction</em>'.
	 * @see org.nasdanika.examples.bank.InternalTransaction
	 * @generated
	 */
	EClass getInternalTransaction();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.examples.bank.InternalTransaction#getOtherAccount <em>Other Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Other Account</em>'.
	 * @see org.nasdanika.examples.bank.InternalTransaction#getOtherAccount()
	 * @see #getInternalTransaction()
	 * @generated
	 */
	EReference getInternalTransaction_OtherAccount();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.ExternalTransaction <em>External Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Transaction</em>'.
	 * @see org.nasdanika.examples.bank.ExternalTransaction
	 * @generated
	 */
	EClass getExternalTransaction();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.ExternalTransaction#getProcessor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Processor</em>'.
	 * @see org.nasdanika.examples.bank.ExternalTransaction#getProcessor()
	 * @see #getExternalTransaction()
	 * @generated
	 */
	EAttribute getExternalTransaction_Processor();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.ExternalTransaction#getExternalAccount <em>External Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Account</em>'.
	 * @see org.nasdanika.examples.bank.ExternalTransaction#getExternalAccount()
	 * @see #getExternalTransaction()
	 * @generated
	 */
	EAttribute getExternalTransaction_ExternalAccount();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.ExternalTransaction#getExternalId <em>External Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>External Id</em>'.
	 * @see org.nasdanika.examples.bank.ExternalTransaction#getExternalId()
	 * @see #getExternalTransaction()
	 * @generated
	 */
	EAttribute getExternalTransaction_ExternalId();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Product <em>Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Product</em>'.
	 * @see org.nasdanika.examples.bank.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Product#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.examples.bank.Product#getName()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Product#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.examples.bank.Product#getDescription()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Product#getAppliesToType <em>Applies To Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Applies To Type</em>'.
	 * @see org.nasdanika.examples.bank.Product#getAppliesToType()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_AppliesToType();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.examples.bank.Product#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Properties</em>'.
	 * @see org.nasdanika.examples.bank.Product#getProperties()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_Properties();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Product#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.nasdanika.examples.bank.Product#isIsAbstract()
	 * @see #getProduct()
	 * @generated
	 */
	EAttribute getProduct_IsAbstract();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.examples.bank.Product#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.examples.bank.Product#getChildren()
	 * @see #getProduct()
	 * @generated
	 */
	EReference getProduct_Children();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.DepositAccount <em>Deposit Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deposit Account</em>'.
	 * @see org.nasdanika.examples.bank.DepositAccount
	 * @generated
	 */
	EClass getDepositAccount();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.LoanAccount <em>Loan Account</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loan Account</em>'.
	 * @see org.nasdanika.examples.bank.LoanAccount
	 * @generated
	 */
	EClass getLoanAccount();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.LoanAccount#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rate</em>'.
	 * @see org.nasdanika.examples.bank.LoanAccount#getRate()
	 * @see #getLoanAccount()
	 * @generated
	 */
	EAttribute getLoanAccount_Rate();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Checking <em>Checking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Checking</em>'.
	 * @see org.nasdanika.examples.bank.Checking
	 * @generated
	 */
	EClass getChecking();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Savings <em>Savings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Savings</em>'.
	 * @see org.nasdanika.examples.bank.Savings
	 * @generated
	 */
	EClass getSavings();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.CreditCard <em>Credit Card</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Credit Card</em>'.
	 * @see org.nasdanika.examples.bank.CreditCard
	 * @generated
	 */
	EClass getCreditCard();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.CreditCard#getCreditLimit <em>Credit Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Credit Limit</em>'.
	 * @see org.nasdanika.examples.bank.CreditCard#getCreditLimit()
	 * @see #getCreditCard()
	 * @generated
	 */
	EAttribute getCreditCard_CreditLimit();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.CreditCard#getGracePeriod <em>Grace Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Grace Period</em>'.
	 * @see org.nasdanika.examples.bank.CreditCard#getGracePeriod()
	 * @see #getCreditCard()
	 * @generated
	 */
	EAttribute getCreditCard_GracePeriod();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Mortgage <em>Mortgage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mortgage</em>'.
	 * @see org.nasdanika.examples.bank.Mortgage
	 * @generated
	 */
	EClass getMortgage();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.examples.bank.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.nasdanika.examples.bank.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.examples.bank.Statement#getTransactions <em>Transactions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transactions</em>'.
	 * @see org.nasdanika.examples.bank.Statement#getTransactions()
	 * @see #getStatement()
	 * @generated
	 */
	EReference getStatement_Transactions();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Statement#getOpeningBalance <em>Opening Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opening Balance</em>'.
	 * @see org.nasdanika.examples.bank.Statement#getOpeningBalance()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_OpeningBalance();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Statement#getOpeningDate <em>Opening Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opening Date</em>'.
	 * @see org.nasdanika.examples.bank.Statement#getOpeningDate()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_OpeningDate();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Statement#getClosingBalance <em>Closing Balance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Closing Balance</em>'.
	 * @see org.nasdanika.examples.bank.Statement#getClosingBalance()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_ClosingBalance();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.examples.bank.Statement#getClosingDate <em>Closing Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Closing Date</em>'.
	 * @see org.nasdanika.examples.bank.Statement#getClosingDate()
	 * @see #getStatement()
	 * @generated
	 */
	EAttribute getStatement_ClosingDate();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.examples.bank.TransactionType <em>Transaction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transaction Type</em>'.
	 * @see org.nasdanika.examples.bank.TransactionType
	 * @generated
	 */
	EEnum getTransactionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BankFactory getBankFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl <em>System Of Records</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.SystemOfRecordsImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getSystemOfRecords()
		 * @generated
		 */
		EClass SYSTEM_OF_RECORDS = eINSTANCE.getSystemOfRecords();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_OF_RECORDS__ID = eINSTANCE.getSystemOfRecords_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_OF_RECORDS__NAME = eINSTANCE.getSystemOfRecords_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM_OF_RECORDS__DESCRIPTION = eINSTANCE.getSystemOfRecords_Description();

		/**
		 * The meta object literal for the '<em><b>Customers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_OF_RECORDS__CUSTOMERS = eINSTANCE.getSystemOfRecords_Customers();

		/**
		 * The meta object literal for the '<em><b>Products</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_OF_RECORDS__PRODUCTS = eINSTANCE.getSystemOfRecords_Products();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.CustomerImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Accounts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__ACCOUNTS = eINSTANCE.getCustomer_Accounts();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__NAME = eINSTANCE.getCustomer_Name();

		/**
		 * The meta object literal for the '<em><b>Login</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__LOGIN = eINSTANCE.getCustomer_Login();

		/**
		 * The meta object literal for the '<em><b>Password Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMER__PASSWORD_HASH = eINSTANCE.getCustomer_PasswordHash();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.AccountImpl <em>Account</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.AccountImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getAccount()
		 * @generated
		 */
		EClass ACCOUNT = eINSTANCE.getAccount();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__STATEMENTS = eINSTANCE.getAccount_Statements();

		/**
		 * The meta object literal for the '<em><b>Product</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCOUNT__PRODUCT = eINSTANCE.getAccount_Product();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__NUMBER = eINSTANCE.getAccount_Number();

		/**
		 * The meta object literal for the '<em><b>Balance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__BALANCE = eINSTANCE.getAccount_Balance();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__DESCRIPTION = eINSTANCE.getAccount_Description();

		/**
		 * The meta object literal for the '<em><b>Period Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCOUNT__PERIOD_START = eINSTANCE.getAccount_PeriodStart();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.TransactionImpl <em>Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.TransactionImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getTransaction()
		 * @generated
		 */
		EClass TRANSACTION = eINSTANCE.getTransaction();

		/**
		 * The meta object literal for the '<em><b>Amount</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__AMOUNT = eINSTANCE.getTransaction_Amount();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__DATE = eINSTANCE.getTransaction_Date();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__COMMENT = eINSTANCE.getTransaction_Comment();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__ID = eINSTANCE.getTransaction_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TYPE = eINSTANCE.getTransaction_Type();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.InternalTransactionImpl <em>Internal Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.InternalTransactionImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getInternalTransaction()
		 * @generated
		 */
		EClass INTERNAL_TRANSACTION = eINSTANCE.getInternalTransaction();

		/**
		 * The meta object literal for the '<em><b>Other Account</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_TRANSACTION__OTHER_ACCOUNT = eINSTANCE.getInternalTransaction_OtherAccount();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.ExternalTransactionImpl <em>External Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.ExternalTransactionImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getExternalTransaction()
		 * @generated
		 */
		EClass EXTERNAL_TRANSACTION = eINSTANCE.getExternalTransaction();

		/**
		 * The meta object literal for the '<em><b>Processor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_TRANSACTION__PROCESSOR = eINSTANCE.getExternalTransaction_Processor();

		/**
		 * The meta object literal for the '<em><b>External Account</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_TRANSACTION__EXTERNAL_ACCOUNT = eINSTANCE.getExternalTransaction_ExternalAccount();

		/**
		 * The meta object literal for the '<em><b>External Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_TRANSACTION__EXTERNAL_ID = eINSTANCE.getExternalTransaction_ExternalId();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.ProductImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__NAME = eINSTANCE.getProduct_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__DESCRIPTION = eINSTANCE.getProduct_Description();

		/**
		 * The meta object literal for the '<em><b>Applies To Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__APPLIES_TO_TYPE = eINSTANCE.getProduct_AppliesToType();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__PROPERTIES = eINSTANCE.getProduct_Properties();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRODUCT__IS_ABSTRACT = eINSTANCE.getProduct_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRODUCT__CHILDREN = eINSTANCE.getProduct_Children();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.DepositAccountImpl <em>Deposit Account</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.DepositAccountImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getDepositAccount()
		 * @generated
		 */
		EClass DEPOSIT_ACCOUNT = eINSTANCE.getDepositAccount();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.LoanAccountImpl <em>Loan Account</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.LoanAccountImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getLoanAccount()
		 * @generated
		 */
		EClass LOAN_ACCOUNT = eINSTANCE.getLoanAccount();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAN_ACCOUNT__RATE = eINSTANCE.getLoanAccount_Rate();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.CheckingImpl <em>Checking</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.CheckingImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getChecking()
		 * @generated
		 */
		EClass CHECKING = eINSTANCE.getChecking();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.SavingsImpl <em>Savings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.SavingsImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getSavings()
		 * @generated
		 */
		EClass SAVINGS = eINSTANCE.getSavings();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.CreditCardImpl <em>Credit Card</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.CreditCardImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getCreditCard()
		 * @generated
		 */
		EClass CREDIT_CARD = eINSTANCE.getCreditCard();

		/**
		 * The meta object literal for the '<em><b>Credit Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREDIT_CARD__CREDIT_LIMIT = eINSTANCE.getCreditCard_CreditLimit();

		/**
		 * The meta object literal for the '<em><b>Grace Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CREDIT_CARD__GRACE_PERIOD = eINSTANCE.getCreditCard_GracePeriod();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.MortgageImpl <em>Mortgage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.MortgageImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getMortgage()
		 * @generated
		 */
		EClass MORTGAGE = eINSTANCE.getMortgage();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.impl.StatementImpl
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '<em><b>Transactions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEMENT__TRANSACTIONS = eINSTANCE.getStatement_Transactions();

		/**
		 * The meta object literal for the '<em><b>Opening Balance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__OPENING_BALANCE = eINSTANCE.getStatement_OpeningBalance();

		/**
		 * The meta object literal for the '<em><b>Opening Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__OPENING_DATE = eINSTANCE.getStatement_OpeningDate();

		/**
		 * The meta object literal for the '<em><b>Closing Balance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__CLOSING_BALANCE = eINSTANCE.getStatement_ClosingBalance();

		/**
		 * The meta object literal for the '<em><b>Closing Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEMENT__CLOSING_DATE = eINSTANCE.getStatement_ClosingDate();

		/**
		 * The meta object literal for the '{@link org.nasdanika.examples.bank.TransactionType <em>Transaction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.examples.bank.TransactionType
		 * @see org.nasdanika.examples.bank.impl.BankPackageImpl#getTransactionType()
		 * @generated
		 */
		EEnum TRANSACTION_TYPE = eINSTANCE.getTransactionType();

	}

} //BankPackage
