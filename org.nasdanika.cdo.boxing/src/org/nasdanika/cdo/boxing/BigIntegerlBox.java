/**
 */
package org.nasdanika.cdo.boxing;

import java.math.BigInteger;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Big Integerl Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.boxing.BigIntegerlBox#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getBigIntegerlBox()
 * @model superTypes="org.nasdanika.cdo.boxing.Box<org.eclipse.emf.ecore.EBigInteger, org.nasdanika.cdo.boxing.Context>"
 * @generated
 */
public interface BigIntegerlBox extends Box<BigInteger, Context> {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(BigInteger)
	 * @see org.nasdanika.cdo.boxing.BoxingPackage#getBigIntegerlBox_Value()
	 * @model
	 * @generated
	 */
	BigInteger getValue();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.boxing.BigIntegerlBox#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BigInteger value);

} // BigIntegerlBox
