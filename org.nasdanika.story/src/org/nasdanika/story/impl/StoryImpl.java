/**
 */
package org.nasdanika.story.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.nasdanika.story.AcceptanceCriterion;
import org.nasdanika.story.ConditionalProtagonist;
import org.nasdanika.story.Goal;
import org.nasdanika.story.Parameter;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Story;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.Theme;

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
 *   <li>{@link org.nasdanika.story.impl.StoryImpl#getAcceptancecriteria <em>Acceptancecriteria</em>}</li>
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
public class StoryImpl extends MinimalEObjectImpl.Container implements Story {
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
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAcceptancecriteria() <em>Acceptancecriteria</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcceptancecriteria()
	 * @generated
	 * @ordered
	 */
	protected EList<AcceptanceCriterion> acceptancecriteria;

	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected EList<Story> depends;

	/**
	 * The cached value of the '{@link #getThemes() <em>Themes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThemes()
	 * @generated
	 * @ordered
	 */
	protected EList<Theme> themes;

	/**
	 * The cached value of the '{@link #getProtagonists() <em>Protagonists</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProtagonists()
	 * @generated
	 * @ordered
	 */
	protected EList<Protagonist> protagonists;

	/**
	 * The cached value of the '{@link #getConditionalprotagonists() <em>Conditionalprotagonists</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionalprotagonists()
	 * @generated
	 * @ordered
	 */
	protected EList<ConditionalProtagonist> conditionalprotagonists;

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
	 * The cached value of the '{@link #getGoal() <em>Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoal()
	 * @generated
	 * @ordered
	 */
	protected String goal = GOAL_EDEFAULT;

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
	 * The cached value of the '{@link #getBenefit() <em>Benefit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBenefit()
	 * @generated
	 * @ordered
	 */
	protected String benefit = BENEFIT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

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
	 * The cached value of the '{@link #isCompleted() <em>Completed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCompleted()
	 * @generated
	 * @ordered
	 */
	protected boolean completed = COMPLETED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRealizes() <em>Realizes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizes()
	 * @generated
	 * @ordered
	 */
	protected EList<Goal> realizes;

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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AcceptanceCriterion> getAcceptancecriteria() {
		if (acceptancecriteria == null) {
			acceptancecriteria = new EObjectContainmentEList<AcceptanceCriterion>(AcceptanceCriterion.class, this, StoryPackage.STORY__ACCEPTANCECRITERIA);
		}
		return acceptancecriteria;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Story> getDepends() {
		if (depends == null) {
			depends = new EObjectResolvingEList<Story>(Story.class, this, StoryPackage.STORY__DEPENDS);
		}
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Theme> getThemes() {
		if (themes == null) {
			themes = new EObjectResolvingEList<Theme>(Theme.class, this, StoryPackage.STORY__THEMES);
		}
		return themes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Protagonist> getProtagonists() {
		if (protagonists == null) {
			protagonists = new EObjectResolvingEList<Protagonist>(Protagonist.class, this, StoryPackage.STORY__PROTAGONISTS);
		}
		return protagonists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConditionalProtagonist> getConditionalprotagonists() {
		if (conditionalprotagonists == null) {
			conditionalprotagonists = new EObjectContainmentEList<ConditionalProtagonist>(ConditionalProtagonist.class, this, StoryPackage.STORY__CONDITIONALPROTAGONISTS);
		}
		return conditionalprotagonists;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoal(String newGoal) {
		String oldGoal = goal;
		goal = newGoal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__GOAL, oldGoal, goal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBenefit() {
		return benefit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBenefit(String newBenefit) {
		String oldBenefit = benefit;
		benefit = newBenefit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__BENEFIT, oldBenefit, benefit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, StoryPackage.STORY__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompleted(boolean newCompleted) {
		boolean oldCompleted = completed;
		completed = newCompleted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StoryPackage.STORY__COMPLETED, oldCompleted, completed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Goal> getRealizes() {
		if (realizes == null) {
			realizes = new EObjectResolvingEList<Goal>(Goal.class, this, StoryPackage.STORY__REALIZES);
		}
		return realizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StoryPackage.STORY__ACCEPTANCECRITERIA:
				return ((InternalEList<?>)getAcceptancecriteria()).basicRemove(otherEnd, msgs);
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
			case StoryPackage.STORY__ACCEPTANCECRITERIA:
				return getAcceptancecriteria();
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
			case StoryPackage.STORY__ACCEPTANCECRITERIA:
				getAcceptancecriteria().clear();
				getAcceptancecriteria().addAll((Collection<? extends AcceptanceCriterion>)newValue);
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
			case StoryPackage.STORY__ACCEPTANCECRITERIA:
				getAcceptancecriteria().clear();
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
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case StoryPackage.STORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StoryPackage.STORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case StoryPackage.STORY__ACCEPTANCECRITERIA:
				return acceptancecriteria != null && !acceptancecriteria.isEmpty();
			case StoryPackage.STORY__DEPENDS:
				return depends != null && !depends.isEmpty();
			case StoryPackage.STORY__THEMES:
				return themes != null && !themes.isEmpty();
			case StoryPackage.STORY__PROTAGONISTS:
				return protagonists != null && !protagonists.isEmpty();
			case StoryPackage.STORY__CONDITIONALPROTAGONISTS:
				return conditionalprotagonists != null && !conditionalprotagonists.isEmpty();
			case StoryPackage.STORY__GOAL:
				return GOAL_EDEFAULT == null ? goal != null : !GOAL_EDEFAULT.equals(goal);
			case StoryPackage.STORY__BENEFIT:
				return BENEFIT_EDEFAULT == null ? benefit != null : !BENEFIT_EDEFAULT.equals(benefit);
			case StoryPackage.STORY__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case StoryPackage.STORY__COMPLETED:
				return completed != COMPLETED_EDEFAULT;
			case StoryPackage.STORY__REALIZES:
				return realizes != null && !realizes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", goal: ");
		result.append(goal);
		result.append(", benefit: ");
		result.append(benefit);
		result.append(", completed: ");
		result.append(completed);
		result.append(')');
		return result.toString();
	}

} //StoryImpl
