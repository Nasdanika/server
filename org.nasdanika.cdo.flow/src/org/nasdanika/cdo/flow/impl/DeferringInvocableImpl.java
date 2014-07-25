/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.flow.DeferredInvocation;
import org.nasdanika.cdo.flow.DeferringInvocable;
import org.nasdanika.cdo.flow.Executor;
import org.nasdanika.cdo.flow.FlowFactory;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;
import org.nasdanika.cdo.flow.Promise;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deferring Invocable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferringInvocableImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferringInvocableImpl#getInvocations <em>Invocations</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferringInvocableImpl#getDelay <em>Delay</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeferringInvocableImpl<R, C extends Context> extends CDOObjectImpl implements DeferringInvocable<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeferringInvocableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.DEFERRING_INVOCABLE;
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
	public Invocable<R, C> getTarget() {
		return (Invocable<R, C>)eGet(FlowPackage.Literals.DEFERRING_INVOCABLE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Invocable<R, C> newTarget) {
		eSet(FlowPackage.Literals.DEFERRING_INVOCABLE__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<DeferredInvocation<R, C>> getInvocations() {
		return (EList<DeferredInvocation<R, C>>)eGet(FlowPackage.Literals.DEFERRING_INVOCABLE__INVOCATIONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDelay() {
		return (Long)eGet(FlowPackage.Literals.DEFERRING_INVOCABLE__DELAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelay(long newDelay) {
		eSet(FlowPackage.Literals.DEFERRING_INVOCABLE__DELAY, newDelay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public Promise<R, C> invoke(C context, EList<Object> arguments) throws Exception {
		DeferredInvocation<R, C> di = FlowFactory.eINSTANCE.createDeferredInvocation();
		getInvocations().add(di);
		ConverterContext cc = context.adapt(ConverterContext.class);
		for (Object a: arguments) {
			di.getArguments().add(cc.convert(a, CDOObject.class));
		}
		Promise<R,C> ret = context.adapt(Executor.class).submit(di, getDelay()>0 ? new Date(System.currentTimeMillis()+getDelay()) : null);
		di.setResult(ret);
		return ret; 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean accept(C context, EList<Object> arguments) throws Exception {
		// Invoked in the same transaction
		return getTarget().accept(context, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case FlowPackage.DEFERRING_INVOCABLE___INVOKE__CONTEXT_ELIST:
				try {
					return invoke((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.DEFERRING_INVOCABLE___ACCEPT__CONTEXT_ELIST:
				try {
					return accept((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //DeferringInvocableImpl
