/**
 */
package org.nasdanika.codegen.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Configurable;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.ContextProvider;
import org.nasdanika.codegen.File;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.IGenerator;
import org.nasdanika.codegen.Property;
import org.nasdanika.codegen.ResourceGenerator;
import org.nasdanika.codegen.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.FileImpl#getPropertiesReferences <em>Properties References</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.FileImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.FileImpl#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FileImpl extends ResourceImpl implements File {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.FILE;
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
	public EList<Property> getProperties() {
		return (EList<Property>)eGet(CodegenPackage.Literals.CONFIGURABLE__PROPERTIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service<Object>> getServices() {
		return (EList<Service<Object>>)eGet(CodegenPackage.Literals.CONFIGURABLE__SERVICES, true);
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IGenerator.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Configurable.class) {
			switch (derivedFeatureID) {
				case CodegenPackage.FILE__PROPERTIES_REFERENCES: return CodegenPackage.CONFIGURABLE__PROPERTIES_REFERENCES;
				case CodegenPackage.FILE__PROPERTIES: return CodegenPackage.CONFIGURABLE__PROPERTIES;
				case CodegenPackage.FILE__SERVICES: return CodegenPackage.CONFIGURABLE__SERVICES;
				default: return -1;
			}
		}
		if (baseClass == ContextProvider.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Generator.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ResourceGenerator.class) {
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
		if (baseClass == IGenerator.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Configurable.class) {
			switch (baseFeatureID) {
				case CodegenPackage.CONFIGURABLE__PROPERTIES_REFERENCES: return CodegenPackage.FILE__PROPERTIES_REFERENCES;
				case CodegenPackage.CONFIGURABLE__PROPERTIES: return CodegenPackage.FILE__PROPERTIES;
				case CodegenPackage.CONFIGURABLE__SERVICES: return CodegenPackage.FILE__SERVICES;
				default: return -1;
			}
		}
		if (baseClass == ContextProvider.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Generator.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ResourceGenerator.class) {
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
		if (baseClass == IGenerator.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == Configurable.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ContextProvider.class) {
			switch (baseOperationID) {
				case CodegenPackage.CONTEXT_PROVIDER___CREATE_CONTEXT__CONTEXT_BOOLEAN: return CodegenPackage.FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN;
				default: return -1;
			}
		}
		if (baseClass == Generator.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == ResourceGenerator.class) {
			switch (baseOperationID) {
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
			case CodegenPackage.FILE___CREATE_CONTEXT__CONTEXT_BOOLEAN:
				return createContext((Context)arguments.get(0), (Boolean)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //FileImpl
