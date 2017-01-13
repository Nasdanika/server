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
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginPasswordRealm;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.NasdanikaException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Login Password Protection Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl#getGuest <em>Guest</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl#getEveryone <em>Everyone</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.LoginPasswordRealmImpl#getPackages <em>Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LoginPasswordRealmImpl extends CDOObjectImpl implements LoginPasswordRealm {
	
	private static final String UTF_8 = "UTF-8";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoginPasswordRealmImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.LOGIN_PASSWORD_REALM;
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
	public Principal getRoot() {
		return (Principal)eGet(SecurityPackage.Literals.REALM__ROOT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(Principal newRoot) {
		eSet(SecurityPackage.Literals.REALM__ROOT, newRoot);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Principal getGuest() {
		return (Principal)eGet(SecurityPackage.Literals.REALM__GUEST, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuest(Principal newGuest) {
		eSet(SecurityPackage.Literals.REALM__GUEST, newGuest);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Principal getEveryone() {
		return (Principal)eGet(SecurityPackage.Literals.REALM__EVERYONE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEveryone(Principal newEveryone) {
		eSet(SecurityPackage.Literals.REALM__EVERYONE, newEveryone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<org.nasdanika.cdo.security.Package> getPackages() {
		return (EList<org.nasdanika.cdo.security.Package>)eGet(SecurityPackage.Literals.REALM__PACKAGES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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
	 * @generated
	 */
	public LoginUser getLoginUser(String login) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	@Override
	public abstract <U extends User> EList<U> getAllUsers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public LoginPasswordHashUser authenticate(LoginPasswordCredentials credentials) {
		for (User user: getAllUsers()) {
			if (user instanceof LoginPasswordHashUser && !((LoginPasswordHashUser) user).isDisabled() && ((LoginPasswordHashUser) user).getPasswordHash()!=null) {
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
	public EList<Principal> getAllPrincipals() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SecurityPackage.LOGIN_PASSWORD_REALM___SET_PASSWORD_HASH__LOGINPASSWORDHASHUSER_STRING:
				setPasswordHash((LoginPasswordHashUser)arguments.get(0), (String)arguments.get(1));
				return null;
			case SecurityPackage.LOGIN_PASSWORD_REALM___GET_LOGIN_USER__STRING:
				return getLoginUser((String)arguments.get(0));
			case SecurityPackage.LOGIN_PASSWORD_REALM___AUTHENTICATE__OBJECT:
				authenticate((LoginPasswordCredentials)arguments.get(0));
				return null;
			case SecurityPackage.LOGIN_PASSWORD_REALM___GET_ALL_PRINCIPALS:
				return getAllPrincipals();
			case SecurityPackage.LOGIN_PASSWORD_REALM___CLEAR_PERMISSIONS__EOBJECT:
				clearPermissions((EObject)arguments.get(0));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //LoginPasswordRealmImpl
