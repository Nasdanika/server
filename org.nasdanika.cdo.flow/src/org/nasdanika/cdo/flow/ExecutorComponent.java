package org.nasdanika.cdo.flow;

import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.transaction.CDOCommitContext;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandler2;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.core.ContextProvider;

public abstract class ExecutorComponent<C extends CDOViewContext<?,?>> implements Executor<C> {
	
	private static Logger logger = Logger.getLogger(ExecutorComponent.class.getName());

	private ContextProvider<C> contextProvider;
	
	protected ContextProvider<C> getContextProvider() {
		return contextProvider;
	}
	
	@Override
	public <R> void post(Command<R, C> command, Date when) {
		final Job<R, C> job = FlowFactory.eINSTANCE.createJob();
		job.setCommand(command);
		job.setWhen(when);
		job.setCreated(new Date());
		storeJob(job);
		((CDOTransaction) command.cdoView()).addTransactionHandler(new CDOTransactionHandler2() {
			
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
				getExecutor().execute(createRunnable(job.cdoID()));
			}
		});
	}
	
	@Override
	public <R> void post(Command<R, C> command) {
		post(command, null);		
	}
	
	@Override
	public <R> Promise<R, C> submit(Command<R, C> command, Date when) {
		final Job<R, C> job = FlowFactory.eINSTANCE.createJob();
		job.setCommand(command);
		job.setCreated(new Date());
		job.setWhen(when);
		Deferred<R, C> ret = FlowFactory.eINSTANCE.createDeferred();
		job.setDeferred(ret);
		storeJob(job);
		((CDOTransaction) command.cdoView()).addTransactionHandler(new CDOTransactionHandler2() {
			
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
				getExecutor().execute(createRunnable(job.cdoID()));
			}
		});
		return ret;
	}
	
	@Override
	public <R> Promise<R, C> submit(Command<R, C> command) {
		return submit(command, null);
	}
	
	protected java.util.concurrent.Executor getExecutor() {
		return executor;
	}
	
	protected Runnable createRunnable(final CDOID jobID) {
		return new Runnable() {
			@Override
			public void run() {
				try (C context = contextProvider.createContext()) {
					@SuppressWarnings("unchecked")
					final Job<Object,C> job = (Job<Object, C>) context.getView().getObject(jobID);
					final Exception[] rejectionReason = { null };
					if (job.canExecute()) {
						job.setStatus(JobStatus.RUNNING);
						job.setStarted(new Date());
						try {
							Object result = job.getCommand().execute(context, ExecutorComponent.this);
							if (job.getDeferred()!=null) {
								job.getDeferred().resolve(result, context, ExecutorComponent.this);
							}						
							job.setStatus(JobStatus.COMPLETED);
							job.setCompleted(new Date());
							dispose(job);
						} catch (Exception e) {
							rejectionReason[0] = e;
							if (job.getDeferred()==null) {
								logger.log(Level.SEVERE, "Job failed: "+e, e);
								job.setStatus(JobStatus.FAILED);
								job.setFailureReason(e.toString());
							} else {
								job.getDeferred().reject(e, context, ExecutorComponent.this);
								job.setStatus(JobStatus.COMPLETED);
								job.setCompleted(new Date());
								dispose(job);
							}
						} finally {
							((CDOTransaction) job.cdoView()).addTransactionHandler(new CDOTransactionHandler2() {
								
								@SuppressWarnings("unchecked")
								@Override
								public void rolledBackTransaction(CDOTransaction transaction) {
									// Mark the job as rolled-back in another transaction
									try (C context = getContextProvider().createContext()) {
										Job<?, C> job2 = (Job<?,C>) context.getView().getObject(job.cdoID());
										job2.setStatus(JobStatus.ROLLEDBACK);
										if (rejectionReason[0]!=null) {
											if (job2.getDeferred()==null) {
												logger.log(Level.SEVERE, "Job failed: "+rejectionReason[0], rejectionReason[0]);
												job2.setFailureReason(rejectionReason[0].toString());
											} else {
												job2.getDeferred().reject(rejectionReason[0], context, ExecutorComponent.this);
												job2.setCompleted(new Date());
												dispose(job2);
											}											
										}
									} catch (Exception e) {
										logger.log(Level.SEVERE, "Could not mark job as rolled back: "+e, e);
									}
								}
								
								@Override
								public void committingTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
									// NOP
								}
								
								@Override
								public void committedTransaction(CDOTransaction transaction, CDOCommitContext commitContext) {
									// NOP
								}
							});
						}
					}
				} catch (Exception e) {
					logger.log(Level.SEVERE, "Error executing command", e);
				}				
			}
		};
	}
	
	/**
	 * Cleanup method, this implementation does nothing. Subclasses may 
	 * override it to remove (detach) completed jobs from the repository.
	 * @param job
	 */
	protected void dispose(Job<?,C> job) {
		// NOP
	}
	
	/**
	 * Creates a job from command and deferrable, stores the job in the repository.
	 * @param command
	 */
	protected abstract void storeJob(Job<?, C> job);
	
	/**
	 * Polls jobs ready for execution.
	 * @return
	 */
	protected abstract Iterator<CDOID> poll();
	
	public void setContextProvider(ContextProvider<C> contextProvider) {
		this.contextProvider = contextProvider;
	}
	
	private int threadPoolSize;
	
	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
	
	private boolean externalExecutor;
	
	private long pollInterval;
	
	private Timer pollTimer;
	
	/**
	 * Interval for polling for jobs ready to be executed.
	 * @param pollInterval
	 */
	public void setPollInterval(long pollInterval) {
		this.pollInterval = pollInterval;
	}
	
	public void activate() throws Exception {
		if (executor==null) {
			if (threadPoolSize<=0) {
				// Calling thread executor.
				executor = new java.util.concurrent.Executor() {
					
					@Override
					public void execute(Runnable command) {
						command.run();			
					}
					
				};
			} else {
				executor = Executors.newFixedThreadPool(threadPoolSize);
			}
		}
		
		TimerTask pollTask = new TimerTask() {

			@Override
			public void run() {
				Iterator<CDOID> jit = poll();
				while (jit.hasNext()) {
					getExecutor().execute(createRunnable(jit.next()));
				}
			}
			
		};
				
		if (pollInterval>0) {
			pollTimer = new Timer("Executor poll timer");
			pollTimer.schedule(pollTask, pollInterval, pollInterval);
		}
	}
	
	public void deactivate() {
		if (pollTimer!=null) {
			pollTimer.cancel();
		}
		
		if (executor instanceof ExecutorService && !externalExecutor) {
			((ExecutorService) executor).shutdown();
		}
	}

	/**
	 * Default calling thread executor
	 */
	private java.util.concurrent.Executor executor;
	
	public void setExecutor(java.util.concurrent.Executor executor) {
		this.executor = executor;
		externalExecutor = true;
	}
	
}
