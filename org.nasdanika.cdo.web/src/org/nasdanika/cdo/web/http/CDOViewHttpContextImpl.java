package org.nasdanika.cdo.web.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.web.CDOViewContext;
import org.nasdanika.web.Context;
import org.nasdanika.web.ExtensionManager;
import org.nasdanika.web.HttpContextImpl;

public class CDOViewHttpContextImpl extends HttpContextImpl implements CDOViewContext {

	protected CDOView view;

	public CDOViewHttpContextImpl(HttpContextImpl master, CDOView view) throws Exception {		
		this(
				master.getPrincipal(), 
				master.getPath(), 
				master.getTarget(), 
				master.getRequestData(), 
				master.getExtensionManager(), 
				master.getRequest(), 
				master.getResponse(), 
				view);
	}
	
	public CDOViewHttpContextImpl(
			Object principal, 
			String[] path,
			Object target, 
			Object requestData,
			ExtensionManager extensionManager, 
			HttpServletRequest req,
			HttpServletResponse resp, 
			CDOView view) throws Exception {
		super(principal, path, target, requestData, extensionManager, req, resp);
		this.view = view;
	}

	@Override
	public CDOView getView() {
		return view;
	}
	
	@Override
	protected Context createSubContext(String[] subPath, Object target) throws Exception {
		return new CDOViewHttpContextImpl(getPrincipal(), subPath, target, getRequestData(), getExtensionManager(), getRequest(), getResponse(), view);
	}

}
