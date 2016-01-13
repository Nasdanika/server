/**
 */
package org.nasdanika.story;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Actor role.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.Role#getSubRoles <em>Sub Roles</em>}</li>
 *   <li>{@link org.nasdanika.story.Role#getSuperRoles <em>Super Roles</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.story.StoryPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends Protagonist {
	/**
	 * Returns the value of the '<em><b>Sub Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.story.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A role may contain zero or more sub-roles. Sub-roles inherit super-role stories.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sub Roles</em>' containment reference list.
	 * @see org.nasdanika.story.StoryPackage#getRole_SubRoles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getSubRoles();

	/**
	 * Returns the value of the '<em><b>Super Roles</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.story.Role}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A role may reference zero or more roles as its super-roles. 
	 * The role inherits super-role stories.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Roles</em>' reference list.
	 * @see org.nasdanika.story.StoryPackage#getRole_SuperRoles()
	 * @model
	 * @generated
	 */
	EList<Role> getSuperRoles();

} // Role
