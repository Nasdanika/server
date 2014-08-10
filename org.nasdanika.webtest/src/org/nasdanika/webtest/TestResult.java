package org.nasdanika.webtest;

import java.util.Map;

/**
 * Base interface for test results
 * @author Pavel Vlasov
 *
 */
public interface TestResult {
	
	Class<?> getTestClass();
	
	enum TestStatus {Pass, Fail, Error, Pending}
	
	Map<TestStatus, Integer> getStats();
	
	String getId();

}
