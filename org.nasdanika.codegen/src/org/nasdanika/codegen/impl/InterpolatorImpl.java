/**
 */
package org.nasdanika.codegen.impl;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Interpolator;
import org.nasdanika.codegen.Work;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interpolator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InterpolatorImpl extends FilterImpl<String> implements Interpolator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InterpolatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.INTERPOLATOR;
	}

	@Override
	public Work<List<String>> createWork(Context context, IProgressMonitor monitor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWorkFactorySize() {
		// TODO Auto-generated method stub
		return 0;
	}

} //InterpolatorImpl
