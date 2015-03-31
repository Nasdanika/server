package org.nasdanika.cdo.scheduler;

import org.eclipse.emf.cdo.CDOObject;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.Context;

public interface SchedulerProvider<CR, MC extends Context> {
	
	Scheduler<CR, MC, String> getScheduler(CR credentials);

	/**
	 * @param context
	 * @param principal
	 * @return Scheduler operating in the provided transaction context.
	 */
	Scheduler<CR, MC, CDOObject> getScheduler(CDOTransactionContext<CR,MC> context, Principal principal);

	/**
	 * @return Scheduler operating in the provided transaction context.
	 */
	Scheduler<CR, MC, CDOObject> getScheduler(CDOTransactionContext<CR,MC> context, CR credentials);

}
