/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Service;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.ServiceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ServiceImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ServiceImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ServiceImpl<T> extends ConfigurableImpl implements Service<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)eGet(CodegenPackage.Literals.SERVICE__TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		eSet(CodegenPackage.Literals.SERVICE__TYPE, newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementation() {
		return (String)eGet(CodegenPackage.Literals.SERVICE__IMPLEMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(String newImplementation) {
		eSet(CodegenPackage.Literals.SERVICE__IMPLEMENTATION, newImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(CodegenPackage.Literals.SERVICE__DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(CodegenPackage.Literals.SERVICE__DESCRIPTION, newDescription);
	}

} //ServiceImpl
