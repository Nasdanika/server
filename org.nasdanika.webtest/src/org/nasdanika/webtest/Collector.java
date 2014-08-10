package org.nasdanika.webtest;

import java.lang.reflect.Method;

/**
 * Collects 
 * @author Pavel Vlasov
 *
 */
public interface Collector extends AutoCloseable {
	
	void onPageProxying(Page page);
	
	void beforePageMethod(Page page, byte[] screenshot, Method method, Object[] args);
	
	void afterPageMethod(Page page, byte[] screenshot, Method method, Object[] args, Object result, Throwable th);

	void onActorProxying(Actor actor);
	
	void beforeActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args);
	
	void afterActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args, Object result, Throwable th);
	
	void beforeTestMethod(Method method, Object[] parameters);
	
	/**
	 * Sets a reference to test instance.
	 * @param test
	 */
	void setTest(Object test);
	
	void beforeTestMethodScreenshot(byte[] screenshot);
	
	void afterTestMethod(Method method, Throwable th);
	
	void afterTestMethodScreenshot(byte[] screenshot);
		
}