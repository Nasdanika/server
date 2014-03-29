package org.nasdanika.transaction;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import com.atomikos.icatch.jta.UserTransactionManager;

public class TransactionManagerComponent implements TransactionManager, UserTransaction {
	
	private UserTransactionManager tm;

	public void activate() {
		tm = new UserTransactionManager();		
	}
	
	public void deactivate() {
		if (tm!=null) {
			tm.close();
			tm = null;
		}
	}

	@Override
	public void begin() throws NotSupportedException, SystemException {
		tm.begin();
	}

	@Override
	public void commit() throws RollbackException, HeuristicMixedException,
			HeuristicRollbackException, SecurityException,
			IllegalStateException, SystemException {
		tm.commit();		
	}

	@Override
	public int getStatus() throws SystemException {
		return tm.getStatus();
	}

	@Override
	public Transaction getTransaction() throws SystemException {
		return tm.getTransaction();
	}

	@Override
	public void resume(Transaction tx) throws InvalidTransactionException, IllegalStateException, SystemException {
		tm.resume(tx);
	}

	@Override
	public void rollback() throws IllegalStateException, SecurityException,
			SystemException {
		tm.rollback();
	}

	@Override
	public void setRollbackOnly() throws IllegalStateException, SystemException {
		tm.setRollbackOnly();
	}

	@Override
	public void setTransactionTimeout(int secs) throws SystemException {
		tm.setTransactionTimeout(secs);
	}

	@Override
	public Transaction suspend() throws SystemException {
		return tm.suspend();
	}

}
