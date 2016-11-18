/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.JavaTextGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Text Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.JavaTextGeneratorImpl#getClassName <em>Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaTextGeneratorImpl extends TextGeneratorImpl implements JavaTextGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaTextGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.JAVA_TEXT_GENERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return (String)eGet(CodegenPackage.Literals.JAVA_TEXT_GENERATOR__CLASS_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		eSet(CodegenPackage.Literals.JAVA_TEXT_GENERATOR__CLASS_NAME, newClassName);
	}

} //JavaTextGeneratorImpl
