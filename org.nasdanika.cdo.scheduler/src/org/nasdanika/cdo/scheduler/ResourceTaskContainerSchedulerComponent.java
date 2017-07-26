package org.nasdanika.cdo.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cdo.concurrent.SchedulerContext;

/**
 * Scheduler which keeps tasks in a resource.
 * @author Pavel
 *
 * @param <CR>
 */
public class ResourceTaskContainerSchedulerComponent<CR> extends AbstractSchedulerComponent<CR> {
	
	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<SchedulerTask<CR>> getTasks(SchedulerContext<CR> context) throws Exception {
		CDOResource tasksResource = getTasksResource(context.getView());
		CDOLock readLock = tasksResource.cdoReadLock();
		try {
			readLock.lock(lockTimeout);
			List<SchedulerTask<CR>> tasks = new ArrayList<>();
			for (EObject obj: tasksResource.getContents()) {
				if (obj instanceof SchedulerTask<?>) {
					tasks.add((SchedulerTask<CR>) obj);
				}
			}
			return tasks.iterator();
		} finally {
			readLock.unlock();
		}
	}

	private CDOResource getTasksResource(CDOTransaction transaction) {
		return transaction.getOrCreateResource(tasksResource);
	}
	
	private String tasksResource = "schedulerTasks";
	
	public void setTasksResource(String tasksResource) {
		this.tasksResource = tasksResource;
	}

	@Override
	protected boolean shallSchedule(SchedulerTask<CR> task) {
		return !task.isDone() && task.eResource() == task.cdoView().getResource(tasksResource);
	}

}
