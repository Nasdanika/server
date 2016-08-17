/**
 */
package org.nasdanika.story.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.nasdanika.story.Actor;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.CatalogElement;
import org.nasdanika.story.ConditionalProtagonist;
import org.nasdanika.story.Epic;
import org.nasdanika.story.Goal;
import org.nasdanika.story.Parameter;
import org.nasdanika.story.Persona;
import org.nasdanika.story.Protagonist;
import org.nasdanika.story.Role;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.State;
import org.nasdanika.story.StateContainer;
import org.nasdanika.story.Step;
import org.nasdanika.story.Story;
import org.nasdanika.story.StoryBase;
import org.nasdanika.story.StoryContainer;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.Theme;
import org.nasdanika.story.User;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.story.StoryPackage
 * @generated
 */
public class StoryValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final StoryValidator INSTANCE = new StoryValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.nasdanika.story";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Validate' of 'Catalog Element'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int CATALOG_ELEMENT__VALIDATE = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return StoryPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case StoryPackage.CATALOG:
				return validateCatalog((Catalog)value, diagnostics, context);
			case StoryPackage.CATALOG_ELEMENT:
				return validateCatalogElement((CatalogElement)value, diagnostics, context);
			case StoryPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case StoryPackage.STATE_CONTAINER:
				return validateStateContainer((StateContainer)value, diagnostics, context);
			case StoryPackage.STORY_BASE:
				return validateStoryBase((StoryBase)value, diagnostics, context);
			case StoryPackage.STORY_CONTAINER:
				return validateStoryContainer((StoryContainer)value, diagnostics, context);
			case StoryPackage.PROTAGONIST:
				return validateProtagonist((Protagonist)value, diagnostics, context);
			case StoryPackage.ROLE:
				return validateRole((Role)value, diagnostics, context);
			case StoryPackage.ACTOR:
				return validateActor((Actor)value, diagnostics, context);
			case StoryPackage.USER:
				return validateUser((User)value, diagnostics, context);
			case StoryPackage.SYSTEM:
				return validateSystem((org.nasdanika.story.System)value, diagnostics, context);
			case StoryPackage.PERSONA:
				return validatePersona((Persona)value, diagnostics, context);
			case StoryPackage.EPIC:
				return validateEpic((Epic)value, diagnostics, context);
			case StoryPackage.THEME:
				return validateTheme((Theme)value, diagnostics, context);
			case StoryPackage.STORY:
				return validateStory((Story)value, diagnostics, context);
			case StoryPackage.SCENARIO:
				return validateScenario((Scenario)value, diagnostics, context);
			case StoryPackage.STEP:
				return validateStep((Step)value, diagnostics, context);
			case StoryPackage.CONDITIONAL_PROTAGONIST:
				return validateConditionalProtagonist((ConditionalProtagonist)value, diagnostics, context);
			case StoryPackage.GOAL:
				return validateGoal((Goal)value, diagnostics, context);
			case StoryPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCatalog(Catalog catalog, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)catalog, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(catalog, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCatalogElement(CatalogElement catalogElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)catalogElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(catalogElement, diagnostics, context);
		return result;
	}

	/**
	 * Validates the validate constraint of '<em>Catalog Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCatalogElement_validate(CatalogElement catalogElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return catalogElement.validate(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStoryBase(StoryBase storyBase, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)storyBase, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(storyBase, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStoryContainer(StoryContainer storyContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)storyContainer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(storyContainer, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtagonist(Protagonist protagonist, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)protagonist, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(protagonist, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole(Role role, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)role, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)role, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(role, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)actor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)actor, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(actor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUser(User user, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)user, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)user, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(user, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(org.nasdanika.story.System system, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)system, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)system, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(system, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePersona(Persona persona, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)persona, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)persona, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(persona, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEpic(Epic epic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)epic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)epic, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(epic, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTheme(Theme theme, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)theme, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)theme, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(theme, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStory(Story story, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)story, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)story, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(story, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)scenario, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(scenario, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStep(Step step, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)step, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalProtagonist(ConditionalProtagonist conditionalProtagonist, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)conditionalProtagonist, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)goal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint((EObject)parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)state, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)state, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(state, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStateContainer(StateContainer stateContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment((EObject)stateContainer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique((EObject)stateContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(stateContainer, diagnostics, context);
		return result;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //StoryValidator
