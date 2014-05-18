package org.nasdanika.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.html.HTMLRenderer;

public abstract class ContextImpl implements WebContext {
	
	private ExtensionManager extensionManager;
	private Map<Object, String> rootObjectsPaths = new ConcurrentHashMap<>();
	
	public ExtensionManager getExtensionManager() {
		return extensionManager;
	}
	
	public Map<Object, String> getRootObjectsPaths() {
		return rootObjectsPaths;
	}
	
	private AuthorizationProvider securityManager;
	private Converter<Object, Object, WebContext> converter;
	private String[] path;
	private Object target;
	private RouteRegistry routeRegistry;
	private Object principal;
	private CompositeObjectPathResolver objectPathResolver;

	public ContextImpl(
			Object principal, 
			String[] path, 
			Object target, 
			final ExtensionManager extensionManager,
			List<TraceEntry> pathTrace) throws Exception {
		
		this.extensionManager = extensionManager;
		this.securityManager = extensionManager.getAuthorizationProvider();
		this.converter = extensionManager.getConverter();
		this.path = path;
		this.target = target;
		this.routeRegistry = extensionManager.getRouteRegistry();
		this.principal = principal;
		
		objectPathResolver = extensionManager.getObjectPathResolver();
		
		if (pathTrace!=null) {
			this.pathTrace.addAll(pathTrace);
		}
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
			final Object ret = r.execute(subContext);
			if (ret instanceof Action) {
				return (Action) ret;
			}
			
			return new Action() {
				
				@Override
				public void close() throws Exception {
					// NOP					
				}
				
				@Override
				public Object execute() throws Exception {
					return ret;
				}
			};
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
	
	@Override
	public String toHTML(Object obj, String profile, Map<String, Object> environment) throws Exception {
		HTMLRenderer renderer = convert(obj, HTMLRenderer.class);
		if (renderer == null) {
			return "<pre>"+StringEscapeUtils.escapeHtml4(String.valueOf(obj))+"</pre>";
		}
		return renderer.render(this, profile, environment);
	}

	@Override
	public HTMLFactory getHTMLFactory() {
		return extensionManager.getHTMLFactory();
	}
	
	@Override
	public String getObjectPath(Object object) throws Exception {
		return objectPathResolver.resolve(object, null, this);
	}
	
	@Override
	public void addPathTraceEntry(final String path, final String displayName) {
		pathTrace.add(new TraceEntry() {
			
			@Override
			public String getPath() {
				return path;
			}
			
			@Override
			public String getDisplayName() {
				return displayName;
			}
		});		
	}
	
	private List<TraceEntry> pathTrace = new ArrayList<>();
	
	@Override
	public List<TraceEntry> getPathTrace() {
		return pathTrace;
	}
}
