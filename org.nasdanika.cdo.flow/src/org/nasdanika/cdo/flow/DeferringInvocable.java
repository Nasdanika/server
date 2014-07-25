/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deferring Invocable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.DeferringInvocable#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.DeferringInvocable#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.DeferringInvocable#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferringInvocable()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface DeferringInvocable<R, C extends Context> extends Invocable<Promise<R, C>, C> {
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
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferringInvocable_Target()
	 * @model containment="true"
	 * @generated
	 */
	Invocable<R, C> getTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.DeferringInvocable#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Invocable<R, C> value);

	/**
	 * Returns the value of the '<em><b>Invocations</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.flow.DeferredInvocation}&lt;R, C>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocations</em>' reference list.
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferringInvocable_Invocations()
	 * @model
	 * @generated
	 */
	EList<DeferredInvocation<R, C>> getInvocations();

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(long)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDeferringInvocable_Delay()
	 * @model
	 * @generated
	 */
	long getDelay();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.DeferringInvocable#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(long value);

} // DeferringInvocable
