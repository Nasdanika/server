package org.nasdanika.core;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CommandExecutorComponent<CX extends Context, R, CMD extends Command<CX,R>> implements CommandExecutor<R, CMD> {

	private ExecutorService executorService;
	private ContextProvider<CX> contextProvider;

	@Override
	public Future<R> execute(final CMD command) {
		if (executorService == null) {
			try (CX ctx = contextProvider.createContext()) {
				final R result = command.execute(ctx);
				return new Future<R>() {

					@Override
					public boolean cancel(boolean mayInterruptIfRunning) {
						return false;
					}

					@Override
					public boolean isCancelled() {
						return false;
					}

					@Override
					public boolean isDone() {
						return true;
					}

					@Override
					public R get() throws InterruptedException,	ExecutionException {						
						return result;
					}

					@Override
					public R get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
						return result;
					}
				};
			} catch (final Exception e) {
				return new Future<R>() {

					@Override
					public boolean cancel(boolean mayInterruptIfRunning) {
						return false;
					}

					@Override
					public boolean isCancelled() {
						return false;
					}

					@Override
					public boolean isDone() {
						return true;
					}

					@Override
					public R get() throws InterruptedException,	ExecutionException {						
						throw new ExecutionException(e);
					}

					@Override
					public R get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
						throw new ExecutionException(e);
					}
				};
			}
			
		}
		executorService.submit(new Callable<R>() {

			@Override
			public R call() throws Exception {
				try (CX ctx = contextProvider.createContext()) {
					return command.execute(ctx);
				}
			}
			
		});
		return null;
	}
	
	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}
	
	public void setContextProvider(ContextProvider<CX> contextProvider) {
		this.contextProvider = contextProvider;
	}

}
