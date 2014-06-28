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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Then <em>Then</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Then
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getThen()
	 * @generated
	 */
	int THEN = 0;

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
	int THEN_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE__TARGET = THEN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Then Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE_FEATURE_COUNT = THEN_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>On Fulfilled</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE___ON_FULFILLED__OBJECT_CONTEXT = THEN___ON_FULFILLED__OBJECT_CONTEXT;

	/**
	 * The operation id for the '<em>On Rejected</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE___ON_REJECTED__EXCEPTION_CONTEXT = THEN___ON_REJECTED__EXCEPTION_CONTEXT;

	/**
	 * The number of operations of the '<em>Then Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THEN_REFERENCE_OPERATION_COUNT = THEN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Command <em>Command</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Command
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getCommand()
	 * @generated
	 */
	int COMMAND = 4;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Promise <em>Promise</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Promise
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromise()
	 * @generated
	 */
	int PROMISE = 3;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DeferredImpl <em>Deferred</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DeferredImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferred()
	 * @generated
	 */
	int DEFERRED = 5;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JobImpl <em>Job</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JobImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJob()
	 * @generated
	 */
	int JOB = 6;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.JobQueueImpl <em>Job Queue</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.JobQueueImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJobQueue()
	 * @generated
	 */
	int JOB_QUEUE = 7;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Executor <em>Executor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Executor
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getExecutor()
	 * @generated
	 */
	int EXECUTOR = 2;

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
	 * The number of structural features of the '<em>Promise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_FEATURE_COUNT = 1;

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
	 * The number of operations of the '<em>Promise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_OPERATION_COUNT = 4;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.Invocable <em>Invocable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.Invocable
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocable()
	 * @generated
	 */
	int INVOCABLE = 8;

	/**
	 * The number of structural features of the '<em>Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Invoke</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE___INVOKE__CONTEXT_ELIST = 0;

	/**
	 * The operation id for the '<em>Accept</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE___ACCEPT__CONTEXT_ELIST = 1;

	/**
	 * The number of operations of the '<em>Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOCABLE_OPERATION_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.InvocableReferenceImpl <em>Invocable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.InvocableReferenceImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocableReference()
	 * @generated
	 */
	int INVOCABLE_REFERENCE = 9;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ActionImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 10;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__OUTPUTS = INVOCABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.ActionOutputImpl <em>Action Output</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.ActionOutputImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionOutput()
	 * @generated
	 */
	int ACTION_OUTPUT = 11;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Action Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Action Output</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OUTPUT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DispatchImpl <em>Dispatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DispatchImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDispatch()
	 * @generated
	 */
	int DISPATCH = 12;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.PublishImpl <em>Publish</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.PublishImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPublish()
	 * @generated
	 */
	int PUBLISH = 13;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DeferredInvocationImpl <em>Deferred Invocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DeferredInvocationImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferredInvocation()
	 * @generated
	 */
	int DEFERRED_INVOCATION = 14;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.impl.DeferringInvocableImpl <em>Deferring Invocable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.impl.DeferringInvocableImpl
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getDeferringInvocable()
	 * @generated
	 */
	int DEFERRING_INVOCABLE = 15;

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
	 * The number of structural features of the '<em>Deferring Invocable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFERRING_INVOCABLE_FEATURE_COUNT = INVOCABLE_FEATURE_COUNT + 2;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.PromiseState <em>Promise State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.PromiseState
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getPromiseState()
	 * @generated
	 */
	int PROMISE_STATE = 16;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.JobStatus <em>Job Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.JobStatus
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getJobStatus()
	 * @generated
	 */
	int JOB_STATUS = 17;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.flow.ActionState <em>Action State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.flow.ActionState
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionState()
	 * @generated
	 */
	int ACTION_STATE = 18;

	/**
	 * The meta object id for the '<em>Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.core.Context
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 19;


	/**
	 * The meta object id for the '<em>Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Exception
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getException()
	 * @generated
	 */
	int EXCEPTION = 20;


	/**
	 * The meta object id for the '<em>CDO Transaction Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.CDOTransactionContext
	 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getCDOTransactionContext()
	 * @generated
	 */
	int CDO_TRANSACTION_CONTEXT = 21;


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
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.flow.ThenReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.flow.ThenReference#getTarget()
	 * @see #getThenReference()
	 * @generated
	 */
	EReference getThenReference_Target();

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
	 * Returns the meta object for class '{@link org.nasdanika.cdo.flow.InvocableReference <em>Invocable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocable Reference</em>'.
	 * @see org.nasdanika.cdo.flow.InvocableReference
	 * @generated
	 */
	EClass getInvocableReference();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.flow.InvocableReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.flow.InvocableReference#getTarget()
	 * @see #getInvocableReference()
	 * @generated
	 */
	EReference getInvocableReference_Target();

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
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>Action Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action Output</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueType="org.nasdanika.cdo.flow.Invocable" valueContainment="true"
	 * @generated
	 */
	EClass getActionOutput();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionOutput()
	 * @generated
	 */
	EAttribute getActionOutput_Key();

	/**
	 * Returns the meta object for the containment reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getActionOutput()
	 * @generated
	 */
	EReference getActionOutput_Value();

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
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THEN_REFERENCE__TARGET = eINSTANCE.getThenReference_Target();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.JobQueueImpl <em>Job Queue</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.JobQueueImpl
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
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.InvocableReferenceImpl <em>Invocable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.InvocableReferenceImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getInvocableReference()
		 * @generated
		 */
		EClass INVOCABLE_REFERENCE = eINSTANCE.getInvocableReference();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOCABLE_REFERENCE__TARGET = eINSTANCE.getInvocableReference_Target();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ActionImpl
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
		 * The meta object literal for the '{@link org.nasdanika.cdo.flow.impl.ActionOutputImpl <em>Action Output</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.flow.impl.ActionOutputImpl
		 * @see org.nasdanika.cdo.flow.impl.FlowPackageImpl#getActionOutput()
		 * @generated
		 */
		EClass ACTION_OUTPUT = eINSTANCE.getActionOutput();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_OUTPUT__KEY = eINSTANCE.getActionOutput_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION_OUTPUT__VALUE = eINSTANCE.getActionOutput_Value();

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
