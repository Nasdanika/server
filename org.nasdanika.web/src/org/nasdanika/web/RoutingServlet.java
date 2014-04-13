package org.nasdanika.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.InvalidSyntaxException;

@SuppressWarnings("serial")
public class RoutingServlet extends HttpServlet {
	
	protected ExtensionManager extensionManager;
	
	private boolean jsonPrettyPrint;	

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		jsonPrettyPrint = "true".equals(config.getInitParameter("json-pretty-print"));
		try {
			extensionManager = new ExtensionManager(null, config.getInitParameter("route-service-filter"));
		} catch (InvalidSyntaxException e) {
			throw new ServletException(e);
		}
	}
			
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();		
		if (pathInfo==null) {
			pathInfo = "";
		}
		if (pathInfo.startsWith("/")) {
			pathInfo = pathInfo.substring(1);
		}
		String[] path = pathInfo.split("/");
		try {
			HttpContext context = new HttpContextImpl(getPrincipal(req, resp), path, null, extensionManager, req, resp);
			for (Route route: extensionManager.getRouteRegistry().matchRootRoutes(RequestMethod.valueOf(req.getMethod()), path)) {
				try (Action action = route.execute(context)) {
					if (action!=null) {
						resultToResponse(action.execute(), resp, context);
						return;
					}
				}
			}
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		} catch (ServletException | IOException e) {
			throw e;
		} catch (Exception e) {
			throw new ServletException(e);			
		}
	}

	protected Object getPrincipal(HttpServletRequest req, HttpServletResponse resp) {
		return req.getUserPrincipal();
	}

//	/**
//	 * Converts request parameters/body to JSON or other format as applicable.
//	 * @param req
//	 * @return
//	 */
//	public static Object requestData(HttpServletRequest req) {
//		// TODO If content type is application/json - parse body and return. Otherwise construct JSON object from parameters 
//		// taking dots in consideration, e.g. a.b=5&a.c=10 shall create { a: { b:5, c:10 }}.
//		return null;
//	}

	public void resultToResponse(Object result, HttpServletResponse resp, WebContext context) throws Exception {
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
			try {
				OutputStream out = resp.getOutputStream();
				byte[] buf = new byte[4096];
				int l;
				while ((l=((InputStream) result).read(buf))!=-1) {
					out.write(buf, 0, l);
				}
			} finally {
				((InputStream) result).close();
			}
		} else if (result instanceof URL) {
			resultToResponse(((URL) result).openStream(), resp, context);
		} else if (result!=null) {
			JSONObject jsonResult = context.convert(result, JSONObject.class);
			if (jsonResult == null) {
				JSONArray jaResult = context.convert(result, JSONArray.class);
				if (jaResult==null) {
					resp.getWriter().write(String.valueOf(result));
				} else {
					resultToResponse(jaResult, resp, context);					
				}
			} else {
				resultToResponse(jsonResult, resp, context);
			}
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
