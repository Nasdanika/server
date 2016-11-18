/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.TextGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class TextGeneratorImpl extends GeneratorImpl<String> implements TextGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.TEXT_GENERATOR;
	}

} //TextGeneratorImpl
