package org.nasdanika.webtest;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public interface TestResultCollector extends AutoCloseable {
	
	void addResult(TestResult testResult);

	AtomicLong getCounter();

	File getOutputDir();

	Executor getScreenshotExecutor();
	
}
