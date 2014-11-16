/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginPasswordProtectionDomain;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.NasdanikaException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Login Password Protection Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordProtectionDomainImpl#getSuperUsersGroup <em>Super Users Group</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordProtectionDomainImpl#getUnauthenticatedPrincipal <em>Unauthenticated Principal</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordProtectionDomainImpl#getEveryoneGroup <em>Everyone Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoginPasswordProtectionDomainImpl extends CDOObjectImpl implements LoginPasswordProtectionDomain {
	
	private static final String UTF_8 = "UTF-8";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoginPasswordProtectionDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.LOGIN_PASSWORD_PROTECTION_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group getSuperUsersGroup() {
		return (Group)eGet(SecurityPackage.Literals.PROTECTION_DOMAIN__SUPER_USERS_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperUsersGroup(Group newSuperUsersGroup) {
		eSet(SecurityPackage.Literals.PROTECTION_DOMAIN__SUPER_USERS_GROUP, newSuperUsersGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User getUnauthenticatedPrincipal() {
		return (User)eGet(SecurityPackage.Literals.PROTECTION_DOMAIN__UNAUTHENTICATED_PRINCIPAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnauthenticatedPrincipal(User newUnauthenticatedPrincipal) {
		eSet(SecurityPackage.Literals.PROTECTION_DOMAIN__UNAUTHENTICATED_PRINCIPAL, newUnauthenticatedPrincipal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group getEveryoneGroup() {
		return (Group)eGet(SecurityPackage.Literals.PROTECTION_DOMAIN__EVERYONE_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEveryoneGroup(Group newEveryoneGroup) {
		eSet(SecurityPackage.Literals.PROTECTION_DOMAIN__EVERYONE_GROUP, newEveryoneGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOR
	 */
	public void setPasswordHash(LoginPasswordHashUser lphUser, String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(lphUser.getLogin().getBytes(UTF_8));
			md.update((byte) 0); // Separator
			md.update(password.getBytes(UTF_8));
			lphUser.setPasswordHash(md.digest());
		} catch (Exception e) {
			throw new NasdanikaException(e);
		}
	}
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public User getUser(String login) {
		for (User user: getAllUsers()) {
			if (user instanceof LoginPasswordHashUser && login.equalsIgnoreCase(((LoginPasswordHashUser) user).getLogin())) {
				return user;
			}
		}
		
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void clearPermissions(EObject obj) {
		for (User user: getAllUsers()) {
			Iterator<Permission> pit = user.getPermissions().iterator();
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
	 * @generated
	 */
	public EList<User> getAllUsers() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public LoginPasswordHashUser authenticate(LoginPasswordCredentials credentials) {
		for (User user: getAllUsers()) {
			if (user instanceof LoginPasswordHashUser && !((LoginPasswordHashUser) user).isDisabled()) {
				LoginPasswordHashUser lphUser = (LoginPasswordHashUser) user;
				try {
					if (lphUser.getLogin()!=null && lphUser.getLogin().equalsIgnoreCase(credentials.getLogin())) {
						try {
							MessageDigest md = MessageDigest.getInstance("SHA");
							md.update(lphUser.getLogin().getBytes(UTF_8));
							md.update((byte) 0); // Separator
							md.update(credentials.getPassword().getBytes(UTF_8));
							if (Arrays.equals(md.digest(), lphUser.getPasswordHash())) {
								return lphUser;
							}
						} catch (Exception e) {
							throw new NasdanikaException(e);
						}
					}
				} catch (Exception e) {
					// TODO Proper logging
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SecurityPackage.LOGIN_PASSWORD_PROTECTION_DOMAIN___SET_PASSWORD_HASH__LOGINPASSWORDHASHUSER_STRING:
				setPasswordHash((LoginPasswordHashUser)arguments.get(0), (String)arguments.get(1));
				return null;
			case SecurityPackage.LOGIN_PASSWORD_PROTECTION_DOMAIN___GET_USER__STRING:
				return getUser((String)arguments.get(0));
			case SecurityPackage.LOGIN_PASSWORD_PROTECTION_DOMAIN___AUTHENTICATE__OBJECT:
				return authenticate((LoginPasswordCredentials)arguments.get(0));
			case SecurityPackage.LOGIN_PASSWORD_PROTECTION_DOMAIN___CLEAR_PERMISSIONS__EOBJECT:
				clearPermissions((EObject)arguments.get(0));
				return null;
			case SecurityPackage.LOGIN_PASSWORD_PROTECTION_DOMAIN___GET_ALL_USERS:
				return getAllUsers();
		}
		return super.eInvoke(operationID, arguments);
	}

} //LoginPasswordProtectionDomainImpl
