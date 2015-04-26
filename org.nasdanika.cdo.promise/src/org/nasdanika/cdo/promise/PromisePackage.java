/**
 */
package org.nasdanika.cdo.promise;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.nasdanika.cdo.promise.PromiseFactory
 * @model kind="package"
 * @generated
 */
public interface PromisePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "promise";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "urn:org.nasdanika.cdo.promise";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.nasdanika.cdo.promise";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PromisePackage eINSTANCE = org.nasdanika.cdo.promise.impl.PromisePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.promise.impl.PromiseImpl <em>Promise</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.promise.impl.PromiseImpl
	 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getPromise()
	 * @generated
	 */
	int PROMISE = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Thens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__THENS = 1;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__STATE = 2;

	/**
	 * The feature id for the '<em><b>Fulfillment Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__FULFILLMENT_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Rejection Reason</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE__REJECTION_REASON = 4;

	/**
	 * The number of structural features of the '<em>Promise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Timeout</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___TIMEOUT__SCHEDULER_LONG_TIMEUNIT_OBJECT = 0;

	/**
	 * The operation id for the '<em>Delay</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___DELAY__SCHEDULER_LONG_TIMEUNIT = 1;

	/**
	 * The operation id for the '<em>Resolve</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___RESOLVE__OBJECT = 2;

	/**
	 * The operation id for the '<em>Reject</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___REJECT__OBJECT = 3;

	/**
	 * The operation id for the '<em>Notify</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___NOTIFY__OBJECT = 4;

	/**
	 * The operation id for the '<em>Then</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE___THEN__CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND = 5;

	/**
	 * The number of operations of the '<em>Promise</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROMISE_OPERATION_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.nasdanika.cdo.promise.PromiseState <em>State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.promise.PromiseState
	 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getPromiseState()
	 * @generated
	 */
	int PROMISE_STATE = 1;

	/**
	 * The meta object id for the '<em>Time Unit</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.concurrent.TimeUnit
	 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 2;

	/**
	 * The meta object id for the '<em>CDO Transaction Context Command</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.CDOTransactionContextCommand
	 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getCDOTransactionContextCommand()
	 * @generated
	 */
	int CDO_TRANSACTION_CONTEXT_COMMAND = 3;


	/**
	 * The meta object id for the '<em>Scheduler</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.nasdanika.cdo.scheduler.Scheduler
	 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getScheduler()
	 * @generated
	 */
	int SCHEDULER = 4;


	/**
	 * The meta object id for the '<em>CDO Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.cdo.CDOObject
	 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getCDOObject()
	 * @generated
	 */
	int CDO_OBJECT = 5;


	/**
	 * Returns the meta object for class '{@link org.nasdanika.cdo.promise.Promise <em>Promise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Promise</em>'.
	 * @see org.nasdanika.cdo.promise.Promise
	 * @generated
	 */
	EClass getPromise();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.promise.Promise#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.nasdanika.cdo.promise.Promise#getChildren()
	 * @see #getPromise()
	 * @generated
	 */
	EReference getPromise_Children();

	/**
	 * Returns the meta object for the containment reference list '{@link org.nasdanika.cdo.promise.Promise#getThens <em>Thens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Thens</em>'.
	 * @see org.nasdanika.cdo.promise.Promise#getThens()
	 * @see #getPromise()
	 * @generated
	 */
	EReference getPromise_Thens();

	/**
	 * Returns the meta object for the attribute '{@link org.nasdanika.cdo.promise.Promise#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.nasdanika.cdo.promise.Promise#getState()
	 * @see #getPromise()
	 * @generated
	 */
	EAttribute getPromise_State();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.promise.Promise#getFulfillmentValue <em>Fulfillment Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fulfillment Value</em>'.
	 * @see org.nasdanika.cdo.promise.Promise#getFulfillmentValue()
	 * @see #getPromise()
	 * @generated
	 */
	EReference getPromise_FulfillmentValue();

	/**
	 * Returns the meta object for the containment reference '{@link org.nasdanika.cdo.promise.Promise#getRejectionReason <em>Rejection Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rejection Reason</em>'.
	 * @see org.nasdanika.cdo.promise.Promise#getRejectionReason()
	 * @see #getPromise()
	 * @generated
	 */
	EReference getPromise_RejectionReason();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.promise.Promise#timeout(org.nasdanika.cdo.scheduler.Scheduler, long, java.util.concurrent.TimeUnit, java.lang.Object) <em>Timeout</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Timeout</em>' operation.
	 * @see org.nasdanika.cdo.promise.Promise#timeout(org.nasdanika.cdo.scheduler.Scheduler, long, java.util.concurrent.TimeUnit, java.lang.Object)
	 * @generated
	 */
	EOperation getPromise__Timeout__Scheduler_long_TimeUnit_Object();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.promise.Promise#delay(org.nasdanika.cdo.scheduler.Scheduler, long, java.util.concurrent.TimeUnit) <em>Delay</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Delay</em>' operation.
	 * @see org.nasdanika.cdo.promise.Promise#delay(org.nasdanika.cdo.scheduler.Scheduler, long, java.util.concurrent.TimeUnit)
	 * @generated
	 */
	EOperation getPromise__Delay__Scheduler_long_TimeUnit();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.promise.Promise#resolve(java.lang.Object) <em>Resolve</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Resolve</em>' operation.
	 * @see org.nasdanika.cdo.promise.Promise#resolve(java.lang.Object)
	 * @generated
	 */
	EOperation getPromise__Resolve__Object();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.promise.Promise#reject(java.lang.Object) <em>Reject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Reject</em>' operation.
	 * @see org.nasdanika.cdo.promise.Promise#reject(java.lang.Object)
	 * @generated
	 */
	EOperation getPromise__Reject__Object();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.promise.Promise#notify(java.lang.Object) <em>Notify</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Notify</em>' operation.
	 * @see org.nasdanika.cdo.promise.Promise#notify(java.lang.Object)
	 * @generated
	 */
	EOperation getPromise__Notify__Object();

	/**
	 * Returns the meta object for the '{@link org.nasdanika.cdo.promise.Promise#then(org.nasdanika.cdo.CDOTransactionContextCommand, org.nasdanika.cdo.CDOTransactionContextCommand, org.nasdanika.cdo.CDOTransactionContextCommand) <em>Then</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Then</em>' operation.
	 * @see org.nasdanika.cdo.promise.Promise#then(org.nasdanika.cdo.CDOTransactionContextCommand, org.nasdanika.cdo.CDOTransactionContextCommand, org.nasdanika.cdo.CDOTransactionContextCommand)
	 * @generated
	 */
	EOperation getPromise__Then__CDOTransactionContextCommand_CDOTransactionContextCommand_CDOTransactionContextCommand();

	/**
	 * Returns the meta object for enum '{@link org.nasdanika.cdo.promise.PromiseState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State</em>'.
	 * @see org.nasdanika.cdo.promise.PromiseState
	 * @generated
	 */
	EEnum getPromiseState();

	/**
	 * Returns the meta object for data type '{@link java.util.concurrent.TimeUnit <em>Time Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Time Unit</em>'.
	 * @see java.util.concurrent.TimeUnit
	 * @model instanceClass="java.util.concurrent.TimeUnit"
	 * @generated
	 */
	EDataType getTimeUnit();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.CDOTransactionContextCommand <em>CDO Transaction Context Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CDO Transaction Context Command</em>'.
	 * @see org.nasdanika.cdo.CDOTransactionContextCommand
	 * @model instanceClass="org.nasdanika.cdo.CDOTransactionContextCommand" typeParameters="CR T R"
	 * @generated
	 */
	EDataType getCDOTransactionContextCommand();

	/**
	 * Returns the meta object for data type '{@link org.nasdanika.cdo.scheduler.Scheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Scheduler</em>'.
	 * @see org.nasdanika.cdo.scheduler.Scheduler
	 * @model instanceClass="org.nasdanika.cdo.scheduler.Scheduler" typeParameters="CR K"
	 * @generated
	 */
	EDataType getScheduler();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.cdo.CDOObject <em>CDO Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CDO Object</em>'.
	 * @see org.eclipse.emf.cdo.CDOObject
	 * @model instanceClass="org.eclipse.emf.cdo.CDOObject"
	 * @generated
	 */
	EDataType getCDOObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PromiseFactory getPromiseFactory();

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
		 * The meta object literal for the '{@link org.nasdanika.cdo.promise.impl.PromiseImpl <em>Promise</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.promise.impl.PromiseImpl
		 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getPromise()
		 * @generated
		 */
		EClass PROMISE = eINSTANCE.getPromise();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMISE__CHILDREN = eINSTANCE.getPromise_Children();

		/**
		 * The meta object literal for the '<em><b>Thens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMISE__THENS = eINSTANCE.getPromise_Thens();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROMISE__STATE = eINSTANCE.getPromise_State();

		/**
		 * The meta object literal for the '<em><b>Fulfillment Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMISE__FULFILLMENT_VALUE = eINSTANCE.getPromise_FulfillmentValue();

		/**
		 * The meta object literal for the '<em><b>Rejection Reason</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROMISE__REJECTION_REASON = eINSTANCE.getPromise_RejectionReason();

		/**
		 * The meta object literal for the '<em><b>Timeout</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___TIMEOUT__SCHEDULER_LONG_TIMEUNIT_OBJECT = eINSTANCE.getPromise__Timeout__Scheduler_long_TimeUnit_Object();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___DELAY__SCHEDULER_LONG_TIMEUNIT = eINSTANCE.getPromise__Delay__Scheduler_long_TimeUnit();

		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___RESOLVE__OBJECT = eINSTANCE.getPromise__Resolve__Object();

		/**
		 * The meta object literal for the '<em><b>Reject</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___REJECT__OBJECT = eINSTANCE.getPromise__Reject__Object();

		/**
		 * The meta object literal for the '<em><b>Notify</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___NOTIFY__OBJECT = eINSTANCE.getPromise__Notify__Object();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROMISE___THEN__CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND_CDOTRANSACTIONCONTEXTCOMMAND = eINSTANCE.getPromise__Then__CDOTransactionContextCommand_CDOTransactionContextCommand_CDOTransactionContextCommand();

		/**
		 * The meta object literal for the '{@link org.nasdanika.cdo.promise.PromiseState <em>State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.promise.PromiseState
		 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getPromiseState()
		 * @generated
		 */
		EEnum PROMISE_STATE = eINSTANCE.getPromiseState();

		/**
		 * The meta object literal for the '<em>Time Unit</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.concurrent.TimeUnit
		 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getTimeUnit()
		 * @generated
		 */
		EDataType TIME_UNIT = eINSTANCE.getTimeUnit();

		/**
		 * The meta object literal for the '<em>CDO Transaction Context Command</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.CDOTransactionContextCommand
		 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getCDOTransactionContextCommand()
		 * @generated
		 */
		EDataType CDO_TRANSACTION_CONTEXT_COMMAND = eINSTANCE.getCDOTransactionContextCommand();

		/**
		 * The meta object literal for the '<em>Scheduler</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.nasdanika.cdo.scheduler.Scheduler
		 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getScheduler()
		 * @generated
		 */
		EDataType SCHEDULER = eINSTANCE.getScheduler();

		/**
		 * The meta object literal for the '<em>CDO Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.cdo.CDOObject
		 * @see org.nasdanika.cdo.promise.impl.PromisePackageImpl#getCDOObject()
		 * @generated
		 */
		EDataType CDO_OBJECT = eINSTANCE.getCDOObject();

	}

} //PromisePackage
