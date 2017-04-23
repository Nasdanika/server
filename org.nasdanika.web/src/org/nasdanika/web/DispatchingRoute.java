package org.nasdanika.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.nasdanika.core.AuthorizationProvider;
import org.nasdanika.core.CoreUtil;
import org.nasdanika.core.DocumentationProvider;
import org.nasdanika.html.Bootstrap.Style;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.web.routes.ObjectRoute;
/**
 * Dispatches request to matching target.
 * 
 * This class can serve API documentation if <code>getApiDocPath()</code> method is overridden. 
 * @author Pavel Vlasov
 *
 */
public abstract class DispatchingRoute implements Route, DocumentationProvider {
	
	/**
	 * Target to dispatch request to.
	 * @author Pavel
	 *
	 */
	public interface Target {
		/**
		 * Supported HTTP methods. 
		 * @return
		 */
		RequestMethod[] getRequestMethods();
		
		/**
		 * Pattern to match path. Pattern is used for matching if getPath() returns null.
		 * @return
		 */
		Pattern getPattern();
		
		/**
		 * Route method path. Takes precedence over pattern. May contain path parameter specs, e.g. <code>{something}</code>
		 * @return
		 */
		String getPath();
		
		/**
		 * Response content type produced by the method. Used for route matching and for setting response content type if not yet set by the target.
		 * If this method returns null then the response content type is implied from the path's extension.
		 * @return
		 */
		String getProduces();
		
		/**
		 * Content types which this method can consume. Used for matching the target to request. Empty array matches any content type.
		 * for <code>CREATE_WEB_SOCKET</code> {@link RequestMethod} this attribute matches sub-protocols.
		 * @return
		 */
		String[] getConsumes();
				
		/**
		 * Authorization action. If not set a standard action corresponding to request method is used:
		 * 
		 * * GET, OPTIONS, TRACE - read
		 * * POST - create
		 * * DELETE - delete
		 * * PUT, PATCH - update
		 * 
		 * @return
		 */
		String getAction();
		
		/**
		 * Authorization qualifier. 
		 * @return
		 */
		String getQualifier();
			
		/**
		 * Comment to be shown in the dynamically generated API documentation.
		 * @return
		 */
		String getComment();	
		
		Object execute(HttpServletRequestContext context, Map<String, String> pathParameters, Object[] arguments) throws Exception;
		
	}
	
	protected abstract List<? extends Target> getTargets(HttpServletRequestContext context);

	@Override
	public Action execute(HttpServletRequestContext context, Object... args) throws Exception {						
		String[] path = context.getPath();
		
		HttpServletResponse response = context.getResponse();
		if (!CoreUtil.isBlank(getApiDocPath())
				&& context.getMethod() == RequestMethod.GET
				&& getApiDocPath().equals(CoreUtil.join(path, "/"))
				&& context.authorizeRead(context.getTarget(), "api-doc", null)) {
			
			response.setContentType("text/html");
			return new ValueAction(generateApiDocumentation(context));
		}
		
		W: for (Target target: getTargets(context)) {
			RequestMethod[] requestMethods = target.getRequestMethods();
			if (requestMethods.length>0) {
				boolean methodMatch = false;
				for (RequestMethod method: requestMethods) {
					if (context.getMethod().equals(method)) {
						methodMatch = true;
						break;
					}
				}
				if (!methodMatch) {
					continue;
				}
			}
			
			String produces = target.getProduces();
			if (!ObjectRoute.matchProduces(context, produces)) {
				continue;
			}
			
			if (!ObjectRoute.matchConsumes(context, target.getConsumes())) {
				continue;
			}
			
			String action = target.getAction();
			if (CoreUtil.isBlank(action)) {
				// Mapping request methods to standard actions
				switch (context.getMethod()) {
				case DELETE:
					action = AuthorizationProvider.StandardAction.delete.name();
					break;
				case GET:
				case OPTIONS:
				case TRACE:
					action = AuthorizationProvider.StandardAction.read.name();
					break;
				case POST:
					action = AuthorizationProvider.StandardAction.create.name();
					break;
				case PUT:
				case PATCH:
					action = AuthorizationProvider.StandardAction.update.name();
					break;
				default:
					action = context.getMethod().name();
					break;						
				}
			}			
						
			String targetPath = target.getPath();
			if (!CoreUtil.isBlank(targetPath)) {
				String[] splitRoutePath = targetPath.split("/");
				if (targetPath.endsWith("/")) {
					if (splitRoutePath.length>=path.length) {
						continue;
					}
				} else {
					if (splitRoutePath.length!=path.length) {
						continue;
					}
				}
				
				String qualifier = target.getQualifier();
				Map<String,String> pathParameters = new HashMap<>();
				for (int i=0; i<splitRoutePath.length; ++i) {
					boolean isPathParameter = splitRoutePath[i].startsWith("{") && splitRoutePath[i].endsWith("}");
					if (isPathParameter) {
						pathParameters.put(splitRoutePath[i].substring(1, splitRoutePath[i].length() - 1), path[i]);
						// Replacing path tokens in the qualifier
						if (qualifier != null) {
							for (int idx = qualifier.indexOf(splitRoutePath[i]); idx != -1; idx = qualifier.indexOf(splitRoutePath[i], idx + splitRoutePath[i].length())) {
								qualifier = qualifier.substring(0, idx) + path[i] + qualifier.substring(idx + splitRoutePath[i].length());
							}
						}								
					} else if (!splitRoutePath[i].equals(path[i])) {
						continue W;
					}
				}
								
				if (context.authorize(context.getTarget(), action, qualifier, null)) {
					if (response!=null && response.getContentType()==null && !CoreUtil.isBlank(produces)) {
						response.setContentType(produces);
					}							
					Object result = target.execute(context, pathParameters, args);
					return result==null ? Action.NOP : ValueAction.wrap(result);
				}
				
				return Action.FORBIDDEN;
			} else if (path.length > 1) {										
				Pattern pattern = target.getPattern();
				if (pattern!=null && pattern.matcher(CoreUtil.join(path, "/")).matches()) {
					if (context.authorize(context.getTarget(), action, target.getQualifier(), null)) {
						if (response!=null && response.getContentType()==null && !CoreUtil.isBlank(produces)) {
							response.setContentType(produces);
						}							
						Object result = target.execute(context, Collections.emptyMap(), args);
						return result==null ? Action.NOP : ValueAction.wrap(result);
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
		private Pattern pattern;
		private RequestMethod[] methods;
		private String[] consumes;
		private String produces;
		private String comment;

		ApiInfo(Target target) {
			path = target.getPath();
			pattern = target.getPattern();
			methods = target.getRequestMethods();
			consumes = target.getConsumes();
			produces = target.getProduces();
			comment = target.getComment();
		}
		
		void generateRow(RowContainer<?> rowContainer) {
			Row row = rowContainer.row();
			row.cell(path);
			row.cell(pattern == null ? "" : pattern);
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
			row.cell(comment);
		}
		
		void generateRow(StringBuilder tableBuilder) {
			tableBuilder.append(" ").append(path).append(" | ");
			tableBuilder.append(pattern==null ? "" : pattern).append(" | ");
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
			tableBuilder.append(comment).append(" | ");
			
			tableBuilder.append(System.lineSeparator());
		}
				
		@Override
		public int compareTo(ApiInfo o) {
			String pop = CoreUtil.isBlank(path) ? String.valueOf(pattern) : path;
			String opop = CoreUtil.isBlank(o.path) ? String.valueOf(o.pattern) : o.path;
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
			
			return hashCode() - o.hashCode();
		}
		
	}

	/**
	 * Generates API documentation.
	 * @return
	 */
	protected String generateApiDocumentation(HttpServletRequestContext context) {
		Map<String, Object> env = new HashMap<>();
		env.put("bootstrap-css", getBootstrapCssLocation());
		env.put("bootstrap-theme-css", getBootstrapThemeCssLocation());
		env.put("jquery-js", getJQueryScriptLocation());
		env.put("bootstrap-js", getBootstrapScriptLocation());
		env.put("title", "Web API");
		Table apiTable = generateApiHtmlTable(context);		
		HTMLFactory htmlFactory = HTMLFactory.INSTANCE;		
		env.put("content", htmlFactory.panel(Style.PRIMARY, "<H4><B>Web API</B></H4>", apiTable, null).style().margin("10px"));
		String apiDoc = htmlFactory.interpolate(getApiDocumentationPageTemplate(), env);
		return apiDoc;
	}

	protected Table generateApiHtmlTable(HttpServletRequestContext context) {
		Table apiTable = HTMLFactory.INSTANCE.table().bordered();
		Row hRow = apiTable.header().row().style(Style.PRIMARY);
		hRow.header("Path").rowspan(2);
		hRow.header("Pattern").rowspan(2);
		hRow.header("Method(s)").bootstrap().text().center();
		hRow.header("Consumes").bootstrap().text().center();
		hRow.header("Produces").bootstrap().text().center();
		hRow.header("Comment");
		
		List<ApiInfo> apiInfos = new ArrayList<>();
		for (Target target: getTargets(context)) {
			apiInfos.add(new ApiInfo(target));
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
			return generateApiHtmlTable(null).toString();
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
						
		tableBuilder.append("Path | Pattern     | Method(s) | Consumes | Produces | Comment").append(System.lineSeparator()); 
		tableBuilder.append("-----|-------------|:---------:|:--------:|:--------:|--------").append(System.lineSeparator());

		List<ApiInfo> apiInfos = new ArrayList<>();
		for (Target target: getTargets(null)) {
			apiInfos.add(new ApiInfo(target));
		}
		
		Collections.sort(apiInfos);
		
		for (ApiInfo ai: apiInfos) {
			ai.generateRow(tableBuilder);
		}
				
		tableBuilder.append(System.lineSeparator());
		return tableBuilder.toString();
	}
	
}
