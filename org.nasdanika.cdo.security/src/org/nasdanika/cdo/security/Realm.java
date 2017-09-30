/**
 */
package org.nasdanika.cdo.security;

import java.util.Iterator;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protection Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Realm establishes associations between users and actions on model objects which users are allowed to perform.
 * There is no Role class/interface in the domain. A grantable actions is Role.
 * 
 * Typically the root of the application model would implement this interface.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.Realm#getAdministrators <em>Administrators</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Realm#getGuest <em>Guest</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Realm#getEveryone <em>Everyone</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.Realm#getPackages <em>Packages</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.security.SecurityPackage#getRealm()
 * @model interface="true" abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Realm<CR> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Administrators</b></em>' reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.User}<code>&lt;CR&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Administrators have all permissions. 
	 * If administrators collection is empty, then any user is treated as a superuser. 
	 * This functionality allows to configure the system after installation and then secure it by adding administrators.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Administrators</em>' reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getRealm_Administrators()
	 * @model annotation="org.nasdanika.cdo.web.render view='list'"
	 * @generated
	 */
	EList<User<CR>> getAdministrators();

	/**
	 * Returns the value of the '<em><b>Guest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unauthenticated principal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Guest</em>' containment reference.
	 * @see #setGuest(Principal)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getRealm_Guest()
	 * @model containment="true"
	 * @generated
	 */
	Principal getGuest();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Realm#getGuest <em>Guest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guest</em>' containment reference.
	 * @see #getGuest()
	 * @generated
	 */
	void setGuest(Principal value);

	/**
	 * Returns the value of the '<em><b>Everyone</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * If this reference is set then all authenticated users implicitly inherit permissions from the ``everyone`` principal.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Everyone</em>' containment reference.
	 * @see #setEveryone(Principal)
	 * @see org.nasdanika.cdo.security.SecurityPackage#getRealm_Everyone()
	 * @model containment="true"
	 * @generated
	 */
	Principal getEveryone();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.security.Realm#getEveryone <em>Everyone</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Everyone</em>' containment reference.
	 * @see #getEveryone()
	 * @generated
	 */
	void setEveryone(Principal value);

	/**
	 * Returns the value of the '<em><b>Packages</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.security.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In a security realm principals are granted permissios to perform actions on
	 * protected objects.
	 * Actions are associated with classed defined in packages.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Packages</em>' containment reference list.
	 * @see org.nasdanika.cdo.security.SecurityPackage#getRealm_Packages()
	 * @model containment="true"
	 * @generated
	 */
	EList<org.nasdanika.cdo.security.Package> getPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Authenticates provided credentials, e.g. user login and password pair.
	 * Returns a list of principals (subject) associated with the provided credentials.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EList<Principal> authenticate(CR credentials);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Realm does not have a containment reference for users, subclasses may
	 * have one or more user containment references, direct or through contained objects.
	 * 
	 * This method returns all users defined in the realm.
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	<U extends User<CR>> EList<U> getAllUsers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Removes permissions associated with the target object from all principals in the realm.
	 * This method shall be invoked before deleting an object. Or use {@link EcoreUtil}.delete().
	 * @param target Target object.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated NOT
	 */
	default void clearPermissions(EObject obj) {
		for (User<?> user: getAllUsers()) {
			Iterator<PrincipalPermission> pit = user.getPermissions().iterator();
			while (pit.hasNext()) {
				Permission p = pit.next();
				if (p.getTarget().equals(obj)) {
					pit.remove();
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns true if principal is administrator. The default implementation returns true
	 * if principal is part of the administrators reference or if the administrators reference is empty.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated NOT
	 */
	default boolean isAdministrator(Principal principal) {
		if (principal == getGuest()) {
			return getAllUsers().isEmpty();
		}
		return getAdministrators().isEmpty() || getAdministrators().contains(principal);
	}

} // Realm
