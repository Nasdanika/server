/**
 */
package org.nasdanika.cdo.sca;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.sca.ScaPackage
 * @generated
 */
public interface ScaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScaFactory eINSTANCE = org.nasdanika.cdo.sca.impl.ScaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Wire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wire</em>'.
	 * @generated
	 */
	Wire createWire();

	/**
	 * Returns a new object of class '<em>Property Setting</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Setting</em>'.
	 * @generated
	 */
	PropertySetting createPropertySetting();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScaPackage getScaPackage();

} //ScaFactory
