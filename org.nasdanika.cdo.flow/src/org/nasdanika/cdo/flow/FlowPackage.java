/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.nasdanika.cdo.flow.FlowFactory
 * @model kind="package"
 * @generated
 */
public interface FlowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "flow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.flow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.flow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FlowPackage eINSTANCE = org.nasdanika.cdo.flow.impl.FlowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Reference <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Reference
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TARGET = 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Then <em>Then</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Then
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getThen()
	 * @generated
	 */
	int THEN = 1;

	/**
	 * The number of structural features of the '<em>Then</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>On Fulfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN___ON_FULFILLED__OBJECT_CONTEXT = 0;

	/**
	 * The operation id for the '<em>On Rejected</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN___ON_REJECTED__EXCEPTION_CONTEXT = 1;

	/**
	 * The number of operations of the '<em>Then</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ThenReferenceImpl <em>Then Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ThenReferenceImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getThenReference()
	 * @generated
	 */
	int THEN_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE__TARGET = REFERENCE__TARGET;

	/**
	 * The number of structural features of the '<em>Then Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE_FEATURE_COUNT = REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>On Fulfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE___ON_FULFILLED__OBJECT_CONTEXT = REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>On Rejected</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE___ON_REJECTED__EXCEPTION_CONTEXT = REFERENCE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Then Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE_OPERATION_COUNT = REFERENCE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Command <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Command
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 8;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Promise <em>Promise</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Promise
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromise()
	 * @generated
	 */
	int PROMISE = 4;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DeferredImpl <em>Deferred</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DeferredImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferred()
	 * @generated
	 */
	int DEFERRED = 9;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JobImpl <em>Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JobImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJob()
	 * @generated
	 */
	int JOB = 10;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.JobQueue <em>Job Queue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.JobQueue
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJobQueue()
	 * @generated
	 */
	int JOB_QUEUE = 11;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Executor <em>Executor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Executor
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getExecutor()
	 * @generated
	 */
	int EXECUTOR = 3;

	/**
	 * The number of structural features of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Executor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTOR_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__DONE = 0;

	/**
	 * The feature id for the '<em><b>Expires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__EXPIRES = 1;

	/**
	 * The number of structural features of the '<em>Promise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Then</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___THEN__THEN_CONTEXT_EXECUTOR = 0;

	/**
	 * The operation id for the '<em>Get Fulfillment Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___GET_FULFILLMENT_VALUE__CONTEXT = 1;

	/**
	 * The operation id for the '<em>Get Rejection Reason</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___GET_REJECTION_REASON__CONTEXT = 2;

	/**
	 * The operation id for the '<em>Get State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___GET_STATE = 3;

	/**
	 * The operation id for the '<em>Cancel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___CANCEL = 4;

	/**
	 * The number of operations of the '<em>Promise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_OPERATION_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.PromiseReferenceImpl <em>Promise Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.PromiseReferenceImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromiseReference()
	 * @generated
	 */
	int PROMISE_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE__DONE = PROMISE__DONE;

	/**
	 * The feature id for the '<em><b>Expires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE__EXPIRES = PROMISE__EXPIRES;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE__TARGET = PROMISE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Promise Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE_FEATURE_COUNT = PROMISE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Then</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE___THEN__THEN_CONTEXT_EXECUTOR = PROMISE___THEN__THEN_CONTEXT_EXECUTOR;

	/**
	 * The operation id for the '<em>Get Fulfillment Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE___GET_FULFILLMENT_VALUE__CONTEXT = PROMISE___GET_FULFILLMENT_VALUE__CONTEXT;

	/**
	 * The operation id for the '<em>Get Rejection Reason</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE___GET_REJECTION_REASON__CONTEXT = PROMISE___GET_REJECTION_REASON__CONTEXT;

	/**
	 * The operation id for the '<em>Get State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE___GET_STATE = PROMISE___GET_STATE;

	/**
	 * The operation id for the '<em>Cancel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE___CANCEL = PROMISE___CANCEL;

	/**
	 * The number of operations of the '<em>Promise Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_REFERENCE_OPERATION_COUNT = PROMISE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.AllImpl <em>All</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.AllImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAll()
	 * @generated
	 */
	int ALL = 6;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.AnyImpl <em>Any</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.AnyImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAny()
	 * @generated
	 */
	int ANY = 7;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__DONE = PROMISE__DONE;

	/**
	 * The feature id for the '<em><b>Expires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL__EXPIRES = PROMISE__EXPIRES;

	/**
	 * The number of structural features of the '<em>All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_FEATURE_COUNT = PROMISE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Then</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL___THEN__THEN_CONTEXT_EXECUTOR = PROMISE___THEN__THEN_CONTEXT_EXECUTOR;

	/**
	 * The operation id for the '<em>Get Fulfillment Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL___GET_FULFILLMENT_VALUE__CONTEXT = PROMISE___GET_FULFILLMENT_VALUE__CONTEXT;

	/**
	 * The operation id for the '<em>Get Rejection Reason</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL___GET_REJECTION_REASON__CONTEXT = PROMISE___GET_REJECTION_REASON__CONTEXT;

	/**
	 * The operation id for the '<em>Get State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL___GET_STATE = PROMISE___GET_STATE;

	/**
	 * The operation id for the '<em>Cancel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL___CANCEL = PROMISE___CANCEL;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL___INIT__ELIST_EXECUTOR = PROMISE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>All</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALL_OPERATION_COUNT = PROMISE_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__DONE = PROMISE__DONE;

	/**
	 * The feature id for the '<em><b>Expires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY__EXPIRES = PROMISE__EXPIRES;

	/**
	 * The number of structural features of the '<em>Any</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_FEATURE_COUNT = PROMISE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Then</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY___THEN__THEN_CONTEXT_EXECUTOR = PROMISE___THEN__THEN_CONTEXT_EXECUTOR;

	/**
	 * The operation id for the '<em>Get Fulfillment Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY___GET_FULFILLMENT_VALUE__CONTEXT = PROMISE___GET_FULFILLMENT_VALUE__CONTEXT;

	/**
	 * The operation id for the '<em>Get Rejection Reason</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY___GET_REJECTION_REASON__CONTEXT = PROMISE___GET_REJECTION_REASON__CONTEXT;

	/**
	 * The operation id for the '<em>Get State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY___GET_STATE = PROMISE___GET_STATE;

	/**
	 * The operation id for the '<em>Cancel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY___CANCEL = PROMISE___CANCEL;

	/**
	 * The operation id for the '<em>Init</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY___INIT__ELIST_EXECUTOR = PROMISE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Any</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_OPERATION_COUNT = PROMISE_OPERATION_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND___EXECUTE__CONTEXT_EXECUTOR = 0;

	/**
	 * The number of operations of the '<em>Command</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMAND_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__DONE = PROMISE__DONE;

	/**
	 * The feature id for the '<em><b>Expires</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__EXPIRES = PROMISE__EXPIRES;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__STATE = PROMISE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__CREATED = PROMISE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__RESOLVED = PROMISE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__COMMENT = PROMISE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resolution</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__RESOLUTION = PROMISE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__THEN = PROMISE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Then Deferreds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED__THEN_DEFERREDS = PROMISE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Deferred</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_FEATURE_COUNT = PROMISE_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>Then</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___THEN__THEN_CONTEXT_EXECUTOR = PROMISE___THEN__THEN_CONTEXT_EXECUTOR;

	/**
	 * The operation id for the '<em>Get Fulfillment Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___GET_FULFILLMENT_VALUE__CONTEXT = PROMISE___GET_FULFILLMENT_VALUE__CONTEXT;

	/**
	 * The operation id for the '<em>Get Rejection Reason</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___GET_REJECTION_REASON__CONTEXT = PROMISE___GET_REJECTION_REASON__CONTEXT;

	/**
	 * The operation id for the '<em>Get State</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___GET_STATE = PROMISE___GET_STATE;

	/**
	 * The operation id for the '<em>Cancel</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___CANCEL = PROMISE___CANCEL;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___EXECUTE__CONTEXT_EXECUTOR = PROMISE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___RESOLVE__OBJECT_CONTEXT_EXECUTOR = PROMISE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___RESOLVE__PROMISE_CONTEXT_EXECUTOR = PROMISE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Reject</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED___REJECT__EXCEPTION_CONTEXT_EXECUTOR = PROMISE_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Deferred</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_OPERATION_COUNT = PROMISE_OPERATION_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Command</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__COMMAND = 0;

	/**
	 * The feature id for the '<em><b>Deferred</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__DEFERRED = 1;

	/**
	 * The feature id for the '<em><b>Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__CREATED = 2;

	/**
	 * The feature id for the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__STARTED = 3;

	/**
	 * The feature id for the '<em><b>Completed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__COMPLETED = 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__STATUS = 5;

	/**
	 * The feature id for the '<em><b>When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__WHEN = 6;

	/**
	 * The feature id for the '<em><b>Failure Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB__FAILURE_REASON = 7;

	/**
	 * The number of structural features of the '<em>Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_FEATURE_COUNT = 8;

	/**
	 * The operation id for the '<em>Can Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB___CAN_EXECUTE = 0;

	/**
	 * The number of operations of the '<em>Job</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_OPERATION_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_QUEUE__JOBS = 0;

	/**
	 * The number of structural features of the '<em>Job Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_QUEUE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Job Queue</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOB_QUEUE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Actuator <em>Actuator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Actuator
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActuator()
	 * @generated
	 */
	int ACTUATOR = 12;

	/**
	 * The number of structural features of the '<em>Actuator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Actuator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.ActuatorReference <em>Actuator Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.ActuatorReference
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActuatorReference()
	 * @generated
	 */
	int ACTUATOR_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_REFERENCE__TARGET = ACTUATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Actuator Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_REFERENCE_FEATURE_COUNT = ACTUATOR_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Actuator Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_REFERENCE_OPERATION_COUNT = ACTUATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Invocable <em>Invocable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Invocable
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocable()
	 * @generated
	 */
	int INVOCABLE = 14;

	/**
	 * The number of structural features of the '<em>Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_FEATURE_COUNT = ACTUATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE___INVOKE__CONTEXT_ELIST = ACTUATOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE___ACCEPT__CONTEXT_ELIST = ACTUATOR_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_OPERATION_COUNT = ACTUATOR_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.InvocableThenImpl <em>Invocable Then</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.InvocableThenImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocableThen()
	 * @generated
	 */
	int INVOCABLE_THEN = 15;

	/**
	 * The feature id for the '<em><b>On Fulfilled</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_THEN__ON_FULFILLED = THEN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>On Rejected</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_THEN__ON_REJECTED = THEN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Invocable Then</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_THEN_FEATURE_COUNT = THEN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>On Fulfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_THEN___ON_FULFILLED__OBJECT_CONTEXT = THEN___ON_FULFILLED__OBJECT_CONTEXT;

	/**
	 * The operation id for the '<em>On Rejected</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_THEN___ON_REJECTED__EXCEPTION_CONTEXT = THEN___ON_REJECTED__EXCEPTION_CONTEXT;

	/**
	 * The number of operations of the '<em>Invocable Then</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_THEN_OPERATION_COUNT = THEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.InvocableReferenceImpl <em>Invocable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.InvocableReferenceImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocableReference()
	 * @generated
	 */
	int INVOCABLE_REFERENCE = 16;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_REFERENCE__TARGET = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Invocable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_REFERENCE_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_REFERENCE___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_REFERENCE___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Invocable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_REFERENCE_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.BoundInvocableImpl <em>Bound Invocable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.BoundInvocableImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getBoundInvocable()
	 * @generated
	 */
	int BOUND_INVOCABLE = 17;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE__BINDINGS = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE__TARGET = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bound Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Bind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE___BIND__CONTEXT_ELIST = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bound Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUND_INVOCABLE_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Action <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Action
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 22;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ActionOutputEntryImpl <em>Action Output Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ActionOutputEntryImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionOutputEntry()
	 * @generated
	 */
	int ACTION_OUTPUT_ENTRY = 26;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ErrorHandlerEntryImpl <em>Error Handler Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ErrorHandlerEntryImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getErrorHandlerEntry()
	 * @generated
	 */
	int ERROR_HANDLER_ENTRY = 27;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DispatchImpl <em>Dispatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DispatchImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDispatch()
	 * @generated
	 */
	int DISPATCH = 28;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.PublishImpl <em>Publish</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.PublishImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPublish()
	 * @generated
	 */
	int PUBLISH = 29;

	/**
	 * The meta object id for the '{@link org.nasdanika.core.Adaptable <em>Adaptable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Adaptable
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAdaptable()
	 * @generated
	 */
	int ADAPTABLE = 30;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.FlowImpl <em>Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.FlowImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getFlow()
	 * @generated
	 */
	int FLOW = 31;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.FlowInputEntryImpl <em>Input Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.FlowInputEntryImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getFlowInputEntry()
	 * @generated
	 */
	int FLOW_INPUT_ENTRY = 32;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.FlowOutputEntryImpl <em>Output Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.FlowOutputEntryImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getFlowOutputEntry()
	 * @generated
	 */
	int FLOW_OUTPUT_ENTRY = 33;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JoinElementImpl <em>Join Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JoinElementImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoinElement()
	 * @generated
	 */
	int JOIN_ELEMENT = 34;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JoinInputImpl <em>Join Input</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JoinInputImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoinInput()
	 * @generated
	 */
	int JOIN_INPUT = 35;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JoinInputEntryImpl <em>Join Input Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JoinInputEntryImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoinInputEntry()
	 * @generated
	 */
	int JOIN_INPUT_ENTRY = 36;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JoinImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 37;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ValuePropertyImpl <em>Value Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ValuePropertyImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getValueProperty()
	 * @generated
	 */
	int VALUE_PROPERTY = 38;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ServiceReferenceImpl <em>Service Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ServiceReferenceImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getServiceReference()
	 * @generated
	 */
	int SERVICE_REFERENCE = 40;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DeferredInvocationImpl <em>Deferred Invocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DeferredInvocationImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferredInvocation()
	 * @generated
	 */
	int DEFERRED_INVOCATION = 19;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Property <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Property
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 20;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.PropertyReferenceImpl <em>Property Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.PropertyReferenceImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPropertyReference()
	 * @generated
	 */
	int PROPERTY_REFERENCE = 21;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DeferringInvocableImpl <em>Deferring Invocable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DeferringInvocableImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferringInvocable()
	 * @generated
	 */
	int DEFERRING_INVOCABLE = 18;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE__TARGET = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE__INVOCATIONS = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE__DELAY = INVOCABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Deferring Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Deferring Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_INVOCATION__ARGUMENTS = COMMAND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_INVOCATION__RESULT = COMMAND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Deferred Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_INVOCATION_FEATURE_COUNT = COMMAND_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_INVOCATION___EXECUTE__CONTEXT_EXECUTOR = COMMAND___EXECUTE__CONTEXT_EXECUTOR;

	/**
	 * The number of operations of the '<em>Deferred Invocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRED_INVOCATION_OPERATION_COUNT = COMMAND_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = ACTUATOR_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___GET = ACTUATOR_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY___SET__OBJECT = ACTUATOR_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = ACTUATOR_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE__TARGET = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE___GET = PROPERTY___GET;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE___SET__OBJECT = PROPERTY___SET__OBJECT;

	/**
	 * The number of operations of the '<em>Property Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_REFERENCE_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OUTPUTS = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Error Handlers</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__ERROR_HANDLERS = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.JavaActionDelegate <em>Java Action Delegate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.JavaActionDelegate
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJavaActionDelegate()
	 * @generated
	 */
	int JAVA_ACTION_DELEGATE = 23;

	/**
	 * The number of structural features of the '<em>Java Action Delegate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION_DELEGATE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Java Action Delegate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION_DELEGATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.PropertyEntryImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPropertyEntry()
	 * @generated
	 */
	int PROPERTY_ENTRY = 24;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Property Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Property Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JavaActionImpl <em>Java Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JavaActionImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJavaAction()
	 * @generated
	 */
	int JAVA_ACTION = 25;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION__OUTPUTS = ACTION__OUTPUTS;

	/**
	 * The feature id for the '<em><b>Error Handlers</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION__ERROR_HANDLERS = ACTION__ERROR_HANDLERS;

	/**
	 * The feature id for the '<em><b>Delegate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION__DELEGATE = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION__PROPERTIES = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Java Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION___INVOKE__CONTEXT_ELIST = ACTION___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION___ACCEPT__CONTEXT_ELIST = ACTION___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Java Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Action Output Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Action Output Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLER_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLER_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Error Handler Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLER_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Error Handler Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_HANDLER_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH__TARGETS = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dispatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Dispatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH__TARGETS = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Publish</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Publish</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Adaptable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Adaptable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADAPTABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__JOBS = JOB_QUEUE__JOBS;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__CONTENTS = JOB_QUEUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__INPUTS = JOB_QUEUE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__OUTPUTS = JOB_QUEUE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Error Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW__ERROR_HANDLER = JOB_QUEUE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_FEATURE_COUNT = JOB_QUEUE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Adapt</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW___ADAPT__CLASS_CONTEXT = JOB_QUEUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OPERATION_COUNT = JOB_QUEUE_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_INPUT_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_INPUT_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Input Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_INPUT_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Input Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_INPUT_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OUTPUT_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OUTPUT_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Output Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OUTPUT_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Output Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OUTPUT_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT__ARGUMENTS = DEFERRED_INVOCATION__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT__RESULT = DEFERRED_INVOCATION__RESULT;

	/**
	 * The feature id for the '<em><b>Consumed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT__CONSUMED = DEFERRED_INVOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collector</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT__COLLECTOR = DEFERRED_INVOCATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Join Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT_FEATURE_COUNT = DEFERRED_INVOCATION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Execute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT___EXECUTE__CONTEXT_EXECUTOR = DEFERRED_INVOCATION___EXECUTE__CONTEXT_EXECUTOR;

	/**
	 * The number of operations of the '<em>Join Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_ELEMENT_OPERATION_COUNT = DEFERRED_INVOCATION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT__OUTER = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT__ELEMENTS = INVOCABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Join Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT___INVOKE__CONTEXT_ELIST = INVOCABLE___INVOKE__CONTEXT_ELIST;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT___ACCEPT__CONTEXT_ELIST = INVOCABLE___ACCEPT__CONTEXT_ELIST;

	/**
	 * The number of operations of the '<em>Join Input</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT_OPERATION_COUNT = INVOCABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Join Input Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Join Input Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_INPUT_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Jobs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__JOBS = JOB_QUEUE__JOBS;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__INPUTS = JOB_QUEUE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Joiner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__JOINER = JOB_QUEUE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = JOB_QUEUE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Finish Join</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN___FINISH_JOIN = JOB_QUEUE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_OPERATION_COUNT = JOB_QUEUE_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY__VALUE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY___GET = PROPERTY___GET;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY___SET__OBJECT = PROPERTY___SET__OBJECT;

	/**
	 * The number of operations of the '<em>Value Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_PROPERTY_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.core.Component <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Component
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 39;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE__TYPE = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE__FILTER = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Service Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE___GET = PROPERTY___GET;

	/**
	 * The operation id for the '<em>Set</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE___SET__OBJECT = PROPERTY___SET__OBJECT;

	/**
	 * The number of operations of the '<em>Service Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_REFERENCE_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.PromiseState <em>Promise State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.PromiseState
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromiseState()
	 * @generated
	 */
	int PROMISE_STATE = 41;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.JobStatus <em>Job Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.JobStatus
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJobStatus()
	 * @generated
	 */
	int JOB_STATUS = 42;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.ActionState <em>Action State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.ActionState
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionState()
	 * @generated
	 */
	int ACTION_STATE = 43;

	/**
	 * The meta object id for the '<em>Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Context
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 44;


	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 45;


	/**
	 * The meta object id for the '<em>CDO Transaction Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.CDOTransactionContext
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getCDOTransactionContext()
	 * @generated
	 */
	int CDO_TRANSACTION_CONTEXT = 46;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see org.nasdanika.cdo.flow.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.flow.Reference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.flow.Reference#getTarget()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Target();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Then <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Then</em>'.
	 * @see org.nasdanika.cdo.flow.Then
	 * @generated
	 */
	EClass getThen();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Then#onFulfilled(java.lang.Object, org.nasdanika.core.Context) <em>On Fulfilled</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>On Fulfilled</em>' operation.
	 * @see org.nasdanika.cdo.flow.Then#onFulfilled(java.lang.Object, org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getThen__OnFulfilled__Object_Context();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Then#onRejected(java.lang.Exception, org.nasdanika.core.Context) <em>On Rejected</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>On Rejected</em>' operation.
	 * @see org.nasdanika.cdo.flow.Then#onRejected(java.lang.Exception, org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getThen__OnRejected__Exception_Context();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.ThenReference <em>Then Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Then Reference</em>'.
	 * @see org.nasdanika.cdo.flow.ThenReference
	 * @generated
	 */
	EClass getThenReference();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Promise <em>Promise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Promise</em>'.
	 * @see org.nasdanika.cdo.flow.Promise
	 * @generated
	 */
	EClass getPromise();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Promise#isDone <em>Done</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Done</em>'.
	 * @see org.nasdanika.cdo.flow.Promise#isDone()
	 * @see #getPromise()
	 * @generated
	 */
	EAttribute getPromise_Done();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Promise#getExpires <em>Expires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expires</em>'.
	 * @see org.nasdanika.cdo.flow.Promise#getExpires()
	 * @see #getPromise()
	 * @generated
	 */
	EAttribute getPromise_Expires();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Promise#then(org.nasdanika.cdo.flow.Then, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor) <em>Then</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Then</em>' operation.
	 * @see org.nasdanika.cdo.flow.Promise#then(org.nasdanika.cdo.flow.Then, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getPromise__Then__Then_Context_Executor();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Deferred <em>Deferred</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deferred</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred
	 * @generated
	 */
	EClass getDeferred();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Deferred#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getState()
	 * @see #getDeferred()
	 * @generated
	 */
	EAttribute getDeferred_State();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Deferred#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getCreated()
	 * @see #getDeferred()
	 * @generated
	 */
	EAttribute getDeferred_Created();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Deferred#getResolved <em>Resolved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resolved</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getResolved()
	 * @see #getDeferred()
	 * @generated
	 */
	EAttribute getDeferred_Resolved();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Deferred#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getComment()
	 * @see #getDeferred()
	 * @generated
	 */
	EAttribute getDeferred_Comment();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.Deferred#getResolution <em>Resolution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resolution</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getResolution()
	 * @see #getDeferred()
	 * @generated
	 */
	EReference getDeferred_Resolution();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.Deferred#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getThen()
	 * @see #getDeferred()
	 * @generated
	 */
	EReference getDeferred_Then();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.Deferred#getThenDeferreds <em>Then Deferreds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Then Deferreds</em>'.
	 * @see org.nasdanika.cdo.flow.Deferred#getThenDeferreds()
	 * @see #getDeferred()
	 * @generated
	 */
	EReference getDeferred_ThenDeferreds();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Deferred#resolve(java.lang.Object, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor) <em>Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resolve</em>' operation.
	 * @see org.nasdanika.cdo.flow.Deferred#resolve(java.lang.Object, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getDeferred__Resolve__Object_Context_Executor();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Deferred#resolve(org.nasdanika.cdo.flow.Promise, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor) <em>Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resolve</em>' operation.
	 * @see org.nasdanika.cdo.flow.Deferred#resolve(org.nasdanika.cdo.flow.Promise, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getDeferred__Resolve__Promise_Context_Executor();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Deferred#reject(java.lang.Exception, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor) <em>Reject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reject</em>' operation.
	 * @see org.nasdanika.cdo.flow.Deferred#reject(java.lang.Exception, org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getDeferred__Reject__Exception_Context_Executor();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Job <em>Job</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job</em>'.
	 * @see org.nasdanika.cdo.flow.Job
	 * @generated
	 */
	EClass getJob();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.flow.Job#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Command</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getCommand()
	 * @see #getJob()
	 * @generated
	 */
	EReference getJob_Command();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.flow.Job#getDeferred <em>Deferred</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deferred</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getDeferred()
	 * @see #getJob()
	 * @generated
	 */
	EReference getJob_Deferred();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Job#getCreated <em>Created</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Created</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getCreated()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Created();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Job#getStarted <em>Started</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Started</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getStarted()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Started();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Job#getCompleted <em>Completed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Completed</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getCompleted()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Completed();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Job#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getStatus()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Job#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>When</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getWhen()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_When();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.Job#getFailureReason <em>Failure Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Failure Reason</em>'.
	 * @see org.nasdanika.cdo.flow.Job#getFailureReason()
	 * @see #getJob()
	 * @generated
	 */
	EAttribute getJob_FailureReason();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Job#canExecute() <em>Can Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Can Execute</em>' operation.
	 * @see org.nasdanika.cdo.flow.Job#canExecute()
	 * @generated
	 */
	EOperation getJob__CanExecute();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.JobQueue <em>Job Queue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Job Queue</em>'.
	 * @see org.nasdanika.cdo.flow.JobQueue
	 * @generated
	 */
	EClass getJobQueue();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.JobQueue#getJobs <em>Jobs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Jobs</em>'.
	 * @see org.nasdanika.cdo.flow.JobQueue#getJobs()
	 * @see #getJobQueue()
	 * @generated
	 */
	EReference getJobQueue_Jobs();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Actuator <em>Actuator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actuator</em>'.
	 * @see org.nasdanika.cdo.flow.Actuator
	 * @generated
	 */
	EClass getActuator();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.ActuatorReference <em>Actuator Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actuator Reference</em>'.
	 * @see org.nasdanika.cdo.flow.ActuatorReference
	 * @generated
	 */
	EClass getActuatorReference();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Promise#getFulfillmentValue(org.nasdanika.core.Context) <em>Get Fulfillment Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Fulfillment Value</em>' operation.
	 * @see org.nasdanika.cdo.flow.Promise#getFulfillmentValue(org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getPromise__GetFulfillmentValue__Context();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Promise#getRejectionReason(org.nasdanika.core.Context) <em>Get Rejection Reason</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Rejection Reason</em>' operation.
	 * @see org.nasdanika.cdo.flow.Promise#getRejectionReason(org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getPromise__GetRejectionReason__Context();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Promise#getState() <em>Get State</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get State</em>' operation.
	 * @see org.nasdanika.cdo.flow.Promise#getState()
	 * @generated
	 */
	EOperation getPromise__GetState();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Promise#cancel() <em>Cancel</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Cancel</em>' operation.
	 * @see org.nasdanika.cdo.flow.Promise#cancel()
	 * @generated
	 */
	EOperation getPromise__Cancel();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.PromiseReference <em>Promise Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Promise Reference</em>'.
	 * @see org.nasdanika.cdo.flow.PromiseReference
	 * @generated
	 */
	EClass getPromiseReference();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.All <em>All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>All</em>'.
	 * @see org.nasdanika.cdo.flow.All
	 * @generated
	 */
	EClass getAll();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.All#init(org.eclipse.emf.common.util.EList, org.nasdanika.cdo.flow.Executor) <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see org.nasdanika.cdo.flow.All#init(org.eclipse.emf.common.util.EList, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getAll__Init__EList_Executor();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Any <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any</em>'.
	 * @see org.nasdanika.cdo.flow.Any
	 * @generated
	 */
	EClass getAny();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Any#init(org.eclipse.emf.common.util.EList, org.nasdanika.cdo.flow.Executor) <em>Init</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Init</em>' operation.
	 * @see org.nasdanika.cdo.flow.Any#init(org.eclipse.emf.common.util.EList, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getAny__Init__EList_Executor();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Command <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Command</em>'.
	 * @see org.nasdanika.cdo.flow.Command
	 * @generated
	 */
	EClass getCommand();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Command#execute(org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor) <em>Execute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Execute</em>' operation.
	 * @see org.nasdanika.cdo.flow.Command#execute(org.nasdanika.core.Context, org.nasdanika.cdo.flow.Executor)
	 * @generated
	 */
	EOperation getCommand__Execute__Context_Executor();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Executor <em>Executor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Executor</em>'.
	 * @see org.nasdanika.cdo.flow.Executor
	 * @model instanceClass="org.nasdanika.cdo.flow.Executor" typeParameters="C" CBounds="org.nasdanika.cdo.flow.Context"
	 * @generated
	 */
	EClass getExecutor();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Invocable <em>Invocable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocable</em>'.
	 * @see org.nasdanika.cdo.flow.Invocable
	 * @generated
	 */
	EClass getInvocable();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Invocable#invoke(org.nasdanika.core.Context, org.eclipse.emf.common.util.EList) <em>Invoke</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Invoke</em>' operation.
	 * @see org.nasdanika.cdo.flow.Invocable#invoke(org.nasdanika.core.Context, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getInvocable__Invoke__Context_EList();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Invocable#accept(org.nasdanika.core.Context, org.eclipse.emf.common.util.EList) <em>Accept</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Accept</em>' operation.
	 * @see org.nasdanika.cdo.flow.Invocable#accept(org.nasdanika.core.Context, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getInvocable__Accept__Context_EList();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.InvocableThen <em>Invocable Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocable Then</em>'.
	 * @see org.nasdanika.cdo.flow.InvocableThen
	 * @generated
	 */
	EClass getInvocableThen();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.InvocableThen#getOnFulfilled <em>On Fulfilled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Fulfilled</em>'.
	 * @see org.nasdanika.cdo.flow.InvocableThen#getOnFulfilled()
	 * @see #getInvocableThen()
	 * @generated
	 */
	EReference getInvocableThen_OnFulfilled();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.InvocableThen#getOnRejected <em>On Rejected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>On Rejected</em>'.
	 * @see org.nasdanika.cdo.flow.InvocableThen#getOnRejected()
	 * @see #getInvocableThen()
	 * @generated
	 */
	EReference getInvocableThen_OnRejected();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.InvocableReference <em>Invocable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocable Reference</em>'.
	 * @see org.nasdanika.cdo.flow.InvocableReference
	 * @generated
	 */
	EClass getInvocableReference();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.BoundInvocable <em>Bound Invocable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bound Invocable</em>'.
	 * @see org.nasdanika.cdo.flow.BoundInvocable
	 * @generated
	 */
	EClass getBoundInvocable();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.BoundInvocable#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.nasdanika.cdo.flow.BoundInvocable#getBindings()
	 * @see #getBoundInvocable()
	 * @generated
	 */
	EReference getBoundInvocable_Bindings();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.BoundInvocable#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.flow.BoundInvocable#getTarget()
	 * @see #getBoundInvocable()
	 * @generated
	 */
	EReference getBoundInvocable_Target();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.BoundInvocable#bind(org.nasdanika.core.Context, org.eclipse.emf.common.util.EList) <em>Bind</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Bind</em>' operation.
	 * @see org.nasdanika.cdo.flow.BoundInvocable#bind(org.nasdanika.core.Context, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getBoundInvocable__Bind__Context_EList();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.nasdanika.cdo.flow.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.flow.Action#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Outputs</em>'.
	 * @see org.nasdanika.cdo.flow.Action#getOutputs()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Outputs();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.flow.Action#getErrorHandlers <em>Error Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Error Handlers</em>'.
	 * @see org.nasdanika.cdo.flow.Action#getErrorHandlers()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_ErrorHandlers();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.JavaActionDelegate <em>Java Action Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Action Delegate</em>'.
	 * @see org.nasdanika.cdo.flow.JavaActionDelegate
	 * @model instanceClass="org.nasdanika.cdo.flow.JavaActionDelegate" typeParameters="R C" CBounds="org.nasdanika.cdo.flow.Context"
	 * @generated
	 */
	EClass getJavaActionDelegate();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Property Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.eclipse.emf.ecore.EObject" valueContainment="true"
	 * @generated
	 */
	EClass getPropertyEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyEntry()
	 * @generated
	 */
	EAttribute getPropertyEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getPropertyEntry()
	 * @generated
	 */
	EReference getPropertyEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.JavaAction <em>Java Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Action</em>'.
	 * @see org.nasdanika.cdo.flow.JavaAction
	 * @generated
	 */
	EClass getJavaAction();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.JavaAction#getDelegate <em>Delegate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delegate</em>'.
	 * @see org.nasdanika.cdo.flow.JavaAction#getDelegate()
	 * @see #getJavaAction()
	 * @generated
	 */
	EAttribute getJavaAction_Delegate();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.flow.JavaAction#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.nasdanika.cdo.flow.JavaAction#getProperties()
	 * @see #getJavaAction()
	 * @generated
	 */
	EReference getJavaAction_Properties();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Action Output Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Output Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.nasdanika.cdo.flow.Actuator<?>" valueContainment="true"
	 * @generated
	 */
	EClass getActionOutputEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionOutputEntry()
	 * @generated
	 */
	EAttribute getActionOutputEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionOutputEntry()
	 * @generated
	 */
	EReference getActionOutputEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Error Handler Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Handler Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.nasdanika.cdo.flow.Invocable<?, ?>" valueContainment="true"
	 * @generated
	 */
	EClass getErrorHandlerEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getErrorHandlerEntry()
	 * @generated
	 */
	EAttribute getErrorHandlerEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getErrorHandlerEntry()
	 * @generated
	 */
	EReference getErrorHandlerEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Dispatch <em>Dispatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch</em>'.
	 * @see org.nasdanika.cdo.flow.Dispatch
	 * @generated
	 */
	EClass getDispatch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.Dispatch#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see org.nasdanika.cdo.flow.Dispatch#getTargets()
	 * @see #getDispatch()
	 * @generated
	 */
	EReference getDispatch_Targets();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Publish <em>Publish</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publish</em>'.
	 * @see org.nasdanika.cdo.flow.Publish
	 * @generated
	 */
	EClass getPublish();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.Publish#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Targets</em>'.
	 * @see org.nasdanika.cdo.flow.Publish#getTargets()
	 * @see #getPublish()
	 * @generated
	 */
	EReference getPublish_Targets();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.core.Adaptable <em>Adaptable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Adaptable</em>'.
	 * @see org.nasdanika.core.Adaptable
	 * @model instanceClass="org.nasdanika.core.Adaptable"
	 * @generated
	 */
	EClass getAdaptable();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Flow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow</em>'.
	 * @see org.nasdanika.cdo.flow.Flow
	 * @generated
	 */
	EClass getFlow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.Flow#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contents</em>'.
	 * @see org.nasdanika.cdo.flow.Flow#getContents()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Contents();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.flow.Flow#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Inputs</em>'.
	 * @see org.nasdanika.cdo.flow.Flow#getInputs()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Inputs();

	/**
	 * Returns the meta object for the map '{@link org.nasdanika.cdo.flow.Flow#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Outputs</em>'.
	 * @see org.nasdanika.cdo.flow.Flow#getOutputs()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_Outputs();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.Flow#getErrorHandler <em>Error Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Error Handler</em>'.
	 * @see org.nasdanika.cdo.flow.Flow#getErrorHandler()
	 * @see #getFlow()
	 * @generated
	 */
	EReference getFlow_ErrorHandler();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Flow#adapt(java.lang.Class, org.nasdanika.core.Context) <em>Adapt</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Adapt</em>' operation.
	 * @see org.nasdanika.cdo.flow.Flow#adapt(java.lang.Class, org.nasdanika.core.Context)
	 * @generated
	 */
	EOperation getFlow__Adapt__Class_Context();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Input Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.nasdanika.cdo.flow.Actuator<?>" valueContainment="true"
	 * @generated
	 */
	EClass getFlowInputEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getFlowInputEntry()
	 * @generated
	 */
	EAttribute getFlowInputEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getFlowInputEntry()
	 * @generated
	 */
	EReference getFlowInputEntry_Value();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Output Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.nasdanika.cdo.flow.ActuatorReference<?, ?>" valueContainment="true"
	 * @generated
	 */
	EClass getFlowOutputEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getFlowOutputEntry()
	 * @generated
	 */
	EAttribute getFlowOutputEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getFlowOutputEntry()
	 * @generated
	 */
	EReference getFlowOutputEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.JoinElement <em>Join Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join Element</em>'.
	 * @see org.nasdanika.cdo.flow.JoinElement
	 * @generated
	 */
	EClass getJoinElement();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.JoinElement#isConsumed <em>Consumed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Consumed</em>'.
	 * @see org.nasdanika.cdo.flow.JoinElement#isConsumed()
	 * @see #getJoinElement()
	 * @generated
	 */
	EAttribute getJoinElement_Consumed();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.JoinElement#getCollector <em>Collector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Collector</em>'.
	 * @see org.nasdanika.cdo.flow.JoinElement#getCollector()
	 * @see #getJoinElement()
	 * @generated
	 */
	EReference getJoinElement_Collector();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.JoinInput <em>Join Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join Input</em>'.
	 * @see org.nasdanika.cdo.flow.JoinInput
	 * @generated
	 */
	EClass getJoinInput();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.JoinInput#isOuter <em>Outer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Outer</em>'.
	 * @see org.nasdanika.cdo.flow.JoinInput#isOuter()
	 * @see #getJoinInput()
	 * @generated
	 */
	EAttribute getJoinInput_Outer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.JoinInput#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.nasdanika.cdo.flow.JoinInput#getElements()
	 * @see #getJoinInput()
	 * @generated
	 */
	EReference getJoinInput_Elements();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Join Input Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join Input Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.nasdanika.cdo.flow.JoinInput<?, C>" CBounds="org.nasdanika.cdo.flow.Context"
	 * @generated
	 */
	EClass getJoinInputEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getJoinInputEntry()
	 * @generated
	 */
	EAttribute getJoinInputEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getJoinInputEntry()
	 * @generated
	 */
	EReference getJoinInputEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see org.nasdanika.cdo.flow.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.flow.Join#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inputs</em>'.
	 * @see org.nasdanika.cdo.flow.Join#getInputs()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_Inputs();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.Join#getJoiner <em>Joiner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Joiner</em>'.
	 * @see org.nasdanika.cdo.flow.Join#getJoiner()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_Joiner();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Join#finishJoin() <em>Finish Join</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Finish Join</em>' operation.
	 * @see org.nasdanika.cdo.flow.Join#finishJoin()
	 * @generated
	 */
	EOperation getJoin__FinishJoin();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.ValueProperty <em>Value Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Property</em>'.
	 * @see org.nasdanika.cdo.flow.ValueProperty
	 * @generated
	 */
	EClass getValueProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.ValueProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.nasdanika.cdo.flow.ValueProperty#getValue()
	 * @see #getValueProperty()
	 * @generated
	 */
	EReference getValueProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.core.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.nasdanika.core.Component
	 * @model instanceClass="org.nasdanika.core.Component"
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.ServiceReference <em>Service Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Reference</em>'.
	 * @see org.nasdanika.cdo.flow.ServiceReference
	 * @generated
	 */
	EClass getServiceReference();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.ServiceReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.cdo.flow.ServiceReference#getType()
	 * @see #getServiceReference()
	 * @generated
	 */
	EAttribute getServiceReference_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.ServiceReference#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.nasdanika.cdo.flow.ServiceReference#getFilter()
	 * @see #getServiceReference()
	 * @generated
	 */
	EAttribute getServiceReference_Filter();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.DeferredInvocation <em>Deferred Invocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deferred Invocation</em>'.
	 * @see org.nasdanika.cdo.flow.DeferredInvocation
	 * @generated
	 */
	EClass getDeferredInvocation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.flow.DeferredInvocation#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.nasdanika.cdo.flow.DeferredInvocation#getArguments()
	 * @see #getDeferredInvocation()
	 * @generated
	 */
	EReference getDeferredInvocation_Arguments();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.DeferredInvocation#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see org.nasdanika.cdo.flow.DeferredInvocation#getResult()
	 * @see #getDeferredInvocation()
	 * @generated
	 */
	EReference getDeferredInvocation_Result();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.nasdanika.cdo.flow.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Property#get() <em>Get</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get</em>' operation.
	 * @see org.nasdanika.cdo.flow.Property#get()
	 * @generated
	 */
	EOperation getProperty__Get();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.flow.Property#set(java.lang.Object) <em>Set</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set</em>' operation.
	 * @see org.nasdanika.cdo.flow.Property#set(java.lang.Object)
	 * @generated
	 */
	EOperation getProperty__Set__Object();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.PropertyReference <em>Property Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Reference</em>'.
	 * @see org.nasdanika.cdo.flow.PropertyReference
	 * @generated
	 */
	EClass getPropertyReference();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.DeferringInvocable <em>Deferring Invocable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deferring Invocable</em>'.
	 * @see org.nasdanika.cdo.flow.DeferringInvocable
	 * @generated
	 */
	EClass getDeferringInvocable();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.flow.DeferringInvocable#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.flow.DeferringInvocable#getTarget()
	 * @see #getDeferringInvocable()
	 * @generated
	 */
	EReference getDeferringInvocable_Target();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.flow.DeferringInvocable#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invocations</em>'.
	 * @see org.nasdanika.cdo.flow.DeferringInvocable#getInvocations()
	 * @see #getDeferringInvocable()
	 * @generated
	 */
	EReference getDeferringInvocable_Invocations();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.flow.DeferringInvocable#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.nasdanika.cdo.flow.DeferringInvocable#getDelay()
	 * @see #getDeferringInvocable()
	 * @generated
	 */
	EAttribute getDeferringInvocable_Delay();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.cdo.flow.PromiseState <em>Promise State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Promise State</em>'.
	 * @see org.nasdanika.cdo.flow.PromiseState
	 * @generated
	 */
	EEnum getPromiseState();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.cdo.flow.JobStatus <em>Job Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Job Status</em>'.
	 * @see org.nasdanika.cdo.flow.JobStatus
	 * @generated
	 */
	EEnum getJobStatus();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.cdo.flow.ActionState <em>Action State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Action State</em>'.
	 * @see org.nasdanika.cdo.flow.ActionState
	 * @generated
	 */
	EEnum getActionState();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.core.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Context</em>'.
	 * @see org.nasdanika.core.Context
	 * @model instanceClass="org.nasdanika.core.Context" serializeable="false"
	 * @generated
	 */
	EDataType getContext();

	/**
	 * Returns the meta object for data type '{@link java.lang.Exception <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Exception</em>'.
	 * @see java.lang.Exception
	 * @model instanceClass="java.lang.Exception"
	 * @generated
	 */
	EDataType getException();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.CDOTransactionContext <em>CDO Transaction Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CDO Transaction Context</em>'.
	 * @see org.nasdanika.cdo.CDOTransactionContext
	 * @model instanceClass="org.nasdanika.cdo.CDOTransactionContext"
	 * @generated
	 */
	EDataType getCDOTransactionContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FlowFactory getFlowFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Reference <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Reference
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__TARGET = eINSTANCE.getReference_Target();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Then <em>Then</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Then
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getThen()
		 * @generated
		 */
		EClass THEN = eINSTANCE.getThen();

		/**
		 * The meta object literal for the '<em><b>On Fulfilled</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THEN___ON_FULFILLED__OBJECT_CONTEXT = eINSTANCE.getThen__OnFulfilled__Object_Context();

		/**
		 * The meta object literal for the '<em><b>On Rejected</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation THEN___ON_REJECTED__EXCEPTION_CONTEXT = eINSTANCE.getThen__OnRejected__Exception_Context();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ThenReferenceImpl <em>Then Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ThenReferenceImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getThenReference()
		 * @generated
		 */
		EClass THEN_REFERENCE = eINSTANCE.getThenReference();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Promise <em>Promise</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Promise
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromise()
		 * @generated
		 */
		EClass PROMISE = eINSTANCE.getPromise();

		/**
		 * The meta object literal for the '<em><b>Done</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROMISE__DONE = eINSTANCE.getPromise_Done();

		/**
		 * The meta object literal for the '<em><b>Expires</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROMISE__EXPIRES = eINSTANCE.getPromise_Expires();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___THEN__THEN_CONTEXT_EXECUTOR = eINSTANCE.getPromise__Then__Then_Context_Executor();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.DeferredImpl <em>Deferred</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.DeferredImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferred()
		 * @generated
		 */
		EClass DEFERRED = eINSTANCE.getDeferred();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFERRED__STATE = eINSTANCE.getDeferred_State();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFERRED__CREATED = eINSTANCE.getDeferred_Created();

		/**
		 * The meta object literal for the '<em><b>Resolved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFERRED__RESOLVED = eINSTANCE.getDeferred_Resolved();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFERRED__COMMENT = eINSTANCE.getDeferred_Comment();

		/**
		 * The meta object literal for the '<em><b>Resolution</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRED__RESOLUTION = eINSTANCE.getDeferred_Resolution();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRED__THEN = eINSTANCE.getDeferred_Then();

		/**
		 * The meta object literal for the '<em><b>Then Deferreds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRED__THEN_DEFERREDS = eINSTANCE.getDeferred_ThenDeferreds();

		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEFERRED___RESOLVE__OBJECT_CONTEXT_EXECUTOR = eINSTANCE.getDeferred__Resolve__Object_Context_Executor();

		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEFERRED___RESOLVE__PROMISE_CONTEXT_EXECUTOR = eINSTANCE.getDeferred__Resolve__Promise_Context_Executor();

		/**
		 * The meta object literal for the '<em><b>Reject</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DEFERRED___REJECT__EXCEPTION_CONTEXT_EXECUTOR = eINSTANCE.getDeferred__Reject__Exception_Context_Executor();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JobImpl <em>Job</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JobImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJob()
		 * @generated
		 */
		EClass JOB = eINSTANCE.getJob();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOB__COMMAND = eINSTANCE.getJob_Command();

		/**
		 * The meta object literal for the '<em><b>Deferred</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOB__DEFERRED = eINSTANCE.getJob_Deferred();

		/**
		 * The meta object literal for the '<em><b>Created</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__CREATED = eINSTANCE.getJob_Created();

		/**
		 * The meta object literal for the '<em><b>Started</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__STARTED = eINSTANCE.getJob_Started();

		/**
		 * The meta object literal for the '<em><b>Completed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__COMPLETED = eINSTANCE.getJob_Completed();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__STATUS = eINSTANCE.getJob_Status();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__WHEN = eINSTANCE.getJob_When();

		/**
		 * The meta object literal for the '<em><b>Failure Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOB__FAILURE_REASON = eINSTANCE.getJob_FailureReason();

		/**
		 * The meta object literal for the '<em><b>Can Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOB___CAN_EXECUTE = eINSTANCE.getJob__CanExecute();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.JobQueue <em>Job Queue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.JobQueue
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJobQueue()
		 * @generated
		 */
		EClass JOB_QUEUE = eINSTANCE.getJobQueue();

		/**
		 * The meta object literal for the '<em><b>Jobs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOB_QUEUE__JOBS = eINSTANCE.getJobQueue_Jobs();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Actuator <em>Actuator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Actuator
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActuator()
		 * @generated
		 */
		EClass ACTUATOR = eINSTANCE.getActuator();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.ActuatorReference <em>Actuator Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.ActuatorReference
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActuatorReference()
		 * @generated
		 */
		EClass ACTUATOR_REFERENCE = eINSTANCE.getActuatorReference();

		/**
		 * The meta object literal for the '<em><b>Get Fulfillment Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___GET_FULFILLMENT_VALUE__CONTEXT = eINSTANCE.getPromise__GetFulfillmentValue__Context();

		/**
		 * The meta object literal for the '<em><b>Get Rejection Reason</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___GET_REJECTION_REASON__CONTEXT = eINSTANCE.getPromise__GetRejectionReason__Context();

		/**
		 * The meta object literal for the '<em><b>Get State</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___GET_STATE = eINSTANCE.getPromise__GetState();

		/**
		 * The meta object literal for the '<em><b>Cancel</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___CANCEL = eINSTANCE.getPromise__Cancel();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.PromiseReferenceImpl <em>Promise Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.PromiseReferenceImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromiseReference()
		 * @generated
		 */
		EClass PROMISE_REFERENCE = eINSTANCE.getPromiseReference();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.AllImpl <em>All</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.AllImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAll()
		 * @generated
		 */
		EClass ALL = eINSTANCE.getAll();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ALL___INIT__ELIST_EXECUTOR = eINSTANCE.getAll__Init__EList_Executor();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.AnyImpl <em>Any</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.AnyImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAny()
		 * @generated
		 */
		EClass ANY = eINSTANCE.getAny();

		/**
		 * The meta object literal for the '<em><b>Init</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ANY___INIT__ELIST_EXECUTOR = eINSTANCE.getAny__Init__EList_Executor();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Command <em>Command</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Command
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getCommand()
		 * @generated
		 */
		EClass COMMAND = eINSTANCE.getCommand();

		/**
		 * The meta object literal for the '<em><b>Execute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMMAND___EXECUTE__CONTEXT_EXECUTOR = eINSTANCE.getCommand__Execute__Context_Executor();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Executor <em>Executor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Executor
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getExecutor()
		 * @generated
		 */
		EClass EXECUTOR = eINSTANCE.getExecutor();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Invocable <em>Invocable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Invocable
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocable()
		 * @generated
		 */
		EClass INVOCABLE = eINSTANCE.getInvocable();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INVOCABLE___INVOKE__CONTEXT_ELIST = eINSTANCE.getInvocable__Invoke__Context_EList();

		/**
		 * The meta object literal for the '<em><b>Accept</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation INVOCABLE___ACCEPT__CONTEXT_ELIST = eINSTANCE.getInvocable__Accept__Context_EList();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.InvocableThenImpl <em>Invocable Then</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.InvocableThenImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocableThen()
		 * @generated
		 */
		EClass INVOCABLE_THEN = eINSTANCE.getInvocableThen();

		/**
		 * The meta object literal for the '<em><b>On Fulfilled</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCABLE_THEN__ON_FULFILLED = eINSTANCE.getInvocableThen_OnFulfilled();

		/**
		 * The meta object literal for the '<em><b>On Rejected</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCABLE_THEN__ON_REJECTED = eINSTANCE.getInvocableThen_OnRejected();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.InvocableReferenceImpl <em>Invocable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.InvocableReferenceImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocableReference()
		 * @generated
		 */
		EClass INVOCABLE_REFERENCE = eINSTANCE.getInvocableReference();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.BoundInvocableImpl <em>Bound Invocable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.BoundInvocableImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getBoundInvocable()
		 * @generated
		 */
		EClass BOUND_INVOCABLE = eINSTANCE.getBoundInvocable();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_INVOCABLE__BINDINGS = eINSTANCE.getBoundInvocable_Bindings();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUND_INVOCABLE__TARGET = eINSTANCE.getBoundInvocable_Target();

		/**
		 * The meta object literal for the '<em><b>Bind</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOUND_INVOCABLE___BIND__CONTEXT_ELIST = eINSTANCE.getBoundInvocable__Bind__Context_EList();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Action <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Action
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__OUTPUTS = eINSTANCE.getAction_Outputs();

		/**
		 * The meta object literal for the '<em><b>Error Handlers</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__ERROR_HANDLERS = eINSTANCE.getAction_ErrorHandlers();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.JavaActionDelegate <em>Java Action Delegate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.JavaActionDelegate
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJavaActionDelegate()
		 * @generated
		 */
		EClass JAVA_ACTION_DELEGATE = eINSTANCE.getJavaActionDelegate();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.PropertyEntryImpl <em>Property Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.PropertyEntryImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPropertyEntry()
		 * @generated
		 */
		EClass PROPERTY_ENTRY = eINSTANCE.getPropertyEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_ENTRY__KEY = eINSTANCE.getPropertyEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ENTRY__VALUE = eINSTANCE.getPropertyEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JavaActionImpl <em>Java Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JavaActionImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJavaAction()
		 * @generated
		 */
		EClass JAVA_ACTION = eINSTANCE.getJavaAction();

		/**
		 * The meta object literal for the '<em><b>Delegate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_ACTION__DELEGATE = eINSTANCE.getJavaAction_Delegate();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_ACTION__PROPERTIES = eINSTANCE.getJavaAction_Properties();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ActionOutputEntryImpl <em>Action Output Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ActionOutputEntryImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionOutputEntry()
		 * @generated
		 */
		EClass ACTION_OUTPUT_ENTRY = eINSTANCE.getActionOutputEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_OUTPUT_ENTRY__KEY = eINSTANCE.getActionOutputEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_OUTPUT_ENTRY__VALUE = eINSTANCE.getActionOutputEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ErrorHandlerEntryImpl <em>Error Handler Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ErrorHandlerEntryImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getErrorHandlerEntry()
		 * @generated
		 */
		EClass ERROR_HANDLER_ENTRY = eINSTANCE.getErrorHandlerEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ERROR_HANDLER_ENTRY__KEY = eINSTANCE.getErrorHandlerEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ERROR_HANDLER_ENTRY__VALUE = eINSTANCE.getErrorHandlerEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.DispatchImpl <em>Dispatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.DispatchImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDispatch()
		 * @generated
		 */
		EClass DISPATCH = eINSTANCE.getDispatch();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH__TARGETS = eINSTANCE.getDispatch_Targets();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.PublishImpl <em>Publish</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.PublishImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPublish()
		 * @generated
		 */
		EClass PUBLISH = eINSTANCE.getPublish();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PUBLISH__TARGETS = eINSTANCE.getPublish_Targets();

		/**
		 * The meta object literal for the '{@link org.nasdanika.core.Adaptable <em>Adaptable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.Adaptable
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAdaptable()
		 * @generated
		 */
		EClass ADAPTABLE = eINSTANCE.getAdaptable();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.FlowImpl <em>Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.FlowImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getFlow()
		 * @generated
		 */
		EClass FLOW = eINSTANCE.getFlow();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__CONTENTS = eINSTANCE.getFlow_Contents();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__INPUTS = eINSTANCE.getFlow_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__OUTPUTS = eINSTANCE.getFlow_Outputs();

		/**
		 * The meta object literal for the '<em><b>Error Handler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW__ERROR_HANDLER = eINSTANCE.getFlow_ErrorHandler();

		/**
		 * The meta object literal for the '<em><b>Adapt</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FLOW___ADAPT__CLASS_CONTEXT = eINSTANCE.getFlow__Adapt__Class_Context();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.FlowInputEntryImpl <em>Input Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.FlowInputEntryImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getFlowInputEntry()
		 * @generated
		 */
		EClass FLOW_INPUT_ENTRY = eINSTANCE.getFlowInputEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_INPUT_ENTRY__KEY = eINSTANCE.getFlowInputEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_INPUT_ENTRY__VALUE = eINSTANCE.getFlowInputEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.FlowOutputEntryImpl <em>Output Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.FlowOutputEntryImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getFlowOutputEntry()
		 * @generated
		 */
		EClass FLOW_OUTPUT_ENTRY = eINSTANCE.getFlowOutputEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_OUTPUT_ENTRY__KEY = eINSTANCE.getFlowOutputEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_OUTPUT_ENTRY__VALUE = eINSTANCE.getFlowOutputEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JoinElementImpl <em>Join Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JoinElementImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoinElement()
		 * @generated
		 */
		EClass JOIN_ELEMENT = eINSTANCE.getJoinElement();

		/**
		 * The meta object literal for the '<em><b>Consumed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_ELEMENT__CONSUMED = eINSTANCE.getJoinElement_Consumed();

		/**
		 * The meta object literal for the '<em><b>Collector</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN_ELEMENT__COLLECTOR = eINSTANCE.getJoinElement_Collector();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JoinInputImpl <em>Join Input</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JoinInputImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoinInput()
		 * @generated
		 */
		EClass JOIN_INPUT = eINSTANCE.getJoinInput();

		/**
		 * The meta object literal for the '<em><b>Outer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_INPUT__OUTER = eINSTANCE.getJoinInput_Outer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN_INPUT__ELEMENTS = eINSTANCE.getJoinInput_Elements();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JoinInputEntryImpl <em>Join Input Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JoinInputEntryImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoinInputEntry()
		 * @generated
		 */
		EClass JOIN_INPUT_ENTRY = eINSTANCE.getJoinInputEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOIN_INPUT_ENTRY__KEY = eINSTANCE.getJoinInputEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN_INPUT_ENTRY__VALUE = eINSTANCE.getJoinInputEntry_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JoinImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__INPUTS = eINSTANCE.getJoin_Inputs();

		/**
		 * The meta object literal for the '<em><b>Joiner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__JOINER = eINSTANCE.getJoin_Joiner();

		/**
		 * The meta object literal for the '<em><b>Finish Join</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation JOIN___FINISH_JOIN = eINSTANCE.getJoin__FinishJoin();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ValuePropertyImpl <em>Value Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ValuePropertyImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getValueProperty()
		 * @generated
		 */
		EClass VALUE_PROPERTY = eINSTANCE.getValueProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_PROPERTY__VALUE = eINSTANCE.getValueProperty_Value();

		/**
		 * The meta object literal for the '{@link org.nasdanika.core.Component <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.Component
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ServiceReferenceImpl <em>Service Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ServiceReferenceImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getServiceReference()
		 * @generated
		 */
		EClass SERVICE_REFERENCE = eINSTANCE.getServiceReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_REFERENCE__TYPE = eINSTANCE.getServiceReference_Type();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_REFERENCE__FILTER = eINSTANCE.getServiceReference_Filter();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.DeferredInvocationImpl <em>Deferred Invocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.DeferredInvocationImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferredInvocation()
		 * @generated
		 */
		EClass DEFERRED_INVOCATION = eINSTANCE.getDeferredInvocation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRED_INVOCATION__ARGUMENTS = eINSTANCE.getDeferredInvocation_Arguments();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRED_INVOCATION__RESULT = eINSTANCE.getDeferredInvocation_Result();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.Property <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.Property
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Get</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___GET = eINSTANCE.getProperty__Get();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY___SET__OBJECT = eINSTANCE.getProperty__Set__Object();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.PropertyReferenceImpl <em>Property Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.PropertyReferenceImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPropertyReference()
		 * @generated
		 */
		EClass PROPERTY_REFERENCE = eINSTANCE.getPropertyReference();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.DeferringInvocableImpl <em>Deferring Invocable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.DeferringInvocableImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferringInvocable()
		 * @generated
		 */
		EClass DEFERRING_INVOCABLE = eINSTANCE.getDeferringInvocable();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRING_INVOCABLE__TARGET = eINSTANCE.getDeferringInvocable_Target();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFERRING_INVOCABLE__INVOCATIONS = eINSTANCE.getDeferringInvocable_Invocations();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFERRING_INVOCABLE__DELAY = eINSTANCE.getDeferringInvocable_Delay();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.PromiseState <em>Promise State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.PromiseState
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromiseState()
		 * @generated
		 */
		EEnum PROMISE_STATE = eINSTANCE.getPromiseState();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.JobStatus <em>Job Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.JobStatus
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJobStatus()
		 * @generated
		 */
		EEnum JOB_STATUS = eINSTANCE.getJobStatus();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.ActionState <em>Action State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.ActionState
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionState()
		 * @generated
		 */
		EEnum ACTION_STATE = eINSTANCE.getActionState();

		/**
		 * The meta object literal for the '<em>Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.core.Context
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getContext()
		 * @generated
		 */
		EDataType CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em>Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Exception
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getException()
		 * @generated
		 */
		EDataType EXCEPTION = eINSTANCE.getException();

		/**
		 * The meta object literal for the '<em>CDO Transaction Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.CDOTransactionContext
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getCDOTransactionContext()
		 * @generated
		 */
		EDataType CDO_TRANSACTION_CONTEXT = eINSTANCE.getCDOTransactionContext();

	}

} //FlowPackage
