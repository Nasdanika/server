/**
 */
package org.nasdanika.codegen.java.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.Generator;

import org.nasdanika.codegen.java.JavaPackage;
import org.nasdanika.codegen.java.TextCompilationUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Compilation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.impl.TextCompilationUnitImpl#getGenerator <em>Generator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextCompilationUnitImpl extends CompilationUnitImpl implements TextCompilationUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextCompilationUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.TEXT_COMPILATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator<String> getGenerator() {
		return (Generator<String>)eGet(JavaPackage.Literals.TEXT_COMPILATION_UNIT__GENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerator(Generator<String> newGenerator) {
		eSet(JavaPackage.Literals.TEXT_COMPILATION_UNIT__GENERATOR, newGenerator);
	}

} //TextCompilationUnitImpl
