package org.nasdanika.web;

import java.util.List;

public interface RouteRegistry {
	
	List<Route> matchObjectRoutes(RequestMethod method, Object target, String[] path) throws Exception;	
	
	List<Route> matchRootRoutes(RequestMethod method, String[] path) throws Exception;
	
	Route getExtensionRoute(RequestMethod method, Object target, String extension) throws Exception;

}
