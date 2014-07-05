/**
 */
package org.nasdanika.cdo.flow;

import org.eclipse.emf.ecore.EFactory;
import org.nasdanika.core.Context;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.nasdanika.cdo.flow.FlowPackage
 * @generated
 */
public interface FlowFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FlowFactory eINSTANCE = org.nasdanika.cdo.flow.impl.FlowFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Then Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Then Reference</em>'.
	 * @generated
	 */
	<R, R1, C extends Context> ThenReference<R, R1, C> createThenReference();

	/**
	 * Returns a new object of class '<em>Promise Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Promise Reference</em>'.
	 * @generated
	 */
	<R, C extends Context> PromiseReference<R, C> createPromiseReference();

	/**
	 * Returns a new object of class '<em>All</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All</em>'.
	 * @generated
	 */
	<R, C extends Context> All<R, C> createAll();

	/**
	 * Returns a new object of class '<em>Any</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any</em>'.
	 * @generated
	 */
	<R, C extends Context> Any<R, C> createAny();

	/**
	 * Returns a new object of class '<em>Deferred</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deferred</em>'.
	 * @generated
	 */
	<R, C extends Context> Deferred<R, C> createDeferred();

	/**
	 * Returns a new object of class '<em>Job</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job</em>'.
	 * @generated
	 */
	<R, C extends Context> Job<R, C> createJob();

	/**
	 * Returns a new object of class '<em>Job Queue</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Job Queue</em>'.
	 * @generated
	 */
	<C extends Context> JobQueue<C> createJobQueue();

	/**
	 * Returns a new object of class '<em>Invocable Then</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invocable Then</em>'.
	 * @generated
	 */
	<R, R1, C extends Context> InvocableThen<R, R1, C> createInvocableThen();

	/**
	 * Returns a new object of class '<em>Invocable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invocable Reference</em>'.
	 * @generated
	 */
	<R, C extends Context> InvocableReference<R, C> createInvocableReference();

	/**
	 * Returns a new object of class '<em>Bound Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bound Invocable</em>'.
	 * @generated
	 */
	BoundInvocable createBoundInvocable();

	/**
	 * Returns a new object of class '<em>Dispatch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dispatch</em>'.
	 * @generated
	 */
	Dispatch createDispatch();

	/**
	 * Returns a new object of class '<em>Publish</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publish</em>'.
	 * @generated
	 */
	Publish createPublish();

	/**
	 * Returns a new object of class '<em>Deferred Invocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deferred Invocation</em>'.
	 * @generated
	 */
	DeferredInvocation createDeferredInvocation();

	/**
	 * Returns a new object of class '<em>Deferring Invocable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deferring Invocable</em>'.
	 * @generated
	 */
	DeferringInvocable createDeferringInvocable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FlowPackage getFlowPackage();

} //FlowFactory
