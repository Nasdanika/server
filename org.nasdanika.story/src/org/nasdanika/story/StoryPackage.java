/**
 */
package org.nasdanika.story;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * Story model allows to capture agile (user) stories in the form of a model which can reference the domain model and be linked to the domain model, e.g. route operations may reference user stories they are used by. The story model can be used for documentation, to link test results to acceptance criteria (also as part of online documentation), and for story-based entitlements - operations reference stories, and users are granted entitlements execute stories, or users are granted roles, which in turn are linked to stories.
 * <!-- end-model-doc -->
 * @see org.nasdanika.story.StoryFactory
 * @model kind="package"
 * @generated
 */
public interface StoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "story";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.story";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.story";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StoryPackage eINSTANCE = org.nasdanika.story.impl.StoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.story.CatalogElement <em>Catalog Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.CatalogElement
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getCatalogElement()
	 * @generated
	 */
	int CATALOG_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_ELEMENT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Catalog Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Catalog Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.CatalogImpl <em>Catalog</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.CatalogImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getCatalog()
	 * @generated
	 */
	int CATALOG = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__ID = CATALOG_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__NAME = CATALOG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__DESCRIPTION = CATALOG_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG__ELEMENTS = CATALOG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_FEATURE_COUNT = CATALOG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Catalog</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATALOG_OPERATION_COUNT = CATALOG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.StoryBase <em>Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.StoryBase
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getStoryBase()
	 * @generated
	 */
	int STORY_BASE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_BASE__ID = CATALOG_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_BASE__NAME = CATALOG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_BASE__DESCRIPTION = CATALOG_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_BASE_FEATURE_COUNT = CATALOG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_BASE_OPERATION_COUNT = CATALOG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.StoryContainer <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.StoryContainer
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getStoryContainer()
	 * @generated
	 */
	int STORY_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_CONTAINER__ID = CATALOG_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_CONTAINER__NAME = CATALOG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_CONTAINER__DESCRIPTION = CATALOG_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_CONTAINER__STORIES = CATALOG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_CONTAINER_FEATURE_COUNT = CATALOG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_CONTAINER_OPERATION_COUNT = CATALOG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.ProtagonistImpl <em>Protagonist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.ProtagonistImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getProtagonist()
	 * @generated
	 */
	int PROTAGONIST = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST__ID = STORY_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST__NAME = STORY_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST__DESCRIPTION = STORY_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST__STORIES = STORY_CONTAINER__STORIES;

	/**
	 * The feature id for the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST__LINK_TO = STORY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Protagonist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST_FEATURE_COUNT = STORY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Protagonist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROTAGONIST_OPERATION_COUNT = STORY_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.RoleImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ID = PROTAGONIST__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NAME = PROTAGONIST__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__DESCRIPTION = PROTAGONIST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__STORIES = PROTAGONIST__STORIES;

	/**
	 * The feature id for the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__LINK_TO = PROTAGONIST__LINK_TO;

	/**
	 * The feature id for the '<em><b>Sub Roles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SUB_ROLES = PROTAGONIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SUPER_ROLES = PROTAGONIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = PROTAGONIST_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = PROTAGONIST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.ActorImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ID = PROTAGONIST__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = PROTAGONIST__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DESCRIPTION = PROTAGONIST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__STORIES = PROTAGONIST__STORIES;

	/**
	 * The feature id for the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LINK_TO = PROTAGONIST__LINK_TO;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__ROLES = PROTAGONIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__SUB_ACTORS = PROTAGONIST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__SUPER_ACTORS = PROTAGONIST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = PROTAGONIST_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_OPERATION_COUNT = PROTAGONIST_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.UserImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getUser()
	 * @generated
	 */
	int USER = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ID = ACTOR__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DESCRIPTION = ACTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__STORIES = ACTOR__STORIES;

	/**
	 * The feature id for the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LINK_TO = ACTOR__LINK_TO;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ROLES = ACTOR__ROLES;

	/**
	 * The feature id for the '<em><b>Sub Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__SUB_ACTORS = ACTOR__SUB_ACTORS;

	/**
	 * The feature id for the '<em><b>Super Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__SUPER_ACTORS = ACTOR__SUPER_ACTORS;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = ACTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = ACTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.SystemImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ID = ACTOR__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NAME = ACTOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DESCRIPTION = ACTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__STORIES = ACTOR__STORIES;

	/**
	 * The feature id for the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LINK_TO = ACTOR__LINK_TO;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__ROLES = ACTOR__ROLES;

	/**
	 * The feature id for the '<em><b>Sub Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SUB_ACTORS = ACTOR__SUB_ACTORS;

	/**
	 * The feature id for the '<em><b>Super Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__SUPER_ACTORS = ACTOR__SUPER_ACTORS;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = ACTOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = ACTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.PersonaImpl <em>Persona</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.PersonaImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getPersona()
	 * @generated
	 */
	int PERSONA = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__ID = USER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__NAME = USER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__DESCRIPTION = USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__STORIES = USER__STORIES;

	/**
	 * The feature id for the '<em><b>Link To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__LINK_TO = USER__LINK_TO;

	/**
	 * The feature id for the '<em><b>Roles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__ROLES = USER__ROLES;

	/**
	 * The feature id for the '<em><b>Sub Actors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__SUB_ACTORS = USER__SUB_ACTORS;

	/**
	 * The feature id for the '<em><b>Super Actors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__SUPER_ACTORS = USER__SUPER_ACTORS;

	/**
	 * The feature id for the '<em><b>Picture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__PICTURE = USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA__GOALS = USER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Persona</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA_FEATURE_COUNT = USER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Persona</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONA_OPERATION_COUNT = USER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.EpicImpl <em>Epic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.EpicImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getEpic()
	 * @generated
	 */
	int EPIC = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIC__ID = STORY_CONTAINER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIC__NAME = STORY_CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIC__DESCRIPTION = STORY_CONTAINER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Stories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIC__STORIES = STORY_CONTAINER__STORIES;

	/**
	 * The number of structural features of the '<em>Epic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIC_FEATURE_COUNT = STORY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Epic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EPIC_OPERATION_COUNT = STORY_CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.ThemeImpl <em>Theme</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.ThemeImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getTheme()
	 * @generated
	 */
	int THEME = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME__ID = CATALOG_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME__NAME = CATALOG_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME__DESCRIPTION = CATALOG_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME__CHILDREN = CATALOG_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Theme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_FEATURE_COUNT = CATALOG_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Theme</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEME_OPERATION_COUNT = CATALOG_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.StoryImpl <em>Story</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.StoryImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getStory()
	 * @generated
	 */
	int STORY = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__ID = STORY_BASE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__NAME = STORY_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__DESCRIPTION = STORY_BASE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Acceptancecriteria</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__ACCEPTANCECRITERIA = STORY_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__DEPENDS = STORY_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Themes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__THEMES = STORY_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Protagonists</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__PROTAGONISTS = STORY_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Conditionalprotagonists</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__CONDITIONALPROTAGONISTS = STORY_BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__GOAL = STORY_BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Benefit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__BENEFIT = STORY_BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__PARAMETERS = STORY_BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Completed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__COMPLETED = STORY_BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY__REALIZES = STORY_BASE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Story</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_FEATURE_COUNT = STORY_BASE_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Story</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORY_OPERATION_COUNT = STORY_BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.AcceptanceCriterionImpl <em>Acceptance Criterion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.AcceptanceCriterionImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getAcceptanceCriterion()
	 * @generated
	 */
	int ACCEPTANCE_CRITERION = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTANCE_CRITERION__ID = 0;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTANCE_CRITERION__CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTANCE_CRITERION__ACTION = 2;

	/**
	 * The feature id for the '<em><b>Outcome</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTANCE_CRITERION__OUTCOME = 3;

	/**
	 * The number of structural features of the '<em>Acceptance Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTANCE_CRITERION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Acceptance Criterion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCEPTANCE_CRITERION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.ConditionalProtagonistImpl <em>Conditional Protagonist</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.ConditionalProtagonistImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getConditionalProtagonist()
	 * @generated
	 */
	int CONDITIONAL_PROTAGONIST = 14;

	/**
	 * The feature id for the '<em><b>Protagonist</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROTAGONIST__PROTAGONIST = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROTAGONIST__CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Conditional Protagonist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROTAGONIST_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Conditional Protagonist</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_PROTAGONIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.GoalImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Details</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DETAILS = 1;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.story.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.story.impl.ParameterImpl
	 * @see org.nasdanika.story.impl.StoryPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Catalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog</em>'.
	 * @see org.nasdanika.story.Catalog
	 * @generated
	 */
	EClass getCatalog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Catalog#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.nasdanika.story.Catalog#getElements()
	 * @see #getCatalog()
	 * @generated
	 */
	EReference getCatalog_Elements();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.CatalogElement <em>Catalog Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Catalog Element</em>'.
	 * @see org.nasdanika.story.CatalogElement
	 * @generated
	 */
	EClass getCatalogElement();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.CatalogElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.nasdanika.story.CatalogElement#getId()
	 * @see #getCatalogElement()
	 * @generated
	 */
	EAttribute getCatalogElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.CatalogElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.story.CatalogElement#getName()
	 * @see #getCatalogElement()
	 * @generated
	 */
	EAttribute getCatalogElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.CatalogElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.story.CatalogElement#getDescription()
	 * @see #getCatalogElement()
	 * @generated
	 */
	EAttribute getCatalogElement_Description();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.StoryBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base</em>'.
	 * @see org.nasdanika.story.StoryBase
	 * @generated
	 */
	EClass getStoryBase();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.StoryContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see org.nasdanika.story.StoryContainer
	 * @generated
	 */
	EClass getStoryContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.StoryContainer#getStories <em>Stories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stories</em>'.
	 * @see org.nasdanika.story.StoryContainer#getStories()
	 * @see #getStoryContainer()
	 * @generated
	 */
	EReference getStoryContainer_Stories();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Protagonist <em>Protagonist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Protagonist</em>'.
	 * @see org.nasdanika.story.Protagonist
	 * @generated
	 */
	EClass getProtagonist();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.story.Protagonist#getLinkTo <em>Link To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Link To</em>'.
	 * @see org.nasdanika.story.Protagonist#getLinkTo()
	 * @see #getProtagonist()
	 * @generated
	 */
	EReference getProtagonist_LinkTo();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.nasdanika.story.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Role#getSubRoles <em>Sub Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Roles</em>'.
	 * @see org.nasdanika.story.Role#getSubRoles()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_SubRoles();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Role#getSuperRoles <em>Super Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Roles</em>'.
	 * @see org.nasdanika.story.Role#getSuperRoles()
	 * @see #getRole()
	 * @generated
	 */
	EReference getRole_SuperRoles();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see org.nasdanika.story.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Actor#getRoles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Roles</em>'.
	 * @see org.nasdanika.story.Actor#getRoles()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_Roles();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Actor#getSubActors <em>Sub Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Actors</em>'.
	 * @see org.nasdanika.story.Actor#getSubActors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_SubActors();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Actor#getSuperActors <em>Super Actors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Actors</em>'.
	 * @see org.nasdanika.story.Actor#getSuperActors()
	 * @see #getActor()
	 * @generated
	 */
	EReference getActor_SuperActors();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see org.nasdanika.story.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.nasdanika.story.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Persona <em>Persona</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Persona</em>'.
	 * @see org.nasdanika.story.Persona
	 * @generated
	 */
	EClass getPersona();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Persona#getPicture <em>Picture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Picture</em>'.
	 * @see org.nasdanika.story.Persona#getPicture()
	 * @see #getPersona()
	 * @generated
	 */
	EAttribute getPersona_Picture();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Persona#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goals</em>'.
	 * @see org.nasdanika.story.Persona#getGoals()
	 * @see #getPersona()
	 * @generated
	 */
	EReference getPersona_Goals();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Epic <em>Epic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Epic</em>'.
	 * @see org.nasdanika.story.Epic
	 * @generated
	 */
	EClass getEpic();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Theme <em>Theme</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Theme</em>'.
	 * @see org.nasdanika.story.Theme
	 * @generated
	 */
	EClass getTheme();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Theme#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.story.Theme#getChildren()
	 * @see #getTheme()
	 * @generated
	 */
	EReference getTheme_Children();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Story <em>Story</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Story</em>'.
	 * @see org.nasdanika.story.Story
	 * @generated
	 */
	EClass getStory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Story#getAcceptancecriteria <em>Acceptancecriteria</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Acceptancecriteria</em>'.
	 * @see org.nasdanika.story.Story#getAcceptancecriteria()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Acceptancecriteria();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Story#getDepends <em>Depends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends</em>'.
	 * @see org.nasdanika.story.Story#getDepends()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Depends();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Story#getThemes <em>Themes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Themes</em>'.
	 * @see org.nasdanika.story.Story#getThemes()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Themes();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Story#getProtagonists <em>Protagonists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protagonists</em>'.
	 * @see org.nasdanika.story.Story#getProtagonists()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Protagonists();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Story#getConditionalprotagonists <em>Conditionalprotagonists</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditionalprotagonists</em>'.
	 * @see org.nasdanika.story.Story#getConditionalprotagonists()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Conditionalprotagonists();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Story#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goal</em>'.
	 * @see org.nasdanika.story.Story#getGoal()
	 * @see #getStory()
	 * @generated
	 */
	EAttribute getStory_Goal();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Story#getBenefit <em>Benefit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Benefit</em>'.
	 * @see org.nasdanika.story.Story#getBenefit()
	 * @see #getStory()
	 * @generated
	 */
	EAttribute getStory_Benefit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.story.Story#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.nasdanika.story.Story#getParameters()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Story#isCompleted <em>Completed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completed</em>'.
	 * @see org.nasdanika.story.Story#isCompleted()
	 * @see #getStory()
	 * @generated
	 */
	EAttribute getStory_Completed();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.Story#getRealizes <em>Realizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realizes</em>'.
	 * @see org.nasdanika.story.Story#getRealizes()
	 * @see #getStory()
	 * @generated
	 */
	EReference getStory_Realizes();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.AcceptanceCriterion <em>Acceptance Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acceptance Criterion</em>'.
	 * @see org.nasdanika.story.AcceptanceCriterion
	 * @generated
	 */
	EClass getAcceptanceCriterion();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.AcceptanceCriterion#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.nasdanika.story.AcceptanceCriterion#getId()
	 * @see #getAcceptanceCriterion()
	 * @generated
	 */
	EAttribute getAcceptanceCriterion_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.AcceptanceCriterion#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see org.nasdanika.story.AcceptanceCriterion#getContext()
	 * @see #getAcceptanceCriterion()
	 * @generated
	 */
	EAttribute getAcceptanceCriterion_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.AcceptanceCriterion#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action</em>'.
	 * @see org.nasdanika.story.AcceptanceCriterion#getAction()
	 * @see #getAcceptanceCriterion()
	 * @generated
	 */
	EAttribute getAcceptanceCriterion_Action();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.AcceptanceCriterion#getOutcome <em>Outcome</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outcome</em>'.
	 * @see org.nasdanika.story.AcceptanceCriterion#getOutcome()
	 * @see #getAcceptanceCriterion()
	 * @generated
	 */
	EAttribute getAcceptanceCriterion_Outcome();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.ConditionalProtagonist <em>Conditional Protagonist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Protagonist</em>'.
	 * @see org.nasdanika.story.ConditionalProtagonist
	 * @generated
	 */
	EClass getConditionalProtagonist();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.story.ConditionalProtagonist#getProtagonist <em>Protagonist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protagonist</em>'.
	 * @see org.nasdanika.story.ConditionalProtagonist#getProtagonist()
	 * @see #getConditionalProtagonist()
	 * @generated
	 */
	EReference getConditionalProtagonist_Protagonist();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.ConditionalProtagonist#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.nasdanika.story.ConditionalProtagonist#getCondition()
	 * @see #getConditionalProtagonist()
	 * @generated
	 */
	EAttribute getConditionalProtagonist_Condition();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see org.nasdanika.story.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Goal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.story.Goal#getName()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Goal#getDetails <em>Details</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Details</em>'.
	 * @see org.nasdanika.story.Goal#getDetails()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_Details();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.story.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.nasdanika.story.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Parameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.story.Parameter#getName()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.story.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.story.Parameter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.nasdanika.story.Parameter#getDescription()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Description();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StoryFactory getStoryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.CatalogImpl <em>Catalog</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.CatalogImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getCatalog()
		 * @generated
		 */
		EClass CATALOG = eINSTANCE.getCatalog();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CATALOG__ELEMENTS = eINSTANCE.getCatalog_Elements();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.CatalogElement <em>Catalog Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.CatalogElement
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getCatalogElement()
		 * @generated
		 */
		EClass CATALOG_ELEMENT = eINSTANCE.getCatalogElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG_ELEMENT__ID = eINSTANCE.getCatalogElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG_ELEMENT__NAME = eINSTANCE.getCatalogElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATALOG_ELEMENT__DESCRIPTION = eINSTANCE.getCatalogElement_Description();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.StoryBase <em>Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.StoryBase
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getStoryBase()
		 * @generated
		 */
		EClass STORY_BASE = eINSTANCE.getStoryBase();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.StoryContainer <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.StoryContainer
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getStoryContainer()
		 * @generated
		 */
		EClass STORY_CONTAINER = eINSTANCE.getStoryContainer();

		/**
		 * The meta object literal for the '<em><b>Stories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY_CONTAINER__STORIES = eINSTANCE.getStoryContainer_Stories();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.ProtagonistImpl <em>Protagonist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.ProtagonistImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getProtagonist()
		 * @generated
		 */
		EClass PROTAGONIST = eINSTANCE.getProtagonist();

		/**
		 * The meta object literal for the '<em><b>Link To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROTAGONIST__LINK_TO = eINSTANCE.getProtagonist_LinkTo();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.RoleImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Sub Roles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__SUB_ROLES = eINSTANCE.getRole_SubRoles();

		/**
		 * The meta object literal for the '<em><b>Super Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE__SUPER_ROLES = eINSTANCE.getRole_SuperRoles();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.ActorImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '<em><b>Roles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__ROLES = eINSTANCE.getActor_Roles();

		/**
		 * The meta object literal for the '<em><b>Sub Actors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__SUB_ACTORS = eINSTANCE.getActor_SubActors();

		/**
		 * The meta object literal for the '<em><b>Super Actors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR__SUPER_ACTORS = eINSTANCE.getActor_SuperActors();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.UserImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.SystemImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.PersonaImpl <em>Persona</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.PersonaImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getPersona()
		 * @generated
		 */
		EClass PERSONA = eINSTANCE.getPersona();

		/**
		 * The meta object literal for the '<em><b>Picture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PERSONA__PICTURE = eINSTANCE.getPersona_Picture();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONA__GOALS = eINSTANCE.getPersona_Goals();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.EpicImpl <em>Epic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.EpicImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getEpic()
		 * @generated
		 */
		EClass EPIC = eINSTANCE.getEpic();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.ThemeImpl <em>Theme</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.ThemeImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getTheme()
		 * @generated
		 */
		EClass THEME = eINSTANCE.getTheme();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THEME__CHILDREN = eINSTANCE.getTheme_Children();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.StoryImpl <em>Story</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.StoryImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getStory()
		 * @generated
		 */
		EClass STORY = eINSTANCE.getStory();

		/**
		 * The meta object literal for the '<em><b>Acceptancecriteria</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__ACCEPTANCECRITERIA = eINSTANCE.getStory_Acceptancecriteria();

		/**
		 * The meta object literal for the '<em><b>Depends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__DEPENDS = eINSTANCE.getStory_Depends();

		/**
		 * The meta object literal for the '<em><b>Themes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__THEMES = eINSTANCE.getStory_Themes();

		/**
		 * The meta object literal for the '<em><b>Protagonists</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__PROTAGONISTS = eINSTANCE.getStory_Protagonists();

		/**
		 * The meta object literal for the '<em><b>Conditionalprotagonists</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__CONDITIONALPROTAGONISTS = eINSTANCE.getStory_Conditionalprotagonists();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY__GOAL = eINSTANCE.getStory_Goal();

		/**
		 * The meta object literal for the '<em><b>Benefit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY__BENEFIT = eINSTANCE.getStory_Benefit();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__PARAMETERS = eINSTANCE.getStory_Parameters();

		/**
		 * The meta object literal for the '<em><b>Completed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORY__COMPLETED = eINSTANCE.getStory_Completed();

		/**
		 * The meta object literal for the '<em><b>Realizes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STORY__REALIZES = eINSTANCE.getStory_Realizes();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.AcceptanceCriterionImpl <em>Acceptance Criterion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.AcceptanceCriterionImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getAcceptanceCriterion()
		 * @generated
		 */
		EClass ACCEPTANCE_CRITERION = eINSTANCE.getAcceptanceCriterion();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCEPTANCE_CRITERION__ID = eINSTANCE.getAcceptanceCriterion_Id();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCEPTANCE_CRITERION__CONTEXT = eINSTANCE.getAcceptanceCriterion_Context();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCEPTANCE_CRITERION__ACTION = eINSTANCE.getAcceptanceCriterion_Action();

		/**
		 * The meta object literal for the '<em><b>Outcome</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCEPTANCE_CRITERION__OUTCOME = eINSTANCE.getAcceptanceCriterion_Outcome();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.ConditionalProtagonistImpl <em>Conditional Protagonist</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.ConditionalProtagonistImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getConditionalProtagonist()
		 * @generated
		 */
		EClass CONDITIONAL_PROTAGONIST = eINSTANCE.getConditionalProtagonist();

		/**
		 * The meta object literal for the '<em><b>Protagonist</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_PROTAGONIST__PROTAGONIST = eINSTANCE.getConditionalProtagonist_Protagonist();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITIONAL_PROTAGONIST__CONDITION = eINSTANCE.getConditionalProtagonist_Condition();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.GoalImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL__NAME = eINSTANCE.getGoal_Name();

		/**
		 * The meta object literal for the '<em><b>Details</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL__DETAILS = eINSTANCE.getGoal_Details();

		/**
		 * The meta object literal for the '{@link org.nasdanika.story.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.story.impl.ParameterImpl
		 * @see org.nasdanika.story.impl.StoryPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DESCRIPTION = eINSTANCE.getParameter_Description();

	}

} //StoryPackage
