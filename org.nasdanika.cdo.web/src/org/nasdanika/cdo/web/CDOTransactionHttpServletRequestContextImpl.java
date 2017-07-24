package org.nasdanika.cdo.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
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
	public Realm<CR> getSecurityRealm() {
		return transactionContext.getSecurityRealm();
	}

	@Override
	public List<Principal> authenticate(CR credentials) throws Exception {
		return transactionContext.authenticate(credentials);
	}
	
	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		// Caching - TODO make configurable
		if ((environment == null || environment.isEmpty()) && target instanceof CDOObject) {
			CDOID cdoId = ((CDOObject) target).cdoID();
			if (!cdoId.isTemporary()) {
				List<CDOID> principalIDs = new ArrayList<>();
				for (Principal principal: getPrincipals()) {
					CDOID pid = principal.cdoID();
					if (pid.isTemporary()) {
						return transactionContext.authorize(target, action, qualifier, environment);						
					}
					principalIDs.add(pid);
				}
				
				HttpSession session = getRequest().getSession();
				String cacheKey = "org.nasdanika.core.Context.authorize:cache";
				@SuppressWarnings("unchecked")
				Map<CDOObjectAuthorizationKey, CDOObjectAuthorizationValue> authorizationCache = (Map<CDOObjectAuthorizationKey, CDOObjectAuthorizationValue>) session.getAttribute(cacheKey);
				if (authorizationCache == null) {
					authorizationCache = new ConcurrentHashMap<>();
					session.setAttribute(cacheKey, authorizationCache);
				}						
				CDOObjectAuthorizationKey key = new CDOObjectAuthorizationKey(principalIDs, cdoId, action, qualifier);
				CDOObjectAuthorizationValue av = authorizationCache.get(key);
				if (av == null || av.isExpired()) {
					av = new CDOObjectAuthorizationValue(transactionContext.authorize(target, action, qualifier, environment), System.currentTimeMillis() + 5 * 60 * 1000); // 5 minutes, make configurable if needed
					authorizationCache.put(key, av);
				}
				return av.isAuthorized();				
			}
		}
		
		return transactionContext.authorize(target, action, qualifier, environment);
	}
	
	@Override
	public List<Principal> getPrincipals() throws Exception {
		return transactionContext.getPrincipals();
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
