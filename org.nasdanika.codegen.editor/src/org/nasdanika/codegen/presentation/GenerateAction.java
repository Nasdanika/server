package org.nasdanika.codegen.presentation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.net4j.util.om.monitor.SubMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.nasdanika.codegen.WorkspaceRoot;

public class GenerateAction extends ActionDelegate {
	
	private WorkspaceRoot workspaceRoot;

	@Override
	public void run(IAction action) {
		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				// TODO
				
				try {
					SubMonitor subMonitor = SubMonitor.convert(monitor, 10);
					for (int i = 0; i < 10; ++i) {
						Thread.sleep(200);
						subMonitor.worked(1);
					}
					throw new InvocationTargetException(new IllegalStateException("Shit happened"));
				} finally {
					monitor.done();
				}
				
			}
			
//			@Override
//			protected void execute(IProgressMonitor progressMonitor) {
//				try {
//					modifyWorkspace(progressMonitor);
//				} catch (CoreException exception) {
//					ErrorDialog.openError(getShell(), "Error generating workspace", exception.toString(), exception.getStatus());
//					GenModelEditPlugin.INSTANCE.log(exception);
//				} catch (Exception exception) {
//					MessageDialog.openError(getShell(), "Error generating workspace", exception.toString());
//					GenModelEditPlugin.INSTANCE.log(exception);
//				} finally {
//					progressMonitor.done();
//				}
//			}
		};

		IWorkbench workbench = PlatformUI.getWorkbench();
		Shell shell = workbench.getModalDialogShellProvider().getShell();
		try {
			new ProgressMonitorDialog(shell).run(true, true, operation);
		} catch (Exception exception) {
            MultiStatus status = createMultiStatus(exception.toString(), exception);
            ErrorDialog.openError(shell, "Generation error", exception.toString(), status);
			CodegenEditorPlugin.getPlugin().getLog().log(status);
			exception.printStackTrace();
		}
	}
	
	private static MultiStatus createMultiStatus(String msg, Throwable t) {
				

		List<Status> childStatuses = new ArrayList<>();

		for (StackTraceElement stackTrace : t.getStackTrace()) {
			childStatuses.add(new Status(IStatus.ERROR, "org.nasdanika.codegen.editor", stackTrace.toString()));
		}

		if (t.getCause() != null) {
			childStatuses.add(createMultiStatus("Caused by: " + t.getCause(), t.getCause()));
		}

		for (Throwable s : t.getSuppressed()) {
			childStatuses.add(createMultiStatus("Supressed: " + s, s.getCause()));
		}

		MultiStatus ms = new MultiStatus("org.nasdanika.codegen.editor", IStatus.ERROR,	childStatuses.toArray(new Status[childStatuses.size()]), msg, t);

		return ms;
	}	

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			if (object instanceof WorkspaceRoot) {
				workspaceRoot = (WorkspaceRoot) object;
				action.setEnabled(true);
				return;
			}
		}
		workspaceRoot = null;
		action.setEnabled(false);
	}

}
