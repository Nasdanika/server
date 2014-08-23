package org.nasdanika.cdo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.web.ExportingContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.WebContext;

public class CDOTransactionHttpContextImpl<CR> extends HttpContextImpl implements CDOTransactionHttpContext<CR> {

	private static final String PRINCIPAL_KEY = Principal.class.getName();
	private CDOTransactionContext<CR> transactionContext;

	public CDOTransactionHttpContextImpl(
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			ClassLoadingContext classLoadingContext,
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextURL,
			ExportingContext exportingContext,
			CDOTransactionContext<CR> transactionContext) throws Exception {
		
		super(path, target, extensionManager, classLoadingContext, pathTrace, req, resp, contextURL, exportingContext);
		this.transactionContext = transactionContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		return new CDOTransactionHttpContextImpl<CR>(
				subPath, 
				target, 
				getExtensionManager(),
				this,
				getPathTrace(),
				getRequest(), 
				getResponse(), 
				subContextURL(subPath, true),
				this, 
				transactionContext);
	}

	@Override
	public void close() throws Exception {
		super.close();
		transactionContext.close();
	}

	@Override
	public CDOTransaction getView() {
		return transactionContext.getView();
	}

	@Override
	public void setRollbackOnly() {
		transactionContext.setRollbackOnly();		
	}

	@Override
	public ProtectionDomain<CR> getProtectionDomain() {
		return transactionContext.getProtectionDomain();
	}

	@Override
	public Principal authenticate(CR credentials) throws Exception {
		Principal authenticatedPrincipal = transactionContext.authenticate(credentials);
		if (authenticatedPrincipal==null) {
			return null;
		}
		getRequest().getSession().setAttribute(PRINCIPAL_KEY, authenticatedPrincipal);
		return authenticatedPrincipal;
	}
	
	@Override
	public Principal getPrincipal() {
		Principal oldPrincipal = (Principal) getRequest().getSession().getAttribute(PRINCIPAL_KEY);
		if (oldPrincipal!=null) {
			CDOObject principal = getView().getObject(oldPrincipal.cdoID());
			if (principal instanceof Principal) {
				return (Principal) principal;
			}
		}
		return transactionContext.getPrincipal();
	}

	@Override
	public boolean isRollbackOnly() {
		return transactionContext.isRollbackOnly();
	}
		
}
