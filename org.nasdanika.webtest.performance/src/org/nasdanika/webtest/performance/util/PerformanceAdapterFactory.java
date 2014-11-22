/**
 */
package org.nasdanika.webtest.performance.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.nasdanika.webtest.performance.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.webtest.performance.PerformancePackage
 * @generated
 */
public class PerformanceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PerformancePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PerformancePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PerformanceSwitch<Adapter> modelSwitch =
		new PerformanceSwitch<Adapter>() {
			@Override
			public Adapter caseTimingBase(TimingBase object) {
				return createTimingBaseAdapter();
			}
			@Override
			public Adapter caseResourceTiming(ResourceTiming object) {
				return createResourceTimingAdapter();
			}
			@Override
			public Adapter caseNavigationTiming(NavigationTiming object) {
				return createNavigationTimingAdapter();
			}
			@Override
			public Adapter caseDocumentTiming(DocumentTiming object) {
				return createDocumentTimingAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.performance.TimingBase <em>Timing Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.performance.TimingBase
	 * @generated
	 */
	public Adapter createTimingBaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.performance.ResourceTiming <em>Resource Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.performance.ResourceTiming
	 * @generated
	 */
	public Adapter createResourceTimingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.performance.NavigationTiming <em>Navigation Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.performance.NavigationTiming
	 * @generated
	 */
	public Adapter createNavigationTimingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.nasdanika.webtest.performance.DocumentTiming <em>Document Timing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.nasdanika.webtest.performance.DocumentTiming
	 * @generated
	 */
	public Adapter createDocumentTimingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //PerformanceAdapterFactory
