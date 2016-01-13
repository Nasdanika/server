package org.nasdanika.webtest;

import java.lang.reflect.Method;

/**
 * Contains results of actor method execution.
 * @author Pavel Vlasov
 *
 */
public abstract class MethodResult<M extends org.nasdanika.webtest.model.MethodResult> extends OperationResult<Method, M> {

	MethodResult(String id, Method method, Object[] arguments, OperationResult<?,?> parent) {
		super(id, method, arguments, parent);
	}
	
	@Override
	protected String getOperationName() {
		return operation.getName();
	};

}
