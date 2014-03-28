package org.nasdanika.web;

public interface RouteDescriptor {
	
	Route getRoute();
	
	int getPriority();
	
	String getPattern();
	
	Class<?> getTarget();
	
	RequestMethod[] getMethods();
	
	boolean isRoot();

}
