package org.nasdanika.webtest;

/**
 * Implementations of this interface are injected with the proxy instance when
 * proxied. It allows to write recursive methods which will be recorded by the framework.
 * @author Pavel
 *
 * @param <T>
 */
public interface ProxyAware<T> {
	
	void setProxy(T proxy);

}
