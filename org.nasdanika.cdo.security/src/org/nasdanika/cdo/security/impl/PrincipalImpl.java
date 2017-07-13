/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.PrincipalAuthorizationHelper;
import org.nasdanika.cdo.security.Group;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.PrincipalPermission;
import org.nasdanika.cdo.security.PrincipalVisitor;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.cdo.security.SecurityPackage;

import org.nasdanika.core.AuthorizationProvider.AccessDecision;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Principal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.PrincipalImpl#getMemberOf <em>Member Of</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PrincipalImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PrincipalImpl#isDisabled <em>Disabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PrincipalImpl extends CDOObjectImpl implements Principal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrincipalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.PRINCIPAL;
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
	public EList<PrincipalPermission> getPermissions() {
		return (EList<PrincipalPermission>)eGet(SecurityPackage.Literals.PRINCIPAL__PERMISSIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisabled() {
		return (Boolean)eGet(SecurityPackage.Literals.PRINCIPAL__DISABLED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisabled(boolean newDisabled) {
		eSet(SecurityPackage.Literals.PRINCIPAL__DISABLED, newDisabled);
	}

	private PrincipalAuthorizationHelper authorizationHelper = new PrincipalAuthorizationHelper(this);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AccessDecision authorize(Context context, EObject target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return authorizationHelper.authorize(context, target, action, qualifier, environment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void accept(PrincipalVisitor visitor) {
		visitor.visit(this);
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Realm<?> getRealm() {
		return Principal.super.getRealm();
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
			case SecurityPackage.PRINCIPAL___AUTHORIZE__CONTEXT_EOBJECT_STRING_STRING_MAP:
				try {
					return authorize((Context)arguments.get(0), (EObject)arguments.get(1), (String)arguments.get(2), (String)arguments.get(3), (Map<String, Object>)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case SecurityPackage.PRINCIPAL___ACCEPT__PRINCIPALVISITOR:
				accept((PrincipalVisitor)arguments.get(0));
				return null;
			case SecurityPackage.PRINCIPAL___GET_REALM:
				return getRealm();
		}
		return super.eInvoke(operationID, arguments);
	}

} //PrincipalImpl
