/**
 */
package org.nasdanika.story.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.story.Goal;
import org.nasdanika.story.Persona;
import org.nasdanika.story.StoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Persona</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.PersonaImpl#getPicture <em>Picture</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.PersonaImpl#getGoals <em>Goals</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonaImpl extends UserImpl implements Persona {
	/**
	 * The default value of the '{@link #getPicture() <em>Picture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPicture()
	 * @generated
	 * @ordered
	 */
	protected static final String PICTURE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.PERSONA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPicture() {
		return (String)eDynamicGet(StoryPackage.PERSONA__PICTURE, StoryPackage.Literals.PERSONA__PICTURE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPicture(String newPicture) {
		eDynamicSet(StoryPackage.PERSONA__PICTURE, StoryPackage.Literals.PERSONA__PICTURE, newPicture);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Goal> getGoals() {
		return (EList<Goal>)eDynamicGet(StoryPackage.PERSONA__GOALS, StoryPackage.Literals.PERSONA__GOALS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoryPackage.PERSONA__GOALS:
				return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
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
			case StoryPackage.PERSONA__PICTURE:
				return getPicture();
			case StoryPackage.PERSONA__GOALS:
				return getGoals();
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
			case StoryPackage.PERSONA__PICTURE:
				setPicture((String)newValue);
				return;
			case StoryPackage.PERSONA__GOALS:
				getGoals().clear();
				getGoals().addAll((Collection<? extends Goal>)newValue);
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
			case StoryPackage.PERSONA__PICTURE:
				setPicture(PICTURE_EDEFAULT);
				return;
			case StoryPackage.PERSONA__GOALS:
				getGoals().clear();
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
			case StoryPackage.PERSONA__PICTURE:
				return PICTURE_EDEFAULT == null ? getPicture() != null : !PICTURE_EDEFAULT.equals(getPicture());
			case StoryPackage.PERSONA__GOALS:
				return !getGoals().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PersonaImpl
