package org.nasdanika.cdo;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.LoginPasswordCredentials;
import org.nasdanika.cdo.security.LoginPasswordRealm;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;

public class LoginPasswordCDOViewContextSubject <V extends CDOView, CR> implements CDOViewContextSubject<V, CR> {
	
	private long timestamp;
	private LoginPasswordCredentials credentials;

	public LoginPasswordCDOViewContextSubject(String login, String password) {
		this.credentials = new LoginPasswordCredentials() {
			
			@Override
			public String getLogin() {
				return login;
			}
			
			@Override
			public String getPassword() {
				return password;
			}
			
		};
		
		this.timestamp = System.currentTimeMillis();
	}

	@Override
	public List<Principal> getPrincipals(CDOViewContext<V, CR> context) {
		Realm<CR> securityRealm = context.getSecurityRealm();		
		return securityRealm instanceof LoginPasswordRealm ?  ((LoginPasswordRealm) securityRealm).authenticate(credentials) : Collections.emptyList();
	}

	@Override
	public void setPrincipals(CDOViewContext<V, CR> context, List<Principal> principals) {
		throw new UnsupportedOperationException("Login password subject does not support this operation");
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}

}
