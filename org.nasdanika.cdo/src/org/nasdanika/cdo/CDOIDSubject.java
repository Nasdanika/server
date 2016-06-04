package org.nasdanika.cdo;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;

/**
 * Simple subject keeping principal identity - CDOID or name - in the instance.
 * @author Pavel Vlasov
 *
 * @param <V>
 * @param <CR>
 */
public class CDOIDSubject<V extends CDOView, CR> extends AbstractCDOViewContextSubject<V, CR> {

	private CDOID principalID;
	private String principalName;

	public CDOIDSubject(Principal principal) {		
		if (principal != null) {
			this.principalID = principal.cdoID();
		}
	}
	
	public CDOIDSubject(String principalName) {
		this.principalName = principalName;
	}
	
	protected void setPrincipalID(CDOID cdoID) {
		this.principalID = cdoID;
	}

	protected CDOID getPrincipalID() {
		return principalID;
	}
	
	@Override
	protected String getPrincipalName() {
		return principalName;
	}
	
}

