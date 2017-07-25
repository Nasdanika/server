package org.nasdanika.cdo.concurrent;

import org.nasdanika.cdo.CDOTransactionContext;
import org.osgi.framework.BundleContext;

public interface SchedulerContext<CR> extends CDOTransactionContext<CR>, Scheduler<CR> {
	
	/**
	 * Cancels future executions of the currently executing task.
	 * @return
	 */
	boolean cancel();
	
	/**
	 * Convenience method for tasks looking up services. 
	 * @return Bundle context.
	 */
	BundleContext getBundleContext();

}
