package org.nasdanika.cdo.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.core.ContextRunnable;

/**
 * Scheduler asynchronously executes {@link ContextRunnable}&lt;{@link SchedulerContext}&lt;CR&gt;&gt;
 * @author Pavel Vlasov
 *
 * @param <CR>
 */
public interface Scheduler<CR> {

	/**
	 * @param task Task to execute.
	 * @param subject Optional security subject.
	 * @return
	 */
    Future<?> submit(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject);
    
    ScheduledFuture<?> schedule(
    		ContextRunnable<SchedulerContext<CR>> task, 
    		CDOViewContextSubject<CDOTransaction, CR> subject, 
    		long delay, 
    		TimeUnit unit);

    ScheduledFuture<?> scheduleAtFixedRate(
    		ContextRunnable<SchedulerContext<CR>> task, 
    		CDOViewContextSubject<CDOTransaction, CR> subject, 
    		long initialDelay, 
    		long period, 
    		TimeUnit unit);

    ScheduledFuture<?> scheduleWithFixedDelay(
    		ContextRunnable<SchedulerContext<CR>> task, 
    		CDOViewContextSubject<CDOTransaction, CR> subject,
            long initialDelay,
            long delay,
            TimeUnit unit);

}
