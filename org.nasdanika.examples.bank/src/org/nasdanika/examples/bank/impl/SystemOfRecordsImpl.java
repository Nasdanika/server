/**
 */
package org.nasdanika.examples.bank.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.core.CommandMethod;
import org.nasdanika.examples.bank.BankPackage;
import org.nasdanika.examples.bank.Customer;
import org.nasdanika.examples.bank.Product;
import org.nasdanika.examples.bank.SystemOfRecords;
import org.nasdanika.web.ActionMethod;
import org.nasdanika.web.HttpContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System Of Records</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getCustomers <em>Customers</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.impl.SystemOfRecordsImpl#getProducts <em>Products</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemOfRecordsImpl extends CDOObjectImpl implements SystemOfRecords {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemOfRecordsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BankPackage.Literals.SYSTEM_OF_RECORDS;
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
	public String getId() {
		return (String)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__ID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(BankPackage.Literals.SYSTEM_OF_RECORDS__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Customer> getCustomers() {
		return (EList<Customer>)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__CUSTOMERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Product> getProducts() {
		return (EList<Product>)eGet(BankPackage.Literals.SYSTEM_OF_RECORDS__PRODUCTS, true);
	}

} //SystemOfRecordsImpl
