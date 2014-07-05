/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.common.util.EList;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.All#getPromises <em>Promises</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getAll()
 * @model superTypes="org.nasdanika.cdo.flow.Promise<org.eclipse.emf.ecore.EEList<R>, C>" CBounds="org.nasdanika.cdo.flow.Context"
 * @generated
 */
public interface All<R, C extends Context> extends Promise<EList<R>, C> {
	/**
	 * Returns the value of the '<em><b>Promises</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Promises</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Promises</em>' containment reference.
	 * @see #setPromises(Promise)
	 * @see org.nasdanika.cdo.flow.FlowPackage#getAll_Promises()
	 * @model containment="true"
	 * @generated
	 */
	Promise<R, C> getPromises();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.flow.All#getPromises <em>Promises</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Promises</em>' containment reference.
	 * @see #getPromises()
	 * @generated
	 */
	void setPromises(Promise<R, C> value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model promisesMany="true" executorType="org.nasdanika.cdo.flow.Executor<C>"
	 * @generated
	 */
	void init(EList<Promise<R, C>> promises, Executor<C> executor);

} // All
