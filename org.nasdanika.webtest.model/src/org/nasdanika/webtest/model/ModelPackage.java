/**
 */
package org.nasdanika.webtest.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * WebTest model is used to represent WebTest session results.
 * <!-- end-model-doc -->
 * @see org.nasdanika.webtest.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.webtest.model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.webtest.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = org.nasdanika.webtest.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.DescriptorImpl <em>Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.DescriptorImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getDescriptor()
	 * @generated
	 */
	int DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR__QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR__LINKS = 3;

	/**
	 * The number of structural features of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.DescriptionImpl <em>Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.DescriptionImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getDescription()
	 * @generated
	 */
	int DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__URL = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION__CONTENT_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.TestSessionImpl <em>Test Session</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.TestSessionImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestSession()
	 * @generated
	 */
	int TEST_SESSION = 2;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Test Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__TEST_RESULTS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Page Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__PAGE_RESULTS = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Actor Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__ACTOR_RESULTS = DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__TIMESTAMP = DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__NODE = DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION__SCREENSHOTS = DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Test Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Test Session</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SESSION_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.TestResultImpl <em>Test Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.TestResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestResult()
	 * @generated
	 */
	int TEST_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Page Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__PAGE_RESULTS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actor Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT__ACTOR_RESULTS = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Test Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Test Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_RESULT_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.TestClassResultImpl <em>Test Class Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.TestClassResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestClassResult()
	 * @generated
	 */
	int TEST_CLASS_RESULT = 4;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__QUALIFIED_NAME = TEST_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__TITLE = TEST_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__DESCRIPTION = TEST_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__LINKS = TEST_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Page Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__PAGE_RESULTS = TEST_RESULT__PAGE_RESULTS;

	/**
	 * The feature id for the '<em><b>Actor Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__ACTOR_RESULTS = TEST_RESULT__ACTOR_RESULTS;

	/**
	 * The feature id for the '<em><b>Method Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__METHOD_RESULTS = TEST_RESULT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stats</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT__STATS = TEST_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Test Class Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT_FEATURE_COUNT = TEST_RESULT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Test Class Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_RESULT_OPERATION_COUNT = TEST_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.StatsEntryImpl <em>Stats Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.StatsEntryImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getStatsEntry()
	 * @generated
	 */
	int STATS_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATS_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATS_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Stats Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATS_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Stats Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATS_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.TestSuiteResultImpl <em>Test Suite Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.TestSuiteResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestSuiteResult()
	 * @generated
	 */
	int TEST_SUITE_RESULT = 6;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__QUALIFIED_NAME = TEST_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__TITLE = TEST_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__DESCRIPTION = TEST_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__LINKS = TEST_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Page Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__PAGE_RESULTS = TEST_RESULT__PAGE_RESULTS;

	/**
	 * The feature id for the '<em><b>Actor Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__ACTOR_RESULTS = TEST_RESULT__ACTOR_RESULTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT__CHILDREN = TEST_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Suite Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT_FEATURE_COUNT = TEST_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Test Suite Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SUITE_RESULT_OPERATION_COUNT = TEST_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.ParameterizedTestResultImpl <em>Parameterized Test Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.ParameterizedTestResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getParameterizedTestResult()
	 * @generated
	 */
	int PARAMETERIZED_TEST_RESULT = 7;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__QUALIFIED_NAME = TEST_SUITE_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__TITLE = TEST_SUITE_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__DESCRIPTION = TEST_SUITE_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__LINKS = TEST_SUITE_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Page Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__PAGE_RESULTS = TEST_SUITE_RESULT__PAGE_RESULTS;

	/**
	 * The feature id for the '<em><b>Actor Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__ACTOR_RESULTS = TEST_SUITE_RESULT__ACTOR_RESULTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__CHILDREN = TEST_SUITE_RESULT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parameter Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS = TEST_SUITE_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameterized Test Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT_FEATURE_COUNT = TEST_SUITE_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameterized Test Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETERIZED_TEST_RESULT_OPERATION_COUNT = TEST_SUITE_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.ScreenshotImpl <em>Screenshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.ScreenshotImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getScreenshot()
	 * @generated
	 */
	int SCREENSHOT = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__HEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__CONTENT_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT__ENTRIES = 4;

	/**
	 * The number of structural features of the '<em>Screenshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Screenshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.OperationArgumentImpl <em>Operation Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.OperationArgumentImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getOperationArgument()
	 * @generated
	 */
	int OPERATION_ARGUMENT = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Masked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT__MASKED = 2;

	/**
	 * The number of structural features of the '<em>Operation Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Operation Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.ScreenshotEntryImpl <em>Screenshot Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.ScreenshotEntryImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getScreenshotEntry()
	 * @generated
	 */
	int SCREENSHOT_ENTRY = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_ENTRY__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_ENTRY__COMMENT = 1;

	/**
	 * The feature id for the '<em><b>Screenshot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_ENTRY__SCREENSHOT = 2;

	/**
	 * The number of structural features of the '<em>Screenshot Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Screenshot Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCREENSHOT_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.OperationResultImpl <em>Operation Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.OperationResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getOperationResult()
	 * @generated
	 */
	int OPERATION_RESULT = 11;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__SCREENSHOTS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__CHILDREN = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__OPERATION_NAME = DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__FAILURE = DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__ERROR = DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__START = DESCRIPTOR_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__FINISH = DESCRIPTOR_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__STATUS = DESCRIPTOR_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT__ARGUMENTS = DESCRIPTOR_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Operation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Operation Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_RESULT_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.ThrowableImpl <em>Throwable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.ThrowableImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 12;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Stack Trace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE__STACK_TRACE = 2;

	/**
	 * The number of structural features of the '<em>Throwable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Throwable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl <em>Stack Trace Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.StackTraceEntryImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getStackTraceEntry()
	 * @generated
	 */
	int STACK_TRACE_ENTRY = 13;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__CLASS_NAME = 0;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__FILE_NAME = 1;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__METHOD_NAME = 2;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__LINE_NUMBER = 3;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY__NATIVE = 4;

	/**
	 * The number of structural features of the '<em>Stack Trace Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Stack Trace Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_TRACE_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.MethodResultImpl <em>Method Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.MethodResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getMethodResult()
	 * @generated
	 */
	int METHOD_RESULT = 15;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__QUALIFIED_NAME = OPERATION_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__TITLE = OPERATION_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__DESCRIPTION = OPERATION_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__LINKS = OPERATION_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__SCREENSHOTS = OPERATION_RESULT__SCREENSHOTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__CHILDREN = OPERATION_RESULT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__OPERATION_NAME = OPERATION_RESULT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__FAILURE = OPERATION_RESULT__FAILURE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__ERROR = OPERATION_RESULT__ERROR;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__START = OPERATION_RESULT__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__FINISH = OPERATION_RESULT__FINISH;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__STATUS = OPERATION_RESULT__STATUS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT__ARGUMENTS = OPERATION_RESULT__ARGUMENTS;

	/**
	 * The number of structural features of the '<em>Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT_FEATURE_COUNT = OPERATION_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_RESULT_OPERATION_COUNT = OPERATION_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.PageMethodResultImpl <em>Page Method Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.PageMethodResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getPageMethodResult()
	 * @generated
	 */
	int PAGE_METHOD_RESULT = 17;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__QUALIFIED_NAME = METHOD_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__TITLE = METHOD_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__DESCRIPTION = METHOD_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__LINKS = METHOD_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__SCREENSHOTS = METHOD_RESULT__SCREENSHOTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__CHILDREN = METHOD_RESULT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__OPERATION_NAME = METHOD_RESULT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__FAILURE = METHOD_RESULT__FAILURE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__ERROR = METHOD_RESULT__ERROR;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__START = METHOD_RESULT__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__FINISH = METHOD_RESULT__FINISH;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__STATUS = METHOD_RESULT__STATUS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__ARGUMENTS = METHOD_RESULT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Page Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT__PAGE_RESULT = METHOD_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Page Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT_FEATURE_COUNT = METHOD_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Page Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_METHOD_RESULT_OPERATION_COUNT = METHOD_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.InitializationResultImpl <em>Initialization Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.InitializationResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getInitializationResult()
	 * @generated
	 */
	int INITIALIZATION_RESULT = 14;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__QUALIFIED_NAME = PAGE_METHOD_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__TITLE = PAGE_METHOD_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__DESCRIPTION = PAGE_METHOD_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__LINKS = PAGE_METHOD_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__SCREENSHOTS = PAGE_METHOD_RESULT__SCREENSHOTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__CHILDREN = PAGE_METHOD_RESULT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__OPERATION_NAME = PAGE_METHOD_RESULT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__FAILURE = PAGE_METHOD_RESULT__FAILURE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__ERROR = PAGE_METHOD_RESULT__ERROR;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__START = PAGE_METHOD_RESULT__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__FINISH = PAGE_METHOD_RESULT__FINISH;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__STATUS = PAGE_METHOD_RESULT__STATUS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__ARGUMENTS = PAGE_METHOD_RESULT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Page Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT__PAGE_RESULT = PAGE_METHOD_RESULT__PAGE_RESULT;

	/**
	 * The number of structural features of the '<em>Initialization Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT_FEATURE_COUNT = PAGE_METHOD_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Initialization Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZATION_RESULT_OPERATION_COUNT = PAGE_METHOD_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.ActorMethodResultImpl <em>Actor Method Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.ActorMethodResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getActorMethodResult()
	 * @generated
	 */
	int ACTOR_METHOD_RESULT = 16;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__QUALIFIED_NAME = METHOD_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__TITLE = METHOD_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__DESCRIPTION = METHOD_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__LINKS = METHOD_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__SCREENSHOTS = METHOD_RESULT__SCREENSHOTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__CHILDREN = METHOD_RESULT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__OPERATION_NAME = METHOD_RESULT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__FAILURE = METHOD_RESULT__FAILURE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__ERROR = METHOD_RESULT__ERROR;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__START = METHOD_RESULT__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__FINISH = METHOD_RESULT__FINISH;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__STATUS = METHOD_RESULT__STATUS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__ARGUMENTS = METHOD_RESULT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Actor Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT__ACTOR_RESULT = METHOD_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actor Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT_FEATURE_COUNT = METHOD_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Actor Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_METHOD_RESULT_OPERATION_COUNT = METHOD_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.TestMethodResultImpl <em>Test Method Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.TestMethodResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestMethodResult()
	 * @generated
	 */
	int TEST_METHOD_RESULT = 18;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__QUALIFIED_NAME = METHOD_RESULT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__TITLE = METHOD_RESULT__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__DESCRIPTION = METHOD_RESULT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__LINKS = METHOD_RESULT__LINKS;

	/**
	 * The feature id for the '<em><b>Screenshots</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__SCREENSHOTS = METHOD_RESULT__SCREENSHOTS;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__CHILDREN = METHOD_RESULT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__OPERATION_NAME = METHOD_RESULT__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Failure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__FAILURE = METHOD_RESULT__FAILURE;

	/**
	 * The feature id for the '<em><b>Error</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__ERROR = METHOD_RESULT__ERROR;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__START = METHOD_RESULT__START;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__FINISH = METHOD_RESULT__FINISH;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__STATUS = METHOD_RESULT__STATUS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__ARGUMENTS = METHOD_RESULT__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT__PARAMETERS = METHOD_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Test Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT_FEATURE_COUNT = METHOD_RESULT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Test Method Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_METHOD_RESULT_OPERATION_COUNT = METHOD_RESULT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.CoverageImpl <em>Coverage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.CoverageImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getCoverage()
	 * @generated
	 */
	int COVERAGE = 19;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE__INVOCATIONS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Coverage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Coverage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COVERAGE_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.ActorResultImpl <em>Actor Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.ActorResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getActorResult()
	 * @generated
	 */
	int ACTOR_RESULT = 20;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__RESULTS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Coverage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__COVERAGE = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT__PROXY = DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Actor Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_RESULT_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.PageResultImpl <em>Page Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.PageResultImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getPageResult()
	 * @generated
	 */
	int PAGE_RESULT = 21;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__RESULTS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Coverage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__COVERAGE = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Web Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__WEB_ELEMENTS = DESCRIPTOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Proxy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT__PROXY = DESCRIPTOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Page Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Page Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_RESULT_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.WebElementImpl <em>Web Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.WebElementImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getWebElement()
	 * @generated
	 */
	int WEB_ELEMENT = 22;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT__QUALIFIED_NAME = DESCRIPTOR__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT__TITLE = DESCRIPTOR__TITLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT__DESCRIPTION = DESCRIPTOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT__LINKS = DESCRIPTOR__LINKS;

	/**
	 * The feature id for the '<em><b>Locators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT__LOCATORS = DESCRIPTOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Web Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT_FEATURE_COUNT = DESCRIPTOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Web Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEB_ELEMENT_OPERATION_COUNT = DESCRIPTOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.LocatorImpl <em>Locator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.LocatorImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getLocator()
	 * @generated
	 */
	int LOCATOR = 23;

	/**
	 * The feature id for the '<em><b>How</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATOR__HOW = 0;

	/**
	 * The feature id for the '<em><b>Using</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATOR__USING = 1;

	/**
	 * The number of structural features of the '<em>Locator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Locator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.impl.LinkImpl <em>Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.impl.LinkImpl
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getLink()
	 * @generated
	 */
	int LINK = 24;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.OperationStatus <em>Operation Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.OperationStatus
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getOperationStatus()
	 * @generated
	 */
	int OPERATION_STATUS = 25;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.model.ScreenshotType <em>Screenshot Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.model.ScreenshotType
	 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getScreenshotType()
	 * @generated
	 */
	int SCREENSHOT_TYPE = 26;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Descriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Descriptor</em>'.
	 * @see org.nasdanika.webtest.model.Descriptor
	 * @generated
	 */
	EClass getDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Descriptor#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.nasdanika.webtest.model.Descriptor#getQualifiedName()
	 * @see #getDescriptor()
	 * @generated
	 */
	EAttribute getDescriptor_QualifiedName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Descriptor#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see org.nasdanika.webtest.model.Descriptor#getTitle()
	 * @see #getDescriptor()
	 * @generated
	 */
	EAttribute getDescriptor_Title();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.webtest.model.Descriptor#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Description</em>'.
	 * @see org.nasdanika.webtest.model.Descriptor#getDescription()
	 * @see #getDescriptor()
	 * @generated
	 */
	EReference getDescriptor_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.Descriptor#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see org.nasdanika.webtest.model.Descriptor#getLinks()
	 * @see #getDescriptor()
	 * @generated
	 */
	EReference getDescriptor_Links();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Description <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description</em>'.
	 * @see org.nasdanika.webtest.model.Description
	 * @generated
	 */
	EClass getDescription();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Description#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.nasdanika.webtest.model.Description#getUrl()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Url();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.webtest.model.Description#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Value</em>'.
	 * @see org.nasdanika.webtest.model.Description#getValue()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Description#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.nasdanika.webtest.model.Description#getContentType()
	 * @see #getDescription()
	 * @generated
	 */
	EAttribute getDescription_ContentType();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.TestSession <em>Test Session</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Session</em>'.
	 * @see org.nasdanika.webtest.model.TestSession
	 * @generated
	 */
	EClass getTestSession();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestSession#getTestResults <em>Test Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Results</em>'.
	 * @see org.nasdanika.webtest.model.TestSession#getTestResults()
	 * @see #getTestSession()
	 * @generated
	 */
	EReference getTestSession_TestResults();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestSession#getPageResults <em>Page Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page Results</em>'.
	 * @see org.nasdanika.webtest.model.TestSession#getPageResults()
	 * @see #getTestSession()
	 * @generated
	 */
	EReference getTestSession_PageResults();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestSession#getActorResults <em>Actor Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor Results</em>'.
	 * @see org.nasdanika.webtest.model.TestSession#getActorResults()
	 * @see #getTestSession()
	 * @generated
	 */
	EReference getTestSession_ActorResults();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.TestSession#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.nasdanika.webtest.model.TestSession#getTimestamp()
	 * @see #getTestSession()
	 * @generated
	 */
	EAttribute getTestSession_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.TestSession#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node</em>'.
	 * @see org.nasdanika.webtest.model.TestSession#getNode()
	 * @see #getTestSession()
	 * @generated
	 */
	EAttribute getTestSession_Node();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestSession#getScreenshots <em>Screenshots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Screenshots</em>'.
	 * @see org.nasdanika.webtest.model.TestSession#getScreenshots()
	 * @see #getTestSession()
	 * @generated
	 */
	EReference getTestSession_Screenshots();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.TestResult <em>Test Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Result</em>'.
	 * @see org.nasdanika.webtest.model.TestResult
	 * @generated
	 */
	EClass getTestResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestResult#getPageResults <em>Page Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page Results</em>'.
	 * @see org.nasdanika.webtest.model.TestResult#getPageResults()
	 * @see #getTestResult()
	 * @generated
	 */
	EReference getTestResult_PageResults();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestResult#getActorResults <em>Actor Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actor Results</em>'.
	 * @see org.nasdanika.webtest.model.TestResult#getActorResults()
	 * @see #getTestResult()
	 * @generated
	 */
	EReference getTestResult_ActorResults();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.TestClassResult <em>Test Class Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Class Result</em>'.
	 * @see org.nasdanika.webtest.model.TestClassResult
	 * @generated
	 */
	EClass getTestClassResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestClassResult#getMethodResults <em>Method Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Method Results</em>'.
	 * @see org.nasdanika.webtest.model.TestClassResult#getMethodResults()
	 * @see #getTestClassResult()
	 * @generated
	 */
	EReference getTestClassResult_MethodResults();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.webtest.model.TestClassResult#getStats <em>Stats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Stats</em>'.
	 * @see org.nasdanika.webtest.model.TestClassResult#getStats()
	 * @see #getTestClassResult()
	 * @generated
	 */
	EReference getTestClassResult_Stats();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Stats Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stats Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
	 * @generated
	 */
	EClass getStatsEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStatsEntry()
	 * @generated
	 */
	EAttribute getStatsEntry_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getStatsEntry()
	 * @generated
	 */
	EAttribute getStatsEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.TestSuiteResult <em>Test Suite Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Suite Result</em>'.
	 * @see org.nasdanika.webtest.model.TestSuiteResult
	 * @generated
	 */
	EClass getTestSuiteResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.TestSuiteResult#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.webtest.model.TestSuiteResult#getChildren()
	 * @see #getTestSuiteResult()
	 * @generated
	 */
	EReference getTestSuiteResult_Children();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.ParameterizedTestResult <em>Parameterized Test Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameterized Test Result</em>'.
	 * @see org.nasdanika.webtest.model.ParameterizedTestResult
	 * @generated
	 */
	EClass getParameterizedTestResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.ParameterizedTestResult#getParameterDescriptors <em>Parameter Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Descriptors</em>'.
	 * @see org.nasdanika.webtest.model.ParameterizedTestResult#getParameterDescriptors()
	 * @see #getParameterizedTestResult()
	 * @generated
	 */
	EReference getParameterizedTestResult_ParameterDescriptors();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Screenshot <em>Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Screenshot</em>'.
	 * @see org.nasdanika.webtest.model.Screenshot
	 * @generated
	 */
	EClass getScreenshot();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Screenshot#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.nasdanika.webtest.model.Screenshot#getLocation()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Screenshot#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.nasdanika.webtest.model.Screenshot#getHeight()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Screenshot#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.nasdanika.webtest.model.Screenshot#getWidth()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Screenshot#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.nasdanika.webtest.model.Screenshot#getContentType()
	 * @see #getScreenshot()
	 * @generated
	 */
	EAttribute getScreenshot_ContentType();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.webtest.model.Screenshot#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entries</em>'.
	 * @see org.nasdanika.webtest.model.Screenshot#getEntries()
	 * @see #getScreenshot()
	 * @generated
	 */
	EReference getScreenshot_Entries();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.OperationArgument <em>Operation Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Argument</em>'.
	 * @see org.nasdanika.webtest.model.OperationArgument
	 * @generated
	 */
	EClass getOperationArgument();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.webtest.model.OperationArgument#getValue()
	 * @see #getOperationArgument()
	 * @generated
	 */
	EAttribute getOperationArgument_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationArgument#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.webtest.model.OperationArgument#getType()
	 * @see #getOperationArgument()
	 * @generated
	 */
	EAttribute getOperationArgument_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationArgument#isMasked <em>Masked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Masked</em>'.
	 * @see org.nasdanika.webtest.model.OperationArgument#isMasked()
	 * @see #getOperationArgument()
	 * @generated
	 */
	EAttribute getOperationArgument_Masked();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.ScreenshotEntry <em>Screenshot Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Screenshot Entry</em>'.
	 * @see org.nasdanika.webtest.model.ScreenshotEntry
	 * @generated
	 */
	EClass getScreenshotEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.ScreenshotEntry#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.webtest.model.ScreenshotEntry#getType()
	 * @see #getScreenshotEntry()
	 * @generated
	 */
	EAttribute getScreenshotEntry_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.ScreenshotEntry#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.nasdanika.webtest.model.ScreenshotEntry#getComment()
	 * @see #getScreenshotEntry()
	 * @generated
	 */
	EAttribute getScreenshotEntry_Comment();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.webtest.model.ScreenshotEntry#getScreenshot <em>Screenshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Screenshot</em>'.
	 * @see org.nasdanika.webtest.model.ScreenshotEntry#getScreenshot()
	 * @see #getScreenshotEntry()
	 * @generated
	 */
	EReference getScreenshotEntry_Screenshot();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.OperationResult <em>Operation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Result</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult
	 * @generated
	 */
	EClass getOperationResult();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.OperationResult#getScreenshots <em>Screenshots</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Screenshots</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getScreenshots()
	 * @see #getOperationResult()
	 * @generated
	 */
	EReference getOperationResult_Screenshots();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.OperationResult#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getChildren()
	 * @see #getOperationResult()
	 * @generated
	 */
	EReference getOperationResult_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationResult#getOperationName <em>Operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Name</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getOperationName()
	 * @see #getOperationResult()
	 * @generated
	 */
	EAttribute getOperationResult_OperationName();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.webtest.model.OperationResult#getFailure <em>Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Failure</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getFailure()
	 * @see #getOperationResult()
	 * @generated
	 */
	EReference getOperationResult_Failure();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.webtest.model.OperationResult#getError <em>Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getError()
	 * @see #getOperationResult()
	 * @generated
	 */
	EReference getOperationResult_Error();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationResult#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getStart()
	 * @see #getOperationResult()
	 * @generated
	 */
	EAttribute getOperationResult_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationResult#getFinish <em>Finish</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Finish</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getFinish()
	 * @see #getOperationResult()
	 * @generated
	 */
	EAttribute getOperationResult_Finish();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.OperationResult#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getStatus()
	 * @see #getOperationResult()
	 * @generated
	 */
	EAttribute getOperationResult_Status();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.OperationResult#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.nasdanika.webtest.model.OperationResult#getArguments()
	 * @see #getOperationResult()
	 * @generated
	 */
	EReference getOperationResult_Arguments();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throwable</em>'.
	 * @see org.nasdanika.webtest.model.Throwable
	 * @generated
	 */
	EClass getThrowable();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Throwable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.webtest.model.Throwable#getType()
	 * @see #getThrowable()
	 * @generated
	 */
	EAttribute getThrowable_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Throwable#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.nasdanika.webtest.model.Throwable#getMessage()
	 * @see #getThrowable()
	 * @generated
	 */
	EAttribute getThrowable_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.Throwable#getStackTrace <em>Stack Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stack Trace</em>'.
	 * @see org.nasdanika.webtest.model.Throwable#getStackTrace()
	 * @see #getThrowable()
	 * @generated
	 */
	EReference getThrowable_StackTrace();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.StackTraceEntry <em>Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Trace Entry</em>'.
	 * @see org.nasdanika.webtest.model.StackTraceEntry
	 * @generated
	 */
	EClass getStackTraceEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.StackTraceEntry#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.nasdanika.webtest.model.StackTraceEntry#getClassName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.StackTraceEntry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.nasdanika.webtest.model.StackTraceEntry#getFileName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.StackTraceEntry#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.nasdanika.webtest.model.StackTraceEntry#getMethodName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.StackTraceEntry#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see org.nasdanika.webtest.model.StackTraceEntry#getLineNumber()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.StackTraceEntry#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see org.nasdanika.webtest.model.StackTraceEntry#isNative()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_Native();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.InitializationResult <em>Initialization Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initialization Result</em>'.
	 * @see org.nasdanika.webtest.model.InitializationResult
	 * @generated
	 */
	EClass getInitializationResult();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.MethodResult <em>Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Result</em>'.
	 * @see org.nasdanika.webtest.model.MethodResult
	 * @generated
	 */
	EClass getMethodResult();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.ActorMethodResult <em>Actor Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Method Result</em>'.
	 * @see org.nasdanika.webtest.model.ActorMethodResult
	 * @generated
	 */
	EClass getActorMethodResult();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.webtest.model.ActorMethodResult#getActorResult <em>Actor Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor Result</em>'.
	 * @see org.nasdanika.webtest.model.ActorMethodResult#getActorResult()
	 * @see #getActorMethodResult()
	 * @generated
	 */
	EReference getActorMethodResult_ActorResult();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.PageMethodResult <em>Page Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Method Result</em>'.
	 * @see org.nasdanika.webtest.model.PageMethodResult
	 * @generated
	 */
	EClass getPageMethodResult();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.webtest.model.PageMethodResult#getPageResult <em>Page Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Page Result</em>'.
	 * @see org.nasdanika.webtest.model.PageMethodResult#getPageResult()
	 * @see #getPageMethodResult()
	 * @generated
	 */
	EReference getPageMethodResult_PageResult();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.TestMethodResult <em>Test Method Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Method Result</em>'.
	 * @see org.nasdanika.webtest.model.TestMethodResult
	 * @generated
	 */
	EClass getTestMethodResult();

	/**
	 * Returns the meta object for the attribute list '{@link org.nasdanika.webtest.model.TestMethodResult#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameters</em>'.
	 * @see org.nasdanika.webtest.model.TestMethodResult#getParameters()
	 * @see #getTestMethodResult()
	 * @generated
	 */
	EAttribute getTestMethodResult_Parameters();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Coverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coverage</em>'.
	 * @see org.nasdanika.webtest.model.Coverage
	 * @generated
	 */
	EClass getCoverage();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Coverage#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invocations</em>'.
	 * @see org.nasdanika.webtest.model.Coverage#getInvocations()
	 * @see #getCoverage()
	 * @generated
	 */
	EAttribute getCoverage_Invocations();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.ActorResult <em>Actor Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Result</em>'.
	 * @see org.nasdanika.webtest.model.ActorResult
	 * @generated
	 */
	EClass getActorResult();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.webtest.model.ActorResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see org.nasdanika.webtest.model.ActorResult#getResults()
	 * @see #getActorResult()
	 * @generated
	 */
	EReference getActorResult_Results();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.ActorResult#getCoverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Coverage</em>'.
	 * @see org.nasdanika.webtest.model.ActorResult#getCoverage()
	 * @see #getActorResult()
	 * @generated
	 */
	EReference getActorResult_Coverage();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.ActorResult#isProxy <em>Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy</em>'.
	 * @see org.nasdanika.webtest.model.ActorResult#isProxy()
	 * @see #getActorResult()
	 * @generated
	 */
	EAttribute getActorResult_Proxy();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.PageResult <em>Page Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page Result</em>'.
	 * @see org.nasdanika.webtest.model.PageResult
	 * @generated
	 */
	EClass getPageResult();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.webtest.model.PageResult#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see org.nasdanika.webtest.model.PageResult#getResults()
	 * @see #getPageResult()
	 * @generated
	 */
	EReference getPageResult_Results();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.PageResult#getCoverage <em>Coverage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Coverage</em>'.
	 * @see org.nasdanika.webtest.model.PageResult#getCoverage()
	 * @see #getPageResult()
	 * @generated
	 */
	EReference getPageResult_Coverage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.PageResult#getWebElements <em>Web Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Web Elements</em>'.
	 * @see org.nasdanika.webtest.model.PageResult#getWebElements()
	 * @see #getPageResult()
	 * @generated
	 */
	EReference getPageResult_WebElements();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.PageResult#isProxy <em>Proxy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Proxy</em>'.
	 * @see org.nasdanika.webtest.model.PageResult#isProxy()
	 * @see #getPageResult()
	 * @generated
	 */
	EAttribute getPageResult_Proxy();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.WebElement <em>Web Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Web Element</em>'.
	 * @see org.nasdanika.webtest.model.WebElement
	 * @generated
	 */
	EClass getWebElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.model.WebElement#getLocators <em>Locators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locators</em>'.
	 * @see org.nasdanika.webtest.model.WebElement#getLocators()
	 * @see #getWebElement()
	 * @generated
	 */
	EReference getWebElement_Locators();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Locator <em>Locator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locator</em>'.
	 * @see org.nasdanika.webtest.model.Locator
	 * @generated
	 */
	EClass getLocator();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Locator#getHow <em>How</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>How</em>'.
	 * @see org.nasdanika.webtest.model.Locator#getHow()
	 * @see #getLocator()
	 * @generated
	 */
	EAttribute getLocator_How();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Locator#getUsing <em>Using</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Using</em>'.
	 * @see org.nasdanika.webtest.model.Locator#getUsing()
	 * @see #getLocator()
	 * @generated
	 */
	EAttribute getLocator_Using();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.model.Link <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link</em>'.
	 * @see org.nasdanika.webtest.model.Link
	 * @generated
	 */
	EClass getLink();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Link#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.nasdanika.webtest.model.Link#getValue()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.model.Link#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.webtest.model.Link#getType()
	 * @see #getLink()
	 * @generated
	 */
	EAttribute getLink_Type();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.webtest.model.OperationStatus <em>Operation Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operation Status</em>'.
	 * @see org.nasdanika.webtest.model.OperationStatus
	 * @generated
	 */
	EEnum getOperationStatus();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.webtest.model.ScreenshotType <em>Screenshot Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Screenshot Type</em>'.
	 * @see org.nasdanika.webtest.model.ScreenshotType
	 * @generated
	 */
	EEnum getScreenshotType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.DescriptorImpl <em>Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.DescriptorImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getDescriptor()
		 * @generated
		 */
		EClass DESCRIPTOR = eINSTANCE.getDescriptor();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTOR__QUALIFIED_NAME = eINSTANCE.getDescriptor_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTOR__TITLE = eINSTANCE.getDescriptor_Title();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR__DESCRIPTION = eINSTANCE.getDescriptor_Description();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTOR__LINKS = eINSTANCE.getDescriptor_Links();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.DescriptionImpl <em>Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.DescriptionImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getDescription()
		 * @generated
		 */
		EClass DESCRIPTION = eINSTANCE.getDescription();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__URL = eINSTANCE.getDescription_Url();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__VALUE = eINSTANCE.getDescription_Value();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION__CONTENT_TYPE = eINSTANCE.getDescription_ContentType();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.TestSessionImpl <em>Test Session</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.TestSessionImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestSession()
		 * @generated
		 */
		EClass TEST_SESSION = eINSTANCE.getTestSession();

		/**
		 * The meta object literal for the '<em><b>Test Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SESSION__TEST_RESULTS = eINSTANCE.getTestSession_TestResults();

		/**
		 * The meta object literal for the '<em><b>Page Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SESSION__PAGE_RESULTS = eINSTANCE.getTestSession_PageResults();

		/**
		 * The meta object literal for the '<em><b>Actor Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SESSION__ACTOR_RESULTS = eINSTANCE.getTestSession_ActorResults();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SESSION__TIMESTAMP = eINSTANCE.getTestSession_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SESSION__NODE = eINSTANCE.getTestSession_Node();

		/**
		 * The meta object literal for the '<em><b>Screenshots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SESSION__SCREENSHOTS = eINSTANCE.getTestSession_Screenshots();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.TestResultImpl <em>Test Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.TestResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestResult()
		 * @generated
		 */
		EClass TEST_RESULT = eINSTANCE.getTestResult();

		/**
		 * The meta object literal for the '<em><b>Page Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_RESULT__PAGE_RESULTS = eINSTANCE.getTestResult_PageResults();

		/**
		 * The meta object literal for the '<em><b>Actor Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_RESULT__ACTOR_RESULTS = eINSTANCE.getTestResult_ActorResults();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.TestClassResultImpl <em>Test Class Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.TestClassResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestClassResult()
		 * @generated
		 */
		EClass TEST_CLASS_RESULT = eINSTANCE.getTestClassResult();

		/**
		 * The meta object literal for the '<em><b>Method Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CLASS_RESULT__METHOD_RESULTS = eINSTANCE.getTestClassResult_MethodResults();

		/**
		 * The meta object literal for the '<em><b>Stats</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CLASS_RESULT__STATS = eINSTANCE.getTestClassResult_Stats();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.StatsEntryImpl <em>Stats Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.StatsEntryImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getStatsEntry()
		 * @generated
		 */
		EClass STATS_ENTRY = eINSTANCE.getStatsEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATS_ENTRY__KEY = eINSTANCE.getStatsEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATS_ENTRY__VALUE = eINSTANCE.getStatsEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.TestSuiteResultImpl <em>Test Suite Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.TestSuiteResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestSuiteResult()
		 * @generated
		 */
		EClass TEST_SUITE_RESULT = eINSTANCE.getTestSuiteResult();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SUITE_RESULT__CHILDREN = eINSTANCE.getTestSuiteResult_Children();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.ParameterizedTestResultImpl <em>Parameterized Test Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.ParameterizedTestResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getParameterizedTestResult()
		 * @generated
		 */
		EClass PARAMETERIZED_TEST_RESULT = eINSTANCE.getParameterizedTestResult();

		/**
		 * The meta object literal for the '<em><b>Parameter Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS = eINSTANCE.getParameterizedTestResult_ParameterDescriptors();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.ScreenshotImpl <em>Screenshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.ScreenshotImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getScreenshot()
		 * @generated
		 */
		EClass SCREENSHOT = eINSTANCE.getScreenshot();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__LOCATION = eINSTANCE.getScreenshot_Location();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__HEIGHT = eINSTANCE.getScreenshot_Height();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__WIDTH = eINSTANCE.getScreenshot_Width();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT__CONTENT_TYPE = eINSTANCE.getScreenshot_ContentType();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREENSHOT__ENTRIES = eINSTANCE.getScreenshot_Entries();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.OperationArgumentImpl <em>Operation Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.OperationArgumentImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getOperationArgument()
		 * @generated
		 */
		EClass OPERATION_ARGUMENT = eINSTANCE.getOperationArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_ARGUMENT__VALUE = eINSTANCE.getOperationArgument_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_ARGUMENT__TYPE = eINSTANCE.getOperationArgument_Type();

		/**
		 * The meta object literal for the '<em><b>Masked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_ARGUMENT__MASKED = eINSTANCE.getOperationArgument_Masked();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.ScreenshotEntryImpl <em>Screenshot Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.ScreenshotEntryImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getScreenshotEntry()
		 * @generated
		 */
		EClass SCREENSHOT_ENTRY = eINSTANCE.getScreenshotEntry();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT_ENTRY__TYPE = eINSTANCE.getScreenshotEntry_Type();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCREENSHOT_ENTRY__COMMENT = eINSTANCE.getScreenshotEntry_Comment();

		/**
		 * The meta object literal for the '<em><b>Screenshot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCREENSHOT_ENTRY__SCREENSHOT = eINSTANCE.getScreenshotEntry_Screenshot();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.OperationResultImpl <em>Operation Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.OperationResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getOperationResult()
		 * @generated
		 */
		EClass OPERATION_RESULT = eINSTANCE.getOperationResult();

		/**
		 * The meta object literal for the '<em><b>Screenshots</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_RESULT__SCREENSHOTS = eINSTANCE.getOperationResult_Screenshots();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_RESULT__CHILDREN = eINSTANCE.getOperationResult_Children();

		/**
		 * The meta object literal for the '<em><b>Operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_RESULT__OPERATION_NAME = eINSTANCE.getOperationResult_OperationName();

		/**
		 * The meta object literal for the '<em><b>Failure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_RESULT__FAILURE = eINSTANCE.getOperationResult_Failure();

		/**
		 * The meta object literal for the '<em><b>Error</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_RESULT__ERROR = eINSTANCE.getOperationResult_Error();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_RESULT__START = eINSTANCE.getOperationResult_Start();

		/**
		 * The meta object literal for the '<em><b>Finish</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_RESULT__FINISH = eINSTANCE.getOperationResult_Finish();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_RESULT__STATUS = eINSTANCE.getOperationResult_Status();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_RESULT__ARGUMENTS = eINSTANCE.getOperationResult_Arguments();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.ThrowableImpl <em>Throwable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.ThrowableImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getThrowable()
		 * @generated
		 */
		EClass THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROWABLE__TYPE = eINSTANCE.getThrowable_Type();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute THROWABLE__MESSAGE = eINSTANCE.getThrowable_Message();

		/**
		 * The meta object literal for the '<em><b>Stack Trace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROWABLE__STACK_TRACE = eINSTANCE.getThrowable_StackTrace();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl <em>Stack Trace Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.StackTraceEntryImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getStackTraceEntry()
		 * @generated
		 */
		EClass STACK_TRACE_ENTRY = eINSTANCE.getStackTraceEntry();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__CLASS_NAME = eINSTANCE.getStackTraceEntry_ClassName();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__FILE_NAME = eINSTANCE.getStackTraceEntry_FileName();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__METHOD_NAME = eINSTANCE.getStackTraceEntry_MethodName();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__LINE_NUMBER = eINSTANCE.getStackTraceEntry_LineNumber();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STACK_TRACE_ENTRY__NATIVE = eINSTANCE.getStackTraceEntry_Native();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.InitializationResultImpl <em>Initialization Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.InitializationResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getInitializationResult()
		 * @generated
		 */
		EClass INITIALIZATION_RESULT = eINSTANCE.getInitializationResult();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.MethodResultImpl <em>Method Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.MethodResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getMethodResult()
		 * @generated
		 */
		EClass METHOD_RESULT = eINSTANCE.getMethodResult();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.ActorMethodResultImpl <em>Actor Method Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.ActorMethodResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getActorMethodResult()
		 * @generated
		 */
		EClass ACTOR_METHOD_RESULT = eINSTANCE.getActorMethodResult();

		/**
		 * The meta object literal for the '<em><b>Actor Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_METHOD_RESULT__ACTOR_RESULT = eINSTANCE.getActorMethodResult_ActorResult();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.PageMethodResultImpl <em>Page Method Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.PageMethodResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getPageMethodResult()
		 * @generated
		 */
		EClass PAGE_METHOD_RESULT = eINSTANCE.getPageMethodResult();

		/**
		 * The meta object literal for the '<em><b>Page Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_METHOD_RESULT__PAGE_RESULT = eINSTANCE.getPageMethodResult_PageResult();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.TestMethodResultImpl <em>Test Method Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.TestMethodResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getTestMethodResult()
		 * @generated
		 */
		EClass TEST_METHOD_RESULT = eINSTANCE.getTestMethodResult();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_METHOD_RESULT__PARAMETERS = eINSTANCE.getTestMethodResult_Parameters();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.CoverageImpl <em>Coverage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.CoverageImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getCoverage()
		 * @generated
		 */
		EClass COVERAGE = eINSTANCE.getCoverage();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COVERAGE__INVOCATIONS = eINSTANCE.getCoverage_Invocations();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.ActorResultImpl <em>Actor Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.ActorResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getActorResult()
		 * @generated
		 */
		EClass ACTOR_RESULT = eINSTANCE.getActorResult();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_RESULT__RESULTS = eINSTANCE.getActorResult_Results();

		/**
		 * The meta object literal for the '<em><b>Coverage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_RESULT__COVERAGE = eINSTANCE.getActorResult_Coverage();

		/**
		 * The meta object literal for the '<em><b>Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTOR_RESULT__PROXY = eINSTANCE.getActorResult_Proxy();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.PageResultImpl <em>Page Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.PageResultImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getPageResult()
		 * @generated
		 */
		EClass PAGE_RESULT = eINSTANCE.getPageResult();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RESULT__RESULTS = eINSTANCE.getPageResult_Results();

		/**
		 * The meta object literal for the '<em><b>Coverage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RESULT__COVERAGE = eINSTANCE.getPageResult_Coverage();

		/**
		 * The meta object literal for the '<em><b>Web Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE_RESULT__WEB_ELEMENTS = eINSTANCE.getPageResult_WebElements();

		/**
		 * The meta object literal for the '<em><b>Proxy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PAGE_RESULT__PROXY = eINSTANCE.getPageResult_Proxy();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.WebElementImpl <em>Web Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.WebElementImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getWebElement()
		 * @generated
		 */
		EClass WEB_ELEMENT = eINSTANCE.getWebElement();

		/**
		 * The meta object literal for the '<em><b>Locators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WEB_ELEMENT__LOCATORS = eINSTANCE.getWebElement_Locators();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.LocatorImpl <em>Locator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.LocatorImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getLocator()
		 * @generated
		 */
		EClass LOCATOR = eINSTANCE.getLocator();

		/**
		 * The meta object literal for the '<em><b>How</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATOR__HOW = eINSTANCE.getLocator_How();

		/**
		 * The meta object literal for the '<em><b>Using</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATOR__USING = eINSTANCE.getLocator_Using();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.impl.LinkImpl <em>Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.impl.LinkImpl
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getLink()
		 * @generated
		 */
		EClass LINK = eINSTANCE.getLink();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__VALUE = eINSTANCE.getLink_Value();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK__TYPE = eINSTANCE.getLink_Type();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.OperationStatus <em>Operation Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.OperationStatus
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getOperationStatus()
		 * @generated
		 */
		EEnum OPERATION_STATUS = eINSTANCE.getOperationStatus();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.model.ScreenshotType <em>Screenshot Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.model.ScreenshotType
		 * @see org.nasdanika.webtest.model.impl.ModelPackageImpl#getScreenshotType()
		 * @generated
		 */
		EEnum SCREENSHOT_TYPE = eINSTANCE.getScreenshotType();

	}

} //ModelPackage
