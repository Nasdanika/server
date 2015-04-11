/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.boxing.ClassBox;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object Method Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.ObjectMethodFunction#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.ObjectMethodFunction#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.ObjectMethodFunction#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getObjectMethodFunction()
 * @model
 * @generated
 */
public interface ObjectMethodFunction<CR, T, R> extends AbstractFunction<CR, T, R> {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(EObject)
	 * @see org.nasdanika.cdo.function.FunctionPackage#getObjectMethodFunction_Target()
	 * @model containment="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.ObjectMethodFunction#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getObjectMethodFunction_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.ObjectMethodFunction#getMethodName <em>Method Name</em>}' attribute.
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getObjectMethodFunction_ParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassBox<T>> getParameterTypes();

} // ObjectMethodFunction
