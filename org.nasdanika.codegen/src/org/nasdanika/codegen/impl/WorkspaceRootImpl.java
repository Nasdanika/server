/**
 */
package org.nasdanika.codegen.impl;

import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Project;
import org.nasdanika.codegen.SubContext;
import org.nasdanika.codegen.WorkspaceRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.codegen.impl.WorkspaceRootImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkspaceRootImpl extends ResourceGeneratorImpl<IWorkspaceRoot> implements WorkspaceRoot {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkspaceRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CodegenPackage.Literals.WORKSPACE_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Project> getProjects() {
		return (EList<Project>)eGet(CodegenPackage.Literals.WORKSPACE_ROOT__PROJECTS, true);
	}

	@Override
	public List<IWorkspaceRoot> generate(Context context, IProgressMonitor monitor) throws Exception {
		777 - Iterator
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		SubContext wsc = context.createSubContext().set(IWorkspaceRoot.class, root);
		SubMonitor sm = SubMonitor.convert(monitor, getTotalWork());
		for (Project prj: getProjects()) {
			prj.generate(wsc, sm.split(prj.getTotalWork()));
		}
		return root;
	}

	@Override
	public int getTotalWork() {
		int ret = 1;
		for (Project prj: getProjects()) {
			ret += prj.getTotalWork();
		}
		return ret;
	}

} //WorkspaceRootImpl
