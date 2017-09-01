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
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.core.runtime.Platform;
import org.nasdanika.core.ContextParameter;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.ExtensionParameter;
import org.nasdanika.core.ServiceParameter;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.RouteMethod.Lock;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
/**
 * Dispatches requests to target's methods with {@link RouteMethod} annotation. Route methods parameters can be annotated with
 * 
 * * {@link BodyParameter},
 * * {@link CookieParameter},
 * * {@link HeaderParameter},
 * * {@link ModelParameter},
 * * {@link PartParameter},
 * * {@link PathParameter},
 * * {@link QueryParameter},
 * * {@link TargetParameter},
 * * {@link ContextParameter}, 
 * * {@link ServiceParameter}, 
 * * {@link ExtensionParameter}
 * 
 * annotations.
 * 
 * Also serves resources as instructed by {@link Resource} annotations on the target's class and its superclasses and interfaces.
 * Route methods are matched before resources. 
 * 
 * @author Pavel Vlasov
 *
 */
public class MethodDispatchingRoute extends DispatchingRoute {
	
	private class RouteMethodEntry implements Target, Comparable<RouteMethodEntry> {
		Object target;
		RouteMethodCommand<HttpServletRequestContext, Object> command;
		
		RouteMethodEntry(Object target, RouteMethodCommand<HttpServletRequestContext, Object> command) {
			super();
			this.target = target;
			this.command = command;
		}
		
		Object getTarget() {
			return target==null ? MethodDispatchingRoute.this : target;
		}
		
		@Override
		public int compareTo(RouteMethodEntry o) {
			return command.compareTo(o.command);
		}

		@Override
		public String toString() {
			return "RouteMethodEntry [command=" + command + ", target=" + target + "]";
		}

		@Override
		public RequestMethod[] getRequestMethods() {
			return command.getRequestMethods();
		}

		@Override
		public Pattern getPattern() {
			return command.getPattern();
		}

		@Override
		public String getPath() {
			return command.getPath();
		}

		@Override
		public String getProduces() {
			return command.getProduces();
		}

		@Override
		public String[] getConsumes() {
			return command.getConsumes();
		}

		@Override
		public String getAction() {
			return command.getAction();
		}

		@Override
		public String getQualifier() {
			return command.getQualifier();
		}

		@Override
		public String getComment() {
			return command.getComment();
		}

		@Override
		public Object execute(HttpServletRequestContext context, Map<String, String> pathParameters, Object[] arguments) throws Exception {
			return command.execute(context, getTarget(), arguments);
		}	
		
	}
			
	protected List<RouteMethodEntry> routeMethodEntries = new ArrayList<>();
	private Object[] targets;
		
	@Override
	protected List<? extends Target> getTargets(HttpServletRequestContext context) throws Exception {
		return routeMethodEntries;
	}	
	
	public MethodDispatchingRoute(BundleContext bundleContext, Object... targets) throws Exception {
		if (targets.length==0) {
			targets = new Object[] {this}; // Self-dispatch
		}
		
		HashSet<Class<?>> traversedRouteMethods = new HashSet<Class<?>>();
		HashSet<Class<?>> traversedResourceEntries = new HashSet<Class<?>>();
		for (Object target: targets) {
			collectRouteMethods(bundleContext, target, target==null ? getClass() : target.getClass(), traversedRouteMethods);
			collectResourceEntries(target==null ? getClass() : target.getClass(), 0, 0, traversedResourceEntries);
		}
		
		Collections.sort(routeMethodEntries);	
		this.targets = targets;
	}
	
	private void collectRouteMethods(BundleContext bundleContext, Object target, Class<?> clazz, Set<Class<?>> traversed) throws Exception {				
		if (clazz!=null && traversed.add(clazz)) {
			for (Method method: clazz.getDeclaredMethods()) {
				RouteMethod routeMethod = method.getAnnotation(RouteMethod.class);
				if (routeMethod!=null) {
					routeMethodEntries.add(new RouteMethodEntry(target, createRouteMethodCommand(bundleContext, method)));
				}
			}
			
			collectRouteMethods(bundleContext, target, clazz.getSuperclass(), traversed);
			Class<?>[] implementedInterfaces = clazz.getInterfaces();
			for (int i=0; i<implementedInterfaces.length; ++i) {
				collectRouteMethods(bundleContext, target, implementedInterfaces[i], traversed);
			}
		}		
	}
	
	protected class DelegatingRouteMethodCommand extends RouteMethodCommand<HttpServletRequestContext, Object> {
		
		public DelegatingRouteMethodCommand(BundleContext bundleContext, Method method) throws Exception {
			super(bundleContext, method);
		}

		@Override
		protected long getLastModified(HttpServletRequestContext context, Object target, Object[] arguments) throws Exception {
			return isCache() ? MethodDispatchingRoute.this.getLastModified(context, target, method, arguments) : -1;
		}
		
		@Override
		protected void preProcess(HttpServletRequestContext context, Object target, Object[] arguments) throws Exception {
			MethodDispatchingRoute.this.preProcess(context, target, method, arguments);
		}
		
	};
	

	/**
	 * Subclasses may override this method to return customized route method commands 
	 * @param bundleContext
	 * @param method
	 * @return
	 * @throws Exception
	 */
	protected RouteMethodCommand<HttpServletRequestContext, Object> createRouteMethodCommand(BundleContext bundleContext, Method method) throws Exception {
		return new DelegatingRouteMethodCommand(bundleContext, method);
	}
	
	protected long getLastModified(HttpServletRequestContext context, Object target, Method method, Object[] arguments) throws Exception {
		return -1;
	}

	/**
	 * Invoked before method execution. This implementation sets Expires header to -1.
	 * @param context
	 * @param target
	 * @param method
	 * @param arguments
	 */
	protected void preProcess(HttpServletRequestContext context, Object target, Method method, Object[] arguments) throws Exception {
		context.getResponse().setHeader("Expires", "-1");			
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
					return bundle.getEntry(location);
				}
				
				return bundle.getEntry(location+path);					
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

    private static final String HEADER_IFMODSINCE = "If-Modified-Since";
    private static final String HEADER_LASTMOD = "Last-Modified";	

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {						
		String[] path = context.getPath();
		
		if (RequestMethod.GET == context.getMethod()) {
			String jp = CoreUtil.join(path, "/");
			for (ResourceEntry resEntry: resourceEntries) {
				if (jp.equals(resEntry.path) || (resEntry.path.endsWith("/") && jp.startsWith(resEntry.path))) {
					URL result = resEntry.resolve(jp.substring(resEntry.path.length()));					
					if (result!=null) {
						if (!AbstractRoutingServlet.isCachingDisabled(context.getRequest())) {					        
					        int maxInactiveInterval = context.getRequest().getSession().getMaxInactiveInterval();
					        if (maxInactiveInterval > 0) {	
					        	context.getResponse().setDateHeader("Expires", System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(maxInactiveInterval));
					        }
					        
					        long lastModified = result.openConnection().getLastModified();
					        long ifModifiedSince = context.getRequest().getDateHeader(HEADER_IFMODSINCE);
					        
					        if (lastModified - ifModifiedSince < 1000) { // Seconds precision.				        	
					        	context.getResponse().setStatus(HttpServletResponse.SC_NOT_MODIFIED);
					        	return Action.NOP;
					        }
	
					        if (lastModified != -1 && !context.getResponse().containsHeader(HEADER_LASTMOD)) {
					            context.getResponse().setDateHeader(HEADER_LASTMOD, lastModified);        	
					        }
						}
						return new ValueAction(result);
					}
				}				
			}
		}
		
		return super.execute(context, args);
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		for (RouteMethodEntry rme: routeMethodEntries) {
			rme.command.close();
		}
		for (Object target: targets) {
			if (target instanceof AutoCloseable) {
				((AutoCloseable) target).close();
			}
		}
	}
	
	// --- Rendering of API docs
		
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
		private Lock lock;

		private Object htmlRequestModel = "";
		private Object htmlResponseModel = "";

		private String markdownRequestModel = "";
		private String markdownResponseModel = "";
		
		ApiInfo(RouteMethodEntry rme) {
			RouteMethodCommand<HttpServletRequestContext, Object> rmc = rme.command;
			path = rmc.getPath();
			pattern = rmc.getMethod().getAnnotation(RouteMethod.class).pattern();
			methods = rmc.getRequestMethods();
			consumes = rmc.getConsumes();
			produces = rmc.getProduces();
			priority = rmc.getMethod().getAnnotation(RouteMethod.class).priority();
			comment = rmc.getComment();
			lock = rmc.getLock();
			
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
			if (lock == null) {
				row.cell();
			} else {
				Tag lockInfo = TagName.ul.create();
				lockInfo.content(TagName.li.create("Type: "+lock.type()));
				lockInfo.content(TagName.li.create("Timeout: "+lock.timeout()));
				lockInfo.content(TagName.li.create("Time unit: "+lock.timeUnit()));
				if (!CoreUtil.isBlank(lock.path())) {
					lockInfo.content(TagName.li.create("Path: "+lock.path()));
				}
				row.cell(lockInfo);
			}
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
			StringBuilder lockInfo = new StringBuilder();
			if (lock != null) {
				lockInfo
					.append("type = " + lock.type())
					.append(", timeout = " + lock.timeout())
					.append(", time unit = " + lock.timeUnit());
				
				if (!CoreUtil.isBlank(lock.path())) {
					lockInfo.append(", path = " + lock.path());
				}
			}
			tableBuilder.append(lockInfo).append(" | ");
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
	@Override
	protected String generateApiDocumentation(HttpServletRequestContext context) {
		StringBuilder sb = new StringBuilder();
		for (Object target: targets) {
			Class<?> tc = target==null ? getClass() : target.getClass();
			if (sb.length()>0) {
				sb.append(", ");
			}
			sb.append(tc.getName());
		}
		Map<String, Object> env = new HashMap<>();
		env.put("bootstrap-css", getBootstrapCssLocation());
		env.put("bootstrap-theme-css", getBootstrapThemeCssLocation());
		env.put("jquery-js", getJQueryScriptLocation());
		env.put("bootstrap-js", getBootstrapScriptLocation());
		env.put("title", "Web API: "+sb);
		Table apiTable = generateApiHtmlTable(context);		
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;		
		env.put("content", htmlFactory.panel(Style.PRIMARY, "<H4><B>Web API:</B> "+sb+"</H4>", apiTable, null).style().margin("10px"));
		String apiDoc = htmlFactory.interpolate(getApiDocumentationPageTemplate(), env);
		return apiDoc;
	}

	@Override
	protected Table generateApiHtmlTable(HttpServletRequestContext context) {
		Table apiTable = HTMLFactory.INSTANCE.table().bordered();
		Row hRow = apiTable.header().row().style(Style.PRIMARY);
		hRow.header("Path").rowspan(2);
		hRow.header("Pattern").rowspan(2);
		hRow.header("Method(s)").bootstrap().text().center();
		hRow.header("Consumes").bootstrap().text().center();
		hRow.header("Produces").bootstrap().text().center();
		hRow.header("Request").bootstrap().text().center();
		hRow.header("Response").bootstrap().text().center();
		hRow.header("Priority").bootstrap().text().center();
		hRow.header("Lock").bootstrap().text().center();		
		hRow.header("Comment");
		
		List<ApiInfo> apiInfos = new ArrayList<>();
		for (RouteMethodEntry rme: routeMethodEntries) {
			apiInfos.add(new ApiInfo(rme));
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

	@Override
	protected String generateApiMarkdownTable() {
		StringBuilder tableBuilder = new StringBuilder(System.lineSeparator());
						
		tableBuilder.append("Path | Pattern     | Method(s) | Consumes | Produces | Request | Response | Priority | Lock | Comment").append(System.lineSeparator()); 
		tableBuilder.append("-----|-------------|:---------:|:--------:|:--------:|:-------:|:--------:|:--------:|------|--------").append(System.lineSeparator());

		List<ApiInfo> apiInfos = new ArrayList<>();
		for (RouteMethodEntry rme: routeMethodEntries) {
			apiInfos.add(new ApiInfo(rme));
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
