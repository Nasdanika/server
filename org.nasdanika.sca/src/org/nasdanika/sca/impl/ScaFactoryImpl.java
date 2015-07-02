/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.core.Context;
import org.nasdanika.sca.Activator;
import org.nasdanika.sca.ActivatorImport;
import org.nasdanika.sca.Component;
import org.nasdanika.sca.Composite;
import org.nasdanika.sca.CompositeReference;
import org.nasdanika.sca.Operation;
import org.nasdanika.sca.OperationExport;
import org.nasdanika.sca.Property;
import org.nasdanika.sca.PropertyImport;
import org.nasdanika.sca.Reference;
import org.nasdanika.sca.ReferenceImport;
import org.nasdanika.sca.ScaFactory;
import org.nasdanika.sca.ScaPackage;
import org.nasdanika.sca.Service;
import org.nasdanika.sca.ServiceExport;
import org.osgi.framework.BundleContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaFactoryImpl extends EFactoryImpl implements ScaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ScaFactory init() {
		try {
			ScaFactory theScaFactory = (ScaFactory)EPackage.Registry.INSTANCE.getEFactory(ScaPackage.eNS_URI);
			if (theScaFactory != null) {
				return theScaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ScaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ScaPackage.COMPONENT: return (EObject)createComponent();
			case ScaPackage.COMPOSITE: return (EObject)createComposite();
			case ScaPackage.COMPOSITE_REFERENCE: return (EObject)createCompositeReference();
			case ScaPackage.REFERENCE: return (EObject)createReference();
			case ScaPackage.SERVICE: return (EObject)createService();
			case ScaPackage.REFERENCE_IMPORT: return (EObject)createReferenceImport();
			case ScaPackage.SERVICE_EXPORT: return (EObject)createServiceExport();
			case ScaPackage.PROPERTY: return (EObject)createProperty();
			case ScaPackage.PROPERTY_IMPORT: return (EObject)createPropertyImport();
			case ScaPackage.ACTIVATOR: return (EObject)createActivator();
			case ScaPackage.OPERATION: return (EObject)createOperation();
			case ScaPackage.ACTIVATOR_IMPORT: return (EObject)createActivatorImport();
			case ScaPackage.OPERATION_EXPORT: return (EObject)createOperationExport();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ScaPackage.CONTEXT:
				return createContextFromString(eDataType, initialValue);
			case ScaPackage.BUNDLE_CONTEXT:
				return createBundleContextFromString(eDataType, initialValue);
			case ScaPackage.EXCEPTION:
				return createExceptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ScaPackage.CONTEXT:
				return convertContextToString(eDataType, instanceValue);
			case ScaPackage.BUNDLE_CONTEXT:
				return convertBundleContextToString(eDataType, instanceValue);
			case ScaPackage.EXCEPTION:
				return convertExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composite createComposite() {
		CompositeImpl composite = new CompositeImpl();
		return composite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeReference createCompositeReference() {
		CompositeReferenceImpl compositeReference = new CompositeReferenceImpl();
		return compositeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceImport createReferenceImport() {
		ReferenceImportImpl referenceImport = new ReferenceImportImpl();
		return referenceImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceExport createServiceExport() {
		ServiceExportImpl serviceExport = new ServiceExportImpl();
		return serviceExport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyImport createPropertyImport() {
		PropertyImportImpl propertyImport = new PropertyImportImpl();
		return propertyImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activator createActivator() {
		ActivatorImpl activator = new ActivatorImpl();
		return activator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivatorImport createActivatorImport() {
		ActivatorImportImpl activatorImport = new ActivatorImportImpl();
		return activatorImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationExport createOperationExport() {
		OperationExportImpl operationExport = new OperationExportImpl();
		return operationExport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContextFromString(EDataType eDataType, String initialValue) {
		return (Context)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BundleContext createBundleContextFromString(EDataType eDataType, String initialValue) {
		return (BundleContext)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBundleContextToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exception createExceptionFromString(EDataType eDataType, String initialValue) {
		return (Exception)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaPackage getScaPackage() {
		return (ScaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ScaPackage getPackage() {
		return ScaPackage.eINSTANCE;
	}

} //ScaFactoryImpl
