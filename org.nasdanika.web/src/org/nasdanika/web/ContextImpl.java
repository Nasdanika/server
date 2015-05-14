package org.nasdanika.web;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.AdapterManager;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.html.HTMLRenderer;
import org.nasdanika.web.html.UIPart;

public abstract class ContextImpl implements HttpServletRequestContext {
	
	private ExtensionManager extensionManager;
	private Map<Object, String> rootObjectsPaths = new ConcurrentHashMap<>();
	
	public ExtensionManager getExtensionManager() {
		return extensionManager;
	}
	
	public Map<Object, String> getRootObjectsPaths() {
		return rootObjectsPaths;
	}
	
	private AuthorizationProvider securityManager;
	private Converter<Object, Object, HttpServletRequestContext> converter;
	private String[] path;
	private Object target;
	private RouteRegistry routeRegistry;
	private CompositeObjectPathResolver objectPathResolver;
	private ClassLoadingContext classLoadingContext;

	public ContextImpl(
			String[] path, 
			Object target, 
			final ExtensionManager extensionManager,
			ClassLoadingContext classLoadingContext,
			List<TraceEntry> pathTrace) throws Exception {
		
		this.extensionManager = extensionManager;
		this.securityManager = extensionManager.getAuthorizationProvider();
		this.converter = extensionManager.getConverter();
		this.path = path;
		this.target = target;
		this.classLoadingContext = classLoadingContext;
		this.routeRegistry = extensionManager.getRouteRegistry();

		objectPathResolver = extensionManager.getObjectPathResolver();
		
		if (pathTrace!=null) {
			this.pathTrace.addAll(pathTrace);
		}
	}

	@Override
	public boolean authorize(Object target, String action, String qualifier, Map<String, Object> environment) throws Exception {		
		return AccessDecision.ALLOW.equals(securityManager.authorize(this, target, action, qualifier, environment));
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
		HttpServletRequestContext subContext = createSubContext(newPath, target);
		for (Route r: routeRegistry.matchObjectRoutes(getMethod(), target, newPath)) {
			final Object ret = r.execute(subContext);
			if (ret==null || ret==Action.NOT_FOUND) {
				continue;
			}
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
	
	protected abstract HttpServletRequestContext createSubContext(String[] subPath, Object target) throws Exception;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public void buildUICategory(
			String category, 
			Object out,
			Map<String, Object> environment) throws Exception {
		for (@SuppressWarnings("rawtypes") UIPart uiPart: extensionManager.getUIParts(target, category)) {
			uiPart.create(this, out, environment);
		}
	}
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return classLoadingContext.loadClass(name);
	}
	
	@Override
	public URL getResource(String name) {
		return classLoadingContext.getResource(name);
	}
	
	@Override
	public Iterable<URL> getResources(String name) throws IOException {
		return classLoadingContext.getResources(name);
	}
	
//	TODO - Explicitly add adapters, adapter map from parent.
	
	
	private AdapterManager adapterManager;

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		if (targetType.isInstance(this)) {
			return (T) this;
		}
				
		if (targetType.isAssignableFrom(HTMLFactory.class)) {
			return (T) extensionManager.getHTMLFactory();
		}
		
		synchronized (this) {
			if (adapterManager==null) {
				adapterManager = new AdapterManager(this, null, null);
			}
		}
		
		T ret = adapterManager.adapt(targetType);
		return ret==null ? extensionManager.adapt(targetType) : ret;

	}
	
}
