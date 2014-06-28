/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Then</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getThen()
 * @model interface="true" abstract="true" CBounds="org.nasdanika.cdo.flow.Context"
 * @extends CDOObject
 * @generated
 */
public interface Then<R, R1, C extends Context> extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	R1 onFulfilled(R value, C context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.nasdanika.cdo.flow.Exception" reasonDataType="org.nasdanika.cdo.flow.Exception"
	 * @generated
	 */
	Exception onRejected(Exception reason, C context);

} // Then
