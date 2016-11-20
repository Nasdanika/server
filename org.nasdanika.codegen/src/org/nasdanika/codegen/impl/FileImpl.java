/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.File;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.FileImpl#getMerger <em>Merger</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.FileImpl#getGenerator <em>Generator</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FileImpl<C> extends ResourceImpl<IFile> implements File<C> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.FILE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service getMerger() {
		return (Service)eGet(CodegenPackage.Literals.FILE__MERGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMerger(Service newMerger) {
		eSet(CodegenPackage.Literals.FILE__MERGER, newMerger);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator<C> getGenerator() {
		return (Generator<C>)eGet(CodegenPackage.Literals.FILE__GENERATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenerator(Generator<C> newGenerator) {
		eSet(CodegenPackage.Literals.FILE__GENERATOR, newGenerator);
	}

} //FileImpl
