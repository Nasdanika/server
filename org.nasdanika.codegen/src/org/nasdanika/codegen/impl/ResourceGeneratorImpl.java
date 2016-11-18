/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.ResourceGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ResourceGeneratorImpl<T> extends GeneratorImpl<T> implements ResourceGenerator<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.RESOURCE_GENERATOR;
	}

} //ResourceGeneratorImpl
