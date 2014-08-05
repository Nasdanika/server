package org.nasdanika.webtest;

import java.lang.reflect.Method;

interface Collector {
	
	void onPageProxying(Page page);
	
	void beforePageMethod(Page page, Method method, Object[] args);
	
	void afterPageMethod(Page page, Method method, Object[] args, Object result, Throwable th);

	void onActorProxying(Actor actor);
	
	void beforeActorMethod(Actor actor, Method method, Object[] args);
	
	void afterActorMethod(Actor actor, Method method, Object[] args, Object result, Throwable th);
	
	void beforeTestMethod(Method method);
	
	void takeBeforeTestMethodScreenshot(Object test);
	
	void afterTestMethod(Method method, Throwable th);
	
	void takeAfterTestMethodScreenshot();
		
}