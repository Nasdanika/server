/**
 */
package org.nasdanika.cdo.flow.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.cdo.flow.Dispatch;
import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Invocable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dispatch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.DispatchImpl#getTargets <em>Targets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchImpl extends CDOObjectImpl implements Dispatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DispatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.DISPATCH;
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
	public EList<Invocable> getTargets() {
		return (EList<Invocable>)eGet(FlowPackage.Literals.DISPATCH__TARGETS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public R invoke(C context, EList<Object> arguments) throws Exception {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean accept(C context, EList<Object> arguments) throws Exception {
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
			case FlowPackage.DISPATCH___INVOKE__CONTEXT_ELIST:
				try {
					return invoke((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case FlowPackage.DISPATCH___ACCEPT__CONTEXT_ELIST:
				try {
					return accept((C)arguments.get(0), (EList<Object>)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

} //DispatchImpl
