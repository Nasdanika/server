/**
 */
package org.nasdanika.examples.bank;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.cdo.security.ProtectionDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Of Records</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <html>System of records is the <b>root</b> of the model. Another sentence to be included <I>only</I> in the detailed documentation, but not in summary.</html>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.examples.bank.SystemOfRecords#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.SystemOfRecords#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.SystemOfRecords#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.SystemOfRecords#getCustomers <em>Customers</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.SystemOfRecords#getProducts <em>Products</em>}</li>
 *   <li>{@link org.nasdanika.examples.bank.SystemOfRecords#getGuest <em>Guest</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords()
 * @model superTypes="org.nasdanika.cdo.security.ProtectionDomain<org.nasdanika.examples.bank.LoginPasswordCredentials>"
 * @generated
 */
public interface SystemOfRecords extends ProtectionDomain<LoginPasswordCredentials> {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.SystemOfRecords#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.SystemOfRecords#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.SystemOfRecords#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Customers</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.examples.bank.Customer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Customers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Customers</em>' containment reference list.
	 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords_Customers()
	 * @model containment="true"
	 * @generated
	 */
	EList<Customer> getCustomers();

	/**
	 * Returns the value of the '<em><b>Products</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.examples.bank.Product}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Products</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Products</em>' containment reference list.
	 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords_Products()
	 * @model containment="true"
	 * @generated
	 */
	EList<Product> getProducts();

	/**
	 * Returns the value of the '<em><b>Guest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guest</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guest</em>' containment reference.
	 * @see #setGuest(Guest)
	 * @see org.nasdanika.examples.bank.BankPackage#getSystemOfRecords_Guest()
	 * @model containment="true"
	 * @generated
	 */
	Guest getGuest();

	/**
	 * Sets the value of the '{@link org.nasdanika.examples.bank.SystemOfRecords#getGuest <em>Guest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guest</em>' containment reference.
	 * @see #getGuest()
	 * @generated
	 */
	void setGuest(Guest value);

} // SystemOfRecords
