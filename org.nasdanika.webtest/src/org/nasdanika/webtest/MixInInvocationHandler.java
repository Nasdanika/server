package org.nasdanika.webtest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collections;

class MixInInvocationHandler<D, T> implements InvocationHandler {
	private final D webDriver;
	private final T target;
	private String title;

	MixInInvocationHandler(D webDriver, T target, String title) {
		this.webDriver = webDriver;
		this.target = target;
		this.title = title;
	}
	
	public T getTarget() {
		return target;
	}
	
	public D getWebDriver() {
		return webDriver;
	}
	
	public String getTitle() {
		return title;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (Page.class.equals(method.getDeclaringClass())) {
			if ((args==null || args.length==0) && method.getParameterTypes().length==0) {
				if ("getWebDriver".equals(method.getName())) {
					return webDriver;
				}
				if ("webElements".equals(method.getName())) {
					return Collections.emptyList();
				}
			}
			throw new UnsupportedOperationException("Method "+method+" not supported by the proxy");
		}
		return method.invoke(target, args);
	}
}