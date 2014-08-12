package org.nasdanika.webtest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
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
	private String id;
		
	private List<TestResultListener> listeners = new ArrayList<>();
	
	@Override
	public void addListener(TestResultListener testResultListener) {
		if (testResultCollector==null) {
			listeners.add(testResultListener);		
		} else {
			testResultCollector.addListener(testResultListener);
		}
	}	
	
	@Override
	public void run(RunNotifier notifier) {
		try {
			outputDir = testResultCollector == null ? NasdanikaWebTestRunner.configOutputDir(getTestClass().getJavaClass()) : testResultCollector.getOutputDir();	
			counter = testResultCollector == null ? new AtomicLong() : testResultCollector.getCounter();
			id = Long.toString(counter.incrementAndGet(), Character.MAX_RADIX);
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
		testResults.add(testResult);
	}

	@Override
	public void setTestResultCollector(TestResultCollector testResultCollector) {
		
		this.testResultCollector = testResultCollector;		
		this.testResultCollector.addResult(new TestSuiteResult() {
			
			@Override
			public Class<?> getTestClass() {
				return NasdanikaWebTestSuite.this.getTestClass().getJavaClass();
			}
			
			@Override
			public List<TestResult> getChildren() {
				return testResults;
			}
			
			@Override
			public Map<TestStatus, Integer> getStats() {
				Map<TestStatus, Integer> ret = new TreeMap<>();
				for (TestStatus ts: TestStatus.values()) {
					ret.put(ts, 0);
				}
				for (TestResult child: testResults) {
					for (Entry<TestStatus, Integer> cs: child.getStats().entrySet()) {
						ret.put(cs.getKey(), ret.get(cs.getKey())+cs.getValue());
					}
					
				}
				return ret;
			}

			@Override
			public String getId() {
				return id;
			}
			
		});
	}

	@Override
	public void close() throws Exception {
		((ExecutorService) screenshotExecutor).shutdown();
		((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
		new ReportGenerator(getTestClass().getJavaClass(), outputDir, testResults).generate();
		WebTestUtil.publishTestResults(testResults);
	}
	
}
