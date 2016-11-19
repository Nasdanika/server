/**
 */
package org.nasdanika.codegen.impl;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Nature;
import org.nasdanika.codegen.Project;
import org.nasdanika.codegen.ReconcileAction;
import org.nasdanika.codegen.Resource;
import org.nasdanika.codegen.SubContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.ProjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ProjectImpl#getNatures <em>Natures</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ProjectImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.nasdanika.codegen.impl.ProjectImpl#getReconcileAction <em>Reconcile Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends ResourceGeneratorImpl<IProject> implements Project {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(CodegenPackage.Literals.PROJECT__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(CodegenPackage.Literals.PROJECT__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Nature> getNatures() {
		return (EList<Nature>)eGet(CodegenPackage.Literals.PROJECT__NATURES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Resource<IFolder>> getResources() {
		return (EList<Resource<IFolder>>)eGet(CodegenPackage.Literals.PROJECT__RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReconcileAction getReconcileAction() {
		return (ReconcileAction)eGet(CodegenPackage.Literals.PROJECT__RECONCILE_ACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReconcileAction(ReconcileAction newReconcileAction) {
		eSet(CodegenPackage.Literals.PROJECT__RECONCILE_ACTION, newReconcileAction);
	}
	
	@Override
	public IProject generate(Context context, IProgressMonitor monitor) throws Exception {
		IProject project = null; // TODO
		SubContext pctx = context.createSubContext().set(IProject.class, project);
		SubMonitor sm = SubMonitor.convert(monitor, getTotalWork());
		for (Resource<?> res: getResources()) {
			res.generate(pctx, sm.split(res.getTotalWork()));
		}
		for (Nature nature: getNatures()) {
			nature.generate(pctx, sm.split(nature.getTotalWork()));
		}
		return project;
	}

	@Override
	public int getTotalWork() {
		int ret = 1;
		for (Resource<?> res: getResources()) {
			ret += res.getTotalWork();
		}
		for (Nature nature: getNatures()) {
			ret += nature.getTotalWork();
		}
		return ret;
	}
	

} //ProjectImpl
