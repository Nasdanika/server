/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Folder;
import org.nasdanika.codegen.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.FolderImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FolderImpl extends ResourceImpl<IFolder> implements Folder {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.FOLDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Resource<IFolder>> getChildren() {
		return (EList<Resource<IFolder>>)eGet(CodegenPackage.Literals.FOLDER__CHILDREN, true);
	}

} //FolderImpl
