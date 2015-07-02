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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.nasdanika.core.AuthorizationProvider.AccessDecision;
import org.nasdanika.core.CoreUtil;

@SuppressWarnings("serial")
public abstract class AbstractRoutingServlet extends HttpServlet {
	
	protected ExtensionManager extensionManager;
	
	private boolean jsonPrettyPrint;
	protected MimetypesFileTypeMap mimeTypesMap;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		jsonPrettyPrint = "true".equals(config.getInitParameter("json-pretty-print"));
		try {
			extensionManager = new ExtensionManager(
					this,
					null, 
					config.getInitParameter("adapter-service-filter"),
					config.getInitParameter("route-service-filter"),
					config.getInitParameter("ui-part-service-filter"),
					config.getInitParameter("html-factory"),
					"deny".equalsIgnoreCase(config.getInitParameter("default-access-decision")) ? AccessDecision.DENY : AccessDecision.ALLOW,
					config.getServletContext().getContextPath());
		} catch (Exception e) {
			throw new ServletException(e);
		}		
		mimeTypesMap = new MimetypesFileTypeMap(AbstractRoutingServlet.class.getResourceAsStream("mime.types"));		
	}
			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
				String contentType = mimeTypesMap.getContentType(fn);
				if (!CoreUtil.isBlank(contentType)) {
					resp.setContentType(contentType);
				}
			}
		}
		Action action = null;
		try (HttpServletRequestContext context = createContext(path, req, resp, reqUrl)) {
			for (Route route: matchRootRoutes(req, path)) {
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

	protected Iterable<Route> matchRootRoutes(HttpServletRequest req, String[] path) throws Exception {
		return extensionManager.getRouteRegistry().matchRootRoutes(RequestMethod.valueOf(req.getMethod()), path);
	}

	protected abstract HttpServletRequestContext createContext(
			String[] path,
			HttpServletRequest req, 
			HttpServletResponse resp, 
			String reqUrl) throws Exception;

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
