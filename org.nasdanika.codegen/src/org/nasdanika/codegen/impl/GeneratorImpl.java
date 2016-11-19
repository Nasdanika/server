/**
 */
package org.nasdanika.codegen.impl;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.codehaus.janino.ScriptEvaluator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configurable;
import org.nasdanika.codegen.ConfigurationItem;
import org.nasdanika.codegen.Context;
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
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getIterator <em>Iterator</em>}</li>
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
	public String getIterator() {
		return (String)eGet(CodegenPackage.Literals.GENERATOR__ITERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(String newIterator) {
		eSet(CodegenPackage.Literals.GENERATOR__ITERATOR, newIterator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Context createContext(Context parent) throws Exception {
		return Generator.super.createContext(parent);
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
			case CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT:
				try {
					return createContext((Context)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}
	
	/**
	 * Creates iterable by evaluating iterator.
	 * @param context
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Iterable<Context> iterate(Context context) throws Exception {
		String iterator = getIterator();
		if (iterator == null || iterator.trim().length() == 0) {
			return Collections.singleton(context);
		}
		
		ScriptEvaluator se = new ScriptEvaluator(iterator);
		se.setReturnType(Object.class);
		se.setParameters(new String[] { "context", "generator" }, new Class[] { Context.class, this.getClass() });
		se.setThrownExceptions(new Class[] { Exception.class });
		se.setParentClassLoader(context.getClassLoader());
		Object result = se.evaluate(new Object[] { context, this });
		if (result == null || Boolean.FALSE.equals(result)) {
			return Collections.emptySet();
		}
		
		if (result instanceof Context) {
			return Collections.singleton((Context) result);
		}
		
		if (result instanceof Iterable) {
			return (Iterable<Context>) result;
		}
				
		if (result.getClass().isArray() && Context.class.isAssignableFrom(result.getClass().getComponentType())) {
			List<Context> ret = new ArrayList<>();
			for (int i=0; i<Array.getLength(result); ++i) {
				ret.add((Context) Array.get(result, i));
			}
			return ret;
		}
		
		throw new IllegalArgumentException("Unexpected iterator return value: "+result);
	}

} //GeneratorImpl
