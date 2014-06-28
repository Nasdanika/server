/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invocable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getInvocable()
 * @model interface="true" abstract="true" CBounds="org.nasdanika.cdo.flow.Context"
 * @extends CDOObject
 * @generated
 */
public interface Invocable<R, C extends Context> extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.cdo.flow.Exception" argumentsMany="true"
	 * @generated
	 */
	R invoke(C context, EList<Object> arguments) throws Exception;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.cdo.flow.Exception" argumentsMany="true"
	 * @generated
	 */
	boolean accept(C context, EList<Object> arguments) throws Exception;

} // Invocable
