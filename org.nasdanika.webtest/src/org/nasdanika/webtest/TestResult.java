package org.nasdanika.webtest;

import java.util.Collection;
import java.util.Map;

/**
 * Base interface for test results
 * @author Pavel Vlasov
 *
 */
public interface TestResult extends HttpPublisher, DirectoryPublisher {
	
	Class<?> getTestClass();
	
	enum TestStatus {Pass, Fail, Error, Pending}
	
	Map<TestStatus, Integer> getStats();
	
	String getId();
		
	Collection<ActorResult> getActorResults();
	
	Collection<PageResult> getPageResults();

}
