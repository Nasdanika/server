/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.JavaFunction#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaFunction#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaFunction#getThrownExceptions <em>Thrown Exceptions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaFunction#getParameterNames <em>Parameter Names</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaFunction#getCode <em>Code</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.JavaFunction#getCodeURL <em>Code URL</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction()
 * @model MCBounds="org.nasdanika.cdo.function.Context"
 * @generated
 */
public interface JavaFunction<CR, MC extends Context, T, R> extends AbstractFunction<CR, MC, T, R> {
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction_ParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassBox<T>> getParameterTypes();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(ClassBox)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	ClassBox<R> getReturnType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.JavaFunction#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(ClassBox<R> value);

	/**
	 * Returns the value of the '<em><b>Thrown Exceptions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.boxing.ClassBox}&lt;java.lang.Object>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thrown Exceptions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thrown Exceptions</em>' containment reference list.
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction_ThrownExceptions()
	 * @model type="org.nasdanika.cdo.boxing.ClassBox<org.eclipse.emf.ecore.EJavaObject>" containment="true"
	 * @generated
	 */
	EList<ClassBox<Object>> getThrownExceptions();

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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction_ParameterNames()
	 * @model
	 * @generated
	 */
	EList<String> getParameterNames();

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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction_Code()
	 * @model
	 * @generated
	 */
	String getCode();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.JavaFunction#getCode <em>Code</em>}' attribute.
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getJavaFunction_CodeURL()
	 * @model
	 * @generated
	 */
	String getCodeURL();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.JavaFunction#getCodeURL <em>Code URL</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code URL</em>' attribute.
	 * @see #getCodeURL()
	 * @generated
	 */
	void setCodeURL(String value);

} // JavaFunction
