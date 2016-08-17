/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Interaction state, e.g. a web page. 
 * Scenarios transition from their start state(s) (context, "given") 
 * to the end state (oucome, "then").
 * 
 * States can be useful when multiple scenarios share start/end states - it allows to clearly identify shared states.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.State#getSuperStates <em>Super States</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getState()
 * @model
 * @generated
 */
public interface State extends CatalogElement {

	/**
	 * Returns the value of the '<em><b>Super States</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * States may form a multiple-inheritance hierarchy. Sub-states inherit 
	 * inbound and outbound transitions (scenarios) of super-states.
	 * 
	 * For example, if all customer pages feature the same menu with links to, say, 
	 * Customer Service page, then a BaseCustomerPage state can be created and
	 * "Customer Service scenario" will start from this abstract state instead of multiple
	 * concrete states, e.g. Accounts Summary or Account Details pages.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super States</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getState_SuperStates()
	 * @model
	 * @generated
	 */
	EList<State> getSuperStates();
} // State
