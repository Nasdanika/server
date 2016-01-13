/**
 */
package org.nasdanika.webtest.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.TestClassResult;
import org.nasdanika.webtest.model.TestMethodResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Class Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestClassResultImpl#getMethodResults <em>Method Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestClassResultImpl#getStats <em>Stats</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestClassResultImpl extends TestResultImpl implements TestClassResult {
	/**
	 * The cached value of the '{@link #getMethodResults() <em>Method Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodResults()
	 * @generated
	 * @ordered
	 */
	protected EList<TestMethodResult> methodResults;

	/**
	 * The cached value of the '{@link #getStats() <em>Stats</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStats()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Integer> stats;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestClassResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TEST_CLASS_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestMethodResult> getMethodResults() {
		if (methodResults == null) {
			methodResults = new EObjectContainmentEList<TestMethodResult>(TestMethodResult.class, this, ModelPackage.TEST_CLASS_RESULT__METHOD_RESULTS);
		}
		return methodResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Integer> getStats() {
		if (stats == null) {
			stats = new EcoreEMap<String,Integer>(ModelPackage.Literals.STATS_ENTRY, StatsEntryImpl.class, this, ModelPackage.TEST_CLASS_RESULT__STATS);
		}
		return stats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TEST_CLASS_RESULT__METHOD_RESULTS:
				return ((InternalEList<?>)getMethodResults()).basicRemove(otherEnd, msgs);
			case ModelPackage.TEST_CLASS_RESULT__STATS:
				return ((InternalEList<?>)getStats()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.TEST_CLASS_RESULT__METHOD_RESULTS:
				return getMethodResults();
			case ModelPackage.TEST_CLASS_RESULT__STATS:
				if (coreType) return getStats();
				else return getStats().map();
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
			case ModelPackage.TEST_CLASS_RESULT__METHOD_RESULTS:
				getMethodResults().clear();
				getMethodResults().addAll((Collection<? extends TestMethodResult>)newValue);
				return;
			case ModelPackage.TEST_CLASS_RESULT__STATS:
				((EStructuralFeature.Setting)getStats()).set(newValue);
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
			case ModelPackage.TEST_CLASS_RESULT__METHOD_RESULTS:
				getMethodResults().clear();
				return;
			case ModelPackage.TEST_CLASS_RESULT__STATS:
				getStats().clear();
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
			case ModelPackage.TEST_CLASS_RESULT__METHOD_RESULTS:
				return methodResults != null && !methodResults.isEmpty();
			case ModelPackage.TEST_CLASS_RESULT__STATS:
				return stats != null && !stats.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TestClassResultImpl
