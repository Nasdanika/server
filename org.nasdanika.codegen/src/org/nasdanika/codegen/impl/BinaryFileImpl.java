/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.BinaryFile;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.StreamGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.BinaryFileImpl#getStreamgenerator <em>Streamgenerator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryFileImpl extends FileImpl implements BinaryFile {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StreamGenerator getStreamgenerator() {
		return (StreamGenerator)eGet(CodegenPackage.Literals.BINARY_FILE__STREAMGENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStreamgenerator(StreamGenerator newStreamgenerator) {
		eSet(CodegenPackage.Literals.BINARY_FILE__STREAMGENERATOR, newStreamgenerator);
	}

} //BinaryFileImpl
