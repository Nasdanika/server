/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.AuthorizationHelper;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getProtectionDomain <em>Protection Domain</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getMembers <em>Members</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.GroupImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends CDOObjectImpl implements Group {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.GROUP;
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
	@SuppressWarnings("unchecked")
	public EList<Group> getMemberOf() {
		return (EList<Group>)eGet(SecurityPackage.Literals.PRINCIPAL__MEMBER_OF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Permission> getPermissions() {
		return (EList<Permission>)eGet(SecurityPackage.Literals.PRINCIPAL__PERMISSIONS, true);
	}

	/**
	 * Traverses containers looking for a protection domain.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ProtectionDomain<?> getProtectionDomain() {
		for (EObject container = eContainer(); container != null; container = container.eContainer()) {
			if (container instanceof ProtectionDomain) {
				return (ProtectionDomain<?>) container;
			}
		}

		return null; //(ProtectionDomain<?>)eGet(SecurityPackage.Literals.PRINCIPAL__PROTECTION_DOMAIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Principal> getMembers() {
		return (EList<Principal>)eGet(SecurityPackage.Literals.GROUP__MEMBERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(SecurityPackage.Literals.GROUP__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SecurityPackage.Literals.GROUP__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SecurityPackage.Literals.GROUP__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SecurityPackage.Literals.GROUP__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isMember(Principal principal) {
		if (principal==null) {
			return false;
		}
		for (Principal m: getMembers()) {
			if (m.equals(principal)) {
				return true;
			}
			
			if (m instanceof Group && ((Group) m).isMember(principal)) {
				return true;
			}
		}
		return false;
	}

	private AuthorizationHelper authorizationHelper = new AuthorizationHelper(this);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AccessDecision authorize(SecurityPolicy securityPolicy, Context context, EObject target, String action, String qualifier, Map<String, Object> environment) {
		return authorizationHelper.authorize(securityPolicy, context, target, action, qualifier, environment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendMessage(Principal from, String subject, String bodyMimeType, Object body) {
		for (Principal m: getMembers()) {
			m.sendMessage(from, subject, bodyMimeType, body);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendMessage(Principal from, String subject, Map<String, Object> bodyMap) {
		for (Principal m: getMembers()) {
			m.sendMessage(from, subject, bodyMap);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendMessage(Principal from, String subject, String body) {
		for (Principal m: getMembers()) {
			m.sendMessage(from, subject, body);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case SecurityPackage.GROUP___IS_MEMBER__PRINCIPAL:
				return isMember((Principal)arguments.get(0));
			case SecurityPackage.GROUP___AUTHORIZE__SECURITYPOLICY_CONTEXT_EOBJECT_STRING_STRING_MAP:
				return authorize((SecurityPolicy)arguments.get(0), (Context)arguments.get(1), (EObject)arguments.get(2), (String)arguments.get(3), (String)arguments.get(4), (Map<String, Object>)arguments.get(5));
			case SecurityPackage.GROUP___SEND_MESSAGE__PRINCIPAL_STRING_STRING_OBJECT:
				sendMessage((Principal)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), arguments.get(3));
				return null;
			case SecurityPackage.GROUP___SEND_MESSAGE__PRINCIPAL_STRING_MAP:
				sendMessage((Principal)arguments.get(0), (String)arguments.get(1), (Map<String, Object>)arguments.get(2));
				return null;
			case SecurityPackage.GROUP___SEND_MESSAGE__PRINCIPAL_STRING_STRING:
				sendMessage((Principal)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2));
				return null;
		}
		return super.eInvoke(operationID, arguments);
	}

} //GroupImpl
