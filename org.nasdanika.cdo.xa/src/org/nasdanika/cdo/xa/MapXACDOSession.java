package org.nasdanika.cdo.xa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import javax.transaction.xa.XAResource;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOUserTransaction;
import org.eclipse.emf.cdo.transaction.CDOXATransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * This class uses a map of CDO views as user object and internally leverages AbstractXACDOSession.
 * @author Pavel Vlasov
 *
 */
public class MapXACDOSession<K> {
	
	/**
	 * Base user object interface.
	 * @author Pavel Vlasov
	 *
	 */
	public interface Views<K> {
		
		/**
		 * @return Views participating in the transaction.
		 */
		Map<K,CDOView> getViews();
				
		ResourceSet getResourceSet();		
		
	}
	
	/**
	 * Views interface used if there is context distributed transaction. 
	 * @author Pavel Vlasov
	 *
	 */
	public interface XAViews<K> extends Views<K>, AutoCloseable {
						
	}
	
	/**
	 * Views interface used if there is no context distributed transaction
	 * and transactional behavior shall be managed by CDOXATransaction.
	 * @author Pavel Vlasov
	 *
	 */
	public interface CDOXAViews<K> extends Views<K> {
		
		/**
		 * @return CDOXATransaction object. 
		 */
		CDOUserTransaction getCDOTransaction();	
		
	}
	
	private Map<K,CDOSession> sessions = new HashMap<K, CDOSession>();
	private TransactionManager transactionManager;

	public Map<K, CDOSession> getSessions() {
		return sessions;
	}

	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	private XACDOSession<Views<K>> xaSession = new AbstractXACDOSession<Views<K>>() {

		/**
		 * Opens a view for each session. All views are added to a single resource set.
		 */
		@Override
		protected BranchData<Views<K>> createBranch(final boolean xaManaged) {
			final Map<K,CDOView> views = new HashMap<>();
			final ResourceSet rs = new ResourceSetImpl();
			for (Entry<K, CDOSession> e: getSessions().entrySet()) {
				views.put(e.getKey(), openView(e.getValue(), e.getKey(), rs));
			}
			
			return new BranchData<Views<K>>() {
				
				Views<K> userObject;
				
				{
					if (xaManaged) {
						userObject = new Views<K>() {

							@Override
							public Map<K,CDOView> getViews() {
								return views;
							}

							@Override
							public ResourceSet getResourceSet() {
								return rs;
							}
							
						};
					} else {
						userObject = new CDOXAViews<K>() {
							
							private CDOUserTransaction transaction = CDOUtil.createXATransaction(rs);

							@Override
							public Map<K,CDOView> getViews() {
								return views;
							}

							@Override
							public ResourceSet getResourceSet() {
								return rs;
							}

							@Override
							public CDOUserTransaction getCDOTransaction() {
								return transaction;
							}
							
						};
					}
				}
				
				@Override
				public Iterable<Notifier> getNotifiers() {
					return Collections.<Notifier>singleton(rs);
				}

				@Override
				public Views<K> getUserObject() {
					return userObject;
				}
			};
		}
	};
	
	private Map<Transaction, Views<K>> enlistments = new WeakHashMap<>();
	
	/**
	 * If there is no context distributed transaction this method returns CDOXAViews instance and transactionality shall be managed through {@link CDOUserTransaction} obtained from its getCDOTransaction() method.
	 * Otherwise this method enlists XAResource into the current transaction and returns XAViews instance. In this case transactionality shall be managed with {@link UserTransaction} or by the container. XAViews.close() method
	 * shall be invoked to delist XAResource from the transaction.
	 * @return
	 * @throws SystemException
	 * @throws RollbackException
	 */
	public Views<K> getViews() throws SystemException, RollbackException {
		final Transaction tr = transactionManager==null ? null : transactionManager.getTransaction();
		
		// No distributed transaction, using CDOXATransaction.
		if (tr == null) {
			final Map<K,CDOView> views = new HashMap<>();
			final ResourceSet rs = new ResourceSetImpl();
			for (Entry<K, CDOSession> e: getSessions().entrySet()) {
				views.put(e.getKey(), openView(e.getValue(), e.getKey(), rs));
			}
			final CDOXATransaction cdoTr = CDOUtil.createXATransaction(rs);
			return new CDOXAViews<K>() {
				
				@Override
				public Map<K,CDOView> getViews() {
					return views;
				}
				
				@Override
				public ResourceSet getResourceSet() {
					return rs;
				}
				
				@Override
				public CDOUserTransaction getCDOTransaction() {
					return cdoTr;
				}
			};
		}
		
		synchronized (enlistments) {
			Views<K> ret = enlistments.get(tr);
			if (ret!=null) {
				return ret;
			}
		}
		
		// Enlist XA resource, wrap branch's user object.				
		XAViews<K> tViews = new XAViews<K>() {
						
			@Override
			public void close() throws SystemException {
				tr.delistResource(xaSession.getXAResource(), XAResource.TMSUCCESS);
				synchronized (enlistments) {
					enlistments.remove(tr);
				}
			}
			
			@Override
			public Map<K,CDOView> getViews() {
				return xaSession.getUserObject().getViews();
			}
			
			@Override
			public ResourceSet getResourceSet() {
				return xaSession.getUserObject().getResourceSet();
			}
		};
		
		tr.enlistResource(xaSession.getXAResource());
		synchronized (enlistments) {
			enlistments.put(tr, tViews);
		}
		return tViews;
	}

	/**
	 * Opens view for a given session. This implementation invokes CDOSession.openTransaction();
	 * @param cdoSession
	 * @param key Session key
	 * @param resourceSet Resource set. 
	 * @return View object.
	 */
	protected CDOView openView(CDOSession cdoSession, K key, ResourceSet resourceSet) {
		return cdoSession.openTransaction(resourceSet);
	}

}
