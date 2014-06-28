/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.cdo.CDOObject;

import org.eclipse.emf.common.util.EList;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job Queue</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.JobQueue#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.nasdanika.cdo.flow.FlowPackage#getJobQueue()
 * @model CBounds="org.nasdanika.cdo.flow.Context"
 * @extends CDOObject
 * @generated
 */
public interface JobQueue<C extends Context> extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Jobs</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.cdo.flow.Job}&lt;?, C>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jobs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jobs</em>' containment reference list.
	 * @see org.nasdanika.cdo.flow.FlowPackage#getJobQueue_Jobs()
	 * @model containment="true"
	 * @generated
	 */
	EList<Job<?, C>> getJobs();

} // JobQueue
