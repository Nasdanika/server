/**
 */
package org.nasdanika.codegen.impl;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Map;
import org.codehaus.janino.ScriptEvaluator;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configuration;
import org.nasdanika.codegen.ConfigurationItem;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.GeneratorFilter;
import org.nasdanika.codegen.util.CodegenValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getIncludes <em>Includes</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getDefaultIncludes <em>Default Includes</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getBaseURL <em>Base URL</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.GeneratorImpl#getInclude <em>Include</em>}</li>
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
	public EList<String> getIncludes() {
		return (EList<String>)eGet(CodegenPackage.Literals.CONFIGURATION__INCLUDES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ConfigurationItem> getConfiguration() {
		return (EList<ConfigurationItem>)eGet(CodegenPackage.Literals.CONFIGURATION__CONFIGURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getDefaultIncludes() {
		return (EList<String>)eGet(CodegenPackage.Literals.CONFIGURATION__DEFAULT_INCLUDES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBaseURL() {
		return (String)eGet(CodegenPackage.Literals.CONFIGURATION__BASE_URL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseURL(String newBaseURL) {
		eSet(CodegenPackage.Literals.CONFIGURATION__BASE_URL, newBaseURL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getClassPath() {
		return (EList<String>)eGet(CodegenPackage.Literals.CONFIGURATION__CLASS_PATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Configuration> getInclude() {
		return (EList<Configuration>)eGet(CodegenPackage.Literals.CONFIGURATION__INCLUDE, true);
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
	 * @generated
	 */
	public boolean validate(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 CodegenValidator.DIAGNOSTIC_SOURCE,
						 CodegenValidator.GENERATOR__VALIDATE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "validate", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
		if (baseClass == Configuration.class) {
			switch (derivedFeatureID) {
				case CodegenPackage.GENERATOR__INCLUDES: return CodegenPackage.CONFIGURATION__INCLUDES;
				case CodegenPackage.GENERATOR__CONFIGURATION: return CodegenPackage.CONFIGURATION__CONFIGURATION;
				case CodegenPackage.GENERATOR__DEFAULT_INCLUDES: return CodegenPackage.CONFIGURATION__DEFAULT_INCLUDES;
				case CodegenPackage.GENERATOR__BASE_URL: return CodegenPackage.CONFIGURATION__BASE_URL;
				case CodegenPackage.GENERATOR__CLASS_PATH: return CodegenPackage.CONFIGURATION__CLASS_PATH;
				case CodegenPackage.GENERATOR__INCLUDE: return CodegenPackage.CONFIGURATION__INCLUDE;
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
		if (baseClass == Configuration.class) {
			switch (baseFeatureID) {
				case CodegenPackage.CONFIGURATION__INCLUDES: return CodegenPackage.GENERATOR__INCLUDES;
				case CodegenPackage.CONFIGURATION__CONFIGURATION: return CodegenPackage.GENERATOR__CONFIGURATION;
				case CodegenPackage.CONFIGURATION__DEFAULT_INCLUDES: return CodegenPackage.GENERATOR__DEFAULT_INCLUDES;
				case CodegenPackage.CONFIGURATION__BASE_URL: return CodegenPackage.GENERATOR__BASE_URL;
				case CodegenPackage.CONFIGURATION__CLASS_PATH: return CodegenPackage.GENERATOR__CLASS_PATH;
				case CodegenPackage.CONFIGURATION__INCLUDE: return CodegenPackage.GENERATOR__INCLUDE;
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
		if (baseClass == Configuration.class) {
			switch (baseOperationID) {
				case CodegenPackage.CONFIGURATION___CREATE_CONTEXT__CONTEXT: return CodegenPackage.GENERATOR___CREATE_CONTEXT__CONTEXT;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case CodegenPackage.GENERATOR___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		GeneratorFilter gf = context.get(GeneratorFilter.class);
		if (gf != null && !gf.test(this)) {
			Collections.emptySet();
		}
		
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
