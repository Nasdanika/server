/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.ConfigurationItem#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.nasdanika.codegen.ConfigurationItem#getValue <em>Value</em>}</li>
 *   <li>{@link org.nasdanika.codegen.ConfigurationItem#isDefault <em>Default</em>}</li>
 *   <li>{@link org.nasdanika.codegen.ConfigurationItem#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getConfigurationItem()
 * @model abstract="true" superTypes="org.nasdanika.codegen.Provider<T> org.nasdanika.codegen.Configurable"
 * @generated
 */
public interface ConfigurationItem<T> extends Provider<T>, Configurable {
	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see #setValueType(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurationItem_ValueType()
	 * @model
	 * @generated
	 */
	String getValueType();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.ConfigurationItem#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurationItem_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.ConfigurationItem#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurationItem_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.ConfigurationItem#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

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
	 * @see org.nasdanika.codegen.CodegenPackage#getConfigurationItem_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.ConfigurationItem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // ConfigurationItem
