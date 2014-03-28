package org.nasdanika.cdo.xa;

import java.util.Collections;
import java.util.Map;
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
 * This class uses array of CDO views as user object and internally leverages AbstractXACDOSession.
 * @author Pavel Vlasov
 *
 */
public class ArrayXACDOSession {
	
	/**
	 * Base user object interface.
	 * @author Pavel Vlasov
	 *
	 */
	public interface Views {
		
		/**
		 * @return Views participating in the transaction.
		 */
		CDOView[] getViews();
				
		ResourceSet getResourceSet();		
		
	}
	
	/**
	 * Views interface used if there is context distributed transaction. 
	 * @author Pavel Vlasov
	 *
	 */
	public interface XAViews extends Views, AutoCloseable {
						
	}
	
	/**
	 * Views interface used if there is no context distributed transaction
	 * and transactional behavior shall be managed by CDOXATransaction.
	 * @author Pavel Vlasov
	 *
	 */
	public interface CDOXAViews extends Views {
		
		/**
		 * @return CDOXATransaction object. 
		 */
		CDOUserTransaction getCDOTransaction();	
		
	}
	
	private CDOSession[] sessions;
	private TransactionManager transactionManager;
	
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void setSessions(CDOSession[] sessions) {
		this.sessions = sessions;
	}
	
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}
	
	public CDOSession[] getSessions() {
		return sessions;
	}
	
	private XACDOSession<Views> xaSession = new AbstractXACDOSession<Views>() {

		/**
		 * Opens a view for each session. All views are added to a single resource set.
		 */
		@Override
		protected BranchData<Views> createBranch(final boolean xaManaged) {
			final CDOView[] views = new CDOView[sessions.length];
			final ResourceSet rs = new ResourceSetImpl();
			for (int i=0; i<views.length; ++i) {
				views[i] = openView(sessions[i], i, rs);
			}
			
			return new BranchData<Views>() {
				
				Views userObject;
				
				{
					if (xaManaged) {
						userObject = new Views() {

							@Override
							public CDOView[] getViews() {
								return views;
							}

							@Override
							public ResourceSet getResourceSet() {
								return rs;
							}
							
						};
					} else {
						userObject = new CDOXAViews() {
							
							private CDOUserTransaction transaction = CDOUtil.createXATransaction(rs);

							@Override
							public CDOView[] getViews() {
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
				public Views getUserObject() {
					return userObject;
				}
			};
		}
	};
	
	private Map<Transaction, Views> enlistments = new WeakHashMap<>();
	
	/**
	 * If there is no context distributed transaction this method returns CDOXAViews instance and transactionality shall be managed through {@link CDOUserTransaction} obtained from its getCDOTransaction() method.
	 * Otherwise this method enlists XAResource into the current transaction and returns XAViews instance. In this case transactionality shall be managed with {@link UserTransaction} or by the container. XAViews.close() method
	 * shall be invoked to delist XAResource from the transaction.
	 * @return
	 * @throws SystemException
	 * @throws RollbackException
	 */
	public Views getViews() throws SystemException, RollbackException {
		final Transaction tr = transactionManager==null ? null : transactionManager.getTransaction();
		
		// No distributed transaction, using CDOXATransaction.
		if (tr == null) {
			final CDOView[] views = new CDOView[sessions.length];
			final ResourceSet rs = new ResourceSetImpl();
			for (int i=0; i<views.length; ++i) {
				views[i] = openView(sessions[i], i, rs);
			}
			final CDOXATransaction cdoTr = CDOUtil.createXATransaction(rs);
			return new CDOXAViews() {
				
				@Override
				public CDOView[] getViews() {
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
			Views ret = enlistments.get(tr);
			if (ret!=null) {
				return ret;
			}
		}
		
		// Enlist XA resource, wrap branch's user object.				
		XAViews tViews = new XAViews() {
						
			@Override
			public void close() throws SystemException {
				tr.delistResource(xaSession.getXAResource(), XAResource.TMSUCCESS);
				synchronized (enlistments) {
					enlistments.remove(tr);
				}
			}
			
			@Override
			public CDOView[] getViews() {
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
	 * @param i Session index.
	 * @param resourceSet Resource set. 
	 * @return View object.
	 */
	protected CDOView openView(CDOSession cdoSession, int i, ResourceSet resourceSet) {
		return cdoSession.openTransaction(resourceSet);
	}

}
