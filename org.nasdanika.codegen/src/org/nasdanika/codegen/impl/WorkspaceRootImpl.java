/**
 */
package org.nasdanika.codegen.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.GeneratorFilter;
import org.nasdanika.codegen.Project;
import org.nasdanika.codegen.SubContext;
import org.nasdanika.codegen.Work;
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
	public Work<List<IWorkspaceRoot>> createWork(Context context) throws Exception {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		List<Work<List<IProject>>> projectWork = new ArrayList<>();
		int[] totalWork = {0};
		GeneratorFilter gf = context.get(GeneratorFilter.class);
		if (gf == null || gf.test(this)) {
			SubContext wsc = context.createSubContext().set(IWorkspaceRoot.class, root);
			for (Context iCtx: iterate(wsc)) {
				for (Project prj: getProjects()) {
					Work<List<IProject>> pWork = prj.createWork(iCtx);
					if (pWork != null) {
						projectWork.add(pWork);
						totalWork[0] += pWork.size();
					}
				}
			}			
		}
		
		return new Work<List<IWorkspaceRoot>>() {
			
			@Override
			public int size() {
				return totalWork[0];
			}
			
			@Override
			public List<IWorkspaceRoot> execute(IProgressMonitor monitor) throws Exception {
				SubMonitor sm = SubMonitor.convert(monitor, size());
				for (Work<List<IProject>> pw: projectWork) {
					pw.execute(sm.split(pw.size()));
				}
				return Collections.singletonList(root);
			}
		};
	}

} //WorkspaceRootImpl
