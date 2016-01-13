/**
 */
package org.nasdanika.webtest.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.TestResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestResultImpl#getPageResults <em>Page Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestResultImpl#getActorResults <em>Actor Results</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestResultImpl extends DescriptorImpl implements TestResult {
	/**
	 * The cached value of the '{@link #getPageResults() <em>Page Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageResults()
	 * @generated
	 * @ordered
	 */
	protected EList<PageResult> pageResults;

	/**
	 * The cached value of the '{@link #getActorResults() <em>Actor Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorResults()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorResult> actorResults;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TEST_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageResult> getPageResults() {
		if (pageResults == null) {
			pageResults = new EObjectContainmentEList<PageResult>(PageResult.class, this, ModelPackage.TEST_RESULT__PAGE_RESULTS);
		}
		return pageResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorResult> getActorResults() {
		if (actorResults == null) {
			actorResults = new EObjectContainmentEList<ActorResult>(ActorResult.class, this, ModelPackage.TEST_RESULT__ACTOR_RESULTS);
		}
		return actorResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TEST_RESULT__PAGE_RESULTS:
				return ((InternalEList<?>)getPageResults()).basicRemove(otherEnd, msgs);
			case ModelPackage.TEST_RESULT__ACTOR_RESULTS:
				return ((InternalEList<?>)getActorResults()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.TEST_RESULT__PAGE_RESULTS:
				return getPageResults();
			case ModelPackage.TEST_RESULT__ACTOR_RESULTS:
				return getActorResults();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.TEST_RESULT__PAGE_RESULTS:
				getPageResults().clear();
				getPageResults().addAll((Collection<? extends PageResult>)newValue);
				return;
			case ModelPackage.TEST_RESULT__ACTOR_RESULTS:
				getActorResults().clear();
				getActorResults().addAll((Collection<? extends ActorResult>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.TEST_RESULT__PAGE_RESULTS:
				getPageResults().clear();
				return;
			case ModelPackage.TEST_RESULT__ACTOR_RESULTS:
				getActorResults().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.TEST_RESULT__PAGE_RESULTS:
				return pageResults != null && !pageResults.isEmpty();
			case ModelPackage.TEST_RESULT__ACTOR_RESULTS:
				return actorResults != null && !actorResults.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestResultImpl
