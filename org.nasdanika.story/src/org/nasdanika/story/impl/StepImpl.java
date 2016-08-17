/**
 */
package org.nasdanika.story.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.story.State;
import org.nasdanika.story.Step;
import org.nasdanika.story.StoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.StepImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StepImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StepImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StepImpl#getFromState <em>From State</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StepImpl#getToState <em>To State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StepImpl extends CDOObjectImpl implements Step {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.STEP;
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
	public String getName() {
		return (String)eDynamicGet(StoryPackage.STEP__NAME, StoryPackage.Literals.STEP__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(StoryPackage.STEP__NAME, StoryPackage.Literals.STEP__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(StoryPackage.STEP__DESCRIPTION, StoryPackage.Literals.STEP__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(StoryPackage.STEP__DESCRIPTION, StoryPackage.Literals.STEP__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return (String)eDynamicGet(StoryPackage.STEP__CONDITION, StoryPackage.Literals.STEP__CONDITION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		eDynamicSet(StoryPackage.STEP__CONDITION, StoryPackage.Literals.STEP__CONDITION, newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getFromState() {
		return (State)eDynamicGet(StoryPackage.STEP__FROM_STATE, StoryPackage.Literals.STEP__FROM_STATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetFromState() {
		return (State)eDynamicGet(StoryPackage.STEP__FROM_STATE, StoryPackage.Literals.STEP__FROM_STATE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromState(State newFromState) {
		eDynamicSet(StoryPackage.STEP__FROM_STATE, StoryPackage.Literals.STEP__FROM_STATE, newFromState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getToState() {
		return (State)eDynamicGet(StoryPackage.STEP__TO_STATE, StoryPackage.Literals.STEP__TO_STATE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State basicGetToState() {
		return (State)eDynamicGet(StoryPackage.STEP__TO_STATE, StoryPackage.Literals.STEP__TO_STATE, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToState(State newToState) {
		eDynamicSet(StoryPackage.STEP__TO_STATE, StoryPackage.Literals.STEP__TO_STATE, newToState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.STEP__NAME:
				return getName();
			case StoryPackage.STEP__DESCRIPTION:
				return getDescription();
			case StoryPackage.STEP__CONDITION:
				return getCondition();
			case StoryPackage.STEP__FROM_STATE:
				if (resolve) return getFromState();
				return basicGetFromState();
			case StoryPackage.STEP__TO_STATE:
				if (resolve) return getToState();
				return basicGetToState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StoryPackage.STEP__NAME:
				setName((String)newValue);
				return;
			case StoryPackage.STEP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case StoryPackage.STEP__CONDITION:
				setCondition((String)newValue);
				return;
			case StoryPackage.STEP__FROM_STATE:
				setFromState((State)newValue);
				return;
			case StoryPackage.STEP__TO_STATE:
				setToState((State)newValue);
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
			case StoryPackage.STEP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StoryPackage.STEP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case StoryPackage.STEP__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case StoryPackage.STEP__FROM_STATE:
				setFromState((State)null);
				return;
			case StoryPackage.STEP__TO_STATE:
				setToState((State)null);
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
			case StoryPackage.STEP__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case StoryPackage.STEP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case StoryPackage.STEP__CONDITION:
				return CONDITION_EDEFAULT == null ? getCondition() != null : !CONDITION_EDEFAULT.equals(getCondition());
			case StoryPackage.STEP__FROM_STATE:
				return basicGetFromState() != null;
			case StoryPackage.STEP__TO_STATE:
				return basicGetToState() != null;
		}
		return super.eIsSet(featureID);
	}

} //StepImpl
