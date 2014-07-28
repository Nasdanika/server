package org.nasdanika.webtest;

import java.lang.reflect.Method;

public class TestMethodResult  extends MethodResult {

	TestMethodResult(String id, Method method, MethodResult parent) {
		super(id, method, parent);
	}

}
