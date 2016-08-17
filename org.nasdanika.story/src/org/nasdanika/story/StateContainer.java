/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Container of states.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.StateContainer#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getStateContainer()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface StateContainer extends CatalogElement {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Story container may contain zero or more stories or epics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getStateContainer_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

} // StateContainer
