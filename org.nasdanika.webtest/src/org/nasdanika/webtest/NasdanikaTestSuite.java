package org.nasdanika.webtest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

public class NasdanikaTestSuite extends Suite implements TestResultSource {

	public NasdanikaTestSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		super(klass, builder);
	}

	public NasdanikaTestSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
		super(builder, classes);
	}

	public NasdanikaTestSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, suiteClasses);
	}

	public NasdanikaTestSuite(Class<?> klass, List<Runner> runners)	throws InitializationError {
		super(klass, runners);
	}

	public NasdanikaTestSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, suiteClasses);
	}
	
	private List<TestResult> testResults = new ArrayList<>();
	private File outputDir;
	
	@Override
	public void run(RunNotifier notifier) {
		try {
			outputDir = suite == null ? NasdanikaTestRunner.configOutputDir(getTestClass().getJavaClass()) : suite.getOutputDir();	
			counter = suite == null ? new AtomicLong() : suite.getCounter();
			screenshotExecutor = suite == null ? Executors.newSingleThreadExecutor() : suite.getScreenshotExecutor();
			try {
				super.run(notifier);
			} finally {
				if (suite==null) {
					((ExecutorService) screenshotExecutor).shutdown();
					((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
					new ReportGenerator(getTestClass().getJavaClass(), outputDir, testResults).generate();
				} 				
			}			
		} catch (Exception e) {
			System.err.println("Report generation failed: "+e);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void runChild(Runner runner, RunNotifier notifier) {
		if (runner instanceof TestResultSource) {
			((TestResultSource) runner).setSuite(suite==null ? this : suite);
		}
		super.runChild(runner, notifier);
	}
	
	private NasdanikaTestSuite suite;
	private AtomicLong counter;
	private Executor screenshotExecutor;
	
	AtomicLong getCounter() {
		return counter;
	}
	
	File getOutputDir() {
		return outputDir;
	}
	
	Executor getScreenshotExecutor() {
		return screenshotExecutor;
	}
	
	void addResult(TestResult testResult) {
		if (suite==null) {
			testResults.add(testResult);
		} else {
			suite.addResult(testResult);
		}
	}

	@Override
	public void setSuite(NasdanikaTestSuite suite) {
		this.suite = suite;		
	}
	
}
