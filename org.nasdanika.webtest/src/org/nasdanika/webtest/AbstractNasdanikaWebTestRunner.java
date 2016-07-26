package org.nasdanika.webtest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.json.JSONObject;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import net.sourceforge.plantuml.SourceStringReader;

/**
 * Base class for test runners which report results to {@link Collector}.
 * @author Pavel Vlasov
 *
 */
public abstract class AbstractNasdanikaWebTestRunner extends BlockJUnit4ClassRunner implements TestResultSource {
	
	private static final String BUNDLE_SCHEME = "bundle";
	
	private static final String SCHEME_SEPARATOR = "://";

	private static final int WAIT_FOR_SERVICE_TIMEOUT = 2000;

	private static final int SCREENSHOT_ATTEMPTS = 5;

	private static final int SCREENSHOT_RETAKE_WAIT_INTERVAL = 2000;

	static ThreadLocal<Collector<WebDriver>> collectorThreadLocal = new ThreadLocal<Collector<WebDriver>>() {
		
		protected Collector<WebDriver> initialValue() {
			// NOP Collector to avoid exceptions.
			return new Collector<WebDriver>() {

				@Override
				public void onPageProxying(Page<WebDriver> page) {}

				@Override
				public void beforePageMethod(Page<WebDriver> page, byte[] screenshot, JSONObject performanceData, Method method, Object[] args) {}

				@Override
				public void afterPageMethod(Page<WebDriver> page, byte[] screenshot, JSONObject performanceData, Method method, Object[] args, Object result, Throwable th) {}

				@Override
				public void onActorProxying(Actor<WebDriver> actor) {}

				@Override
				public void beforeActorMethod(Actor<WebDriver> actor, byte[] screenshot, JSONObject performanceData, Method method, Object[] args) {}

				@Override
				public void afterActorMethod(Actor<WebDriver> actor, byte[] screenshot, JSONObject performanceData, Method method, Object[] args, Object result, Throwable th) {}

				@Override
				public void beforeTestMethod(Method method, int index, Object[] parameters) {}

				@Override
				public void beforeTestMethodScreenshot(byte[] screenshot, JSONObject performanceData) {}

				@Override
				public void afterTestMethod(Method method, Throwable th) {}

				@Override
				public void afterTestMethodScreenshot(byte[] screenshot, JSONObject performanceData) {}

				@Override
				public void close() throws Exception {}

				@Override
				public void setTest(Object test) {}

				@Override
				public void beforePageInitialization(
						Class<? extends Page<WebDriver>> pageClass,
						byte[] screenshot, 
						JSONObject performanceData) {}

				@Override
				public void afterPageInitialization(
						Class<? extends Page<WebDriver>> pageClass, 
						Page<WebDriver> page, 
						byte[] screenshot, 
						JSONObject performanceData, 
						Throwable th) {}

				@Override
				public void onScreenshot(byte[] screenshot, String comment) {}
				
				@Override
				public AnnotatedElement getCurrentOperation() {
					return null;
				}
				
			};
		};
		
	};
	
	static ThreadLocal<Object> testThreadLocal = new ThreadLocal<Object>();
	private static ThreadLocal<List<ServiceTracker<?,?>>> serviceTrackersThreadLocal = new ThreadLocal<List<ServiceTracker<?,?>>>() {
		
		protected java.util.List<ServiceTracker<?,?>> initialValue() {
			return new ArrayList<ServiceTracker<?,?>>();
		};
	};
	
	static JSONObject capturePerformance() {
		Object test = testThreadLocal.get();
		if (test instanceof WebTest) {
			return WebTestUtil.capturePerformance(((WebTest<?>) test).getWebDriver());
		}
		return null;
	}
	
	private static Sketch matchSketch(AnnotatedElement element, SketchWebDriver sketchWebDriver) {
		Sketches sketches = element.getAnnotation(Sketches.class);
		if (sketches != null) {
			for (Sketch sketch: sketches.value()) {
				if (sketch.selector().equals(sketchWebDriver.getSelector()) || sketch.selector().trim().length() == 0) {
					return sketch;
				}
			}
		}
			
		return null;	
	}
	
	static byte[] takeScreenshotOrSketch(Method method, Screenshot.When when) {
		Object test = testThreadLocal.get();
		if (test instanceof TakesScreenshot) { // To customize screenshot taking in some advanced situations
			takeScreenshot((TakesScreenshot) test);
		}
		if (test instanceof WebTest) {
			WebDriver webDriver = ((WebTest<?>) test).getWebDriver();
			if (method != null && webDriver instanceof SketchWebDriver) {
				Sketch sketch = matchSketch(method, (SketchWebDriver) webDriver);
				if (sketch != null) {
					Dimension windowSize = sketch.windowSize().length == 2 ? new Dimension(sketch.windowSize()[0], sketch.windowSize()[1]) : null;
					switch (when) {
					case AFTER:
						String location = sketch.after();
						if (location.trim().length() == 0) {
							location = sketch.value();
						}
						if (location.trim().length() == 0) {
							return null;
						}
						return takeSketch(method.getDeclaringClass(), location, windowSize);
					case BEFORE:
						return takeSketch(method.getDeclaringClass(), sketch.before(), windowSize);
					case EXCEPTION:
						return takeSketch(method.getDeclaringClass(), sketch.exception(), windowSize);
					case DURING:
					default:
						return null;
					}
				}
			} else if (webDriver instanceof TakesScreenshot) {
				return takeScreenshot((TakesScreenshot) webDriver);
			}
		}
		return null;
	}
	
	private static byte[] takeSketch(Class<?> pageClass, SketchWebDriver sketchWebDriver, Screenshot.When when) {
		Sketch sketch = matchSketch(pageClass, sketchWebDriver);
		if (sketch != null) {
			Dimension windowSize = sketch.windowSize().length == 2 ? new Dimension(sketch.windowSize()[0], sketch.windowSize()[1]) : null;
			switch (when) {
			case AFTER:
				String location = sketch.after();
				if (location.trim().length() == 0) {
					location = sketch.value();
				}
				if (location.trim().length() == 0) {
					return null;
				}
				return takeSketch(pageClass, location, windowSize);
			case BEFORE:
				return takeSketch(pageClass, sketch.before(), windowSize);
			case EXCEPTION:
				return takeSketch(pageClass, sketch.exception(), windowSize);
			case DURING:
			default:
				return null;
			}
		}
		return null;
	}
	
	static byte[] takeSketch(Class<?> contextClass, String location, Dimension windowSize) {
		if (location != null && location.trim().length() > 0) {
			if (contextClass == null) {
				Collector<WebDriver> collector = collectorThreadLocal.get();
				if (collector != null) {
					AnnotatedElement currentOperation = collector.getCurrentOperation();
					if (currentOperation instanceof Class) {
						contextClass = (Class<?>) currentOperation;
					} else if (currentOperation instanceof Method) {
						contextClass = ((Method) currentOperation).getDeclaringClass();
					}
				}
			}
			
			try {
				boolean isExternal;
				URL resourceURL;
				if (location.startsWith(BUNDLE_SCHEME+SCHEME_SEPARATOR)) {
					isExternal = false;
					int slashIdx = location.indexOf('/', BUNDLE_SCHEME.length()+SCHEME_SEPARATOR.length());
					resourceURL = slashIdx == - 1 ? null : Platform.getBundle(location.substring(BUNDLE_SCHEME.length()+SCHEME_SEPARATOR.length(), slashIdx)).getEntry(location.substring(slashIdx));
				} else if (location.contains(SCHEME_SEPARATOR)) {
					isExternal = true;
					resourceURL = new URL(location);
				} else {
					isExternal = false;
					resourceURL = contextClass.getResource(location);
				}
				
				if (resourceURL == null) {
					System.err.println("Sketch resource not found in the context of "+contextClass.getName()+": "+location);
				} else {
					if (location.toLowerCase().endsWith(".png")) {
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						try (InputStream in = resourceURL.openStream()) {
							int b;
							while ((b = in.read()) != -1) {
								baos.write(b);
							}
						}
						baos.close();
						return baos.toByteArray();
					}
					
					if (location.toLowerCase().endsWith(".plantuml")) {
						StringWriter sw = new StringWriter();
						try (Reader reader = new InputStreamReader(resourceURL.openStream())) {
							int ch;
							while ((ch = reader.read()) != -1) {
								sw.write(ch);
							}
						}
						sw.close();
						SourceStringReader reader = new SourceStringReader(sw.toString());
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						reader.generateImage(baos);
						baos.close();
						return baos.toByteArray();
					}
					
					if (!isExternal) {
						System.err.println("Sketch resource cannot be rendered. Context: "+contextClass.getName()+", location: "+location);						
					} else {
						PhantomJSDriver phantomJSDriver = new PhantomJSDriver();
						try {
							if (windowSize != null) {
								phantomJSDriver.manage().window().setSize(windowSize);
							}
							phantomJSDriver.get(location);
							return takeScreenshot(phantomJSDriver);
						} finally {
							phantomJSDriver.quit();
						}
					}
				}
			} catch (Exception e) {
				System.err.println("Error taking sketch from '"+location+"': "+e);
			}
		}
		return null;
	}
	
	private static byte[] takeScreenshot(TakesScreenshot takesScreenshot) {
		String takeScreenshots = System.getenv("NASDANIKA_WEBTEST_TAKE_SCREENSHOTS");
		if ("no".equalsIgnoreCase(takeScreenshots) || "false".equalsIgnoreCase(takeScreenshots)) {
			return null;
		}
		
		if (takeScreenshots!=null && !"yes".equalsIgnoreCase(takeScreenshots) && !"true".equalsIgnoreCase(takeScreenshots)) {
			System.err.println("Invalid value of NASDANIKA_WEBTEST_TAKE_SCREENSHOTS environment variable: "+takeScreenshots);
		}
		
		try {
			for (int i=0; ; ++i) {
				try {
					return takesScreenshot.getScreenshotAs(OutputType.BYTES);
				} catch (WebDriverException wde) {
					if (i<SCREENSHOT_ATTEMPTS && wde.getMessage()!=null && wde.getMessage().startsWith("Could not take screenshot of current page - Error: Page is not loaded yet, try later")) {							
						try {
							System.out.println("Retaking screenshot");
							Thread.sleep(SCREENSHOT_RETAKE_WAIT_INTERVAL); // Wait and retry.
						} catch (InterruptedException e) {
							return null; 
						}
					} else {
						throw wde;
					}
				} 
			}
		} catch (Exception e) {
			System.err.println("Error taking screenshot: "+e);
			e.printStackTrace();
		}
		
		return null;
	}
	
	static boolean shallTakeBeforeScreenshot(Screenshot screenshotAnnotation) {
		return screenshotAnnotation==null || Arrays.asList(screenshotAnnotation.value()).contains(Screenshot.When.BEFORE); 
	}
	
	static boolean shallTakeAfterScreenshot(Screenshot screenshotAnnotation) {
		return screenshotAnnotation==null || Arrays.asList(screenshotAnnotation.value()).contains(Screenshot.When.AFTER); 
	}
	
	static boolean shallTakeExceptionScreenshot(Screenshot screenshotAnnotation) {
		return screenshotAnnotation==null || Arrays.asList(screenshotAnnotation.value()).contains(Screenshot.When.EXCEPTION); 
	}
	
	protected TestResultCollector testResultCollector;

	protected AbstractNasdanikaWebTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	public void setTestResultCollector(TestResultCollector testResultCollector) {
		this.testResultCollector = testResultCollector;		
	}
			
	protected abstract Collector<WebDriver> createCollector(TestResultCollector testResultCollector) throws Exception;
			
	@Override
	public void run(RunNotifier notifier) {
		try {
			Collector<WebDriver> prevCollector = collectorThreadLocal.get();
			collectorThreadLocal.set(createCollector(testResultCollector));
			try {
				super.run(notifier);
			} finally {
				collectorThreadLocal.get().close();
				collectorThreadLocal.set(prevCollector);				
			}
		} catch (Exception e) {			
			System.err.println("Report generation failed: "+e);
			e.printStackTrace();
		}
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
		return outputDir;
	}
	
	@Override
	protected Statement methodBlock(final FrameworkMethod method) {
		final Statement superStatement =  super.methodBlock(method);
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {		    	
		    	collectorThreadLocal.get().beforeTestMethod(method.getMethod(), getIndex(), getParameters());
		    	try {
			    	boolean isPending = false;
			    	Pending pendingAnnotation = method.getMethod().getAnnotation(Pending.class);
			    	if (pendingAnnotation!=null) {
			    		String until = pendingAnnotation.until();
			    		if (until.trim().length()==0) {
			    			isPending = true; // No expiration date - ignore the test
			    		} else {
			    			try {
			    				isPending = new SimpleDateFormat("yyyy-MM-dd").parse(until).getTime() > System.currentTimeMillis();
			    			} catch (ParseException e) {
			    				System.err.println("Invalid until date: "+until);
			    			}
			    		}
			    		
			    	}
			    	
					if (!isPending) {
						superStatement.evaluate();
					}
		    		collectorThreadLocal.get().afterTestMethod(method.getMethod(), null);
		    	} catch (Throwable th) {
		    		collectorThreadLocal.get().afterTestMethod(method.getMethod(), th);
		    		throw th;
		    	} finally {
		    		// Close service trackers if any
		    		for (ServiceTracker<?,?> st: serviceTrackersThreadLocal.get()) {
		    			st.close();
		    		}
		    		
		    		serviceTrackersThreadLocal.get().clear();
		    	}
			}
			
		};
	}
	
	private static final Object[] NO_PARAMETERS = {};
	
	/**
	 * @return Test parameters if test is parameterized.
	 */
	protected Object[] getParameters() {
		return NO_PARAMETERS;
	}
	
	protected int getIndex() {
		return -1;
	}
	
	@Override
	protected Statement methodInvoker(final FrameworkMethod method, final Object test) {
		injectFactoriesAndServices(test);
		
		return new Statement() {

		    @Override
		    public void evaluate() throws Throwable {
	    		Method theMethod = method.getMethod();
	    		Screenshot screenshotAnnotation = theMethod.getAnnotation(Screenshot.class);
	    		long delay = screenshotAnnotation==null ? 0 : screenshotAnnotation.delay();
	    		if (test instanceof WebTest) {
	    			delay += ((WebTest<?>) test).getScreenshotDelay();
	    		}
		    	try {				    		
		    		testThreadLocal.set(test);
		    		collectorThreadLocal.get().setTest(test);
		    		if (test instanceof WebTest) {
		    			WebTestUtil.doWait(((WebTest<?>) test).getWebDriver(), theMethod);
		    		}
		    		if (shallTakeBeforeScreenshot(screenshotAnnotation)) {
		    			if (delay>0) {
		    				Thread.sleep(delay);
		    			}
		    			collectorThreadLocal.get().beforeTestMethodScreenshot(takeScreenshotOrSketch(theMethod, Screenshot.When.BEFORE), capturePerformance());
		    		} else {
		    			collectorThreadLocal.get().beforeTestMethodScreenshot(null, capturePerformance());		    			
		    		}
			    	method.invokeExplosively(test);
		    		if (shallTakeAfterScreenshot(screenshotAnnotation)) {
		    			if (delay>0) {
		    				Thread.sleep(delay);
		    			}
		    			collectorThreadLocal.get().afterTestMethodScreenshot(takeScreenshotOrSketch(theMethod, Screenshot.When.AFTER), capturePerformance());
		    		} else {
		    			collectorThreadLocal.get().afterTestMethodScreenshot(null, capturePerformance());
		    		}
		    	} catch (Throwable th) {
		    		if (shallTakeExceptionScreenshot(screenshotAnnotation)) {
		    			if (delay>0) {
		    				Thread.sleep(delay);
		    			}
		    			collectorThreadLocal.get().afterTestMethodScreenshot(takeScreenshotOrSketch(theMethod, Screenshot.When.EXCEPTION), capturePerformance());
		    		} else {
		    			collectorThreadLocal.get().afterTestMethodScreenshot(null, capturePerformance());		    			
		    		}
		    		throw th;
		    	} finally {
		    		testThreadLocal.set(null);
		    	}
		    }
		    
		};
	}

	@SuppressWarnings("unchecked")
	private void injectFactoriesAndServices(final Object test) {
		try {
			BundleContext bundleContext = FrameworkUtil.getBundle(test.getClass()).getBundleContext();
			if (bundleContext==null) {
				throw new NullPointerException("Cannot acquire bundle context for class "+test.getClass());
			}
			for (Field field: test.getClass().getFields()) {
				ActorFactory afa = field.getAnnotation(ActorFactory.class);
				if (afa!=null) {
					if (afa.filter().trim().length()==0) {
						ServiceTracker<Object,Object> st = new ServiceTracker<Object,Object>(bundleContext, (Class<Object>) field.getType(), null);
						st.open();
						serviceTrackersThreadLocal.get().add(st);
						field.set(test, WebTestUtil.proxyActorFactory(st.waitForService(WAIT_FOR_SERVICE_TIMEOUT)));
					} else {
						String filter = "(&(" + Constants.OBJECTCLASS + "=" + field.getType().getName() + ")"+MessageFormat.format(afa.filter(), getParameters())+")";
						ServiceTracker<Object,Object> st = new ServiceTracker<Object,Object>(bundleContext,	filter,	null);
						st.open();
						serviceTrackersThreadLocal.get().add(st);
						field.set(test, WebTestUtil.proxyActorFactory(st.waitForService(WAIT_FOR_SERVICE_TIMEOUT)));
					}
				} else {
					PageFactory pfa = field.getAnnotation(PageFactory.class);
					if (pfa!=null) {
						if (pfa.filter().trim().length()==0) {
							ServiceTracker<Object,Object> st = new ServiceTracker<Object,Object>(bundleContext, (Class<Object>) field.getType(), null);
							st.open();
							serviceTrackersThreadLocal.get().add(st);
							field.set(test, WebTestUtil.proxyPageFactory(st.waitForService(WAIT_FOR_SERVICE_TIMEOUT)));
						} else {
							String filter = "(&(" + Constants.OBJECTCLASS + "=" + field.getType().getName() + ")"+MessageFormat.format(pfa.filter(), getParameters())+")";
							ServiceTracker<Object,Object> st = new ServiceTracker<Object,Object>(bundleContext,	filter,	null);
							st.open();
							serviceTrackersThreadLocal.get().add(st);
							field.set(test, WebTestUtil.proxyPageFactory(st.waitForService(WAIT_FOR_SERVICE_TIMEOUT)));
						}
					} else {
						Service sa = field.getAnnotation(Service.class);
						if (sa!=null) {
							if (sa.filter().trim().length()==0) {
								ServiceTracker<Object,Object> st = new ServiceTracker<Object,Object>(bundleContext, (Class<Object>) field.getType(), null);
								st.open();
								serviceTrackersThreadLocal.get().add(st);
								field.set(test, st.waitForService(WAIT_FOR_SERVICE_TIMEOUT));
							} else {
								String filter = "(&(" + Constants.OBJECTCLASS + "=" + field.getType().getName() + ")"+MessageFormat.format(sa.filter(), getParameters())+")";
								ServiceTracker<Object,Object> st = new ServiceTracker<Object,Object>(bundleContext,	filter,	null);
								st.open();
								serviceTrackersThreadLocal.get().add(st);
								field.set(test, st.waitForService(WAIT_FOR_SERVICE_TIMEOUT));
							}
						}						
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Factroy injection failed: "+e, e);
		}			
	}

	@SuppressWarnings("unchecked")
	public static <D extends WebDriver> void beforePageInitialization(D driver, Class<? extends Page<D>> pageClass) {
		Screenshot screenshotAnnotation = pageClass.getAnnotation(Screenshot.class);
		long delay = screenshotAnnotation==null ? 0 : screenshotAnnotation.delay();
		Object test = testThreadLocal.get();
		if (test instanceof WebTest) {
			delay += ((WebTest<?>) test).getScreenshotDelay();
		}
		if (shallTakeBeforeScreenshot(screenshotAnnotation)) {
			if (delay>0) {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			if (driver instanceof SketchWebDriver) {
				((Collector<D>) collectorThreadLocal.get()).beforePageInitialization(pageClass, takeSketch(pageClass, (SketchWebDriver) driver, Screenshot.When.BEFORE), WebTestUtil.capturePerformance(driver));				
			} else if (driver instanceof TakesScreenshot) {
				((Collector<D>) collectorThreadLocal.get()).beforePageInitialization(pageClass, takeScreenshot((TakesScreenshot) driver), WebTestUtil.capturePerformance(driver));
			}
		} else {
			((Collector<D>) collectorThreadLocal.get()).beforePageInitialization(pageClass, null, WebTestUtil.capturePerformance(driver));
		}
	}

	@SuppressWarnings("unchecked")
	public static <D extends WebDriver> void afterPageInitialization(
			WebDriver driver,
			Class<? extends Page<D>> pageClass, 
			Page<D> page,
			Throwable th) {
		Screenshot screenshotAnnotation = pageClass.getAnnotation(Screenshot.class);
		long delay = screenshotAnnotation==null ? 0 : screenshotAnnotation.delay();
		Object test = testThreadLocal.get();
		if (test instanceof WebTest) {
			delay += ((WebTest<?>) test).getScreenshotDelay();
		}
		if (th==null) {
			if (shallTakeAfterScreenshot(screenshotAnnotation)) {
				if (delay>0) {
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (driver instanceof SketchWebDriver) {
					((Collector<D>) collectorThreadLocal.get()).afterPageInitialization(pageClass, page, takeSketch(pageClass, (SketchWebDriver) driver, Screenshot.When.AFTER), WebTestUtil.capturePerformance(driver), null);
				} else if (driver instanceof TakesScreenshot) {
					((Collector<D>) collectorThreadLocal.get()).afterPageInitialization(pageClass, page, takeScreenshot((TakesScreenshot) driver), WebTestUtil.capturePerformance(driver), null);
				}
			} else {
				((Collector<D>) collectorThreadLocal.get()).afterPageInitialization(pageClass, page, null, WebTestUtil.capturePerformance(driver), null);
			}
		} else {
			if (shallTakeExceptionScreenshot(screenshotAnnotation)) {
				if (delay>0) {
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (driver instanceof SketchWebDriver) {
					((Collector<D>) collectorThreadLocal.get()).afterPageInitialization(pageClass, page, takeSketch(pageClass, (SketchWebDriver) driver, Screenshot.When.EXCEPTION), WebTestUtil.capturePerformance(driver), th);
				} else if (driver instanceof TakesScreenshot) {
					((Collector<D>) collectorThreadLocal.get()).afterPageInitialization(pageClass, page, takeScreenshot((TakesScreenshot) driver), WebTestUtil.capturePerformance(driver), th);
				}
			} else {
				((Collector<D>) collectorThreadLocal.get()).afterPageInitialization(pageClass, page, null, WebTestUtil.capturePerformance(driver), th);
			}			
		}
	}
	
}
