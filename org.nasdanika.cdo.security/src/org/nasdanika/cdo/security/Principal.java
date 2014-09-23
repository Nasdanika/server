/**
 */
package org.nasdanika.cdo.security;

import java.util.Map;
import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Principal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Principal#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Principal#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Principal#getProtectionDomain <em>Protection Domain</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Principal extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Member Of</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Group}.
	 * It is bidirectional and its opposite is '{@link org.nasdanika.cdo.security.Group#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Of</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal_MemberOf()
	 * @see org.nasdanika.cdo.security.Group#getMembers
	 * @model opposite="members"
	 * @generated
	 */
	EList<Group> getMemberOf();

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Permission}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permissions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permissions</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal_Permissions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Permission> getPermissions();

	/**
	 * Returns the value of the '<em><b>Protection Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protection Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protection Domain</em>' reference.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal_ProtectionDomain()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ProtectionDomain<?> getProtectionDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.cdo.security.AccessDecision" securityPolicyType="org.nasdanika.cdo.security.SecurityPolicy" contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated
	 */
	AccessDecision authorize(SecurityPolicy securityPolicy, Context context, EObject target, String action, String qualifier, Map<String, Object> environment);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void sendMessage(Principal from, String subject, String bodyMimeType, Object body);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void sendMessage(Principal from, String subject, Map<String, Object> bodyMap);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void sendMessage(Principal from, String subject, String body);

} // Principal
