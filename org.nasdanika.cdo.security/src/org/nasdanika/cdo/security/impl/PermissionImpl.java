/**
 */
package org.nasdanika.cdo.security.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.Permission;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#isAllow <em>Allow</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.PermissionImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PermissionImpl extends CDOObjectImpl implements Permission {
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
	@Override
	protected int eStaticFeatureCount() {
		return 0;
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
	 * @generated
	 */
	public Action getAction() {
		return (Action)eGet(SecurityPackage.Literals.PERMISSION__ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		eSet(SecurityPackage.Literals.PERMISSION__ACTION, newAction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AccessDecision authorize(Context context, String action, String qualifier, Map<String, Object> environment) {
		//System.out.println(target + " "+action+" "+path);
		
		Date now = new Date();
		if (getStartDate()!=null && getStartDate().after(now)) {
			return AccessDecision.ABSTAIN;
		}
		if (getEndDate()!=null && getEndDate().before(now)) {
			return AccessDecision.ABSTAIN;
		}

		if (getAction().match(context, getTarget(), action, qualifier, environment)) {
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
			case SecurityPackage.PERMISSION___AUTHORIZE__CONTEXT_STRING_STRING_MAP:
				return authorize((Context)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Map<String, Object>)arguments.get(3));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PermissionImpl
