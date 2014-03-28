package org.nasdanika.cdo.xa;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.net4j.util.collection.Closeable;

/**
 * Abstract implementation of XACDOSession which relies on {@link CDOXATransactionImpl} 
 * for managing distributed transaction branches.
 * @author Pavel Vlasov
 *
 * @param <T> Type of the user object providing access to CDO views 
 * participating in a distributed transaction
 */
public abstract class AbstractXACDOSession<T> implements XACDOSession<T> {
	
	/**
	 * This interface is used by a transaction branch. It provides access to two objects
	 * one used to manage transactions and the other used by application programmers to 
	 * access CDO views and transactions participating in a distributed transaction. 
	 * @author Pavel Vlasov
	 *
	 * @param <T>
	 */
	protected interface BranchData<T> {
		
		/**
		 * @return Notifiers to convert to view sets to enlist into distributed transaction.
		 */
		Iterable<Notifier> getNotifiers();
		
		/**
		 * @return Object providing access to CDO transactions/views for the application programmer.
		 */
		T getUserObject();
		
	}
	
	/**
	 * User object for invocations outside transaction boundaries.
	 */
	private T unmanagedUserObject;
	
	/**
	 * XAResource can participate in multiple transactions simultaneously, but can be associated with at most one transaction at a time, i.e. its resource
	 * manager shall be able to maintain multiple transaction branches, with zero or one branch being active at any point of time.
	 * 
	 * Stack is used because Atomikos TransactionEssentials support nested transactions and don't call end() on enclosing transaction before calling start() on nested.
	 */
	private Deque<XidKey> transactionKeyStack = new ConcurrentLinkedDeque<>();
	
	private Map<XidKey, TransactionBranch<T>> branches = new HashMap<>();
	
	private XAResource xaResource = new XAResource() {
		
		private int timeout;
		
		@Override
		public boolean setTransactionTimeout(int seconds) throws XAException {
			this.timeout = seconds;
			return true;
		}
		
		@Override
		public boolean isSameRM(XAResource xares) throws XAException {
			return xares == this;
		}
		
		@Override
		public int getTransactionTimeout() throws XAException {
			return timeout;
		}
		
		@Override
		public synchronized Xid[] recover(int flag) throws XAException {
			if (flag==TMENDRSCAN) {
				return new Xid[] {}; // Empty array, everything was returned at TMSTARTSCAN
			}
			
			List<Xid> ret = new ArrayList<>();
			for (Map.Entry<XidKey, TransactionBranch<T>> be: branches.entrySet()) {
				if (TransactionBranch.State.PREPARED.equals(be.getValue().getState())) {
					ret.add(be.getKey().getXid());
				}
			}
			return ret.toArray(new Xid[ret.size()]);
		}
		
		@Override
		public synchronized void forget(Xid xid) throws XAException {
			// Forgetting about prepared branch by rolling it back.
			XidKey xidKey = new XidKey(xid);
			TransactionBranch<T> branch = branches.get(xidKey);
			// Doing nothing if branch is null, the spec doesn't say whether RM must throw and exception is this case.
			if (branch!=null) {
				if (TransactionBranch.State.PREPARED.equals(branch.getState())) {
					branch.forget();
					branches.remove(xidKey);
				} else {
					throw new XAException(XAException.XAER_NOTA); // Invalid XID.
				}
			}			
		}
		
		@Override
		public synchronized void start(Xid xid, int flags) throws XAException {			
			XidKey xidKey = new XidKey(xid);
			switch (flags) {
			case TMJOIN:
			{				
				// Joining existing branch
				TransactionBranch<T> branch = branches.get(xidKey);
				if (branch == null) {
					// Invalid XID
					throw new XAException(XAException.XAER_NOTA);
				}
				transactionKeyStack.push(xidKey);
				branch.join();
				break;
			}
			case TMRESUME: 
			{
				// Resume existing branch.
				TransactionBranch<T> branch = branches.get(xidKey);
				if (branch == null) {
					// Invalid XID
					throw new XAException(XAException.XAER_NOTA);
				}
				transactionKeyStack.push(xidKey);
				branch.resume();
				break;
			}
			case TMNOFLAGS: 
			{
				// Create a new branch
				if (branches.containsKey(xidKey)) {
					throw new XAException(XAException.XAER_DUPID);
				}
				BranchData<T> bData = createBranch(true);
				branches.put(xidKey, new TransactionBranch<T>(bData.getUserObject(), getProgressMonitor(), bData.getNotifiers()));
				transactionKeyStack.push(xidKey);
				break;
			}
			default:
				// Invalid flags.
				throw new XAException(XAException.XAER_INVAL);
			}
			
		}
		
		@Override
		public synchronized void end(Xid xid, int flags) throws XAException {
			if (transactionKeyStack.isEmpty()) {
				// end without start
				throw new XAException(XAException.XAER_PROTO);
			}
			
			XidKey xidKey = new XidKey(xid);
			if (!transactionKeyStack.peek().equals(xidKey)) {
				// Current XID is not equal to the argument XID.
				throw new XAException(XAException.XAER_NOTA);
			}
			TransactionBranch<T> branch = branches.get(xidKey);
			if (branch==null) {
				// Branch for given XID not found.
				throw new XAException(XAException.XAER_NOTA);				
			}
			switch (flags) {
			case TMSUSPEND:
				branch.suspend();
				break;
			case TMSUCCESS:
				branch.success();
				break;
			case TMFAIL:
				branch.fail();
				break;
			default:
				throw new XAException(XAException.XAER_INVAL);				
			}	
			transactionKeyStack.pop();
		}
		
		@Override
		public int prepare(Xid xid) throws XAException {
			XidKey xidKey = new XidKey(xid);
			TransactionBranch<T> branch;
			synchronized (this) {
				branch = branches.get(xidKey);
			}
			if (branch==null) {
				// Branch for given XID not found.
				throw new XAException(XAException.XAER_NOTA);				
			}
			int ret = branch.prepare();
			if (ret == XA_RDONLY) {
				// Branch was read-only, nothing to do.
				synchronized (this) {
					branches.remove(xidKey);
				}
			}
			return ret;
		}
		
		@Override
		public void rollback(Xid xid) throws XAException {
			XidKey xidKey = new XidKey(xid);
			TransactionBranch<T> branch;
			synchronized (this) {
				branch = branches.get(xidKey);
			}
			if (branch==null) {
				// Branch for given XID not found.
				throw new XAException(XAException.XAER_NOTA);				
			}
			branch.rollback();
			synchronized (this) {
				branches.remove(xidKey);
			}
		}
		
		@Override
		public void commit(Xid xid, boolean onePhase) throws XAException {
			XidKey xidKey = new XidKey(xid);
			TransactionBranch<T> branch;
			synchronized (this) {
				branch = branches.get(xidKey);
			}
			if (branch==null) {
				// Branch for given XID not found.
				throw new XAException(XAException.XAER_NOTA);				
			}
			if (onePhase) {
				branch.prepare();
			}
			branch.commit();
			synchronized (this) {
				branches.remove(xidKey);
			}
		}
	};

	@Override
	public XAResource getXAResource() {
		return xaResource;
	}

	@Override
	public T getUserObject() {
		synchronized (xaResource) {
			if (transactionKeyStack.isEmpty()) {
				if (unmanagedUserObject==null) {
					unmanagedUserObject = createBranch(false).getUserObject(); 
				}
				return unmanagedUserObject;
			}
			XidKey currentTransactionKey = transactionKeyStack.peek();
			TransactionBranch<T> branch = branches.get(currentTransactionKey);
			if (branch==null) {
				throw new IllegalStateException("Transaction branch does not exist for XID "+currentTransactionKey.getXid());
			}
			return branch.getUserObject();
		}
	}	
	
	/**
	 * Creates data for a new branch.
	 * If views object (T) has closing methods, e.g. implements {@link Closeable}, object's closing methods shall delist xaResource from 
	 * its transaction. Ideally, the views object shall act identically within and without distributed transactions, from the calling code perspective, i.e. if 
	 * the views object provides commit() method, it shall not commit the transaction if the distributed transaction is present, and if the views object provides rollback() method,
	 * this method shall mark the branch as rollbackOnly using rollback listener.
	 * @param xaManaged True if the branch's transactional behavior will be managed through its XAResource, false if it will be managed through user object. 
	 * @return
	 */
	protected abstract BranchData<T> createBranch(boolean xaManaged);

	protected IProgressMonitor progressMonitor = new NullProgressMonitor();
	
	protected IProgressMonitor getProgressMonitor() {
		return progressMonitor;
	}
}
