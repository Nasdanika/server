package org.nasdanika.function;

public interface Facade<C, FC, T> {
	
	String getId();
	
	T getTarget(C context);
	
	<R, CMD extends Command<C,FC,T,R>> R executeCommand(CMD command); 

}
