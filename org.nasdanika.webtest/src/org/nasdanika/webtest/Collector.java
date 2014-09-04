package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

/**
 * Collects 
 * @author Pavel Vlasov
 *
 */
public interface Collector<D extends WebDriver> extends AutoCloseable {
	
	void onPageProxying(Page<D> page);
		
	void beforePageInitialization(Class<? extends Page<D>> pageClass, byte[] screenshot);
	
	void afterPageInitialization(Class<? extends Page<D>> pageClass, Page<D> page, byte[] screenshot, Throwable th);

	void beforePageMethod(Page<D> page, byte[] screenshot, Method method, Object[] args);
	
	void afterPageMethod(Page<D> page, byte[] screenshot, Method method, Object[] args, Object result, Throwable th);

	void onActorProxying(Actor<D> actor);
	
	void beforeActorMethod(Actor<D> actor, byte[] screenshot, Method method, Object[] args);
	
	void afterActorMethod(Actor<D> actor, byte[] screenshot, Method method, Object[] args, Object result, Throwable th);
	
	void beforeTestMethod(Method method, int index, Object[] parameters);
	
	/**
	 * Sets a reference to test instance.
	 * @param test
	 */
	void setTest(Object test);
	
	void beforeTestMethodScreenshot(byte[] screenshot);
	
	void afterTestMethod(Method method, Throwable th);
	
	void afterTestMethodScreenshot(byte[] screenshot);
		
}