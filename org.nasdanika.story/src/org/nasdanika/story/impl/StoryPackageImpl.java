/**
 */
package org.nasdanika.story.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
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
import org.nasdanika.story.StoryFactory;
import org.nasdanika.story.StoryPackage;
import org.nasdanika.story.Theme;
import org.nasdanika.story.User;
import org.nasdanika.story.util.StoryValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StoryPackageImpl extends EPackageImpl implements StoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catalogEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catalogElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass protagonistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass epicEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass themeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scenarioEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionalProtagonistEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.nasdanika.story.StoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StoryPackageImpl() {
		super(eNS_URI, StoryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link StoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StoryPackage init() {
		if (isInited) return (StoryPackage)EPackage.Registry.INSTANCE.getEPackage(StoryPackage.eNS_URI);

		// Obtain or create and register package
		StoryPackageImpl theStoryPackage = (StoryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StoryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StoryPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStoryPackage.createPackageContents();

		// Initialize created meta-data
		theStoryPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theStoryPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return StoryValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theStoryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StoryPackage.eNS_URI, theStoryPackage);
		return theStoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatalog() {
		return catalogEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatalog_Elements() {
		return (EReference)catalogEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatalogElement() {
		return catalogElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalogElement_Id() {
		return (EAttribute)catalogElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalogElement_Name() {
		return (EAttribute)catalogElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatalogElement_Description() {
		return (EAttribute)catalogElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCatalogElement__Validate__DiagnosticChain_Map() {
		return catalogElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoryBase() {
		return storyBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoryContainer() {
		return storyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoryContainer_Stories() {
		return (EReference)storyContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProtagonist() {
		return protagonistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProtagonist_LinkTo() {
		return (EReference)protagonistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_SubRoles() {
		return (EReference)roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRole_SuperRoles() {
		return (EReference)roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Roles() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_SubActors() {
		return (EReference)actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_SuperActors() {
		return (EReference)actorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersona() {
		return personaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPersona_Picture() {
		return (EAttribute)personaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersona_Goals() {
		return (EReference)personaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEpic() {
		return epicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTheme() {
		return themeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTheme_Children() {
		return (EReference)themeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStory() {
		return storyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Scenarios() {
		return (EReference)storyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Depends() {
		return (EReference)storyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Themes() {
		return (EReference)storyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Protagonists() {
		return (EReference)storyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Conditionalprotagonists() {
		return (EReference)storyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStory_Goal() {
		return (EAttribute)storyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStory_Benefit() {
		return (EAttribute)storyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Parameters() {
		return (EReference)storyEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStory_Completed() {
		return (EAttribute)storyEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStory_Realizes() {
		return (EReference)storyEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScenario() {
		return scenarioEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScenario_Context() {
		return (EAttribute)scenarioEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScenario_Action() {
		return (EAttribute)scenarioEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScenario_Outcome() {
		return (EAttribute)scenarioEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionalProtagonist() {
		return conditionalProtagonistEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionalProtagonist_Protagonist() {
		return (EReference)conditionalProtagonistEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionalProtagonist_Condition() {
		return (EAttribute)conditionalProtagonistEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoal() {
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoal_Name() {
		return (EAttribute)goalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoal_Details() {
		return (EAttribute)goalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Type() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Description() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoryFactory getStoryFactory() {
		return (StoryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		catalogEClass = createEClass(CATALOG);
		createEReference(catalogEClass, CATALOG__ELEMENTS);

		catalogElementEClass = createEClass(CATALOG_ELEMENT);
		createEAttribute(catalogElementEClass, CATALOG_ELEMENT__ID);
		createEAttribute(catalogElementEClass, CATALOG_ELEMENT__NAME);
		createEAttribute(catalogElementEClass, CATALOG_ELEMENT__DESCRIPTION);
		createEOperation(catalogElementEClass, CATALOG_ELEMENT___VALIDATE__DIAGNOSTICCHAIN_MAP);

		storyBaseEClass = createEClass(STORY_BASE);

		storyContainerEClass = createEClass(STORY_CONTAINER);
		createEReference(storyContainerEClass, STORY_CONTAINER__STORIES);

		protagonistEClass = createEClass(PROTAGONIST);
		createEReference(protagonistEClass, PROTAGONIST__LINK_TO);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__SUB_ROLES);
		createEReference(roleEClass, ROLE__SUPER_ROLES);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__ROLES);
		createEReference(actorEClass, ACTOR__SUB_ACTORS);
		createEReference(actorEClass, ACTOR__SUPER_ACTORS);

		userEClass = createEClass(USER);

		systemEClass = createEClass(SYSTEM);

		personaEClass = createEClass(PERSONA);
		createEAttribute(personaEClass, PERSONA__PICTURE);
		createEReference(personaEClass, PERSONA__GOALS);

		epicEClass = createEClass(EPIC);

		themeEClass = createEClass(THEME);
		createEReference(themeEClass, THEME__CHILDREN);

		storyEClass = createEClass(STORY);
		createEReference(storyEClass, STORY__SCENARIOS);
		createEReference(storyEClass, STORY__DEPENDS);
		createEReference(storyEClass, STORY__THEMES);
		createEReference(storyEClass, STORY__PROTAGONISTS);
		createEReference(storyEClass, STORY__CONDITIONALPROTAGONISTS);
		createEAttribute(storyEClass, STORY__GOAL);
		createEAttribute(storyEClass, STORY__BENEFIT);
		createEReference(storyEClass, STORY__PARAMETERS);
		createEAttribute(storyEClass, STORY__COMPLETED);
		createEReference(storyEClass, STORY__REALIZES);

		scenarioEClass = createEClass(SCENARIO);
		createEAttribute(scenarioEClass, SCENARIO__CONTEXT);
		createEAttribute(scenarioEClass, SCENARIO__ACTION);
		createEAttribute(scenarioEClass, SCENARIO__OUTCOME);

		conditionalProtagonistEClass = createEClass(CONDITIONAL_PROTAGONIST);
		createEReference(conditionalProtagonistEClass, CONDITIONAL_PROTAGONIST__PROTAGONIST);
		createEAttribute(conditionalProtagonistEClass, CONDITIONAL_PROTAGONIST__CONDITION);

		goalEClass = createEClass(GOAL);
		createEAttribute(goalEClass, GOAL__NAME);
		createEAttribute(goalEClass, GOAL__DETAILS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEAttribute(parameterEClass, PARAMETER__TYPE);
		createEAttribute(parameterEClass, PARAMETER__DESCRIPTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		catalogEClass.getESuperTypes().add(this.getCatalogElement());
		storyBaseEClass.getESuperTypes().add(this.getCatalogElement());
		storyContainerEClass.getESuperTypes().add(this.getCatalogElement());
		protagonistEClass.getESuperTypes().add(this.getStoryContainer());
		roleEClass.getESuperTypes().add(this.getProtagonist());
		actorEClass.getESuperTypes().add(this.getProtagonist());
		userEClass.getESuperTypes().add(this.getActor());
		systemEClass.getESuperTypes().add(this.getActor());
		personaEClass.getESuperTypes().add(this.getUser());
		epicEClass.getESuperTypes().add(this.getStoryContainer());
		epicEClass.getESuperTypes().add(this.getStoryBase());
		themeEClass.getESuperTypes().add(this.getCatalogElement());
		storyEClass.getESuperTypes().add(this.getStoryBase());
		scenarioEClass.getESuperTypes().add(this.getCatalogElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(catalogEClass, Catalog.class, "Catalog", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCatalog_Elements(), this.getCatalogElement(), null, "elements", null, 0, -1, Catalog.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catalogElementEClass, CatalogElement.class, "CatalogElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCatalogElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, CatalogElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalogElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, CatalogElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCatalogElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, CatalogElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getCatalogElement__Validate__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(storyBaseEClass, StoryBase.class, "StoryBase", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(storyContainerEClass, StoryContainer.class, "StoryContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStoryContainer_Stories(), this.getStoryBase(), null, "stories", null, 0, -1, StoryContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(protagonistEClass, Protagonist.class, "Protagonist", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProtagonist_LinkTo(), theEcorePackage.getEClass(), null, "linkTo", null, 0, 1, Protagonist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_SubRoles(), this.getRole(), null, "subRoles", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRole_SuperRoles(), this.getRole(), null, "superRoles", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, Actor.class, "Actor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_Roles(), this.getRole(), null, "roles", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_SubActors(), this.getActor(), null, "subActors", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_SuperActors(), this.getActor(), null, "superActors", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemEClass, org.nasdanika.story.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(personaEClass, Persona.class, "Persona", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPersona_Picture(), theEcorePackage.getEString(), "picture", null, 0, 1, Persona.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersona_Goals(), this.getGoal(), null, "goals", null, 0, -1, Persona.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(epicEClass, Epic.class, "Epic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(themeEClass, Theme.class, "Theme", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTheme_Children(), this.getTheme(), null, "children", null, 0, -1, Theme.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storyEClass, Story.class, "Story", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStory_Scenarios(), this.getScenario(), null, "scenarios", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Depends(), this.getStory(), null, "depends", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Themes(), this.getTheme(), null, "themes", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Protagonists(), this.getProtagonist(), null, "protagonists", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Conditionalprotagonists(), this.getConditionalProtagonist(), null, "conditionalprotagonists", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStory_Goal(), theEcorePackage.getEString(), "goal", null, 0, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStory_Benefit(), theEcorePackage.getEString(), "benefit", null, 0, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStory_Completed(), theEcorePackage.getEBoolean(), "completed", null, 0, 1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStory_Realizes(), this.getGoal(), null, "realizes", null, 0, -1, Story.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scenarioEClass, Scenario.class, "Scenario", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScenario_Context(), theEcorePackage.getEString(), "context", null, 0, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScenario_Action(), theEcorePackage.getEString(), "action", null, 0, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScenario_Outcome(), theEcorePackage.getEString(), "outcome", null, 0, 1, Scenario.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalProtagonistEClass, ConditionalProtagonist.class, "ConditionalProtagonist", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalProtagonist_Protagonist(), this.getProtagonist(), null, "protagonist", null, 1, -1, ConditionalProtagonist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionalProtagonist_Condition(), theEcorePackage.getEString(), "condition", null, 0, 1, ConditionalProtagonist.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoal_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoal_Details(), theEcorePackage.getEString(), "details", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Type(), theEcorePackage.getEString(), "type", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Description(), theEcorePackage.getEString(), "description", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGenModelAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/GenModel";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "documentation", "Story model allows to capture agile (user) stories in the form of a model which can reference the domain model and be linked to the domain model, e.g. route operations may reference user stories they are used by. The story model can be used for documentation, to link test results to acceptance criteria (also as part of online documentation), and for story-based entitlements - operations reference stories, and users are granted entitlements execute stories, or users are granted roles, which in turn are linked to stories.\r\n\r\n![Class diagram](bundle:org.nasdanika.story/doc/story.png)"
		   });	
		addAnnotation
		  (catalogEClass, 
		   source, 
		   new String[] {
			 "documentation", "Generic container for [[Story|Stories]], [[Actor|Actors]], [[Role|Roles]], [[Epic|Epics]], [[Theme|Themes]], ..."
		   });	
		addAnnotation
		  (getCatalog_Elements(), 
		   source, 
		   new String[] {
			 "documentation", "Catalog elements."
		   });	
		addAnnotation
		  (catalogElementEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base interface for model elements which can be added to a catalog."
		   });	
		addAnnotation
		  (getCatalogElement__Validate__DiagnosticChain_Map(), 
		   source, 
		   new String[] {
			 "documentation", "Validates element for execution/generation. Adds messages to diagnostics and "
		   });	
		addAnnotation
		  ((getCatalogElement__Validate__DiagnosticChain_Map()).getEParameters().get(0), 
		   source, 
		   new String[] {
			 "documentation", "Diagnostics to add validation messages to."
		   });	
		addAnnotation
		  ((getCatalogElement__Validate__DiagnosticChain_Map()).getEParameters().get(1), 
		   source, 
		   new String[] {
			 "documentation", "Validation context."
		   });	
		addAnnotation
		  (getCatalogElement_Id(), 
		   source, 
		   new String[] {
			 "documentation", "Unique, in the containing resource, catalog element identifier. Identifiers are automatically generated when an element is added to a catalog."
		   });	
		addAnnotation
		  (getCatalogElement_Name(), 
		   source, 
		   new String[] {
			 "documentation", "Element name."
		   });	
		addAnnotation
		  (getCatalogElement_Description(), 
		   source, 
		   new String[] {
			 "documentation", "Element description. Supports markdown. Some catalog elements may hide description attribute."
		   });	
		addAnnotation
		  (storyBaseEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base interface for stories and epics"
		   });	
		addAnnotation
		  (storyContainerEClass, 
		   source, 
		   new String[] {
			 "documentation", "Container of stories."
		   });	
		addAnnotation
		  (getStoryContainer_Stories(), 
		   source, 
		   new String[] {
			 "documentation", "Story container may contain zero or more stories or epics."
		   });	
		addAnnotation
		  (protagonistEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base interface representing the main character of a story. Protagonists may contain stories, in this case the containing protagonist becomes an implicit protagonist of the contained stories."
		   });	
		addAnnotation
		  (getProtagonist_LinkTo(), 
		   source, 
		   new String[] {
			 "documentation", "Protagonist can be linked to EClass. In this case protagonist documentation is displayed as a tab in the EClass documentation and \r\nuser stories are mounted under the target EClass in the documentation tree."
		   });	
		addAnnotation
		  (roleEClass, 
		   source, 
		   new String[] {
			 "documentation", "Actor role."
		   });	
		addAnnotation
		  (getRole_SubRoles(), 
		   source, 
		   new String[] {
			 "documentation", "A role may contain zero or more sub-roles. Sub-roles inherit super-role stories."
		   });	
		addAnnotation
		  (getRole_SuperRoles(), 
		   source, 
		   new String[] {
			 "documentation", "A role may reference zero or more roles as its super-roles. \r\nThe role inherits super-role stories."
		   });	
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "documentation", "Base interface for actors."
		   });	
		addAnnotation
		  (getActor_Roles(), 
		   source, 
		   new String[] {
			 "documentation", "Actor can play zero or more roles."
		   });	
		addAnnotation
		  (getActor_SubActors(), 
		   source, 
		   new String[] {
			 "documentation", "Sub-actors may be contained by the super-actor to form a single-inheritance hierarchy. Multiple inheritance can be set up with superActors reference."
		   });	
		addAnnotation
		  (getActor_SuperActors(), 
		   source, 
		   new String[] {
			 "documentation", "Actors form a multiple inheritance hierarcy and may have zero or more super-actors. All stories and roles played by by a super-actor are also played by its sub-actors."
		   });	
		addAnnotation
		  (userEClass, 
		   source, 
		   new String[] {
			 "documentation", "A human actor."
		   });	
		addAnnotation
		  (systemEClass, 
		   source, 
		   new String[] {
			 "documentation", "A system actor."
		   });	
		addAnnotation
		  (personaEClass, 
		   source, 
		   new String[] {
			 "documentation", "Agile persona."
		   });	
		addAnnotation
		  (getPersona_Picture(), 
		   source, 
		   new String[] {
			 "documentation", "URL of the picture relative to the containing resource."
		   });	
		addAnnotation
		  (getPersona_Goals(), 
		   source, 
		   new String[] {
			 "documentation", "A persona may have zero or more goals."
		   });	
		addAnnotation
		  (epicEClass, 
		   source, 
		   new String[] {
			 "documentation", "Epic is used to group stories."
		   });	
		addAnnotation
		  (themeEClass, 
		   source, 
		   new String[] {
			 "documentation", "Theme is a cross-cutting concern, e.g. performance."
		   });	
		addAnnotation
		  (getTheme_Children(), 
		   source, 
		   new String[] {
			 "documentation", "Themes can be organized into a hierarchy."
		   });	
		addAnnotation
		  (getStory_Scenarios(), 
		   source, 
		   new String[] {
			 "documentation", "A story may contain zero or more acceptance criteria."
		   });	
		addAnnotation
		  (getStory_Depends(), 
		   source, 
		   new String[] {
			 "documentation", "A story may depend (include, use) other user stories. E.g. ``edit`` user story may depend on ``view`` user story, \r\ni.e. a user need to view something first in order to edit it."
		   });	
		addAnnotation
		  (getStory_Themes(), 
		   source, 
		   new String[] {
			 "documentation", "User story may be associated with zero or more themes."
		   });	
		addAnnotation
		  (getStory_Protagonists(), 
		   source, 
		   new String[] {
			 "documentation", "A story shall have at least one protagonist. If a story is played by multiple types of protagonists, more than one protagonist can be set for the story to obviate artificial generalization relationships between protagonists."
		   });	
		addAnnotation
		  (getStory_Conditionalprotagonists(), 
		   source, 
		   new String[] {
			 "documentation", "Some story protagonists may be defined as conditional. For example ``Approve credit application``\r\nstory may have a conditional protagonist with credit amount used in the condition."
		   });	
		addAnnotation
		  (getStory_Goal(), 
		   source, 
		   new String[] {
			 "documentation", "Story goal (I want)."
		   });	
		addAnnotation
		  (getStory_Benefit(), 
		   source, 
		   new String[] {
			 "documentation", "Story benefit (So that)."
		   });	
		addAnnotation
		  (getStory_Parameters(), 
		   source, 
		   new String[] {
			 "documentation", "A story may have parameters, e.g. ``Approve credit application`` story may have parameter ``creditAmount``."
		   });	
		addAnnotation
		  (getStory_Completed(), 
		   source, 
		   new String[] {
			 "documentation", "Completed flag."
		   });	
		addAnnotation
		  (getScenario_Context(), 
		   source, 
		   new String[] {
			 "documentation", "Context (Given)."
		   });	
		addAnnotation
		  (getScenario_Action(), 
		   source, 
		   new String[] {
			 "documentation", "Action (when)."
		   });	
		addAnnotation
		  (getScenario_Outcome(), 
		   source, 
		   new String[] {
			 "documentation", "Outcome (then)."
		   });	
		addAnnotation
		  (getConditionalProtagonist_Protagonist(), 
		   source, 
		   new String[] {
			 "documentation", "References one or more protagonists."
		   });	
		addAnnotation
		  (getConditionalProtagonist_Condition(), 
		   source, 
		   new String[] {
			 "documentation", "Condition in JavaScript, e.g. amount<5000.00\r\n"
		   });	
		addAnnotation
		  (goalEClass, 
		   source, 
		   new String[] {
			 "documentation", "Persona\'s goal."
		   });	
		addAnnotation
		  (parameterEClass, 
		   source, 
		   new String[] {
			 "documentation", "Story parameter"
		   });
	}

} //StoryPackageImpl
