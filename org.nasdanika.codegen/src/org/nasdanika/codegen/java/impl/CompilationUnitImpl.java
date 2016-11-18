/**
 */
package org.nasdanika.codegen.java.impl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.core.ICompilationUnit;

import org.nasdanika.codegen.TextGenerator;

import org.nasdanika.codegen.impl.GeneratorImpl;

import org.nasdanika.codegen.java.CompilationUnit;
import org.nasdanika.codegen.java.JavaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compilation Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.java.impl.CompilationUnitImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.java.impl.CompilationUnitImpl#getSourceGenerator <em>Source Generator</em>}</li>
 *   <li>{@link org.nasdanika.codegen.java.impl.CompilationUnitImpl#isMerge <em>Merge</em>}</li>
 *   <li>{@link org.nasdanika.codegen.java.impl.CompilationUnitImpl#isFormat <em>Format</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompilationUnitImpl extends GeneratorImpl<ICompilationUnit> implements CompilationUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompilationUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaPackage.Literals.COMPILATION_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(JavaPackage.Literals.COMPILATION_UNIT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(JavaPackage.Literals.COMPILATION_UNIT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<TextGenerator> getSourceGenerator() {
		return (EList<TextGenerator>)eGet(JavaPackage.Literals.COMPILATION_UNIT__SOURCE_GENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMerge() {
		return (Boolean)eGet(JavaPackage.Literals.COMPILATION_UNIT__MERGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMerge(boolean newMerge) {
		eSet(JavaPackage.Literals.COMPILATION_UNIT__MERGE, newMerge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFormat() {
		return (Boolean)eGet(JavaPackage.Literals.COMPILATION_UNIT__FORMAT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(boolean newFormat) {
		eSet(JavaPackage.Literals.COMPILATION_UNIT__FORMAT, newFormat);
	}

} //CompilationUnitImpl
