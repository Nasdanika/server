package org.nasdanika.cdo;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.transaction.CDOTransaction;

public class CDOTransactionContextProviderComponent implements CDOTransactionContextProvider {
	
	private CDOSessionProvider sessionProvider;
	
	public void setSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = sessionProvider;
	}
	
	public void clearSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = null;
	}	
	
	// TODO - transaction handlers and content adapters references & extensions.

	@Override
	public CDOTransactionContext createContext() {
		if (sessionProvider!=null) {			
			return new CDOTransactionContext() {
				
				private CDOTransaction transaction = sessionProvider.getSession().openTransaction();
				
				{
					// TODO - transaction.addTransactionHandler(handler);
					// TODO - content adapters
				}
				
				private boolean rollbackOnly;
				
				@Override
				public void close() throws Exception {
					if (rollbackOnly) {
						transaction.rollback();
					} else {
						transaction.commit();
					}
					transaction.close();
				}
				
				@Override
				public CDOTransaction getTransaction() {
					return transaction;
				}

				@Override
				public void setRollbackOnly() {
					rollbackOnly = true;					
				}
			};
		}
		return null;
	}

}
