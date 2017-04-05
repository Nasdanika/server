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
 * <!-- begin-model-doc -->
 * Permissions to perform actions on model elements are granted or denied to principals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Principal#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Principal#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Principal#isDisabled <em>Disabled</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal()
 * @model annotation="org.nasdanika.cdo.web.render label='{{eclass-name}}' icon='fa fa-user-o'"
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
	 * <!-- begin-model-doc -->
	 * Opposite to ``Group.members``.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Member Of</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal_MemberOf()
	 * @see org.nasdanika.cdo.security.Group#getMembers
	 * @model opposite="members"
	 * @generated
	 */
	EList<Group> getMemberOf();

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.PrincipalPermission}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Permissions of this principal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Permissions</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal_Permissions()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrincipalPermission> getPermissions();

	/**
	 * Returns the value of the '<em><b>Disabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Disabling a principal has the same effect as deleting it, 
	 * but with the ability to enable at some later point of time.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disabled</em>' attribute.
	 * @see #setDisabled(boolean)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getPrincipal_Disabled()
	 * @model
	 * @generated
	 */
	boolean isDisabled();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Principal#isDisabled <em>Disabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disabled</em>' attribute.
	 * @see #isDisabled()
	 * @generated
	 */
	void setDisabled(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Authorizes to execute an action with a qualifier on an object in a context and an environment.
	 * If target is instanceof Protected then its authorize() method is invoked and takes precedence over the Principal's authorize().
	 * @param context Authorization context.
	 * @param target Permission target object.
	 * @param action Action name, e.g. ``read``, ``add``, or ``invoke``.
	 * @param qualifier Action qualifier. E.g. attribute name for ``read`` or operation signature for ``invoke``.
	 * @param environment
	 *   Authorization environment, e.g. for ``transferFunds`` environment may contain ``transferAmount`` key.
	 *   Environment may be used by conditional actions and/or conditional permissions.
	 * <!-- end-model-doc -->
	 * @model dataType="org.nasdanika.cdo.security.AccessDecision" contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated
	 */
	AccessDecision authorize(Context context, EObject target, String action, String qualifier, Map<String, Object> environment);

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realm</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Realm this principal belongs to. The default implementation traverses containment
	 * hierarchy until it finds a container of type ``Realm``.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	default Realm<?> getRealm() {
		for (EObject c = eContainer(); c != null; c = c.eContainer()) {
			if (c instanceof Realm) {
				return (Realm<?>) c;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Invokes ``PrincipalVisitor.visit()`` on this principal. For groups invokes ``accept(principalVisitor)`` on all group members.
	 * @param visitor 
	 * <!-- end-model-doc -->
	 * @model visitorDataType="org.nasdanika.cdo.security.PrincipalVisitor"
	 * @generated
	 */
	void accept(PrincipalVisitor visitor);

} // Principal
