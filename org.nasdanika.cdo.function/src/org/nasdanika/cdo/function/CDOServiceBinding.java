/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.function.ServiceBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CDO Service Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.CDOServiceBinding#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.CDOServiceBinding#getServiceType <em>Service Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getCDOServiceBinding()
 * @model superTypes="org.nasdanika.cdo.function.ServiceBinding"
 * @extends CDOObject
 * @generated
 */
public interface CDOServiceBinding extends CDOObject, ServiceBinding {
	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see #setFilter(String)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getCDOServiceBinding_Filter()
	 * @model
	 * @generated
	 */
	String getFilter();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.CDOServiceBinding#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

	/**
	 * Returns the value of the '<em><b>Service Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Type</em>' attribute.
	 * @see #setServiceType(String)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getCDOServiceBinding_ServiceType()
	 * @model
	 * @generated
	 */
	String getServiceType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.CDOServiceBinding#getServiceType <em>Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Type</em>' attribute.
	 * @see #getServiceType()
	 * @generated
	 */
	void setServiceType(String value);

} // CDOServiceBinding
