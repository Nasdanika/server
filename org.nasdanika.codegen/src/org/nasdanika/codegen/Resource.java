/**
 */
package org.nasdanika.codegen;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.Resource#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.Resource#getReconcileAction <em>Reconcile Action</em>}</li>
 * </ul>
 *
 * @see org.nasdanika.codegen.CodegenPackage#getResource()
 * @model abstract="true"
 * @extends CDOObject
 * @generated
 */
public interface Resource extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.nasdanika.codegen.CodegenPackage#getResource_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Resource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Reconcile Action</b></em>' attribute.
	 * The default value is <code>"Merge"</code>.
	 * The literals are from the enumeration {@link org.nasdanika.codegen.ReconcileAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reconcile Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reconcile Action</em>' attribute.
	 * @see org.nasdanika.codegen.ReconcileAction
	 * @see #setReconcileAction(ReconcileAction)
	 * @see org.nasdanika.codegen.CodegenPackage#getResource_ReconcileAction()
	 * @model default="Merge"
	 * @generated
	 */
	ReconcileAction getReconcileAction();

	/**
	 * Sets the value of the '{@link org.nasdanika.codegen.Resource#getReconcileAction <em>Reconcile Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reconcile Action</em>' attribute.
	 * @see org.nasdanika.codegen.ReconcileAction
	 * @see #getReconcileAction()
	 * @generated
	 */
	void setReconcileAction(ReconcileAction value);

} // Resource
