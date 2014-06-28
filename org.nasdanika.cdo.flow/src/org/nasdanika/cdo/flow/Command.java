/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.cdo.CDOObject;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getCommand()
 * @model interface="true" abstract="true" CBounds="org.nasdanika.cdo.flow.Context"
 * @extends CDOObject
 * @generated
 */
public interface Command<R, C extends Context> extends CDOObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.nasdanika.cdo.flow.Exception" executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	R execute(C context, Executor<C> executor) throws Exception;

} // Command
