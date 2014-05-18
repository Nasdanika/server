package org.nasdanika.cdo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.WebContext;

public class CDOTransactionHttpContextImpl extends HttpContextImpl implements CDOTransactionHttpContext {

	private CDOTransactionContext transactionContext;

	public CDOTransactionHttpContextImpl(
			Object principal, 
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextURL,
			CDOTransactionContext transactionContext) throws Exception {
		
		super(principal, path, target, extensionManager, pathTrace, req, resp, contextURL);
		this.transactionContext = transactionContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		return new CDOTransactionHttpContextImpl(
				getPrincipal(), 
				subPath, 
				target, 
				getExtensionManager(), 
				getPathTrace(),
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
