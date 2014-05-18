package org.nasdanika.cdo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.TraceEntry;
import org.nasdanika.web.WebContext;

public class CDOViewHttpContextImpl extends HttpContextImpl implements CDOViewHttpContext {

	private CDOViewContext viewContext;

	public CDOViewHttpContextImpl(
			Object principal, 
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextURL,
			CDOViewContext viewContext) throws Exception {
		
		super(principal, path, target, extensionManager, pathTrace, req, resp, contextURL);
		this.viewContext = viewContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		CDOViewHttpContextImpl subContext = new CDOViewHttpContextImpl(
				getPrincipal(), 
				subPath, 
				target, 
				getExtensionManager(), 
				getPathTrace(),
				getRequest(), 
				getResponse(), 
				subContextURL(subPath, true),
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

}
