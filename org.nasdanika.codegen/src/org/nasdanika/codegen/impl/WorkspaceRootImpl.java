/**
 */
package org.nasdanika.codegen.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EClass;
import org.nasdanika.codegen.CodegenPackage;
import org.nasdanika.codegen.Context;
import org.nasdanika.codegen.Generator;
import org.nasdanika.codegen.SubContext;
import org.nasdanika.codegen.Work;
import org.nasdanika.codegen.WorkspaceRoot;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Workspace Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class WorkspaceRootImpl extends GroupImpl<IProject> implements WorkspaceRoot {
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

	@Override
	public Work<List<IProject>> createWork(Context context) throws Exception {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		List<Work<List<IProject>>> projectWork = new ArrayList<>();
		int[] totalWork = {0};
		SubContext wsc = context.createSubContext().set(IWorkspaceRoot.class, root);
		for (Context iCtx: iterate(wsc)) {
			for (Generator<IProject> prj: getElements()) {
				Work<List<IProject>> pWork = prj.createWork(iCtx);
				if (pWork != null) {
					projectWork.add(pWork);
					totalWork[0] += pWork.size();
				}
			}
		}			
		
		return new Work<List<IProject>>() {
			
			@Override
			public int size() {
				return totalWork[0];
			}
			
			@Override
			public List<IProject> execute(IProgressMonitor monitor) throws Exception {
				List<IProject> ret = new ArrayList<>();
				SubMonitor sm = SubMonitor.convert(monitor, size());
				for (Work<List<IProject>> pw: projectWork) {
					if (pw != null) {
						List<IProject> pr = pw.execute(sm.split(pw.size()));
						if (pr != null) {
							ret.addAll(pr);
						}
					}
				}
				return ret;
			}
		};
	}

} //WorkspaceRootImpl
