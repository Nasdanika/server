package org.nasdanika.cdo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	private List<CDOID> principalIDs = Collections.emptyList();
	private List<String> principalNames = Collections.emptyList();

	public CDOIDSubject(List<Principal> principals, List<String> principalNames) {
		if (principals == null) {
			principalNames = new ArrayList<>();
			for (String name: principalNames) {
				principalNames.add(name);
			}
		} else {
			principalIDs = new ArrayList<>();
			for (Principal principal: principals) {
				principalIDs.add(principal.cdoID());
			}
		} 
	}
	
	@Override
	protected void setPrincipalIDs(List<CDOID> principalIDs) {
		this.principalIDs = principalIDs;
	}

	@Override
	protected List<CDOID> getPrincipalIDs() {
		return principalIDs;
	}
	
	@Override
	protected List<String> getPrincipalNames() {
		return principalNames;
	}
	
}

