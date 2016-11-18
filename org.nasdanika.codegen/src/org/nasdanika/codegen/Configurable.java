/**
 */
package org.nasdanika.codegen;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Configurable#getPropertiesReferences <em>Properties References</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configurable#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configurable#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getConfigurable()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Configurable extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Properties References</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties References</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties References</em>' attribute list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurable_PropertiesReferences()
	 * @model
	 * @generated
	 */
	EList<String> getPropertiesReferences();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurable_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Service}&lt;java.lang.Object>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurable_Services()
	 * @model type="org.nasdanika.codegen.Service<org.eclipse.emf.ecore.EJavaObject>" containment="true"
	 * @generated
	 */
	EList<Service<Object>> getServices();

} // Configurable
