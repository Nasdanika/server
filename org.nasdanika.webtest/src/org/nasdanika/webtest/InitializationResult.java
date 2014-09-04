package org.nasdanika.webtest;

import org.nasdanika.html.HTMLFactory.Glyphicon;

/**
 * Contains results of actor method execution.
 * @author Pavel Vlasov
 *
 */
public class InitializationResult extends OperationResult<Class<?>> {

	InitializationResult(String id, Class<?> klass, OperationResult<?> parent) {
		super(id, klass, null, parent);
	}
	
	public String getName() {
		return operation.getName()+"::init";
	}
	
	@Override
	Glyphicon getGlyphicon() {
		return Glyphicon.asterisk;
	}

}
