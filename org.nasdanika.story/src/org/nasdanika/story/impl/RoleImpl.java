/**
 */
package org.nasdanika.story.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.story.Role;
import org.nasdanika.story.StoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.RoleImpl#getSubRoles <em>Sub Roles</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.RoleImpl#getSuperRoles <em>Super Roles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoleImpl extends ProtagonistImpl implements Role {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Role> getSubRoles() {
		return (EList<Role>)eDynamicGet(StoryPackage.ROLE__SUB_ROLES, StoryPackage.Literals.ROLE__SUB_ROLES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Role> getSuperRoles() {
		return (EList<Role>)eDynamicGet(StoryPackage.ROLE__SUPER_ROLES, StoryPackage.Literals.ROLE__SUPER_ROLES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoryPackage.ROLE__SUB_ROLES:
				return ((InternalEList<?>)getSubRoles()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.ROLE__SUB_ROLES:
				return getSubRoles();
			case StoryPackage.ROLE__SUPER_ROLES:
				return getSuperRoles();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoryPackage.ROLE__SUB_ROLES:
				getSubRoles().clear();
				getSubRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case StoryPackage.ROLE__SUPER_ROLES:
				getSuperRoles().clear();
				getSuperRoles().addAll((Collection<? extends Role>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StoryPackage.ROLE__SUB_ROLES:
				getSubRoles().clear();
				return;
			case StoryPackage.ROLE__SUPER_ROLES:
				getSuperRoles().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StoryPackage.ROLE__SUB_ROLES:
				return !getSubRoles().isEmpty();
			case StoryPackage.ROLE__SUPER_ROLES:
				return !getSuperRoles().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleImpl
