package org.nasdanika.cdo.scheduler;

import java.util.concurrent.TimeUnit;

import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.core.Context;

public interface Scheduler<CR, MC extends Context, K> {
	
	K schedule(CDOTransactionContextCommand<CR, MC, Object, Object> command, long delay, TimeUnit timeUnit);

	K scheduleAtFixedRate(CDOTransactionContextCommand<CR, MC, Object, Object> command, long initialDelay, long period, TimeUnit unit);
	
	K scheduleWithFixedDelay(CDOTransactionContextCommand<CR, MC, Object, Object> command, long initialDelay, long delay, TimeUnit unit);
	
	boolean cancel(K taskKey);
	
	K submit(CDOTransactionContextCommand<CR, MC, Object, Object> command);
}
