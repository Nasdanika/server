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
import java.util.concurrent.atomic.AtomicLong;

public class TestClassResult implements Collector, TestResult {

	private File screenshotsDir;
	private Executor screenshotExecutor;

	private AtomicLong counter;
	final Class<?> klass;	
	final String id;
	
	public Class<?> getTestClass() {
		return klass;
	}
	
	public String getId() {
		return id;
	}

	TestClassResult(Class<?> klass, AtomicLong counter, File screenshotsDir, Executor screenshotExecutor) throws IOException {
		this.klass = klass;
		this.counter = counter;
		id = Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
		this.screenshotsDir = screenshotsDir;
		this.screenshotExecutor = screenshotExecutor;
	}
	
	private ScreenshotEntry currentScreenshot;
		
	private ScreenshotEntry createScreenshotEntry(MethodResult methodResult, byte[] screenshot) {
        ScreenshotEntry ret = new ScreenshotEntry(
        		methodResult, 
        		currentScreenshot, 
        		screenshotsDir, 
        		Long.toString(counter.incrementAndGet(), Character.MAX_RADIX), 
        		screenshot);
        currentScreenshot = ret;
		screenshotExecutor.execute(ret);
		return ret;
	}
	
	Map<Class<? extends Actor>, ActorResult> actors = new HashMap<>();
	Map<Class<? extends Page>, PageResult> pages = new HashMap<>();
	
	public Collection<ActorResult> getActorResults() {
		return actors.values();
	}
	
	public Collection<PageResult> getPageResults() {
		return pages.values();
	}	

	@Override
	public void onPageProxying(Page page) {
		Class<? extends Page> pageClass = page.getClass();
		if (!pages.containsKey(pageClass)) {
			pages.put(pageClass, new PageResult(pageClass));
		}		
	}
	@Override
	public void onActorProxying(Actor actor) {
		Class<? extends Actor> actorClass = actor.getClass();
		if (!actors.containsKey(actorClass)) {
			actors.put(actorClass, new ActorResult(actorClass));
		}		
	}
	
	private final List<TestMethodResult> testMethodResults = new ArrayList<>();
	
	public List<TestMethodResult> getTestMethodResults() {
		return testMethodResults;
	}
	
	private MethodResult currentMethodResult;
	
	@Override
	public void beforeActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args) {
		ActorMethodResult amr = new ActorMethodResult(
				Long.toString(counter.incrementAndGet(), Character.MAX_RADIX),
				method,
				args,
				currentMethodResult);
		actors.get(actor.getClass()).results.add(amr);
		currentMethodResult = amr;
		amr.beforeScreenshot = createScreenshotEntry(amr, screenshot);
	}
	@Override
	public void afterActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args,	Object result, Throwable th) {
		if (currentMethodResult instanceof ActorMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = createScreenshotEntry(currentMethodResult, screenshot);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	@Override
	public void beforePageMethod(Page page, byte[] screenshot, Method method, Object[] args) {
		PageMethodResult pmr = new PageMethodResult(
				Long.toString(counter.incrementAndGet(), Character.MAX_RADIX),
				method,
				args,
				currentMethodResult);
		pages.get(page.getClass()).results.add(pmr);
		currentMethodResult = pmr;
		pmr.beforeScreenshot = createScreenshotEntry(pmr, screenshot);
	}
	@Override
	public void afterPageMethod(Page page, byte[] screenshot, Method method, Object[] args, Object result, Throwable th) {
		if (currentMethodResult instanceof PageMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = createScreenshotEntry(currentMethodResult, screenshot);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	
	@Override
	public void beforeTestMethod(Method method, Object[] parameters) {
		currentMethodResult = new TestMethodResult(
				Long.toString(counter.incrementAndGet(), Character.MAX_RADIX),
				method, 
				null,
				currentMethodResult,
				parameters);
		testMethodResults.add((TestMethodResult) currentMethodResult);
	}
	
	@Override
	public void beforeTestMethodScreenshot(byte[] screenshot) {
		currentMethodResult.beforeScreenshot = createScreenshotEntry(currentMethodResult, screenshot);		
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
		currentMethodResult.afterScreenshot = createScreenshotEntry(currentMethodResult, screenshot);
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
