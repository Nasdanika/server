package org.nasdanika.cdo.scheduler;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.Context;
import org.osgi.framework.BundleContext;

public abstract class AbstractSchedulerProviderComponent<CR, MC extends Context> implements SchedulerProvider<CR, MC> {
	
	private int threadPoolSize = 1; 
	private ScheduledExecutorService scheduledExecutorService;
	private Map<CDOID, Future<?>> scheduledTasks = new ConcurrentHashMap<>();
	
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	
	protected CDOTransactionContext<CR,MC> createContext() {
		return transactionContextProvider.createContext();
	}
	
	private class SchedulerTaskRunnable implements Runnable {
		
		private CDOID taskId;

		SchedulerTaskRunnable(CDOID taskId) {
			this.taskId = taskId;
		}

		@Override
		public void run() {
			try (CDOTransactionContext<CR,MC> transactionContext = createContext()) {
				CDOTransaction transaction = transactionContext.getView();
				SchedulerTask task = (SchedulerTask) transaction.getObject(taskId);
				@SuppressWarnings("unchecked")
				CDOTransactionContextCommand<CR, MC, Object, Object> command = (CDOTransactionContextCommand<CR, MC, Object, Object>) BoxUtil.unbox(task.getTarget(), transactionContext); 
				if (command.canExecute()) {
					try {
						Object result = command.execute(createCommandContext(transactionContext, task.getRunAs()), task.getRunAt(), task.isFixedRate(), task.getPeriod());
						if (Boolean.FALSE.equals(result)) {
							// TODO - cancel the task.
						}
					} catch (Exception e) {
						// TODO - cancel the task on method exit in a different transaction.
					}
				}
				// TODO - store exception to the task, copy Throwable and stack trace from WebTestHub, add cause (in WTH it is "peeled").
			} catch (Exception e) {
				handleException(e);
			}			
		}
		
	}
	
	protected void handleException(Exception e) {
		e.printStackTrace(); 
	}
	
	public CDOTransactionContext<CR, MC> createCommandContext(CDOTransactionContext<CR, MC> transactionContext, Principal runAs) {
		// TODO
//		return ;
	}

	public void activate(BundleContext bundleContext) throws Exception {
		scheduledExecutorService = Executors.newScheduledThreadPool(threadPoolSize);
		try (CDOTransactionContext<CR,MC> transactionContext = createContext()) {
			CDOTransaction transaction = transactionContext.getView();
			Lock readLock = tasksReadLock(transaction);
			try {
				readLock.lock();
				for (Object obj: getTasks(transaction)) {
					if (obj instanceof SchedulerTask) {
						SchedulerTask schedulerTask = (SchedulerTask) obj;
						CDOID taskId = schedulerTask.cdoID();
						SchedulerTaskRunnable taskRunnable = new SchedulerTaskRunnable(taskId);
						// One time
						long now = System.currentTimeMillis();
						Long period = schedulerTask.getPeriod();
						if (period==null) {
							scheduledTasks.put(taskId, scheduledExecutorService.schedule(taskRunnable, Math.max(1, schedulerTask.getRunAt() - now), TimeUnit.MILLISECONDS));
						} else {
							long runAt = schedulerTask.getRunAt();
							while (runAt<now) {
								runAt+=period;
							}
							if (schedulerTask.isFixedRate()) {
								scheduledTasks.put(taskId, scheduledExecutorService.scheduleAtFixedRate(taskRunnable, runAt - now, period, TimeUnit.MILLISECONDS));
							} else {
								scheduledTasks.put(taskId, scheduledExecutorService.scheduleWithFixedDelay(taskRunnable, runAt - now, period, TimeUnit.MILLISECONDS));							
							}						
						}
					}
				}
			} finally {
				readLock.unlock();
			}
		}		
	}

	public void deactivate(BundleContext bundleContext) throws Exception {
		for (Future<?> st: scheduledTasks.values()) {
			st.cancel(false);
		}
		scheduledExecutorService.shutdown();
	}
	
	private CDOTransactionContextProvider<CR, MC> transactionContextProvider;
	
	public void setTransactionContextProvider(CDOTransactionContextProvider<CR, MC> transactionContextProvider) {
		this.transactionContextProvider = transactionContextProvider;
	}
	
	protected abstract Collection<? super SchedulerTask> getTasks(CDOTransaction transaction); 
	protected abstract Lock tasksReadLock(CDOTransaction transaction);
	protected abstract Lock tasksWriteLock(CDOTransaction transaction);	

	// Delegate methods for schedulers.
	
	protected void schedule(
			CDOTransactionContext<CR, MC> transactionContext, 
			Principal principal, 
			CDOTransactionContextCommand<CR, MC, Object, Object> command, 
			final long delay, 
			final TimeUnit timeUnit,
			final AtomicReference<String> resultCollector) throws Exception {
		
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(timeUnit.toMillis(delay)+System.currentTimeMillis());
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(principal);
		transaction.addTransactionHandler(new CDOTransactionHandler2() {
			
			@Override
			public void rolledBackTransaction(CDOTransaction transaction) {
				// NOP				
			}
			
			@Override
			public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
				// NOP				
			}
			
			@Override
			public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {						
				CDOID taskID = task.cdoID();
				scheduledTasks.put(taskID, scheduledExecutorService.schedule(new SchedulerTaskRunnable(taskID), delay, timeUnit));			
				StringBuilder builder = new StringBuilder();
				CDOIDUtil.write(builder, taskID);
				resultCollector.set(builder.toString());				
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}
	}

	protected void scheduleAtFixedRate(
			CDOTransactionContext<CR, MC> transactionContext, 
			Principal principal, 
			CDOTransactionContextCommand<CR, MC, Object, Object> command,
			final long initialDelay, 
			final long period, 
			final TimeUnit timeUnit,
			final AtomicReference<String> resultCollector) throws Exception {
				
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(timeUnit.toMillis(initialDelay)+System.currentTimeMillis());
		task.setFixedRate(true);
		task.setPeriod(timeUnit.toMillis(period));
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(principal);
		transaction.addTransactionHandler(new CDOTransactionHandler2() {
			
			@Override
			public void rolledBackTransaction(CDOTransaction transaction) {
				// NOP				
			}
			
			@Override
			public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
				// NOP				
			}
			
			@Override
			public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {						
				CDOID taskID = task.cdoID();
				scheduledTasks.put(taskID, scheduledExecutorService.scheduleAtFixedRate(new SchedulerTaskRunnable(taskID), initialDelay, period, timeUnit));			
				StringBuilder builder = new StringBuilder();
				CDOIDUtil.write(builder, taskID);
				resultCollector.set(builder.toString());				
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}
	}

	protected void scheduleWithFixedDelay(
			CDOTransactionContext<CR, MC> transactionContext, 
			Principal principal, 
			CDOTransactionContextCommand<CR, MC, Object, Object> command,
			final long initialDelay, 
			final long delay, 
			final TimeUnit timeUnit,
			final AtomicReference<String> resultCollector) throws Exception {
				
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(timeUnit.toMillis(initialDelay)+System.currentTimeMillis());
		task.setPeriod(timeUnit.toMillis(delay));
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(principal);
		transaction.addTransactionHandler(new CDOTransactionHandler2() {
			
			@Override
			public void rolledBackTransaction(CDOTransaction transaction) {
				// NOP				
			}
			
			@Override
			public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
				// NOP				
			}
			
			@Override
			public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {						
				CDOID taskID = task.cdoID();
				scheduledTasks.put(taskID, scheduledExecutorService.scheduleWithFixedDelay(new SchedulerTaskRunnable(taskID), initialDelay, delay, timeUnit));			
				StringBuilder builder = new StringBuilder();
				CDOIDUtil.write(builder, taskID);
				resultCollector.set(builder.toString());				
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}		
	}

	protected boolean cancel(CDOTransaction transaction, CDOID taskId) throws Exception {
		Future<?> sf = scheduledTasks.get(taskId);
		if (sf!=null && sf.cancel(false)) {
			Lock writeLock = tasksWriteLock(transaction);
			try {
				writeLock.lock();
				SchedulerTask task = (SchedulerTask) transaction.getObject(taskId);
				return getTasks(transaction).remove(task);
			} catch (ObjectNotFoundException onfe) {
				return false;
			} finally {
				writeLock.unlock();
			}
		}
		
		return false;
	}

	protected void submit(
			CDOTransactionContext<CR, MC> transactionContext, 
			Principal principal, 
			CDOTransactionContextCommand<CR, MC, Object, Object> command,
			final AtomicReference<String> resultCollector) throws Exception {
		
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(System.currentTimeMillis());
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(principal);
		transaction.addTransactionHandler(new CDOTransactionHandler2() {
			
			@Override
			public void rolledBackTransaction(CDOTransaction transaction) {
				// NOP				
			}
			
			@Override
			public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
				// NOP				
			}
			
			@Override
			public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {						
				CDOID taskID = task.cdoID();
				scheduledTasks.put(taskID, scheduledExecutorService.submit(new SchedulerTaskRunnable(taskID)));			
				StringBuilder builder = new StringBuilder();
				CDOIDUtil.write(builder, taskID);
				resultCollector.set(builder.toString());				
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}
	}
	
	// Provider methods
	@Override
	public Scheduler<CR, MC, String> getScheduler(CR credentials) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scheduler<CR, MC, CDOObject> getScheduler(CDOTransactionContext<CR, MC> context, Principal principal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scheduler<CR, MC, CDOObject> getScheduler(CDOTransactionContext<CR, MC> context, CR credentials) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
