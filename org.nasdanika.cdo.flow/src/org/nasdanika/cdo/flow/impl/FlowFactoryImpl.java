/**
 */
package org.nasdanika.cdo.flow.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.flow.*;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FlowFactoryImpl extends EFactoryImpl implements FlowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FlowFactory init() {
		try {
			FlowFactory theFlowFactory = (FlowFactory)EPackage.Registry.INSTANCE.getEFactory(FlowPackage.eNS_URI);
			if (theFlowFactory != null) {
				return theFlowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FlowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FlowPackage.THEN_REFERENCE: return (EObject)createThenReference();
			case FlowPackage.DEFERRED: return (EObject)createDeferred();
			case FlowPackage.JOB: return (EObject)createJob();
			case FlowPackage.JOB_QUEUE: return (EObject)createJobQueue();
			case FlowPackage.INVOCABLE_REFERENCE: return (EObject)createInvocableReference();
			case FlowPackage.ACTION_OUTPUT: return (EObject)createActionOutput();
			case FlowPackage.DISPATCH: return (EObject)createDispatch();
			case FlowPackage.PUBLISH: return (EObject)createPublish();
			case FlowPackage.DEFERRED_INVOCATION: return (EObject)createDeferredInvocation();
			case FlowPackage.DEFERRING_INVOCABLE: return (EObject)createDeferringInvocable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FlowPackage.PROMISE_STATE:
				return createPromiseStateFromString(eDataType, initialValue);
			case FlowPackage.JOB_STATUS:
				return createJobStatusFromString(eDataType, initialValue);
			case FlowPackage.ACTION_STATE:
				return createActionStateFromString(eDataType, initialValue);
			case FlowPackage.EXCEPTION:
				return createExceptionFromString(eDataType, initialValue);
			case FlowPackage.CDO_TRANSACTION_CONTEXT:
				return createCDOTransactionContextFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FlowPackage.PROMISE_STATE:
				return convertPromiseStateToString(eDataType, instanceValue);
			case FlowPackage.JOB_STATUS:
				return convertJobStatusToString(eDataType, instanceValue);
			case FlowPackage.ACTION_STATE:
				return convertActionStateToString(eDataType, instanceValue);
			case FlowPackage.EXCEPTION:
				return convertExceptionToString(eDataType, instanceValue);
			case FlowPackage.CDO_TRANSACTION_CONTEXT:
				return convertCDOTransactionContextToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, R1, C extends Context> ThenReference<R, R1, C> createThenReference() {
		ThenReferenceImpl<R, R1, C> thenReference = new ThenReferenceImpl<R, R1, C>();
		return thenReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> Deferred<R, C> createDeferred() {
		DeferredImpl<R, C> deferred = new DeferredImpl<R, C>();
		return deferred;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> Job<R, C> createJob() {
		JobImpl<R, C> job = new JobImpl<R, C>();
		return job;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C extends Context> JobQueue<C> createJobQueue() {
		JobQueueImpl<C> jobQueue = new JobQueueImpl<C>();
		return jobQueue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> InvocableReference<R, C> createInvocableReference() {
		InvocableReferenceImpl<R, C> invocableReference = new InvocableReferenceImpl<R, C>();
		return invocableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Invocable> createActionOutput() {
		ActionOutputImpl actionOutput = new ActionOutputImpl();
		return actionOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dispatch createDispatch() {
		DispatchImpl dispatch = new DispatchImpl();
		return dispatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publish createPublish() {
		PublishImpl publish = new PublishImpl();
		return publish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeferredInvocation createDeferredInvocation() {
		DeferredInvocationImpl deferredInvocation = new DeferredInvocationImpl();
		return deferredInvocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeferringInvocable createDeferringInvocable() {
		DeferringInvocableImpl deferringInvocable = new DeferringInvocableImpl();
		return deferringInvocable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseState createPromiseStateFromString(EDataType eDataType, String initialValue) {
		PromiseState result = PromiseState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPromiseStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobStatus createJobStatusFromString(EDataType eDataType, String initialValue) {
		JobStatus result = JobStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJobStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionState createActionStateFromString(EDataType eDataType, String initialValue) {
		ActionState result = ActionState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActionStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception createExceptionFromString(EDataType eDataType, String initialValue) {
		return (Exception)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CDOTransactionContext createCDOTransactionContextFromString(EDataType eDataType, String initialValue) {
		return (CDOTransactionContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCDOTransactionContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowPackage getFlowPackage() {
		return (FlowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FlowPackage getPackage() {
		return FlowPackage.eINSTANCE;
	}

} //FlowFactoryImpl
