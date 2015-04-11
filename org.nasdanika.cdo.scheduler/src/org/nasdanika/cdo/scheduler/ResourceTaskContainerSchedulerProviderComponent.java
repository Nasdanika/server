package org.nasdanika.cdo.scheduler;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.core.Context;

public class ResourceTaskContainerSchedulerProviderComponent<CR> extends AbstractSchedulerProviderComponent<CR> {

	@Override
	protected Collection<? super SchedulerTask> getTasks(CDOTransaction transaction) {
		return getTasksResource(transaction).getContents();
	}

	private CDOResource getTasksResource(CDOTransaction transaction) {
		return transaction.getResource(tasksResource);
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
