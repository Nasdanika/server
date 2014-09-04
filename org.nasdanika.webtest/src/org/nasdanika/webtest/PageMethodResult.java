package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.nasdanika.html.HTMLFactory.Glyphicon;

/**
 * Contains results of page method execution.
 * @author Pavel Vlasov
 *
 */
public class PageMethodResult extends MethodResult {

	PageMethodResult(String id, Method method, Object[] arguments, OperationResult<?> parent) {
		super(id, method, arguments, parent);
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.list_alt;
	}

}
