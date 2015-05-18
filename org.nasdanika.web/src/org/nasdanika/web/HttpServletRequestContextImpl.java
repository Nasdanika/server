package org.nasdanika.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.core.ClassLoadingContext;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.core.NasdanikaException;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.html.HTMLRenderer;
import org.nasdanika.web.html.UIPart;
import org.osgi.framework.FrameworkUtil;

public class HttpServletRequestContextImpl extends ContextImpl implements HttpServletRequestContext {
	
	
	private ExtensionManager extensionManager;
	private Map<Object, String> rootObjectsPaths = new ConcurrentHashMap<>();
	
	public ExtensionManager getExtensionManager() {
		return extensionManager;
	}
	
	public Map<Object, String> getRootObjectsPaths() {
		return rootObjectsPaths;
	}
	
	//private AuthorizationProvider securityManager;
	private String[] path;
	private Object target;
	private RouteRegistry routeRegistry;
	private CompositeObjectPathResolver objectPathResolver;
	private ClassLoadingContext classLoadingContext;

	@Override
	public String[] getPath() {
		return path;
	}

	@Override
	public Action getAction(Object target, int pathOffset, Context... chain) throws Exception {
		String[] oldPath = getPath();
		if (oldPath.length<pathOffset) {
			throw new IllegalArgumentException("Offset is greater than path length");			
		}
		String[] newPath = Arrays.copyOfRange(oldPath, pathOffset, oldPath.length);
		HttpServletRequestContext subContext = createSubContext(newPath, target, chain);
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
	

	@SuppressWarnings("unchecked")
	@Override
	public <T> T adapt(Class<T> targetType) throws Exception {
		HTMLFactory htmlFactory = extensionManager.getHTMLFactory();
		if (targetType.isInstance(htmlFactory)) {
			return (T) htmlFactory;
		}
		
		if (targetType.isInstance(getRequest())) {
			return (T) getRequest();
		}
		
		if (targetType.isInstance(getResponse())) {
			return (T) getResponse();
		}
		
		
		T ret = super.adapt(targetType);
		if (ret!=null) {
			return ret;
		}
				
		return ret==null ? extensionManager.adapt(targetType) : ret;

	}
	
	
	private static final String SESSION_TRACE_ATTRIBUTE_NAME = HttpServletRequestContext.class+":session-trace";
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String contextURL;
	private ExportingContext exportingContext;

	public HttpServletRequestContextImpl(
			String[] path, 
			Object target, 
			ExtensionManager extensionManager, 
			ClassLoadingContext classLoadingContext,
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextUrl,
			ExportingContext exportingContext,
			Context[] chain) throws Exception {	
		
		super(FrameworkUtil.getBundle(HttpServletRequestContext.class).getBundleContext(), chain);
		
		this.extensionManager = extensionManager;
		setDefaultAccessDecision(extensionManager.getDefaultAccessDecision());
		this.path = path;
		this.target = target;
		this.classLoadingContext = classLoadingContext;
		this.routeRegistry = extensionManager.getRouteRegistry();

		objectPathResolver = extensionManager.getObjectPathResolver();
		
		if (pathTrace!=null) {
			this.pathTrace.addAll(pathTrace);
		}
		this.req = req;
		this.resp = resp;
		this.contextURL = contextUrl;
		this.exportingContext = exportingContext;
	}
	
	protected HttpServletRequestContext createSubContext(String[] subPath, Object target, Context[] chain) throws Exception {
		HttpServletRequestContextImpl subContext = new HttpServletRequestContextImpl(
				subPath, 
				target, 
				getExtensionManager(), 
				this,
				getPathTrace(),
				getRequest(), 
				getResponse(),
				subContextURL(subPath, false),
				this, 
				chain);
		subContext.getRootObjectsPaths().putAll(getRootObjectsPaths());
		return subContext;
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

	@Override
	public Store getSessionStore() {
		Store ret = (Store) req.getSession().getAttribute(Store.class.getName());
		if (ret==null) {
			ret = new Store() {
				
				private Map<String, Object> storage = new HashMap<>();
				private long counter = Integer.MAX_VALUE+1;

				@Override
				public synchronized Object get(String key) {
					return storage.get(key);
				}

				@Override
				public synchronized Object remove(String key) {
					return storage.remove(key);
				}

				@Override
				public synchronized String put(Object obj) {
					String candidateKey;
					try {
						candidateKey = URLEncoder.encode(Integer.toString(obj.hashCode(), Character.MAX_RADIX), getCharacterEncoding());
					} catch (UnsupportedEncodingException e) {
						throw new NasdanikaException(e);
					}
					Object atKey = storage.get(candidateKey);
					if (atKey==null) {
						storage.put(candidateKey, obj);
						return candidateKey;
					}
					if (atKey.equals(obj)) {
						return candidateKey;
					}
					for (Entry<String, Object> e: storage.entrySet()) {
						if (obj.equals(e.getValue())) {
							return e.getKey();
						}
					}
					do {
						try {
							candidateKey = URLEncoder.encode(Long.toString(++counter, Character.MAX_RADIX), getCharacterEncoding());
						} catch (UnsupportedEncodingException e) {
							throw new NasdanikaException(e);
						}
					} while (storage.containsKey(candidateKey));
					storage.put(candidateKey, obj);
					return candidateKey;
				}
				
			};
			req.getSession().setAttribute(Store.class.getName(), ret);
		}
		return ret;
	}
	
	@Override
	public void addSessionTraceEntry(final String path, final String displayName) {
		@SuppressWarnings("unchecked")
		Queue<TraceEntry> sessionTrace = (Queue<TraceEntry>) req.getSession().getAttribute(SESSION_TRACE_ATTRIBUTE_NAME);
		if (sessionTrace == null) {
			sessionTrace = new ConcurrentLinkedQueue<TraceEntry>();
			req.getSession().setAttribute(SESSION_TRACE_ATTRIBUTE_NAME, sessionTrace);
		}
		sessionTrace.add(new TraceEntry() {
			
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
		
	@Override
	public Collection<TraceEntry> getSessionTrace() {
		@SuppressWarnings("unchecked")
		Queue<TraceEntry> sessionTrace = (Queue<TraceEntry>) req.getSession().getAttribute(SESSION_TRACE_ATTRIBUTE_NAME);
		return sessionTrace == null ? Collections.<TraceEntry>emptyList() : sessionTrace;
	}
	
	@Override
	public String getCharacterEncoding() {
		String ret = req.getCharacterEncoding();
		return ret==null ? "UTF-8" : ret;
	}	
	
	private class Exports {
		AtomicLong counter = new AtomicLong();
		Map<String, Object> exportedObjects = new ConcurrentHashMap<>();
		Map<String, Map<RequestMethod,Route>> exportedRoutes = new ConcurrentHashMap<>();
		String nextId() {
			return Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
		}
	}
	
	private static final String EXPORTS_ATTRIBUTE = ExportingContext.class.getName();
	
	private static final Object sessionMonitor = new Object();

	@Override
	public String exportObject(Object obj) {
		if (exportingContext==null) {
			HttpSession session = req.getSession();
			synchronized (sessionMonitor) {
				Exports exports = (Exports) session.getAttribute(EXPORTS_ATTRIBUTE);
				if (exports==null) {
					exports = new Exports();
					session.setAttribute(EXPORTS_ATTRIBUTE, exports);
				}
				String path = getContextURL()+"/exports/"+exports.nextId();
				exports.exportedObjects.put(path, obj);			
				return path;
			}
		}
		return exportingContext.exportObject(obj);
	}

	@Override
	public String exportRoute(Route route, RequestMethod... method) {
		if (exportingContext==null) {
			HttpSession session = req.getSession();
			synchronized (sessionMonitor) {
				Exports exports = (Exports) session.getAttribute(EXPORTS_ATTRIBUTE);
				if (exports==null) {
					exports = new Exports();
					session.setAttribute(EXPORTS_ATTRIBUTE, exports);
				}
				Map<RequestMethod, Route> methodMap = new HashMap<>();
				for (RequestMethod m: method) {
					methodMap.put(m, route);
				}
				String path = getContextURL()+"/exports/"+exports.nextId();
				exports.exportedRoutes.put(path, methodMap);			
				return path;
			}
		}
		return exportingContext.exportRoute(route, method);
	}

	@Override
	public Object unexport(String path) {
		if (exportingContext==null) {
			HttpSession session = req.getSession();
			Exports exports = (Exports) session.getAttribute(EXPORTS_ATTRIBUTE);
			if (exports==null) {
				return null;
			}
			Object ret = exports.exportedObjects.remove(path);
			if (ret!=null) {
				return ret;
			}
			return exports.exportedRoutes.remove(path);
		}
		return exportingContext.unexport(path);
	}

	@Override
	public Principal getSecurityPrincipal() {
		return getRequest().getUserPrincipal();
	}

}
