package org.nasdanika.cdo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.ProtectionDomain;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.web.ExportingContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.WebContext;

public class CDOViewHttpContextImpl<CR> extends HttpContextImpl implements CDOViewHttpContext<CR> {

	private static final String PRINCIPAL_ID_KEY = Principal.class.getName()+":CDOID";
	private CDOViewContext<CDOView, CR> viewContext;

	public CDOViewHttpContextImpl(
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			ClassLoadingContext classLoadingContext,
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextURL,
			ExportingContext exportingContext,
			CDOViewContext<CDOView, CR> viewContext) throws Exception {
		
		super(path, target, extensionManager, classLoadingContext, pathTrace, req, resp, contextURL, exportingContext);
		this.viewContext = viewContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		CDOViewHttpContextImpl<CR> subContext = new CDOViewHttpContextImpl<CR>(
				subPath, 
				target, 
				getExtensionManager(), 
				this,
				getPathTrace(),
				getRequest(), 
				getResponse(), 
				subContextURL(subPath, true),
				this,
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
	public ProtectionDomain<CR> getProtectionDomain() {
		return viewContext.getProtectionDomain();
	}

	@Override
	public boolean authenticate(CR credentials) throws Exception {
		if (viewContext.authenticate(credentials)) {
			getRequest().getSession().setAttribute(PRINCIPAL_ID_KEY, viewContext.getPrincipal().cdoID());
			return true;
		}
		return false;
	}
	
	@Override
	public Principal getPrincipal() {
		Object principalID = getRequest().getSession().getAttribute(PRINCIPAL_ID_KEY);
		if (principalID instanceof CDOID) {
			CDOObject principal = getView().getObject((CDOID) principalID);
			if (principal instanceof Principal) {
				return (Principal) principal;
			}
		}
		return viewContext.getPrincipal();
	}

}
