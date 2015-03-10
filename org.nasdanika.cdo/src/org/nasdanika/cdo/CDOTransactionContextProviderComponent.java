package org.nasdanika.cdo;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandlerBase;
import org.nasdanika.cdo.security.LoginPasswordHashUser;
import org.nasdanika.cdo.security.LoginUser;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.cdo.security.SecurityPolicy;
import org.nasdanika.cdo.security.SecurityPolicyManager;
import org.nasdanika.cdo.security.User;
import org.nasdanika.core.Context;
import org.nasdanika.core.SecurityContext;
import org.osgi.service.component.ComponentContext;

public abstract class CDOTransactionContextProviderComponent<CR, MC extends Context> implements CDOTransactionContextProvider<CR, MC> {
	
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
	
	private Collection<CDOTransactionHandlerBase> transactionHandlers = new CopyOnWriteArrayList<CDOTransactionHandlerBase>();
	
	public void addTransactionHandler(CDOTransactionHandlerBase transactionHandler) {
		transactionHandlers.add(transactionHandler);
	}
	
	public void removeTransactionHandler(CDOTransactionHandlerBase transactionHandler) {
		transactionHandlers.remove(transactionHandler);
	}

	@Override
	public CDOTransactionContext<CR, MC> createContext() {
		if (sessionProvider!=null) {			
			return new CDOTransactionContext<CR, MC>() {
				
				private CDOTransaction transaction = sessionProvider.getSession().openTransaction();
				
				{
					for (CDOTransactionHandlerBase handler: transactionHandlers) {
						transaction.addTransactionHandler(handler);
					}
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
				public Principal getPrincipal(MC masterContext) throws Exception {
					if (authenticatedPrincipal!=null) {
						return authenticatedPrincipal;
					}
					
					java.security.Principal securityPrincipal = null;
					// Mapping Java security principal to protection domain principal. Principal name shall match user login.
					if (masterContext instanceof SecurityContext) {
						securityPrincipal = ((SecurityContext) masterContext).getSecurityPrincipal();
					} else {
						SecurityContext sc = masterContext.adapt(SecurityContext.class);
						if (sc!=null) {
							securityPrincipal = sc.getSecurityPrincipal();
						}
					}					
					
					if (securityPrincipal!=null) {
						for (User pdu: getProtectionDomain().getAllUsers()) { // TODO - find(login) to optimize search in large user populations
							if (pdu instanceof LoginUser && ((LoginUser) pdu).getLogin().equalsIgnoreCase(securityPrincipal.getName())) {								
								if (((LoginUser) pdu).isDisabled() || (pdu instanceof LoginPasswordHashUser && ((LoginPasswordHashUser) pdu).getPasswordHash()!=null)) {
									break;
								} else {
									return pdu;
								}
							}
						}
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
