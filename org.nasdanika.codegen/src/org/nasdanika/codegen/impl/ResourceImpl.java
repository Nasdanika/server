/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.ReconcileAction;
import org.nasdanika.codegen.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.ResourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ResourceImpl#getReconcileAction <em>Reconcile Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ResourceImpl extends CDOObjectImpl implements Resource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(CodegenPackage.Literals.RESOURCE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(CodegenPackage.Literals.RESOURCE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReconcileAction getReconcileAction() {
		return (ReconcileAction)eGet(CodegenPackage.Literals.RESOURCE__RECONCILE_ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReconcileAction(ReconcileAction newReconcileAction) {
		eSet(CodegenPackage.Literals.RESOURCE__RECONCILE_ACTION, newReconcileAction);
	}

} //ResourceImpl
