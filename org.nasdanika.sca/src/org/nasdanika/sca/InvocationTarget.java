/**
 */
package org.nasdanika.sca;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocation Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.sca.InvocationTarget#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.sca.ScaPackage#getInvocationTarget()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface InvocationTarget extends ModelElement {
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
	 * @see org.nasdanika.sca.ScaPackage#getInvocationTarget_Bindings()
	 * @model
	 * @generated
	 */
	String getBindings();

	/**
	 * Sets the value of the '{@link org.nasdanika.sca.InvocationTarget#getBindings <em>Bindings</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bindings</em>' attribute.
	 * @see #getBindings()
	 * @generated
	 */
	void setBindings(String value);

} // InvocationTarget
