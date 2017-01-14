package org.nasdanika.cdo.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
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

public class CDOViewHttpServletRequestContextImpl<CR> extends HttpServletRequestContextImpl implements CDOViewHttpServletRequestContext<CR> {

	private CDOViewContext<CDOView, CR> viewContext;

	public CDOViewHttpServletRequestContextImpl(
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
			CDOViewContext<CDOView, CR> viewContext) throws Exception {
		
		super(path, target, extensionManager, classLoadingContext, pathTrace, req, resp, contextURL, exportingContext, chain);
		this.viewContext = viewContext;
	}
	
	@Override
	protected HttpServletRequestContext createSubContext(String[] subPath, Object target, Context[] chain) throws Exception {
		CDOViewHttpServletRequestContextImpl<CR> subContext = new CDOViewHttpServletRequestContextImpl<CR>(
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
				viewContext);
		subContext.getRootObjectsPaths().putAll(getRootObjectsPaths());
		return subContext;
	}
	
	@Override
	public CDOView getView() {
		return viewContext.getView();
	}

	@Override
	public void close() throws Exception {
		viewContext.close();
		// TODO - tracking and closing of sub-contexts.
	}

	@Override
	public Realm<CR> getSecurityRealm() {
		return viewContext.getSecurityRealm();
	}

	@Override
	public Principal authenticate(CR credentials) throws Exception {
		return viewContext.authenticate(credentials);
	}
	
	@Override
	public Principal getPrincipal() throws Exception {
		return viewContext.getPrincipal();
	}
	
	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {
		return viewContext.authorize(target, action, qualifier, environment);
	}
		
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		T ret = viewContext.adapt(targetType);
		return ret==null ? super.adapt(targetType) : ret;
	}

	@Override
	public CDOViewContextSubject<CDOView, CR> getSubject() throws Exception {
		return viewContext.getSubject();
	}

}
