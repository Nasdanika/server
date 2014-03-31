package org.nasdanika.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpContextImpl extends ContextImpl implements HttpContext {
	
	private HttpServletRequest req;
	private HttpServletResponse resp;

	public HttpContextImpl(
			Object principal, 
			String[] path, 
			Object target, 
			Object requestData, 
			ExtensionManager extensionManager, 
			HttpServletRequest req, 
			HttpServletResponse resp) throws Exception {
		
		super(principal, path, target, requestData, extensionManager);
		this.req = req;
		this.resp = resp;
	}
	
	@Override
	protected Context createSubContext(String[] subPath, Object target) throws Exception {
		return new HttpContextImpl(getPrincipal(), subPath, target, getRequestData(), getExtensionManager(), getRequest(), getResponse());
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

}
