/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Script Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.JavaScriptFunction#getCode <em>Code</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaScriptFunction#getCodeURL <em>Code URL</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaScriptFunction#getParameterNames <em>Parameter Names</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaScriptFunction#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaScriptFunction()
 * @model
 * @generated
 */
public interface JavaScriptFunction<CR, T, R> extends AbstractFunction<CR, T, R> {
	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see #setCode(String)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaScriptFunction_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.JavaScriptFunction#getCode <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' attribute.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(String value);

	/**
	 * Returns the value of the '<em><b>Code URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Code URL</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code URL</em>' attribute.
	 * @see #setCodeURL(String)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaScriptFunction_CodeURL()
	 * @model
	 * @generated
	 */
	String getCodeURL();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.JavaScriptFunction#getCodeURL <em>Code URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code URL</em>' attribute.
	 * @see #getCodeURL()
	 * @generated
	 */
	void setCodeURL(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Names</em>' attribute list.
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaScriptFunction_ParameterNames()
	 * @model
	 * @generated
	 */
	EList<String> getParameterNames();

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' map.
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaScriptFunction_Bindings()
	 * @model mapType="org.nasdanika.cdo.function.ScriptBinding<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<String, EObject> getBindings();

} // JavaScriptFunction
