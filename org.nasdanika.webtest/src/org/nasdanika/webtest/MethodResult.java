package org.nasdanika.webtest;

import java.lang.reflect.Method;

/**
 * Contains results of actor method execution.
 * @author Pavel Vlasov
 *
 */
public class MethodResult extends OperationResult<Method> {

	MethodResult(String id, Method method, Object[] arguments, OperationResult<?> parent) {
		super(id, method, arguments, parent);
	}
	
	@Override
	protected String getOperationName() {
		return operation.getName();
	};

}
