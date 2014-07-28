package org.nasdanika.webtest;

import java.lang.reflect.Method;

/**
 * Contains results of actor method execution.
 * @author Pavel Vlasov
 *
 */
class ActorMethodResult extends MethodResult {

	ActorMethodResult(String id, Method method, MethodResult parent) {
		super(id, method, parent);
	}

}
