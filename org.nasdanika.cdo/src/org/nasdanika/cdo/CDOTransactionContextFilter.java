package org.nasdanika.cdo;

import org.eclipse.emf.cdo.transaction.CDOTransaction;

/**
 * Filter which allows to replace master context and default access decision.
 * @author Pavel
 *
 * @param <V>
 * @param <CR>
 * @param <MC>
 */
public class CDOTransactionContextFilter<CR> extends CDOViewContextFilter<CDOTransaction, CR> implements CDOTransactionContext<CR> {
	
	public void setRollbackOnly() {
		((CDOTransactionContext<CR>) target).setRollbackOnly();
	}

	public boolean isRollbackOnly() {
		return ((CDOTransactionContext<CR>) target).isRollbackOnly();
	}

	public CDOTransactionContextFilter(CDOTransactionContext<CR> target) {
		super(target);
	}

}
