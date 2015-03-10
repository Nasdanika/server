package org.nasdanika.promise;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;

public interface Facade<C extends Context, T> {
	
	String getId();
	
	T getTarget(C context);
	
	/**
	 * Creates context and executes the command in context passing target as an argument. 
	 * @param command
	 * @return
	 */
	<R, CMD extends Command<C,T,R>> R executeCommand(CMD command); 

}
