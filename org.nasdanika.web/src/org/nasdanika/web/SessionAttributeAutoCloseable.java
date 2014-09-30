package org.nasdanika.web;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Wraps autocloseable, closes autocloseable when attribute is unbound.
 * @author Pavel Vlasov
 *
 */
public class SessionAttributeAutoCloseable<T> implements HttpSessionBindingListener {

	private T target;

	public SessionAttributeAutoCloseable(T target) {
		this.target = target;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// NOP
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		if (target instanceof AutoCloseable) {
			try {
				((AutoCloseable) target).close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public T get() {
		return target;
	}

}
