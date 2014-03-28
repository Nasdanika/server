package org.nasdanika.web;

import java.util.Arrays;

public abstract class ContextImpl implements Context {
	
	protected ExtensionManager extensionManager;
	protected AuthorizationProvider securityManager;
	protected Converter<Object, Object> converter;
	protected String[] path;
	protected Object requestData;
	protected Object target;
	protected RouteRegistry routeRegistry;
	protected Object principal;

	public ContextImpl(
			Object principal, 
			String[] path, 
			Object target, 
			Object requestData, 
			ExtensionManager extensionManager) throws Exception {
		
		this.extensionManager = extensionManager;
		this.securityManager = extensionManager.getAuthorizationProvider();
		this.converter = extensionManager.getConverter();
		this.path = path;
		this.requestData = requestData;
		this.target = target;
		this.routeRegistry = extensionManager.getRouteRegistry();
		this.principal = principal;
	}
	
	@Override
	public Object getPrincipal() {
		return principal;
	}

	@Override
	public boolean authorize(Object target, String action) {		
		return securityManager.authorize(this, target, action);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object source, Class<T> targetType) throws Exception {
		return (T) converter.convert(source, (Class<Object>) targetType, this);
	}

	@Override
	public String[] getPath() {
		return path;
	}

	@Override
	public Action getAction(Object target, int pathOffset) throws Exception {
		String[] oldPath = getPath();
		if (oldPath.length<pathOffset) {
			throw new IllegalArgumentException("Offset is greater than path length");			
		}
		String[] newPath = Arrays.copyOfRange(oldPath, pathOffset, oldPath.length);
		Context subContext = createSubContext(newPath, target);
		for (Route r: routeRegistry.matchObjectRoutes(getMethod(), target, newPath)) {
			Action ret = r.navigate(subContext);
			if (ret!=null) {
				return ret;
			}
		}
		return null;
	}
	
	protected abstract Context createSubContext(String[] subPath, Object target) throws Exception;

	@Override
	public Object getRequestData() {
		return requestData;
	}

	@Override
	public Object getTarget() {
		return target;
	}

}
