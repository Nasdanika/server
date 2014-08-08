package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.nasdanika.html.HTMLFactory.Glyphicon;

public class TestMethodResult  extends MethodResult {

	private Object[] parameters;

	TestMethodResult(String id, Method method, MethodResult parent, Object[] parameters) {
		super(id, method, parent);
		this.parameters = parameters;
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.search;
	}
	
	public Object[] getParameters() {
		return parameters;
	}

}
