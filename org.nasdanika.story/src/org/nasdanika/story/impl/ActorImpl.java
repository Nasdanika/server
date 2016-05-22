/**
 */
package org.nasdanika.story.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.story.Actor;
import org.nasdanika.story.Role;
import org.nasdanika.story.StoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.ActorImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ActorImpl#getSubActors <em>Sub Actors</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ActorImpl#getSuperActors <em>Super Actors</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ActorImpl extends ProtagonistImpl implements Actor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.ACTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Role> getRoles() {
		return (EList<Role>)eDynamicGet(StoryPackage.ACTOR__ROLES, StoryPackage.Literals.ACTOR__ROLES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Actor> getSubActors() {
		return (EList<Actor>)eDynamicGet(StoryPackage.ACTOR__SUB_ACTORS, StoryPackage.Literals.ACTOR__SUB_ACTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Actor> getSuperActors() {
		return (EList<Actor>)eDynamicGet(StoryPackage.ACTOR__SUPER_ACTORS, StoryPackage.Literals.ACTOR__SUPER_ACTORS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoryPackage.ACTOR__SUB_ACTORS:
				return ((InternalEList<?>)getSubActors()).basicRemove(otherEnd, msgs);
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
			case StoryPackage.ACTOR__ROLES:
				return getRoles();
			case StoryPackage.ACTOR__SUB_ACTORS:
				return getSubActors();
			case StoryPackage.ACTOR__SUPER_ACTORS:
				return getSuperActors();
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
			case StoryPackage.ACTOR__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case StoryPackage.ACTOR__SUB_ACTORS:
				getSubActors().clear();
				getSubActors().addAll((Collection<? extends Actor>)newValue);
				return;
			case StoryPackage.ACTOR__SUPER_ACTORS:
				getSuperActors().clear();
				getSuperActors().addAll((Collection<? extends Actor>)newValue);
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
			case StoryPackage.ACTOR__ROLES:
				getRoles().clear();
				return;
			case StoryPackage.ACTOR__SUB_ACTORS:
				getSubActors().clear();
				return;
			case StoryPackage.ACTOR__SUPER_ACTORS:
				getSuperActors().clear();
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
			case StoryPackage.ACTOR__ROLES:
				return !getRoles().isEmpty();
			case StoryPackage.ACTOR__SUB_ACTORS:
				return !getSubActors().isEmpty();
			case StoryPackage.ACTOR__SUPER_ACTORS:
				return !getSuperActors().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActorImpl
