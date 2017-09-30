package org.nasdanika.cdo;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.LoginPasswordRealm;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.cdo.security.TokenCredentials;

public class TokenCDOViewContextSubject <V extends CDOView, CR> implements CDOViewContextSubject<V, CR> {
	
	private long timestamp;
	private TokenCredentials tokenCredentials;

	public TokenCDOViewContextSubject(String client, String token) {
		this.tokenCredentials = new TokenCredentials() {
			
			@Override
			public String getLogin() {
				return client;
			}
			
			@Override
			public String getPassword() {
				return token;
			}
			
		};
		
		this.timestamp = System.currentTimeMillis();
	}

	@Override
	public List<Principal> getPrincipals(CDOViewContext<V, CR> context) {
		Realm<CR> securityRealm = context.getSecurityRealm();		
		return securityRealm instanceof LoginPasswordRealm ?  ((LoginPasswordRealm) securityRealm).authenticate(tokenCredentials) : Collections.emptyList();
	}

	@Override
	public void setPrincipals(CDOViewContext<V, CR> context, List<Principal> principals) {
		throw new UnsupportedOperationException("Token subject does not support this operation");
	}

	@Override
	public long getTimestamp() {
		return timestamp;
	}
	
	@Override
	public Map<String, Object> configureAuthorizationEnvironment(Map<String, Object> environment) {
		environment = CDOViewContextSubject.super.configureAuthorizationEnvironment(environment);
		Map<String, Object> ret = environment == null ? new HashMap<>() : new HashMap<>(environment);
		ret.put("token.client", tokenCredentials.getLogin());
		ret.put("token.payload", tokenCredentials.getPassword());		
		return ret;
	}

}
