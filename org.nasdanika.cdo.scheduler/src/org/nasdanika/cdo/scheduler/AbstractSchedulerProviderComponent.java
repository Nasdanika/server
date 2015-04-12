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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextCommand;
import org.nasdanika.cdo.CDOTransactionContextFilter;
import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.AdapterProvider;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.osgi.service.component.ComponentContext;

public abstract class AbstractSchedulerProviderComponent<CR> implements SchedulerProvider<CR>, AdapterProvider<CDOTransactionContext<CR>, Scheduler<CR, CDOObject>> {
	
	private int threadPoolSize = 1; 
	private ScheduledExecutorService scheduledExecutorService;
	private Map<CDOID, Future<?>> scheduledTasks = new ConcurrentHashMap<>();
	private AccessDecision defaultAccessDecision;
	
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	
	protected CDOTransactionContext<CR> createContext() {
		return transactionContextProvider.createContext(null);
	}
	
	// Retention period - don't delete tasks upon completion, but after some time?
	
	private class SchedulerTaskRunnable implements Runnable {
		
		private CDOID taskId;

		SchedulerTaskRunnable(CDOID taskId) {
			this.taskId = taskId;
		}

		@Override
		public void run() {
			boolean delete = false;
//			Exception toLog = null;
			try (CDOTransactionContext<CR> transactionContext = createContext()) {
				CDOTransaction transaction = transactionContext.getView();
				SchedulerTask task = (SchedulerTask) transaction.getObject(taskId);
				@SuppressWarnings("unchecked")
				CDOTransactionContextCommand<CR, Object, Object> command = (CDOTransactionContextCommand<CR, Object, Object>) BoxUtil.unbox(task.getTarget(), transactionContext); 
				if (command.canExecute()) {
					try {
						Object result = command.execute(createCommandContext(transactionContext, task.getRunAs()), task.getRunAt(), task.isFixedRate(), task.getPeriod());
						if (Boolean.FALSE.equals(result)) { 
							Future<?> sf = scheduledTasks.get(taskId);
							if (sf!=null) {
								sf.cancel(false);
							}
							delete = true;
						} else if (task.getPeriod()==null) { // One-off
							delete = true;
						}
					} catch (Exception e) {
						delete = true;
//						toLog = e;
						handleException(e);
					}
				}
				// If retention period - store exception to the task, copy Throwable and stack trace from WebTestHub, add cause (in WTH it is "peeled")???
			} catch (Exception e) {
				handleException(e);
			}
			if (delete) {
				// Different context - that one could have been rolled back.
				try (CDOTransactionContext<CR> transactionContext = createContext()) {
					CDOTransaction transaction = transactionContext.getView();
					SchedulerTask task = (SchedulerTask) transaction.getObject(taskId);
					EcoreUtil.delete(task, true);
				} catch (Exception e) {
					handleException(e);
				}				
			}
		}
				
	}
	
	protected void handleException(Exception e) {
		e.printStackTrace(); 
	}
	
	public CDOTransactionContext<CR> createCommandContext(CDOTransactionContext<CR> transactionContext, final Principal runAs) {
		return new CDOTransactionContextFilter<CR, Principal>(transactionContext) {

			@Override
			protected Principal getMasterContext() {
				return runAs;
			}

			@Override
			protected AccessDecision getDefaultAccessDecision() {
				return defaultAccessDecision;
			}
			
		};
	}

	public void activate(ComponentContext componentContext) throws Exception {
		scheduledExecutorService = Executors.newScheduledThreadPool(threadPoolSize);
		defaultAccessDecision = "deny".equalsIgnoreCase((String) componentContext.getProperties().get("default-access-decision")) ? AccessDecision.DENY : AccessDecision.ALLOW;
		try (CDOTransactionContext<CR> transactionContext = createContext()) {
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
	
	protected abstract Collection<? super SchedulerTask> getTasks(CDOTransaction transaction); 
	protected abstract Lock tasksReadLock(CDOTransaction transaction);
	protected abstract Lock tasksWriteLock(CDOTransaction transaction);	

	// Delegate methods for schedulers.
	
	protected SchedulerTask schedule(
			CDOTransactionContext<CR> transactionContext, 
			CDOTransactionContextCommand<CR, Object, Object> command, 
			final long delay, 
			final TimeUnit timeUnit,
			final AtomicReference<String> resultCollector) throws Exception {
		
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(timeUnit.toMillis(delay)+System.currentTimeMillis());
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(transactionContext.getPrincipal());
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
				if (resultCollector!=null) {
					StringBuilder builder = new StringBuilder();
					CDOIDUtil.write(builder, taskID);
					resultCollector.set(builder.toString());
				}
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}
		return task;
	}

	protected SchedulerTask scheduleAtFixedRate(
			CDOTransactionContext<CR> transactionContext, 
			CDOTransactionContextCommand<CR, Object, Object> command,
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
		task.setRunAs(transactionContext.getPrincipal());
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
				if (resultCollector!=null) {
					StringBuilder builder = new StringBuilder();
					CDOIDUtil.write(builder, taskID);
					resultCollector.set(builder.toString());
				}
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}
		return task;
	}

	protected SchedulerTask scheduleWithFixedDelay(
			CDOTransactionContext<CR> transactionContext, 
			CDOTransactionContextCommand<CR, Object, Object> command,
			final long initialDelay, 
			final long delay, 
			final TimeUnit timeUnit,
			final AtomicReference<String> resultCollector) throws Exception {
				
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(timeUnit.toMillis(initialDelay)+System.currentTimeMillis());
		task.setPeriod(timeUnit.toMillis(delay));
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(transactionContext.getPrincipal());
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
				if (resultCollector!=null) {
					StringBuilder builder = new StringBuilder();
					CDOIDUtil.write(builder, taskID);
					resultCollector.set(builder.toString());
				}
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}	
		return task;
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

	protected SchedulerTask submit(
			CDOTransactionContext<CR> transactionContext, 
			CDOTransactionContextCommand<CR, Object, Object> command,
			final AtomicReference<String> resultCollector) throws Exception {
		
		CDOTransaction transaction = transactionContext.getView();				
		final SchedulerTask task = SchedulerFactory.eINSTANCE.createSchedulerTask();
		task.setRunAt(System.currentTimeMillis());
		task.setTarget(BoxUtil.box(command, transactionContext));
		task.setRunAs(transactionContext.getPrincipal());
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
				if (resultCollector!=null) {
					StringBuilder builder = new StringBuilder();
					CDOIDUtil.write(builder, taskID);
					resultCollector.set(builder.toString());
				}
			}
			
		});
		Lock tasksWriteLock = tasksWriteLock(transaction);
		tasksWriteLock.lock();
		try {
			getTasks(transaction).add(task);
		} finally {
			tasksWriteLock.unlock();
		}
		return task;
	}
	
	// Provider methods
	@Override
	public Scheduler<CR, String> getScheduler(final CR credentials) {
		return new Scheduler<CR, String>() {

			@Override
			public String schedule(
					CDOTransactionContextCommand<CR, Object, Object> command,
					long delay, 
					TimeUnit timeUnit) {
				
				AtomicReference<String> ret = new AtomicReference<String>();
				
				try (CDOTransactionContext<CR> ctx = createContext()) {
					Principal principal = ctx.authenticate(credentials);
					if (principal==null) {
						throw new SchedulerException("Invalid credentials");
					}
					
					AbstractSchedulerProviderComponent.this.schedule(ctx, command, delay, timeUnit, ret);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
				
				return ret.get();
			}

			@Override
			public String scheduleAtFixedRate(
					CDOTransactionContextCommand<CR, Object, Object> command,
					long initialDelay, 
					long period, 
					TimeUnit timeUnit) {
								
				AtomicReference<String> ret = new AtomicReference<String>();
				
				try (CDOTransactionContext<CR> ctx = createContext()) {
					Principal principal = ctx.authenticate(credentials);
					if (principal==null) {
						throw new SchedulerException("Invalid credentials");
					}
					
					AbstractSchedulerProviderComponent.this.scheduleAtFixedRate(ctx, command, initialDelay, period, timeUnit, ret);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
				
				return ret.get();
			}

			@Override
			public String scheduleWithFixedDelay(
					CDOTransactionContextCommand<CR, Object, Object> command,
					long initialDelay, 
					long delay, 
					TimeUnit timeUnit) {
				
				AtomicReference<String> ret = new AtomicReference<String>();
				
				try (CDOTransactionContext<CR> ctx = createContext()) {
					Principal principal = ctx.authenticate(credentials);
					if (principal==null) {
						throw new SchedulerException("Invalid credentials");
					}
					
					AbstractSchedulerProviderComponent.this.scheduleWithFixedDelay(ctx, command, initialDelay, delay, timeUnit, ret);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
				
				return ret.get();
			}

			@Override
			public boolean cancel(String taskKey) {
				try (CDOTransactionContext<CR> ctx = createContext()) {
					Principal principal = ctx.authenticate(credentials);
					if (principal==null) {
						throw new SchedulerException("Invalid credentials");
					}
					
					return AbstractSchedulerProviderComponent.this.cancel(ctx.getView(), CDOIDUtil.read(taskKey));
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
			}

			@Override
			public String submit(CDOTransactionContextCommand<CR, Object, Object> command) {
				
				AtomicReference<String> ret = new AtomicReference<String>();
				
				try (CDOTransactionContext<CR> ctx = createContext()) {
					Principal principal = ctx.authenticate(credentials);
					if (principal==null) {
						throw new SchedulerException("Invalid credentials");
					}
					
					AbstractSchedulerProviderComponent.this.submit(ctx, command, ret);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
				
				return ret.get();
			}
			
		};
	}

	@Override
	public Scheduler<CR, CDOObject> getScheduler(final CDOTransactionContext<CR> transactionContext) {
		return new Scheduler<CR, CDOObject>() {

			@Override
			public CDOObject schedule(
					CDOTransactionContextCommand<CR, Object, Object> command,
					long delay, 
					TimeUnit timeUnit) {

				try {
					return AbstractSchedulerProviderComponent.this.schedule(transactionContext, command, delay, timeUnit, null);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
			}

			@Override
			public CDOObject scheduleAtFixedRate(
					CDOTransactionContextCommand<CR, Object, Object> command,
					long initialDelay, 
					long period, 
					TimeUnit timeUnit) {

				try {
					return AbstractSchedulerProviderComponent.this.scheduleAtFixedRate(transactionContext, command, initialDelay, period, timeUnit, null);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
			}

			@Override
			public CDOObject scheduleWithFixedDelay(
					CDOTransactionContextCommand<CR, Object, Object> command,
					long initialDelay, 
					long delay, 
					TimeUnit timeUnit) {

				try {
					return AbstractSchedulerProviderComponent.this.scheduleWithFixedDelay(transactionContext, command, initialDelay, delay, timeUnit, null);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
			}

			@Override
			public boolean cancel(CDOObject task) {
				try {
					return AbstractSchedulerProviderComponent.this.cancel(transactionContext.getView(), task.cdoID());
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
			}

			@Override
			public CDOObject submit(CDOTransactionContextCommand<CR, Object, Object> command) {
				try {
					return AbstractSchedulerProviderComponent.this.submit(transactionContext, command, null);
				} catch (Exception e) {
					throw new SchedulerException(e);
				}
			}
			
		};
	}

	@Override
	public Scheduler<CR, CDOObject> createAdapter(CDOTransactionContext<CR> target) {
		return getScheduler(target);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class<Scheduler<CR, CDOObject>> getAdapterType() {
		return (Class) Scheduler.class;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class<CDOTransactionContext<CR>> getTargetType() {
		return (Class) CDOTransactionContext.class;
	}

}
