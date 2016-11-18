/**
 */
package org.nasdanika.codegen;

import org.eclipse.core.resources.IWorkspaceRoot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.WorkspaceRoot#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getWorkspaceRoot()
 * @model superTypes="org.nasdanika.codegen.ResourceGenerator<org.nasdanika.codegen.IWorkspaceRoot>"
 * @generated
 */
public interface WorkspaceRoot extends ResourceGenerator<IWorkspaceRoot> {
	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Project}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Projects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getWorkspaceRoot_Projects()
	 * @model containment="true"
	 * @generated
	 */
	EList<Project> getProjects();

} // WorkspaceRoot
