/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.JavaTextFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Text Filter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.JavaTextFilterImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaTextFilterImpl extends TextFilterImpl implements JavaTextFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaTextFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.JAVA_TEXT_FILTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(CodegenPackage.Literals.JAVA_TEXT_FILTER__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(CodegenPackage.Literals.JAVA_TEXT_FILTER__CLASS_NAME, newClassName);
	}

} //JavaTextFilterImpl
