package org.nasdanika.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpContextImpl extends ContextImpl implements HttpContext {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String contextURL;

	public HttpContextImpl(
			Object principal, 
			String[] path, 
			Object target, 
			ExtensionManager extensionManager, 
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextUrl) throws Exception {
		
		super(principal, path, target, extensionManager);
		this.req = req;
		this.resp = resp;
		this.contextURL = contextUrl;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		return new HttpContextImpl(
				getPrincipal(), 
				subPath, 
				target, 
				getExtensionManager(), 
				getRequest(), 
				getResponse(),
				subContextURL(subPath, false));
	}
	
	protected String subContextURL(String[] subPath, boolean trimExtensions) {
		StringBuilder urlBuilder = new StringBuilder(getContextURL());
		for (String pe: subPath) {
			// Trim extensions
			if (trimExtensions) {
				int lastDot = pe.lastIndexOf('.');
				if (lastDot>0) {
					pe = pe.substring(0, lastDot);
				}
			}
			urlBuilder.append("/").append(pe);
		}
		return urlBuilder.toString();
	}

	@Override
	public HttpServletRequest getRequest() {
		return req;
	}

	@Override
	public HttpServletResponse getResponse() {
		return resp;
	}

	@Override
	public RequestMethod getMethod() {
		return RequestMethod.valueOf(req.getMethod());
	}
	
	@Override
	public String getContextURL() {
		return contextURL;
	}

}
