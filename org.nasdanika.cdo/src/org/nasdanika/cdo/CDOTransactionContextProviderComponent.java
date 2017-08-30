package org.nasdanika.cdo;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.session.CDOSessionProvider;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionHandlerBase;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.core.NasdanikaException;
import org.osgi.framework.Bundle;
import org.osgi.service.component.ComponentContext;

public abstract class CDOTransactionContextProviderComponent<CR> implements CDOTransactionContextProvider<CR> {

	private CDOSessionProvider sessionProvider;
	private Bundle bundle;
	private AccessDecision defaultAccessDecision;
	
	public void activate(ComponentContext componentContext) throws Exception {
		this.bundle = componentContext.getBundleContext().getBundle();
		defaultAccessDecision = "deny".equalsIgnoreCase((String) componentContext.getProperties().get("default-access-decision")) ? AccessDecision.DENY : AccessDecision.ALLOW;
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
	public CDOTransactionContext<CR> createContext(CDOViewContextSubject<CDOTransaction, CR> subject, Context... chain) {
		if (sessionProvider!=null) {			
			try {
				return new CDOTransactionContextImpl<CR>(
						bundle, 
						defaultAccessDecision,
						subject,
						chain) {
					
					@Override
					public Realm<CR> getSecurityRealm() {
						return CDOTransactionContextProviderComponent.this.getSecurityRealm(getView());
					}

					@Override
					protected CDOTransaction openView() {
						CDOTransaction transaction = sessionProvider.getSession().openTransaction();
						onOpenTransaction(this, transaction);
						return transaction;
					}

					@Override
					public void close() throws Exception {
						onCloseContext(this);
						super.close();						
					}
					
					@Override
					public Lock getReadLock(CDOObject obj) throws Exception {
						return CDOTransactionContextProviderComponent.this.getReadLock(this, obj);
					}
					
					@Override
					public Lock getWriteLock(CDOObject obj) throws Exception {
						return CDOTransactionContextProviderComponent.this.getWriteLock(this, obj);
					}
					
				};
			} catch (Exception e) {
				throw new NasdanikaException("Cannot create CDO transaction context", e);
			}
		}
		return null;
	}
	
	/**
	 * Invoked on opening transaction.
	 * @param transaction
	 */
	protected void onOpenTransaction(CDOTransactionContext<CR> context, CDOTransaction transaction) {
		for (CDOTransactionHandlerBase handler: transactionHandlers) {
			transaction.addTransactionHandler(handler);
		}		
	}
	
	/**
	 * Invoked when context is closed.
	 * @param context
	 */
	protected void onCloseContext(CDOTransactionContext<CR> context) {
		
	}

	protected abstract Realm<CR> getSecurityRealm(CDOTransaction view);
	
	/**
	 * Override to customize locking. E.g. return a lock which invokes CDOLock.lock(timeout) from lock().
	 * Or record locks acquired for a given context and unlock them in onCloseContext().
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	protected Lock getReadLock(CDOTransactionContext<CR> context, CDOObject obj) throws Exception {
		return obj.cdoReadLock();
	}
	
	/**
	 * Override to customize locking
	 * @param context
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	protected Lock getWriteLock(CDOTransactionContext<CR> context, CDOObject obj) throws Exception {
		return obj.cdoWriteLock();
	}
	

}
