package org.nasdanika.cdo.scheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
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
import org.nasdanika.cdo.CDOIDSubject;
import org.nasdanika.cdo.CDOSessionInitializer;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.cdo.concurrent.Scheduler;
import org.nasdanika.cdo.concurrent.SchedulerContext;
import org.nasdanika.core.ContextRunnable;
import org.osgi.service.component.ComponentContext;

/**
 * This component schedules instances of {@link SchedulerTask} using {@link Scheduler} service.
 * At activation tasks are loaded from the repository by getTasks() method.
 * After activation changes in tasks state such as modification, deletion, and creation of new {@link SchedulerTask}s is detected
 * by <code>committedTransaction()</code> method and appropriate changes are made in the executor service tasks - they are cancelled for deleted, scheduled
 * for new, and cancelled and scheduled again for modified. 
 * @author Pavel Vlasov
 *
 * @param <CR>
 */
public abstract class AbstractSchedulerComponent<CR> implements CDOSessionInitializer, CDOTransactionHandler2 {
	
	private Scheduler<CR> scheduler;
	private Map<CDOID, Future<?>> scheduledTasks = new ConcurrentHashMap<>();

	public void setScheduler(Scheduler<CR> scheduler) {
		this.scheduler = scheduler;
	}
	
	protected long lockTimeout = 60000; 
	
	/**
	 * Lock timeout in milliseconds. Default is 1 minute.
	 * @param lockTimeout
	 */
	public void setLockTimeout(long lockTimeout) {
		this.lockTimeout = lockTimeout;
	}
	
	/**
	 * Creates a thread pool executor service and then schedules tasks returned by <code>getTasks()</code> method.
	 * @param componentContext
	 * @throws Exception
	 */
	public void activate(ComponentContext componentContext) throws Exception {
		scheduler.submit(new ContextRunnable<SchedulerContext<CR>>() {

			@Override
			public void run(SchedulerContext<CR> context) throws Exception {
				Iterator<SchedulerTask<CR>> tit = getTasks(context);
				while (tit.hasNext()) {
					schedule(tit.next());
				}
			}
			
		}, null);
	}
			
	protected abstract Iterator<SchedulerTask<CR>> getTasks(SchedulerContext<CR> context) throws Exception;
	
	protected void schedule(SchedulerTask<CR> schedulerTask) {
		if (!schedulerTask.isDone()) {
			CDOID schedulerTaskID = schedulerTask.cdoID();
			CDOViewContextSubject<CDOTransaction, CR> subject = CDOIDSubject.createPrincipalsSubject(schedulerTask.getSubject());
			Date now = new Date();				
			
			ContextRunnable<SchedulerContext<CR>> wrapperTask = new ContextRunnable<SchedulerContext<CR>>() {

				@SuppressWarnings("unchecked")
				@Override
				public void run(SchedulerContext<CR> context) throws Exception {
					long start = System.currentTimeMillis();
					Exception[] exception = {null};
					Diagnostic[] diagnostic = {null}; 
					try {
						diagnostic[0] = ((SchedulerTask<CR>) context.getView().getObject(schedulerTaskID)).run(context);
					} catch (Exception e) {
						exception[0] = e;
						context.setRollbackOnly();
						e.printStackTrace();
					} finally {
						long finish = System.currentTimeMillis();
						ContextRunnable<SchedulerContext<CR>> updateRunHistoryTask = new ContextRunnable<SchedulerContext<CR>>() {

							@Override
							public void run(SchedulerContext<CR> context) throws Exception {
								// May execute in a different transaction, need to get the task by ID.
								SchedulerTask<CR> schedulerTaskToUpdate = (SchedulerTask<CR>) context.getView().getObject(schedulerTaskID);
								CDOLock writeLock = schedulerTaskToUpdate.cdoWriteLock();
								writeLock.lock(lockTimeout);
								// One-off task
								if (!(schedulerTaskToUpdate instanceof RecurringSchedulerTask)) {
									schedulerTaskToUpdate.setDone(true);
									scheduledTasks.remove(schedulerTaskID);
								}
								Diagnostic historyEntry = SchedulerFactory.eINSTANCE.createDiagnostic();
								historyEntry.setTime(new Date(start));
								historyEntry.setDuration(finish - start);
								if (exception[0] != null) {
									historyEntry.setException(SchedulerFactory.eINSTANCE.createThrowable(exception[0]));
									historyEntry.setStatus(Status.ERROR);
									historyEntry.setMessage("Exception: "+exception[0].toString());
								} else if (diagnostic[0] != null) {
									historyEntry.setStatus(diagnostic[0].getStatus());
									historyEntry.setMessage(diagnostic[0].getMessage());
									historyEntry.getChildren().addAll(new ArrayList<>(diagnostic[0].getChildren()));
								}
								schedulerTaskToUpdate.getHistory().add(historyEntry);
							}
						};
						
						if (context.isRollbackOnly()) {
							// This transaction will be rolled back - executing update in another transaction.
							context.submit(updateRunHistoryTask, subject);
						} else {
							// All good - updating history in this transaction.
							updateRunHistoryTask.run(context);
						}
					}
				}
				
			};
			
			if (schedulerTask instanceof FixedDelaySchedulerTask) {
				FixedDelaySchedulerTask<?> fixedDelaySchedulerTask = (FixedDelaySchedulerTask<?>) schedulerTask;
				long start = schedulerTask.getStart().getTime();
				for (Diagnostic he: schedulerTask.getHistory()) {
					start = he.getTime().getTime() + he.getDuration() + fixedDelaySchedulerTask.getDelay();
				}
				long initialDelay = start - System.currentTimeMillis();
				if (initialDelay < 0) {
					initialDelay = 0;
				}
				Future<?> future = scheduler.scheduleWithFixedDelay(wrapperTask, subject, initialDelay, fixedDelaySchedulerTask.getDelay(), fixedDelaySchedulerTask.getTimeUnit());
				scheduledTasks.put(schedulerTask.cdoID(), future);				
			} else if (schedulerTask instanceof FixedRateSchedulerTask) {
				FixedRateSchedulerTask<?> fixedRateSchedulerTask = (FixedRateSchedulerTask<?>) schedulerTask;
				long start = schedulerTask.getStart().getTime();
				for (Diagnostic he: schedulerTask.getHistory()) {
					start = he.getTime().getTime() + fixedRateSchedulerTask.getPeriod();
				}
				long initialDelay = start - System.currentTimeMillis();
				if (initialDelay < 0) {
					initialDelay = 0;
				}
				Future<?> future = scheduler.scheduleAtFixedRate(wrapperTask, subject, initialDelay, fixedRateSchedulerTask.getPeriod(), fixedRateSchedulerTask.getTimeUnit());
				scheduledTasks.put(schedulerTask.cdoID(), future);								
			} else {				
				Date start = schedulerTask.getStart();
				Future<?> future;
				if (start.before(now)) {
					future = scheduler.submit(wrapperTask, subject);
				} else {
					future = scheduler.schedule(wrapperTask, subject, start.getTime() - now.getTime(), TimeUnit.MILLISECONDS);
				}
				scheduledTasks.put(schedulerTask.cdoID(), future);
			}
		}
	}
	
	/**
	 * Cancels scheduled tasks and shuts down the executor service.
	 * @param componentContext
	 * @throws Exception
	 */
	public void deactivate(ComponentContext componentContext) throws Exception {
		for (Future<?> st: scheduledTasks.values()) {
			st.cancel(false);
		}
	}
		
	protected boolean cancel(SchedulerTask<CR> task) {
		Future<?> sf = scheduledTasks.remove(task.cdoID());
		return sf != null && sf.cancel(false);
	}
	
	@Override
	public void init(CDOSession session) {
		CDOPackageRegistry packageRegistry = session.getPackageRegistry();
		packageRegistry.putEPackage(SchedulerPackage.eINSTANCE);
	}
	
	/**
	 * @param task
	 * @return true if a new task created within the transaction shall be scheduled.
	 */
	protected abstract boolean shallSchedule(SchedulerTask<CR> task); 

	/**
	 * Detects changes in {@link SchedulerTask}s state such as modification, deletion, and creation of new tasks. 
	 * Makes appropriate changes in the executor service tasks - they are cancelled for deleted, scheduled
	 * for new, and cancelled and scheduled again for modified. 	 
	 */
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
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__DONE);
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__START);
				featuresOfInterest.add(SchedulerPackage.Literals.SCHEDULER_TASK__SUBJECT);
				featuresOfInterest.add(SchedulerPackage.Literals.FIXED_DELAY_SCHEDULER_TASK__DELAY);
				featuresOfInterest.add(SchedulerPackage.Literals.FIXED_RATE_SCHEDULER_TASK__PERIOD);

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
