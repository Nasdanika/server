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

import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.OperationArgument;
import org.nasdanika.webtest.model.OperationResult;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.ScreenshotEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getScreenshots <em>Screenshots</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getFailure <em>Failure</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getError <em>Error</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getStart <em>Start</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getFinish <em>Finish</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.OperationResultImpl#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationResultImpl extends DescriptorImpl implements OperationResult {
	/**
	 * The cached value of the '{@link #getScreenshots() <em>Screenshots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScreenshots()
	 * @generated
	 * @ordered
	 */
	protected EList<ScreenshotEntry> screenshots;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationResult> children;

	/**
	 * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationName()
	 * @generated
	 * @ordered
	 */
	protected String operationName = OPERATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFailure() <em>Failure</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailure()
	 * @generated
	 * @ordered
	 */
	protected org.nasdanika.webtest.model.Throwable failure;

	/**
	 * The cached value of the '{@link #getError() <em>Error</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getError()
	 * @generated
	 * @ordered
	 */
	protected org.nasdanika.webtest.model.Throwable error;

	/**
	 * The default value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected static final long START_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected long start = START_EDEFAULT;

	/**
	 * The default value of the '{@link #getFinish() <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinish()
	 * @generated
	 * @ordered
	 */
	protected static final long FINISH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getFinish() <em>Finish</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinish()
	 * @generated
	 * @ordered
	 */
	protected long finish = FINISH_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final OperationStatus STATUS_EDEFAULT = OperationStatus.PASS;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected OperationStatus status = STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationArgument> arguments;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.OPERATION_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScreenshotEntry> getScreenshots() {
		if (screenshots == null) {
			screenshots = new EObjectContainmentEList<ScreenshotEntry>(ScreenshotEntry.class, this, ModelPackage.OPERATION_RESULT__SCREENSHOTS);
		}
		return screenshots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationResult> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<OperationResult>(OperationResult.class, this, ModelPackage.OPERATION_RESULT__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationName(String newOperationName) {
		String oldOperationName = operationName;
		operationName = newOperationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__OPERATION_NAME, oldOperationName, operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.webtest.model.Throwable getFailure() {
		return failure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFailure(org.nasdanika.webtest.model.Throwable newFailure, NotificationChain msgs) {
		org.nasdanika.webtest.model.Throwable oldFailure = failure;
		failure = newFailure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__FAILURE, oldFailure, newFailure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailure(org.nasdanika.webtest.model.Throwable newFailure) {
		if (newFailure != failure) {
			NotificationChain msgs = null;
			if (failure != null)
				msgs = ((InternalEObject)failure).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPERATION_RESULT__FAILURE, null, msgs);
			if (newFailure != null)
				msgs = ((InternalEObject)newFailure).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPERATION_RESULT__FAILURE, null, msgs);
			msgs = basicSetFailure(newFailure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__FAILURE, newFailure, newFailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.webtest.model.Throwable getError() {
		return error;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetError(org.nasdanika.webtest.model.Throwable newError, NotificationChain msgs) {
		org.nasdanika.webtest.model.Throwable oldError = error;
		error = newError;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__ERROR, oldError, newError);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setError(org.nasdanika.webtest.model.Throwable newError) {
		if (newError != error) {
			NotificationChain msgs = null;
			if (error != null)
				msgs = ((InternalEObject)error).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPERATION_RESULT__ERROR, null, msgs);
			if (newError != null)
				msgs = ((InternalEObject)newError).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPERATION_RESULT__ERROR, null, msgs);
			msgs = basicSetError(newError, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__ERROR, newError, newError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(long newStart) {
		long oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getFinish() {
		return finish;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinish(long newFinish) {
		long oldFinish = finish;
		finish = newFinish;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__FINISH, oldFinish, finish));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationStatus getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(OperationStatus newStatus) {
		OperationStatus oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_RESULT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationArgument> getArguments() {
		if (arguments == null) {
			arguments = new EObjectContainmentEList<OperationArgument>(OperationArgument.class, this, ModelPackage.OPERATION_RESULT__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.OPERATION_RESULT__SCREENSHOTS:
				return ((InternalEList<?>)getScreenshots()).basicRemove(otherEnd, msgs);
			case ModelPackage.OPERATION_RESULT__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case ModelPackage.OPERATION_RESULT__FAILURE:
				return basicSetFailure(null, msgs);
			case ModelPackage.OPERATION_RESULT__ERROR:
				return basicSetError(null, msgs);
			case ModelPackage.OPERATION_RESULT__ARGUMENTS:
				return ((InternalEList<?>)getArguments()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.OPERATION_RESULT__SCREENSHOTS:
				return getScreenshots();
			case ModelPackage.OPERATION_RESULT__CHILDREN:
				return getChildren();
			case ModelPackage.OPERATION_RESULT__OPERATION_NAME:
				return getOperationName();
			case ModelPackage.OPERATION_RESULT__FAILURE:
				return getFailure();
			case ModelPackage.OPERATION_RESULT__ERROR:
				return getError();
			case ModelPackage.OPERATION_RESULT__START:
				return getStart();
			case ModelPackage.OPERATION_RESULT__FINISH:
				return getFinish();
			case ModelPackage.OPERATION_RESULT__STATUS:
				return getStatus();
			case ModelPackage.OPERATION_RESULT__ARGUMENTS:
				return getArguments();
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
			case ModelPackage.OPERATION_RESULT__SCREENSHOTS:
				getScreenshots().clear();
				getScreenshots().addAll((Collection<? extends ScreenshotEntry>)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends OperationResult>)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__OPERATION_NAME:
				setOperationName((String)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__FAILURE:
				setFailure((org.nasdanika.webtest.model.Throwable)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__ERROR:
				setError((org.nasdanika.webtest.model.Throwable)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__START:
				setStart((Long)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__FINISH:
				setFinish((Long)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__STATUS:
				setStatus((OperationStatus)newValue);
				return;
			case ModelPackage.OPERATION_RESULT__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends OperationArgument>)newValue);
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
			case ModelPackage.OPERATION_RESULT__SCREENSHOTS:
				getScreenshots().clear();
				return;
			case ModelPackage.OPERATION_RESULT__CHILDREN:
				getChildren().clear();
				return;
			case ModelPackage.OPERATION_RESULT__OPERATION_NAME:
				setOperationName(OPERATION_NAME_EDEFAULT);
				return;
			case ModelPackage.OPERATION_RESULT__FAILURE:
				setFailure((org.nasdanika.webtest.model.Throwable)null);
				return;
			case ModelPackage.OPERATION_RESULT__ERROR:
				setError((org.nasdanika.webtest.model.Throwable)null);
				return;
			case ModelPackage.OPERATION_RESULT__START:
				setStart(START_EDEFAULT);
				return;
			case ModelPackage.OPERATION_RESULT__FINISH:
				setFinish(FINISH_EDEFAULT);
				return;
			case ModelPackage.OPERATION_RESULT__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case ModelPackage.OPERATION_RESULT__ARGUMENTS:
				getArguments().clear();
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
			case ModelPackage.OPERATION_RESULT__SCREENSHOTS:
				return screenshots != null && !screenshots.isEmpty();
			case ModelPackage.OPERATION_RESULT__CHILDREN:
				return children != null && !children.isEmpty();
			case ModelPackage.OPERATION_RESULT__OPERATION_NAME:
				return OPERATION_NAME_EDEFAULT == null ? operationName != null : !OPERATION_NAME_EDEFAULT.equals(operationName);
			case ModelPackage.OPERATION_RESULT__FAILURE:
				return failure != null;
			case ModelPackage.OPERATION_RESULT__ERROR:
				return error != null;
			case ModelPackage.OPERATION_RESULT__START:
				return start != START_EDEFAULT;
			case ModelPackage.OPERATION_RESULT__FINISH:
				return finish != FINISH_EDEFAULT;
			case ModelPackage.OPERATION_RESULT__STATUS:
				return status != STATUS_EDEFAULT;
			case ModelPackage.OPERATION_RESULT__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
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
		result.append(" (operationName: ");
		result.append(operationName);
		result.append(", start: ");
		result.append(start);
		result.append(", finish: ");
		result.append(finish);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //OperationResultImpl
