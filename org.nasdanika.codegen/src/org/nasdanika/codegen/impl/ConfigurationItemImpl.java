/**
 */
package org.nasdanika.codegen.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configurable;
import org.nasdanika.codegen.ConfigurationItem;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Provider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#getPropertiesReferences <em>Properties References</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#getDefaultPropertiesReferences <em>Default Properties References</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#getValueType <em>Value Type</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ConfigurationItemImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConfigurationItemImpl<T> extends CDOObjectImpl implements ConfigurationItem<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.CONFIGURATION_ITEM;
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
	public String getValueType() {
		return (String)eGet(CodegenPackage.Literals.CONFIGURATION_ITEM__VALUE_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueType(String newValueType) {
		eSet(CodegenPackage.Literals.CONFIGURATION_ITEM__VALUE_TYPE, newValueType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return (String)eGet(CodegenPackage.Literals.CONFIGURATION_ITEM__VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		eSet(CodegenPackage.Literals.CONFIGURATION_ITEM__VALUE, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefault() {
		return (Boolean)eGet(CodegenPackage.Literals.CONFIGURATION_ITEM__DEFAULT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefault(boolean newDefault) {
		eSet(CodegenPackage.Literals.CONFIGURATION_ITEM__DEFAULT, newDefault);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(CodegenPackage.Literals.CONFIGURATION_ITEM__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(CodegenPackage.Literals.CONFIGURATION_ITEM__DESCRIPTION, newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext(Context parent) throws Exception {
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
				case CodegenPackage.CONFIGURATION_ITEM__PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURABLE__PROPERTIES_REFERENCES;
				case CodegenPackage.CONFIGURATION_ITEM__CONFIGURATION: return CodegenPackage.CONFIGURABLE__CONFIGURATION;
				case CodegenPackage.CONFIGURATION_ITEM__DEFAULT_PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURABLE__DEFAULT_PROPERTIES_REFERENCES;
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
				case CodegenPackage.CONFIGURABLE__PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURATION_ITEM__PROPERTIES_REFERENCES;
				case CodegenPackage.CONFIGURABLE__CONFIGURATION: return CodegenPackage.CONFIGURATION_ITEM__CONFIGURATION;
				case CodegenPackage.CONFIGURABLE__DEFAULT_PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURATION_ITEM__DEFAULT_PROPERTIES_REFERENCES;
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
				case CodegenPackage.CONFIGURABLE___CREATE_CONTEXT__CONTEXT: return CodegenPackage.CONFIGURATION_ITEM___CREATE_CONTEXT__CONTEXT;
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
			case CodegenPackage.CONFIGURATION_ITEM___CREATE_CONTEXT__CONTEXT:
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
	 * Attempts to instantiate a class by finding a constructor which would accept provided arguments in any combination.
	 * @param clazz
	 * @param args
	 * @return instance or null if approriate constructor was not found.
	 * @throws Exception
	 */
	static Object instantiate(Class<?> clazz, Class<?>[] types, Object[] args) throws Exception {
		C: for (Constructor<?> constructor: clazz.getConstructors()) {
			Class<?>[] pt = constructor.getParameterTypes();
			if (pt.length == args.length) {
				List<Object> aList = new ArrayList<>(Arrays.asList(args));
				Object[] cArgs = new Object[pt.length];
				
				A: for (int i=0; i<cArgs.length; ++i) {
					Iterator<Object> ait = aList.iterator();
					while (ait.hasNext()) {
						Object na = ait.next();
						if (pt[i].isAssignableFrom(types[i])) {
							cArgs[i] = na;
							ait.remove();
							continue A; // Argument found.
						}
					}
					continue C; // Argument not found.
				}
				
				if (aList.isEmpty()) { // Extra check.
					return constructor.newInstance(cArgs);
				}				
			}
		}
		
		return null;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public T get(Context context) throws Exception {
		if (getValueType() == null || getValueType().trim().length() == 0 || String.class.getName().equals(getValueType().trim())) {
			if (!getConfiguration().isEmpty()) {
				throw new IllegalStateException("String values are not configurable configuration");
			}
			return (T) context.interpolate(getValue());
		}
		
		Class<?> valueClass = context.getClassLoader().loadClass(getValueType().trim());
		// Blank value
		String interpolatedValue = context.interpolate(getValue());
		boolean isBlankValue = interpolatedValue == null || interpolatedValue.trim().length() == 0;
		if (Provider.class.isAssignableFrom(valueClass)) {
			if (isBlankValue) {
				// Try default constructor
				Object ret = instantiate(valueClass, new Class<?>[] {}, new Object[] {});
				if (ret != null) {
					return ((Provider<T>) ret).get(createContext(context));
				}				
			}
			Object ret = instantiate(valueClass, new Class<?>[] { String.class }, new Object[] { interpolatedValue });
			if (ret == null) {
				throw new IllegalStateException("Cannot create provider (no appropriate constructor found) "+valueClass);
			}				
			return ((Provider<T>) ret).get(createContext(context));
		}
		
		if (isBlankValue) {
			if (getConfiguration().isEmpty()) {
				// Try default constructor
				Object ret = instantiate(valueClass, new Class<?>[] {}, new Object[] {});
				if (ret != null) {
					return (T) ret;
				}				
			}
			// Try constructor which accepts Context
			Object ret = instantiate(valueClass, new Class<?>[] { Context.class }, new Object[] {createContext(context) });
			if (ret != null) {
				return (T) ret;
			}				
		}
		
		if (getConfiguration().isEmpty()) {
			// Try String constructor
			Object ret = instantiate(valueClass, new Class<?>[] { String.class }, new Object[] { interpolatedValue });
			if (ret != null) {
				return (T) ret;
			}				
		}
		
		// Try constructor which accepts Context and String
		Object ret = instantiate(valueClass, new Class<?>[] { String.class, Context.class }, new Object[] { interpolatedValue, createContext(context) });
		if (ret != null) {
			return (T) ret;
		}				

		throw new IllegalStateException("Cannot create value (no appropriate constructor found) "+valueClass);
		
	}

} //ConfigurationItemImpl
