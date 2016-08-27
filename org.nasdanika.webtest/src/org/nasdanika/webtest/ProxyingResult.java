package org.nasdanika.webtest;

import org.nasdanika.html.Bootstrap.Glyphicon;

/**
 * Indicates that a proxy was created for a given object.
 * @author Pavel Vlasov
 *
 */
public class ProxyingResult extends OperationResult<Class<?>, org.nasdanika.webtest.model.ProxyingResult> {

	ProxyingResult(String id, Class<?> klass, OperationResult<?,?> parent) {
		super(id, klass, null, parent);
	}
	
	protected String getOperationName() {
		return operation.getName()+"::proxy";
//		String oName = operation.getName();
//		return oName.substring(oName.lastIndexOf('.')+1)+"::init";
	}
	
	@Override
	Glyphicon getGlyphicon() {
		return Glyphicon.asterisk;
	}
	
	@Override
	protected org.nasdanika.webtest.model.ProxyingResult createModel() {
		return org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createProxyingResult();
	}	

}
