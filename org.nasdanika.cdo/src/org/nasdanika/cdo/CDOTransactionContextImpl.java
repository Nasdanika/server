package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.core.Context;
import org.osgi.framework.Bundle;


public abstract class CDOTransactionContextImpl<CR, MC extends Context> extends CDOViewContextImpl<CDOTransaction, CR, MC> implements CDOTransactionContext<CR, MC> {

	public CDOTransactionContextImpl(Bundle bundle, SecurityPolicyManager securityPolicyManager) throws Exception {
		super(bundle, securityPolicyManager);
	}
		
	private boolean rollbackOnly;

	@Override
	public void close() throws Exception {
		if (rollbackOnly) {
			getView().rollback();
		} else {
			getView().commit();
		}
		super.close();
	}

	@Override
	public void setRollbackOnly() {
		rollbackOnly = true;					
	}

	@Override
	public boolean isRollbackOnly() {
		return rollbackOnly;
	}
}
