/**
 */
package org.nasdanika.webtest.performance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.nasdanika.webtest.performance.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerformanceFactoryImpl extends EFactoryImpl implements PerformanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PerformanceFactory init() {
		try {
			PerformanceFactory thePerformanceFactory = (PerformanceFactory)EPackage.Registry.INSTANCE.getEFactory(PerformancePackage.eNS_URI);
			if (thePerformanceFactory != null) {
				return thePerformanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PerformanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceFactoryImpl() {
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
			case PerformancePackage.TIMING_BASE: return (EObject)createTimingBase();
			case PerformancePackage.RESOURCE_TIMING: return (EObject)createResourceTiming();
			case PerformancePackage.NAVIGATION_TIMING: return (EObject)createNavigationTiming();
			case PerformancePackage.DOCUMENT_TIMING: return (EObject)createDocumentTiming();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingBase createTimingBase() {
		TimingBaseImpl timingBase = new TimingBaseImpl();
		return timingBase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTiming createResourceTiming() {
		ResourceTimingImpl resourceTiming = new ResourceTimingImpl();
		return resourceTiming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationTiming createNavigationTiming() {
		NavigationTimingImpl navigationTiming = new NavigationTimingImpl();
		return navigationTiming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentTiming createDocumentTiming() {
		DocumentTimingImpl documentTiming = new DocumentTimingImpl();
		return documentTiming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformancePackage getPerformancePackage() {
		return (PerformancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PerformancePackage getPackage() {
		return PerformancePackage.eINSTANCE;
	}

} //PerformanceFactoryImpl
