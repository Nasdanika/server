/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Resource;
import org.nasdanika.codegen.ResourceReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.ResourceReferenceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceReferenceImpl extends ResourceImpl implements ResourceReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.RESOURCE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getTarget() {
		return (Resource)eGet(CodegenPackage.Literals.RESOURCE_REFERENCE__TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Resource newTarget) {
		eSet(CodegenPackage.Literals.RESOURCE_REFERENCE__TARGET, newTarget);
	}

} //ResourceReferenceImpl
