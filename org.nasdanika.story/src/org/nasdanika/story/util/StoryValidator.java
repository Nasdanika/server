/**
 */
package org.nasdanika.story.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

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
		if (!validate_NoCircularContainment(catalog, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(catalog, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(catalog, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCatalogElement(CatalogElement catalogElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(catalogElement, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(catalogElement, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(catalogElement, diagnostics, context);
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
		if (!validate_NoCircularContainment(storyBase, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(storyBase, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(storyBase, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStoryContainer(StoryContainer storyContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(storyContainer, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(storyContainer, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(storyContainer, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProtagonist(Protagonist protagonist, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(protagonist, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(protagonist, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(protagonist, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRole(Role role, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(role, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(role, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(role, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(role, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActor(Actor actor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actor, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(actor, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUser(User user, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(user, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(user, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(user, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(user, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(org.nasdanika.story.System system, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(system, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(system, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(system, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePersona(Persona persona, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(persona, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(persona, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(persona, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEpic(Epic epic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(epic, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(epic, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(epic, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTheme(Theme theme, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(theme, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(theme, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(theme, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStory(Story story, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(story, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(story, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(story, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(story, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario(Scenario scenario, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scenario, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateCatalogElement_validate(scenario, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionalProtagonist(ConditionalProtagonist conditionalProtagonist, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conditionalProtagonist, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(goal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
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
