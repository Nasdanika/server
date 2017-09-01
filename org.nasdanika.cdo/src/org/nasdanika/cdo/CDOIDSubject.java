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

	protected CDOIDSubject() {
	}
	
	protected long timestamp;
	
	@Override
	public long getTimestamp() {
		return timestamp;
	}
	
	@Override
	protected void setPrincipalIDs(List<CDOID> principalIDs) {
		this.principalIDs = principalIDs;
		timestamp = System.currentTimeMillis();
	}

	@Override
	protected List<CDOID> getPrincipalIDs() {
		return principalIDs;
	}
	
	@Override
	protected List<String> getPrincipalNames() {
		return principalNames;
	}
	
	public static <V extends CDOView, CR> CDOIDSubject<V, CR> createPrincipalsSubject(List<Principal> principals) {
		CDOIDSubject<V, CR> ret = new CDOIDSubject<V, CR>();
		ret.principalIDs = new ArrayList<>();
		for (Principal principal: principals) {
			ret.principalIDs.add(principal.cdoID());
		}
		return ret;
	}
		
	public static <V extends CDOView, CR> CDOIDSubject<V, CR> createPrincipalIDsSubject(List<CDOID> principalIDs) {
		CDOIDSubject<V, CR> ret = new CDOIDSubject<V, CR>();
		ret.principalIDs = new ArrayList<>(principalIDs);
		return ret;
	}	
	
	public static <V extends CDOView, CR> CDOIDSubject<V, CR> createPrincipalNamesSubject(List<String> principalNames) {
		CDOIDSubject<V, CR> ret = new CDOIDSubject<V, CR>();
		ret.principalNames = new ArrayList<>(principalNames);
		return ret;
	}
}

