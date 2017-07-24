package org.nasdanika.cdo.web;

import org.eclipse.emf.cdo.CDOObject;

/**
 * A value class for caching authorization results on {@link CDOObject}s.
 * @author Pavel Vlasov
 *
 */
public class CDOObjectAuthorizationValue {
		
	private boolean authorized;	
	private long expires;
	
	public CDOObjectAuthorizationValue(boolean authorized, long expires) {
		super();
		this.authorized = authorized;
		this.expires = expires;
	}
	
	public boolean isAuthorized() {
		return authorized;
	}
	
	public boolean isExpired() {
		return expires != -1 && expires < System.currentTimeMillis();
	}

}
