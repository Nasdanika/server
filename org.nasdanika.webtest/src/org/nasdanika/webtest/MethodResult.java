package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.nasdanika.html.HTMLFactory.Glyphicon;

/**
 * Contains results of actor method execution.
 * @author Pavel Vlasov
 *
 */
public class MethodResult extends OperationResult<Method> {

	MethodResult(String id, Method method, Object[] arguments, OperationResult<?> parent) {
		super(id, method, arguments, parent);
	}
	
	public String getName() {
		return operation.getName();
	};

}
