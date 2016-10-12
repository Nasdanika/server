/**
 */
package org.nasdanika.webtest.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.webtest.model.Method;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.WebElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Page Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.PageResultImpl#getWebElements <em>Web Elements</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.PageResultImpl#isProxy <em>Proxy</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.PageResultImpl#isDelegate <em>Delegate</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.PageResultImpl#getMethods <em>Methods</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PageResultImpl extends DescriptorImpl implements PageResult {
	/**
	 * The cached value of the '{@link #getWebElements() <em>Web Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWebElements()
	 * @generated
	 * @ordered
	 */
	protected EList<WebElement> webElements;

	/**
	 * The default value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProxy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROXY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isProxy() <em>Proxy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProxy()
	 * @generated
	 * @ordered
	 */
	protected boolean proxy = PROXY_EDEFAULT;

	/**
	 * The default value of the '{@link #isDelegate() <em>Delegate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDelegate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELEGATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDelegate() <em>Delegate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDelegate()
	 * @generated
	 * @ordered
	 */
	protected boolean delegate = DELEGATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PAGE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WebElement> getWebElements() {
		if (webElements == null) {
			webElements = new EObjectContainmentEList<WebElement>(WebElement.class, this, ModelPackage.PAGE_RESULT__WEB_ELEMENTS);
		}
		return webElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProxy() {
		return proxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxy(boolean newProxy) {
		boolean oldProxy = proxy;
		proxy = newProxy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE_RESULT__PROXY, oldProxy, proxy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDelegate() {
		return delegate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegate(boolean newDelegate) {
		boolean oldDelegate = delegate;
		delegate = newDelegate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE_RESULT__DELEGATE, oldDelegate, delegate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<Method>(Method.class, this, ModelPackage.PAGE_RESULT__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PAGE_RESULT__WEB_ELEMENTS:
				return ((InternalEList<?>)getWebElements()).basicRemove(otherEnd, msgs);
			case ModelPackage.PAGE_RESULT__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PAGE_RESULT__WEB_ELEMENTS:
				return getWebElements();
			case ModelPackage.PAGE_RESULT__PROXY:
				return isProxy();
			case ModelPackage.PAGE_RESULT__DELEGATE:
				return isDelegate();
			case ModelPackage.PAGE_RESULT__METHODS:
				return getMethods();
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
			case ModelPackage.PAGE_RESULT__WEB_ELEMENTS:
				getWebElements().clear();
				getWebElements().addAll((Collection<? extends WebElement>)newValue);
				return;
			case ModelPackage.PAGE_RESULT__PROXY:
				setProxy((Boolean)newValue);
				return;
			case ModelPackage.PAGE_RESULT__DELEGATE:
				setDelegate((Boolean)newValue);
				return;
			case ModelPackage.PAGE_RESULT__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
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
			case ModelPackage.PAGE_RESULT__WEB_ELEMENTS:
				getWebElements().clear();
				return;
			case ModelPackage.PAGE_RESULT__PROXY:
				setProxy(PROXY_EDEFAULT);
				return;
			case ModelPackage.PAGE_RESULT__DELEGATE:
				setDelegate(DELEGATE_EDEFAULT);
				return;
			case ModelPackage.PAGE_RESULT__METHODS:
				getMethods().clear();
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
			case ModelPackage.PAGE_RESULT__WEB_ELEMENTS:
				return webElements != null && !webElements.isEmpty();
			case ModelPackage.PAGE_RESULT__PROXY:
				return proxy != PROXY_EDEFAULT;
			case ModelPackage.PAGE_RESULT__DELEGATE:
				return delegate != DELEGATE_EDEFAULT;
			case ModelPackage.PAGE_RESULT__METHODS:
				return methods != null && !methods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (proxy: ");
		result.append(proxy);
		result.append(", delegate: ");
		result.append(delegate);
		result.append(')');
		return result.toString();
	}

} //PageResultImpl
