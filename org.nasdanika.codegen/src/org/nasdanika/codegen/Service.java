/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Service#getServiceType <em>Service Type</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getService()
 * @model
 * @generated
 */
public interface Service<T> extends ConfigurationItem<T> {
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
	 * @see org.nasdanika.codegen.CodegenPackage#getService_ServiceType()
	 * @model
	 * @generated
	 */
	String getServiceType();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Service#getServiceType <em>Service Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Type</em>' attribute.
	 * @see #getServiceType()
	 * @generated
	 */
	void setServiceType(String value);

} // Service
