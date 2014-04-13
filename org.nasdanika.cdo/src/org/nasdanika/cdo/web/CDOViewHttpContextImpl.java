package org.nasdanika.cdo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.CDOViewContext;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;
import org.nasdanika.web.WebContext;

public class CDOViewHttpContextImpl extends HttpContextImpl implements CDOViewHttpContext {

	private CDOViewContext viewContext;

	public CDOViewHttpContextImpl(
			Object principal, 
			String[] path,
			Object target, 
			ExtensionManager extensionManager,
			HttpServletRequest req, 
			HttpServletResponse resp,
			CDOViewContext viewContext) throws Exception {
		
		super(principal, path, target, extensionManager, req, resp);
		this.viewContext = viewContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		return new CDOViewHttpContextImpl(getPrincipal(), subPath, target, getExtensionManager(), getRequest(), getResponse(), viewContext);
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
