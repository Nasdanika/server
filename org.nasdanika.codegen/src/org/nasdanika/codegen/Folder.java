/**
 */
package org.nasdanika.codegen;

import org.eclipse.core.resources.IFolder;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Folder#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getFolder()
 * @model superTypes="org.nasdanika.codegen.Resource org.nasdanika.codegen.ResourceGenerator<org.nasdanika.codegen.IFolder>"
 * @generated
 */
public interface Folder extends Resource<IFolder> {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getFolder_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getChildren();

} // Folder
