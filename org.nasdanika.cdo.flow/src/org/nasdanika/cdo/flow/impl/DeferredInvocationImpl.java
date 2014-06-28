/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.flow.Deferred;
import org.nasdanika.cdo.flow.DeferredInvocation;
import org.nasdanika.cdo.flow.FlowPackage;

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
public class DeferredInvocationImpl extends CDOObjectImpl implements DeferredInvocation {
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
	public Deferred getResult() {
		return (Deferred)eGet(FlowPackage.Literals.DEFERRED_INVOCATION__RESULT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(Deferred newResult) {
		eSet(FlowPackage.Literals.DEFERRED_INVOCATION__RESULT, newResult);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R execute(C context) throws Exception {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case FlowPackage.DEFERRED_INVOCATION___EXECUTE__CONTEXT:
				try {
					return execute((C)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //DeferredInvocationImpl
