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
 *   <li>{@link org.nasdanika.codegen.Configurable#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configurable#getDefaultPropertiesReferences <em>Default Properties References</em>}</li>
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
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.ConfigurationItem}&lt;java.lang.Object>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurable_Configuration()
	 * @model type="org.nasdanika.codegen.ConfigurationItem<org.eclipse.emf.ecore.EJavaObject>" containment="true"
	 * @generated
	 */
	EList<ConfigurationItem<Object>> getConfiguration();

	/**
	 * Returns the value of the '<em><b>Default Properties References</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Properties References</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Properties References</em>' attribute list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurable_DefaultPropertiesReferences()
	 * @model
	 * @generated
	 */
	EList<String> getDefaultPropertiesReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.codegen.Context" parentDataType="org.nasdanika.codegen.Context"
	 * @generated NOT
	 */
	default Context createContext(Context parent) throws Exception {
		SubContext ret = parent.createSubContext();
		for (ConfigurationItem<Object> ci: getConfiguration()) {
			if (ci instanceof Property) {
				ret.set(((Property<?>) ci).getName(), ci.get(ret));
			} else {
				@SuppressWarnings("unchecked")
				Class<Object> serviceType = (Class<Object>) parent.getClassLoader().loadClass(((Service<?>) ci).getServiceType());
				ret.set(serviceType, ci.get(ret));				
			}
		}		
		return ret;
	}

} // Configurable
