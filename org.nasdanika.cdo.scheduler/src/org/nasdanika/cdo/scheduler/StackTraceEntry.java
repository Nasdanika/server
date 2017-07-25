/**
 */
package org.nasdanika.cdo.scheduler;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Trace Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getLineNumber <em>Line Number</em>}</li>
 *   <li>{@link org.nasdanika.cdo.scheduler.StackTraceEntry#isNative <em>Native</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getStackTraceEntry()
 * @model annotation="org.nasdanika.cdo.web.render icon='fa fa-bars' editable='false'"
 * @extends CDOObject
 * @generated
 */
public interface StackTraceEntry extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Class name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getStackTraceEntry_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * File name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>File Name</em>' attribute.
	 * @see #setFileName(String)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getStackTraceEntry_FileName()
	 * @model
	 * @generated
	 */
	String getFileName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getFileName <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Name</em>' attribute.
	 * @see #getFileName()
	 * @generated
	 */
	void setFileName(String value);

	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Method name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getStackTraceEntry_MethodName()
	 * @model
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Line number.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Line Number</em>' attribute.
	 * @see #setLineNumber(int)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getStackTraceEntry_LineNumber()
	 * @model
	 * @generated
	 */
	int getLineNumber();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#getLineNumber <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Number</em>' attribute.
	 * @see #getLineNumber()
	 * @generated
	 */
	void setLineNumber(int value);

	/**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 'true' for native methods.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see org.nasdanika.cdo.scheduler.SchedulerPackage#getStackTraceEntry_Native()
	 * @model
	 * @generated
	 */
	boolean isNative();

	/**
	 * Sets the value of the '{@link org.nasdanika.cdo.scheduler.StackTraceEntry#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
	void setNative(boolean value);

} // StackTraceEntry
