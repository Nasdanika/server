/**
 */
package org.nasdanika.codegen.impl;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.TextFile;
import org.nasdanika.codegen.Work;

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

	@Override
	public Work<List<IFile>> createWork(Context context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

} //TextFileImpl
