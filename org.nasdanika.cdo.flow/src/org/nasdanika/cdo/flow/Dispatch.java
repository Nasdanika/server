/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dispatch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.Dispatch#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getDispatch()
 * @model
 * @generated
 */
public interface Dispatch extends Invocable {
	/**
	 * Returns the value of the '<em><b>Targets</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.flow.Invocable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Targets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Targets</em>' containment reference list.
	 * @see org.nasdanika.cdo.flow.FlowPackage#getDispatch_Targets()
	 * @model containment="true"
	 * @generated
	 */
	EList<Invocable> getTargets();

} // Dispatch
