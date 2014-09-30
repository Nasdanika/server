/**
 */
package org.nasdanika.cdo.security.impl;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Policy Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getActions <em>Actions</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.cdo.security.impl.SecurityPolicyContainerImpl#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
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
	
	@Override
	public Iterable<Action> getGrantableActions(String targetNamespaceURI, String targetClass) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

} //SecurityPolicyContainerImpl
