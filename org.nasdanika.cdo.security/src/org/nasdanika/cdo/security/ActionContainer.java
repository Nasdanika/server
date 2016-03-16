/**
 */
package org.nasdanika.cdo.security;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.ActionContainer#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getActionContainer()
 * @model
 * @extends CDOObject
 * @generated
 */
public interface ActionContainer extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Actions. Each action is associated with EClass.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getActionContainer_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

} // ActionContainer
