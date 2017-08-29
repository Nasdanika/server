package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.osgi.framework.Bundle;

public abstract class CDOTransactionContextImpl<CR> extends CDOViewContextImpl<CDOTransaction, CR> implements CDOTransactionContext<CR> {

	public CDOTransactionContextImpl(
			Bundle bundle, 
			AccessDecision defaultAccessDecision,
			CDOViewContextSubject<CDOTransaction, CR> subject,
			Context... chain) throws Exception {
		super(bundle, defaultAccessDecision, subject, chain);
	}
		
	private boolean rollbackOnly;

	@Override
	public void close() throws Exception {
		try {
			if (rollbackOnly) {
				getView().rollback();
			} else {
				getView().commit();
			}
		} finally {
			super.close();
		}
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
