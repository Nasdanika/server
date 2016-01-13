package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.nasdanika.html.Bootstrap.Glyphicon;

/**
 * Contains results of page method execution.
 * @author Pavel Vlasov
 *
 */
public class PageMethodResult extends MethodResult<org.nasdanika.webtest.model.PageMethodResult> {

	PageMethodResult(String id, Method method, Object[] arguments, OperationResult<?,?> parent) {
		super(id, method, arguments, parent);
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.list_alt;
	}

	@Override
	protected org.nasdanika.webtest.model.PageMethodResult createModel() {
		return org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createPageMethodResult();
	}

}
