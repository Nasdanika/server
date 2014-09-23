package org.nasdanika.cdo.security;

public interface SecurityPolicy {
	
	/**
	 * Finds action by its key.
	 * @param actionKey
	 * @return
	 */
	Action getAction(ActionKey actionKey);
	
	/**
	 * Grantable actions for a given class.
	 * @param targetNamespaceURI
	 * @param targetClass
	 * @return
	 */
	Iterable<Action> getGrantableActions(String targetNamespaceURI, String targetClass);

}
