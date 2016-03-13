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
import org.nasdanika.webtest.model.Descriptor;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.ParameterizedTestResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameterized Test Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.ParameterizedTestResultImpl#getParameterDescriptors <em>Parameter Descriptors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterizedTestResultImpl extends TestSuiteResultImpl implements ParameterizedTestResult {
	/**
	 * The cached value of the '{@link #getParameterDescriptors() <em>Parameter Descriptors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterDescriptors()
	 * @generated
	 * @ordered
	 */
	protected EList<Descriptor> parameterDescriptors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterizedTestResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PARAMETERIZED_TEST_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Descriptor> getParameterDescriptors() {
		if (parameterDescriptors == null) {
			parameterDescriptors = new EObjectContainmentEList<Descriptor>(Descriptor.class, this, ModelPackage.PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS);
		}
		return parameterDescriptors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS:
				return ((InternalEList<?>)getParameterDescriptors()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS:
				return getParameterDescriptors();
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
			case ModelPackage.PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS:
				getParameterDescriptors().clear();
				getParameterDescriptors().addAll((Collection<? extends Descriptor>)newValue);
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
			case ModelPackage.PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS:
				getParameterDescriptors().clear();
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
			case ModelPackage.PARAMETERIZED_TEST_RESULT__PARAMETER_DESCRIPTORS:
				return parameterDescriptors != null && !parameterDescriptors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ParameterizedTestResultImpl
