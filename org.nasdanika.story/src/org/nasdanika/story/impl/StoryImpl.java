/**
 */
package org.nasdanika.story.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import java.util.Map;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.ConditionalProtagonist;
import org.nasdanika.story.Goal;
import org.nasdanika.story.Parameter;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.Story;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.Theme;
import org.nasdanika.story.util.StoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Story</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getThemes <em>Themes</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getProtagonists <em>Protagonists</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getConditionalprotagonists <em>Conditionalprotagonists</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getGoal <em>Goal</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getBenefit <em>Benefit</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#isCompleted <em>Completed</em>}</li>
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getRealizes <em>Realizes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StoryImpl extends CDOObjectImpl implements Story {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

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
	 * The default value of the '{@link #getGoal() <em>Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoal()
	 * @generated
	 * @ordered
	 */
	protected static final String GOAL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getBenefit() <em>Benefit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBenefit()
	 * @generated
	 * @ordered
	 */
	protected static final String BENEFIT_EDEFAULT = null;

	/**
	 * The default value of the '{@link #isCompleted() <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompleted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COMPLETED_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StoryPackage.Literals.STORY;
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
	public String getId() {
		return (String)eDynamicGet(StoryPackage.STORY__ID, StoryPackage.Literals.CATALOG_ELEMENT__ID, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		eDynamicSet(StoryPackage.STORY__ID, StoryPackage.Literals.CATALOG_ELEMENT__ID, newId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eDynamicGet(StoryPackage.STORY__NAME, StoryPackage.Literals.CATALOG_ELEMENT__NAME, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eDynamicSet(StoryPackage.STORY__NAME, StoryPackage.Literals.CATALOG_ELEMENT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eDynamicGet(StoryPackage.STORY__DESCRIPTION, StoryPackage.Literals.CATALOG_ELEMENT__DESCRIPTION, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eDynamicSet(StoryPackage.STORY__DESCRIPTION, StoryPackage.Literals.CATALOG_ELEMENT__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Scenario> getScenarios() {
		return (EList<Scenario>)eDynamicGet(StoryPackage.STORY__SCENARIOS, StoryPackage.Literals.STORY__SCENARIOS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Story> getDepends() {
		return (EList<Story>)eDynamicGet(StoryPackage.STORY__DEPENDS, StoryPackage.Literals.STORY__DEPENDS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Theme> getThemes() {
		return (EList<Theme>)eDynamicGet(StoryPackage.STORY__THEMES, StoryPackage.Literals.STORY__THEMES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Protagonist> getProtagonists() {
		return (EList<Protagonist>)eDynamicGet(StoryPackage.STORY__PROTAGONISTS, StoryPackage.Literals.STORY__PROTAGONISTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConditionalProtagonist> getConditionalprotagonists() {
		return (EList<ConditionalProtagonist>)eDynamicGet(StoryPackage.STORY__CONDITIONALPROTAGONISTS, StoryPackage.Literals.STORY__CONDITIONALPROTAGONISTS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoal() {
		return (String)eDynamicGet(StoryPackage.STORY__GOAL, StoryPackage.Literals.STORY__GOAL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoal(String newGoal) {
		eDynamicSet(StoryPackage.STORY__GOAL, StoryPackage.Literals.STORY__GOAL, newGoal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBenefit() {
		return (String)eDynamicGet(StoryPackage.STORY__BENEFIT, StoryPackage.Literals.STORY__BENEFIT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenefit(String newBenefit) {
		eDynamicSet(StoryPackage.STORY__BENEFIT, StoryPackage.Literals.STORY__BENEFIT, newBenefit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Parameter> getParameters() {
		return (EList<Parameter>)eDynamicGet(StoryPackage.STORY__PARAMETERS, StoryPackage.Literals.STORY__PARAMETERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompleted() {
		return (Boolean)eDynamicGet(StoryPackage.STORY__COMPLETED, StoryPackage.Literals.STORY__COMPLETED, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompleted(boolean newCompleted) {
		eDynamicSet(StoryPackage.STORY__COMPLETED, StoryPackage.Literals.STORY__COMPLETED, newCompleted);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Goal> getRealizes() {
		return (EList<Goal>)eDynamicGet(StoryPackage.STORY__REALIZES, StoryPackage.Literals.STORY__REALIZES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (getId() != null && getId().trim().length() > 0) {
			TreeIterator<EObject> rcit = eResource().getAllContents();
			while (rcit.hasNext()) {
				EObject next = rcit.next();
				if (next != this && next instanceof CatalogElement) {
					String nextId = ((CatalogElement) next).getId();
					if (nextId != null && getId().trim().equals(nextId.trim())) {
						if (diagnostics != null) {
							diagnostics.add
								(new BasicDiagnostic
									(Diagnostic.ERROR,
									 StoryValidator.DIAGNOSTIC_SOURCE,
									 StoryValidator.CATALOG_ELEMENT__VALIDATE,
									 "Duplicate ID " + EObjectValidator.getObjectLabel(this, context),
									 new Object [] { this }));
						}
						return false;						
					}
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoryPackage.STORY__SCENARIOS:
				return ((InternalEList<?>)getScenarios()).basicRemove(otherEnd, msgs);
			case StoryPackage.STORY__CONDITIONALPROTAGONISTS:
				return ((InternalEList<?>)getConditionalprotagonists()).basicRemove(otherEnd, msgs);
			case StoryPackage.STORY__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case StoryPackage.STORY__ID:
				return getId();
			case StoryPackage.STORY__NAME:
				return getName();
			case StoryPackage.STORY__DESCRIPTION:
				return getDescription();
			case StoryPackage.STORY__SCENARIOS:
				return getScenarios();
			case StoryPackage.STORY__DEPENDS:
				return getDepends();
			case StoryPackage.STORY__THEMES:
				return getThemes();
			case StoryPackage.STORY__PROTAGONISTS:
				return getProtagonists();
			case StoryPackage.STORY__CONDITIONALPROTAGONISTS:
				return getConditionalprotagonists();
			case StoryPackage.STORY__GOAL:
				return getGoal();
			case StoryPackage.STORY__BENEFIT:
				return getBenefit();
			case StoryPackage.STORY__PARAMETERS:
				return getParameters();
			case StoryPackage.STORY__COMPLETED:
				return isCompleted();
			case StoryPackage.STORY__REALIZES:
				return getRealizes();
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
			case StoryPackage.STORY__ID:
				setId((String)newValue);
				return;
			case StoryPackage.STORY__NAME:
				setName((String)newValue);
				return;
			case StoryPackage.STORY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case StoryPackage.STORY__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends Scenario>)newValue);
				return;
			case StoryPackage.STORY__DEPENDS:
				getDepends().clear();
				getDepends().addAll((Collection<? extends Story>)newValue);
				return;
			case StoryPackage.STORY__THEMES:
				getThemes().clear();
				getThemes().addAll((Collection<? extends Theme>)newValue);
				return;
			case StoryPackage.STORY__PROTAGONISTS:
				getProtagonists().clear();
				getProtagonists().addAll((Collection<? extends Protagonist>)newValue);
				return;
			case StoryPackage.STORY__CONDITIONALPROTAGONISTS:
				getConditionalprotagonists().clear();
				getConditionalprotagonists().addAll((Collection<? extends ConditionalProtagonist>)newValue);
				return;
			case StoryPackage.STORY__GOAL:
				setGoal((String)newValue);
				return;
			case StoryPackage.STORY__BENEFIT:
				setBenefit((String)newValue);
				return;
			case StoryPackage.STORY__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case StoryPackage.STORY__COMPLETED:
				setCompleted((Boolean)newValue);
				return;
			case StoryPackage.STORY__REALIZES:
				getRealizes().clear();
				getRealizes().addAll((Collection<? extends Goal>)newValue);
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
			case StoryPackage.STORY__ID:
				setId(ID_EDEFAULT);
				return;
			case StoryPackage.STORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StoryPackage.STORY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case StoryPackage.STORY__SCENARIOS:
				getScenarios().clear();
				return;
			case StoryPackage.STORY__DEPENDS:
				getDepends().clear();
				return;
			case StoryPackage.STORY__THEMES:
				getThemes().clear();
				return;
			case StoryPackage.STORY__PROTAGONISTS:
				getProtagonists().clear();
				return;
			case StoryPackage.STORY__CONDITIONALPROTAGONISTS:
				getConditionalprotagonists().clear();
				return;
			case StoryPackage.STORY__GOAL:
				setGoal(GOAL_EDEFAULT);
				return;
			case StoryPackage.STORY__BENEFIT:
				setBenefit(BENEFIT_EDEFAULT);
				return;
			case StoryPackage.STORY__PARAMETERS:
				getParameters().clear();
				return;
			case StoryPackage.STORY__COMPLETED:
				setCompleted(COMPLETED_EDEFAULT);
				return;
			case StoryPackage.STORY__REALIZES:
				getRealizes().clear();
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
			case StoryPackage.STORY__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case StoryPackage.STORY__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case StoryPackage.STORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? getDescription() != null : !DESCRIPTION_EDEFAULT.equals(getDescription());
			case StoryPackage.STORY__SCENARIOS:
				return !getScenarios().isEmpty();
			case StoryPackage.STORY__DEPENDS:
				return !getDepends().isEmpty();
			case StoryPackage.STORY__THEMES:
				return !getThemes().isEmpty();
			case StoryPackage.STORY__PROTAGONISTS:
				return !getProtagonists().isEmpty();
			case StoryPackage.STORY__CONDITIONALPROTAGONISTS:
				return !getConditionalprotagonists().isEmpty();
			case StoryPackage.STORY__GOAL:
				return GOAL_EDEFAULT == null ? getGoal() != null : !GOAL_EDEFAULT.equals(getGoal());
			case StoryPackage.STORY__BENEFIT:
				return BENEFIT_EDEFAULT == null ? getBenefit() != null : !BENEFIT_EDEFAULT.equals(getBenefit());
			case StoryPackage.STORY__PARAMETERS:
				return !getParameters().isEmpty();
			case StoryPackage.STORY__COMPLETED:
				return isCompleted() != COMPLETED_EDEFAULT;
			case StoryPackage.STORY__REALIZES:
				return !getRealizes().isEmpty();
		}
		return super.eIsSet(featureID);
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
			case StoryPackage.STORY___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //StoryImpl
