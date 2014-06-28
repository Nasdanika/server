/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Then Promise</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.ThenPromise#getThen <em>Then</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getThenPromise()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ThenPromise extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(Then)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getThenPromise_Then()
	 * @model containment="true"
	 * @generated
	 */
	Then getThen();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.ThenPromise#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(Then value);

} // ThenPromise
