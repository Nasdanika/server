/**
 */
package org.nasdanika.cdo.scheduler.impl;

import java.util.concurrent.TimeUnit;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.nasdanika.cdo.concurrent.SchedulerContext;
import org.nasdanika.cdo.scheduler.Diagnostic;
import org.nasdanika.cdo.scheduler.FixedDelaySchedulerTask;
import org.nasdanika.cdo.scheduler.FixedRateSchedulerTask;
import org.nasdanika.cdo.scheduler.RecurringSchedulerTask;
import org.nasdanika.cdo.scheduler.SchedulerFactory;
import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.SchedulerTask;
import org.nasdanika.cdo.scheduler.StackTraceEntry;
import org.nasdanika.cdo.scheduler.Status;
import org.nasdanika.cdo.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerPackageImpl extends EPackageImpl implements SchedulerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulerTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recurringSchedulerTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedRateSchedulerTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedDelaySchedulerTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackTraceEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum statusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType schedulerContextEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType timeUnitEDataType = null;

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
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulerPackageImpl() {
		super(eNS_URI, SchedulerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SchedulerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulerPackage init() {
		if (isInited) return (SchedulerPackage)EPackage.Registry.INSTANCE.getEPackage(SchedulerPackage.eNS_URI);

		// Obtain or create and register package
		SchedulerPackageImpl theSchedulerPackage = (SchedulerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SchedulerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SchedulerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SecurityPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSchedulerPackage.createPackageContents();

		// Initialize created meta-data
		theSchedulerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulerPackage.eNS_URI, theSchedulerPackage);
		return theSchedulerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagnostic() {
		return diagnosticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagnostic_Status() {
		return (EAttribute)diagnosticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagnostic_Message() {
		return (EAttribute)diagnosticEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagnostic_Children() {
		return (EReference)diagnosticEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagnostic_Exception() {
		return (EReference)diagnosticEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagnostic_Duration() {
		return (EAttribute)diagnosticEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagnostic_Time() {
		return (EAttribute)diagnosticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulerTask() {
		return schedulerTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulerTask_Start() {
		return (EAttribute)schedulerTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSchedulerTask_Done() {
		return (EAttribute)schedulerTaskEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getSchedulerTask__Run__SchedulerContext() {
		return schedulerTaskEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecurringSchedulerTask() {
		return recurringSchedulerTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecurringSchedulerTask_TimeUnit() {
		return (EAttribute)recurringSchedulerTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerTask_Subject() {
		return (EReference)schedulerTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedulerTask_History() {
		return (EReference)schedulerTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedRateSchedulerTask() {
		return fixedRateSchedulerTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedRateSchedulerTask_Period() {
		return (EAttribute)fixedRateSchedulerTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedDelaySchedulerTask() {
		return fixedDelaySchedulerTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedDelaySchedulerTask_Delay() {
		return (EAttribute)fixedDelaySchedulerTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThrowable() {
		return throwableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrowable_Type() {
		return (EAttribute)throwableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getThrowable_Message() {
		return (EAttribute)throwableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowable_StackTrace() {
		return (EReference)throwableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowable_Suppressed() {
		return (EReference)throwableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThrowable_Cause() {
		return (EReference)throwableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackTraceEntry() {
		return stackTraceEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_ClassName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_FileName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_MethodName() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_LineNumber() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStackTraceEntry_Native() {
		return (EAttribute)stackTraceEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStatus() {
		return statusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSchedulerContext() {
		return schedulerContextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTimeUnit() {
		return timeUnitEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerFactory getSchedulerFactory() {
		return (SchedulerFactory)getEFactoryInstance();
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
		diagnosticEClass = createEClass(DIAGNOSTIC);
		createEAttribute(diagnosticEClass, DIAGNOSTIC__TIME);
		createEAttribute(diagnosticEClass, DIAGNOSTIC__STATUS);
		createEAttribute(diagnosticEClass, DIAGNOSTIC__MESSAGE);
		createEReference(diagnosticEClass, DIAGNOSTIC__CHILDREN);
		createEReference(diagnosticEClass, DIAGNOSTIC__EXCEPTION);
		createEAttribute(diagnosticEClass, DIAGNOSTIC__DURATION);

		schedulerTaskEClass = createEClass(SCHEDULER_TASK);
		createEAttribute(schedulerTaskEClass, SCHEDULER_TASK__START);
		createEReference(schedulerTaskEClass, SCHEDULER_TASK__SUBJECT);
		createEReference(schedulerTaskEClass, SCHEDULER_TASK__HISTORY);
		createEAttribute(schedulerTaskEClass, SCHEDULER_TASK__DONE);
		createEOperation(schedulerTaskEClass, SCHEDULER_TASK___RUN__SCHEDULERCONTEXT);

		recurringSchedulerTaskEClass = createEClass(RECURRING_SCHEDULER_TASK);
		createEAttribute(recurringSchedulerTaskEClass, RECURRING_SCHEDULER_TASK__TIME_UNIT);

		fixedDelaySchedulerTaskEClass = createEClass(FIXED_DELAY_SCHEDULER_TASK);
		createEAttribute(fixedDelaySchedulerTaskEClass, FIXED_DELAY_SCHEDULER_TASK__DELAY);

		fixedRateSchedulerTaskEClass = createEClass(FIXED_RATE_SCHEDULER_TASK);
		createEAttribute(fixedRateSchedulerTaskEClass, FIXED_RATE_SCHEDULER_TASK__PERIOD);

		throwableEClass = createEClass(THROWABLE);
		createEAttribute(throwableEClass, THROWABLE__TYPE);
		createEAttribute(throwableEClass, THROWABLE__MESSAGE);
		createEReference(throwableEClass, THROWABLE__STACK_TRACE);
		createEReference(throwableEClass, THROWABLE__SUPPRESSED);
		createEReference(throwableEClass, THROWABLE__CAUSE);

		stackTraceEntryEClass = createEClass(STACK_TRACE_ENTRY);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__CLASS_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__FILE_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__METHOD_NAME);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__LINE_NUMBER);
		createEAttribute(stackTraceEntryEClass, STACK_TRACE_ENTRY__NATIVE);

		// Create enums
		statusEEnum = createEEnum(STATUS);

		// Create data types
		schedulerContextEDataType = createEDataType(SCHEDULER_CONTEXT);
		timeUnitEDataType = createEDataType(TIME_UNIT);
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
		SecurityPackage theSecurityPackage = (SecurityPackage)EPackage.Registry.INSTANCE.getEPackage(SecurityPackage.eNS_URI);

		// Create type parameters
		ETypeParameter schedulerTaskEClass_CR = addETypeParameter(schedulerTaskEClass, "CR");
		ETypeParameter recurringSchedulerTaskEClass_CR = addETypeParameter(recurringSchedulerTaskEClass, "CR");
		ETypeParameter fixedDelaySchedulerTaskEClass_CR = addETypeParameter(fixedDelaySchedulerTaskEClass, "CR");
		ETypeParameter fixedRateSchedulerTaskEClass_CR = addETypeParameter(fixedRateSchedulerTaskEClass, "CR");
		addETypeParameter(schedulerContextEDataType, "CR");

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(this.getSchedulerTask());
		EGenericType g2 = createEGenericType(recurringSchedulerTaskEClass_CR);
		g1.getETypeArguments().add(g2);
		recurringSchedulerTaskEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getRecurringSchedulerTask());
		g2 = createEGenericType(fixedDelaySchedulerTaskEClass_CR);
		g1.getETypeArguments().add(g2);
		fixedDelaySchedulerTaskEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getRecurringSchedulerTask());
		g2 = createEGenericType(fixedRateSchedulerTaskEClass_CR);
		g1.getETypeArguments().add(g2);
		fixedRateSchedulerTaskEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes, features, and operations; add parameters
		initEClass(diagnosticEClass, Diagnostic.class, "Diagnostic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagnostic_Time(), ecorePackage.getEDate(), "time", null, 1, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnostic_Status(), this.getStatus(), "status", null, 1, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnostic_Message(), ecorePackage.getEString(), "message", null, 0, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnostic_Children(), this.getDiagnostic(), null, "children", null, 0, -1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnostic_Exception(), this.getThrowable(), null, "exception", null, 0, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnostic_Duration(), ecorePackage.getELong(), "duration", null, 0, 1, Diagnostic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(schedulerTaskEClass, SchedulerTask.class, "SchedulerTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSchedulerTask_Start(), ecorePackage.getEDate(), "start", null, 1, 1, SchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulerTask_Subject(), theSecurityPackage.getPrincipal(), null, "subject", null, 0, -1, SchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedulerTask_History(), this.getDiagnostic(), null, "history", null, 0, -1, SchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSchedulerTask_Done(), ecorePackage.getEBoolean(), "done", null, 0, 1, SchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getSchedulerTask__Run__SchedulerContext(), this.getDiagnostic(), "run", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getSchedulerContext());
		g2 = createEGenericType(schedulerTaskEClass_CR);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theSecurityPackage.getException());

		initEClass(recurringSchedulerTaskEClass, RecurringSchedulerTask.class, "RecurringSchedulerTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecurringSchedulerTask_TimeUnit(), this.getTimeUnit(), "timeUnit", "SECONDS", 1, 1, RecurringSchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fixedDelaySchedulerTaskEClass, FixedDelaySchedulerTask.class, "FixedDelaySchedulerTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedDelaySchedulerTask_Delay(), ecorePackage.getELong(), "delay", null, 0, 1, FixedDelaySchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fixedRateSchedulerTaskEClass, FixedRateSchedulerTask.class, "FixedRateSchedulerTask", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedRateSchedulerTask_Period(), ecorePackage.getELong(), "period", null, 0, 1, FixedRateSchedulerTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throwableEClass, org.nasdanika.cdo.scheduler.Throwable.class, "Throwable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getThrowable_Type(), ecorePackage.getEString(), "type", null, 0, 1, org.nasdanika.cdo.scheduler.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getThrowable_Message(), ecorePackage.getEString(), "message", null, 0, 1, org.nasdanika.cdo.scheduler.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrowable_StackTrace(), this.getStackTraceEntry(), null, "stackTrace", null, 0, -1, org.nasdanika.cdo.scheduler.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrowable_Suppressed(), this.getThrowable(), null, "suppressed", null, 0, -1, org.nasdanika.cdo.scheduler.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThrowable_Cause(), this.getThrowable(), null, "cause", null, 0, 1, org.nasdanika.cdo.scheduler.Throwable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stackTraceEntryEClass, StackTraceEntry.class, "StackTraceEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStackTraceEntry_ClassName(), ecorePackage.getEString(), "className", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_FileName(), ecorePackage.getEString(), "fileName", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_MethodName(), ecorePackage.getEString(), "methodName", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStackTraceEntry_Native(), ecorePackage.getEBoolean(), "native", null, 0, 1, StackTraceEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(statusEEnum, Status.class, "Status");
		addEEnumLiteral(statusEEnum, Status.PENDING);
		addEEnumLiteral(statusEEnum, Status.IN_PROGRESS);
		addEEnumLiteral(statusEEnum, Status.SUCCESS);
		addEEnumLiteral(statusEEnum, Status.WARNING);
		addEEnumLiteral(statusEEnum, Status.ERROR);
		addEEnumLiteral(statusEEnum, Status.CANCELLED);

		// Initialize data types
		initEDataType(schedulerContextEDataType, SchedulerContext.class, "SchedulerContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(timeUnitEDataType, TimeUnit.class, "TimeUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// org.nasdanika.cdo.web.render
		createOrgAnnotations();
		// http://www.eclipse.org/emf/2002/GenModel
		createGenModelAnnotations();
	}

	/**
	 * Initializes the annotations for <b>org.nasdanika.cdo.web.render</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOrgAnnotations() {
		String source = "org.nasdanika.cdo.web.render";	
		addAnnotation
		  (statusEEnum, 
		   source, 
		   new String[] {
			 "icon", "fa fa-check-circle-o"
		   });	
		addAnnotation
		  (statusEEnum.getELiterals().get(1), 
		   source, 
		   new String[] {
			 "icon", "fa fa-spinner fa-spin"
		   });	
		addAnnotation
		  (statusEEnum.getELiterals().get(2), 
		   source, 
		   new String[] {
			 "icon", "fa fa-check-square text-success"
		   });	
		addAnnotation
		  (statusEEnum.getELiterals().get(3), 
		   source, 
		   new String[] {
			 "icon", "fa fa-warning text-warning"
		   });	
		addAnnotation
		  (statusEEnum.getELiterals().get(4), 
		   source, 
		   new String[] {
			 "icon", "fa fa-exclamation-circle text-danger"
		   });	
		addAnnotation
		  (statusEEnum.getELiterals().get(5), 
		   source, 
		   new String[] {
			 "icon", "fa fa-times-circle-o text-info"
		   });	
		addAnnotation
		  (diagnosticEClass, 
		   source, 
		   new String[] {
			 "editable", "false"
		   });	
		addAnnotation
		  (getDiagnostic_Time(), 
		   source, 
		   new String[] {
			 "format", "yyyy-MM-dd HH:mm:ss.SSS z"
		   });	
		addAnnotation
		  (getDiagnostic_Children(), 
		   source, 
		   new String[] {
			 "editable", "false",
			 "tree-feature", "false"
		   });	
		addAnnotation
		  (getSchedulerTask_Start(), 
		   source, 
		   new String[] {
			 "format", "display: yyyy-MM-dd HH:mm:ss.SSS z\r\nedit: yyyy-MM-dd\'T\'HH:mm",
			 "input-type", "datetime_local"
		   });	
		addAnnotation
		  (getSchedulerTask_History(), 
		   source, 
		   new String[] {
			 "tree-feature", "false",
			 "editable", "false",
			 "icon", "fa fa-cog"
		   });	
		addAnnotation
		  (throwableEClass, 
		   source, 
		   new String[] {
			 "icon", "fa fa-bolt",
			 "editable", "false"
		   });	
		addAnnotation
		  (stackTraceEntryEClass, 
		   source, 
		   new String[] {
			 "icon", "fa fa-bars",
			 "editable", "false"
		   });
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
		  (diagnosticEClass, 
		   source, 
		   new String[] {
			 "documentation", "Diagnostic of the task run. The root diagnostic returned by the run() method is merged into the run history entry."
		   });	
		addAnnotation
		  (getDiagnostic_Time(), 
		   source, 
		   new String[] {
			 "documentation", "Time of task execution."
		   });	
		addAnnotation
		  (getDiagnostic_Duration(), 
		   source, 
		   new String[] {
			 "documentation", "Duration of task execution in milliseconds."
		   });	
		addAnnotation
		  (schedulerTaskEClass, 
		   source, 
		   new String[] {
			 "documentation", "Supertype for scheduler tasks."
		   });	
		addAnnotation
		  (getSchedulerTask_Start(), 
		   source, 
		   new String[] {
			 "documentation", "When to execute task. Submits task if this value is before the current time."
		   });	
		addAnnotation
		  (getSchedulerTask_History(), 
		   source, 
		   new String[] {
			 "documentation", "History of task execution."
		   });	
		addAnnotation
		  (getSchedulerTask_Done(), 
		   source, 
		   new String[] {
			 "documentation", "Tasks are scheduled only if they are not done. Scheduler sets done to true for\r\none-off tasks (not fixed rate or fixed delay)."
		   });	
		addAnnotation
		  (getFixedDelaySchedulerTask_Delay(), 
		   source, 
		   new String[] {
			 "documentation", "Task delay in time units."
		   });	
		addAnnotation
		  (getFixedRateSchedulerTask_Period(), 
		   source, 
		   new String[] {
			 "documentation", "Task period in time units."
		   });	
		addAnnotation
		  (throwableEClass, 
		   source, 
		   new String[] {
			 "documentation", "Models java.lang.Throwable."
		   });	
		addAnnotation
		  (getThrowable_Type(), 
		   source, 
		   new String[] {
			 "documentation", "Throwable class name."
		   });	
		addAnnotation
		  (getThrowable_Message(), 
		   source, 
		   new String[] {
			 "documentation", "Error message."
		   });	
		addAnnotation
		  (getThrowable_StackTrace(), 
		   source, 
		   new String[] {
			 "documentation", "Stack trace."
		   });	
		addAnnotation
		  (getThrowable_Suppressed(), 
		   source, 
		   new String[] {
			 "documentation", "Stack trace."
		   });	
		addAnnotation
		  (getThrowable_Cause(), 
		   source, 
		   new String[] {
			 "documentation", "Stack trace."
		   });	
		addAnnotation
		  (stackTraceEntryEClass, 
		   source, 
		   new String[] {
			 "documentation", ""
		   });	
		addAnnotation
		  (getStackTraceEntry_ClassName(), 
		   source, 
		   new String[] {
			 "documentation", "Class name."
		   });	
		addAnnotation
		  (getStackTraceEntry_FileName(), 
		   source, 
		   new String[] {
			 "documentation", "File name."
		   });	
		addAnnotation
		  (getStackTraceEntry_MethodName(), 
		   source, 
		   new String[] {
			 "documentation", "Method name."
		   });	
		addAnnotation
		  (getStackTraceEntry_LineNumber(), 
		   source, 
		   new String[] {
			 "documentation", "Line number."
		   });	
		addAnnotation
		  (getStackTraceEntry_Native(), 
		   source, 
		   new String[] {
			 "documentation", "\'true\' for native methods."
		   });
	}

} //SchedulerPackageImpl
