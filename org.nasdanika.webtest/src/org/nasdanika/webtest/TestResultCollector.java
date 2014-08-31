package org.nasdanika.webtest;

import java.io.File;
import java.util.concurrent.Executor;

public interface TestResultCollector extends TestResultListener {

	IdGenerator getIdGenerator();

	File getOutputDir();

	Executor getScreenshotExecutor();
	
	void addListener(TestResultListener testResultListener);
	
}
