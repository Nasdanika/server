/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.flow.Command;
import org.nasdanika.cdo.flow.Deferred;
import org.nasdanika.cdo.flow.Executor;
import org.nasdanika.cdo.flow.FlowFactory;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Promise;
import org.nasdanika.cdo.flow.PromiseState;
import org.nasdanika.cdo.flow.Then;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;
import org.nasdanika.core.NasdanikaException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Promise</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#isDone <em>Done</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getState <em>State</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getCreated <em>Created</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getResolved <em>Resolved</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getResolution <em>Resolution</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getThen <em>Then</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredImpl#getThenDeferreds <em>Then Deferreds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeferredImpl<R, C extends Context> extends CDOObjectImpl implements Deferred<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeferredImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.DEFERRED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDone() {
		return (Boolean)eGet(FlowPackage.Literals.PROMISE__DONE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDone(boolean newDone) {
		eSet(FlowPackage.Literals.PROMISE__DONE, newDone);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PromiseState getState() {
		return (PromiseState)eGet(FlowPackage.Literals.DEFERRED__STATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(PromiseState newState) {
		eSet(FlowPackage.Literals.DEFERRED__STATE, newState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreated() {
		return (Date)eGet(FlowPackage.Literals.DEFERRED__CREATED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreated(Date newCreated) {
		eSet(FlowPackage.Literals.DEFERRED__CREATED, newCreated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getResolved() {
		return (Date)eGet(FlowPackage.Literals.DEFERRED__RESOLVED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolved(Date newResolved) {
		eSet(FlowPackage.Literals.DEFERRED__RESOLVED, newResolved);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return (String)eGet(FlowPackage.Literals.DEFERRED__COMMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		eSet(FlowPackage.Literals.DEFERRED__COMMENT, newComment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getResolution() {
		return (EObject)eGet(FlowPackage.Literals.DEFERRED__RESOLUTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolution(EObject newResolution) {
		eSet(FlowPackage.Literals.DEFERRED__RESOLUTION, newResolution);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Then<Object, R, C> getThen() {
		return (Then<Object, R, C>)eGet(FlowPackage.Literals.DEFERRED__THEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThen(Then<Object, R, C> newThen) {
		eSet(FlowPackage.Literals.DEFERRED__THEN, newThen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Deferred<?, C>> getThenDeferreds() {
		return (EList<Deferred<?, C>>)eGet(FlowPackage.Literals.DEFERRED__THEN_DEFERREDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void resolve(R value, C context, Executor<C> executor) {
		if (!PromiseState.PENDING.equals(getState())) {
			throw new IllegalStateException("Promise is already "+getState());
		}		
		if (getResolution()!=null) {
			throw new IllegalStateException("Resolution already set");
		}
		ConverterContext converterContext = context.adapt(ConverterContext.class);
		try {
			CDOObject cdoValue = converterContext.convert(value, CDOObject.class);
			if (value!=null && cdoValue==null) {
				setResolution(converterContext.convert(
						new NasdanikaException("Could not convert "+value+" to CDOObject for storing in repository"),
						CDOObject.class));
				setState(PromiseState.REJECTED);
			} else {
				setResolution(cdoValue);
				setState(PromiseState.FULFILLED);
			}
		} catch (Exception e) {
			try {
				setResolution(converterContext.convert(e, CDOObject.class));
				setState(PromiseState.REJECTED);
			} catch (Exception e1) {
				throw new NasdanikaException(e1);
			}
		}
		
		for (Deferred<?, C> d: getThenDeferreds()) {
			executor.post(d);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void resolve(Promise<R, C> promise, C context, Executor<C> executor) {
		switch (promise.getState()) {
		case FULFILLED:
			resolve(promise.getFulfillmentValue(context), context, executor);
			break;
		case PENDING:
			((Deferred<R,C>) promise).getThenDeferreds().add(this);
			break;
		case REJECTED:
			reject(promise.getRejectionReason(context), context, executor);
			break;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void reject(Exception reason, C context, Executor<C> executor) {
		if (!PromiseState.PENDING.equals(getState())) {
			throw new IllegalStateException("Promise is already "+getState());
		}		
		if (getResolution()!=null) {
			throw new IllegalStateException("Resolution already set");
		}
		ConverterContext converterContext = context.adapt(ConverterContext.class);
		try {
			CDOObject cdoValue = converterContext.convert(reason, CDOObject.class);
			setResolution(cdoValue);
			setState(PromiseState.REJECTED);
		} catch (Exception e) {
			throw new NasdanikaException(e);
		}
		
		for (Deferred<?, C> d: getThenDeferreds()) {
			executor.post(d);
		}
		
		if (isDone()) {
			logger.log(Level.SEVERE, "Deferred rejected: "+reason, reason);
		}
	}
	
	private static Logger logger = Logger.getLogger(DeferredImpl.class.getName());

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Object execute(C context, Executor<C> executor) throws Exception {
		// This method is invoked in a new transaction after containing deferred is resolved
		// The method invokes Then, if present, and resolves this deferred to then return value.
		if (eContainer() instanceof Promise) {
			@SuppressWarnings("unchecked")
			Promise<?, C> containingPromise = (Promise<?, C>) eContainer();
			switch (containingPromise.getState()) {
			case FULFILLED:
				if (getThen()==null) {
					resolve((R) containingPromise.getFulfillmentValue(context), context, executor);
				} else {
					resolve(
							getThen().onFulfilled(containingPromise.getFulfillmentValue(context), context), 
							context, 
							executor);
				}				
				return null;
			case PENDING:
				throw new IllegalStateException("Containing promise is in PENDING state");
			case REJECTED:
				if (getThen()==null) {
					reject(containingPromise.getRejectionReason(context), context, executor);
				} else {
					reject(
							getThen().onRejected(containingPromise.getRejectionReason(context), context), 
							context, 
							executor);
				}				
				return null;
			default:
				throw new IllegalArgumentException("Unexpected promise state: "+containingPromise.getState());
			}
		}
		
		throw new IllegalStateException("Deferred shall be executed as a command only when it is contained in a fulfilled or rejected promise");
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public R getFulfillmentValue(C context) {
		if (PromiseState.FULFILLED.equals(getState())) {
			EObject val = getResolution();
			return (R) (val instanceof Box ? ((Box<?,C>) val).get(context) : val);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Exception getRejectionReason(C context) {
		if (PromiseState.REJECTED.equals(getState())) {
			EObject reason = getResolution();
			return (Exception) (reason instanceof Box ? ((Box<?,C>) reason).get(context) : reason);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public <R1> Promise<R1, C> then(Then<R, R1, C> then, C context, Executor<C> executor) {
		Deferred<R1, C> ret = FlowFactory.eINSTANCE.createDeferred();
		ret.setThen((Then<Object, R1, C>) then);
		getThenDeferreds().add(ret);
		switch (getState()) {
		case PENDING:
			// Nothing
			break;
		case FULFILLED:
		case REJECTED:
			executor.post(ret);
			break;
		}
		return ret;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Command.class) {
			switch (baseOperationID) {
				case FlowPackage.COMMAND___EXECUTE__CONTEXT_EXECUTOR: return FlowPackage.DEFERRED___EXECUTE__CONTEXT_EXECUTOR;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings({"rawtypes", "unchecked" })
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlowPackage.DEFERRED___RESOLVE__OBJECT_CONTEXT_EXECUTOR:
				resolve((R)arguments.get(0), (C)arguments.get(1), (Executor<C>)arguments.get(2));
				return null;
			case FlowPackage.DEFERRED___RESOLVE__PROMISE_CONTEXT_EXECUTOR:
				resolve((Promise<R, C>)arguments.get(0), (C)arguments.get(1), (Executor<C>)arguments.get(2));
				return null;
			case FlowPackage.DEFERRED___REJECT__EXCEPTION_CONTEXT_EXECUTOR:
				reject((Exception)arguments.get(0), (C)arguments.get(1), (Executor<C>)arguments.get(2));
				return null;
			case FlowPackage.DEFERRED___EXECUTE__CONTEXT_EXECUTOR:
				try {
					return execute((C)arguments.get(0), (Executor<C>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.DEFERRED___THEN__THEN_CONTEXT_EXECUTOR:
				return then((Then)arguments.get(0), (C)arguments.get(1), (Executor<C>)arguments.get(2));
			case FlowPackage.DEFERRED___GET_FULFILLMENT_VALUE__CONTEXT:
				return getFulfillmentValue((C)arguments.get(0));
			case FlowPackage.DEFERRED___GET_REJECTION_REASON__CONTEXT:
				return getRejectionReason((C)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //PromiseImpl
