/**
 */
package org.nasdanika.codegen;

import org.eclipse.core.resources.IProject;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * .
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Project#getNatures <em>Natures</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Project#getResources <em>Resources</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Project#getReconcileAction <em>Reconcile Action</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getProject()
 * @model superTypes="org.nasdanika.codegen.ResourceGenerator<org.nasdanika.codegen.IProject>"
 * @generated
 */
public interface Project extends ResourceGenerator<IProject> {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * .
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Natures</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Nature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Natures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * .
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Natures</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getProject_Natures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Nature> getNatures();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link org.nasdanika.codegen.Resource}&lt;org.eclipse.core.resources.IResource>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * .
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see org.nasdanika.codegen.CodegenPackage#getProject_Resources()
	 * @model type="org.nasdanika.codegen.Resource<org.nasdanika.codegen.IResource>" containment="true"
	 * @generated
	 */
	EList<Resource<IResource>> getResources();

	/**
	 * Returns the value of the '<em><b>Reconcile Action</b></em>' attribute.
	 * The default value is <code>"Append"</code>.
	 * The literals are from the enumeration {@link org.nasdanika.codegen.ReconcileAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reconcile Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * .
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reconcile Action</em>' attribute.
	 * @see org.nasdanika.codegen.ReconcileAction
	 * @see #setReconcileAction(ReconcileAction)
	 * @see org.nasdanika.codegen.CodegenPackage#getProject_ReconcileAction()
	 * @model default="Append"
	 * @generated
	 */
	ReconcileAction getReconcileAction();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Project#getReconcileAction <em>Reconcile Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reconcile Action</em>' attribute.
	 * @see org.nasdanika.codegen.ReconcileAction
	 * @see #getReconcileAction()
	 * @generated
	 */
	void setReconcileAction(ReconcileAction value);

} // Project
