package org.nasdanika.core;

public interface Component<C extends Context> {

	void activate(C context) throws Exception;
	
	void deactivate(C context) throws Exception;
	
}
