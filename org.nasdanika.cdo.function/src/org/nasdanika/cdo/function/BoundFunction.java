/**
 */
package org.nasdanika.cdo.function;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.function.BoundFunction#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.function.BoundFunction#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.function.FunctionPackage#getBoundFunction()
 * @model MCBounds="org.nasdanika.cdo.function.Context"
 * @generated
 */
public interface BoundFunction<CR, MC extends Context, T, R> extends AbstractFunction<CR, MC, T, R> {
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
	 * @see org.nasdanika.cdo.function.FunctionPackage#getBoundFunction_Target()
	 * @model containment="true"
	 * @generated
	 */
	EObject getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.function.BoundFunction#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EObject value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' map.
	 * The key is of type {@link java.lang.Integer},
	 * and the value is of type {@link org.eclipse.emf.ecore.EObject},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' map.
	 * @see org.nasdanika.cdo.function.FunctionPackage#getBoundFunction_Bindings()
	 * @model mapType="org.nasdanika.cdo.function.ArgumentBinding<org.eclipse.emf.ecore.EIntegerObject, org.eclipse.emf.ecore.EObject>"
	 * @generated
	 */
	EMap<Integer, EObject> getBindings();

} // BoundFunction
