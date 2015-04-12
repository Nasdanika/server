package org.nasdanika.cdo.scheduler;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;

/**
 * Scheduler which keeps tasks in a resource.
 * @author Pavel
 *
 * @param <CR>
 */
public class ResourceTaskContainerSchedulerProviderComponent<CR> extends AbstractSchedulerProviderComponent<CR> {

	@Override
	protected Collection<? super SchedulerTask> getTasks(CDOTransaction transaction) {
		return getTasksResource(transaction).getContents();
	}

	private CDOResource getTasksResource(CDOTransaction transaction) {
		return transaction.getOrCreateResource(tasksResource);
	}
	
	private String tasksResource = "schedulerTasks";
	
	public void setTasksResource(String tasksResource) {
		this.tasksResource = tasksResource;
	}

	@Override
	protected Lock tasksReadLock(CDOTransaction transaction) {
		return getTasksResource(transaction).cdoReadLock();
	}

	@Override
	protected Lock tasksWriteLock(CDOTransaction transaction) {
		return getTasksResource(transaction).cdoWriteLock();
	}

}
