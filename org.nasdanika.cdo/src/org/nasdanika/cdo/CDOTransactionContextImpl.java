package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.osgi.framework.Bundle;

public abstract class CDOTransactionContextImpl<CR> extends CDOViewContextImpl<CDOTransaction, CR> implements CDOTransactionContext<CR> {

	public CDOTransactionContextImpl(
			Bundle bundle, 
			SecurityPolicyManager securityPolicyManager,
			AccessDecision defaultAccessDecision,
			CDOViewContextSubject<CDOTransaction, CR> subject,
			Context... chain) throws Exception {
		super(bundle, securityPolicyManager, defaultAccessDecision, subject, chain);
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
