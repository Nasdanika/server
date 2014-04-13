package org.nasdanika.core;

import java.util.concurrent.Future;

public interface CommandExecutor<R, CMD extends Command<?,R>> {

	Future<R> execute(CMD command);
	
}
