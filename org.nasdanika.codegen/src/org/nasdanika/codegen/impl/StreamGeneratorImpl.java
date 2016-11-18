/**
 */
package org.nasdanika.codegen.impl;

import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.StreamGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stream Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class StreamGeneratorImpl extends GeneratorImpl<InputStream> implements StreamGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.STREAM_GENERATOR;
	}

} //StreamGeneratorImpl
