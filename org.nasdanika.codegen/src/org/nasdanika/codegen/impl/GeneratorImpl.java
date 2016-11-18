/**
 */
package org.nasdanika.codegen.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configurable;
import org.nasdanika.codegen.ConfigurationItem;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.ContextProvider;
import org.nasdanika.codegen.Generator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getPropertiesReferences <em>Properties References</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getDefaultPropertiesReferences <em>Default Properties References</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GeneratorImpl<T> extends CDOObjectImpl implements Generator<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.GENERATOR;
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
	public EList<String> getPropertiesReferences() {
		return (EList<String>)eGet(CodegenPackage.Literals.CONFIGURABLE__PROPERTIES_REFERENCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConfigurationItem<Object>> getConfiguration() {
		return (EList<ConfigurationItem<Object>>)eGet(CodegenPackage.Literals.CONFIGURABLE__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getDefaultPropertiesReferences() {
		return (EList<String>)eGet(CodegenPackage.Literals.CONFIGURABLE__DEFAULT_PROPERTIES_REFERENCES, true);
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
	public Context createContext(Context parent) {
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Configurable.class) {
			switch (derivedFeatureID) {
				case CodegenPackage.GENERATOR__PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURABLE__PROPERTIES_REFERENCES;
				case CodegenPackage.GENERATOR__CONFIGURATION: return CodegenPackage.CONFIGURABLE__CONFIGURATION;
				case CodegenPackage.GENERATOR__DEFAULT_PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURABLE__DEFAULT_PROPERTIES_REFERENCES;
				default: return -1;
			}
		}
		if (baseClass == ContextProvider.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Configurable.class) {
			switch (baseFeatureID) {
				case CodegenPackage.CONFIGURABLE__PROPERTIES_REFERENCES: return CodegenPackage.GENERATOR__PROPERTIES_REFERENCES;
				case CodegenPackage.CONFIGURABLE__CONFIGURATION: return CodegenPackage.GENERATOR__CONFIGURATION;
				case CodegenPackage.CONFIGURABLE__DEFAULT_PROPERTIES_REFERENCES: return CodegenPackage.GENERATOR__DEFAULT_PROPERTIES_REFERENCES;
				default: return -1;
			}
		}
		if (baseClass == ContextProvider.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == Configurable.class) {
			switch (baseOperationID) {
				case CodegenPackage.CONFIGURABLE___CREATE_CONTEXT__CONTEXT: return CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT;
				default: return -1;
			}
		}
		if (baseClass == ContextProvider.class) {
			switch (baseOperationID) {
				case CodegenPackage.CONTEXT_PROVIDER___CREATE_CONTEXT__CONTEXT_BOOLEAN: return CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT_BOOLEAN:
				return createContext((Context)arguments.get(0), (Boolean)arguments.get(1));
			case CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT:
				return createContext((Context)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

} //GeneratorImpl
