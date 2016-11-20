/**
 */
package org.nasdanika.codegen.impl;

import java.io.InputStream;
import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.BinaryFile;
import org.nasdanika.codegen.CodegenPackage;

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

} //BinaryFileImpl
