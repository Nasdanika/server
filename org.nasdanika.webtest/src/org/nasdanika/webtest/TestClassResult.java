package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.Executor;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestClassResult implements Collector<WebDriver>, TestResult {

	private File screenshotsDir;
	private Executor screenshotExecutor;

	private IdGenerator idGenerator;
	final Class<?> klass;	
	private String id;
	
	public Class<?> getTestClass() {
		return klass;
	}
	
	public String getId() {
		return id;
	}

	TestClassResult(Class<?> klass, IdGenerator idGenerator, int idx, File screenshotsDir, Executor screenshotExecutor) throws IOException {
		this.klass = klass;
		this.idGenerator = idGenerator;
		id = idGenerator.genId(klass.getName(), idx==-1 ? null : Integer.toString(idx, Character.MAX_RADIX));
		this.screenshotsDir = screenshotsDir;
		this.screenshotExecutor = screenshotExecutor;
	}
	
	private ScreenshotEntry currentScreenshot;
		
	private ScreenshotEntry createScreenshotEntry(OperationResult<?> operationResult, byte[] screenshot, Screenshot.When when) {
		if (screenshot==null) {
			return null;
		}
        ScreenshotEntry ret = new ScreenshotEntry(
        		operationResult, 
        		currentScreenshot, 
        		screenshotsDir, 
        		idGenerator.genId(operationResult.getOperation().toString(), when.name()), 
        		screenshot);
        currentScreenshot = ret;
		screenshotExecutor.execute(ret);
		return ret;
	}
	
	Map<Class<? extends Actor<WebDriver>>, ActorResult> actors = new HashMap<>();
	Map<Class<? extends Page<WebDriver>>, PageResult> pages = new HashMap<>();
	
	public Collection<ActorResult> getActorResults() {
		return actors.values();
	}
	
	public Collection<PageResult> getPageResults() {
		return pages.values();
	}
	
	private void onPageClass(Class<? extends Page<WebDriver>> pageClass, int size) {
		if (!pages.containsKey(pageClass)) {
			pages.put(pageClass, new PageResult(pageClass, size));
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onPageProxying(Page<WebDriver> page) {
		onPageClass((Class<? extends Page<WebDriver>>) page.getClass(), page.size());
	}
	
	private void onActorClass(Class<? extends Actor<WebDriver>> actorClass) {
		if (!actors.containsKey(actorClass)) {
			actors.put(actorClass, new ActorResult(actorClass));
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onActorProxying(Actor<WebDriver> actor) {
		onActorClass((Class<? extends Actor<WebDriver>>) actor.getClass());
	}
	
	private final List<TestMethodResult> testMethodResults = new ArrayList<>();
	
	public List<TestMethodResult> getTestMethodResults() {
		return testMethodResults;
	}
	
	private OperationResult<?> currentOperationResult;
	
	@Override
	public void beforeActorMethod(Actor<WebDriver> actor, byte[] screenshot, JSONObject performance, Method method, Object[] args) {
		ActorMethodResult amr = new ActorMethodResult(
				idGenerator.genId(method.toString(), null),
				method,
				args,
				currentOperationResult);
		actors.get(actor.getClass()).results.add(amr);
		currentOperationResult = amr;
		amr.beforeScreenshot = createScreenshotEntry(amr, screenshot, Screenshot.When.BEFORE);
		amr.beforePerformance = performance;
	}
	@Override
	public void afterActorMethod(Actor<WebDriver> actor, byte[] screenshot, JSONObject performance, Method method, Object[] args,	Object result, Throwable th) {
		if (currentOperationResult instanceof ActorMethodResult && method.equals(currentOperationResult.operation)) {
			currentOperationResult.failure = th;
			currentOperationResult.finish = System.currentTimeMillis();
			currentOperationResult.afterScreenshot = createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER);
			currentOperationResult.afterPerformance = performance;
			currentOperationResult = currentOperationResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentOperationResult);
		}
	}
	
	@Override
	public void beforePageInitialization(Class<? extends Page<WebDriver>> pageClass, byte[] screenshot, JSONObject performance) {
		int size = 0;
		for (Class<?> cls = pageClass; cls!=null; cls = cls.getSuperclass()) {
			for (Field field: cls.getDeclaredFields()) {
				if (WebElement.class.isAssignableFrom(field.getType())) {
					++size;
				} 
			}
		}
		onPageClass(pageClass, size);
		InitializationResult pir = new InitializationResult(
				idGenerator.genId(pageClass.getName(), "_init"),
				pageClass, 
				currentOperationResult);
		pages.get(pageClass).results.add(pir);
		currentOperationResult = pir;
		pir.beforeScreenshot = createScreenshotEntry(pir, screenshot, Screenshot.When.BEFORE);
		pir.beforePerformance = performance;
	}
	@Override
	public void afterPageInitialization(
			Class<? extends Page<WebDriver>> pageClass, 
			Page<WebDriver> page,
			byte[] screenshot, 
			JSONObject performance, 
			Throwable th) {
		if (currentOperationResult instanceof InitializationResult && pageClass.equals(currentOperationResult.operation)) {
			currentOperationResult.failure = th;
			currentOperationResult.finish = System.currentTimeMillis();
			currentOperationResult.afterScreenshot = createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER);
			currentOperationResult.afterPerformance = performance;
			currentOperationResult = currentOperationResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentOperationResult);
		}
	}
	@Override
	public void beforePageMethod(Page<WebDriver> page, byte[] screenshot, JSONObject performance, Method method, Object[] args) {
		PageMethodResult pmr = new PageMethodResult(
				idGenerator.genId(method.toString(), null),
				method,
				args,
				currentOperationResult);
		pages.get(page.getClass()).results.add(pmr);
		currentOperationResult = pmr;
		pmr.beforeScreenshot = createScreenshotEntry(pmr, screenshot, Screenshot.When.BEFORE);
		pmr.beforePerformance = performance;
	}
	@Override
	public void afterPageMethod(Page<WebDriver> page, byte[] screenshot, JSONObject performance, Method method, Object[] args, Object result, Throwable th) {
		if (currentOperationResult instanceof PageMethodResult && method.equals(currentOperationResult.operation)) {
			currentOperationResult.failure = th;
			currentOperationResult.finish = System.currentTimeMillis();
			currentOperationResult.afterScreenshot = createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER);
			currentOperationResult.afterPerformance = performance;
			currentOperationResult = currentOperationResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentOperationResult);
		}
	}
	
	@Override
	public void beforeTestMethod(Method method, int index, Object[] parameters) {
		currentOperationResult = new TestMethodResult(
				idGenerator.genId(method.toString(), null),
				method, 
				null,
				currentOperationResult,
				index,
				parameters);
		testMethodResults.add((TestMethodResult) currentOperationResult);
	}
	
	@Override
	public void beforeTestMethodScreenshot(byte[] screenshot, JSONObject performance) {
		currentOperationResult.beforeScreenshot = createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.BEFORE);	
		currentOperationResult.beforePerformance = performance;
	}
	
	@Override
	public void afterTestMethod(Method method, Throwable th) {
		if (currentOperationResult instanceof TestMethodResult && method.equals(currentOperationResult.operation)) {
			currentOperationResult.failure = th;
			currentOperationResult.finish = System.currentTimeMillis();
			currentOperationResult = currentOperationResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentOperationResult);
		}
	}
	
	@Override
	public void afterTestMethodScreenshot(byte[] screenshot, JSONObject performance) {
		currentOperationResult.afterScreenshot = createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER);
		currentOperationResult.afterPerformance = performance;
	}
		
	@Override
	public Map<TestStatus, Integer> getStats() {
		Map<TestStatus, Integer> ret = new TreeMap<>();
		for (TestStatus ts: TestStatus.values()) {
			ret.put(ts, 0);
		}
		for (TestMethodResult tmr: testMethodResults) {
			TestStatus status;
			if (tmr.failure==null) {
				status = tmr.isPending() ? TestStatus.Pending : TestStatus.Pass;
			} else {
				status = tmr.isFailure() ? TestStatus.Fail : TestStatus.Error;
			}
			ret.put(status, ret.get(status)+1);
		}
		return ret;
	}
				
	@Override
	public void close() throws Exception {
		// NOP		
	}
//
//	@Override
//	public String getName() {
//		return ReportGenerator.classTitle(klass);
//	}
//
//	@Override
//	public String getDescription() {
//		Description description = klass.getAnnotation(Description.class);
//		if (description==null) {
//			return "";
//		} 
//		
//		if (description.html()) {
//			StringBuilder sb = new StringBuilder();
//			for (String str: description.value()) {
//				if (sb.length()>0) {
//					sb.append(" ");
//				}
//				sb.append(str);
//			}
//			return sb.toString();
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (String str: description.value()) {
//			if (sb.length()>0) {
//				sb.append(System.lineSeparator());
//			}
//			sb.append(StringEscapeUtils.escapeHtml4(str));
//		}
//		return "<pre>"+sb.append("</pre>");			
//	}

	@Override
	public void setTest(Object test) {
		currentOperationResult.setTarget(test);
	}
		
	@Override
	public void publish(URL url, String securityToken, Map<Object, String> idMap, PublishMonitor monitor) throws Exception {
		if (monitor!=null) {
			monitor.onPublishing("Test Class Result "+getTestClass().getName(), url);
		}
		HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		JSONObject data = new JSONObject();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionToJSON(getTestClass(), data);
		JSONObject stats = new JSONObject();
		data.put("stats", stats);
		for (Entry<TestStatus, Integer> ce: getStats().entrySet()) {
			stats.put(ce.getKey().toString(), ce.getValue());
		}
		data.put("type", "class");
		try (Writer w = new OutputStreamWriter(pConnection.getOutputStream())) {
			data.write(w);
		}
		int responseCode = pConnection.getResponseCode();
		if (responseCode==HttpURLConnection.HTTP_OK) {
			id = pConnection.getHeaderField("ID");
			idMap.put(this, id);
			String location = pConnection.getHeaderField("Location");

			URL methodResultsURL= new URL(location+"/methodResults");
			for (TestMethodResult mr: getTestMethodResults()) {
				mr.publish(methodResultsURL, securityToken, idMap, monitor);				
			}

			URL pageResultsURL= new URL(location+"/pageResults");
			for (PageResult pr: getPageResults()) {
				pr.publish(pageResultsURL, securityToken, idMap, monitor);				
			}

			URL actorResultsURL= new URL(location+"/actorResults");
			for (ActorResult ar: getActorResults()) {
				ar.publish(actorResultsURL, securityToken, idMap, monitor);				
			}
		} else {
			throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
		}
	}			

	@Override
	public int publishSize() {
		int ret = 1;
		for (TestMethodResult mr: getTestMethodResults()) {
			ret+=mr.publishSize();	
		}

		for (PageResult pr: getPageResults()) {
			ret+=pr.publishSize();	
		}

		for (ActorResult ar: getActorResults()) {
			ret+=ar.publishSize();	
		}
		return ret;
	}				
	
}
