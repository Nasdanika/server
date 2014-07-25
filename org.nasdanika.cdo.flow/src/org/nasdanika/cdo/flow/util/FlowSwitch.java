/**
 */
package org.nasdanika.cdo.flow.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.nasdanika.cdo.flow.*;
import org.nasdanika.core.Adaptable;
import org.nasdanika.core.Component;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.flow.FlowPackage
 * @generated
 */
public class FlowSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FlowPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSwitch() {
		if (modelPackage == null) {
			modelPackage = FlowPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FlowPackage.REFERENCE: {
				Reference<?> reference = (Reference<?>)theEObject;
				T1 result = caseReference(reference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.THEN: {
				Then<?, ?, ?> then = (Then<?, ?, ?>)theEObject;
				T1 result = caseThen(then);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.THEN_REFERENCE: {
				ThenReference<?, ?, ?> thenReference = (ThenReference<?, ?, ?>)theEObject;
				T1 result = caseThenReference(thenReference);
				if (result == null) result = caseReference(thenReference);
				if (result == null) result = caseThen(thenReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.EXECUTOR: {
				Executor<?> executor = (Executor<?>)theEObject;
				T1 result = caseExecutor(executor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PROMISE: {
				Promise<?, ?> promise = (Promise<?, ?>)theEObject;
				T1 result = casePromise(promise);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PROMISE_REFERENCE: {
				PromiseReference<?, ?> promiseReference = (PromiseReference<?, ?>)theEObject;
				T1 result = casePromiseReference(promiseReference);
				if (result == null) result = casePromise(promiseReference);
				if (result == null) result = caseReference(promiseReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ALL: {
				All<?, ?> all = (All<?, ?>)theEObject;
				T1 result = caseAll(all);
				if (result == null) result = casePromise(all);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ANY: {
				Any<?, ?> any = (Any<?, ?>)theEObject;
				T1 result = caseAny(any);
				if (result == null) result = casePromise(any);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.COMMAND: {
				Command<?, ?> command = (Command<?, ?>)theEObject;
				T1 result = caseCommand(command);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DEFERRED: {
				Deferred<?, ?> deferred = (Deferred<?, ?>)theEObject;
				T1 result = caseDeferred(deferred);
				if (result == null) result = casePromise(deferred);
				if (result == null) result = caseCommand(deferred);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOB: {
				Job<?, ?> job = (Job<?, ?>)theEObject;
				T1 result = caseJob(job);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOB_QUEUE: {
				JobQueue<?> jobQueue = (JobQueue<?>)theEObject;
				T1 result = caseJobQueue(jobQueue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ACTUATOR: {
				Actuator<?> actuator = (Actuator<?>)theEObject;
				T1 result = caseActuator(actuator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ACTUATOR_REFERENCE: {
				ActuatorReference<?, ?> actuatorReference = (ActuatorReference<?, ?>)theEObject;
				T1 result = caseActuatorReference(actuatorReference);
				if (result == null) result = caseActuator(actuatorReference);
				if (result == null) result = caseReference(actuatorReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.INVOCABLE: {
				Invocable<?, ?> invocable = (Invocable<?, ?>)theEObject;
				T1 result = caseInvocable(invocable);
				if (result == null) result = caseActuator(invocable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.INVOCABLE_THEN: {
				InvocableThen<?, ?, ?> invocableThen = (InvocableThen<?, ?, ?>)theEObject;
				T1 result = caseInvocableThen(invocableThen);
				if (result == null) result = caseThen(invocableThen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.INVOCABLE_REFERENCE: {
				InvocableReference<?, ?> invocableReference = (InvocableReference<?, ?>)theEObject;
				T1 result = caseInvocableReference(invocableReference);
				if (result == null) result = caseInvocable(invocableReference);
				if (result == null) result = caseActuatorReference(invocableReference);
				if (result == null) result = caseActuator(invocableReference);
				if (result == null) result = caseReference(invocableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.BOUND_INVOCABLE: {
				BoundInvocable<?, ?> boundInvocable = (BoundInvocable<?, ?>)theEObject;
				T1 result = caseBoundInvocable(boundInvocable);
				if (result == null) result = caseInvocable(boundInvocable);
				if (result == null) result = caseActuator(boundInvocable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DEFERRING_INVOCABLE: {
				DeferringInvocable<?, ?> deferringInvocable = (DeferringInvocable<?, ?>)theEObject;
				T1 result = caseDeferringInvocable(deferringInvocable);
				if (result == null) result = caseInvocable(deferringInvocable);
				if (result == null) result = caseActuator(deferringInvocable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DEFERRED_INVOCATION: {
				DeferredInvocation<?, ?> deferredInvocation = (DeferredInvocation<?, ?>)theEObject;
				T1 result = caseDeferredInvocation(deferredInvocation);
				if (result == null) result = caseCommand(deferredInvocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PROPERTY: {
				Property<?> property = (Property<?>)theEObject;
				T1 result = caseProperty(property);
				if (result == null) result = caseActuator(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PROPERTY_REFERENCE: {
				PropertyReference<?> propertyReference = (PropertyReference<?>)theEObject;
				T1 result = casePropertyReference(propertyReference);
				if (result == null) result = caseProperty(propertyReference);
				if (result == null) result = caseActuatorReference(propertyReference);
				if (result == null) result = caseActuator(propertyReference);
				if (result == null) result = caseReference(propertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ACTION: {
				Action<?, ?> action = (Action<?, ?>)theEObject;
				T1 result = caseAction(action);
				if (result == null) result = caseInvocable(action);
				if (result == null) result = caseActuator(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JAVA_ACTION_DELEGATE: {
				JavaActionDelegate<?, ?> javaActionDelegate = (JavaActionDelegate<?, ?>)theEObject;
				T1 result = caseJavaActionDelegate(javaActionDelegate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PROPERTY_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, EObject> propertyEntry = (Map.Entry<String, EObject>)theEObject;
				T1 result = casePropertyEntry(propertyEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JAVA_ACTION: {
				JavaAction<?, ?> javaAction = (JavaAction<?, ?>)theEObject;
				T1 result = caseJavaAction(javaAction);
				if (result == null) result = caseAction(javaAction);
				if (result == null) result = caseInvocable(javaAction);
				if (result == null) result = caseActuator(javaAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ACTION_OUTPUT_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, Actuator<?>> actionOutputEntry = (Map.Entry<String, Actuator<?>>)theEObject;
				T1 result = caseActionOutputEntry(actionOutputEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ERROR_HANDLER_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, Invocable<?, ?>> errorHandlerEntry = (Map.Entry<String, Invocable<?, ?>>)theEObject;
				T1 result = caseErrorHandlerEntry(errorHandlerEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.DISPATCH: {
				Dispatch<?, ?> dispatch = (Dispatch<?, ?>)theEObject;
				T1 result = caseDispatch(dispatch);
				if (result == null) result = caseInvocable(dispatch);
				if (result == null) result = caseActuator(dispatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.PUBLISH: {
				Publish<?, ?> publish = (Publish<?, ?>)theEObject;
				T1 result = casePublish(publish);
				if (result == null) result = caseInvocable(publish);
				if (result == null) result = caseActuator(publish);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.ADAPTABLE: {
				Adaptable adaptable = (Adaptable)theEObject;
				T1 result = caseAdaptable(adaptable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.FLOW: {
				Flow<?> flow = (Flow<?>)theEObject;
				T1 result = caseFlow(flow);
				if (result == null) result = caseJobQueue(flow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.FLOW_INPUT_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, Actuator<?>> flowInputEntry = (Map.Entry<String, Actuator<?>>)theEObject;
				T1 result = caseFlowInputEntry(flowInputEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.FLOW_OUTPUT_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, ActuatorReference<?, ?>> flowOutputEntry = (Map.Entry<String, ActuatorReference<?, ?>>)theEObject;
				T1 result = caseFlowOutputEntry(flowOutputEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOIN_ELEMENT: {
				JoinElement<?, ?> joinElement = (JoinElement<?, ?>)theEObject;
				T1 result = caseJoinElement(joinElement);
				if (result == null) result = caseDeferredInvocation(joinElement);
				if (result == null) result = caseCommand(joinElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOIN_INPUT: {
				JoinInput<?, ?> joinInput = (JoinInput<?, ?>)theEObject;
				T1 result = caseJoinInput(joinInput);
				if (result == null) result = caseInvocable(joinInput);
				if (result == null) result = caseActuator(joinInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOIN_INPUT_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<?> joinInputEntry = (Map.Entry<?>)theEObject;
				T1 result = caseJoinInputEntry(joinInputEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.JOIN: {
				Join<?> join = (Join<?>)theEObject;
				T1 result = caseJoin(join);
				if (result == null) result = caseJobQueue(join);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.VALUE_PROPERTY: {
				ValueProperty<?> valueProperty = (ValueProperty<?>)theEObject;
				T1 result = caseValueProperty(valueProperty);
				if (result == null) result = caseProperty(valueProperty);
				if (result == null) result = caseActuator(valueProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T1 result = caseComponent(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FlowPackage.SERVICE_REFERENCE: {
				ServiceReference<?> serviceReference = (ServiceReference<?>)theEObject;
				T1 result = caseServiceReference(serviceReference);
				if (result == null) result = caseProperty(serviceReference);
				if (result == null) result = caseComponent(serviceReference);
				if (result == null) result = caseActuator(serviceReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseReference(Reference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Then</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Then</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, R1, C extends Context> T1 caseThen(Then<R, R1, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Then Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Then Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, R1, C extends Context> T1 caseThenReference(ThenReference<R, R1, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Promise</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Promise</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 casePromise(Promise<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Promise Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Promise Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 casePromiseReference(PromiseReference<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseAll(All<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseAny(Any<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseCommand(Command<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Executor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Executor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T1 caseExecutor(Executor<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferred</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferred</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseDeferred(Deferred<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Job</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Job</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseJob(Job<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Job Queue</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Job Queue</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T1 caseJobQueue(JobQueue<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actuator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actuator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseActuator(Actuator<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Actuator Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actuator Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T, A extends Actuator<T>> T1 caseActuatorReference(ActuatorReference<T, A> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseInvocable(Invocable<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocable Then</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocable Then</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, R1, C extends Context> T1 caseInvocableThen(InvocableThen<R, R1, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invocable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invocable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseInvocableReference(InvocableReference<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bound Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bound Invocable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseBoundInvocable(BoundInvocable<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseAction(Action<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Action Delegate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Action Delegate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseJavaActionDelegate(JavaActionDelegate<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePropertyEntry(Map.Entry<String, EObject> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseJavaAction(JavaAction<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Output Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Output Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseActionOutputEntry(Map.Entry<String, Actuator<?>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error Handler Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error Handler Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseErrorHandlerEntry(Map.Entry<String, Invocable<?, ?>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dispatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dispatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseDispatch(Dispatch<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 casePublish(Publish<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Adaptable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Adaptable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAdaptable(Adaptable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T1 caseFlow(Flow<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFlowInputEntry(Map.Entry<String, Actuator<?>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFlowOutputEntry(Map.Entry<String, ActuatorReference<?, ?>> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseJoinElement(JoinElement<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseJoinInput(JoinInput<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join Input Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join Input Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T1 caseJoinInputEntry(Map.Entry<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <C extends Context> T1 caseJoin(Join<C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseValueProperty(ValueProperty<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseServiceReference(ServiceReference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferred Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferred Invocation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseDeferredInvocation(DeferredInvocation<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseProperty(Property<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 casePropertyReference(PropertyReference<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deferring Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deferring Invocable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <R, C extends Context> T1 caseDeferringInvocable(DeferringInvocable<R, C> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

} //FlowSwitch
