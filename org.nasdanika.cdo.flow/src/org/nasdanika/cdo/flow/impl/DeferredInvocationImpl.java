/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.flow.DeferredInvocation;
import org.nasdanika.cdo.flow.DeferringInvocable;
import org.nasdanika.cdo.flow.Executor;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;
import org.nasdanika.cdo.flow.Promise;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deferred Invocation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredInvocationImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DeferredInvocationImpl#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeferredInvocationImpl<R, C extends Context> extends CDOObjectImpl implements DeferredInvocation<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeferredInvocationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.DEFERRED_INVOCATION;
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
	@SuppressWarnings("unchecked")
	public EList<EObject> getArguments() {
		return (EList<EObject>)eGet(FlowPackage.Literals.DEFERRED_INVOCATION__ARGUMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Promise<R, C> getResult() {
		return (Promise<R, C>)eGet(FlowPackage.Literals.DEFERRED_INVOCATION__RESULT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Promise<R, C> newResult) {
		eSet(FlowPackage.Literals.DEFERRED_INVOCATION__RESULT, newResult);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public R execute(C context, Executor<C> executor) throws Exception {
		Invocable<R, Context> target = ((DeferringInvocable<R, Context>) eContainer()).getTarget();
		EList<Object> args = new BasicEList<Object>();
		for (EObject b: getArguments()) {
			if (b instanceof Box) {
				args.add(((Box<?,C>) b).get(context));
			} else {
				args.add(b);
			}
		}
		return target.invoke(context, args);
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
			case FlowPackage.DEFERRED_INVOCATION___EXECUTE__CONTEXT_EXECUTOR:
				try {
					return execute((C)arguments.get(0), (Executor<C>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //DeferredInvocationImpl
