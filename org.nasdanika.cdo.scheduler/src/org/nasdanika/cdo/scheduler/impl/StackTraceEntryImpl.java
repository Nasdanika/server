/**
 */
package org.nasdanika.cdo.scheduler.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.cdo.scheduler.SchedulerPackage;
import org.nasdanika.cdo.scheduler.StackTraceEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.impl.StackTraceEntryImpl#isNative <em>Native</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StackTraceEntryImpl extends CDOObjectImpl implements StackTraceEntry {
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
		return SchedulerPackage.Literals.STACK_TRACE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__CLASS_NAME, newClassName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileName() {
		return (String)eGet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__FILE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileName(String newFileName) {
		eSet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__FILE_NAME, newFileName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return (String)eGet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__METHOD_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		eSet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__METHOD_NAME, newMethodName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return (Integer)eGet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__LINE_NUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		eSet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__LINE_NUMBER, newLineNumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNative() {
		return (Boolean)eGet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__NATIVE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNative(boolean newNative) {
		eSet(SchedulerPackage.Literals.STACK_TRACE_ENTRY__NATIVE, newNative);
	}

} //StackTraceEntryImpl
