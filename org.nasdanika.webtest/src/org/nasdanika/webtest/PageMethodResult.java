package org.nasdanika.webtest;

import java.lang.reflect.Method;

/**
 * Contains results of page method execution.
 * @author Pavel Vlasov
 *
 */
class PageMethodResult extends MethodResult {

	PageMethodResult(String id, Method method, MethodResult parent) {
		super(id, method, parent);
	}

}
