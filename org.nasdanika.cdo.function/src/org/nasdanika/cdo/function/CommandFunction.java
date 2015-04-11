/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.boxing.ClassBox;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.CommandFunction#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.CommandFunction#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.CommandFunction#getReturnType <em>Return Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getCommandFunction()
 * @model
 * @generated
 */
public interface CommandFunction<CR, T, R> extends AbstractFunction<CR, T, R> {
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getCommandFunction_Target()
	 * @model containment="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.CommandFunction#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getCommandFunction_ParameterTypes()
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getCommandFunction_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	ClassBox<R> getReturnType();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.CommandFunction#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(ClassBox<R> value);

} // CommandFunction
