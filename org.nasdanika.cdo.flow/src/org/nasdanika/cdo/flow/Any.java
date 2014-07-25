/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.common.util.EList;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Any</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getAny()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface Any<R, C extends Context> extends Promise<R, C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model promisesMany="true" executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	void init(EList<Promise<R, C>> promises, Executor<C> executor);

} // Any
