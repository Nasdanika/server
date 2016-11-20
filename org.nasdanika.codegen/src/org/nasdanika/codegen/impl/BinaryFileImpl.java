/**
 */
package org.nasdanika.codegen.impl;

import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.BinaryFile;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Work;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary File</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BinaryFileImpl extends FileImpl<InputStream> implements BinaryFile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryFileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.BINARY_FILE;
	}

	@Override
	public Work<List<IFile>> createWork(Context context) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

} //BinaryFileImpl
