/**
 */
package org.nasdanika.webtest.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.nasdanika.webtest.model.Locator;
import org.nasdanika.webtest.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Locator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.LocatorImpl#getHow <em>How</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.LocatorImpl#getUsing <em>Using</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocatorImpl extends MinimalEObjectImpl.Container implements Locator {
	/**
	 * The default value of the '{@link #getHow() <em>How</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHow()
	 * @generated
	 * @ordered
	 */
	protected static final String HOW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHow() <em>How</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHow()
	 * @generated
	 * @ordered
	 */
	protected String how = HOW_EDEFAULT;

	/**
	 * The default value of the '{@link #getUsing() <em>Using</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsing()
	 * @generated
	 * @ordered
	 */
	protected static final String USING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUsing() <em>Using</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsing()
	 * @generated
	 * @ordered
	 */
	protected String using = USING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.LOCATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHow() {
		return how;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHow(String newHow) {
		String oldHow = how;
		how = newHow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATOR__HOW, oldHow, how));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUsing() {
		return using;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsing(String newUsing) {
		String oldUsing = using;
		using = newUsing;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LOCATOR__USING, oldUsing, using));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.LOCATOR__HOW:
				return getHow();
			case ModelPackage.LOCATOR__USING:
				return getUsing();
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
			case ModelPackage.LOCATOR__HOW:
				setHow((String)newValue);
				return;
			case ModelPackage.LOCATOR__USING:
				setUsing((String)newValue);
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
			case ModelPackage.LOCATOR__HOW:
				setHow(HOW_EDEFAULT);
				return;
			case ModelPackage.LOCATOR__USING:
				setUsing(USING_EDEFAULT);
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
			case ModelPackage.LOCATOR__HOW:
				return HOW_EDEFAULT == null ? how != null : !HOW_EDEFAULT.equals(how);
			case ModelPackage.LOCATOR__USING:
				return USING_EDEFAULT == null ? using != null : !USING_EDEFAULT.equals(using);
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
		result.append(" (how: ");
		result.append(how);
		result.append(", using: ");
		result.append(using);
		result.append(')');
		return result.toString();
	}

} //LocatorImpl
