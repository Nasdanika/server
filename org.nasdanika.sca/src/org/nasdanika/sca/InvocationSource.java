/**
 */
package org.nasdanika.sca;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.InvocationSource#getInvocationTarget <em>Invocation Target</em>}</li>
 *   <li>{@link org.nasdanika.sca.InvocationSource#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getInvocationSource()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InvocationSource extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Invocation Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation Target</em>' reference.
	 * @see #setInvocationTarget(InvocationTarget)
	 * @see org.nasdanika.sca.ScaPackage#getInvocationSource_InvocationTarget()
	 * @model
	 * @generated
	 */
	InvocationTarget getInvocationTarget();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.InvocationSource#getInvocationTarget <em>Invocation Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation Target</em>' reference.
	 * @see #getInvocationTarget()
	 * @generated
	 */
	void setInvocationTarget(InvocationTarget value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' attribute.
	 * @see #setBindings(String)
	 * @see org.nasdanika.sca.ScaPackage#getInvocationSource_Bindings()
	 * @model
	 * @generated
	 */
	String getBindings();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.InvocationSource#getBindings <em>Bindings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bindings</em>' attribute.
	 * @see #getBindings()
	 * @generated
	 */
	void setBindings(String value);

} // InvocationSource
