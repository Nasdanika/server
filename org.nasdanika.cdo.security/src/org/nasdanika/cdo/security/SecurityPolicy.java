package org.nasdanika.cdo.security;

import java.util.Collection;

public interface SecurityPolicy {
	
	/**
	 * Finds action by its key.
	 * @param actionKey
	 * @return
	 */
	Action getAction(ActionKey actionKey);
	
	/**
	 * Grantable actions for a given class, not including supertypes.
	 * @param targetNamespaceURI
	 * @param targetClass
	 * @return
	 */
	Collection<Action> getGrantableActions(String targetNamespaceURI, String targetClass);

}
