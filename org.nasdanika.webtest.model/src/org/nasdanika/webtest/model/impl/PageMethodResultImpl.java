/**
 */
package org.nasdanika.webtest.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.PageMethodResult;
import org.nasdanika.webtest.model.PageResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Method Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.PageMethodResultImpl#getPageResult <em>Page Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PageMethodResultImpl extends MethodResultImpl implements PageMethodResult {
	/**
	 * The cached value of the '{@link #getPageResult() <em>Page Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageResult()
	 * @generated
	 * @ordered
	 */
	protected PageResult pageResult;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageMethodResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PAGE_METHOD_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageResult getPageResult() {
		if (pageResult != null && pageResult.eIsProxy()) {
			InternalEObject oldPageResult = (InternalEObject)pageResult;
			pageResult = (PageResult)eResolveProxy(oldPageResult);
			if (pageResult != oldPageResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT, oldPageResult, pageResult));
			}
		}
		return pageResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PageResult basicGetPageResult() {
		return pageResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPageResult(PageResult newPageResult, NotificationChain msgs) {
		PageResult oldPageResult = pageResult;
		pageResult = newPageResult;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT, oldPageResult, newPageResult);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageResult(PageResult newPageResult) {
		if (newPageResult != pageResult) {
			NotificationChain msgs = null;
			if (pageResult != null)
				msgs = ((InternalEObject)pageResult).eInverseRemove(this, ModelPackage.PAGE_RESULT__RESULTS, PageResult.class, msgs);
			if (newPageResult != null)
				msgs = ((InternalEObject)newPageResult).eInverseAdd(this, ModelPackage.PAGE_RESULT__RESULTS, PageResult.class, msgs);
			msgs = basicSetPageResult(newPageResult, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT, newPageResult, newPageResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT:
				if (pageResult != null)
					msgs = ((InternalEObject)pageResult).eInverseRemove(this, ModelPackage.PAGE_RESULT__RESULTS, PageResult.class, msgs);
				return basicSetPageResult((PageResult)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT:
				return basicSetPageResult(null, msgs);
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
			case ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT:
				if (resolve) return getPageResult();
				return basicGetPageResult();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT:
				setPageResult((PageResult)newValue);
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
			case ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT:
				setPageResult((PageResult)null);
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
			case ModelPackage.PAGE_METHOD_RESULT__PAGE_RESULT:
				return pageResult != null;
		}
		return super.eIsSet(featureID);
	}

} //PageMethodResultImpl
