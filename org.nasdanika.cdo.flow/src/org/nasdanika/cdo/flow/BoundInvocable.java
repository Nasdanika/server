/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bound Invocable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.BoundInvocable#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.BoundInvocable#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getBoundInvocable()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface BoundInvocable<R, C extends Context> extends Invocable<R, C> {

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.nasdanika.cdo.flow.FlowPackage#getBoundInvocable_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getBindings();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Invocable)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getBoundInvocable_Target()
	 * @model containment="true"
	 * @generated
	 */
	Invocable<R, C> getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.BoundInvocable#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Invocable<R, C> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.cdo.flow.Exception" argumentsMany="true"
	 * @generated
	 */
	void bind(C context, EList<Object> arguments) throws Exception;
} // BoundInvocable
