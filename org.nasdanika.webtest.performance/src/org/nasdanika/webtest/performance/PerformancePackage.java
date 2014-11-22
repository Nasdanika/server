/**
 */
package org.nasdanika.webtest.performance;

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
 * @see org.nasdanika.webtest.performance.PerformanceFactory
 * @model kind="package"
 * @generated
 */
public interface PerformancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "performance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.webtest.performance";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.webtest.performance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PerformancePackage eINSTANCE = org.nasdanika.webtest.performance.impl.PerformancePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl <em>Timing Base</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.performance.impl.TimingBaseImpl
	 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getTimingBase()
	 * @generated
	 */
	int TIMING_BASE = 0;

	/**
	 * The feature id for the '<em><b>Connect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__CONNECT_END = 0;

	/**
	 * The feature id for the '<em><b>Connect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__CONNECT_START = 1;

	/**
	 * The feature id for the '<em><b>Domain Lookup End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__DOMAIN_LOOKUP_END = 2;

	/**
	 * The feature id for the '<em><b>Domain Lookup Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__DOMAIN_LOOKUP_START = 3;

	/**
	 * The feature id for the '<em><b>Fetch Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__FETCH_START = 4;

	/**
	 * The feature id for the '<em><b>Redirect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__REDIRECT_END = 5;

	/**
	 * The feature id for the '<em><b>Redirect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__REDIRECT_START = 6;

	/**
	 * The feature id for the '<em><b>Request Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__REQUEST_START = 7;

	/**
	 * The feature id for the '<em><b>Response End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__RESPONSE_END = 8;

	/**
	 * The feature id for the '<em><b>Response Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__RESPONSE_START = 9;

	/**
	 * The feature id for the '<em><b>Secure Connection Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__SECURE_CONNECTION_START = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__NAME = 11;

	/**
	 * The feature id for the '<em><b>Redirect Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE__REDIRECT_COUNT = 12;

	/**
	 * The number of structural features of the '<em>Timing Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE_FEATURE_COUNT = 13;

	/**
	 * The number of operations of the '<em>Timing Base</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_BASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.performance.impl.ResourceTimingImpl <em>Resource Timing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.performance.impl.ResourceTimingImpl
	 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getResourceTiming()
	 * @generated
	 */
	int RESOURCE_TIMING = 1;

	/**
	 * The feature id for the '<em><b>Connect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__CONNECT_END = TIMING_BASE__CONNECT_END;

	/**
	 * The feature id for the '<em><b>Connect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__CONNECT_START = TIMING_BASE__CONNECT_START;

	/**
	 * The feature id for the '<em><b>Domain Lookup End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__DOMAIN_LOOKUP_END = TIMING_BASE__DOMAIN_LOOKUP_END;

	/**
	 * The feature id for the '<em><b>Domain Lookup Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__DOMAIN_LOOKUP_START = TIMING_BASE__DOMAIN_LOOKUP_START;

	/**
	 * The feature id for the '<em><b>Fetch Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__FETCH_START = TIMING_BASE__FETCH_START;

	/**
	 * The feature id for the '<em><b>Redirect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__REDIRECT_END = TIMING_BASE__REDIRECT_END;

	/**
	 * The feature id for the '<em><b>Redirect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__REDIRECT_START = TIMING_BASE__REDIRECT_START;

	/**
	 * The feature id for the '<em><b>Request Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__REQUEST_START = TIMING_BASE__REQUEST_START;

	/**
	 * The feature id for the '<em><b>Response End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__RESPONSE_END = TIMING_BASE__RESPONSE_END;

	/**
	 * The feature id for the '<em><b>Response Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__RESPONSE_START = TIMING_BASE__RESPONSE_START;

	/**
	 * The feature id for the '<em><b>Secure Connection Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__SECURE_CONNECTION_START = TIMING_BASE__SECURE_CONNECTION_START;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__NAME = TIMING_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Redirect Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__REDIRECT_COUNT = TIMING_BASE__REDIRECT_COUNT;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__DURATION = TIMING_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__START_TIME = TIMING_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__ENTRY_TYPE = TIMING_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initiator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING__INITIATOR_TYPE = TIMING_BASE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Resource Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING_FEATURE_COUNT = TIMING_BASE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Resource Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_TIMING_OPERATION_COUNT = TIMING_BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl <em>Navigation Timing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.performance.impl.NavigationTimingImpl
	 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getNavigationTiming()
	 * @generated
	 */
	int NAVIGATION_TIMING = 2;

	/**
	 * The feature id for the '<em><b>Connect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__CONNECT_END = TIMING_BASE__CONNECT_END;

	/**
	 * The feature id for the '<em><b>Connect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__CONNECT_START = TIMING_BASE__CONNECT_START;

	/**
	 * The feature id for the '<em><b>Domain Lookup End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOMAIN_LOOKUP_END = TIMING_BASE__DOMAIN_LOOKUP_END;

	/**
	 * The feature id for the '<em><b>Domain Lookup Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOMAIN_LOOKUP_START = TIMING_BASE__DOMAIN_LOOKUP_START;

	/**
	 * The feature id for the '<em><b>Fetch Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__FETCH_START = TIMING_BASE__FETCH_START;

	/**
	 * The feature id for the '<em><b>Redirect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__REDIRECT_END = TIMING_BASE__REDIRECT_END;

	/**
	 * The feature id for the '<em><b>Redirect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__REDIRECT_START = TIMING_BASE__REDIRECT_START;

	/**
	 * The feature id for the '<em><b>Request Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__REQUEST_START = TIMING_BASE__REQUEST_START;

	/**
	 * The feature id for the '<em><b>Response End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__RESPONSE_END = TIMING_BASE__RESPONSE_END;

	/**
	 * The feature id for the '<em><b>Response Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__RESPONSE_START = TIMING_BASE__RESPONSE_START;

	/**
	 * The feature id for the '<em><b>Secure Connection Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__SECURE_CONNECTION_START = TIMING_BASE__SECURE_CONNECTION_START;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__NAME = TIMING_BASE__NAME;

	/**
	 * The feature id for the '<em><b>Redirect Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__REDIRECT_COUNT = TIMING_BASE__REDIRECT_COUNT;

	/**
	 * The feature id for the '<em><b>Dom Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOM_COMPLETE = TIMING_BASE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dom Content Loaded Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END = TIMING_BASE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dom Content Loaded Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START = TIMING_BASE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dom Interactive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOM_INTERACTIVE = TIMING_BASE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dom Loading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__DOM_LOADING = TIMING_BASE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Load Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__LOAD_EVENT_END = TIMING_BASE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Load Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__LOAD_EVENT_START = TIMING_BASE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Navigation Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__NAVIGATION_START = TIMING_BASE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Unload Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__UNLOAD_EVENT_END = TIMING_BASE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Unload Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__UNLOAD_EVENT_START = TIMING_BASE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING__ENTRIES = TIMING_BASE_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Navigation Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING_FEATURE_COUNT = TIMING_BASE_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Navigation Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_TIMING_OPERATION_COUNT = TIMING_BASE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl <em>Document Timing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.webtest.performance.impl.DocumentTimingImpl
	 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getDocumentTiming()
	 * @generated
	 */
	int DOCUMENT_TIMING = 3;

	/**
	 * The feature id for the '<em><b>Connect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__CONNECT_END = NAVIGATION_TIMING__CONNECT_END;

	/**
	 * The feature id for the '<em><b>Connect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__CONNECT_START = NAVIGATION_TIMING__CONNECT_START;

	/**
	 * The feature id for the '<em><b>Domain Lookup End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOMAIN_LOOKUP_END = NAVIGATION_TIMING__DOMAIN_LOOKUP_END;

	/**
	 * The feature id for the '<em><b>Domain Lookup Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOMAIN_LOOKUP_START = NAVIGATION_TIMING__DOMAIN_LOOKUP_START;

	/**
	 * The feature id for the '<em><b>Fetch Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__FETCH_START = NAVIGATION_TIMING__FETCH_START;

	/**
	 * The feature id for the '<em><b>Redirect End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__REDIRECT_END = NAVIGATION_TIMING__REDIRECT_END;

	/**
	 * The feature id for the '<em><b>Redirect Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__REDIRECT_START = NAVIGATION_TIMING__REDIRECT_START;

	/**
	 * The feature id for the '<em><b>Request Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__REQUEST_START = NAVIGATION_TIMING__REQUEST_START;

	/**
	 * The feature id for the '<em><b>Response End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__RESPONSE_END = NAVIGATION_TIMING__RESPONSE_END;

	/**
	 * The feature id for the '<em><b>Response Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__RESPONSE_START = NAVIGATION_TIMING__RESPONSE_START;

	/**
	 * The feature id for the '<em><b>Secure Connection Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__SECURE_CONNECTION_START = NAVIGATION_TIMING__SECURE_CONNECTION_START;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__NAME = NAVIGATION_TIMING__NAME;

	/**
	 * The feature id for the '<em><b>Redirect Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__REDIRECT_COUNT = NAVIGATION_TIMING__REDIRECT_COUNT;

	/**
	 * The feature id for the '<em><b>Dom Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOM_COMPLETE = NAVIGATION_TIMING__DOM_COMPLETE;

	/**
	 * The feature id for the '<em><b>Dom Content Loaded Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOM_CONTENT_LOADED_EVENT_END = NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END;

	/**
	 * The feature id for the '<em><b>Dom Content Loaded Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOM_CONTENT_LOADED_EVENT_START = NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START;

	/**
	 * The feature id for the '<em><b>Dom Interactive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOM_INTERACTIVE = NAVIGATION_TIMING__DOM_INTERACTIVE;

	/**
	 * The feature id for the '<em><b>Dom Loading</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DOM_LOADING = NAVIGATION_TIMING__DOM_LOADING;

	/**
	 * The feature id for the '<em><b>Load Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__LOAD_EVENT_END = NAVIGATION_TIMING__LOAD_EVENT_END;

	/**
	 * The feature id for the '<em><b>Load Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__LOAD_EVENT_START = NAVIGATION_TIMING__LOAD_EVENT_START;

	/**
	 * The feature id for the '<em><b>Navigation Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__NAVIGATION_START = NAVIGATION_TIMING__NAVIGATION_START;

	/**
	 * The feature id for the '<em><b>Unload Event End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__UNLOAD_EVENT_END = NAVIGATION_TIMING__UNLOAD_EVENT_END;

	/**
	 * The feature id for the '<em><b>Unload Event Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__UNLOAD_EVENT_START = NAVIGATION_TIMING__UNLOAD_EVENT_START;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__ENTRIES = NAVIGATION_TIMING__ENTRIES;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__DURATION = NAVIGATION_TIMING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__START_TIME = NAVIGATION_TIMING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__ENTRY_TYPE = NAVIGATION_TIMING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initiator Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING__INITIATOR_TYPE = NAVIGATION_TIMING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Document Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING_FEATURE_COUNT = NAVIGATION_TIMING_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Document Timing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_TIMING_OPERATION_COUNT = NAVIGATION_TIMING_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.performance.TimingBase <em>Timing Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timing Base</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase
	 * @generated
	 */
	EClass getTimingBase();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getConnectEnd <em>Connect End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connect End</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getConnectEnd()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_ConnectEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getConnectStart <em>Connect Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connect Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getConnectStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_ConnectStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getDomainLookupEnd <em>Domain Lookup End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Lookup End</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getDomainLookupEnd()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_DomainLookupEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getDomainLookupStart <em>Domain Lookup Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Lookup Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getDomainLookupStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_DomainLookupStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getFetchStart <em>Fetch Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fetch Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getFetchStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_FetchStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getRedirectEnd <em>Redirect End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Redirect End</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getRedirectEnd()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_RedirectEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getRedirectStart <em>Redirect Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Redirect Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getRedirectStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_RedirectStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getRequestStart <em>Request Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Request Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getRequestStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_RequestStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getResponseEnd <em>Response End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response End</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getResponseEnd()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_ResponseEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getResponseStart <em>Response Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Response Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getResponseStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_ResponseStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getSecureConnectionStart <em>Secure Connection Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secure Connection Start</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getSecureConnectionStart()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_SecureConnectionStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getName()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.TimingBase#getRedirectCount <em>Redirect Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Redirect Count</em>'.
	 * @see org.nasdanika.webtest.performance.TimingBase#getRedirectCount()
	 * @see #getTimingBase()
	 * @generated
	 */
	EAttribute getTimingBase_RedirectCount();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.performance.ResourceTiming <em>Resource Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Timing</em>'.
	 * @see org.nasdanika.webtest.performance.ResourceTiming
	 * @generated
	 */
	EClass getResourceTiming();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.ResourceTiming#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.nasdanika.webtest.performance.ResourceTiming#getDuration()
	 * @see #getResourceTiming()
	 * @generated
	 */
	EAttribute getResourceTiming_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.ResourceTiming#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see org.nasdanika.webtest.performance.ResourceTiming#getStartTime()
	 * @see #getResourceTiming()
	 * @generated
	 */
	EAttribute getResourceTiming_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.ResourceTiming#getEntryType <em>Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Type</em>'.
	 * @see org.nasdanika.webtest.performance.ResourceTiming#getEntryType()
	 * @see #getResourceTiming()
	 * @generated
	 */
	EAttribute getResourceTiming_EntryType();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.ResourceTiming#getInitiatorType <em>Initiator Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initiator Type</em>'.
	 * @see org.nasdanika.webtest.performance.ResourceTiming#getInitiatorType()
	 * @see #getResourceTiming()
	 * @generated
	 */
	EAttribute getResourceTiming_InitiatorType();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.performance.NavigationTiming <em>Navigation Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Timing</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming
	 * @generated
	 */
	EClass getNavigationTiming();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomComplete <em>Dom Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dom Complete</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getDomComplete()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_DomComplete();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventEnd <em>Dom Content Loaded Event End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dom Content Loaded Event End</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventEnd()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_DomContentLoadedEventEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventStart <em>Dom Content Loaded Event Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dom Content Loaded Event Start</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getDomContentLoadedEventStart()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_DomContentLoadedEventStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomInteractive <em>Dom Interactive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dom Interactive</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getDomInteractive()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_DomInteractive();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getDomLoading <em>Dom Loading</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dom Loading</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getDomLoading()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_DomLoading();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getLoadEventEnd <em>Load Event End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Event End</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getLoadEventEnd()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_LoadEventEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getLoadEventStart <em>Load Event Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load Event Start</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getLoadEventStart()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_LoadEventStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getNavigationStart <em>Navigation Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Navigation Start</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getNavigationStart()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_NavigationStart();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventEnd <em>Unload Event End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unload Event End</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventEnd()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_UnloadEventEnd();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventStart <em>Unload Event Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unload Event Start</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getUnloadEventStart()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EAttribute getNavigationTiming_UnloadEventStart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.webtest.performance.NavigationTiming#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.nasdanika.webtest.performance.NavigationTiming#getEntries()
	 * @see #getNavigationTiming()
	 * @generated
	 */
	EReference getNavigationTiming_Entries();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.webtest.performance.DocumentTiming <em>Document Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Timing</em>'.
	 * @see org.nasdanika.webtest.performance.DocumentTiming
	 * @generated
	 */
	EClass getDocumentTiming();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PerformanceFactory getPerformanceFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.webtest.performance.impl.TimingBaseImpl <em>Timing Base</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.performance.impl.TimingBaseImpl
		 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getTimingBase()
		 * @generated
		 */
		EClass TIMING_BASE = eINSTANCE.getTimingBase();

		/**
		 * The meta object literal for the '<em><b>Connect End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__CONNECT_END = eINSTANCE.getTimingBase_ConnectEnd();

		/**
		 * The meta object literal for the '<em><b>Connect Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__CONNECT_START = eINSTANCE.getTimingBase_ConnectStart();

		/**
		 * The meta object literal for the '<em><b>Domain Lookup End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__DOMAIN_LOOKUP_END = eINSTANCE.getTimingBase_DomainLookupEnd();

		/**
		 * The meta object literal for the '<em><b>Domain Lookup Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__DOMAIN_LOOKUP_START = eINSTANCE.getTimingBase_DomainLookupStart();

		/**
		 * The meta object literal for the '<em><b>Fetch Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__FETCH_START = eINSTANCE.getTimingBase_FetchStart();

		/**
		 * The meta object literal for the '<em><b>Redirect End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__REDIRECT_END = eINSTANCE.getTimingBase_RedirectEnd();

		/**
		 * The meta object literal for the '<em><b>Redirect Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__REDIRECT_START = eINSTANCE.getTimingBase_RedirectStart();

		/**
		 * The meta object literal for the '<em><b>Request Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__REQUEST_START = eINSTANCE.getTimingBase_RequestStart();

		/**
		 * The meta object literal for the '<em><b>Response End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__RESPONSE_END = eINSTANCE.getTimingBase_ResponseEnd();

		/**
		 * The meta object literal for the '<em><b>Response Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__RESPONSE_START = eINSTANCE.getTimingBase_ResponseStart();

		/**
		 * The meta object literal for the '<em><b>Secure Connection Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__SECURE_CONNECTION_START = eINSTANCE.getTimingBase_SecureConnectionStart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__NAME = eINSTANCE.getTimingBase_Name();

		/**
		 * The meta object literal for the '<em><b>Redirect Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMING_BASE__REDIRECT_COUNT = eINSTANCE.getTimingBase_RedirectCount();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.performance.impl.ResourceTimingImpl <em>Resource Timing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.performance.impl.ResourceTimingImpl
		 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getResourceTiming()
		 * @generated
		 */
		EClass RESOURCE_TIMING = eINSTANCE.getResourceTiming();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TIMING__DURATION = eINSTANCE.getResourceTiming_Duration();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TIMING__START_TIME = eINSTANCE.getResourceTiming_StartTime();

		/**
		 * The meta object literal for the '<em><b>Entry Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TIMING__ENTRY_TYPE = eINSTANCE.getResourceTiming_EntryType();

		/**
		 * The meta object literal for the '<em><b>Initiator Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_TIMING__INITIATOR_TYPE = eINSTANCE.getResourceTiming_InitiatorType();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.performance.impl.NavigationTimingImpl <em>Navigation Timing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.performance.impl.NavigationTimingImpl
		 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getNavigationTiming()
		 * @generated
		 */
		EClass NAVIGATION_TIMING = eINSTANCE.getNavigationTiming();

		/**
		 * The meta object literal for the '<em><b>Dom Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__DOM_COMPLETE = eINSTANCE.getNavigationTiming_DomComplete();

		/**
		 * The meta object literal for the '<em><b>Dom Content Loaded Event End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_END = eINSTANCE.getNavigationTiming_DomContentLoadedEventEnd();

		/**
		 * The meta object literal for the '<em><b>Dom Content Loaded Event Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__DOM_CONTENT_LOADED_EVENT_START = eINSTANCE.getNavigationTiming_DomContentLoadedEventStart();

		/**
		 * The meta object literal for the '<em><b>Dom Interactive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__DOM_INTERACTIVE = eINSTANCE.getNavigationTiming_DomInteractive();

		/**
		 * The meta object literal for the '<em><b>Dom Loading</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__DOM_LOADING = eINSTANCE.getNavigationTiming_DomLoading();

		/**
		 * The meta object literal for the '<em><b>Load Event End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__LOAD_EVENT_END = eINSTANCE.getNavigationTiming_LoadEventEnd();

		/**
		 * The meta object literal for the '<em><b>Load Event Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__LOAD_EVENT_START = eINSTANCE.getNavigationTiming_LoadEventStart();

		/**
		 * The meta object literal for the '<em><b>Navigation Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__NAVIGATION_START = eINSTANCE.getNavigationTiming_NavigationStart();

		/**
		 * The meta object literal for the '<em><b>Unload Event End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__UNLOAD_EVENT_END = eINSTANCE.getNavigationTiming_UnloadEventEnd();

		/**
		 * The meta object literal for the '<em><b>Unload Event Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_TIMING__UNLOAD_EVENT_START = eINSTANCE.getNavigationTiming_UnloadEventStart();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_TIMING__ENTRIES = eINSTANCE.getNavigationTiming_Entries();

		/**
		 * The meta object literal for the '{@link org.nasdanika.webtest.performance.impl.DocumentTimingImpl <em>Document Timing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.webtest.performance.impl.DocumentTimingImpl
		 * @see org.nasdanika.webtest.performance.impl.PerformancePackageImpl#getDocumentTiming()
		 * @generated
		 */
		EClass DOCUMENT_TIMING = eINSTANCE.getDocumentTiming();

	}

} //PerformancePackage
