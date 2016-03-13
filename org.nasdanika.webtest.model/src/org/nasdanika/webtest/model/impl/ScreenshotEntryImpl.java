/**
 */
package org.nasdanika.webtest.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.Screenshot;
import org.nasdanika.webtest.model.ScreenshotEntry;
import org.nasdanika.webtest.model.ScreenshotType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Screenshot Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.ScreenshotEntryImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ScreenshotEntryImpl#getComment <em>Comment</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.ScreenshotEntryImpl#getScreenshot <em>Screenshot</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScreenshotEntryImpl extends MinimalEObjectImpl.Container implements ScreenshotEntry {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ScreenshotType TYPE_EDEFAULT = ScreenshotType.BEFORE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ScreenshotType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected static final String COMMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComment() <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComment()
	 * @generated
	 * @ordered
	 */
	protected String comment = COMMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScreenshot() <em>Screenshot</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScreenshot()
	 * @generated
	 * @ordered
	 */
	protected Screenshot screenshot;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScreenshotEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SCREENSHOT_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScreenshotType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ScreenshotType newType) {
		ScreenshotType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SCREENSHOT_ENTRY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComment(String newComment) {
		String oldComment = comment;
		comment = newComment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SCREENSHOT_ENTRY__COMMENT, oldComment, comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Screenshot getScreenshot() {
		if (screenshot != null && screenshot.eIsProxy()) {
			InternalEObject oldScreenshot = (InternalEObject)screenshot;
			screenshot = (Screenshot)eResolveProxy(oldScreenshot);
			if (screenshot != oldScreenshot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT, oldScreenshot, screenshot));
			}
		}
		return screenshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Screenshot basicGetScreenshot() {
		return screenshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScreenshot(Screenshot newScreenshot, NotificationChain msgs) {
		Screenshot oldScreenshot = screenshot;
		screenshot = newScreenshot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT, oldScreenshot, newScreenshot);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScreenshot(Screenshot newScreenshot) {
		if (newScreenshot != screenshot) {
			NotificationChain msgs = null;
			if (screenshot != null)
				msgs = ((InternalEObject)screenshot).eInverseRemove(this, ModelPackage.SCREENSHOT__ENTRIES, Screenshot.class, msgs);
			if (newScreenshot != null)
				msgs = ((InternalEObject)newScreenshot).eInverseAdd(this, ModelPackage.SCREENSHOT__ENTRIES, Screenshot.class, msgs);
			msgs = basicSetScreenshot(newScreenshot, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT, newScreenshot, newScreenshot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT:
				if (screenshot != null)
					msgs = ((InternalEObject)screenshot).eInverseRemove(this, ModelPackage.SCREENSHOT__ENTRIES, Screenshot.class, msgs);
				return basicSetScreenshot((Screenshot)otherEnd, msgs);
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
			case ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT:
				return basicSetScreenshot(null, msgs);
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
			case ModelPackage.SCREENSHOT_ENTRY__TYPE:
				return getType();
			case ModelPackage.SCREENSHOT_ENTRY__COMMENT:
				return getComment();
			case ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT:
				if (resolve) return getScreenshot();
				return basicGetScreenshot();
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
			case ModelPackage.SCREENSHOT_ENTRY__TYPE:
				setType((ScreenshotType)newValue);
				return;
			case ModelPackage.SCREENSHOT_ENTRY__COMMENT:
				setComment((String)newValue);
				return;
			case ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT:
				setScreenshot((Screenshot)newValue);
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
			case ModelPackage.SCREENSHOT_ENTRY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.SCREENSHOT_ENTRY__COMMENT:
				setComment(COMMENT_EDEFAULT);
				return;
			case ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT:
				setScreenshot((Screenshot)null);
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
			case ModelPackage.SCREENSHOT_ENTRY__TYPE:
				return type != TYPE_EDEFAULT;
			case ModelPackage.SCREENSHOT_ENTRY__COMMENT:
				return COMMENT_EDEFAULT == null ? comment != null : !COMMENT_EDEFAULT.equals(comment);
			case ModelPackage.SCREENSHOT_ENTRY__SCREENSHOT:
				return screenshot != null;
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
		result.append(", comment: ");
		result.append(comment);
		result.append(')');
		return result.toString();
	}

} //ScreenshotEntryImpl
