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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.webtest.model.ActorMethodResult;
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.Coverage;
import org.nasdanika.webtest.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.ActorResultImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ActorResultImpl#getCoverage <em>Coverage</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ActorResultImpl#isProxy <em>Proxy</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ActorResultImpl#isDelegate <em>Delegate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActorResultImpl extends DescriptorImpl implements ActorResult {
	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorMethodResult> results;

	/**
	 * The cached value of the '{@link #getCoverage() <em>Coverage</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoverage()
	 * @generated
	 * @ordered
	 */
	protected EList<Coverage> coverage;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ACTOR_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorMethodResult> getResults() {
		if (results == null) {
			results = new EObjectWithInverseResolvingEList<ActorMethodResult>(ActorMethodResult.class, this, ModelPackage.ACTOR_RESULT__RESULTS, ModelPackage.ACTOR_METHOD_RESULT__ACTOR_RESULT);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Coverage> getCoverage() {
		if (coverage == null) {
			coverage = new EObjectContainmentEList<Coverage>(Coverage.class, this, ModelPackage.ACTOR_RESULT__COVERAGE);
		}
		return coverage;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACTOR_RESULT__PROXY, oldProxy, proxy));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ACTOR_RESULT__DELEGATE, oldDelegate, delegate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ACTOR_RESULT__RESULTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getResults()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ACTOR_RESULT__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
			case ModelPackage.ACTOR_RESULT__COVERAGE:
				return ((InternalEList<?>)getCoverage()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.ACTOR_RESULT__RESULTS:
				return getResults();
			case ModelPackage.ACTOR_RESULT__COVERAGE:
				return getCoverage();
			case ModelPackage.ACTOR_RESULT__PROXY:
				return isProxy();
			case ModelPackage.ACTOR_RESULT__DELEGATE:
				return isDelegate();
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
			case ModelPackage.ACTOR_RESULT__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends ActorMethodResult>)newValue);
				return;
			case ModelPackage.ACTOR_RESULT__COVERAGE:
				getCoverage().clear();
				getCoverage().addAll((Collection<? extends Coverage>)newValue);
				return;
			case ModelPackage.ACTOR_RESULT__PROXY:
				setProxy((Boolean)newValue);
				return;
			case ModelPackage.ACTOR_RESULT__DELEGATE:
				setDelegate((Boolean)newValue);
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
			case ModelPackage.ACTOR_RESULT__RESULTS:
				getResults().clear();
				return;
			case ModelPackage.ACTOR_RESULT__COVERAGE:
				getCoverage().clear();
				return;
			case ModelPackage.ACTOR_RESULT__PROXY:
				setProxy(PROXY_EDEFAULT);
				return;
			case ModelPackage.ACTOR_RESULT__DELEGATE:
				setDelegate(DELEGATE_EDEFAULT);
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
			case ModelPackage.ACTOR_RESULT__RESULTS:
				return results != null && !results.isEmpty();
			case ModelPackage.ACTOR_RESULT__COVERAGE:
				return coverage != null && !coverage.isEmpty();
			case ModelPackage.ACTOR_RESULT__PROXY:
				return proxy != PROXY_EDEFAULT;
			case ModelPackage.ACTOR_RESULT__DELEGATE:
				return delegate != DELEGATE_EDEFAULT;
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

} //ActorResultImpl
