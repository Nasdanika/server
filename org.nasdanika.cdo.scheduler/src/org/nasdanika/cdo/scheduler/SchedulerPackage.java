/**
 */
package org.nasdanika.cdo.scheduler;

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
 * @see org.nasdanika.cdo.scheduler.SchedulerFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.scheduler";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.scheduler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulerPackage eINSTANCE = org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.DiagnosticImpl <em>Diagnostic</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.DiagnosticImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getDiagnostic()
	 * @generated
	 */
	int DIAGNOSTIC = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__TIME = 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__STATUS = 1;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__CHILDREN = 3;

	/**
	 * The feature id for the '<em><b>Exception</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__EXCEPTION = 4;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC__DURATION = 5;

	/**
	 * The number of structural features of the '<em>Diagnostic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Diagnostic</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getSchedulerTask()
	 * @generated
	 */
	int SCHEDULER_TASK = 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.FixedRateSchedulerTaskImpl <em>Fixed Rate Scheduler Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.FixedRateSchedulerTaskImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getFixedRateSchedulerTask()
	 * @generated
	 */
	int FIXED_RATE_SCHEDULER_TASK = 4;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.FixedDelaySchedulerTaskImpl <em>Fixed Delay Scheduler Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.FixedDelaySchedulerTaskImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getFixedDelaySchedulerTask()
	 * @generated
	 */
	int FIXED_DELAY_SCHEDULER_TASK = 3;

	/**
	 * The meta object id for the '<em>Context</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.concurrent.SchedulerContext
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getSchedulerContext()
	 * @generated
	 */
	int SCHEDULER_CONTEXT = 8;

	/**
	 * The meta object id for the '<em>Time Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.concurrent.TimeUnit
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 9;

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.Diagnostic <em>Diagnostic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic
	 * @generated
	 */
	EClass getDiagnostic();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.Diagnostic#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic#getStatus()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_Status();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.Diagnostic#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic#getMessage()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.scheduler.Diagnostic#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic#getChildren()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EReference getDiagnostic_Children();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.scheduler.Diagnostic#getException <em>Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exception</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic#getException()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EReference getDiagnostic_Exception();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.Diagnostic#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic#getDuration()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.Diagnostic#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see org.nasdanika.cdo.scheduler.Diagnostic#getTime()
	 * @see #getDiagnostic()
	 * @generated
	 */
	EAttribute getDiagnostic_Time();

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__START = 0;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__SUBJECT = 1;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__HISTORY = 2;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__DONE = 3;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK___RUN__SCHEDULERCONTEXT = 0;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.RecurringSchedulerTaskImpl <em>Recurring Scheduler Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.RecurringSchedulerTaskImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getRecurringSchedulerTask()
	 * @generated
	 */
	int RECURRING_SCHEDULER_TASK = 2;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK__START = SCHEDULER_TASK__START;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK__SUBJECT = SCHEDULER_TASK__SUBJECT;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK__HISTORY = SCHEDULER_TASK__HISTORY;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK__DONE = SCHEDULER_TASK__DONE;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK__TIME_UNIT = SCHEDULER_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recurring Scheduler Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK_FEATURE_COUNT = SCHEDULER_TASK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK___RUN__SCHEDULERCONTEXT = SCHEDULER_TASK___RUN__SCHEDULERCONTEXT;

	/**
	 * The number of operations of the '<em>Recurring Scheduler Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURRING_SCHEDULER_TASK_OPERATION_COUNT = SCHEDULER_TASK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK__START = RECURRING_SCHEDULER_TASK__START;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK__SUBJECT = RECURRING_SCHEDULER_TASK__SUBJECT;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK__HISTORY = RECURRING_SCHEDULER_TASK__HISTORY;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK__DONE = RECURRING_SCHEDULER_TASK__DONE;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK__TIME_UNIT = RECURRING_SCHEDULER_TASK__TIME_UNIT;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK__DELAY = RECURRING_SCHEDULER_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed Delay Scheduler Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK_FEATURE_COUNT = RECURRING_SCHEDULER_TASK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK___RUN__SCHEDULERCONTEXT = RECURRING_SCHEDULER_TASK___RUN__SCHEDULERCONTEXT;

	/**
	 * The number of operations of the '<em>Fixed Delay Scheduler Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_DELAY_SCHEDULER_TASK_OPERATION_COUNT = RECURRING_SCHEDULER_TASK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK__START = RECURRING_SCHEDULER_TASK__START;

	/**
	 * The feature id for the '<em><b>Subject</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK__SUBJECT = RECURRING_SCHEDULER_TASK__SUBJECT;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK__HISTORY = RECURRING_SCHEDULER_TASK__HISTORY;

	/**
	 * The feature id for the '<em><b>Done</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK__DONE = RECURRING_SCHEDULER_TASK__DONE;

	/**
	 * The feature id for the '<em><b>Time Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK__TIME_UNIT = RECURRING_SCHEDULER_TASK__TIME_UNIT;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK__PERIOD = RECURRING_SCHEDULER_TASK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fixed Rate Scheduler Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK_FEATURE_COUNT = RECURRING_SCHEDULER_TASK_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Run</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK___RUN__SCHEDULERCONTEXT = RECURRING_SCHEDULER_TASK___RUN__SCHEDULERCONTEXT;

	/**
	 * The number of operations of the '<em>Fixed Rate Scheduler Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_RATE_SCHEDULER_TASK_OPERATION_COUNT = RECURRING_SCHEDULER_TASK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl <em>Throwable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.ThrowableImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 5;

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
	 * The feature id for the '<em><b>Suppressed</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE__SUPPRESSED = 3;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE__CAUSE = 4;

	/**
	 * The number of structural features of the '<em>Throwable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Throwable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THROWABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl <em>Stack Trace Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getStackTraceEntry()
	 * @generated
	 */
	int STACK_TRACE_ENTRY = 6;

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
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.Status <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.Status
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 7;

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.SchedulerTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask
	 * @generated
	 */
	EClass getSchedulerTask();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getStart()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EAttribute getSchedulerTask_Start();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.SchedulerTask#isDone <em>Done</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Done</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#isDone()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EAttribute getSchedulerTask_Done();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.scheduler.SchedulerTask#run(org.nasdanika.cdo.concurrent.SchedulerContext) <em>Run</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Run</em>' operation.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#run(org.nasdanika.cdo.concurrent.SchedulerContext)
	 * @generated
	 */
	EOperation getSchedulerTask__Run__SchedulerContext();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.RecurringSchedulerTask <em>Recurring Scheduler Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recurring Scheduler Task</em>'.
	 * @see org.nasdanika.cdo.scheduler.RecurringSchedulerTask
	 * @generated
	 */
	EClass getRecurringSchedulerTask();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.RecurringSchedulerTask#getTimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Unit</em>'.
	 * @see org.nasdanika.cdo.scheduler.RecurringSchedulerTask#getTimeUnit()
	 * @see #getRecurringSchedulerTask()
	 * @generated
	 */
	EAttribute getRecurringSchedulerTask_TimeUnit();

	/**
	 * Returns the meta object for the reference list '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getSubject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subject</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getSubject()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EReference getSchedulerTask_Subject();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>History</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getHistory()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EReference getSchedulerTask_History();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.FixedRateSchedulerTask <em>Fixed Rate Scheduler Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Rate Scheduler Task</em>'.
	 * @see org.nasdanika.cdo.scheduler.FixedRateSchedulerTask
	 * @generated
	 */
	EClass getFixedRateSchedulerTask();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.FixedRateSchedulerTask#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.nasdanika.cdo.scheduler.FixedRateSchedulerTask#getPeriod()
	 * @see #getFixedRateSchedulerTask()
	 * @generated
	 */
	EAttribute getFixedRateSchedulerTask_Period();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask <em>Fixed Delay Scheduler Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Delay Scheduler Task</em>'.
	 * @see org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask
	 * @generated
	 */
	EClass getFixedDelaySchedulerTask();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask#getDelay()
	 * @see #getFixedDelaySchedulerTask()
	 * @generated
	 */
	EAttribute getFixedDelaySchedulerTask_Delay();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throwable</em>'.
	 * @see org.nasdanika.cdo.scheduler.Throwable
	 * @generated
	 */
	EClass getThrowable();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.Throwable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.nasdanika.cdo.scheduler.Throwable#getType()
	 * @see #getThrowable()
	 * @generated
	 */
	EAttribute getThrowable_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.Throwable#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.nasdanika.cdo.scheduler.Throwable#getMessage()
	 * @see #getThrowable()
	 * @generated
	 */
	EAttribute getThrowable_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.scheduler.Throwable#getStackTrace <em>Stack Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stack Trace</em>'.
	 * @see org.nasdanika.cdo.scheduler.Throwable#getStackTrace()
	 * @see #getThrowable()
	 * @generated
	 */
	EReference getThrowable_StackTrace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.scheduler.Throwable#getSuppressed <em>Suppressed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Suppressed</em>'.
	 * @see org.nasdanika.cdo.scheduler.Throwable#getSuppressed()
	 * @see #getThrowable()
	 * @generated
	 */
	EReference getThrowable_Suppressed();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.scheduler.Throwable#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Cause</em>'.
	 * @see org.nasdanika.cdo.scheduler.Throwable#getCause()
	 * @see #getThrowable()
	 * @generated
	 */
	EReference getThrowable_Cause();

	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.StackTraceEntry <em>Stack Trace Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Trace Entry</em>'.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry
	 * @generated
	 */
	EClass getStackTraceEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry#getClassName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry#getFileName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry#getMethodName()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry#getLineNumber()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_LineNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see org.nasdanika.cdo.scheduler.StackTraceEntry#isNative()
	 * @see #getStackTraceEntry()
	 * @generated
	 */
	EAttribute getStackTraceEntry_Native();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.cdo.scheduler.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see org.nasdanika.cdo.scheduler.Status
	 * @generated
	 */
	EEnum getStatus();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.concurrent.SchedulerContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Context</em>'.
	 * @see org.nasdanika.cdo.concurrent.SchedulerContext
	 * @model instanceClass="org.nasdanika.cdo.concurrent.SchedulerContext" typeParameters="CR"
	 * @generated
	 */
	EDataType getSchedulerContext();

	/**
	 * Returns the meta object for data type '{@link java.util.concurrent.TimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Time Unit</em>'.
	 * @see java.util.concurrent.TimeUnit
	 * @model instanceClass="java.util.concurrent.TimeUnit"
	 * @generated
	 */
	EDataType getTimeUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulerFactory getSchedulerFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.DiagnosticImpl <em>Diagnostic</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.DiagnosticImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getDiagnostic()
		 * @generated
		 */
		EClass DIAGNOSTIC = eINSTANCE.getDiagnostic();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC__STATUS = eINSTANCE.getDiagnostic_Status();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC__MESSAGE = eINSTANCE.getDiagnostic_Message();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC__CHILDREN = eINSTANCE.getDiagnostic_Children();

		/**
		 * The meta object literal for the '<em><b>Exception</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC__EXCEPTION = eINSTANCE.getDiagnostic_Exception();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC__DURATION = eINSTANCE.getDiagnostic_Duration();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC__TIME = eINSTANCE.getDiagnostic_Time();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getSchedulerTask()
		 * @generated
		 */
		EClass SCHEDULER_TASK = eINSTANCE.getSchedulerTask();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_TASK__START = eINSTANCE.getSchedulerTask_Start();

		/**
		 * The meta object literal for the '<em><b>Done</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_TASK__DONE = eINSTANCE.getSchedulerTask_Done();

		/**
		 * The meta object literal for the '<em><b>Run</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SCHEDULER_TASK___RUN__SCHEDULERCONTEXT = eINSTANCE.getSchedulerTask__Run__SchedulerContext();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.RecurringSchedulerTaskImpl <em>Recurring Scheduler Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.RecurringSchedulerTaskImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getRecurringSchedulerTask()
		 * @generated
		 */
		EClass RECURRING_SCHEDULER_TASK = eINSTANCE.getRecurringSchedulerTask();

		/**
		 * The meta object literal for the '<em><b>Time Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURRING_SCHEDULER_TASK__TIME_UNIT = eINSTANCE.getRecurringSchedulerTask_TimeUnit();

		/**
		 * The meta object literal for the '<em><b>Subject</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_TASK__SUBJECT = eINSTANCE.getSchedulerTask_Subject();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_TASK__HISTORY = eINSTANCE.getSchedulerTask_History();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.FixedRateSchedulerTaskImpl <em>Fixed Rate Scheduler Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.FixedRateSchedulerTaskImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getFixedRateSchedulerTask()
		 * @generated
		 */
		EClass FIXED_RATE_SCHEDULER_TASK = eINSTANCE.getFixedRateSchedulerTask();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_RATE_SCHEDULER_TASK__PERIOD = eINSTANCE.getFixedRateSchedulerTask_Period();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.FixedDelaySchedulerTaskImpl <em>Fixed Delay Scheduler Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.FixedDelaySchedulerTaskImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getFixedDelaySchedulerTask()
		 * @generated
		 */
		EClass FIXED_DELAY_SCHEDULER_TASK = eINSTANCE.getFixedDelaySchedulerTask();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_DELAY_SCHEDULER_TASK__DELAY = eINSTANCE.getFixedDelaySchedulerTask_Delay();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.ThrowableImpl <em>Throwable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.ThrowableImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getThrowable()
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
		 * The meta object literal for the '<em><b>Suppressed</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROWABLE__SUPPRESSED = eINSTANCE.getThrowable_Suppressed();

		/**
		 * The meta object literal for the '<em><b>Cause</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THROWABLE__CAUSE = eINSTANCE.getThrowable_Cause();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl <em>Stack Trace Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getStackTraceEntry()
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
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.Status <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.Status
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getStatus()
		 * @generated
		 */
		EEnum STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '<em>Context</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.concurrent.SchedulerContext
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getSchedulerContext()
		 * @generated
		 */
		EDataType SCHEDULER_CONTEXT = eINSTANCE.getSchedulerContext();

		/**
		 * The meta object literal for the '<em>Time Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.concurrent.TimeUnit
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getTimeUnit()
		 * @generated
		 */
		EDataType TIME_UNIT = eINSTANCE.getTimeUnit();

	}

} //SchedulerPackage
