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

import org.nasdanika.webtest.model.Locator;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.WebElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Web Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.WebElementImpl#getLocators <em>Locators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WebElementImpl extends DescriptorImpl implements WebElement {
	/**
	 * The cached value of the '{@link #getLocators() <em>Locators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocators()
	 * @generated
	 * @ordered
	 */
	protected EList<Locator> locators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WebElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.WEB_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Locator> getLocators() {
		if (locators == null) {
			locators = new EObjectContainmentEList<Locator>(Locator.class, this, ModelPackage.WEB_ELEMENT__LOCATORS);
		}
		return locators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.WEB_ELEMENT__LOCATORS:
				return ((InternalEList<?>)getLocators()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.WEB_ELEMENT__LOCATORS:
				return getLocators();
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
			case ModelPackage.WEB_ELEMENT__LOCATORS:
				getLocators().clear();
				getLocators().addAll((Collection<? extends Locator>)newValue);
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
			case ModelPackage.WEB_ELEMENT__LOCATORS:
				getLocators().clear();
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
			case ModelPackage.WEB_ELEMENT__LOCATORS:
				return locators != null && !locators.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WebElementImpl
