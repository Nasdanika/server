package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.nasdanika.html.Bootstrap.Glyphicon;

/**
 * Contains results of actor method execution.
 * @author Pavel Vlasov
 *
 */
public class ActorMethodResult extends MethodResult<org.nasdanika.webtest.model.ActorMethodResult> {

	ActorMethodResult(String id, Method method, Object[] arguments, OperationResult<?,?> parent) {
		super(id, method, arguments, parent);
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.user;
	}

	@Override
	protected org.nasdanika.webtest.model.ActorMethodResult createModel() {
		return org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createActorMethodResult();
	}

}
