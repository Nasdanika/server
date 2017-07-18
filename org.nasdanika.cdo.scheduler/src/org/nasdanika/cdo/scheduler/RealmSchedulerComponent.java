package org.nasdanika.cdo.scheduler;

import java.util.Collections;
import java.util.Iterator;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.security.Realm;

/**
 * Gets tasks from the security realm if it implements SchedulerTaskProvider. 
 * @author Pavel
 *
 * @param <CR>
 */
public class RealmSchedulerComponent<CR> extends AbstractSchedulerComponent<CR> {

	@SuppressWarnings("unchecked")
	@Override
	protected Iterator<SchedulerTask<CR>> getTasks(CDOTransactionContext<CR> context) {
		Realm<CR> realm = context.getSecurityRealm();
		return realm instanceof SchedulerTaskProvider ? ((SchedulerTaskProvider<CR>) realm).getSchedulerTasks(context) : Collections.emptyIterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected boolean shallSchedule(SchedulerTask<CR> task) {
		try (CDOTransactionContext<CR> context = createContext()) {
			Realm<CR> realm = context.getSecurityRealm(); 			
			return realm instanceof SchedulerTaskProvider && ((SchedulerTaskProvider<CR>) realm).shallSchedule(context, (SchedulerTask<CR>) realm.cdoView().getObject(task.cdoID()));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
