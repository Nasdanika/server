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
import org.nasdanika.webtest.model.ActorResult;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.PageResult;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.TestResult;
import org.nasdanika.webtest.model.TestSession;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Session</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestSessionImpl#getTestResults <em>Test Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestSessionImpl#getPageResults <em>Page Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestSessionImpl#getActorResults <em>Actor Results</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestSessionImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestSessionImpl#getNode <em>Node</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.TestSessionImpl#getScreenshots <em>Screenshots</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSessionImpl extends DescriptorImpl implements TestSession {
	/**
	 * The cached value of the '{@link #getTestResults() <em>Test Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestResults()
	 * @generated
	 * @ordered
	 */
	protected EList<TestResult> testResults;

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
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final long TIMESTAMP_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected long timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected String node = NODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScreenshots() <em>Screenshots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScreenshots()
	 * @generated
	 * @ordered
	 */
	protected EList<Screenshot> screenshots;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSessionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TEST_SESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TestResult> getTestResults() {
		if (testResults == null) {
			testResults = new EObjectContainmentEList<TestResult>(TestResult.class, this, ModelPackage.TEST_SESSION__TEST_RESULTS);
		}
		return testResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PageResult> getPageResults() {
		if (pageResults == null) {
			pageResults = new EObjectContainmentEList<PageResult>(PageResult.class, this, ModelPackage.TEST_SESSION__PAGE_RESULTS);
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
			actorResults = new EObjectContainmentEList<ActorResult>(ActorResult.class, this, ModelPackage.TEST_SESSION__ACTOR_RESULTS);
		}
		return actorResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimestamp(long newTimestamp) {
		long oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_SESSION__TIMESTAMP, oldTimestamp, timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(String newNode) {
		String oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TEST_SESSION__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Screenshot> getScreenshots() {
		if (screenshots == null) {
			screenshots = new EObjectContainmentEList<Screenshot>(Screenshot.class, this, ModelPackage.TEST_SESSION__SCREENSHOTS);
		}
		return screenshots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TEST_SESSION__TEST_RESULTS:
				return ((InternalEList<?>)getTestResults()).basicRemove(otherEnd, msgs);
			case ModelPackage.TEST_SESSION__PAGE_RESULTS:
				return ((InternalEList<?>)getPageResults()).basicRemove(otherEnd, msgs);
			case ModelPackage.TEST_SESSION__ACTOR_RESULTS:
				return ((InternalEList<?>)getActorResults()).basicRemove(otherEnd, msgs);
			case ModelPackage.TEST_SESSION__SCREENSHOTS:
				return ((InternalEList<?>)getScreenshots()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.TEST_SESSION__TEST_RESULTS:
				return getTestResults();
			case ModelPackage.TEST_SESSION__PAGE_RESULTS:
				return getPageResults();
			case ModelPackage.TEST_SESSION__ACTOR_RESULTS:
				return getActorResults();
			case ModelPackage.TEST_SESSION__TIMESTAMP:
				return getTimestamp();
			case ModelPackage.TEST_SESSION__NODE:
				return getNode();
			case ModelPackage.TEST_SESSION__SCREENSHOTS:
				return getScreenshots();
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
			case ModelPackage.TEST_SESSION__TEST_RESULTS:
				getTestResults().clear();
				getTestResults().addAll((Collection<? extends TestResult>)newValue);
				return;
			case ModelPackage.TEST_SESSION__PAGE_RESULTS:
				getPageResults().clear();
				getPageResults().addAll((Collection<? extends PageResult>)newValue);
				return;
			case ModelPackage.TEST_SESSION__ACTOR_RESULTS:
				getActorResults().clear();
				getActorResults().addAll((Collection<? extends ActorResult>)newValue);
				return;
			case ModelPackage.TEST_SESSION__TIMESTAMP:
				setTimestamp((Long)newValue);
				return;
			case ModelPackage.TEST_SESSION__NODE:
				setNode((String)newValue);
				return;
			case ModelPackage.TEST_SESSION__SCREENSHOTS:
				getScreenshots().clear();
				getScreenshots().addAll((Collection<? extends Screenshot>)newValue);
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
			case ModelPackage.TEST_SESSION__TEST_RESULTS:
				getTestResults().clear();
				return;
			case ModelPackage.TEST_SESSION__PAGE_RESULTS:
				getPageResults().clear();
				return;
			case ModelPackage.TEST_SESSION__ACTOR_RESULTS:
				getActorResults().clear();
				return;
			case ModelPackage.TEST_SESSION__TIMESTAMP:
				setTimestamp(TIMESTAMP_EDEFAULT);
				return;
			case ModelPackage.TEST_SESSION__NODE:
				setNode(NODE_EDEFAULT);
				return;
			case ModelPackage.TEST_SESSION__SCREENSHOTS:
				getScreenshots().clear();
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
			case ModelPackage.TEST_SESSION__TEST_RESULTS:
				return testResults != null && !testResults.isEmpty();
			case ModelPackage.TEST_SESSION__PAGE_RESULTS:
				return pageResults != null && !pageResults.isEmpty();
			case ModelPackage.TEST_SESSION__ACTOR_RESULTS:
				return actorResults != null && !actorResults.isEmpty();
			case ModelPackage.TEST_SESSION__TIMESTAMP:
				return timestamp != TIMESTAMP_EDEFAULT;
			case ModelPackage.TEST_SESSION__NODE:
				return NODE_EDEFAULT == null ? node != null : !NODE_EDEFAULT.equals(node);
			case ModelPackage.TEST_SESSION__SCREENSHOTS:
				return screenshots != null && !screenshots.isEmpty();
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
		result.append(" (timestamp: ");
		result.append(timestamp);
		result.append(", node: ");
		result.append(node);
		result.append(')');
		return result.toString();
	}

} //TestSessionImpl
