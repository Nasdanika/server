/**
 */
package org.nasdanika.codegen;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Container of configuration items - properties and services.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Configuration#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configuration#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configuration#getDefaultIncludes <em>Default Includes</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configuration#getBaseURL <em>Base URL</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configuration#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Configuration#getInclude <em>Include</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface Configuration extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Includes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * URL's of configuration files to load into the this configurable's context.
	 * URL's are resolved relative to the ``baseURL``, which in turn is resolved relative to the model resource. 
	 * 
	 * The following custom schemes supported:
	 * 
	 * * ``bundle`` - ``bundle:<bundle symbolic name>/<resource path in the bundle>``
	 * * ``java`` - ``java:<classloader path>``
	 * 
	 * Configuration files can be in the following formats:
	 * 
	 * * XMI model - ``.xml`` or ``.nsdgen`` extension.
	 * * Properties file - ``.properties`` extension.
	 * * JSON file following the structure of the configuration model - ``.json`` extension.
	 * * YAML file following the structure of the configuration model - ``.yml`` extension.
	 * 
	 * If XML/JSON/YAML contains configuration definition, then its ``createContext()`` method is invoked in sequence
	 * to create a chain of contexts. If property or service is contained in the definition, it gets mounted to a context created by this configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Includes</em>' attribute list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration_Includes()
	 * @model
	 * @generated
	 */
	EList<String> getIncludes();

	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.ConfigurationItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Configuration items - properties and services.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration_Configuration()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConfigurationItem> getConfiguration();

	/**
	 * Returns the value of the '<em><b>Default Includes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Same as ``includes``, but default includes are used only if the parent context doesn't contain configuration items with requested keys (names or types).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Default Includes</em>' attribute list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration_DefaultIncludes()
	 * @model
	 * @generated
	 */
	EList<String> getDefaultIncludes();

	/**
	 * Returns the value of the '<em><b>Base URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Base URL to resolve includes, default includes, and classpath entries. 
	 * The URL is resolved relative to the model location and defaults to the model location URL.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base URL</em>' attribute.
	 * @see #setBaseURL(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration_BaseURL()
	 * @model
	 * @generated
	 */
	String getBaseURL();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Configuration#getBaseURL <em>Base URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base URL</em>' attribute.
	 * @see #getBaseURL()
	 * @generated
	 */
	void setBaseURL(String value);

	/**
	 * Returns the value of the '<em><b>Class Path</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Class path for loading classes of configuration elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Path</em>' attribute list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration_ClassPath()
	 * @model
	 * @generated
	 */
	EList<String> getClassPath();

	/**
	 * Returns the value of the '<em><b>Include</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Configurations defined elsewhere to be included into this configuration. 
	 * Configurations get chained and configuration items (properties and services) get
	 * mounted to the context created by this configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Include</em>' reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getConfiguration_Include()
	 * @model
	 * @generated
	 */
	EList<Configuration> getInclude();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.codegen.Context" parentDataType="org.nasdanika.codegen.Context"
	 * @generated NOT
	 */
	default Context createContext(Context parent) throws Exception {
		SubContext ret = parent.createSubContext();
		for (ConfigurationItem ci: getConfiguration()) {
			if (ci instanceof Property) {
				ret.set(((Property) ci).getName(), ci.get(ret));
			} else {
				@SuppressWarnings("unchecked")
				Class<Object> serviceType = (Class<Object>) parent.getClassLoader().loadClass(((Service) ci).getServiceType());
				ret.set(serviceType, ci.get(ret));				
			}
		}		
		return ret;
	}

} // Configuration
