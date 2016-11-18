/**
 */
package org.nasdanika.codegen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.codegen.CodegenPackage#getContextProvider()
 * @model abstract="true"
 * @generated
 */
public interface ContextProvider extends Configurable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.codegen.Context" parentDataType="org.nasdanika.codegen.Context"
	 * @generated
	 */
	Context createContext(Context parent, boolean withContainer);

} // ContextProvider
