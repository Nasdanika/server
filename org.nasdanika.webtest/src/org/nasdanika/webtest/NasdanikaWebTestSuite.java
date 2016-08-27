package org.nasdanika.webtest;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
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
	
	// Calling thread executor by default.
	private Executor childExecutor = new Executor() {
		
		@Override
		public void execute(Runnable command) {
			command.run();
		}
	};
	
	@Override
	public void run(RunNotifier notifier) {
		try {
			outputDir = testResultCollector == null ? NasdanikaWebTestRunner.configOutputDir(getTestClass().getJavaClass()) : testResultCollector.getOutputDir();	
			idGenerator = testResultCollector == null ? new IdGenerator() : testResultCollector.getIdGenerator();
			id = idGenerator.genId(getTestClass().getJavaClass().getName(), null);
			screenshotExecutor = testResultCollector == null ? Executors.newSingleThreadExecutor() : testResultCollector.getScreenshotExecutor();
			Concurrent concurrent = getTestClass().getJavaClass().getAnnotation(Concurrent.class);
			if (concurrent!=null) {
				if (concurrent.value()>0) {
					childExecutor = Executors.newFixedThreadPool(concurrent.value());
				} else {
					childExecutor = Executors.newCachedThreadPool();
				}
			}
			try {
				super.run(notifier);
			} finally {
				if (childExecutor instanceof ExecutorService) {
					((ExecutorService) childExecutor).shutdown();
					((ExecutorService) childExecutor).awaitTermination(10, TimeUnit.MINUTES); // TODO - from @Concurrent?
				}
				
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
	protected void runChild(final Runner runner, final RunNotifier notifier) {
		childExecutor.execute(new Runnable() {

			@Override
			public void run() {
				if (runner instanceof TestResultSource) {
					((TestResultSource) runner).setTestResultCollector(testResultCollector==null ? NasdanikaWebTestSuite.this : testResultCollector);
				}
				NasdanikaWebTestSuite.super.runChild(runner, notifier);
			}
			
		});
	}
	
	private TestResultCollector testResultCollector;
	private IdGenerator idGenerator;
	private Executor screenshotExecutor;
	
	@Override
	public IdGenerator getIdGenerator() {
		return testResultCollector == null ? idGenerator : testResultCollector.getIdGenerator();
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
			
			@Override
			public Collection<ActorResult> getActorResults() {
				Map<String, ActorResult> collector = new HashMap<>();
				for (TestResult tr: getChildren()) {
					for (ActorResult car: tr.getActorResults()) {
						ActorResult aar = collector.get(car.getActorKey());
						if (aar==null) {
							aar = new ActorResult(car.getActorInterface(), car.getTitle());
							collector.put(car.getActorKey(), aar);
						}
						aar.merge(car);
					}
				}
				return collector.values();
			}

			@Override
			public Collection<PageResult> getPageResults() {
				Map<String, PageResult> collector = new HashMap<>();
				for (TestResult tr: getChildren()) {
					for (PageResult cpr: tr.getPageResults()) {
						PageResult apr = collector.get(cpr.getPageKey());
						if (apr==null) {
							apr = new PageResult(cpr.getPageInterface(), cpr.webElements(), cpr.getTitle());
							collector.put(cpr.getPageKey(), apr);
						}
						apr.merge(cpr);
					}
				}
				return collector.values();
			}

			@Override
			public void publish(
					URL url, 
					String securityToken, 
					boolean publishPerformance,
					Map<Object, String> idMap, 
					PublishMonitor monitor) throws Exception {
				
				if (monitor!=null) {
					monitor.onPublishing("Test Suite "+getTestClass().getName(), url);
				}
				if (getChildren().isEmpty() && getActorResults().isEmpty() && getPageResults().isEmpty()) {
					return; // No reason to publish.
				}				
				HttpURLConnection pConnection = (HttpURLConnection) url.openConnection();
				pConnection.setRequestMethod("POST");
				pConnection.setDoOutput(true);
				pConnection.setRequestProperty("Authorization", "Bearer "+securityToken);
				JSONObject data = new JSONObject();
				WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToJSON(getTestClass(), data);
				data.put("type", "suite");
				try (Writer w = new OutputStreamWriter(pConnection.getOutputStream())) {
					data.write(w);
				}
				int responseCode = pConnection.getResponseCode();
				if (responseCode==HttpURLConnection.HTTP_OK) {
					id = pConnection.getHeaderField("ID");
					idMap.put(this, id);
					String location = pConnection.getHeaderField("Location");

					URL childrenURL= new URL(location+"/children");
					for (TestResult tr: getChildren()) {
						tr.publish(childrenURL, securityToken, publishPerformance, idMap, monitor);				
					}

					URL pageResultsURL= new URL(location+"/pageResults");
					for (PageResult pr: getPageResults()) {
						pr.publish(pageResultsURL, securityToken, publishPerformance, idMap, monitor);				
					}

					URL actorResultsURL= new URL(location+"/actorResults");
					for (ActorResult ar: getActorResults()) {
						ar.publish(actorResultsURL, securityToken, publishPerformance, idMap, monitor);				
					}
				} else {
					throw new PublishException(url+" error: "+responseCode+" "+pConnection.getResponseMessage());
				}
			}			

			@Override
			public int publishSize() {
				int ret = 1;
				for (TestResult mr: getChildren()) {
					ret+=mr.publishSize();	
				}

				for (PageResult pr: getPageResults()) {
					ret+=pr.publishSize();	
				}

				for (ActorResult ar: getActorResults()) {
					ret+=ar.publishSize();	
				}
				return ret;
			}

			@Override
			public String publish(
					Directory directory, 
					boolean publishPerformance, 
					Map<Object, String> idMap,
					DirectoryPublishMonitor monitor) throws Exception {
				
				throw new UnsupportedOperationException("TODO!");
			}

			@Override
			public org.nasdanika.webtest.model.TestResult toModel(
					List<org.nasdanika.webtest.model.Screenshot> screenshotsCollector, 
					File screenshotsDir, 
					Map<Object, Object> objectMap,
					org.nasdanika.core.Context context,
					Executor executor) {
				
				if (getChildren().isEmpty() && getActorResults().isEmpty() && getPageResults().isEmpty()) {
					return null; 
				}				
				org.nasdanika.webtest.model.TestSuiteResult testResult = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createTestSuiteResult();
				objectMap.put(this, testResult);
				WebTestUtil.qualifiedNameAndTitleAndDescriptionAndLinksToDescriptor(getTestClass(), testResult);
				if (WebTestUtil.isBlank(testResult.getTitle())) {
					testResult.setTitle(WebTestUtil.title(getTestClass().getName()));
				}

				for (TestResult tr: getChildren()) {
					org.nasdanika.webtest.model.TestResult trModel = tr.toModel(
							screenshotsCollector, 
							screenshotsDir, 
							objectMap,
							context,
							executor);
					
					if (trModel!=null) {
						testResult.getChildren().add(trModel);
					}
				}

				for (PageResult pr: getPageResults()) {
					org.nasdanika.webtest.model.PageResult prModel = pr.toModel(screenshotsDir, objectMap);
					if (prModel!=null) {
						testResult.getPageResults().add(prModel);
					}
				}

				for (ActorResult ar: getActorResults()) {
					org.nasdanika.webtest.model.ActorResult arModel = ar.toModel(screenshotsDir, objectMap);
					if (arModel!=null) {
						testResult.getActorResults().add(arModel);
					}
				}
				return testResult;
			}				
			
		});
	}

	@Override
	public void close() throws Exception {
		((ExecutorService) screenshotExecutor).shutdown();
		((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
		Publish publish = getTestClass().getJavaClass().getAnnotation(Publish.class);
		if (publish!=null) {
			String publishURL = publish.url();
			if (publishURL.trim().length()==0) {
				publishURL = System.getenv("NASDANIKA_WEBTEST_PUBLISH_URL");
			}
			if (publishURL!=null) {
				String securityToken = publish.securityToken();
				if (securityToken.trim().length()==0) {
					securityToken = System.getenv("NASDANIKA_WEBTEST_PUBLISH_SECURITY_TOKEN");
				}								
				new TestSession(getTestClass().getJavaClass(), testResults).publish(new URL(publishURL), securityToken, publish.publishPerformance(), new IdentityHashMap<Object, String>(), null);
			}
		}
		if (getTestClass().getJavaClass().getAnnotation(Report.class)!=null) {
			new ReportGenerator(getTestClass().getJavaClass(), outputDir, getIdGenerator(), testResults).generate();
		}
		WebTestUtil.publishTestResults(testResults);
		
		new TestSession(getTestClass().getJavaClass(), testResults).writeModel();
		
		if (getTestClass().getJavaClass().getAnnotation(Report.class)==null) {
			WebTestUtil.delete(outputDir);
		}
	}
	
}
