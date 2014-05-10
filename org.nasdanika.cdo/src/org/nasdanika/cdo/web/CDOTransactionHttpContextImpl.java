package org.nasdanika.cdo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.WebContext;

public class CDOTransactionHttpContextImpl extends HttpContextImpl implements CDOTransactionHttpContext {

	private CDOTransactionContext transactionContext;

	public CDOTransactionHttpContextImpl(
			Object principal, 
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextURL,
			CDOTransactionContext transactionContext) throws Exception {
		
		super(principal, path, target, extensionManager, req, resp, contextURL);
		this.transactionContext = transactionContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		return new CDOTransactionHttpContextImpl(
				getPrincipal(), 
				subPath, 
				target, 
				getExtensionManager(), 
				getRequest(), 
				getResponse(), 
				subContextURL(subPath, true),
				transactionContext);
	}

	@Override
	public void close() throws Exception {
		super.close();
		transactionContext.close();
	}

	@Override
	public CDOTransaction getTransaction() {
		return transactionContext.getTransaction();
	}

	@Override
	public void setRollbackOnly() {
		transactionContext.setRollbackOnly();		
	}

}
