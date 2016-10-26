package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.cdo.boxing.Boxer;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.RowContainer.Row.Cell;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.webtest.model.OperationArgument;
import org.nasdanika.webtest.model.OperationStatus;
import org.nasdanika.webtest.model.StackTraceEntry;
import org.openqa.selenium.WebDriverException;

/**
 * Result of an operation such as constructor or method invocation.
 * @author Pavel Vlasov
 *
 */
public abstract class OperationResult<O extends AnnotatedElement, M extends org.nasdanika.webtest.model.OperationResult> implements HttpPublisher, DirectoryPublisher, InstanceTracker {

	final O operation;
	
	private Object target;
	
	public void setTarget(Object target) {
		this.target = target;
	}
	
	public Object getTarget() {
		return target;
	}

	final OperationResult<?,?> parent;

	private String id;
	
	private Object[] arguments;
	private boolean[] maskedArguments;
	private Boxer[] argumentBoxers;
	private Boxer resultBoxer;
	
	public Object[] getArguments() {
		return arguments;
	}
		
	private String instanceAlias;
	
	private static long instanceCounter;
	
	private static ThreadLocal<Map<Class<?>,Map<Object,String>>> instanceAliasMapThreadLocal = new ThreadLocal<Map<Class<?>,Map<Object,String>>>() {
		
		protected Map<Class<?>,Map<Object,String>> initialValue() {
			return new WeakHashMap<Class<?>,Map<Object,String>>();
		}
		
	};
	
	
	/**
	 * Sets operation instance.
	 * @param instance
	 */
	public void setInstance(Object instance) {
		if (instance!=null) {
			Map<Class<?>, Map<Object, String>> instanceAliasMap = instanceAliasMapThreadLocal.get();
			Map<Object, String> instanceClassAliasMap = instanceAliasMap.get(instance.getClass());
			if (instanceClassAliasMap == null) {
				instanceClassAliasMap = new WeakHashMap<Object,String>();
				instanceAliasMap.put(instance.getClass(), instanceClassAliasMap);
			}
			
			instanceAlias = instanceClassAliasMap.get(instance);
			if (instanceAlias==null) {
				if (instance instanceof Aliased) {
					instanceAlias = ((Aliased) instance).getAlias();
				} else {
					String cName = instance.getClass().getName();					
					int lastDotIdx = cName.lastIndexOf('.');
					instanceAlias = cName.substring(lastDotIdx+1, lastDotIdx+2)+Long.toString(instanceCounter++);
				}
				instanceClassAliasMap.put(instance, instanceAlias);
			}
		}
	}
	
	Object result;
	
	public Object getResult() {
		return result;
	}
	
	public O getOperation() {
		return operation;
	}
	
	public OperationResult<?,?> getParent() {
		return parent;
	}
	
	public String getId() {
		return id;
	}

	OperationResult(String id, O operation, Object[] arguments, OperationResult<?,?> parent) {
		this.id = id;
		this.operation = operation;
		ReportValue rva = operation.getAnnotation(ReportValue.class);
		if (rva != null) {
			try {
				resultBoxer = rva.value().newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				setFailure(e);
			}
		}
		if (arguments!=null) {
			this.arguments = Arrays.copyOf(arguments, arguments.length);	
			this.maskedArguments = new boolean[arguments.length];
			this.argumentBoxers = new Boxer[arguments.length];			
			Annotation[][] pa = null;			
			if (operation instanceof Constructor) {
				pa = ((Constructor<?>) operation).getParameterAnnotations();
			} else if (operation instanceof Method) {
				pa = ((Method) operation).getParameterAnnotations();				
			}			
			if (pa!=null) {
				for (int i=0; i<pa.length; ++i) {
					for (int j=0; j<pa[i].length; ++j) {
						if (pa[i][j] instanceof Mask) {
							this.arguments[i] = "*****";
							this.maskedArguments[i] = true;
							break;
						} else if (pa[i][j] instanceof ReportValue) {
							try {
								this.argumentBoxers[i] = ((ReportValue) pa[i][j]).value().newInstance();
							} catch (InstantiationException | IllegalAccessException e) {
								setFailure(e);
							}
						}
					}
				}
			}
		}
		this.parent = parent;
		if (parent!=null) {
			parent.childResults.add(this);
		}
	}
	
	@Override
	public String toString() {
		return getClass().getName()+ 
				" [operation=" + operation + 
				", start=" + start + 
				", finish=" + finish + 
				", result=" + result +
				", failure=" + failure + "]";
	}

	private long start = System.currentTimeMillis();
	
	public long getStart() {
		return start;
	}
	
	JSONObject beforePerformance;
	
	long finish;
	
	public long getFinish() {
		return finish;
	}
	
	List<ScreenshotEntry> screenshots = new ArrayList<>();
	
	JSONObject afterPerformance;

	private Throwable failure;
	
	void setFailure(Throwable f) {
		if (this.failure == null) {
			this.failure = f;
		} else {
			this.failure.addSuppressed(f);
		}		
	}
	
	public Throwable getFailure() {
		return failure;
	}
	
	boolean hasOwnFailure() {
		if (getFailure()==null) {
			return false;
		}
		
		Throwable rootCause = getRootCause();
		for (OperationResult<?,?> cor: childResults) {
			if (isSameRootCause(cor, rootCause)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isSameRootCause(OperationResult<?,?> or, Throwable rootCause) {
		if (rootCause.equals(or.getRootCause())) {
			return true;
		}
		for (OperationResult<?,?> cor: or.childResults) {
			if (isSameRootCause(cor, rootCause)) {
				return true;
			}
		}
		return false;
	}
	
	public Throwable getRootCause() {
		for (Throwable th = getFailure(); th!=null; th = th.getCause()) {
			if (th.getCause()==null) {
				return th;
			}
		}
		return getFailure();
	}		
	
	public boolean isFailure() {
		Throwable rootCause = getRootCause();
		// Maybe need to refine which subclasses of WebDriverException shall be treated as failures,
		// maybe make configurable through @Report annotation
		return rootCause instanceof AssertionError || rootCause instanceof WebDriverException; 
	}
	
	List<OperationResult<?,?>> childResults = new ArrayList<>();
	
	public List<OperationResult<?,?>> getChildren() {
		return childResults;
	}
	
	public List<ScreenshotEntry> allScreenshots() {
		return collectAllScreenshots(new LinkedList<ScreenshotEntry>()); 
	}
	
	private LinkedList<ScreenshotEntry> collectAllScreenshots(LinkedList<ScreenshotEntry> collector) {
		if (collector != null) {
			for (ScreenshotEntry se: screenshots) {
				if (se!=null) {
					collector.add(se);
				}
			}
			
			for (OperationResult<?,?> or: childResults) {
				or.collectAllScreenshots(collector);
			}

			Collections.sort(collector);
		}
		return collector;
	};
	
	Glyphicon getGlyphicon() {
		return Glyphicon.asterisk;
	}
	
	void genRow(HTMLFactory htmlFactory, Table methodTable) {
		Row row = methodTable.row();
		if (isPending()) {
			row.style(Bootstrap.Style.DEFAULT);
		} else if (isFailure()) {
			row.style(Bootstrap.Style.DANGER);
		} else if (getFailure()!=null) {
			row.style(Bootstrap.Style.WARNING);
		} else {
			row.style(Bootstrap.Style.SUCCESS);
		}
		row.cell(routeLink(htmlFactory, false));
		genDescriptionAndDurationCells(htmlFactory, row);
	}
	
	protected String getOperationName() {
		return String.valueOf(operation);
	}
	
	Object routeLink(HTMLFactory htmlFactory, boolean doStyle) {
		String name = "";
		Title mTitle = operation.getAnnotation(Title.class);
		if (mTitle == null) {
			name = WebTestUtil.title(getOperationName());
		} else {
			name = format(mTitle.value());
		}
		
		String methodDetailsLocation = "content/operation_"	+ id + ".html";
		if (getFailure()==null) {
			if (isPending()) { // Only the first screenshot or no calls to actor/page methods.
				Tag routeLink = htmlFactory.span(
						htmlFactory.glyphicon(Glyphicon.time), 
						"&nbsp;", 
						name);				
				return doStyle ? routeLink.style("color", Bootstrap.Color.GRAY.code) : routeLink;
				
			}
			
			Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.ok), 
					"&nbsp;", 
					name);
			return doStyle ? routeLink.style("color", Bootstrap.Color.SUCCESS.code) : routeLink;
		}
		
		if (isFailure()) {
			Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.remove), 
					"&nbsp;", 
					name);
			
			return doStyle ? routeLink.style("color", Bootstrap.Color.DANGER.code) : routeLink;
		}
		
		Tag routeLink = htmlFactory.routeLink(
					"main", 
					methodDetailsLocation, 
					htmlFactory.glyphicon(Glyphicon.warning_sign), 
					"&nbsp;", 
					name);
		return doStyle ? routeLink.style("color", Bootstrap.Color.WARNING.code) : routeLink;
	}

	public boolean isPending() {
		Screenshot screenshot = getOperation().getAnnotation(Screenshot.class);
		int expectedScreenshots = screenshot==null || Arrays.asList(screenshot.value()).contains(Screenshot.When.BEFORE) ? 2 : 1;
		return allScreenshots().size()<expectedScreenshots && childResults.isEmpty();
	}
		
	void genRows(HTMLFactory htmlFactory, Table methodTable, Object carouselId, List<ScreenshotEntry> screenshots, int indent) {
		Row row = methodTable.row();
		if (isPending()) {
			row.style(Bootstrap.Style.MUTED);
		} else if (isFailure()) {
			row.style(Bootstrap.Style.DANGER);
		} else if (getFailure()!=null) {
			row.style(Bootstrap.Style.WARNING);
		}
		
		Object caption = getHTMLCaption(htmlFactory);
		int slideIdx = -1;
		if (!screenshots.isEmpty()) {
			slideIdx = screenshots.indexOf(screenshots.get(0).getMaster()); 
		}
		if (slideIdx!=-1) {
			caption = htmlFactory.link("#carousel_"+carouselId, caption)
					.on(Event.click, "jQuery('#"+carouselId+"').carousel("+slideIdx+"); return true;");
		}
		row.cell(caption).style("padding-left", (indent*30+5)+"px");
		
		genDescriptionAndDurationCells(htmlFactory, row);
		
		for (OperationResult<?,?> ch: childResults) {
			ch.genRows(htmlFactory, methodTable, carouselId, screenshots, indent+1);
		}
	}
	
	String getDescriptionHTML() {
		Description description = operation.getAnnotation(Description.class);
		if (description==null) {
			return null;
		}			
		
		StringBuilder ret = new StringBuilder();
			
		if ("text/html".equalsIgnoreCase(description.contentType())) {
			for (String str: description.value()) {
				ret.append(format(str)).append(" ");
			}
		} else {
			ret.append("<pre>");
			int idx = 0;
			for (String str: description.value()) {
				if (idx++>0) {
					ret.append(System.lineSeparator());
				}
				ret.append(StringEscapeUtils.escapeHtml4(format(str)));
			}
			ret.append("</pre>");			
		}
		return ret.toString();
	}
	
	protected String format(String str) {
		if (str==null || arguments==null || arguments.length==0) {
			return str;
		}
		return MessageFormat.format(str, arguments);
	}

	private void genDescriptionAndDurationCells(HTMLFactory htmlFactory, Row row) {
		Cell descriptionCell = row.cell();
		String description = getDescriptionHTML();
		boolean hasOwnFailure = hasOwnFailure();
		if (description==null) {
			if (!hasOwnFailure) {
				descriptionCell.content("&nbsp;");
			}
		} else {
			descriptionCell.content(description);
		}
		
		if (hasOwnFailure) {
			StringWriter sw = new StringWriter();
			Throwable rootCause = getRootCause();
			rootCause.printStackTrace(new PrintWriter(sw));
			try {
				sw.close();
				descriptionCell.content(htmlFactory.collapsible(isFailure() ? Bootstrap.Style.DANGER : Bootstrap.Style.WARNING, "<pre>"+StringEscapeUtils.escapeHtml4(rootCause.toString())+"</pre>", true, "<pre style='color:red'>", sw, "</pre>"));
			} catch (IOException e) {
				// Should never happen.
				e.printStackTrace();
			}
		}
		
		long duration = finish - start;
		if (duration<1000) {
			row.cell(duration, " ms");
		} else {
			row.cell(MessageFormat.format("{0,number,#.###} sec", new Object[] {duration/1000.0}));
		}
	}
	
	String getHTMLCaption(HTMLFactory htmlFactory) {
		StringBuilder caption = new StringBuilder();
		caption.append(htmlFactory.glyphicon(getGlyphicon()));
		caption.append(" <b>");
		Class<?> dc = operation instanceof Member ? ((Member) operation).getDeclaringClass() : null;
		caption.append(ReportGenerator.classTitle(dc));
		caption.append("</b> <i>");
		Title mTitle = operation.getAnnotation(Title.class);
		if (mTitle==null) {
			caption.append(WebTestUtil.title(getOperationName()));
		} else {
			caption.append(format(mTitle.value()));
		}
		caption.append("</i>");
		return caption.toString();
	}
		
	public String getName() {
		StringBuilder caption = new StringBuilder();
		Class<?> dc = operation instanceof Member ? ((Member) operation).getDeclaringClass() : null;
		caption.append(ReportGenerator.classTitle(dc));
		caption.append(" : ");
		Title mTitle = operation.getAnnotation(Title.class);
		if (mTitle==null) {
			caption.append(WebTestUtil.title(getOperationName()));
		} else {
			caption.append(mTitle.value());
		}
		return format(caption.toString());
	}
		
	@Override
	public void publish(
			URL url, 
			String securityToken, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			PublishMonitor monitor) throws Exception {
		
		if (monitor!=null) {
			monitor.onPublishing("Operation Result "+getOperationName(), url);
		}
		HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		try (Writer w = new OutputStreamWriter(new GZIPOutputStream(pConnection.getOutputStream()))) {
			toJSON(publishPerformance, idMap).write(w);
		}
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			id = pConnection.getHeaderField("ID");
			idMap.put(this, id);
			String location = pConnection.getHeaderField("Location");
	
			if (parent==null) {
				URL methodResultsURL= new URL(location+"/screenshots");
				for (ScreenshotEntry se: allScreenshots()) {
					se.publish(methodResultsURL, securityToken, publishPerformance, idMap, monitor);				
				}
			}
	
			URL childrenURL= new URL(location+"/children");
			for (OperationResult<?,?> child: getChildren()) {
				child.publish(childrenURL, securityToken, publishPerformance, idMap, monitor);				
			}
			
			// --- Update non-containing references ---
			if (parent==null && !screenshots.isEmpty()) {
				HttpURLConnection uConnection = (HttpURLConnection) new URL(location).openConnection();
				uConnection.setRequestMethod("PUT");
				uConnection.setDoOutput(true);
				uConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
				JSONObject uData = new JSONObject();
				JSONArray screenshotsArray = new JSONArray();
				uData.put("screenshots", screenshotsArray);
				for (ScreenshotEntry screenshot: screenshots) {
					String sid = idMap.get(screenshot.getMaster());
					if (sid==null) {
						throw new IllegalStateException("Screenshot ID not found in ID map");
					}
					// TODO - type and comment as well
					screenshotsArray.put(sid);					
				}
				try (Writer w = new OutputStreamWriter(uConnection.getOutputStream())) {
					uData.write(w);
				}
				if (uConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
					throw new PublishException(uConnection.getURL()+" error: "+uConnection.getResponseCode()+" "+uConnection.getResponseMessage());
				}				
			}					
			// ---
		} else {
			throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
		}
	}

	private JSONObject toJSON(boolean publishPerformance, Map<Object, String> idMap) throws JSONException, Exception {
		JSONObject data = new JSONObject();
		WebTestUtil.titleAndDescriptionAndLinksAndCategoryToJSON(getOperation(), data);
		data.put("operationName", getOperationName());
		if (!data.has("title")) {
			data.put("title", WebTestUtil.title(getOperationName()));
		}
		data.put("qualifiedName", operation.toString());
		String cName = getClass().getName();
		data.put("type", cName.substring(cName.lastIndexOf('.')+1));
		if (publishPerformance) {
			if (beforePerformance!=null) {
				data.put("beforePerformance", beforePerformance);
			}
			if (afterPerformance!=null) {
				data.put("afterPerformance", afterPerformance);
			}
		}
		if (arguments!=null) {
			// Simplistic approach for now
			JSONArray args = new JSONArray();
			data.put("arguments", args);
			for (Object arg: arguments) {
				args.put(arg==null ? null : arg.toString());
			}
		}
		if (hasOwnFailure()) {
			if (isFailure()) {
				data.put("failure", toJSON(getRootCause()));
			} else {
				data.put("error", toJSON(getRootCause()));
			}
		}
		
		if (isPending()) {
			data.put("status", "PENDING");
		} else if (isFailure()) {
			data.put("status", "FAIL");
		} else if (getFailure()!=null) {
			data.put("status", "ERROR");
		} else {
			data.put("status", "PASS");
		}
		
		data.put("finish", finish);
		data.put("start", start);
		if (parent!=null && !screenshots.isEmpty()) {
			JSONArray screenshotsArray = new JSONArray();
			data.put("screenshots", screenshotsArray);
			for (ScreenshotEntry se: screenshots) {
				String sid = idMap.get(se.getMaster());
				if (sid==null) {
					throw new IllegalStateException("Screenshot ID not found in ID map");
				}
				// TODO - type and comment as well
				screenshotsArray.put(sid);				
			}
		}		
		extraPublishInfo(data);
		return data;
	}	
	
	private static JSONObject toJSON(Throwable th) throws Exception {
		JSONObject ret = new JSONObject();
		ret.put("type", th.getClass().getName());
		if (th.getMessage()!=null) {
			ret.put("message", th.getMessage());
		}
		JSONArray stackTrace = new JSONArray();
		ret.put("stackTrace", stackTrace);
		for (StackTraceElement ste: th.getStackTrace()) {
			JSONObject el = new JSONObject();
			stackTrace.put(el);
			el.put("className", ste.getClassName());
			if (ste.getFileName()!=null) {
				el.put("fileName", ste.getFileName());
			}
			if (ste.getLineNumber()>=0) {
				el.put("lineNumber", ste.getLineNumber());
			}
			el.put("methodName", ste.getMethodName());
			if (ste.isNativeMethod()) {
				el.put("native", true);
			}			
		}
		return ret;
	}
	
	private static org.nasdanika.webtest.model.Throwable toModel(Throwable th) {
		org.nasdanika.webtest.model.Throwable ret = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createThrowable();
		ret.setType(th.getClass().getName());
		if (th.getMessage()!=null) {
			ret.setMessage(th.getMessage());
		}
		for (StackTraceElement ste: th.getStackTrace()) {
			StackTraceEntry stackTraceEntry = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createStackTraceEntry();
			ret.getStackTrace().add(stackTraceEntry);
			stackTraceEntry.setClassName(ste.getClassName());
			if (ste.getFileName()!=null) {
				stackTraceEntry.setFileName(ste.getFileName());
			}
			if (ste.getLineNumber()>=0) {
				stackTraceEntry.setLineNumber(ste.getLineNumber());
			}
			stackTraceEntry.setMethodName(ste.getMethodName());
			stackTraceEntry.setNative(ste.isNativeMethod());
		}
		if (th.getCause() != null) {
			ret.setCause(toModel(th.getCause()));
		}
		for (Throwable s: th.getSuppressed()) {
			ret.getSupressed().add(toModel(s));
		}
		return ret;
	}
	
	
	/**
	 * A method for subclasses add 
	 * @param data 
	 */
	protected void extraPublishInfo(JSONObject data) throws Exception {
		
	}
	
	/**
	 * A method for subclasses add 
	 * @param data 
	 */
	protected void extraModelInfo(M model) {
		
	}
	
	
	@Override
	public int publishSize() {
		int ret = 1;
		for (OperationResult<?,?> or: getChildren()) {
			ret+=or.publishSize();	
		}
	
		if (parent==null) {
			for (ScreenshotEntry ss: allScreenshots()) {
				ret+=ss.publishSize();	
			}
		}
		return ret;
	}
	
	/**
	 * If object is instance of one of the keys in the object map, then the value is returned.
	 * Otherwise obj is returned.
	 * @param obj
	 * @param objectMap
	 * @return
	 */
	protected Object resolveModel(Object obj, Map<Object, Object> objectMap) {
		for (Entry<Object, Object> e: objectMap.entrySet()) {
			if (e.getKey() instanceof InstanceTracker && ((InstanceTracker) e.getKey()).isInstance(obj)) {
				return e.getValue();
			}
		}
		return obj;
	}
	
	/**
	 * Expands proxy types to a list of implemented interfaces
	 * @param type
	 * @return
	 */
	private String typeName(Class<?> type) {
		if (Proxy.isProxyClass(type)) {
			StringBuilder sb = new StringBuilder();
			for (Class<?> i: type.getInterfaces()) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(i.getName());
			}
			return sb.toString();
		}
		return type.getName();
	}
	
	/**
	 * Stores operation result to a model element.
	 * @param screenshotsCollector Collector of screenshots.
	 * @param screenshotsDir Directory where to store screenshots.
	 * @param objectMap Map of web test results to corresponding model elements.
	 * @param executor Executor allows to post tasks which are to be executed later after the 
	 * model elements are created for all results and added to the model.
	 * @return
	 */
	public M toModel(
			List<org.nasdanika.webtest.model.Screenshot> screenshotsCollector, 
			File screenshotsDir, 
			Map<Object, Object> objectMap,
			org.nasdanika.core.Context context,
			Executor executor) {
		M model = createModel();				
		objectMap.put(this, model);
		
		WebTestUtil.titleAndDescriptionAndLinksAndCategoryToDescriptor(getOperation(), model);
		model.setOperationName(getOperationName());
		if (WebTestUtil.isBlank(model.getTitle())) {
			model.setTitle(WebTestUtil.title(getOperationName()));
		}
		model.setQualifiedName(operation.toString());
		
		// Later execution for proper boxing of references.
		executor.execute(new Runnable() {

			@Override
			public void run() {
				if (arguments!=null) {
					// Simplistic approach for now
					for (int i=0; i<arguments.length; ++i) {
						OperationArgument operationArgument = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createOperationArgument();
						operationArgument.setMasked(maskedArguments[i]);
						if (arguments[i]!=null) {
							operationArgument.setType(typeName(arguments[i].getClass()));
							if (argumentBoxers[i] != null) {
								operationArgument.setValue(argumentBoxers[i].box(resolveModel(arguments[i], objectMap), context));
							}
						}
						model.getArguments().add(operationArgument);
					}
				}
				if (result!=null) {
					OperationArgument operationArgument = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createOperationArgument();
					operationArgument.setMasked(operation.getAnnotation(Mask.class)!=null);
					operationArgument.setType(typeName(result.getClass()));
					if (resultBoxer != null) {
						operationArgument.setValue(resultBoxer.box(resolveModel(result, objectMap), context));
					}
					model.getArguments().add(operationArgument);
				}
			}
			
		});
		if (instanceAlias!=null) {
			model.setInstanceAlias(instanceAlias);
		}
		if (hasOwnFailure()) {
			if (isFailure()) {
				model.setFailure(toModel(getRootCause()));
			} else {
				model.setError(toModel(getRootCause()));				
			}
		}
		
		if (isPending()) {
			model.setStatus(OperationStatus.PENDING);
		} else if (isFailure()) {
			model.setStatus(OperationStatus.FAIL);
		} else if (getFailure()!=null) {
			model.setStatus(OperationStatus.ERROR);
		} else {
			model.setStatus(OperationStatus.PASS);
		}
		
		model.setStart(start);
		model.setFinish(finish);
		
		// Root results write master screenshots to the collector
		for (ScreenshotEntry se: screenshots) {	
			if (se!=null && !objectMap.containsKey(se.getMaster())) {
				screenshotsCollector.add(se.getMaster().toScreenshotModel(screenshotsDir, objectMap));
			}
		}
				
		for (ScreenshotEntry se: screenshots) {
			if (se!=null) {
				model.getScreenshots().add(se.toScreenshotEntryModel(objectMap));
			}
		}
		
		extraModelInfo(model);
	
		for (OperationResult<?,?> child: getChildren()) {
			org.nasdanika.webtest.model.OperationResult childModel = child.toModel(
					screenshotsCollector, 
					screenshotsDir, 
					objectMap,
					context,
					executor);
			if (childModel!=null) {
				model.getChildren().add(childModel);
			}
		}
		return model;
	}
	
	protected abstract M createModel();
	
	@Override
	public boolean isInstance(Object obj) {
		return obj == target;
	}

	@Override
	public String publish(
			Directory directory, 
			boolean publishPerformance, 
			Map<Object, String> idMap,
			DirectoryPublishMonitor monitor) throws Exception {
		
//		String path = "operations/"+"TODO - operation class, . to /, then method name with ___ and parameter types separated by _";
//		
//		if (monitor!=null) {
//			monitor.onPublishing("Operation Result "+getOperationName(), path);
//		}
//		HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
//		pConnection.setRequestMethod("POST");
//		pConnection.setDoOutput(true);
//		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
//		try (Writer w = new OutputStreamWriter(new GZIPOutputStream(pConnection.getOutputStream()))) {
//			toJSON(publishPerformance, idMap).write(w);
//		}
//		int responseCode = pConnection.getResponseCode();
//		if (responseCode==HttpURLConnection.HTTP_OK) {
//			id = pConnection.getHeaderField("ID");
//			idMap.put(this, id);
//			String location = pConnection.getHeaderField("Location");
//	
//			if (parent==null) {
//				URL methodResultsURL= new URL(location+"/screenshots");
//				for (ScreenshotEntry se: allScreenshots()) {
//					se.publish(methodResultsURL, securityToken, publishPerformance, idMap, monitor);				
//				}
//			}
//	
//			URL childrenURL= new URL(location+"/children");
//			for (OperationResult<?,?> child: getChildren()) {
//				child.publish(childrenURL, securityToken, publishPerformance, idMap, monitor);				
//			}
//			
//			// --- Update non-containing references ---
//			if (parent==null && (afterScreenshot!=null || beforeScreenshot!=null)) {
//				HttpURLConnection uConnection = (HttpURLConnection) new URL(location).openConnection();
//				uConnection.setRequestMethod("PUT");
//				uConnection.setDoOutput(true);
//				uConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
//				JSONObject uData = new JSONObject();
//				if (afterScreenshot!=null) {
//					String sid = idMap.get(afterScreenshot.getMaster());
//					if (sid==null) {
//						throw new IllegalStateException("Screenshot ID not found in ID map");
//					}
//					uData.put("afterScreenshot", sid);
//				}
//				if (beforeScreenshot!=null) {
//					String sid = idMap.get(beforeScreenshot.getMaster());
//					if (sid==null) {
//						throw new IllegalStateException("Screenshot ID not found in ID map");
//					}
//					uData.put("beforeScreenshot", sid);
//				}
//				try (Writer w = new OutputStreamWriter(uConnection.getOutputStream())) {
//					uData.write(w);
//				}
//				if (uConnection.getResponseCode()!=HttpURLConnection.HTTP_OK) {
//					throw new PublishException(uConnection.getURL()+" error: "+uConnection.getResponseCode()+" "+uConnection.getResponseMessage());
//				}				
//			}					
//			// ---
//		} else {
//			throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
//		}
		throw new UnsupportedOperationException("TODO!");
	}				
		
}
