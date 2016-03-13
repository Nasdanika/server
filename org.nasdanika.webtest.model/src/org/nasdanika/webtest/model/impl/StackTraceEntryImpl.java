/**
 */
package org.nasdanika.webtest.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.nasdanika.webtest.model.ModelPackage;
import org.nasdanika.webtest.model.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.nasdanika.webtest.model.impl.StackTraceEntryImpl#isNative <em>Native</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StackTraceEntryImpl extends MinimalEObjectImpl.Container implements StackTraceEntry {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNative() <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNative()
	 * @generated
	 * @ordered
	 */
	protected boolean native_ = NATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StackTraceEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.STACK_TRACE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_TRACE_ENTRY__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_TRACE_ENTRY__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_TRACE_ENTRY__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_TRACE_ENTRY__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative() {
		return native_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNative(boolean newNative) {
		boolean oldNative = native_;
		native_ = newNative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STACK_TRACE_ENTRY__NATIVE, oldNative, native_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.STACK_TRACE_ENTRY__CLASS_NAME:
				return getClassName();
			case ModelPackage.STACK_TRACE_ENTRY__FILE_NAME:
				return getFileName();
			case ModelPackage.STACK_TRACE_ENTRY__METHOD_NAME:
				return getMethodName();
			case ModelPackage.STACK_TRACE_ENTRY__LINE_NUMBER:
				return getLineNumber();
			case ModelPackage.STACK_TRACE_ENTRY__NATIVE:
				return isNative();
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
			case ModelPackage.STACK_TRACE_ENTRY__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__FILE_NAME:
				setFileName((String)newValue);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__LINE_NUMBER:
				setLineNumber((Integer)newValue);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__NATIVE:
				setNative((Boolean)newValue);
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
			case ModelPackage.STACK_TRACE_ENTRY__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
				return;
			case ModelPackage.STACK_TRACE_ENTRY__NATIVE:
				setNative(NATIVE_EDEFAULT);
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
			case ModelPackage.STACK_TRACE_ENTRY__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case ModelPackage.STACK_TRACE_ENTRY__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case ModelPackage.STACK_TRACE_ENTRY__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case ModelPackage.STACK_TRACE_ENTRY__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
			case ModelPackage.STACK_TRACE_ENTRY__NATIVE:
				return native_ != NATIVE_EDEFAULT;
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
		result.append(" (className: ");
		result.append(className);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(", native: ");
		result.append(native_);
		result.append(')');
		return result.toString();
	}

} //StackTraceEntryImpl
