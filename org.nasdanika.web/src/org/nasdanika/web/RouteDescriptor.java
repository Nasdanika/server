package org.nasdanika.web;

public interface RouteDescriptor {
	
	enum RouteType { ROOT, OBJECT, EXTENSION }
	
	Route getRoute();
	
	int getPriority();
	
	String getPattern();
	
	Class<?> getTarget();
	
	RequestMethod[] getMethods();
	
	RouteType getType();

}
