package org.nasdanika.cdo.scheduler;

import java.util.concurrent.TimeUnit;

import org.nasdanika.cdo.CDOTransactionContextCommand;

public interface Scheduler<CR, K> {
	
	K schedule(CDOTransactionContextCommand<CR, Object, Object> command, long delay, TimeUnit timeUnit);

	K scheduleAtFixedRate(CDOTransactionContextCommand<CR, Object, Object> command, long initialDelay, long period, TimeUnit timeUnit);
	
	K scheduleWithFixedDelay(CDOTransactionContextCommand<CR, Object, Object> command, long initialDelay, long delay, TimeUnit timeUnit);
	
	boolean cancel(K taskKey);
	
	K submit(CDOTransactionContextCommand<CR, Object, Object> command);
}
