/**
 */
package org.nasdanika.story.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.story.ConditionalProtagonist;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.StoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Protagonist</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.ConditionalProtagonistImpl#getProtagonist <em>Protagonist</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.ConditionalProtagonistImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionalProtagonistImpl extends CDOObjectImpl implements ConditionalProtagonist {
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
	protected ConditionalProtagonistImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.CONDITIONAL_PROTAGONIST;
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
	public Protagonist getProtagonist() {
		return (Protagonist)eDynamicGet(StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST, StoryPackage.Literals.CONDITIONAL_PROTAGONIST__PROTAGONIST, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Protagonist basicGetProtagonist() {
		return (Protagonist)eDynamicGet(StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST, StoryPackage.Literals.CONDITIONAL_PROTAGONIST__PROTAGONIST, false, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProtagonist(Protagonist newProtagonist) {
		eDynamicSet(StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST, StoryPackage.Literals.CONDITIONAL_PROTAGONIST__PROTAGONIST, newProtagonist);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return (String)eDynamicGet(StoryPackage.CONDITIONAL_PROTAGONIST__CONDITION, StoryPackage.Literals.CONDITIONAL_PROTAGONIST__CONDITION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		eDynamicSet(StoryPackage.CONDITIONAL_PROTAGONIST__CONDITION, StoryPackage.Literals.CONDITIONAL_PROTAGONIST__CONDITION, newCondition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST:
				if (resolve) return getProtagonist();
				return basicGetProtagonist();
			case StoryPackage.CONDITIONAL_PROTAGONIST__CONDITION:
				return getCondition();
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
			case StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST:
				setProtagonist((Protagonist)newValue);
				return;
			case StoryPackage.CONDITIONAL_PROTAGONIST__CONDITION:
				setCondition((String)newValue);
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
			case StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST:
				setProtagonist((Protagonist)null);
				return;
			case StoryPackage.CONDITIONAL_PROTAGONIST__CONDITION:
				setCondition(CONDITION_EDEFAULT);
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
			case StoryPackage.CONDITIONAL_PROTAGONIST__PROTAGONIST:
				return basicGetProtagonist() != null;
			case StoryPackage.CONDITIONAL_PROTAGONIST__CONDITION:
				return CONDITION_EDEFAULT == null ? getCondition() != null : !CONDITION_EDEFAULT.equals(getCondition());
		}
		return super.eIsSet(featureID);
	}

} //ConditionalProtagonistImpl
