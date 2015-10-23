/**
 */
package org.nasdanika.webtest.performance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.webtest.performance.PerformancePackage
 * @generated
 */
public interface PerformanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PerformanceFactory eINSTANCE = org.nasdanika.webtest.performance.impl.PerformanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Timing Base</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timing Base</em>'.
	 * @generated
	 */
	TimingBase createTimingBase();

	/**
	 * Returns a new object of class '<em>Resource Timing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Timing</em>'.
	 * @generated
	 */
	ResourceTiming createResourceTiming();

	/**
	 * Returns a new object of class '<em>Navigation Timing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Navigation Timing</em>'.
	 * @generated
	 */
	NavigationTiming createNavigationTiming();

	/**
	 * Returns a new object of class '<em>Document Timing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Timing</em>'.
	 * @generated
	 */
	DocumentTiming createDocumentTiming();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PerformancePackage getPerformancePackage();

} //PerformanceFactory
