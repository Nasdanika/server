/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.common.util.EList;

import org.nasdanika.cdo.boxing.ClassBox;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Method Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.ServiceMethodFunction#getServiceType <em>Service Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.ServiceMethodFunction#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.ServiceMethodFunction#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.ServiceMethodFunction#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getServiceMethodFunction()
 * @model MCBounds="org.nasdanika.cdo.function.Context"
 * @generated
 */
public interface ServiceMethodFunction<CR, MC extends Context, T, R> extends AbstractFunction<CR, MC, T, R> {
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getServiceMethodFunction_ServiceType()
	 * @model
	 * @generated
	 */
	String getServiceType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getServiceType <em>Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Type</em>' attribute.
	 * @see #getServiceType()
	 * @generated
	 */
	void setServiceType(String value);

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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getServiceMethodFunction_Filter()
	 * @model
	 * @generated
	 */
	String getFilter();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getServiceMethodFunction_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.ServiceMethodFunction#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.boxing.ClassBox}&lt;T>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Types</em>' containment reference list.
	 * @see org.nasdanika.cdo.function.FunctionPackage#getServiceMethodFunction_ParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassBox<T>> getParameterTypes();

} // ServiceMethodFunction
