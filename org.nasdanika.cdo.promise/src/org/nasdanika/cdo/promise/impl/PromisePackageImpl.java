/**
 */
package org.nasdanika.cdo.promise.impl;

import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOObject;
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
import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.promise.Promise;
import org.nasdanika.cdo.promise.PromiseFactory;
import org.nasdanika.cdo.promise.PromisePackage;
import org.nasdanika.cdo.promise.PromiseState;
import org.nasdanika.cdo.scheduler.Scheduler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PromisePackageImpl extends EPackageImpl implements PromisePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass promiseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum promiseStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType timeUnitEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cdoTransactionContextCommandEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType schedulerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cdoObjectEDataType = null;

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
	 * @see org.nasdanika.cdo.promise.PromisePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PromisePackageImpl() {
		super(eNS_URI, PromiseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PromisePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PromisePackage init() {
		if (isInited) return (PromisePackage)EPackage.Registry.INSTANCE.getEPackage(PromisePackage.eNS_URI);

		// Obtain or create and register package
		PromisePackageImpl thePromisePackage = (PromisePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PromisePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PromisePackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePromisePackage.createPackageContents();

		// Initialize created meta-data
		thePromisePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePromisePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PromisePackage.eNS_URI, thePromisePackage);
		return thePromisePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPromise() {
		return promiseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPromise_Children() {
		return (EReference)promiseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPromise_Thens() {
		return (EReference)promiseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPromise_State() {
		return (EAttribute)promiseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPromise_FulfillmentValue() {
		return (EReference)promiseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPromise_RejectionReason() {
		return (EReference)promiseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Timeout__Scheduler_long_TimeUnit_Object() {
		return promiseEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Delay__Scheduler_long_TimeUnit() {
		return promiseEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Resolve__Object() {
		return promiseEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Reject__Object() {
		return promiseEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Notify__Object() {
		return promiseEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Then__CDOTransactionContextCommand_CDOTransactionContextCommand_CDOTransactionContextCommand() {
		return promiseEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPromiseState() {
		return promiseStateEEnum;
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
	public EDataType getCDOTransactionContextCommand() {
		return cdoTransactionContextCommandEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getScheduler() {
		return schedulerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCDOObject() {
		return cdoObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseFactory getPromiseFactory() {
		return (PromiseFactory)getEFactoryInstance();
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
		promiseEClass = createEClass(PROMISE);
		createEReference(promiseEClass, PROMISE__CHILDREN);
		createEReference(promiseEClass, PROMISE__THENS);
		createEAttribute(promiseEClass, PROMISE__STATE);
		createEReference(promiseEClass, PROMISE__FULFILLMENT_VALUE);
		createEReference(promiseEClass, PROMISE__REJECTION_REASON);
		createEOperation(promiseEClass, PROMISE___TIMEOUT__SCHEDULER_LONG_TIMEUNIT_OBJECT);
		createEOperation(promiseEClass, PROMISE___DELAY__SCHEDULER_LONG_TIMEUNIT);
		createEOperation(promiseEClass, PROMISE___RESOLVE__OBJECT);
		createEOperation(promiseEClass, PROMISE___REJECT__OBJECT);
		createEOperation(promiseEClass, PROMISE___NOTIFY__OBJECT);
		createEOperation(promiseEClass, PROMISE___THEN__CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND);

		// Create enums
		promiseStateEEnum = createEEnum(PROMISE_STATE);

		// Create data types
		timeUnitEDataType = createEDataType(TIME_UNIT);
		cdoTransactionContextCommandEDataType = createEDataType(CDO_TRANSACTION_CONTEXT_COMMAND);
		schedulerEDataType = createEDataType(SCHEDULER);
		cdoObjectEDataType = createEDataType(CDO_OBJECT);
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

		// Create type parameters
		ETypeParameter promiseEClass_CR = addETypeParameter(promiseEClass, "CR");
		ETypeParameter promiseEClass_F = addETypeParameter(promiseEClass, "F");
		ETypeParameter promiseEClass_R = addETypeParameter(promiseEClass, "R");
		ETypeParameter promiseEClass_N = addETypeParameter(promiseEClass, "N");
		addETypeParameter(cdoTransactionContextCommandEDataType, "CR");
		addETypeParameter(cdoTransactionContextCommandEDataType, "T");
		addETypeParameter(cdoTransactionContextCommandEDataType, "R");
		addETypeParameter(schedulerEDataType, "CR");
		addETypeParameter(schedulerEDataType, "K");

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(promiseEClass, Promise.class, "Promise", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(this.getPromise());
		EGenericType g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getPromise_Children(), g1, null, "children", null, 0, -1, Promise.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEReference(getPromise_Thens(), g1, null, "thens", null, 0, -1, Promise.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPromise_State(), this.getPromiseState(), "state", null, 0, 1, Promise.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPromise_FulfillmentValue(), ecorePackage.getEObject(), null, "fulfillmentValue", null, 0, 1, Promise.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPromise_RejectionReason(), ecorePackage.getEObject(), null, "rejectionReason", null, 0, 1, Promise.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getPromise__Timeout__Scheduler_long_TimeUnit_Object(), null, "timeout", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "TR");
		g1 = createEGenericType(this.getScheduler());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getCDOObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "scheduler", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "timeout", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTimeUnit(), "timeUnit", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(t1);
		addEParameter(op, g1, "reason", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_F);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_N);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getPromise__Delay__Scheduler_long_TimeUnit(), null, "delay", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getScheduler());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getCDOObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "scheduler", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "delay", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTimeUnit(), "timeUnit", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_F);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_N);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getPromise__Resolve__Object(), null, "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_F);
		addEParameter(op, g1, "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPromise__Reject__Object(), null, "reject", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_R);
		addEParameter(op, g1, "reason", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPromise__Notify__Object(), null, "notify", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_N);
		addEParameter(op, g1, "progress", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getPromise__Then__CDOTransactionContextCommand_CDOTransactionContextCommand_CDOTransactionContextCommand(), null, "then", 0, 1, IS_UNIQUE, IS_ORDERED);
		t1 = addETypeParameter(op, "TF");
		ETypeParameter t2 = addETypeParameter(op, "TR");
		ETypeParameter t3 = addETypeParameter(op, "TN");
		g1 = createEGenericType(this.getCDOTransactionContextCommand());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(promiseEClass_F);
		g2.setELowerBound(g3);
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "onFulfill", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getCDOTransactionContextCommand());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(promiseEClass_R);
		g2.setELowerBound(g3);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "onReject", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getCDOTransactionContextCommand());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(promiseEClass_N);
		g2.setELowerBound(g3);
		g2 = createEGenericType(t3);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "onNotify", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(promiseEClass_CR);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t2);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t3);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(promiseStateEEnum, PromiseState.class, "PromiseState");
		addEEnumLiteral(promiseStateEEnum, PromiseState.PENDING);
		addEEnumLiteral(promiseStateEEnum, PromiseState.FULFILLED);
		addEEnumLiteral(promiseStateEEnum, PromiseState.REJECTED);
		addEEnumLiteral(promiseStateEEnum, PromiseState.CANCELLED);

		// Initialize data types
		initEDataType(timeUnitEDataType, TimeUnit.class, "TimeUnit", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cdoTransactionContextCommandEDataType, CDOTransactionContextCommand.class, "CDOTransactionContextCommand", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(schedulerEDataType, Scheduler.class, "Scheduler", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cdoObjectEDataType, CDOObject.class, "CDOObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //PromisePackageImpl
