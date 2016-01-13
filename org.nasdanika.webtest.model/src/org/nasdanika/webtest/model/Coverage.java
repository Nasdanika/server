/**
 */
package org.nasdanika.webtest.model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Coverage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.Coverage#getInvocations <em>Invocations</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.webtest.model.ModelPackage#getCoverage()
 * @model
 * @generated
 */
public interface Coverage extends Descriptor {
	/**
	 * Returns the value of the '<em><b>Invocations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocations</em>' attribute.
	 * @see #setInvocations(int)
	 * @see org.nasdanika.webtest.model.ModelPackage#getCoverage_Invocations()
	 * @model
	 * @generated
	 */
	int getInvocations();

	/**
	 * Sets the value of the '{@link org.nasdanika.webtest.model.Coverage#getInvocations <em>Invocations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocations</em>' attribute.
	 * @see #getInvocations()
	 * @generated
	 */
	void setInvocations(int value);

} // Coverage
