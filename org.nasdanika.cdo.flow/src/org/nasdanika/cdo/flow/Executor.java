package org.nasdanika.cdo.flow;

import java.util.Date;

import org.nasdanika.core.Context;

public interface Executor<C extends Context> {
	
	/**
	 * Fire-and-forget. Command is executed at some time in the future.
	 * @param command
	 */
	<R> void post(Command<R, C> command);
	
	<R> Promise<R,C> submit(Command<R,C> command);

	<R> void post(Command<R, C> command, Date when);
	
	<R> Promise<R,C> submit(Command<R,C> command, Date when);
}
