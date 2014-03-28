package org.nasdanika.web;


public interface AuthorizationProvider {

	/**
	 * Checks whether given context has a permission to execute an action on the ojbect
	 * @param target Target object
	 * @param action Action ID.
	 * @return Boolean.TRUE if action is allowed, Boolean.FALSE if denied, null if 
	 * this provider neither allows nor denies the action - used for chaining/stacking of
	 * security providers.
	 */
	Boolean authorize(Context context, Object target, String action);
	
}
