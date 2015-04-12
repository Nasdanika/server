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
public abstract class CDOTransactionContextFilter<CR, MC> extends CDOViewContextFilter<CDOTransaction, CR, MC, CDOTransactionContext<CR>> implements CDOTransactionContext<CR> {
	
	public CDOTransactionContextFilter(CDOTransactionContext<CR> target) {
		super(target);
	}

	@Override
	public void setRollbackOnly() {
		target.setRollbackOnly();		
	}

	@Override
	public boolean isRollbackOnly() {
		return target.isRollbackOnly();
	}

}
