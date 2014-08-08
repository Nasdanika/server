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

public class NasdanikaWebTestSuite extends Suite implements TestResultSource, TestResultCollector {

	public NasdanikaWebTestSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		super(klass, builder);
	}

	public NasdanikaWebTestSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
		super(builder, classes);
	}

	public NasdanikaWebTestSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, suiteClasses);
	}

	public NasdanikaWebTestSuite(Class<?> klass, List<Runner> runners)	throws InitializationError {
		super(klass, runners);
	}

	public NasdanikaWebTestSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, suiteClasses);
	}

	private List<TestResult> testResults = new ArrayList<>();
	private File outputDir;
	
	@Override
	public void run(RunNotifier notifier) {
		try {
			outputDir = testResultCollector == null ? NasdanikaWebTestRunner.configOutputDir(getTestClass().getJavaClass()) : testResultCollector.getOutputDir();	
			counter = testResultCollector == null ? new AtomicLong() : testResultCollector.getCounter();
			screenshotExecutor = testResultCollector == null ? Executors.newSingleThreadExecutor() : testResultCollector.getScreenshotExecutor();
			try {
				super.run(notifier);
			} finally {
				if (testResultCollector==null) {
					close();
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
			((TestResultSource) runner).setTestResultCollector(testResultCollector==null ? this : testResultCollector);
		}
		super.runChild(runner, notifier);
	}
	
	private TestResultCollector testResultCollector;
	private AtomicLong counter;
	private Executor screenshotExecutor;
	
	@Override
	public AtomicLong getCounter() {
		return testResultCollector == null ? counter : testResultCollector.getCounter();
	}
	
	@Override
	public File getOutputDir() {
		return testResultCollector == null ? outputDir : testResultCollector.getOutputDir();
	}
	
	@Override
	public Executor getScreenshotExecutor() {
		return testResultCollector == null ? screenshotExecutor : testResultCollector.getScreenshotExecutor();
	}
	
	@Override
	public void addResult(TestResult testResult) {
		if (testResultCollector==null) {
			testResults.add(testResult);
		} else {
			testResultCollector.addResult(testResult);
		}
	}

	@Override
	public void setTestResultCollector(TestResultCollector testResultCollector) {
		this.testResultCollector = testResultCollector;		
	}

	@Override
	public void close() throws Exception {
		((ExecutorService) screenshotExecutor).shutdown();
		((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
		new ReportGenerator(getTestClass().getJavaClass(), outputDir, testResults).generate();
	}
	
}
