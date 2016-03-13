package org.nasdanika.web;

public interface RouteDescriptor {
	
	enum RouteType { ROOT, OBJECT, EXTENSION }
	
	Route getRoute();
	
	int getPriority();
	
	String getPattern();
	
	String getPath();
	
	Class<?> getTarget();
	
	RequestMethod[] getMethods();
	
	RouteType getType();

}
