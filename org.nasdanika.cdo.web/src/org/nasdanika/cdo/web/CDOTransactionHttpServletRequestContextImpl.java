package org.nasdanika.cdo.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.CDOViewContextSubject;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.web.ExportingContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.HttpServletRequestContextImpl;
import org.nasdanika.web.TraceEntry;

public class CDOTransactionHttpServletRequestContextImpl<CR> extends HttpServletRequestContextImpl implements CDOTransactionHttpServletRequestContext<CR> {

	private CDOTransactionContext<CR> transactionContext;

	public CDOTransactionHttpServletRequestContextImpl(
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			ClassLoadingContext classLoadingContext,
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextURL,
			ExportingContext exportingContext,
			Context[] chain, 
			CDOTransactionContext<CR> transactionContext) throws Exception {
		
		super(path, target, extensionManager, classLoadingContext, pathTrace, req, resp, contextURL, exportingContext, chain);
		this.transactionContext = transactionContext;
	}
	
	@Override
	protected HttpServletRequestContext createSubContext(String[] subPath, Object target, Context[] chain) throws Exception {
		CDOTransactionHttpServletRequestContextImpl<CR> subContext = new CDOTransactionHttpServletRequestContextImpl<CR>(
				subPath, 
				target, 
				getExtensionManager(),
				this,
				getPathTrace(),
				getRequest(), 
				getResponse(), 
				subContextURL(subPath, true),
				this, 
				fullChain(chain),
				transactionContext);
		subContext.getRootObjectsPaths().putAll(getRootObjectsPaths());
		return subContext;
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
	public Realm<CR> getProtectionDomain() {
		return transactionContext.getSecurityRealm();
	}

	@Override
	public Principal authenticate(CR credentials) throws Exception {
		return transactionContext.authenticate(credentials);
	}
	
	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return transactionContext.authorize(target, action, qualifier, environment);
	}
	
	@Override
	public Principal getPrincipal() throws Exception {
		return transactionContext.getPrincipal();
	}

	@Override
	public boolean isRollbackOnly() {
		return transactionContext.isRollbackOnly();
	}
	
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		T ret = transactionContext.adapt(targetType);
		return ret==null ? super.adapt(targetType) : ret;
	}

	@Override
	public CDOViewContextSubject<CDOTransaction, CR> getSubject() throws Exception {
		return transactionContext.getSubject();
	}
		
}
