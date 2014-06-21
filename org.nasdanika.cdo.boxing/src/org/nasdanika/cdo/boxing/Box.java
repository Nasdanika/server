/**
 */
package org.nasdanika.cdo.boxing;

import org.eclipse.emf.cdo.CDOObject;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Box</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.boxing.BoxingPackage#getBox()
 * @model interface="true" abstract="true" CBounds="org.nasdanika.cdo.boxing.Context"
 * @extends CDOObject
 * @generated
 */
public interface Box<T, C extends Context> extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	T get(C context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void set(T value, C context);

} // Box
