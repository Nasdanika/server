package org.nasdanika.cdo.web;

import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;

/**
 * A key class for caching authorization results on {@link CDOObject}s.
 * @author Pavel Vlasov
 *
 */
public class CDOObjectAuthorizationKey {
		
	private CDOID targetId;	
	private String action;
	private String qualifier;
	private List<CDOID> principalIDs;
	
	public CDOObjectAuthorizationKey(List<CDOID> principalIDs, CDOID targetId, String action, String qualifier) {
		this.principalIDs = principalIDs;
		this.targetId = targetId;
		this.action = action;
		this.qualifier = qualifier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((principalIDs == null) ? 0 : principalIDs.hashCode());
		result = prime * result + ((qualifier == null) ? 0 : qualifier.hashCode());
		result = prime * result + ((targetId == null) ? 0 : targetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CDOObjectAuthorizationKey other = (CDOObjectAuthorizationKey) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (principalIDs == null) {
			if (other.principalIDs != null)
				return false;
		} else if (!principalIDs.equals(other.principalIDs))
			return false;
		if (qualifier == null) {
			if (other.qualifier != null)
				return false;
		} else if (!qualifier.equals(other.qualifier))
			return false;
		if (targetId == null) {
			if (other.targetId != null)
				return false;
		} else if (!targetId.equals(other.targetId))
			return false;
		return true;
	}

}
