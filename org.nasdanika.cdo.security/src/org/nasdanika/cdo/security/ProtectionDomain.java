/**
 */
package org.nasdanika.cdo.security;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protection Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <html>Protection domain establishes associations between users and actions which they can execute by the means of groups and permissions. There is no Role class/interface in the domain. A grantable actions is Role.</html>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.ProtectionDomain#getActions <em>Actions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ProtectionDomain#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ProtectionDomain#getSuperUsersGroup <em>Super Users Group</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ProtectionDomain#getUnauthenticatedPrincipal <em>Unauthenticated Principal</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.ProtectionDomain#getEveryoneGroup <em>Everyone Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectionDomain()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface ProtectionDomain<CR> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Action}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Actions. Each action is associated with EClass.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectionDomain_Actions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Group}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Groups.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectionDomain_Groups()
	 * @model containment="true"
	 * @generated
	 */
	EList<Group> getGroups();

	/**
	 * Returns the value of the '<em><b>Super Users Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Superusers have all permissions. If this collection is empty, then any user is treated as a superuser. This functionality allows to configure the system after installation and then secure it by adding superusers.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Users Group</em>' reference.
	 * @see #setSuperUsersGroup(Group)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectionDomain_SuperUsersGroup()
	 * @model
	 * @generated
	 */
	Group getSuperUsersGroup();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ProtectionDomain#getSuperUsersGroup <em>Super Users Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Users Group</em>' reference.
	 * @see #getSuperUsersGroup()
	 * @generated
	 */
	void setSuperUsersGroup(Group value);

	/**
	 * Returns the value of the '<em><b>Unauthenticated Principal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Unauthenticated principal.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unauthenticated Principal</em>' reference.
	 * @see #setUnauthenticatedPrincipal(User)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectionDomain_UnauthenticatedPrincipal()
	 * @model
	 * @generated
	 */
	User getUnauthenticatedPrincipal();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ProtectionDomain#getUnauthenticatedPrincipal <em>Unauthenticated Principal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unauthenticated Principal</em>' reference.
	 * @see #getUnauthenticatedPrincipal()
	 * @generated
	 */
	void setUnauthenticatedPrincipal(User value);

	/**
	 * Returns the value of the '<em><b>Everyone Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>If this reference is set then all authenticated users are considered to be implicit members of this group.</html>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Everyone Group</em>' reference.
	 * @see #setEveryoneGroup(Group)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtectionDomain_EveryoneGroup()
	 * @model
	 * @generated
	 */
	Group getEveryoneGroup();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.ProtectionDomain#getEveryoneGroup <em>Everyone Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Everyone Group</em>' reference.
	 * @see #getEveryoneGroup()
	 * @generated
	 */
	void setEveryoneGroup(Group value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Authenticates user given provided credentials, e.g. user login and password pair.</html>
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	User authenticate(CR credentials);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <html>Removes permissions associated with the object allowing it to be detached from the model.</html>
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void clearPermissions(EObject obj);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<User> getAllUsers();

} // ProtectionDomain
