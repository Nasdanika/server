/**
 */
package org.nasdanika.story.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getSubActors() <em>Sub Actors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> subActors;

	/**
	 * The cached value of the '{@link #getSuperActors() <em>Super Actors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperActors()
	 * @generated
	 * @ordered
	 */
	protected EList<Actor> superActors;

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
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectResolvingEList<Role>(Role.class, this, StoryPackage.ACTOR__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getSubActors() {
		if (subActors == null) {
			subActors = new EObjectContainmentEList<Actor>(Actor.class, this, StoryPackage.ACTOR__SUB_ACTORS);
		}
		return subActors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Actor> getSuperActors() {
		if (superActors == null) {
			superActors = new EObjectResolvingEList<Actor>(Actor.class, this, StoryPackage.ACTOR__SUPER_ACTORS);
		}
		return superActors;
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
				return roles != null && !roles.isEmpty();
			case StoryPackage.ACTOR__SUB_ACTORS:
				return subActors != null && !subActors.isEmpty();
			case StoryPackage.ACTOR__SUPER_ACTORS:
				return superActors != null && !superActors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ActorImpl
