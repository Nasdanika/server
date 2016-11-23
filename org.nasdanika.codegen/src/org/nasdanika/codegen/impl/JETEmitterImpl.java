/**
 */
package org.nasdanika.codegen.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.JETEmitter;
import org.nasdanika.codegen.Work;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JET Emitter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.JETEmitterImpl#getTemplateURI <em>Template URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JETEmitterImpl extends GeneratorImpl<String> implements JETEmitter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JETEmitterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.JET_EMITTER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemplateURI() {
		return (String)eGet(CodegenPackage.Literals.JET_EMITTER__TEMPLATE_URI, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplateURI(String newTemplateURI) {
		eSet(CodegenPackage.Literals.JET_EMITTER__TEMPLATE_URI, newTemplateURI);
	}

	@Override
	public Work<List<String>> createWork(Context context, IProgressMonitor monitor) throws Exception {
		// TODO - this context creation, iteration, ...
		return new Work<List<String>>() {
			
			@Override
			public int size() {
				return 1;
			}
			
			@Override
			public List<String> execute(IProgressMonitor monitor) throws Exception {
				// TODO - relative URI
				org.eclipse.emf.codegen.jet.JETEmitter jetEmitter = new org.eclipse.emf.codegen.jet.JETEmitter(getTemplateURI(), context.getClassLoader());
				return Collections.singletonList(jetEmitter.generate(monitor, new Object[] { context }));
			}
		};
	}

	@Override
	public int getWorkFactorySize() {
		return 1;
	}

} //JETEmitterImpl
