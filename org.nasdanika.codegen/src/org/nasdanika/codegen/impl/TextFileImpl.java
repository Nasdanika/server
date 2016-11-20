/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.TextFile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text File</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TextFileImpl extends FileImpl<String> implements TextFile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.TEXT_FILE;
	}

} //TextFileImpl
