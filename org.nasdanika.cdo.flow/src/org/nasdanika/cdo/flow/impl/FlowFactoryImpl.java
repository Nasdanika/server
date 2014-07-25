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
			case FlowPackage.PROMISE_REFERENCE: return (EObject)createPromiseReference();
			case FlowPackage.ALL: return (EObject)createAll();
			case FlowPackage.ANY: return (EObject)createAny();
			case FlowPackage.DEFERRED: return (EObject)createDeferred();
			case FlowPackage.JOB: return (EObject)createJob();
			case FlowPackage.INVOCABLE_THEN: return (EObject)createInvocableThen();
			case FlowPackage.INVOCABLE_REFERENCE: return (EObject)createInvocableReference();
			case FlowPackage.BOUND_INVOCABLE: return (EObject)createBoundInvocable();
			case FlowPackage.DEFERRING_INVOCABLE: return (EObject)createDeferringInvocable();
			case FlowPackage.DEFERRED_INVOCATION: return (EObject)createDeferredInvocation();
			case FlowPackage.PROPERTY_REFERENCE: return (EObject)createPropertyReference();
			case FlowPackage.PROPERTY_ENTRY: return (EObject)createPropertyEntry();
			case FlowPackage.JAVA_ACTION: return (EObject)createJavaAction();
			case FlowPackage.ACTION_OUTPUT_ENTRY: return (EObject)createActionOutputEntry();
			case FlowPackage.ERROR_HANDLER_ENTRY: return (EObject)createErrorHandlerEntry();
			case FlowPackage.DISPATCH: return (EObject)createDispatch();
			case FlowPackage.PUBLISH: return (EObject)createPublish();
			case FlowPackage.FLOW: return (EObject)createFlow();
			case FlowPackage.FLOW_INPUT_ENTRY: return (EObject)createFlowInputEntry();
			case FlowPackage.FLOW_OUTPUT_ENTRY: return (EObject)createFlowOutputEntry();
			case FlowPackage.JOIN_ELEMENT: return (EObject)createJoinElement();
			case FlowPackage.JOIN_INPUT: return (EObject)createJoinInput();
			case FlowPackage.JOIN_INPUT_ENTRY: return (EObject)createJoinInputEntry();
			case FlowPackage.JOIN: return (EObject)createJoin();
			case FlowPackage.VALUE_PROPERTY: return (EObject)createValueProperty();
			case FlowPackage.SERVICE_REFERENCE: return (EObject)createServiceReference();
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
	public <R, C extends Context> PromiseReference<R, C> createPromiseReference() {
		PromiseReferenceImpl<R, C> promiseReference = new PromiseReferenceImpl<R, C>();
		return promiseReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> All<R, C> createAll() {
		AllImpl<R, C> all = new AllImpl<R, C>();
		return all;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> Any<R, C> createAny() {
		AnyImpl<R, C> any = new AnyImpl<R, C>();
		return any;
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
	public <R, R1, C extends Context> InvocableThen<R, R1, C> createInvocableThen() {
		InvocableThenImpl<R, R1, C> invocableThen = new InvocableThenImpl<R, R1, C>();
		return invocableThen;
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
	public <R, C extends Context> BoundInvocable<R, C> createBoundInvocable() {
		BoundInvocableImpl<R, C> boundInvocable = new BoundInvocableImpl<R, C>();
		return boundInvocable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> Dispatch<R, C> createDispatch() {
		DispatchImpl<R, C> dispatch = new DispatchImpl<R, C>();
		return dispatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> Publish<R, C> createPublish() {
		PublishImpl<R, C> publish = new PublishImpl<R, C>();
		return publish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C extends Context> Flow<C> createFlow() {
		FlowImpl<C> flow = new FlowImpl<C>();
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Actuator<?>> createFlowInputEntry() {
		FlowInputEntryImpl flowInputEntry = new FlowInputEntryImpl();
		return flowInputEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, ActuatorReference<?, ?>> createFlowOutputEntry() {
		FlowOutputEntryImpl flowOutputEntry = new FlowOutputEntryImpl();
		return flowOutputEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> JoinElement<R, C> createJoinElement() {
		JoinElementImpl<R, C> joinElement = new JoinElementImpl<R, C>();
		return joinElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> JoinInput<R, C> createJoinInput() {
		JoinInputImpl<R, C> joinInput = new JoinInputImpl<R, C>();
		return joinInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("rawtypes")
	public <C extends Context> Map.Entry createJoinInputEntry() {
		JoinInputEntryImpl<C> joinInputEntry = new JoinInputEntryImpl<C>();
		return joinInputEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <C extends Context> Join<C> createJoin() {
		JoinImpl<C> join = new JoinImpl<C>();
		return join;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ValueProperty<T> createValueProperty() {
		ValuePropertyImpl<T> valueProperty = new ValuePropertyImpl<T>();
		return valueProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ServiceReference<T> createServiceReference() {
		ServiceReferenceImpl<T> serviceReference = new ServiceReferenceImpl<T>();
		return serviceReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> DeferredInvocation<R, C> createDeferredInvocation() {
		DeferredInvocationImpl<R, C> deferredInvocation = new DeferredInvocationImpl<R, C>();
		return deferredInvocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> PropertyReference<T> createPropertyReference() {
		PropertyReferenceImpl<T> propertyReference = new PropertyReferenceImpl<T>();
		return propertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, EObject> createPropertyEntry() {
		PropertyEntryImpl propertyEntry = new PropertyEntryImpl();
		return propertyEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> JavaAction<R, C> createJavaAction() {
		JavaActionImpl<R, C> javaAction = new JavaActionImpl<R, C>();
		return javaAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Actuator<?>> createActionOutputEntry() {
		ActionOutputEntryImpl actionOutputEntry = new ActionOutputEntryImpl();
		return actionOutputEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Invocable<?, ?>> createErrorHandlerEntry() {
		ErrorHandlerEntryImpl errorHandlerEntry = new ErrorHandlerEntryImpl();
		return errorHandlerEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <R, C extends Context> DeferringInvocable<R, C> createDeferringInvocable() {
		DeferringInvocableImpl<R, C> deferringInvocable = new DeferringInvocableImpl<R, C>();
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
