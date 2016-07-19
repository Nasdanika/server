package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
import org.nasdanika.webtest.model.ModelFactory;
import org.openqa.selenium.WebDriver;

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
		
	private ScreenshotEntry createScreenshotEntry(OperationResult<?,?> operationResult, byte[] screenshot, Screenshot.When when) {
		if (screenshot==null || screenshotsDir==null) {
			return null;
		}
        ScreenshotEntry ret = new ScreenshotEntry(
        		operationResult, 
        		when,
        		currentScreenshot, 
        		screenshotsDir, 
        		idGenerator.genId(operationResult.getOperation().toString(), when.name()), 
        		screenshot);
        currentScreenshot = ret;
		screenshotExecutor.execute(ret);
		return ret;
	}
	
	Map<String, ActorResult> actors = new HashMap<>();
	Map<String, PageResult> pages = new HashMap<>();
	
	public Collection<ActorResult> getActorResults() {
		return actors.values();
	}
	
	public Collection<PageResult> getPageResults() {
		return pages.values();
	}
	
	private void onPageClass(Class<? extends Page<WebDriver>> pageClass, List<Field> webElements, String title) {
		String pageKey = pageClass.getName();
		if (Proxy.isProxyClass(pageClass) && title!=null) {
			pageKey+=":"+title;
		}
		if (!pages.containsKey(pageKey)) {
			pages.put(pageKey, new PageResult(pageClass, webElements, title));
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onPageProxying(Page<WebDriver> page) {		
		Class<? extends Page<WebDriver>> pageClass = (Class<? extends Page<WebDriver>>) page.getClass();
		if (Proxy.isProxyClass(pageClass) && Proxy.getInvocationHandler(page) instanceof MixInInvocationHandler) {
			onPageClass(pageClass, page.webElements(), ((MixInInvocationHandler<?, ?>) Proxy.getInvocationHandler(page)).getTitle());
		} else {
			onPageClass(pageClass, page.webElements(), pageClass.getAnnotation(Title.class)==null ? null : pageClass.getAnnotation(Title.class).value());
		}				
	}
	
	private void onActorClass(Class<? extends Actor<WebDriver>> actorClass, String title) {
		String actorKey = actorClass.getName();
		if (Proxy.isProxyClass(actorClass) && title!=null) {
			actorKey+=":"+title;
		}
		if (!actors.containsKey(actorKey)) {
			actors.put(actorKey, new ActorResult(actorClass, title));
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onActorProxying(Actor<WebDriver> actor) {
		Class<? extends Actor<WebDriver>> actorClass = (Class<? extends Actor<WebDriver>>) actor.getClass();
		if (Proxy.isProxyClass(actorClass) && Proxy.getInvocationHandler(actor) instanceof MixInInvocationHandler) {
			onActorClass(actorClass, ((MixInInvocationHandler<?, ?>) Proxy.getInvocationHandler(actor)).getTitle());
		} else {
			onActorClass(actorClass, actorClass.getAnnotation(Title.class)==null ? null : actorClass.getAnnotation(Title.class).value());
		}										
	}
	
	/**
	 * @return Page or Actor object key
	 */
	private static String getObjectKey(Object obj) {
		if (Proxy.isProxyClass(obj.getClass()) && Proxy.getInvocationHandler(obj) instanceof MixInInvocationHandler) {
			String title = ((MixInInvocationHandler<?,?>) Proxy.getInvocationHandler(obj)).getTitle();
			return title==null || title.trim().length()==0 ? obj.getClass().getName() : obj.getClass().getName()+":"+title;
		}
		return obj.getClass().getName();
	}
	
	private final List<TestMethodResult> testMethodResults = new ArrayList<>();
	
	public List<TestMethodResult> getTestMethodResults() {
		return testMethodResults;
	}
	
	private OperationResult<?,?> currentOperationResult;
	
	@Override
	public void beforeActorMethod(Actor<WebDriver> actor, byte[] screenshot, JSONObject performance, Method method, Object[] args) {
		ActorMethodResult amr = new ActorMethodResult(
				idGenerator.genId(method.toString(), null),
				method,
				args,
				currentOperationResult);
		actors.get(getObjectKey(actor)).results.add(amr);
		currentOperationResult = amr;
		amr.screenshots.add(createScreenshotEntry(amr, screenshot, Screenshot.When.BEFORE));
		amr.beforePerformance = performance;
	}
	
	@Override
	public void afterActorMethod(Actor<WebDriver> actor, byte[] screenshot, JSONObject performance, Method method, Object[] args, Object result, Throwable th) {
		if (currentOperationResult instanceof ActorMethodResult && method.equals(currentOperationResult.operation)) {
			currentOperationResult.setInstance(actor);
			currentOperationResult.failure = th;
			currentOperationResult.result = result;			
			currentOperationResult.finish = System.currentTimeMillis();
			currentOperationResult.screenshots.add(createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER));
			currentOperationResult.afterPerformance = performance;
			currentOperationResult = currentOperationResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentOperationResult);
		}
	}
	
	@Override
	public void beforePageInitialization(Class<? extends Page<WebDriver>> pageClass, byte[] screenshot, JSONObject performance) {
		onPageClass(pageClass, WebTestUtil.webElements(pageClass), pageClass.getAnnotation(Title.class)==null ? null : pageClass.getAnnotation(Title.class).value());
		InitializationResult pir = new InitializationResult(
				idGenerator.genId(pageClass.getName(), "_init"),
				pageClass, 
				currentOperationResult);
		pages.get(pageClass.getName()).results.add(pir);
		currentOperationResult = pir;
		pir.screenshots.add(createScreenshotEntry(pir, screenshot, Screenshot.When.BEFORE));
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
			currentOperationResult.screenshots.add(createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER));
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
		pages.get(getObjectKey(page)).results.add(pmr);
		currentOperationResult = pmr;
		pmr.screenshots.add(createScreenshotEntry(pmr, screenshot, Screenshot.When.BEFORE));
		pmr.beforePerformance = performance;
	}
	@Override
	public void afterPageMethod(Page<WebDriver> page, byte[] screenshot, JSONObject performance, Method method, Object[] args, Object result, Throwable th) {
		if (currentOperationResult instanceof PageMethodResult && method.equals(currentOperationResult.operation)) {
			currentOperationResult.setInstance(page);
			currentOperationResult.failure = th;
			currentOperationResult.result = result;
			currentOperationResult.finish = System.currentTimeMillis();
			currentOperationResult.screenshots.add(createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER));
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
		currentOperationResult.screenshots.add(createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.BEFORE));	
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
		currentOperationResult.screenshots.add(createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.AFTER));
		currentOperationResult.afterPerformance = performance;
	}
	
	@Override
	public AnnotatedElement getCurrentOperation() {
		return currentOperationResult == null ? null : currentOperationResult.operation;
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

	@Override
	public void setTest(Object test) {
		currentOperationResult.setTarget(test);
	}
		
	@Override
	public void publish(
			URL url, 
			String securityToken, 
			boolean publishPerformance,
			Map<Object, String> idMap, 
			PublishMonitor monitor) throws Exception {
		
		if (monitor!=null) {
			monitor.onPublishing("Test Class Result "+getTestClass().getName(), url);
		}
		if (getTestMethodResults().isEmpty() && getActorResults().isEmpty() && getPageResults().isEmpty()) {
			return; // No reason to publish.
		}
		HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
		pConnection.setRequestMethod("POST");
		pConnection.setDoOutput(true);
		pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
		JSONObject data = new JSONObject();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToJSON(getTestClass(), data);
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
				mr.publish(methodResultsURL, securityToken, publishPerformance, idMap, monitor);				
			}

			URL pageResultsURL= new URL(location+"/pageResults");
			for (PageResult pr: getPageResults()) {
				pr.publish(pageResultsURL, securityToken, publishPerformance, idMap, monitor);				
			}

			URL actorResultsURL= new URL(location+"/actorResults");
			for (ActorResult ar: getActorResults()) {
				ar.publish(actorResultsURL, securityToken, publishPerformance, idMap, monitor);				
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


	@Override
	public String publish(
			Directory directory, 
			boolean publishPerformance, 
			Map<Object, String> idMap,
			DirectoryPublishMonitor monitor) throws Exception {
		
		throw new UnsupportedOperationException("TODO!");
	}

	@Override
	public void onScreenshot(byte[] screenshot, String comment) {
		if (currentOperationResult!=null) {
			ScreenshotEntry se = createScreenshotEntry(currentOperationResult, screenshot, Screenshot.When.DURING);
			se.setComment(comment);
			currentOperationResult.screenshots.add(se);
		}
	}

	@Override
	public org.nasdanika.webtest.model.TestResult toModel(List<org.nasdanika.webtest.model.Screenshot> screenshotsCollector, File screenshotsDir, Map<Object, Object> objectMap) {		
		if (getTestMethodResults().isEmpty() && getActorResults().isEmpty() && getPageResults().isEmpty()) {
			return null; 
		}
		ModelFactory modelFactory = org.nasdanika.webtest.model.ModelFactory.eINSTANCE;
		org.nasdanika.webtest.model.TestClassResult testResult = modelFactory.createTestClassResult();
		WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToDescriptor(getTestClass(), testResult);
		
		for (Entry<TestStatus, Integer> ce: getStats().entrySet()) {
			testResult.getStats().put(ce.getKey().toString(), ce.getValue());
		}
		objectMap.put(this, testResult);
		for (TestMethodResult mr: getTestMethodResults()) {
			org.nasdanika.webtest.model.TestMethodResult mrModel = mr.toModel(screenshotsCollector, screenshotsDir, objectMap);
			if (mrModel!=null) {
				testResult.getMethodResults().add(mrModel);
			}				
		}
		for (PageResult pr: getPageResults()) {
			org.nasdanika.webtest.model.PageResult prModel = pr.toModel(screenshotsDir, objectMap);
			if (prModel!=null) {
				testResult.getPageResults().add(prModel);
			}
		}

		for (ActorResult ar: getActorResults()) {
			org.nasdanika.webtest.model.ActorResult arModel = ar.toModel(screenshotsDir, objectMap);
			if (arModel!=null) {
				testResult.getActorResults().add(arModel);
			}
		}
		return testResult;
	}
	
}
