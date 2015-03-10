package org.nasdanika.core;

import java.util.concurrent.Future;

public interface CommandExecutor<C extends Context, T, R, CMD extends Command<C,T,R>> {

	Future<R> execute(CMD command);
	
}
