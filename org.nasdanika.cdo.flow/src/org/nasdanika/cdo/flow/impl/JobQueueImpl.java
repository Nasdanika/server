/**
 */
package org.nasdanika.cdo.flow.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.flow.FlowPackage;
import org.nasdanika.cdo.flow.Job;
import org.nasdanika.cdo.flow.JobQueue;

import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Job Queue</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.nasdanika.cdo.flow.impl.JobQueueImpl#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JobQueueImpl<C extends Context> extends CDOObjectImpl implements JobQueue<C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JobQueueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FlowPackage.Literals.JOB_QUEUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Job<?, C>> getJobs() {
		return (EList<Job<?, C>>)eGet(FlowPackage.Literals.JOB_QUEUE__JOBS, true);
	}

} //JobQueueImpl
