package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.osgi.framework.Bundle;


public abstract class CDOTransactionContextImpl<CR, MC> extends CDOViewContextImpl<CDOTransaction, CR, MC> implements CDOTransactionContext<CR> {

	public CDOTransactionContextImpl(
			Bundle bundle, 
			SecurityPolicyManager securityPolicyManager,
			MC masterContext,
			AccessDecision defaultAccessDecision) throws Exception {
		super(bundle, securityPolicyManager, masterContext, defaultAccessDecision);
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
