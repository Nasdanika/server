package org.nasdanika.web;


public interface Context {
	
	/**
	 * Checks whether given extensionManager has a permission to execute
	 * an action on the ojbect
	 * @param target Target object
	 * @param action Action ID.
	 * @return true if action is allowed, false if denied.
	 */
	boolean authorize(Object target, String action);	
	
	/**
	 * Converts source to target type in given extensionManager.
	 * @param source
	 * @param targetType
	 * @return source converted to target type or null if conversion is not possible.
	 * @throws Exception
	 */
	<T> T convert(Object source, Class<T> targetType) throws Exception;
	
	RequestMethod getMethod();
	
	String[] getPath();
	
	/**
	 * Returns action for a given target object with current path offset to pathOffset. 
	 * @param target
	 * @param pathOffset
	 * @return
	 * @throws Exception
	 */
	Action getAction(Object target, int pathOffset) throws Exception;
		
	Object getRequestData();
	
	Object getTarget();
	
	Object getPrincipal();
	
}
