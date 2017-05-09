/**
 */
package org.nasdanika.cdo.security;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Group of principals. Group permissions are inherited by its members.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Group#getMembers <em>Members</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Group#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Group#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getGroup()
 * @model annotation="org.nasdanika.cdo.web.render label='{{name}}' icon='fa fa-group'"
 * @generated
 */
public interface Group extends Principal {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Principal}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.cdo.security.Principal#getMemberOf <em>Member Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group members.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Members</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getGroup_Members()
	 * @see org.nasdanika.cdo.security.Principal#getMemberOf
	 * @model opposite="memberOf"
	 *        annotation="org.nasdanika.cdo.web.render typed-element-location='item' view='list'"
	 * @generated
	 */
	EList<Principal> getMembers();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getGroup_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Group#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Group description.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getGroup_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Group#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Checks direct/indirect membership in the group.
	 * @param principal Principal.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean isMember(Principal principal);

} // Group
