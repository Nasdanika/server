/**
 */
package org.nasdanika.examples.bank.impl;

import java.math.BigDecimal;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.CreditCard;
import org.nasdanika.web.ActionMethod;
import org.nasdanika.web.HttpContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Credit Card</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.CreditCardImpl#getCreditLimit <em>Credit Limit</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.CreditCardImpl#getGracePeriod <em>Grace Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreditCardImpl extends LoanAccountImpl implements CreditCard {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreditCardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.CREDIT_CARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigDecimal getCreditLimit() {
		return (BigDecimal)eGet(BankPackage.Literals.CREDIT_CARD__CREDIT_LIMIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreditLimit(BigDecimal newCreditLimit) {
		eSet(BankPackage.Literals.CREDIT_CARD__CREDIT_LIMIT, newCreditLimit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGracePeriod() {
		return (Integer)eGet(BankPackage.Literals.CREDIT_CARD__GRACE_PERIOD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGracePeriod(int newGracePeriod) {
		eSet(BankPackage.Literals.CREDIT_CARD__GRACE_PERIOD, newGracePeriod);
	}
	
	
	@ActionMethod(pattern=".+\\.html")
	public String home(HttpContext context) {
		return "he";
	}


} //CreditCardImpl
