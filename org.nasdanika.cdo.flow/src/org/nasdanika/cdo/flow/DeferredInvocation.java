/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deferred Invocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.DeferredInvocation#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.DeferredInvocation#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferredInvocation()
 * @model
 * @generated
 */
public interface DeferredInvocation extends Command {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferredInvocation_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<EObject> getArguments();

	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(Deferred)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferredInvocation_Result()
	 * @model containment="true"
	 * @generated
	 */
	Deferred getResult();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.DeferredInvocation#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(Deferred value);

} // DeferredInvocation
