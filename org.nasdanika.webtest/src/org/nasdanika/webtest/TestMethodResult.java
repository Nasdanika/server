package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.text.MessageFormat;

import org.nasdanika.html.HTMLFactory.Glyphicon;

public class TestMethodResult  extends MethodResult {

	private Object[] parameters;

	TestMethodResult(String id, Method method, Object[] arguments, MethodResult parent, Object[] parameters) {
		super(id, method, arguments, parent);
		this.parameters = parameters;
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.search;
	}
	
	public Object[] getParameters() {
		return parameters;
	}
	
	/**
	 * Use parameters instead of arguments in format.
	 */
	protected String formatDescription(String description) {
		if (parameters==null || parameters.length==0) {
			return description;
		}
		return MessageFormat.format(description, parameters);
	}	

}
