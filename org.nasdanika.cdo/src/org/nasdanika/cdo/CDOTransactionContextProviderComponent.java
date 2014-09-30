package org.nasdanika.cdo;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.osgi.service.component.ComponentContext;

public abstract class CDOTransactionContextProviderComponent<CR> implements CDOTransactionContextProvider<CR> {
	
	private CDOSessionProvider sessionProvider;
	private SecurityPolicyManager securityPolicyManager;
	
	public void activate(ComponentContext componentContext) throws Exception {
		securityPolicyManager = new SecurityPolicyManager(
				componentContext.getBundleContext(), 
				(String) componentContext.getProperties().get("security-policy-filter")); 
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
	
	// TODO - transaction handlers and content adapters references & extensions.

	@Override
	public CDOTransactionContext<CR> createContext() {
		if (sessionProvider!=null) {			
			return new CDOTransactionContext<CR>() {
				
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
				public CDOTransaction getView() {
					return transaction;
				}

				@Override
				public void setRollbackOnly() {
					rollbackOnly = true;					
				}
								
				private Principal authenticatedPrincipal;

				@Override
				public Principal getPrincipal() {
					if (authenticatedPrincipal!=null) {
						return authenticatedPrincipal;
					}
					ProtectionDomain<CR> pd = getProtectionDomain();
					return pd==null ? null : pd.getUnauthenticatedPrincipal();
				}

				@Override
				public ProtectionDomain<CR> getProtectionDomain() {
					return CDOTransactionContextProviderComponent.this.getProtectionDomain(getView());
				}

				@Override
				public Principal authenticate(CR credentials) {
					ProtectionDomain<CR> pd = getProtectionDomain();
					if (pd==null) {
						return null;
					}
					authenticatedPrincipal = pd.authenticate(credentials);
					return authenticatedPrincipal;
				}

				@SuppressWarnings("unchecked")
				@Override
				public <T> T adapt(Class<T> targetType) {					
					if (SecurityPolicy.class.equals(targetType)) {
						return (T) securityPolicyManager;
					}
					return targetType.isInstance(this) ? (T) this : null;
				}

				@Override
				public boolean isRollbackOnly() {
					return rollbackOnly;
				}
				
			};
		}
		return null;
	}

	protected abstract ProtectionDomain<CR> getProtectionDomain(CDOTransaction view);

}
