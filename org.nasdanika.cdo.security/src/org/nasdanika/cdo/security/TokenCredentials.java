package org.nasdanika.cdo.security;

/**
 * This interface indicates token credentials.
 * It returns null from getLogin() and shall return token value from getPassword(). 
 * @author Pavel Vlasov
 *
 */
public interface TokenCredentials extends LoginPasswordCredentials {
	
	/**
	 * Returns null, can be overridden to return, e.g. remote host name.
	 */
	@Override
	default String getLogin() {
		return null;
	}

}
