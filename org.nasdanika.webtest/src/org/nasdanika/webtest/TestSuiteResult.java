package org.nasdanika.webtest;

import java.util.List;

public interface TestSuiteResult extends TestResult {
	
	List<TestResult> getChildren();

}
