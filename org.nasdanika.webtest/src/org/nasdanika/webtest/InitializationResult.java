package org.nasdanika.webtest;

import org.nasdanika.html.Bootstrap.Glyphicon;

/**
 * Contains results of page class initialization.
 * @author Pavel Vlasov
 *
 */
public class InitializationResult extends OperationResult<Class<?>, org.nasdanika.webtest.model.InitializationResult> {

	InitializationResult(String id, Class<?> klass, OperationResult<?,?> parent) {
		super(id, klass, null, parent);
	}
	
	protected String getOperationName() {
		String oName = operation.getName();
		return oName.substring(oName.lastIndexOf('.')+1)+"::init";
	}
	
	@Override
	Glyphicon getGlyphicon() {
		return Glyphicon.asterisk;
	}
	
	@Override
	protected org.nasdanika.webtest.model.InitializationResult createModel() {
		return org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createInitializationResult();
	}	

}
