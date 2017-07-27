package org.nasdanika.cdo.scheduler;

import java.util.Iterator;

import org.nasdanika.cdo.CDOTransactionContext;

/**
 * Provider of scheduler tasks.
 * @author Pavel Vlasov
 *
 */
public interface SchedulerTaskProvider<CR> {
	
	/**
	 * Invoked on scheduler start to schedule tasks belonging to the provider.
	 * @param context
	 * @return
	 */
	Iterator<SchedulerTask<CR>> getSchedulerTasks(CDOTransactionContext<CR> context) throws Exception;
	
	/**
	 * Invoked by the transaction handler for new tasks attached to the transaction
	 * to find out whether these tasks belong to the provider and shall be scheduled.
	 * @param context
	 * @param task
	 * @return
	 */
	boolean shallSchedule(CDOTransactionContext<CR> context, SchedulerTask<CR> task) throws Exception;

}
