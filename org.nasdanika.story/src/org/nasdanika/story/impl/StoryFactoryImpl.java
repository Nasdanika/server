/**
 */
package org.nasdanika.story.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.story.Catalog;
import org.nasdanika.story.ConditionalProtagonist;
import org.nasdanika.story.Epic;
import org.nasdanika.story.Goal;
import org.nasdanika.story.Parameter;
import org.nasdanika.story.Persona;
import org.nasdanika.story.Role;
import org.nasdanika.story.Scenario;
import org.nasdanika.story.Story;
import org.nasdanika.story.StoryFactory;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.Theme;
import org.nasdanika.story.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryFactoryImpl extends EFactoryImpl implements StoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StoryFactory init() {
		try {
			StoryFactory theStoryFactory = (StoryFactory)EPackage.Registry.INSTANCE.getEFactory(StoryPackage.eNS_URI);
			if (theStoryFactory != null) {
				return theStoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StoryPackage.CATALOG: return (EObject)createCatalog();
			case StoryPackage.ROLE: return (EObject)createRole();
			case StoryPackage.USER: return (EObject)createUser();
			case StoryPackage.SYSTEM: return (EObject)createSystem();
			case StoryPackage.PERSONA: return (EObject)createPersona();
			case StoryPackage.EPIC: return (EObject)createEpic();
			case StoryPackage.THEME: return (EObject)createTheme();
			case StoryPackage.STORY: return (EObject)createStory();
			case StoryPackage.SCENARIO: return (EObject)createScenario();
			case StoryPackage.CONDITIONAL_PROTAGONIST: return (EObject)createConditionalProtagonist();
			case StoryPackage.GOAL: return (EObject)createGoal();
			case StoryPackage.PARAMETER: return (EObject)createParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Catalog createCatalog() {
		CatalogImpl catalog = new CatalogImpl();
		return catalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Role createRole() {
		RoleImpl role = new RoleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.story.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Persona createPersona() {
		PersonaImpl persona = new PersonaImpl();
		return persona;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Epic createEpic() {
		EpicImpl epic = new EpicImpl();
		return epic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Theme createTheme() {
		ThemeImpl theme = new ThemeImpl();
		return theme;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Story createStory() {
		StoryImpl story = new StoryImpl();
		return story;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalProtagonist createConditionalProtagonist() {
		ConditionalProtagonistImpl conditionalProtagonist = new ConditionalProtagonistImpl();
		return conditionalProtagonist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryPackage getStoryPackage() {
		return (StoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StoryPackage getPackage() {
		return StoryPackage.eINSTANCE;
	}

} //StoryFactoryImpl
