/**
 */
package org.nasdanika.codegen.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.ContextProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ContextProviderImpl extends ConfigurableImpl implements ContextProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextProviderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.CONTEXT_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext(Context parent, boolean withContainer) {
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodegenPackage.CONTEXT_PROVIDER___CREATE_CONTEXT__CONTEXT_BOOLEAN:
				return createContext((Context)arguments.get(0), (Boolean)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ContextProviderImpl
