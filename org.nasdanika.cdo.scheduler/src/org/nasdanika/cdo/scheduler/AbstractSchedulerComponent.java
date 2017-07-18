package org.nasdanika.cdo.scheduler;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.CDOLock;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.nasdanika.cdo.CDOSessionInitializer;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.osgi.service.component.ComponentContext;

public abstract class AbstractSchedulerComponent<CR> implements Scheduler<CR>, CDOSessionInitializer, CDOTransactionHandler2 {
	
	private int threadPoolSize = 1; 
	private ScheduledExecutorService scheduledExecutorService;
	private Map<CDOID, Future<?>> scheduledTasks = new ConcurrentHashMap<>();
	
	/**
	 * If scheduler modifies task attributes, it puts modified features to this map to avoid unnecessary rescheduling. 
	 */
	private Map<CDOTransaction, Map<CDOID, Set<EStructuralFeature>>> taskModificationsMap = new WeakHashMap<>();
	
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	
	protected CDOTransactionContext<CR> createContext() {
		return transactionContextProvider.createContext(null);
	}
	
	private class SchedulerTaskRunnable implements Runnable {
		
		private CDOID taskId;

		SchedulerTaskRunnable(CDOID taskId) {
			this.taskId = taskId;
		}

		@Override
		public void run() {
			try (CDOTransactionContext<CR> transactionContext = createContext()) {
				CDOTransaction transaction = transactionContext.getView();
				@SuppressWarnings("unchecked")
				SchedulerTask<CR> task = (SchedulerTask<CR>) transaction.getObject(taskId);
				task.execute(transactionContext);
				CDOLock lock = task.cdoWriteLock();
				try {
					lock.lock();
					Set<EStructuralFeature> modifiedFeatures = new HashSet<>();
					if (task.isActive() && task.getPeriod() > 0) {
						task.setRunAt(new Date(System.currentTimeMillis() + task.getPeriod()));
					} else {
						Future<?> sf = scheduledTasks.get(taskId);
						if (sf!=null) {
							sf.cancel(false);
						}
						scheduledTasks.remove(taskId);
						task.setActive(false);
						task.setRunAt(null);
						modifiedFeatures.add(SchedulerPackage.Literals.SCHEDULER_TASK__ACTIVE);
					}
					modifiedFeatures.add(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AT);
					synchronized(taskModificationsMap) {
						taskModificationsMap.put(transaction, Collections.singletonMap(taskId, modifiedFeatures));
					}
				} finally {
					lock.unlock();
				}
			} catch (Exception e) {
				handleException(taskId, e);
			}
		}
		
	}
	
	protected void handleException(CDOID taskId, Exception e) {
		System.err.println("Task ID: "+taskId);
		e.printStackTrace(); 
	}

	public void activate(ComponentContext componentContext) throws Exception {
		scheduledExecutorService = Executors.newScheduledThreadPool(threadPoolSize);
		try (CDOTransactionContext<CR> transactionContext = createContext()) {
			Iterator<SchedulerTask<CR>> tit = getTasks(transactionContext);
			while (tit.hasNext()) {
				schedule(tit.next());
			}
		}		
	}

	public void deactivate(ComponentContext componentContext) throws Exception {
		for (Future<?> st: scheduledTasks.values()) {
			st.cancel(false);
		}
		scheduledExecutorService.shutdown();
	}
	
	private CDOTransactionContextProvider<CR> transactionContextProvider;
	
	public void setTransactionContextProvider(CDOTransactionContextProvider<CR> transactionContextProvider) {
		this.transactionContextProvider = transactionContextProvider;
	}
	
	protected abstract Iterator<SchedulerTask<CR>> getTasks(CDOTransactionContext<CR> context); 
	
	@Override
	public void schedule(SchedulerTask<CR> schedulerTask) {
		if (schedulerTask.isActive()) {
			CDOID taskId = schedulerTask.cdoID();
			SchedulerTaskRunnable taskRunnable = new SchedulerTaskRunnable(taskId);
			// One time
			long now = System.currentTimeMillis();
			long runAt = schedulerTask.getRunAt() == null ? now : schedulerTask.getRunAt().getTime();
			Future<?> future;
			if (schedulerTask.getPeriod() > 0) {
				// Repetitive task
				long delay = Math.max(runAt - now, 1);
				if (schedulerTask.isFixedRate()) {
					future = scheduledExecutorService.scheduleAtFixedRate(taskRunnable, delay, schedulerTask.getPeriod(), TimeUnit.MILLISECONDS);
				} else {
					future = scheduledExecutorService.scheduleWithFixedDelay(taskRunnable, delay, schedulerTask.getPeriod(), TimeUnit.MILLISECONDS);
				}						
			} else {
				// One-shot task
				if (runAt > now) {
					future = scheduledExecutorService.schedule(taskRunnable, runAt - now, TimeUnit.MILLISECONDS);							
				} else {
					future = scheduledExecutorService.submit(taskRunnable);
				}
			}
			scheduledTasks.put(taskId, future);
		}
	}
	
	@Override
	public boolean cancel(SchedulerTask<CR> task) {
		Future<?> sf = scheduledTasks.get(task.cdoID());
		return sf != null && sf.cancel(false);
	}
	
	@Override
	public void init(CDOSession session) {
		CDOPackageRegistry packageRegistry = session.getPackageRegistry();
		packageRegistry.putEPackage(SchedulerPackage.eINSTANCE);
	}
	
	/**
	 * @param task
	 * @return true if a new task created withing the transaction shall be scheduled.
	 */
	protected abstract boolean shallSchedule(SchedulerTask<CR> task); 

	// Listening for changes in scheduled tasks.
	@SuppressWarnings("unchecked")
	@Override
	public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
		// Removing detached tasks.
		for (CDOID cdoId: commitContext.getDetachedObjects().keySet()) {
			Future<?> future = scheduledTasks.get(cdoId);
			if (future != null) {
				future.cancel(false);
			}
		}
		
		// Updating dirty
		for (Entry<CDOID, CDOObject> doe: commitContext.getDirtyObjects().entrySet()) {
			if (scheduledTasks.containsKey(doe.getKey())) {
				Set<EStructuralFeature> featuresOfInterest = new HashSet<>();
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__ACTIVE);
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__FIXED_RATE);
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__PERIOD);
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__RUN_AT);

				synchronized (taskModificationsMap) {
					Map<CDOID, Set<EStructuralFeature>> schedulerModifiedTasks = taskModificationsMap.remove(transaction);
					if (schedulerModifiedTasks != null) {
						Set<EStructuralFeature> schedulerModifiedFeatures = schedulerModifiedTasks.get(doe.getKey());
						if (schedulerModifiedFeatures != null) {
							featuresOfInterest.removeAll(schedulerModifiedFeatures);
						}
					}
				}
								
				CDORevisionDelta revisionDelta = commitContext.getRevisionDeltas().get(doe.getKey());
				for (EStructuralFeature fi: featuresOfInterest) {
					if (revisionDelta.getFeatureDelta(fi) != null) {
						SchedulerTask<CR> schedulerTask = (SchedulerTask<CR>) doe.getValue();
						cancel(schedulerTask);
						schedule(schedulerTask);
						break;
					}
				}
			}
		}
		
		// New objects.
		for (CDOObject newObj: commitContext.getNewObjects().values()) {
			if (newObj instanceof SchedulerTask && shallSchedule((SchedulerTask<CR>) newObj)) {
				schedule((SchedulerTask<CR>) newObj);
			}
		}
		
	}

	@Override
	public void committingTransaction(CDOTransaction arg0, CDOCommitContext arg1) {
		// NOP		
	}

	@Override
	public void rolledBackTransaction(CDOTransaction arg0) {
		// NOP		
	}
	

}
