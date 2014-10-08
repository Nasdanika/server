/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#isAllow <em>Allow</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#isWithGrantOption <em>With Grant Option</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getComment <em>Comment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PermissionImpl extends ActionKeyImpl implements Permission {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAllow() {
		return (Boolean)eGet(SecurityPackage.Literals.PERMISSION__ALLOW, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllow(boolean newAllow) {
		eSet(SecurityPackage.Literals.PERMISSION__ALLOW, newAllow);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getTarget() {
		return (EObject)eGet(SecurityPackage.Literals.PERMISSION__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EObject newTarget) {
		eSet(SecurityPackage.Literals.PERMISSION__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWithGrantOption() {
		return (Boolean)eGet(SecurityPackage.Literals.PERMISSION__WITH_GRANT_OPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWithGrantOption(boolean newWithGrantOption) {
		eSet(SecurityPackage.Literals.PERMISSION__WITH_GRANT_OPTION, newWithGrantOption);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return (Date)eGet(SecurityPackage.Literals.PERMISSION__START_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		eSet(SecurityPackage.Literals.PERMISSION__START_DATE, newStartDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return (Date)eGet(SecurityPackage.Literals.PERMISSION__END_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		eSet(SecurityPackage.Literals.PERMISSION__END_DATE, newEndDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return (String)eGet(SecurityPackage.Literals.PERMISSION__COMMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		eSet(SecurityPackage.Literals.PERMISSION__COMMENT, newComment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AccessDecision authorize(SecurityPolicy securityPolicy, Context context, Object target, String action, String path, Map<String, Object> environment) {
		Date now = new Date();
		if (getStartDate()!=null && getStartDate().after(now)) {
			return AccessDecision.ABSTAIN;
		}
		if (getEndDate()!=null && getEndDate().before(now)) {
			return AccessDecision.ABSTAIN;
		}
		
		Action permissionAction = securityPolicy==null ? null : securityPolicy.getAction(this);
		if (permissionAction==null) {
			return AccessDecision.ABSTAIN;
		}
		
		if ((target instanceof EClass || target instanceof Class) && getTarget()==null) {
			if (permissionAction.match(context, "class:"+action, path, environment)) {
				return isAllow() ? AccessDecision.ALLOW : AccessDecision.DENY;
			}
			return AccessDecision.ABSTAIN;
		}
		if ((getTarget()==null || (target!=null && target.equals(getTarget()))) && permissionAction.match(context, action, path, environment)) {
			return isAllow() ? AccessDecision.ALLOW : AccessDecision.DENY;
		}
		return AccessDecision.ABSTAIN;
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
			case SecurityPackage.PERMISSION___AUTHORIZE__SECURITYPOLICY_CONTEXT_OBJECT_STRING_STRING_MAP:
				return authorize((SecurityPolicy)arguments.get(0), (Context)arguments.get(1), arguments.get(2), (String)arguments.get(3), (String)arguments.get(4), (Map<String, Object>)arguments.get(5));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PermissionImpl
