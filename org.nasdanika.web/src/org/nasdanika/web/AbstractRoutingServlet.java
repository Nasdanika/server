package org.nasdanika.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.Context;
import org.nasdanika.core.ContextImpl;
import org.nasdanika.core.ContextProvider;
import org.nasdanika.core.CoreUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

@SuppressWarnings("serial")
public abstract class AbstractRoutingServlet extends WebSocketServlet {
	
	private WebSocketServletFactory webSocketServletFactory;
	
    @Override
    public void configure(WebSocketServletFactory factory) {
    	this.webSocketServletFactory = factory;
    	String webSocketIdleTimeout = getServletConfig().getInitParameter("web-socket-idle-timeout");
        if (!CoreUtil.isBlank(webSocketIdleTimeout)) {
        	factory.getPolicy().setIdleTimeout(Long.parseLong(webSocketIdleTimeout)); 
        }
        factory.setCreator(new WebSocketCreator() {
			
			@Override
			public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
				String pathInfo = req.getHttpServletRequest().getPathInfo();		
				
				if (pathInfo==null) {
					pathInfo = "";
				}
				if (pathInfo.startsWith("/")) {
					pathInfo = pathInfo.substring(1);
				}
				String[] path = pathInfo.split("/");
				String reqUrl = req.getHttpServletRequest().getContextPath()+req.getHttpServletRequest().getServletPath();
				Action action = null;
				Context chain = new ContextImpl(getBundleContext()) {
					
					@SuppressWarnings("unchecked")
					@Override
					public <T> T adapt(Class<T> targetType) throws Exception {
						if (WebSocketUpgradeInfo.class == targetType) {
							return (T) new WebSocketUpgradeInfo() {
								
								@Override
								public ServletUpgradeResponse getUpgradeResponse() {
									return resp;
								}
								
								@Override
								public ServletUpgradeRequest getUpgradeRequest() {
									return req;
								}
								
								@Override
								public ContextProvider<?> getContextProvider(HttpServletRequestContext context) throws Exception {
									return createWebSocketContextProvider(context, req, resp);
								}
								
							};
						}
						return super.adapt(targetType);
					}
				};
				try (HttpServletRequestContext context = createContext(path, req.getHttpServletRequest(), null, reqUrl, chain)) {
					for (Route route: matchRootRoutes(RequestMethod.valueOf(req.getMethod()), path)) {
						action = route.execute(context);
						if (action!=null) {
							break;
						}
					}
					if (action!=null) {
						return action.execute();
					}
				} catch (Exception e) {
					e.printStackTrace();
					try {
						resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
				
				return null;
			}
		});
    }	
    
    protected BundleContext getBundleContext() {
		return FrameworkUtil.getBundle(getClass()).getBundleContext();
    }
    
    /**
     * Creates web socket context provider. Implementations may, for example, store the original request principal/subject in the provider.
     * @param context
     * @param upgradeRequest
     * @param upgradeResponse
     * @return
     */
    protected abstract ContextProvider<?> createWebSocketContextProvider(
    		HttpServletRequestContext context,
    		ServletUpgradeRequest upgradeRequest, 
    		ServletUpgradeResponse upgradeResponse) throws Exception;
    
	protected ExtensionManager extensionManager;
	
	private boolean jsonPrettyPrint;

	private String responseCharacterEncoding = "UTF-8";
	public static final MimetypesFileTypeMap MIME_TYPES_MAP = new MimetypesFileTypeMap(AbstractRoutingServlet.class.getResourceAsStream("mime.types"));
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		Thread currentThread = Thread.currentThread();
		ClassLoader ccl = currentThread.getContextClassLoader();
		try {			
			currentThread.setContextClassLoader(getClass().getClassLoader());
			if (config.getServletContext().getAttribute(DecoratedObjectFactory.ATTR) == null) {
				config.getServletContext().setAttribute(DecoratedObjectFactory.ATTR, new DecoratedObjectFactory());
			}
			super.init(config);
		} finally {
			currentThread.setContextClassLoader(ccl);
		}
		
		jsonPrettyPrint = "true".equals(config.getInitParameter("json-pretty-print"));
		try {
			extensionManager = new ExtensionManager(
					this,
					getBundleContext(), 
					config.getInitParameter("adapter-service-filter"),
					config.getInitParameter("route-service-filter"),
					config.getInitParameter("ui-part-service-filter"),
					config.getInitParameter("html-factory"),
					"deny".equalsIgnoreCase(config.getInitParameter("default-access-decision")) ? AccessDecision.DENY : AccessDecision.ALLOW,
					config.getServletContext().getContextPath());
		} catch (Exception e) {
			throw new ServletException(e);
		}		
		
		String rce = config.getInitParameter("response-character-encoding");
		if (rce != null) {
			responseCharacterEncoding = rce;
		}
	}
			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(responseCharacterEncoding);
        if (webSocketServletFactory != null && webSocketServletFactory.isUpgradeRequest(req,resp)) {
        	super.service(req, resp);
        } else {		
			String reqUrl = req.getContextPath()+req.getServletPath();
			String pathInfo = req.getPathInfo();		
			
			if (pathInfo==null) {
				pathInfo = "";
			}
			if (pathInfo.startsWith("/")) {
				pathInfo = pathInfo.substring(1);
			}
			String[] path = pathInfo.split("/");
			if (path.length>0) {
				String fn = path[path.length-1];
				if (fn.indexOf('.')!=-1) {
					String contentType = MIME_TYPES_MAP.getContentType(fn);
					if (!CoreUtil.isBlank(contentType)) {
						resp.setContentType(contentType);
					}
				}
			}
			Action action = null;
			try (HttpServletRequestContext context = createContext(path, req, resp, reqUrl)) {
				for (Route route: matchRootRoutes(RequestMethod.valueOf(req.getMethod()), path)) {
					action = route.execute(context);
					if (action!=null) {
						break;
					}
				}
			} catch (ServerException e) {
				resp.sendError(e.getStatusCode(), e.getMessage());
			} catch (ServletException | IOException e) {
				throw e;
			} catch (Exception e) {
				throw new ServletException(e);			
			}
			if (action==null) {			
				resp.sendError(HttpServletResponse.SC_NOT_FOUND);			
			} else {
				try {
					resultToResponse(action.execute(), resp);
				} catch (IOException | ServletException e) {
					throw e;
				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
        }
	}

	protected Iterable<Route> matchRootRoutes(RequestMethod method, String[] path) throws Exception {
		return extensionManager.getRouteRegistry().matchRootRoutes(method, path);
	}

	protected abstract HttpServletRequestContext createContext(
			String[] path,
			HttpServletRequest req, 
			HttpServletResponse resp, 
			String reqUrl,
			Context... chain) throws Exception;

	public void resultToResponse(Object result, HttpServletResponse resp) throws Exception {
		if (result instanceof ProcessingError) {
			ProcessingError processingError = (ProcessingError) result;
			if (processingError.getMessage()==null) {
				resp.sendError(processingError.getCode());
			} else {
				resp.sendError(processingError.getCode(), processingError.getMessage());
			}
		} else if (result instanceof JSONArray) {
			resp.setContentType("application/json");
			if (jsonPrettyPrint) {
				resp.getWriter().write(((JSONArray) result).toString(4));
			} else {
				((JSONArray) result).write(resp.getWriter());
			}
		} else if (result instanceof JSONObject) {
			resp.setContentType("application/json");
			if (jsonPrettyPrint) {
				resp.getWriter().write(((JSONObject) result).toString(4));
			} else {
				((JSONObject) result).write(resp.getWriter());
			}
		} else if (result instanceof String) {
			resp.getWriter().write((String) result);
		} else if (result instanceof char[]) {
			resp.getWriter().write((char[]) result);
		} else if (result instanceof byte[]) {
			resp.getOutputStream().write((byte[]) result);
		} else if (result instanceof Reader) {
			try {
				Writer writer = resp.getWriter();
				char[] cbuf = new char[4096];
				int l;
				while ((l=((Reader) result).read(cbuf))!=-1) {
					writer.write(cbuf, 0, l);
				}
			} finally {
				((Reader) result).close();
			}
		} else if (result instanceof InputStream) {
			try (InputStream in = (InputStream) result; OutputStream out = resp.getOutputStream()) {
				byte[] buf = new byte[4096];
				int l;
				while ((l=((InputStream) result).read(buf))!=-1) {
					out.write(buf, 0, l);
				}
			}
		} else if (result instanceof URL) {
			resultToResponse(((URL) result).openStream(), resp);
		} else if (result!=null) {
			resp.getWriter().write(result.toString());
		}
	}
	
	@Override
	public void destroy() {
		if (extensionManager!=null) {
			try {
				extensionManager.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.destroy();
	}

}
