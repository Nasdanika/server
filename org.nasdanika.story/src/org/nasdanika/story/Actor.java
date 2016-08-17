/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base interface for actors.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Actor#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.nasdanika.story.Actor#getSubActors <em>Sub Actors</em>}</li>
 *   <li>{@link org.nasdanika.story.Actor#getSuperActors <em>Super Actors</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getActor()
 * @model abstract="true"
 * @generated
 */
public interface Actor extends Protagonist {
	/**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Actor can play zero or more roles.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getActor_Roles()
	 * @model
	 * @generated
	 */
	EList<Role> getRoles();

	/**
	 * Returns the value of the '<em><b>Sub Actors</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.Actor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sub-actors may be contained by the super-actor to form a single-inheritance hierarchy. Multiple inheritance can be set up with superActors reference.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Actors</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getActor_SubActors()
	 * @model containment="true"
	 * @generated
	 */
	EList<Actor> getSubActors();

	/**
	 * Returns the value of the '<em><b>Super Actors</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Actor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Actors form a multiple inheritance hierarchy and may have zero or more super-actors. All stories and roles played by by a super-actor are also played by its sub-actors.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Actors</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getActor_SuperActors()
	 * @model
	 * @generated
	 */
	EList<Actor> getSuperActors();

} // Actor
