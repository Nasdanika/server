package org.nasdanika.webtest;

import java.lang.reflect.Method;

import org.nasdanika.html.HTMLFactory.Glyphicon;

public class TestMethodResult  extends MethodResult {

	TestMethodResult(String id, Method method, MethodResult parent) {
		super(id, method, parent);
	}
	
	Glyphicon getGlyphicon() {
		return Glyphicon.search;
	}

}
