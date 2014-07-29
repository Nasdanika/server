package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestResult implements Collector {

	private File screenshotsDir;
	private Executor screenshotExecutor;

	private AtomicLong counter;
	final Class<?> klass;	
	final String id;

	TestResult(Class<?> klass, AtomicLong counter, File screenshotsDir, Executor screenshotExecutor) throws IOException {
		this.klass = klass;
		this.counter = counter;
		id = Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
		this.screenshotsDir = screenshotsDir;
		this.screenshotExecutor = screenshotExecutor;
	}
	
	private ScreenshotEntry currentScreenshot;
		
	private ScreenshotEntry takeScreenshot(MethodResult methodResult) {
		if (test instanceof WebTest) {
			WebDriver webDriver = ((WebTest) test).getWebDriver();
			if (webDriver!=null) {
				try {
					//new WebDriverWait(webDriver, 10); - TODO - waits from annotations???
			        ScreenshotEntry ret = new ScreenshotEntry(methodResult, currentScreenshot, screenshotsDir, Long.toString(counter.incrementAndGet(), Character.MAX_RADIX), ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
			        currentScreenshot = ret;
					screenshotExecutor.execute(ret);
					return ret;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	Map<Class<? extends Actor>, ActorResult> actors = new HashMap<>();
	Map<Class<? extends Page>, PageResult> pages = new HashMap<>();

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
	
	final List<TestMethodResult> testMethodResults = new ArrayList<>();
	
	private MethodResult currentMethodResult;
	private Object test;
	
	@Override
	public void beforeActorMethod(Actor actor, Method method, Object[] args) {
		ActorMethodResult amr = new ActorMethodResult(Long.toString(counter.incrementAndGet(), Character.MAX_RADIX),method, currentMethodResult);
		actors.get(actor.getClass()).results.add(amr);
		currentMethodResult = amr;
		amr.beforeScreenshot = takeScreenshot(amr);
	}
	@Override
	public void afterActorMethod(Actor actor, Method method, Object[] args,	Object result, Throwable th) {
		if (currentMethodResult instanceof ActorMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = takeScreenshot(currentMethodResult);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	@Override
	public void beforePageMethod(Page page, Method method, Object[] args) {
		PageMethodResult pmr = new PageMethodResult(Long.toString(counter.incrementAndGet(), Character.MAX_RADIX),method, currentMethodResult);
		pages.get(page.getClass()).results.add(pmr);
		currentMethodResult = pmr;
		pmr.beforeScreenshot = takeScreenshot(pmr);
	}
	@Override
	public void afterPageMethod(Page page, Method method, Object[] args, Object result, Throwable th) {
		if (currentMethodResult instanceof PageMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = takeScreenshot(currentMethodResult);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	
	@Override
	public void beforeTestMethod(Object test, Method method) {
		currentMethodResult = new TestMethodResult(Long.toString(counter.incrementAndGet(), Character.MAX_RADIX),method, currentMethodResult);
		testMethodResults.add((TestMethodResult) currentMethodResult);
		currentMethodResult.beforeScreenshot = takeScreenshot(currentMethodResult);
		this.test = test;		
	}
	@Override
	public void afterTestMethod(Object test, Method method, Throwable th) {
		if (currentMethodResult instanceof TestMethodResult && method.equals(currentMethodResult.method)) {
			currentMethodResult.failure = th;
			currentMethodResult.finish = System.currentTimeMillis();
			currentMethodResult.afterScreenshot = takeScreenshot(currentMethodResult);
			currentMethodResult = currentMethodResult.parent;
		} else {
			throw new IllegalStateException("Stack corruption - unexpected current method: "+currentMethodResult);
		}
	}
	
	/**
	 * 
	 * @return successes, failures, pending.
	 */
	int[] getStats() {
		int[] ret = {0, 0, 0};
		for (TestMethodResult tmr: testMethodResults) {
			if (tmr.failure==null) {
				ret[tmr.isPending() ? 2 : 0]++;
			} else {
				ret[1]++;
			}
		}
		return ret;
	}

}
