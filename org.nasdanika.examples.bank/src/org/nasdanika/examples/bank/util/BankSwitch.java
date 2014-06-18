/**
 */
package org.nasdanika.examples.bank.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.User;
import org.nasdanika.examples.bank.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.nasdanika.examples.bank.BankPackage
 * @generated
 */
public class BankSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BankPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BankSwitch() {
		if (modelPackage == null) {
			modelPackage = BankPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BankPackage.SYSTEM_OF_RECORDS: {
				SystemOfRecords systemOfRecords = (SystemOfRecords)theEObject;
				T result = caseSystemOfRecords(systemOfRecords);
				if (result == null) result = caseProtectionDomain(systemOfRecords);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.CUSTOMER: {
				Customer customer = (Customer)theEObject;
				T result = caseCustomer(customer);
				if (result == null) result = caseUser(customer);
				if (result == null) result = casePrincipal(customer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.ACCOUNT: {
				Account account = (Account)theEObject;
				T result = caseAccount(account);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.TRANSACTION: {
				Transaction transaction = (Transaction)theEObject;
				T result = caseTransaction(transaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.INTERNAL_TRANSACTION: {
				InternalTransaction internalTransaction = (InternalTransaction)theEObject;
				T result = caseInternalTransaction(internalTransaction);
				if (result == null) result = caseTransaction(internalTransaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.EXTERNAL_TRANSACTION: {
				ExternalTransaction externalTransaction = (ExternalTransaction)theEObject;
				T result = caseExternalTransaction(externalTransaction);
				if (result == null) result = caseTransaction(externalTransaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.PRODUCT: {
				Product product = (Product)theEObject;
				T result = caseProduct(product);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.DEPOSIT_ACCOUNT: {
				DepositAccount depositAccount = (DepositAccount)theEObject;
				T result = caseDepositAccount(depositAccount);
				if (result == null) result = caseAccount(depositAccount);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.LOAN_ACCOUNT: {
				LoanAccount loanAccount = (LoanAccount)theEObject;
				T result = caseLoanAccount(loanAccount);
				if (result == null) result = caseAccount(loanAccount);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.CHECKING: {
				Checking checking = (Checking)theEObject;
				T result = caseChecking(checking);
				if (result == null) result = caseDepositAccount(checking);
				if (result == null) result = caseAccount(checking);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.SAVINGS: {
				Savings savings = (Savings)theEObject;
				T result = caseSavings(savings);
				if (result == null) result = caseDepositAccount(savings);
				if (result == null) result = caseAccount(savings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.CREDIT_CARD: {
				CreditCard creditCard = (CreditCard)theEObject;
				T result = caseCreditCard(creditCard);
				if (result == null) result = caseLoanAccount(creditCard);
				if (result == null) result = caseAccount(creditCard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.MORTGAGE: {
				Mortgage mortgage = (Mortgage)theEObject;
				T result = caseMortgage(mortgage);
				if (result == null) result = caseLoanAccount(mortgage);
				if (result == null) result = caseAccount(mortgage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BankPackage.GUEST: {
				Guest guest = (Guest)theEObject;
				T result = caseGuest(guest);
				if (result == null) result = caseUser(guest);
				if (result == null) result = casePrincipal(guest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Of Records</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Of Records</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemOfRecords(SystemOfRecords object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Customer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomer(Customer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Account</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Account</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccount(Account object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransaction(Transaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalTransaction(InternalTransaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Transaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Transaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalTransaction(ExternalTransaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deposit Account</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deposit Account</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDepositAccount(DepositAccount object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loan Account</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loan Account</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoanAccount(LoanAccount object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checking</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checking</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChecking(Checking object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Savings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Savings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSavings(Savings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Credit Card</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Credit Card</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreditCard(CreditCard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mortgage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mortgage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMortgage(Mortgage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guest</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guest</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuest(Guest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Protection Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Protection Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <CR> T caseProtectionDomain(ProtectionDomain<CR> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Principal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Principal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrincipal(Principal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //BankSwitch
