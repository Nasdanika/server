/**
 */
package org.nasdanika.cdo.promise;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.promise.PromisePackage
 * @generated
 */
public interface PromiseFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PromiseFactory eINSTANCE = org.nasdanika.cdo.promise.impl.PromiseFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Promise</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Promise</em>'.
	 * @generated
	 */
	<CR, F, R, N> Promise<CR, F, R, N> createPromise();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PromisePackage getPromisePackage();

} //PromiseFactory
