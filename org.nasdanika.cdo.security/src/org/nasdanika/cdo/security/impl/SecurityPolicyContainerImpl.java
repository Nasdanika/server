/**
 */
package org.nasdanika.cdo.security.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.security.Action;
import org.nasdanika.cdo.security.ActionContainer;
import org.nasdanika.cdo.security.ActionKey;
import org.nasdanika.cdo.security.AuthorizationHelper;
import org.nasdanika.cdo.security.SecurityPackage;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyContainer;
import org.nasdanika.core.CoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SecurityPolicyContainerImpl extends CDOObjectImpl implements SecurityPolicyContainer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecurityPolicyContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SecurityPackage.Literals.SECURITY_POLICY_CONTAINER;
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
	public EList<Action> getActions() {
		return (EList<Action>)eGet(SecurityPackage.Literals.ACTION_CONTAINER__ACTIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(SecurityPackage.Literals.SECURITY_POLICY_CONTAINER__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(SecurityPackage.Literals.SECURITY_POLICY_CONTAINER__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(SecurityPackage.Literals.SECURITY_POLICY_CONTAINER__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(SecurityPackage.Literals.SECURITY_POLICY_CONTAINER__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ActionContainer> getImports() {
		return (EList<ActionContainer>)eGet(SecurityPackage.Literals.SECURITY_POLICY_CONTAINER__IMPORTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ActionContainer.class) {
			switch (derivedFeatureID) {
				case SecurityPackage.SECURITY_POLICY_CONTAINER__ACTIONS: return SecurityPackage.ACTION_CONTAINER__ACTIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ActionContainer.class) {
			switch (baseFeatureID) {
				case SecurityPackage.ACTION_CONTAINER__ACTIONS: return SecurityPackage.SECURITY_POLICY_CONTAINER__ACTIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public Action getAction(ActionKey actionKey) {
		Action ret = AuthorizationHelper.findAction(actionKey, this, null, null, null);
		if (ret!=null) {
			return ret;
		}
		
		for (ActionContainer ip: getImports()) {
			if (ip instanceof SecurityPolicy) {
				Action action = ((SecurityPolicy) ip).getAction(actionKey);
				if (action!=null) {
					return action;
				}
			} else {
				Action action = AuthorizationHelper.findAction(actionKey, ip, null, null, null);
				if (action!=null) {
					return action;
				}
			}			
		}
		return null;
	}
	
	private static boolean equal(String str1, String str2) {
		if (CoreUtil.isBlank(str1)) {
			return CoreUtil.isBlank(str2);
		}
		if (CoreUtil.isBlank(str2)) {
			return false;
		}
		return str1.trim().equals(str2.trim());
	}
	
	private void getGrantableActions(Action action, String targetNamespaceURI, String targetClass, Collection<Action> collector) {
		if (action.isGrantable()
				&& equal(AuthorizationHelper.effectiveTargetNamespaceURI(action), targetNamespaceURI)
				&& equal(AuthorizationHelper.effectiveTargetClass(action), targetClass)) {
			collector.add(action);
		}
		for (Action c: action.getActions()) {
			getGrantableActions(c, targetNamespaceURI, targetClass, collector);
		}
	}
			
	@Override
	public Collection<Action> getGrantableActions(String targetNamespaceURI, String targetClass) {
		Collection<Action> ret = new ArrayList<>();
		for (Action a: getActions()) {
			getGrantableActions(a, targetNamespaceURI, targetClass, ret);
		}				
		// Duplicates elimination??
		for (ActionContainer i: getImports()) {			
			if (i instanceof SecurityPolicy) {
				ret.addAll(((SecurityPolicy) i).getGrantableActions(targetNamespaceURI, targetClass));
			} else {
				for (Action a: i.getActions()) {
					getGrantableActions(a, targetNamespaceURI, targetClass, ret);
				}				
			}			
		}
		
		return ret;
	}

} //SecurityPolicyContainerImpl
