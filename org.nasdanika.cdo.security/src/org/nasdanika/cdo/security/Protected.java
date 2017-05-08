/**
 */
package org.nasdanika.cdo.security;

import java.util.Map;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protected</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Classes extending this interface maintain a list of permissions referencing principals.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Protected#getPermissions <em>Permissions</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getProtected()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Protected extends CDOObject {

	/**
	 * Returns the value of the '<em><b>Permissions</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.ProtectedPermission}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Permissions on this object.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Permissions</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getProtected_Permissions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProtectedPermission> getPermissions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Authorizes the principal to execute an action with a qualifier in a context and an environment.
	 * If return value of this methos is ALLOW or DENY, it takes precedence over Principal's authorize() return value
	 * (i.e. Principal's authorize() is not invoked if this method returns anything other than ABSTAIN).
	 * 
	 * The default implementation of this method iterates over protected permissions.
	 * @param context Authorization context.
	 * @param principal Permission target object.
	 * @param action Action name, e.g. ``read``, ``add``, or ``invoke``.
	 * @param qualifier Action qualifier. E.g. attribute name for ``read`` or operation signature for ``invoke``.
	 * @param environment
	 *   Authorization environment, e.g. for ``transferFunds`` environment may contain ``transferAmount`` key.
	 *   Environment may be used by conditional actions and/or conditional permissions.
	 * <!-- end-model-doc -->
	 * @model dataType="org.nasdanika.cdo.security.AccessDecision" contextDataType="org.nasdanika.cdo.security.Context"
	 * @generated NOT
	 */
	default AccessDecision authorize(Context context, Principal principal, String action, String qualifier, Map<String, Object> environment) {
		for (ProtectedPermission p: getPermissions()) {
			if (p.getPrincipal() == principal) {
				AccessDecision ad = p.authorize(context, action, qualifier, environment);
				if (ad != AccessDecision.ABSTAIN) {
					return ad;
				}
			}
		}
		return AccessDecision.ABSTAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns a list of principals which can be granted access to this protected. 
	 * The default implementation returns a list of all realm users excluding roots
	 * plus everyone group.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	default EList<Principal> getGrantees() {
		BasicEList<Principal> grantees = ECollections.newBasicEList();
		for (EObject container = eContainer(); container != null; container = container.eContainer()) {
			if (container instanceof Realm) {
				Realm<?> realm = (Realm<?>) container;
				U: for (User<?> u: realm.getAllUsers()) {
					if (u == realm.getRoot()) {
						continue U;
					}
					if (realm.getRoot() instanceof Group && ((Group) realm.getRoot()).isMember(u)) {
						continue U;
					}
					grantees.add(u);
				}
				if (realm.getEveryone() != null) {
					grantees.add(realm.getEveryone());
				}
				break;
			}
		}
		return grantees;
	};

} // Protected
