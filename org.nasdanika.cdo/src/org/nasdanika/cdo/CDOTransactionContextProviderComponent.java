package org.nasdanika.cdo;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandlerBase;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.core.NasdanikaException;
import org.osgi.framework.Bundle;
import org.osgi.service.component.ComponentContext;

public abstract class CDOTransactionContextProviderComponent<CR> implements CDOTransactionContextProvider<CR> {

	private CDOSessionProvider sessionProvider;
	private SecurityPolicyManager securityPolicyManager;
	private Bundle bundle;
	private boolean deny;
	
	public void activate(ComponentContext componentContext) throws Exception {
		securityPolicyManager = new SecurityPolicyManager(
				componentContext.getBundleContext(), 
				(String) componentContext.getProperties().get("security-policy-filter"));
		this.bundle = componentContext.getBundleContext().getBundle();
		deny = "deny".equalsIgnoreCase((String) componentContext.getProperties().get("default-access-decision"));
	}
	
	public void deactivate() throws Exception {
		if (securityPolicyManager!=null) {
			securityPolicyManager.close();
		}
	}
	
	public void setSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = sessionProvider;
	}
	
	public void clearSessionProvider(CDOSessionProvider sessionProvider) {
		this.sessionProvider = null;
	}	
	
	private Collection<CDOTransactionHandlerBase> transactionHandlers = new CopyOnWriteArrayList<CDOTransactionHandlerBase>();
	
	public void addTransactionHandler(CDOTransactionHandlerBase transactionHandler) {
		transactionHandlers.add(transactionHandler);
	}
	
	public void removeTransactionHandler(CDOTransactionHandlerBase transactionHandler) {
		transactionHandlers.remove(transactionHandler);
	}

	@Override
	public <MC> CDOTransactionContext<CR> createContext(MC masterContext) {
		if (sessionProvider!=null) {			
			try {
				return new CDOTransactionContextImpl<CR, MC>(
						bundle, 
						securityPolicyManager,
						masterContext,
						deny) {
					
					@Override
					public ProtectionDomain<CR> getProtectionDomain() {
						return CDOTransactionContextProviderComponent.this.getProtectionDomain(getView());
					}

					@Override
					protected CDOTransaction openView() {
						CDOTransaction transaction = sessionProvider.getSession().openTransaction();
						{
							for (CDOTransactionHandlerBase handler: transactionHandlers) {
								transaction.addTransactionHandler(handler);
							}
							// TODO - content adapters
						}
						return transaction;
					}

					
				};
			} catch (Exception e) {
				throw new NasdanikaException("Cannot create CDO View context", e);
			}
		}
		return null;
	}

	protected abstract ProtectionDomain<CR> getProtectionDomain(CDOTransaction view);

}
