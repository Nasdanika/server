/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.core.resources.IWorkspaceRoot;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Project;
import org.nasdanika.codegen.WorkspaceRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.WorkspaceRootImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkspaceRootImpl extends ResourceGeneratorImpl<IWorkspaceRoot> implements WorkspaceRoot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.WORKSPACE_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Project> getProjects() {
		return (EList<Project>)eGet(CodegenPackage.Literals.WORKSPACE_ROOT__PROJECTS, true);
	}

} //WorkspaceRootImpl
