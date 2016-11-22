/**
 */
package org.nasdanika.codegen;

import org.eclipse.core.resources.IProject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Workspace Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Workspace root does not really generate anything because there is only 
 * one already existing workspace root. This model element is used for grouping projects.
 * <!-- end-model-doc -->
 *
 *
 * @see org.nasdanika.codegen.CodegenPackage#getWorkspaceRoot()
 * @model superTypes="org.nasdanika.codegen.Group<org.nasdanika.codegen.IProject>"
 * @generated
 */
public interface WorkspaceRoot extends Group<IProject> {

} // WorkspaceRoot
