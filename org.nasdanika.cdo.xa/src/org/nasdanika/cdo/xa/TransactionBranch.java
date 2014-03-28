package org.nasdanika.cdo.xa;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.view.CDOViewSet;
import org.eclipse.emf.common.notify.Notifier;

/**
 * Transaction branch uses CDOXATransaction.
 * @author Pavel Vlasov
 * @param <T> Type of the user object providing access to CDO views 
 * participating in a distributed transaction
 */
class TransactionBranch<T> {
	/**
	 * State transitions:
	 * ACTIVE, SUSPENDED -&gt; SUCCESS
	 * ACTIVE, SUSPENDED -&gt; ROLLED_BACK
	 * ACTIVE -&gt; SUSPENDED
	 * SUSPENDED -&gt; ACTIVE
	 * SUCCESS -&gt; PREPARED
	 * SUCCESS -&gt; ROLLED_BACK
	 * PREPARED -&gt; COMMITTED
	 * PREPARED -&gt; ROLLED_BACK
	 * @author Pavel Vlasov
	 *
	 */
	enum State {
		ACTIVE,
		SUSPENDED,
		SUCCESS,
		PREPARED,
		COMMITTED,
		ROLLED_BACK
	}
	
	private State state = State.ACTIVE;
	
	public State getState() {
		return state;
	}

	protected T userObject;
	private CDOXATransactionImpl cdoXATransaction;
	private IProgressMonitor progressMonitor;
	
	TransactionBranch(T userObject, IProgressMonitor progressMonitor, Iterable<Notifier> notifiers) {
		cdoXATransaction = new CDOXATransactionImpl();
		for (Notifier notifier : notifiers) {
			CDOViewSet viewSet = CDOUtil.getViewSet(notifier);
			if (viewSet == null) {
				throw new IllegalArgumentException("Notifier is not associated with a CDOViewSet: "	+ notifier);
			}

			cdoXATransaction.add(viewSet);
		}
		this.progressMonitor = progressMonitor;
		this.userObject = userObject;
	}

	public void forget() throws XAException {
		// Forget is not clearly explained in the spec, assuming rollback.
		rollback();
	}

	public void rollback() throws XAException {
		switch (state) {
		case PREPARED:
			// roll back from prepared state.
			try {
				cdoXATransaction.commitException(progressMonitor, 0, new Exception("Fake"));
			} catch (CommitException e) {
				// NOP
			}
			cdoXATransaction.commitFinally(progressMonitor);
			state = State.ROLLED_BACK;
			break;
		case COMMITTED:
		case ROLLED_BACK:
			// NOP
			break;
		case ACTIVE:
		case SUCCESS:
		case SUSPENDED:
			// "regular" rollback.
			cdoXATransaction.rollback();
			break;
		default:
			throw new IllegalStateException("Unhandled state: " + state);
			
		}
	}

	public int prepare() throws XAException {
		if (state != State.SUCCESS) {
			throw new XAException(XAException.XAER_PROTO); // Can prepare only from success state.
		}
		
		if (!cdoXATransaction.isDirty()) {
			// getViews() was not called or none of transactions is dirty.
			return XAResource.XA_RDONLY;
		}

		cdoXATransaction.commitPrepare(progressMonitor);

		// First two phases
		int phase = 0;
		try {
			while (phase < 2) {
				cdoXATransaction.commitPhase(progressMonitor);
				++phase;
			}
			state = State.PREPARED;
			return XAResource.XA_OK;
		} catch (Exception ex) {
			try {
				cdoXATransaction.commitException(progressMonitor, phase, ex);
			} catch (CommitException e) {
				logException("Exception in prepare()", e);
			}
			cdoXATransaction.commitFinally(progressMonitor);
			state = State.ROLLED_BACK;
			throw new XAException(XAException.XAER_RMERR);
		}
	}
	
	private static final Logger LOGGER = Logger.getLogger(TransactionBranch.class.getName());

	protected void logException(String msg, Exception e) {
		LOGGER.log(Level.SEVERE, msg, e);		
	}

	public void commit() throws XAException {
		if (state == State.PREPARED) {
			// Can commit only from prepared state.
			try {
				// Last phase.
				cdoXATransaction.commitPhase(progressMonitor);
				state = State.COMMITTED;
			} catch (Exception ex) {
				// At this point we can't do anything, there is no reason
				// to invoke commitException();
				logException("Exception in commit()", ex);
				state = State.ROLLED_BACK;
				throw new XAException(XAException.XAER_PROTO);
			} finally {
				cdoXATransaction.commitFinally(progressMonitor);
			}
		} else {
			throw new XAException(XAException.XAER_PROTO);
		}
	}

	/**
	 * @return User object, providing access to CDO views and transactions associated with this 
	 * branch of a distributed transaction.
	 */
	public T getUserObject() {
		return userObject;
	}

	public void resume() throws XAException {
		if (state == State.SUSPENDED) {
			state = State.ACTIVE;
		} else {
			throw new XAException(XAException.XAER_PROTO); // Can resume only from SUSPENDED.
		}		
	}

	public void join() throws XAException {
		state = State.ACTIVE; // Lenient, may change to checking if state is SUCCESS
	}

	public void suspend() throws XAException {
		if (state == State.ACTIVE) {
			state = State.SUSPENDED;
		} else {
			throw new XAException(XAException.XAER_PROTO); // Can suspend only from active state.
		}
	}
	
	public void success() throws XAException {
		if (state == State.ACTIVE) {
			state = State.SUCCESS;
		} else {
			throw new XAException(XAException.XAER_PROTO); // Can end only from active state.
		}
	}
	
	public void fail() throws XAException {
		if (state == State.ACTIVE) {
			cdoXATransaction.rollback();
			state = State.ROLLED_BACK;
		} else {
			throw new XAException(XAException.XAER_PROTO); // Can end only from active state.
		}
	}
	
}
