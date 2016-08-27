package org.nasdanika.webtest;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

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

	/**
	 * @param screenshotsDir
	 * @param objectMap Maps web test objects (e.g. screenshots) to model objects.
	 * @return
	 */
	org.nasdanika.webtest.model.TestResult toModel(
			List<org.nasdanika.webtest.model.Screenshot> screenshotsCollector, 
			File screenshotsDir, 
			Map<Object, Object> objectMap,
			org.nasdanika.core.Context context,
			Executor executor);

}
