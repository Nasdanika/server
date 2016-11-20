/**
 */
package org.nasdanika.codegen.impl;

import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.JavaStreamFilter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Stream Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class JavaStreamFilterImpl extends JavaFilterImpl<InputStream> implements JavaStreamFilter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaStreamFilterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.JAVA_STREAM_FILTER;
	}

} //JavaStreamFilterImpl
