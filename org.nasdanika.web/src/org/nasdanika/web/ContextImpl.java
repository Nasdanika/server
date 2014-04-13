package org.nasdanika.web;

import java.util.Arrays;

public abstract class ContextImpl implements WebContext {
	
	private ExtensionManager extensionManager;
	
	public ExtensionManager getExtensionManager() {
		return extensionManager;
	}
	
	private AuthorizationProvider securityManager;
	private Converter<Object, Object> converter;
	private String[] path;
	private Object target;
	private RouteRegistry routeRegistry;
	private Object principal;

	public ContextImpl(
			Object principal, 
			String[] path, 
			Object target, 
			ExtensionManager extensionManager) throws Exception {
		
		this.extensionManager = extensionManager;
		this.securityManager = extensionManager.getAuthorizationProvider();
		this.converter = extensionManager.getConverter();
		this.path = path;
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
		WebContext subContext = createSubContext(newPath, target);
		for (Route r: routeRegistry.matchObjectRoutes(getMethod(), target, newPath)) {
			Action ret = r.execute(subContext);
			if (ret!=null) {
				return ret;
			}
		}
		return null;
	}
	
	@Override
	public Action getExtensionAction(Object target, String extension) throws Exception {
		Route eRoute = routeRegistry.getExtensionRoute(getMethod(), target, extension);
		return eRoute == null ? null : eRoute.execute(this);
	}
	
	protected abstract WebContext createSubContext(String[] subPath, Object target) throws Exception;

	@Override
	public void close() throws Exception {
		// NOP		
	}	

	@Override
	public Object getTarget() {
		return target;
	}

}
