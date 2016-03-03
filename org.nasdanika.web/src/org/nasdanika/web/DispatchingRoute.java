package org.nasdanika.web;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.DocumentationProvider;
import org.nasdanika.core.ExtensionParameter;
import org.nasdanika.core.ServiceParameter;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.routes.ObjectRoute;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * Dispatches requests to target's methods with {@link RouteMethod} annotation. Route methods parameters can be annotated with
 * {@link ContextParameter}, {@link ServiceParameter}, {@link ExtensionParameter}, {@link PathParameter}, {@link QueryParameter}, 
 * {@link BodyParameter}, or {@link CookieParameter} annotations.
 * 
 * Also serves resources as instructed by {@link Resource} annotations on the target's class and its superclasses and interfaces.
 * Route methods are matched before resources. 
 * 
 * This class can serve API documentation if <code>getApiDocPath()</code> method is overridden. 
 * @author Pavel Vlasov
 *
 */
public class DispatchingRoute implements Route, DocumentationProvider {
			
	private Object target;
	protected List<RouteMethodCommand<HttpServletRequestContext, Object>> routeMethodCommands = new ArrayList<>();
	
	protected Object getTarget() {
		return target==null ? this : target;
	}
	
	public DispatchingRoute(BundleContext bundleContext, Object target) throws Exception {
		this.target = target;
		for (Method method: (target==null ? getClass() : target.getClass()).getMethods()) {
			final RouteMethod routeMethod = method.getAnnotation(RouteMethod.class);
			if (routeMethod!=null) {
				routeMethodCommands.add(createRouteMethodCommand(bundleContext, method));
			}
		}
		
		Collections.sort(routeMethodCommands);				
		collectResourceEntries(target==null ? getClass() : target.getClass(), 0, 0, new HashSet<Class<?>>());
	}

	/**
	 * Subclasses may override this method to return customized route method commands 
	 * @param bundleContext
	 * @param method
	 * @return
	 * @throws Exception
	 */
	protected RouteMethodCommand<HttpServletRequestContext, Object> createRouteMethodCommand(BundleContext bundleContext, Method method) throws Exception {
		return new RouteMethodCommand<HttpServletRequestContext, Object>(bundleContext, method);
	}
	
	private void collectResourceEntries(Class<?> clazz, int distance, int position, Set<Class<?>> traversed) {
		if (clazz!=null && traversed.add(clazz)) {
			int idx = 0;
			Resource resource = clazz.getAnnotation(Resource.class);
			if (resource!=null) {
				resourceEntries.add(new ResourceEntry(clazz, resource, distance, position, ++idx));
			}

			Resources resources = clazz.getAnnotation(Resources.class);
			if (resources!=null) {
				for (Resource res: resources.value()) {
					resourceEntries.add(new ResourceEntry(clazz, res, distance, position, ++idx));
				}
			}
			collectResourceEntries(clazz.getSuperclass(), distance+1, 0, traversed);
			Class<?>[] implementedInterfaces = clazz.getInterfaces();
			for (int i=0; i<implementedInterfaces.length; ++i) {
				collectResourceEntries(implementedInterfaces[i], distance+1, i, traversed);
			}
			
			Collections.sort(resourceEntries);
		}		
	}
	
	private class ResourceEntry implements Comparable<ResourceEntry> {

		private String path;
		private int distance;
		private int priority;
		private String bundle;
		private Class<?> clazz;
		private String location;
		private boolean absolute;
		private String comment;
		private int position;
		private int index;

		ResourceEntry(Class<?> clazz, Resource res, int distance, int position, int index) {
			this.bundle = res.bundle();
			this.clazz = clazz;
			this.location = res.value();
			this.priority = res.priority();
			this.path = CoreUtil.isBlank(res.path()) ? res.value() : res.path();
			this.distance = distance;
			this.position = position;
			this.index = index;
			this.absolute = res.absolute();
			this.comment = res.comment();
			//this.bundleVersion = res.bundleVersion();
		}
		
		URL resolve(String path) throws MalformedURLException {
			if (absolute) {
				if (CoreUtil.isBlank(path)) {
					return new URL(location);
				}
				
				return new URL(location+path);
				
			}
			
			if (CoreUtil.isBlank(bundle)) {
				if (CoreUtil.isBlank(path)) {
					return clazz.getResource(location);
				}
				
				return clazz.getResource(location+path);
			}
			
			
			Bundle bundle = Platform.getBundle(this.bundle);
			if (bundle!=null) {
				if (CoreUtil.isBlank(path)) {
					return bundle.getResource(location);
				}
				
				return bundle.getResource(location+path);					
			}
			
			return null;
		}
		
		@Override
		public int compareTo(ResourceEntry o) {
			// The route with higher priority takes precedence.
			int cmp = o.priority - priority;
			if (cmp!=0) {
				return cmp;
			}
			
			// A route with the longest path takes precedence over the other.				
			cmp = o.path.length() - path.length();
			if (cmp!=0) {
				return cmp;
			}
			
			// If priorities are equal, then route defined in a sub-class or a class with shortest inheritance distance to the target class.
			cmp = distance - o.distance;
			if (cmp!=0) {
				return cmp;
			}
			
			cmp = position - o.position;
			if (cmp!=0) {
				return cmp;
			}
						
			cmp = index - o.index;
			if (cmp!=0) {
				return cmp;
			}
			
			return hashCode() - o.hashCode();
		}
		
	}
	
	private List<ResourceEntry> resourceEntries = new ArrayList<>();

	
	/**
	 * Dispatches to self 
	 * @throws Exception 
	 */
	protected DispatchingRoute(BundleContext bundleContext) throws Exception {
		this(bundleContext, null);
	}

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {						
		String[] path = context.getPath();
		
		if (!CoreUtil.isBlank(getApiDocPath())
				&& context.getMethod() == RequestMethod.GET
				&& getApiDocPath().equals(CoreUtil.join(path, "/"))) {
			
			context.getResponse().setContentType("text/html");
			return new ValueAction(generateApiDocumentation());
		}
		
		if (RequestMethod.GET == context.getMethod()) {
			String jp = CoreUtil.join(path, "/");
			for (ResourceEntry resEntry: resourceEntries) {
				if (jp.equals(resEntry.path) || (resEntry.path.endsWith("/") && jp.startsWith(resEntry.path))) {
					URL result = resEntry.resolve(jp.substring(resEntry.path.length()));					
					if (result!=null) {
						return new ValueAction(result);
					}
				}				
			}
		}
		
		W: for (RouteMethodCommand<HttpServletRequestContext, Object> routeMethodCommand: routeMethodCommands) {
			
			if (routeMethodCommand.getRequestMethods().length>0) {
				boolean methodMatch = false;
				for (RequestMethod method: routeMethodCommand.getRequestMethods()) {
					if (context.getMethod().equals(method)) {
						methodMatch = true;
						break;
					}
				}
				if (!methodMatch) {
					continue;
				}
			}
			
			if (!ObjectRoute.matchProduces(context, routeMethodCommand.getProduces())) {
				continue;
			}
			
			if (!ObjectRoute.matchConsumes(context, routeMethodCommand.getConsumes())) {
				continue;
			}
						
			if (!CoreUtil.isBlank(routeMethodCommand.getPath())) {
				String[] splitRoutePath = routeMethodCommand.getPath().split("/");
				if (routeMethodCommand.getPath().endsWith("/")) {
					if (splitRoutePath.length>=path.length) {
						continue;
					}
				} else {
					if (splitRoutePath.length!=path.length) {
						continue;
					}
				}
				
				for (int i=0; i<splitRoutePath.length; ++i) {
					boolean isPathParameter = splitRoutePath[i].startsWith("{") && splitRoutePath[i].endsWith("}");
					if (!isPathParameter && !splitRoutePath[i].equals(path[i])) {
						continue W;
					}
				}
				
				if (context.authorize(getTarget(), CoreUtil.isBlank(routeMethodCommand.getAction()) ? context.getMethod().name() : routeMethodCommand.getAction(), routeMethodCommand.getQualifier(), null)) {
					if (!CoreUtil.isBlank(routeMethodCommand.getProduces())) {
						context.getResponse().setContentType(routeMethodCommand.getProduces());
					}							
					Object result = routeMethodCommand.execute(context, getTarget(), args);
					if (result==null && routeMethodCommand.getMethod().getReturnType() == void.class) {
						return Action.NOP;				
					}
					return ValueAction.wrap(result);
				}
				
				return Action.FORBIDDEN;
			} else if (path.length > 1) {										
				if (routeMethodCommand.getPattern()!=null && routeMethodCommand.getPattern().matcher(CoreUtil.join(path, "/")).matches()) {
					if (context.authorize(getTarget(), CoreUtil.isBlank(routeMethodCommand.getAction()) ? context.getMethod().name() : routeMethodCommand.getAction(), routeMethodCommand.getQualifier(), null)) {
						if (!CoreUtil.isBlank(routeMethodCommand.getProduces())) {
							context.getResponse().setContentType(routeMethodCommand.getProduces());
						}							
						Object result = routeMethodCommand.execute(context, getTarget(), args);
						if (result==null && routeMethodCommand.getMethod().getReturnType() == void.class) {
							return Action.NOP;				
						}
						return ValueAction.wrap(result);
					}
					
					return Action.FORBIDDEN;
				}				
			}						
		}		
		return Action.NOT_FOUND;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		for (WebMethodCommand<HttpServletRequestContext, Object> wmc: routeMethodCommands) {
			wmc.close();
		}
	}
	
	// --- Rendering of API docs
	
	/**
	 * @return Location of bootstrap.css. This implementation returns MaxCDN location. 
	 */
	protected String getBootstrapCssLocation() {
		return "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css";
	}

	/**
	 * @return Location of bootstrap theme. This implementation returns MaxCDN location. 
	 */
	protected String getBootstrapThemeCssLocation() {
		return "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css";
	}
	
	/**
	 * @return Location of jQuery script. This implementation returns MaxCDN location. 
	 */
	protected String getJQueryScriptLocation() {
		return "//code.jquery.com/jquery-1.12.0.min.js";
	}

	/**
	 * @return Location of bootstrap script. This implementation returns MaxCDN location. 
	 */
	protected String getBootstrapScriptLocation() {
		return "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js";
	}
	
	/**
	 * If this method returns a non-blank string then it is used as a path to serve generated
	 * API docs at for the GET method. 
	 * @return
	 */
	protected String getApiDocPath() {
		return null;
	}
		
	protected String markdownModelName(Class<?> modelClass) {
		if (void.class == modelClass || modelClass == null) {
			return "";
		}
		if (modelClass.isPrimitive()) {
			return modelClass.getName();
		}
		if (modelClass.isArray()) {
			return "[[javadoc>"+modelClass.getComponentType().getName()+"]]*";
		}
		return "[[javadoc>"+modelClass.getName()+"]]";
	}
	
	protected Object htmlModelName(Class<?> modelClass) {
		if (void.class == modelClass || modelClass == null) {
			return "";
		}
		return modelClass.getName();
	}	
	
	/**
	 * Helper class for sorting and presenting method and resource entries
	 * @author Pavel Vlasov
	 *
	 */
	private class ApiInfo implements Comparable<ApiInfo> {
		private String path;
		private String pattern;
		private RequestMethod[] methods;
		private String[] consumes;
		private String produces;
		private int priority;
		private String comment;

		private Object htmlRequestModel = "";
		private Object htmlResponseModel = "";

		private String markdownRequestModel = "";
		private String markdownResponseModel = "";
		
		ApiInfo(RouteMethodCommand<HttpServletRequestContext, Object> rmc) {
			path = rmc.getPath();
			pattern = rmc.getMethod().getAnnotation(RouteMethod.class).pattern();
			methods = rmc.getRequestMethods();
			consumes = rmc.getConsumes();
			produces = rmc.getProduces();
			priority = rmc.getMethod().getAnnotation(RouteMethod.class).priority();
			comment = rmc.getComment();
			
			Class<?>[] pt = rmc.getMethod().getParameterTypes();
			Annotation[][] pa = rmc.getMethod().getParameterAnnotations();
			Z: for (int i=0; i<pt.length; ++i) {
				for (Annotation a: pa[i]) {
					if (a instanceof BodyParameter) {
						htmlRequestModel = htmlModelName(pt[i]);
						markdownRequestModel = markdownModelName(pt[i]);
						break Z;
					}
				}
			}
			htmlResponseModel = htmlModelName(rmc.getMethod().getReturnType()); 
			markdownResponseModel = markdownModelName(rmc.getMethod().getReturnType()); 
		}

		ApiInfo(ResourceEntry re) {
			path = re.path;
			pattern = "";
			methods = new RequestMethod[] {RequestMethod.GET};
			consumes = new String[] {};
			produces = "";
			priority = re.priority;
			comment = re.comment;
		}
		
		void generateRow(RowContainer<?> rowContainer) {
			Row row = rowContainer.row();
			row.cell(path);
			row.cell(pattern);
			if (methods.length==0 || Arrays.equals(RequestMethod.values(), methods)) {
				row.cell("*").bootstrap().text().center();
			} else if (methods.length==1) {
				row.cell(methods[0].name()).bootstrap().text().center();
				styleApiRow(row, methods[0]);
			} else {
				Tag ul = row.getFactory().tag(TagName.ul);
				row.cell(ul).bootstrap().text().center();
				for (RequestMethod rm: methods) {
					ul.content(ul.getFactory().tag(TagName.li, rm.name()));
				}
			}
			if (consumes == null || consumes.length==0) {
				row.cell("");
			} else if (consumes.length==1) {
				row.cell(consumes[0]).bootstrap().text().center();
			} else {
				Tag ul = row.getFactory().tag(TagName.ul);
				row.cell(ul).bootstrap().text().center();
				for (String c: consumes) {
					ul.content(ul.getFactory().tag(TagName.li, c));
				}
			}
			row.cell(produces).bootstrap().text().center();
			row.cell(htmlRequestModel).bootstrap().text().center();
			row.cell(htmlResponseModel).bootstrap().text().center();
			row.cell(priority).bootstrap().text().center();
			row.cell(comment);
		}
		
		void generateRow(StringBuilder tableBuilder) {
			tableBuilder.append(" ").append(path).append(" | ");
			tableBuilder.append(pattern).append(" | ");
			if (methods.length==0 || Arrays.equals(RequestMethod.values(), methods)) {
				tableBuilder.append("*").append(" | ");
			} else if (methods.length==1) {
				tableBuilder.append(methods[0].name()).append(" | ");
			} else {
				for (RequestMethod rm: methods) {
					tableBuilder.append(rm.name()).append(" ");
				}
				tableBuilder.append("| ");
			}
			if (consumes == null || consumes.length==0) {
				tableBuilder.append(" | ");
			} else if (consumes.length==1) {
				tableBuilder.append(consumes[0]).append(" | ");
			} else {
				for (String c: consumes) {
					tableBuilder.append(c).append(" ");
				}
				tableBuilder.append("| ");
			}
			tableBuilder.append(produces).append(" | ");
			tableBuilder.append(markdownRequestModel).append(" | ");
			tableBuilder.append(markdownResponseModel).append(" | ");
			tableBuilder.append(priority).append(" | ");
			tableBuilder.append(comment).append(" | ");
			
			tableBuilder.append(System.lineSeparator());
		}
				
		@Override
		public int compareTo(ApiInfo o) {
			String pop = CoreUtil.isBlank(path) ? pattern : path;
			String opop = CoreUtil.isBlank(o.path) ? o.pattern : o.path;
			int cmp = pop.compareTo(opop);
			if (cmp!=0) {
				return cmp;
			}
			if (methods.length==0) {
				if (o.methods.length>0) {
					return -1;
				}
			}
			if (o.methods.length==0) {
				if (methods.length>0) {
					return 1;
				}
			}
			
			if (methods.length>0 && o.methods.length>0) {
				cmp = methods[0].name().compareTo(o.methods[0].name());
				if (cmp!=0) {
					return cmp;
				}
			}
			
			cmp = produces.compareTo(o.produces);
			if (cmp!=0) {
				return cmp;
			}
			cmp = o.priority - priority;
			if (cmp!=0) {
				return cmp;
			}
			
			return hashCode() - o.hashCode();
		}
		
	}

	/**
	 * Generates API documentation.
	 * @return
	 */
	protected String generateApiDocumentation() {
		Map<String, Object> env = new HashMap<>();
		env.put("bootstrap-css", getBootstrapCssLocation());
		env.put("bootstrap-theme-css", getBootstrapThemeCssLocation());
		env.put("jquery-js", getJQueryScriptLocation());
		env.put("bootstrap-js", getBootstrapScriptLocation());
		env.put("title", "Web API: "+getTarget().getClass().getName());
		Table apiTable = generateApiHtmlTable();		
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;		
		env.put("content", htmlFactory.panel(Style.PRIMARY, "<H4><B>Web API:</B> "+getTarget().getClass().getName()+"</H4>", apiTable, null).style().margin("10px"));
		String apiDoc = htmlFactory.interpolate(getApiDocumentationPageTemplate(), env);
		return apiDoc;
	}

	protected Table generateApiHtmlTable() {
		Table apiTable = HTMLFactory.INSTANCE.table().bordered();
		Row hRow = apiTable.header().row().style(Style.PRIMARY);
		hRow.header("Path");
		hRow.header("Pattern");
		hRow.header("Method(s)").bootstrap().text().center();
		hRow.header("Consumes").bootstrap().text().center();
		hRow.header("Produces").bootstrap().text().center();
		hRow.header("Request").bootstrap().text().center();
		hRow.header("Response").bootstrap().text().center();
		hRow.header("Priority").bootstrap().text().center();
		hRow.header("Comment");
		
		List<ApiInfo> apiInfos = new ArrayList<>();
		for (RouteMethodCommand<HttpServletRequestContext, Object> rmc: routeMethodCommands) {
			apiInfos.add(new ApiInfo(rmc));
		}
		
		for (ResourceEntry re: resourceEntries) {
			apiInfos.add(new ApiInfo(re));
		}
		
		Collections.sort(apiInfos);
		
		RowContainer<?> tableBody = apiTable.body();
		for (ApiInfo ai: apiInfos) {
			ai.generateRow(tableBody);
		}
		return apiTable;
	}

	/**
	 * @return Page template resource - String, URL, Reader, or InputStream.
	 */
	protected Object getApiDocumentationPageTemplate() {
		return DispatchingRoute.class.getResource("api-doc-template.html");
	}
	
	/**
	 * Styles API row based on request method.
	 * @param row
	 * @param requestMethod
	 */
	protected void styleApiRow(Row row, RequestMethod requestMethod) {
		switch (requestMethod) {
		case DELETE:
			row.style(Style.DANGER);
			break;
		case GET:
			row.style(Style.INFO);
			break;
		case POST:
			row.style(Style.SUCCESS);
			break;
		case PUT:
			row.style(Style.WARNING);
			break;
		case OPTIONS:
			break;
		case PATCH:
			break;
		case TRACE:
			break;
		default:
			// Nothing
			break;				
		}
	}

	@Override
	public String[] getSupportedDocumentationFormats() {
		return new String[] { "text/html", "text/markdown" };
	}

	@Override
	public String getDocumentation(String format) {
		if ("text/html".equals(format)) {
			return generateApiHtmlTable().toString();
		}
		if ("text/markdown".equals(format)) {
			return System.lineSeparator()
					+ System.lineSeparator()
					+ "Dispatching route [[javadoc>"+getClass().getName()+"]]"
					+ System.lineSeparator()
					+ System.lineSeparator()
					+ generateApiMarkdownTable();			
		}
		throw new IllegalArgumentException("Unsupported format: "+format);
	}

	protected String generateApiMarkdownTable() {
		StringBuilder tableBuilder = new StringBuilder(System.lineSeparator());
		
		tableBuilder.append("Path | Pattern     | Method(s) | Consumes | Produces | Request | Response | Priority | Comment").append(System.lineSeparator()); 
		tableBuilder.append("-----|-------------|:---------:|:--------:|:--------:|:-------:|:--------:|:--------:|--------").append(System.lineSeparator());

		List<ApiInfo> apiInfos = new ArrayList<>();
		for (RouteMethodCommand<HttpServletRequestContext, Object> rmc: routeMethodCommands) {
			apiInfos.add(new ApiInfo(rmc));
		}
		
		for (ResourceEntry re: resourceEntries) {
			apiInfos.add(new ApiInfo(re));
		}
		
		Collections.sort(apiInfos);
		
		for (ApiInfo ai: apiInfos) {
			ai.generateRow(tableBuilder);
		}
		
		
		tableBuilder.append(System.lineSeparator());
		return tableBuilder.toString();
	}
	
}
