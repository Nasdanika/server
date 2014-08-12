package org.nasdanika.webtest;

public interface TestResultListener extends AutoCloseable {
	
	void addResult(TestResult testResult);

}
