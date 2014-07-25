/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.boxing.Box;
import org.nasdanika.cdo.flow.BoundInvocable;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;
import org.nasdanika.core.Context;
import org.nasdanika.core.ConverterContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bound Invocable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.BoundInvocableImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.nasdanika.cdo.flow.impl.BoundInvocableImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BoundInvocableImpl<R, C extends Context> extends CDOObjectImpl implements BoundInvocable<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundInvocableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.BOUND_INVOCABLE;
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
	public EList<EObject> getBindings() {
		return (EList<EObject>)eGet(FlowPackage.Literals.BOUND_INVOCABLE__BINDINGS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invocable<R, C> getTarget() {
		return (Invocable<R, C>)eGet(FlowPackage.Literals.BOUND_INVOCABLE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Invocable<R, C> newTarget) {
		eSet(FlowPackage.Literals.BOUND_INVOCABLE__TARGET, newTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @generated NOT
	 */
	public void bind(C context, EList<Object> arguments) throws Exception {
		ConverterContext cc = context.adapt(ConverterContext.class);
		for (Object a: arguments) {
			getBindings().add(cc.convert(a, CDOObject.class));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public R invoke(C context, EList<Object> arguments) throws Exception {
		return getTarget().invoke(context, mergeArguments(context, arguments));
	}

	@SuppressWarnings("unchecked")
	private EList<Object> mergeArguments(C context, EList<Object> arguments) {
		EList<Object> args = new BasicEList<Object>();
		for (EObject b: getBindings()) {
			if (b instanceof Box) {
				args.add(((Box<?,C>) b).get(context));
			} else {
				args.add(b);
			}
		}
		if (arguments!=null) {
			args.addAll(arguments);
		}
		return args;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean accept(C context, EList<Object> arguments) throws Exception {
		return getTarget().accept(context, mergeArguments(context, arguments));
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
			case FlowPackage.BOUND_INVOCABLE___BIND__CONTEXT_ELIST:
				try {
					bind((C)arguments.get(0), (EList<Object>)arguments.get(1));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.BOUND_INVOCABLE___INVOKE__CONTEXT_ELIST:
				try {
					return invoke((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.BOUND_INVOCABLE___ACCEPT__CONTEXT_ELIST:
				try {
					return accept((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //BoundInvocableImpl
