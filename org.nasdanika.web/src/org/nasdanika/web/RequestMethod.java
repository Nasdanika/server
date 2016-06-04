package org.nasdanika.web;

/**
 * Request methods enumeration, corresponds to HTTP methods used in REST.
 * @author Pavel
 *
 */
public enum RequestMethod { 
	DELETE, 
	GET, 
	OPTIONS, 
	PATCH, 
	POST, 
	PUT, 
	TRACE,
	
	/**
	 * A pseudo method for web socket creation.
	 */
	CREATE_WEB_SOCKET
}