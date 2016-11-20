/**
 */
package org.nasdanika.codegen.impl;

import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.JavaStreamGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Stream Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class JavaStreamGeneratorImpl extends JavaGeneratorImpl<InputStream> implements JavaStreamGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaStreamGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.JAVA_STREAM_GENERATOR;
	}

} //JavaStreamGeneratorImpl
