package org.nasdanika.cdo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
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
			String contextURL,
			CDOViewContext viewContext) throws Exception {
		
		super(principal, path, target, extensionManager, req, resp, contextURL);
		this.viewContext = viewContext;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		return new CDOViewHttpContextImpl(
				getPrincipal(), 
				subPath, 
				target, 
				getExtensionManager(), 
				getRequest(), 
				getResponse(), 
				subContextURL(subPath, true),
				viewContext);
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
	public String getObjectURL(Object object) {
		for (CDOResourceNode e: viewContext.getView().getElements()) {
			String ret = getObjectURL(e, getContextURL(), object);
			if (ret!=null) {
				return ret;
			}
		}
		return super.getObjectURL(object);
	}

	private String getObjectURL(CDOResourceNode e, String contextURL, Object object) {
		if (e==object) {
			return contextURL+"/"+e.getName();
		}
		if (e instanceof CDOResourceFolder) {
			for (CDOResourceNode n: ((CDOResourceFolder) e).getNodes()) {
				String ret = getObjectURL(n, contextURL+"/"+e.getName(), object);
				if (ret!=null) {
					return ret;
				}
			}
			return null;
		}
		
		if (e instanceof CDOResource 
				&& object instanceof CDOObject 
				&& ((CDOObject) object).cdoResource()==e) {
			
			CDOResource res = ((CDOObject) object).cdoResource();
			return contextURL+"/"+res.getURIFragment((EObject) object);
		}
		
		return null;
	}

}
