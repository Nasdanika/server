/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Configuration item contributes to the context of Configurable
 * and can itself be configurable.
 * 
 * Configuration item can be configured with value or other configuration items. 
 * Value and configuration items are injected into the configuration item via constructor. An appropriate constructor is selected based on 
 * whether the value is blank and configuration items are present:
 * 
 * * Blank value, no configuration items - default constructor, if exists.
 * * Non-blank value, no configuration items - a constructor which takes String, if exists.
 * * Blank value, configuration items - a constructor which takes Context, if exists.
 * * Otherwise - a constructor which takes String and Context in any order.
 * 
 * If configuration item's type is assignable from ``org.nasdanika.codegen.Provider``, then it gets instantiated using
 * either the default constructor, if it exists and value is blank, or a constructor which takes String. The provider's ``get(Context)`` method is used
 * to obtain actual configuration item.
 * 
 * If value is not blank, it is interpolated using properties already defined in the context and inherited from the parent context. 
 * Interpolation is the process of expanding tokens enclosed into double-curly brackets to the values of properties with corresponding names.
 * 
 * If a property with a given name is not defined, a token does not get expanded.
 * 
 * Example:
 * ```
 * {{base-package}}.impl
 * ```
 * <!-- end-model-doc -->
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
 * @model abstract="true" superTypes="org.nasdanika.codegen.Provider<org.eclipse.emf.ecore.EJavaObject> org.nasdanika.codegen.Configuration"
 * @generated
 */
public interface ConfigurationItem extends Provider<Object>, Configuration {
	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Configuration item value type. Defaults to ``java.lang.String``.
	 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * Configuration item value.
	 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * Regular configuration shadow/override configuration items defined in parent context(s),
	 * default configuration items, on the contrary, get shadowed by parent's configuration items
	 * with the same keys.
	 * <!-- end-model-doc -->
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
	 * <!-- begin-model-doc -->
	 * Optional description.
	 * <!-- end-model-doc -->
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
