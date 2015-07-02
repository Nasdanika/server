package org.nasdanika.cdo;

import java.util.Map;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;

/**
 * Filter which allows to replace master context and default access decision.
 * @author Pavel
 *
 * @param <V>
 * @param <CR>
 * @param <MC>
 */
public class CDOTransactionContextFilter<CR> implements CDOTransactionContext<CR> {
	
	private CDOTransactionContext<CR> target;

	public <T> T adapt(Class<T> targetType) throws Exception {
		return target.adapt(targetType);
	}

	public void setRollbackOnly() {
		target.setRollbackOnly();
	}

	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return this.target.authorize(target, action, qualifier, environment);
	}

	public boolean isRollbackOnly() {
		return target.isRollbackOnly();
	}

	public CDOTransaction getView() {
		return target.getView();
	}

	public Principal getPrincipal() throws Exception {
		return target.getPrincipal();
	}

	public void close() throws Exception {
		target.close();
	}

	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		return target.convert(source, targetType);
	}

	public ProtectionDomain<CR> getProtectionDomain() {
		return target.getProtectionDomain();
	}

	public Principal authenticate(CR credentials) throws Exception {
		return target.authenticate(credentials);
	}

	public CDOTransactionContextFilter(CDOTransactionContext<CR> target) {
		this.target = target;
	}

}
