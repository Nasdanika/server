package org.nasdanika.webtest;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

/**
 * Collects 
 * @author Pavel Vlasov
 *
 */
public interface Collector<D extends WebDriver> extends AutoCloseable {
	
	void onPageProxying(Page<D> page);
		
	void beforePageInitialization(Class<? extends Page<D>> pageClass, byte[] screenshot, JSONObject performanceData);
	
	void afterPageInitialization(Class<? extends Page<D>> pageClass, Page<D> page, byte[] screenshot, JSONObject performanceData, Throwable th);

	void beforePageMethod(Page<D> page, byte[] screenshot, JSONObject performanceData, Method method, Object[] args);
	
	void afterPageMethod(Page<D> page, byte[] screenshot, JSONObject performanceData, Method method, Object[] args, Object result, Throwable th);

	void onActorProxying(Actor<D> actor);
	
	void beforeActorMethod(Actor<D> actor, byte[] screenshot, JSONObject performanceData, Method method, Object[] args);
	
	void afterActorMethod(Actor<D> actor, byte[] screenshot, JSONObject performanceData, Method method, Object[] args, Object result, Throwable th);
	
	void beforeTestMethod(Method method, int index, Object[] parameters);
	
	/**
	 * Invoked on explicit "DUING" screenshots.
	 * @param screenshot
	 * @param comment
	 */
	void onScreenshot(byte[] screenshot, String comment);
	
	/**
	 * Sets a reference to test instance.
	 * @param test
	 */
	void setTest(Object test);
	
	void beforeTestMethodScreenshot(byte[] screenshot, JSONObject performanceData);
	
	void afterTestMethod(Method method, Throwable th);
	
	void afterTestMethodScreenshot(byte[] screenshot, JSONObject performanceData);
	
	/**
	 * @return Method for methods, Class for constructors.
	 */
	AnnotatedElement getCurrentOperation();

	void setPending();

	void setUnsupportedParameterValue();
		
}