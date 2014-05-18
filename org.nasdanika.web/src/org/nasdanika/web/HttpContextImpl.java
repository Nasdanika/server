package org.nasdanika.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nasdanika.core.NasdanikaException;

public class HttpContextImpl extends ContextImpl implements HttpContext {
	
	private static final String SESSION_TRACE_ATTRIBUTE_NAME = HttpContext.class+":session-trace";
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private String contextURL;

	public HttpContextImpl(
			Object principal, 
			String[] path, 
			Object target, 
			ExtensionManager extensionManager, 
			List<TraceEntry> pathTrace,
			HttpServletRequest req, 
			HttpServletResponse resp,
			String contextUrl) throws Exception {
		
		super(principal, path, target, extensionManager, pathTrace);
		this.req = req;
		this.resp = resp;
		this.contextURL = contextUrl;
	}
	
	@Override
	protected WebContext createSubContext(String[] subPath, Object target) throws Exception {
		HttpContextImpl subContext = new HttpContextImpl(
				getPrincipal(), 
				subPath, 
				target, 
				getExtensionManager(), 
				getPathTrace(),
				getRequest(), 
				getResponse(),
				subContextURL(subPath, false));
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

}
