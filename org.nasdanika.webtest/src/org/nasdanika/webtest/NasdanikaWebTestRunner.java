package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.model.InitializationError;
import org.openqa.selenium.WebDriver;

/**
 * Test runner for generating a standalone report or reporting 
 * results to a suite. 
 * @author Pavel Vlasov
 *
 */
public class NasdanikaWebTestRunner extends AbstractNasdanikaWebTestRunner {
	
	
	public NasdanikaWebTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}
			
	@Override
	protected Collector<WebDriver> createCollector(final TestResultCollector testResultCollector) throws Exception {
		final IdGenerator idGenerator = testResultCollector==null ? new IdGenerator() : testResultCollector.getIdGenerator();
		final File outputDir = testResultCollector == null ? configOutputDir(getTestClass().getJavaClass()) : testResultCollector.getOutputDir();	
		final File screenshotsDir = outputDir==null ? null : new File(outputDir, "screenshots");
		final Executor screenshotExecutor = testResultCollector==null ? Executors.newSingleThreadExecutor() : testResultCollector.getScreenshotExecutor();
		
		TestClassResult testClassResult = new TestClassResult(getTestClass().getJavaClass(), idGenerator, getIndex(), screenshotsDir, screenshotExecutor) {
			
			@Override
			public void close() throws Exception {
				super.close();
				if (testResultCollector==null) {
					((ExecutorService) screenshotExecutor).shutdown();
					((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
					Publish publish = getTestClass().getAnnotation(Publish.class);
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
							new TestSession(getTestClass(), Collections.singleton(this)).publish(new URL(publishURL), securityToken, publish.publishPerformance(), new IdentityHashMap<Object, String>(), null);
						}						
					}
					if (getTestClass().getAnnotation(Report.class)!=null) {
						new ReportGenerator(getTestClass(), outputDir, idGenerator, Collections.singleton(this)).generate();
					}
					WebTestUtil.publishTestResults(Collections.singleton(this));		
					
					new TestSession(getTestClass(), Collections.singleton(this)).writeModel();
					
					if (getTestClass().getAnnotation(Report.class)==null) {
						WebTestUtil.delete(outputDir);
					}
				} else {
					testResultCollector.addResult(this);
				}
			}
			
		};
		
		return WebTestUtil.<WebDriver>createCollector(testClassResult);
	}
	
	static File configOutputDir(Class<?> klass) throws IOException {
		Report reportAnnotation = klass.getAnnotation(Report.class);
		String outputDirTemplate = reportAnnotation==null ? "target/nasdanika-web-tests/{2}" : reportAnnotation.outputDir();
		String className = klass.getName();
		String shortClassName = className.substring(className.lastIndexOf('.')+1);
		String outputDirName = MessageFormat.format(outputDirTemplate.replace('/', File.separatorChar), new Object[] {shortClassName, className, className.replace('.', File.separatorChar)});
		File outputDir = new File(outputDirName);						
		if (outputDir.exists()) {
			for (File c: outputDir.listFiles()) {
				WebTestUtil.delete(c);
			}
		} else if (!outputDir.mkdirs()) {
			throw new IOException("Could not create output directory "+outputDir.getAbsolutePath());
		}		
		File screenshotsDir = new File(outputDir, "screenshots");
		if (!screenshotsDir.exists() && !screenshotsDir.mkdir()) {
			throw new IOException("Could not create screenshot output directory "+screenshotsDir.getAbsolutePath());			
		}
		
		return outputDir;
	}	
	

}
