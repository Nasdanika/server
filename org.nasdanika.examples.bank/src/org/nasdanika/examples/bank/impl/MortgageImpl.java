/**
 */
package org.nasdanika.examples.bank.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Mortgage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mortgage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MortgageImpl extends LoanAccountImpl implements Mortgage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MortgageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.MORTGAGE;
	}

} //MortgageImpl
