package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;

import org.openqa.selenium.WebDriver;

public class TestClassResult implements Collector<WebDriver>, TestResult {

	private File screenshotsDir;
	private Executor screenshotExecutor;

	private IdGenerator idGenerator;
	final Class<?> klass;	
	final String id;
	
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
		
	private ScreenshotEntry createScreenshotEntry(MethodResult methodResult, byte[] screenshot, Screenshot.When when) {
		if (screenshot==null) {
			return null;
		}
        ScreenshotEntry ret = new ScreenshotEntry(
        		methodResult, 
        		currentScreenshot, 
        		screenshotsDir, 
        		idGenerator.genId(methodResult.getMethod().toString(), when.name()), 
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
	
	private void onPageClass(Class<? extends Page<WebDriver>> pageClass) {
		if (!pages.containsKey(pageClass)) {
			pages.put(pageClass, new PageResult(pageClass));
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onPageProxying(Page<WebDriver> page) {
		onPageClass((Class<? extends Page<WebDriver>>) page.getClass());
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
	
	private MethodResult currentMethodResult;
	
	@Override
	public void beforeActorMethod(Actor<WebDriver> actor, byte[] screenshot, Method method, Object[] args) {
		ActorMethodResult amr = new ActorMethodResult(
				idGenerator.genId(method.toString(), null),
				method,
				args,
				currentMethodResult);
		actors.get(actor.getClass()).results.add(amr);
		currentMethodResult = amr;
		amr.beforeScreenshot = createScreenshotEntry(amr, screenshot, Screenshot.When.BEFORE);
	}
	@Override
	public void afterActorMethod(Actor<WebDriver> actor, byte[] screenshot, Method method, Object[] args,	Object result, Throwable th) {
		if (currentMethodResult instanceof ActorMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = createScreenshotEntry(currentMethodResult, screenshot, Screenshot.When.AFTER);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	@Override
	public void beforePageMethod(Page<WebDriver> page, byte[] screenshot, Method method, Object[] args) {
		PageMethodResult pmr = new PageMethodResult(
				idGenerator.genId(method.toString(), null),
				method,
				args,
				currentMethodResult);
		pages.get(page.getClass()).results.add(pmr);
		currentMethodResult = pmr;
		pmr.beforeScreenshot = createScreenshotEntry(pmr, screenshot, Screenshot.When.BEFORE);
	}
	@Override
	public void afterPageMethod(Page<WebDriver> page, byte[] screenshot, Method method, Object[] args, Object result, Throwable th) {
		if (currentMethodResult instanceof PageMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = createScreenshotEntry(currentMethodResult, screenshot, Screenshot.When.AFTER);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	
	@Override
	public void beforeTestMethod(Method method, int index, Object[] parameters) {
		currentMethodResult = new TestMethodResult(
				idGenerator.genId(method.toString(), null),
				method, 
				null,
				currentMethodResult,
				index,
				parameters);
		testMethodResults.add((TestMethodResult) currentMethodResult);
	}
	
	@Override
	public void beforeTestMethodScreenshot(byte[] screenshot) {
		currentMethodResult.beforeScreenshot = createScreenshotEntry(currentMethodResult, screenshot, Screenshot.When.BEFORE);		
	}
	
	@Override
	public void afterTestMethod(Method method, Throwable th) {
		if (currentMethodResult instanceof TestMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	
	@Override
	public void afterTestMethodScreenshot(byte[] screenshot) {
		currentMethodResult.afterScreenshot = createScreenshotEntry(currentMethodResult, screenshot, Screenshot.When.AFTER);
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
		currentMethodResult.setTarget(test);
	}

}
