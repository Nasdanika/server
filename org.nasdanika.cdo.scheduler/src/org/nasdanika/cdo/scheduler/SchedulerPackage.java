/**
 */
package org.nasdanika.cdo.scheduler;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.scheduler.SchedulerFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.scheduler";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.scheduler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulerPackage eINSTANCE = org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl <em>Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl
	 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getSchedulerTask()
	 * @generated
	 */
	int SCHEDULER_TASK = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Run At</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__RUN_AT = 1;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__PERIOD = 2;

	/**
	 * The feature id for the '<em><b>Fixed Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__FIXED_RATE = 3;

	/**
	 * The feature id for the '<em><b>Run As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK__RUN_AS = 4;

	/**
	 * The number of structural features of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_TASK_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.scheduler.SchedulerTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask
	 * @generated
	 */
	EClass getSchedulerTask();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getTarget()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EReference getSchedulerTask_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAt <em>Run At</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run At</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getRunAt()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EAttribute getSchedulerTask_RunAt();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getPeriod()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EAttribute getSchedulerTask_Period();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.scheduler.SchedulerTask#isFixedRate <em>Fixed Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Rate</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#isFixedRate()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EAttribute getSchedulerTask_FixedRate();

	/**
	 * Returns the meta object for the reference '{@link org.nasdanika.cdo.scheduler.SchedulerTask#getRunAs <em>Run As</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Run As</em>'.
	 * @see org.nasdanika.cdo.scheduler.SchedulerTask#getRunAs()
	 * @see #getSchedulerTask()
	 * @generated
	 */
	EReference getSchedulerTask_RunAs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulerFactory getSchedulerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl <em>Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerTaskImpl
		 * @see org.nasdanika.cdo.scheduler.impl.SchedulerPackageImpl#getSchedulerTask()
		 * @generated
		 */
		EClass SCHEDULER_TASK = eINSTANCE.getSchedulerTask();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_TASK__TARGET = eINSTANCE.getSchedulerTask_Target();

		/**
		 * The meta object literal for the '<em><b>Run At</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_TASK__RUN_AT = eINSTANCE.getSchedulerTask_RunAt();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_TASK__PERIOD = eINSTANCE.getSchedulerTask_Period();

		/**
		 * The meta object literal for the '<em><b>Fixed Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER_TASK__FIXED_RATE = eINSTANCE.getSchedulerTask_FixedRate();

		/**
		 * The meta object literal for the '<em><b>Run As</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_TASK__RUN_AS = eINSTANCE.getSchedulerTask_RunAs();

	}

} //SchedulerPackage
