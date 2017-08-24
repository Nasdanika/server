package org.nasdanika.cdo.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOTransactionContextFilter;
import org.nasdanika.cdo.CDOTransactionContextProvider;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.core.ContextRunnable;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;

/**
 * OSGi component providing scheduler service. Creates a thread pool executor service and uses {@link CDOTransactionContextProvider} reference for context creation.
 * @author Pavel Vlasov
 *
 */
public class SchedulerComponent<CR> implements Scheduler<CR> {
	
	protected ScheduledExecutorService scheduledExecutorService;
	protected BundleContext bundleContext;

	/**
	 * Sets {@link CDOTransactionContextProvider} reference.
	 * @param transactionContextProvider
	 */
	public void setTransactionContextProvider(CDOTransactionContextProvider<CR> transactionContextProvider) {
		this.transactionContextProvider = transactionContextProvider;
	}
	
	/**
	 * Clears {@link CDOTransactionContextProvider} reference.
	 * @param transactionContextProvider
	 */
	public void unsetTransactionContextProvider(CDOTransactionContextProvider<CR> transactionContextProvider) {
		if (this.transactionContextProvider == transactionContextProvider) {
			this.transactionContextProvider = null;
		}
	}
	
	/**
	 * Creates a thread pool executor service and then schedules tasks returned by <code>getTasks()</code> method.
	 * @param componentContext
	 * @throws Exception
	 */
	public void activate(ComponentContext componentContext) throws Exception {
		this.bundleContext = componentContext.getBundleContext();
	}
	
	public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}
	
	public void unsetScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		if (this.scheduledExecutorService == scheduledExecutorService) {
			this.scheduledExecutorService = null;
		}
	}
	
	
	protected SchedulerContext<CR> createContext(CDOViewContextSubject<CDOTransaction, CR> subject, Future<?> future) throws Exception {		
		class SchedulerContextImpl extends CDOTransactionContextFilter<CR> implements SchedulerContext<CR> {

			public SchedulerContextImpl(CDOTransactionContext<CR> target) {
				super(target);
			}

			@Override
			public Future<?> submit(ContextRunnable<SchedulerContext<CR>> task,	CDOViewContextSubject<CDOTransaction, CR> subject) {
				return SchedulerComponent.this.submit(task, subject);
			}

			@Override
			public ScheduledFuture<?> schedule(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject, long delay, TimeUnit unit) {
				return SchedulerComponent.this.schedule(task, subject, delay, unit);
			}

			@Override
			public ScheduledFuture<?> scheduleAtFixedRate(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject, long initialDelay, long period, TimeUnit unit) {
				return SchedulerComponent.this.scheduleAtFixedRate(task, subject, initialDelay, period, unit);
			}

			@Override
			public ScheduledFuture<?> scheduleWithFixedDelay(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject, long initialDelay, long delay, TimeUnit unit) {
				return SchedulerComponent.this.scheduleWithFixedDelay(task, subject, initialDelay, delay, unit);
			}

			@Override
			public boolean cancel() {
				return future != null && future.cancel(false);
			}

			@Override
			public BundleContext getBundleContext() {
				return bundleContext;
			}

		}
		if (transactionContextProvider != null) {
			CDOTransactionContext<CR> context = transactionContextProvider.createContext(subject);
			if (context != null) {
				return new SchedulerContextImpl(context);
			}
		}
		return null;
	}
	
	private class SchedulerRunnable implements Runnable {
		
		private ContextRunnable<SchedulerContext<CR>> task;
		private CDOViewContextSubject<CDOTransaction, CR> subject;
		private Future<?> future;

		SchedulerRunnable(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject) {
			this.task = task;
			this.subject = subject;
		}
		
		void setFuture(Future<?> future) {
			this.future = future;
		}

		@Override
		public void run() {
			try {
				SchedulerContext<CR> schedulerContext = createContext(subject, future);
				if (schedulerContext != null) {
					try {  
						task.run(schedulerContext);
					} finally {
						schedulerContext.close();
					}
				}
			} catch (Exception e) {
				handleException(task, future, e);
			}				
		}
		
	}
	
	/**
	 * Handles task exception. 
	 */
	protected void handleException(ContextRunnable<SchedulerContext<CR>> task, Future<?> future, Exception e) {
		System.err.println("Error executing task: "+task);
		e.printStackTrace(); 
	}

	/**
	 * Cancels scheduled tasks and shuts down the executor service.
	 * @param componentContext
	 * @throws Exception
	 */
	public void deactivate(ComponentContext componentContext) throws Exception {
		scheduledExecutorService = null;
	}
	
	private CDOTransactionContextProvider<CR> transactionContextProvider;
	
	@Override
	public Future<?> submit(ContextRunnable<SchedulerContext<CR>> task,	CDOViewContextSubject<CDOTransaction, CR> subject) {
		SchedulerComponent<CR>.SchedulerRunnable schedulerRunnable = new SchedulerRunnable(task, subject);		
		Future<?> future = scheduledExecutorService.submit(schedulerRunnable); 
		return future;
	}

	@Override
	public ScheduledFuture<?> schedule(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject, long delay, TimeUnit unit) {
		if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
			throw new RejectedExecutionException("Executor service is not set or has been shut down");
		}
		SchedulerComponent<CR>.SchedulerRunnable schedulerRunnable = new SchedulerRunnable(task, subject);		
		return scheduledExecutorService.schedule(schedulerRunnable, delay, unit);
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject, long initialDelay, long period, TimeUnit unit) {
		if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
			throw new RejectedExecutionException("Executor service is not set or has been shut down");
		}
		SchedulerComponent<CR>.SchedulerRunnable schedulerRunnable = new SchedulerRunnable(task, subject);		
		ScheduledFuture<?> future = scheduledExecutorService.scheduleAtFixedRate(schedulerRunnable, initialDelay, period, unit);
		schedulerRunnable.setFuture(future);
		return future;
	}

	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay(ContextRunnable<SchedulerContext<CR>> task, CDOViewContextSubject<CDOTransaction, CR> subject, long initialDelay, long delay, TimeUnit unit) {
		if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
			throw new RejectedExecutionException("Executor service is not set or has been shut down");
		}
		SchedulerComponent<CR>.SchedulerRunnable schedulerRunnable = new SchedulerRunnable(task, subject);		
		ScheduledFuture<?> future = scheduledExecutorService.scheduleWithFixedDelay(schedulerRunnable, initialDelay, delay, unit);
		schedulerRunnable.setFuture(future);
		return future;
	}

}
