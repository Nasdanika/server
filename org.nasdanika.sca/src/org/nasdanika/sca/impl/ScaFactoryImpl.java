/**
 */
package org.nasdanika.sca.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.sca.*;

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
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
