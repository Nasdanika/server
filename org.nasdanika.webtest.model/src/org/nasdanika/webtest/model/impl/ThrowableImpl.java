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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Throwable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.ThrowableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ThrowableImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ThrowableImpl#getStackTrace <em>Stack Trace</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ThrowableImpl#getSupressed <em>Supressed</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ThrowableImpl#getCause <em>Cause</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ThrowableImpl extends MinimalEObjectImpl.Container implements org.nasdanika.webtest.model.Throwable {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStackTrace() <em>Stack Trace</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStackTrace()
	 * @generated
	 * @ordered
	 */
	protected EList<StackTraceEntry> stackTrace;

	/**
	 * The cached value of the '{@link #getSupressed() <em>Supressed</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupressed()
	 * @generated
	 * @ordered
	 */
	protected EList<org.nasdanika.webtest.model.Throwable> supressed;

	/**
	 * The cached value of the '{@link #getCause() <em>Cause</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCause()
	 * @generated
	 * @ordered
	 */
	protected org.nasdanika.webtest.model.Throwable cause;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThrowableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.THROWABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.THROWABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.THROWABLE__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StackTraceEntry> getStackTrace() {
		if (stackTrace == null) {
			stackTrace = new EObjectContainmentEList<StackTraceEntry>(StackTraceEntry.class, this, ModelPackage.THROWABLE__STACK_TRACE);
		}
		return stackTrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.nasdanika.webtest.model.Throwable> getSupressed() {
		if (supressed == null) {
			supressed = new EObjectContainmentEList<org.nasdanika.webtest.model.Throwable>(org.nasdanika.webtest.model.Throwable.class, this, ModelPackage.THROWABLE__SUPRESSED);
		}
		return supressed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.nasdanika.webtest.model.Throwable getCause() {
		return cause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCause(org.nasdanika.webtest.model.Throwable newCause, NotificationChain msgs) {
		org.nasdanika.webtest.model.Throwable oldCause = cause;
		cause = newCause;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.THROWABLE__CAUSE, oldCause, newCause);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCause(org.nasdanika.webtest.model.Throwable newCause) {
		if (newCause != cause) {
			NotificationChain msgs = null;
			if (cause != null)
				msgs = ((InternalEObject)cause).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.THROWABLE__CAUSE, null, msgs);
			if (newCause != null)
				msgs = ((InternalEObject)newCause).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.THROWABLE__CAUSE, null, msgs);
			msgs = basicSetCause(newCause, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.THROWABLE__CAUSE, newCause, newCause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.THROWABLE__STACK_TRACE:
				return ((InternalEList<?>)getStackTrace()).basicRemove(otherEnd, msgs);
			case ModelPackage.THROWABLE__SUPRESSED:
				return ((InternalEList<?>)getSupressed()).basicRemove(otherEnd, msgs);
			case ModelPackage.THROWABLE__CAUSE:
				return basicSetCause(null, msgs);
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
			case ModelPackage.THROWABLE__TYPE:
				return getType();
			case ModelPackage.THROWABLE__MESSAGE:
				return getMessage();
			case ModelPackage.THROWABLE__STACK_TRACE:
				return getStackTrace();
			case ModelPackage.THROWABLE__SUPRESSED:
				return getSupressed();
			case ModelPackage.THROWABLE__CAUSE:
				return getCause();
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
			case ModelPackage.THROWABLE__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.THROWABLE__MESSAGE:
				setMessage((String)newValue);
				return;
			case ModelPackage.THROWABLE__STACK_TRACE:
				getStackTrace().clear();
				getStackTrace().addAll((Collection<? extends StackTraceEntry>)newValue);
				return;
			case ModelPackage.THROWABLE__SUPRESSED:
				getSupressed().clear();
				getSupressed().addAll((Collection<? extends org.nasdanika.webtest.model.Throwable>)newValue);
				return;
			case ModelPackage.THROWABLE__CAUSE:
				setCause((org.nasdanika.webtest.model.Throwable)newValue);
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
			case ModelPackage.THROWABLE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.THROWABLE__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case ModelPackage.THROWABLE__STACK_TRACE:
				getStackTrace().clear();
				return;
			case ModelPackage.THROWABLE__SUPRESSED:
				getSupressed().clear();
				return;
			case ModelPackage.THROWABLE__CAUSE:
				setCause((org.nasdanika.webtest.model.Throwable)null);
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
			case ModelPackage.THROWABLE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.THROWABLE__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case ModelPackage.THROWABLE__STACK_TRACE:
				return stackTrace != null && !stackTrace.isEmpty();
			case ModelPackage.THROWABLE__SUPRESSED:
				return supressed != null && !supressed.isEmpty();
			case ModelPackage.THROWABLE__CAUSE:
				return cause != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", message: ");
		result.append(message);
		result.append(')');
		return result.toString();
	}

} //ThrowableImpl
