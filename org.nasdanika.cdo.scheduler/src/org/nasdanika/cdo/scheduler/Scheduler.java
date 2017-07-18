package org.nasdanika.cdo.scheduler;

public interface Scheduler<CR> {
	
	void schedule(SchedulerTask<CR> task);
	
	boolean cancel(SchedulerTask<CR> task);
	
}
