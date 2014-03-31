/**
 */
package org.nasdanika.examples.bank.impl;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Checking;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Checking</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CheckingImpl extends DepositAccountImpl implements Checking {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.CHECKING;
	}

} //CheckingImpl
