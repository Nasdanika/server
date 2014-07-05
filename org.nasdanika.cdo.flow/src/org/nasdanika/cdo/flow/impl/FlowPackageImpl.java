/**
 */
package org.nasdanika.cdo.flow.impl;

import java.util.Map;
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
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.flow.Action;
import org.nasdanika.cdo.flow.ActionState;
import org.nasdanika.cdo.flow.All;
import org.nasdanika.cdo.flow.Any;
import org.nasdanika.cdo.flow.BoundInvocable;
import org.nasdanika.cdo.flow.Command;
import org.nasdanika.cdo.flow.Deferred;
import org.nasdanika.cdo.flow.DeferredInvocation;
import org.nasdanika.cdo.flow.DeferringInvocable;
import org.nasdanika.cdo.flow.Dispatch;
import org.nasdanika.cdo.flow.Executor;
import org.nasdanika.cdo.flow.FlowFactory;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;
import org.nasdanika.cdo.flow.InvocableReference;
import org.nasdanika.cdo.flow.InvocableThen;
import org.nasdanika.cdo.flow.Job;
import org.nasdanika.cdo.flow.JobQueue;
import org.nasdanika.cdo.flow.JobStatus;
import org.nasdanika.cdo.flow.Promise;
import org.nasdanika.cdo.flow.PromiseReference;
import org.nasdanika.cdo.flow.PromiseState;
import org.nasdanika.cdo.flow.Publish;
import org.nasdanika.cdo.flow.Then;
import org.nasdanika.cdo.flow.ThenReference;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowPackageImpl extends EPackageImpl implements FlowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thenReferenceEClass = null;

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
	private EClass promiseReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deferredEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jobQueueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invocableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invocableThenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invocableReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundInvocableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deferredInvocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deferringInvocableEClass = null;

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
	private EEnum jobStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actionStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType contextEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType exceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType cdoTransactionContextEDataType = null;

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
	 * @see org.nasdanika.cdo.flow.FlowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FlowPackageImpl() {
		super(eNS_URI, FlowFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FlowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FlowPackage init() {
		if (isInited) return (FlowPackage)EPackage.Registry.INSTANCE.getEPackage(FlowPackage.eNS_URI);

		// Obtain or create and register package
		FlowPackageImpl theFlowPackage = (FlowPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FlowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FlowPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFlowPackage.createPackageContents();

		// Initialize created meta-data
		theFlowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFlowPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FlowPackage.eNS_URI, theFlowPackage);
		return theFlowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThen() {
		return thenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThen__OnFulfilled__Object_Context() {
		return thenEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getThen__OnRejected__Exception_Context() {
		return thenEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThenReference() {
		return thenReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThenReference_Target() {
		return (EReference)thenReferenceEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getPromise_Done() {
		return (EAttribute)promiseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__Then__Then_Context_Executor() {
		return promiseEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeferred() {
		return deferredEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeferred_State() {
		return (EAttribute)deferredEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeferred_Created() {
		return (EAttribute)deferredEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeferred_Resolved() {
		return (EAttribute)deferredEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeferred_Comment() {
		return (EAttribute)deferredEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferred_Resolution() {
		return (EReference)deferredEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferred_Then() {
		return (EReference)deferredEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferred_ThenDeferreds() {
		return (EReference)deferredEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeferred__Resolve__Object_Context_Executor() {
		return deferredEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeferred__Resolve__Promise_Context_Executor() {
		return deferredEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDeferred__Reject__Exception_Context_Executor() {
		return deferredEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJob() {
		return jobEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJob_Command() {
		return (EReference)jobEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJob_Deferred() {
		return (EReference)jobEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Created() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Started() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Completed() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_Status() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_When() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJob_FailureReason() {
		return (EAttribute)jobEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getJob__CanExecute() {
		return jobEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJobQueue() {
		return jobQueueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getJobQueue_Jobs() {
		return (EReference)jobQueueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__GetFulfillmentValue__Context() {
		return promiseEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__GetRejectionReason__Context() {
		return promiseEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPromise__GetState() {
		return promiseEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPromiseReference() {
		return promiseReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPromiseReference_Target() {
		return (EReference)promiseReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAll() {
		return allEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAll_Promises() {
		return (EReference)allEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAll__Init__EList_Executor() {
		return allEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAny() {
		return anyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAny_Promises() {
		return (EReference)anyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAny__Init__EList_Executor() {
		return anyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommand() {
		return commandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCommand__Execute__Context_Executor() {
		return commandEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutor() {
		return executorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvocable() {
		return invocableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocable__Invoke__Context_EList() {
		return invocableEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getInvocable__Accept__Context_EList() {
		return invocableEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvocableThen() {
		return invocableThenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocableThen_OnFulfilled() {
		return (EReference)invocableThenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocableThen_OnRejected() {
		return (EReference)invocableThenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvocableReference() {
		return invocableReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvocableReference_Target() {
		return (EReference)invocableReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundInvocable() {
		return boundInvocableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Outputs() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionOutput() {
		return actionOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionOutput_Key() {
		return (EAttribute)actionOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionOutput_Value() {
		return (EReference)actionOutputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDispatch() {
		return dispatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDispatch_Targets() {
		return (EReference)dispatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublish() {
		return publishEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPublish_Targets() {
		return (EReference)publishEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeferredInvocation() {
		return deferredInvocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferredInvocation_Arguments() {
		return (EReference)deferredInvocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferredInvocation_Result() {
		return (EReference)deferredInvocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeferringInvocable() {
		return deferringInvocableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferringInvocable_Target() {
		return (EReference)deferringInvocableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeferringInvocable_Invocations() {
		return (EReference)deferringInvocableEClass.getEStructuralFeatures().get(1);
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
	public EEnum getJobStatus() {
		return jobStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActionState() {
		return actionStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getContext() {
		return contextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getException() {
		return exceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCDOTransactionContext() {
		return cdoTransactionContextEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFactory getFlowFactory() {
		return (FlowFactory)getEFactoryInstance();
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
		thenEClass = createEClass(THEN);
		createEOperation(thenEClass, THEN___ON_FULFILLED__OBJECT_CONTEXT);
		createEOperation(thenEClass, THEN___ON_REJECTED__EXCEPTION_CONTEXT);

		thenReferenceEClass = createEClass(THEN_REFERENCE);
		createEReference(thenReferenceEClass, THEN_REFERENCE__TARGET);

		executorEClass = createEClass(EXECUTOR);

		promiseEClass = createEClass(PROMISE);
		createEAttribute(promiseEClass, PROMISE__DONE);
		createEOperation(promiseEClass, PROMISE___THEN__THEN_CONTEXT_EXECUTOR);
		createEOperation(promiseEClass, PROMISE___GET_FULFILLMENT_VALUE__CONTEXT);
		createEOperation(promiseEClass, PROMISE___GET_REJECTION_REASON__CONTEXT);
		createEOperation(promiseEClass, PROMISE___GET_STATE);

		promiseReferenceEClass = createEClass(PROMISE_REFERENCE);
		createEReference(promiseReferenceEClass, PROMISE_REFERENCE__TARGET);

		allEClass = createEClass(ALL);
		createEReference(allEClass, ALL__PROMISES);
		createEOperation(allEClass, ALL___INIT__ELIST_EXECUTOR);

		anyEClass = createEClass(ANY);
		createEReference(anyEClass, ANY__PROMISES);
		createEOperation(anyEClass, ANY___INIT__ELIST_EXECUTOR);

		commandEClass = createEClass(COMMAND);
		createEOperation(commandEClass, COMMAND___EXECUTE__CONTEXT_EXECUTOR);

		deferredEClass = createEClass(DEFERRED);
		createEAttribute(deferredEClass, DEFERRED__STATE);
		createEAttribute(deferredEClass, DEFERRED__CREATED);
		createEAttribute(deferredEClass, DEFERRED__RESOLVED);
		createEAttribute(deferredEClass, DEFERRED__COMMENT);
		createEReference(deferredEClass, DEFERRED__RESOLUTION);
		createEReference(deferredEClass, DEFERRED__THEN);
		createEReference(deferredEClass, DEFERRED__THEN_DEFERREDS);
		createEOperation(deferredEClass, DEFERRED___RESOLVE__OBJECT_CONTEXT_EXECUTOR);
		createEOperation(deferredEClass, DEFERRED___RESOLVE__PROMISE_CONTEXT_EXECUTOR);
		createEOperation(deferredEClass, DEFERRED___REJECT__EXCEPTION_CONTEXT_EXECUTOR);

		jobEClass = createEClass(JOB);
		createEReference(jobEClass, JOB__COMMAND);
		createEReference(jobEClass, JOB__DEFERRED);
		createEAttribute(jobEClass, JOB__CREATED);
		createEAttribute(jobEClass, JOB__STARTED);
		createEAttribute(jobEClass, JOB__COMPLETED);
		createEAttribute(jobEClass, JOB__STATUS);
		createEAttribute(jobEClass, JOB__WHEN);
		createEAttribute(jobEClass, JOB__FAILURE_REASON);
		createEOperation(jobEClass, JOB___CAN_EXECUTE);

		jobQueueEClass = createEClass(JOB_QUEUE);
		createEReference(jobQueueEClass, JOB_QUEUE__JOBS);

		invocableEClass = createEClass(INVOCABLE);
		createEOperation(invocableEClass, INVOCABLE___INVOKE__CONTEXT_ELIST);
		createEOperation(invocableEClass, INVOCABLE___ACCEPT__CONTEXT_ELIST);

		invocableThenEClass = createEClass(INVOCABLE_THEN);
		createEReference(invocableThenEClass, INVOCABLE_THEN__ON_FULFILLED);
		createEReference(invocableThenEClass, INVOCABLE_THEN__ON_REJECTED);

		invocableReferenceEClass = createEClass(INVOCABLE_REFERENCE);
		createEReference(invocableReferenceEClass, INVOCABLE_REFERENCE__TARGET);

		boundInvocableEClass = createEClass(BOUND_INVOCABLE);

		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__OUTPUTS);

		actionOutputEClass = createEClass(ACTION_OUTPUT);
		createEAttribute(actionOutputEClass, ACTION_OUTPUT__KEY);
		createEReference(actionOutputEClass, ACTION_OUTPUT__VALUE);

		dispatchEClass = createEClass(DISPATCH);
		createEReference(dispatchEClass, DISPATCH__TARGETS);

		publishEClass = createEClass(PUBLISH);
		createEReference(publishEClass, PUBLISH__TARGETS);

		deferredInvocationEClass = createEClass(DEFERRED_INVOCATION);
		createEReference(deferredInvocationEClass, DEFERRED_INVOCATION__ARGUMENTS);
		createEReference(deferredInvocationEClass, DEFERRED_INVOCATION__RESULT);

		deferringInvocableEClass = createEClass(DEFERRING_INVOCABLE);
		createEReference(deferringInvocableEClass, DEFERRING_INVOCABLE__TARGET);
		createEReference(deferringInvocableEClass, DEFERRING_INVOCABLE__INVOCATIONS);

		// Create enums
		promiseStateEEnum = createEEnum(PROMISE_STATE);
		jobStatusEEnum = createEEnum(JOB_STATUS);
		actionStateEEnum = createEEnum(ACTION_STATE);

		// Create data types
		contextEDataType = createEDataType(CONTEXT);
		exceptionEDataType = createEDataType(EXCEPTION);
		cdoTransactionContextEDataType = createEDataType(CDO_TRANSACTION_CONTEXT);
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
		ETypeParameter thenEClass_R = addETypeParameter(thenEClass, "R");
		ETypeParameter thenEClass_R1 = addETypeParameter(thenEClass, "R1");
		ETypeParameter thenEClass_C = addETypeParameter(thenEClass, "C");
		ETypeParameter thenReferenceEClass_R = addETypeParameter(thenReferenceEClass, "R");
		ETypeParameter thenReferenceEClass_R1 = addETypeParameter(thenReferenceEClass, "R1");
		ETypeParameter thenReferenceEClass_C = addETypeParameter(thenReferenceEClass, "C");
		ETypeParameter executorEClass_C = addETypeParameter(executorEClass, "C");
		ETypeParameter promiseEClass_R = addETypeParameter(promiseEClass, "R");
		ETypeParameter promiseEClass_C = addETypeParameter(promiseEClass, "C");
		ETypeParameter promiseReferenceEClass_R = addETypeParameter(promiseReferenceEClass, "R");
		ETypeParameter promiseReferenceEClass_C = addETypeParameter(promiseReferenceEClass, "C");
		ETypeParameter allEClass_R = addETypeParameter(allEClass, "R");
		ETypeParameter allEClass_C = addETypeParameter(allEClass, "C");
		ETypeParameter anyEClass_R = addETypeParameter(anyEClass, "R");
		ETypeParameter anyEClass_C = addETypeParameter(anyEClass, "C");
		ETypeParameter commandEClass_R = addETypeParameter(commandEClass, "R");
		ETypeParameter commandEClass_C = addETypeParameter(commandEClass, "C");
		ETypeParameter deferredEClass_R = addETypeParameter(deferredEClass, "R");
		ETypeParameter deferredEClass_C = addETypeParameter(deferredEClass, "C");
		ETypeParameter jobEClass_R = addETypeParameter(jobEClass, "R");
		ETypeParameter jobEClass_C = addETypeParameter(jobEClass, "C");
		ETypeParameter jobQueueEClass_C = addETypeParameter(jobQueueEClass, "C");
		ETypeParameter invocableEClass_R = addETypeParameter(invocableEClass, "R");
		ETypeParameter invocableEClass_C = addETypeParameter(invocableEClass, "C");
		ETypeParameter invocableThenEClass_R = addETypeParameter(invocableThenEClass, "R");
		ETypeParameter invocableThenEClass_R1 = addETypeParameter(invocableThenEClass, "R1");
		ETypeParameter invocableThenEClass_C = addETypeParameter(invocableThenEClass, "C");
		ETypeParameter invocableReferenceEClass_R = addETypeParameter(invocableReferenceEClass, "R");
		ETypeParameter invocableReferenceEClass_C = addETypeParameter(invocableReferenceEClass, "C");
		ETypeParameter actionEClass_R = addETypeParameter(actionEClass, "R");
		ETypeParameter actionEClass_C = addETypeParameter(actionEClass, "C");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getContext());
		thenEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		thenReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		executorEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		promiseEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		promiseReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		allEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		anyEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		commandEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		deferredEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		jobEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		jobQueueEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		invocableEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		invocableThenEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		invocableReferenceEClass_C.getEBounds().add(g1);
		g1 = createEGenericType(this.getContext());
		actionEClass_C.getEBounds().add(g1);

		// Add supertypes to classes
		g1 = createEGenericType(this.getThen());
		EGenericType g2 = createEGenericType(thenReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(thenReferenceEClass_R1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(thenReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		thenReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(promiseReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		promiseReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(ecorePackage.getEEList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(allEClass_R);
		g2.getETypeArguments().add(g3);
		g2 = createEGenericType(allEClass_C);
		g1.getETypeArguments().add(g2);
		allEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(anyEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(anyEClass_C);
		g1.getETypeArguments().add(g2);
		anyEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(deferredEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		deferredEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCommand());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		deferredEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getThen());
		g2 = createEGenericType(invocableThenEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(invocableThenEClass_R1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(invocableThenEClass_C);
		g1.getETypeArguments().add(g2);
		invocableThenEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInvocable());
		g2 = createEGenericType(invocableReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(invocableReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		invocableReferenceEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getInvocable());
		g2 = createEGenericType(actionEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(actionEClass_C);
		g1.getETypeArguments().add(g2);
		actionEClass.getEGenericSuperTypes().add(g1);
		dispatchEClass.getESuperTypes().add(this.getInvocable());
		publishEClass.getESuperTypes().add(this.getInvocable());
		deferredInvocationEClass.getESuperTypes().add(this.getCommand());
		deferringInvocableEClass.getESuperTypes().add(this.getInvocable());

		// Initialize classes, features, and operations; add parameters
		initEClass(thenEClass, Then.class, "Then", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = initEOperation(getThen__OnFulfilled__Object_Context(), null, "onFulfilled", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(thenEClass_R);
		addEParameter(op, g1, "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(thenEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());
		g1 = createEGenericType(thenEClass_R1);
		initEOperation(op, g1);

		op = initEOperation(getThen__OnRejected__Exception_Context(), this.getException(), "onRejected", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getException(), "reason", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(thenEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());

		initEClass(thenReferenceEClass, ThenReference.class, "ThenReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getThen());
		g2 = createEGenericType(thenReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(thenReferenceEClass_R1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(thenReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getThenReference_Target(), g1, null, "target", null, 0, 1, ThenReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executorEClass, Executor.class, "Executor", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(promiseEClass, Promise.class, "Promise", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPromise_Done(), ecorePackage.getEBoolean(), "done", null, 0, 1, Promise.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getPromise__Then__Then_Context_Executor(), null, "then", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "R1");
		g1 = createEGenericType(this.getThen());
		g2 = createEGenericType(promiseEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "then", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(promiseEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseEClass_C);
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = initEOperation(getPromise__GetFulfillmentValue__Context(), null, "getFulfillmentValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_R);
		initEOperation(op, g1);

		op = initEOperation(getPromise__GetRejectionReason__Context(), this.getException(), "getRejectionReason", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(promiseEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getPromise__GetState(), this.getPromiseState(), "getState", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(promiseReferenceEClass, PromiseReference.class, "PromiseReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(promiseReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(promiseReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getPromiseReference_Target(), g1, null, "target", null, 0, 1, PromiseReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allEClass, All.class, "All", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(allEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(allEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getAll_Promises(), g1, null, "promises", null, 0, 1, All.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAll__Init__EList_Executor(), null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(allEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(allEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "promises", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(allEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(anyEClass, Any.class, "Any", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(anyEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(anyEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getAny_Promises(), g1, null, "promises", null, 0, 1, Any.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getAny__Init__EList_Executor(), null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(anyEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(anyEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "promises", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(anyEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(commandEClass, Command.class, "Command", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getCommand__Execute__Context_Executor(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(commandEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(commandEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());
		g1 = createEGenericType(commandEClass_R);
		initEOperation(op, g1);

		initEClass(deferredEClass, Deferred.class, "Deferred", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeferred_State(), this.getPromiseState(), "state", null, 0, 1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeferred_Created(), ecorePackage.getEDate(), "created", null, 0, 1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeferred_Resolved(), ecorePackage.getEDate(), "resolved", null, 0, 1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeferred_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeferred_Resolution(), ecorePackage.getEObject(), null, "resolution", null, 0, 1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getThen());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(deferredEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getDeferred_Then(), g1, null, "then", null, 0, 1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getDeferred());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getDeferred_ThenDeferreds(), g1, null, "thenDeferreds", null, 0, -1, Deferred.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getDeferred__Resolve__Object_Context_Executor(), null, "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(deferredEClass_R);
		addEParameter(op, g1, "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(deferredEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDeferred__Resolve__Promise_Context_Executor(), null, "resolve", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getPromise());
		g2 = createEGenericType(deferredEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "promise", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(deferredEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getDeferred__Reject__Exception_Context_Executor(), null, "reject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getException(), "reason", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(deferredEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getExecutor());
		g2 = createEGenericType(deferredEClass_C);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "executor", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jobEClass, Job.class, "Job", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getCommand());
		g2 = createEGenericType(jobEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(jobEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getJob_Command(), g1, null, "command", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getDeferred());
		g2 = createEGenericType(jobEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(jobEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getJob_Deferred(), g1, null, "deferred", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Created(), ecorePackage.getEDate(), "created", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Started(), ecorePackage.getEDate(), "started", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Completed(), ecorePackage.getEDate(), "completed", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_Status(), this.getJobStatus(), "status", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_When(), ecorePackage.getEDate(), "when", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJob_FailureReason(), ecorePackage.getEString(), "failureReason", null, 0, 1, Job.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getJob__CanExecute(), ecorePackage.getEBoolean(), "canExecute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(jobQueueEClass, JobQueue.class, "JobQueue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getJob());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(jobQueueEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getJobQueue_Jobs(), g1, null, "jobs", null, 0, -1, JobQueue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invocableEClass, Invocable.class, "Invocable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getInvocable__Invoke__Context_EList(), null, "invoke", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(invocableEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "arguments", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());
		g1 = createEGenericType(invocableEClass_R);
		initEOperation(op, g1);

		op = initEOperation(getInvocable__Accept__Context_EList(), ecorePackage.getEBoolean(), "accept", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(invocableEClass_C);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "arguments", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getException());

		initEClass(invocableThenEClass, InvocableThen.class, "InvocableThen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getInvocable());
		g2 = createEGenericType(invocableThenEClass_R1);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(invocableThenEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getInvocableThen_OnFulfilled(), g1, null, "onFulfilled", null, 0, 1, InvocableThen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(this.getInvocable());
		g2 = createEGenericType(this.getException());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(invocableThenEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getInvocableThen_OnRejected(), g1, null, "onRejected", null, 0, 1, InvocableThen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invocableReferenceEClass, InvocableReference.class, "InvocableReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(this.getInvocable());
		g2 = createEGenericType(invocableReferenceEClass_R);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(invocableReferenceEClass_C);
		g1.getETypeArguments().add(g2);
		initEReference(getInvocableReference_Target(), g1, null, "target", null, 0, 1, InvocableReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boundInvocableEClass, BoundInvocable.class, "BoundInvocable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_Outputs(), this.getActionOutput(), null, "outputs", null, 0, -1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionOutputEClass, Map.Entry.class, "ActionOutput", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionOutput_Key(), ecorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionOutput_Value(), this.getInvocable(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dispatchEClass, Dispatch.class, "Dispatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDispatch_Targets(), this.getInvocable(), null, "targets", null, 0, -1, Dispatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(publishEClass, Publish.class, "Publish", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPublish_Targets(), this.getInvocable(), null, "targets", null, 0, -1, Publish.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deferredInvocationEClass, DeferredInvocation.class, "DeferredInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeferredInvocation_Arguments(), ecorePackage.getEObject(), null, "arguments", null, 0, -1, DeferredInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeferredInvocation_Result(), this.getDeferred(), null, "result", null, 0, 1, DeferredInvocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deferringInvocableEClass, DeferringInvocable.class, "DeferringInvocable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeferringInvocable_Target(), this.getInvocable(), null, "target", null, 0, 1, DeferringInvocable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeferringInvocable_Invocations(), this.getDeferredInvocation(), null, "invocations", null, 0, -1, DeferringInvocable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(promiseStateEEnum, PromiseState.class, "PromiseState");
		addEEnumLiteral(promiseStateEEnum, PromiseState.PENDING);
		addEEnumLiteral(promiseStateEEnum, PromiseState.FULFILLED);
		addEEnumLiteral(promiseStateEEnum, PromiseState.REJECTED);

		initEEnum(jobStatusEEnum, JobStatus.class, "JobStatus");
		addEEnumLiteral(jobStatusEEnum, JobStatus.PENDING);
		addEEnumLiteral(jobStatusEEnum, JobStatus.RUNNING);
		addEEnumLiteral(jobStatusEEnum, JobStatus.COMPLETED);
		addEEnumLiteral(jobStatusEEnum, JobStatus.FAILED);
		addEEnumLiteral(jobStatusEEnum, JobStatus.ROLLEDBACK);

		initEEnum(actionStateEEnum, ActionState.class, "ActionState");
		addEEnumLiteral(actionStateEEnum, ActionState.PASSIVE);
		addEEnumLiteral(actionStateEEnum, ActionState.ACTIVATING);
		addEEnumLiteral(actionStateEEnum, ActionState.ACTIVE);
		addEEnumLiteral(actionStateEEnum, ActionState.PASSIVATING);

		// Initialize data types
		initEDataType(contextEDataType, Context.class, "Context", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(cdoTransactionContextEDataType, CDOTransactionContext.class, "CDOTransactionContext", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //FlowPackageImpl
