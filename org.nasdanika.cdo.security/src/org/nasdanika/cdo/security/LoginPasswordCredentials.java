package org.nasdanika.cdo.security;

public interface LoginPasswordCredentials {
	
	String getLogin() throws Exception;
	
	String getPassword() throws Exception;

}
