package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Base class for test runners which report results to {@link Collector}.
 * @author Pavel Vlasov
 *
 */
public abstract class AbstractNasdanikaWebTestRunner extends BlockJUnit4ClassRunner implements TestResultSource {
	
	private static final int SCREENSHOT_ATTEMPTS = 5;

	private static final int SCREENSHOT_RETAKE_WAIT_INTERVAL = 2000;

	private static ThreadLocal<Collector> collectorThreadLocal = new ThreadLocal<Collector>() {
		
		protected Collector initialValue() {
			// NOP Collector to avoid exceptions.
			return new Collector() {

				@Override
				public void onPageProxying(Page page) {}

				@Override
				public void beforePageMethod(Page page, byte[] screenshot, Method method, Object[] args) {}

				@Override
				public void afterPageMethod(Page page, byte[] screenshot, Method method, Object[] args, Object result, Throwable th) {}

				@Override
				public void onActorProxying(Actor actor) {}

				@Override
				public void beforeActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args) {}

				@Override
				public void afterActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args, Object result, Throwable th) {}

				@Override
				public void beforeTestMethod(Method method, Object[] parameters) {}

				@Override
				public void beforeTestMethodScreenshot(byte[] screenshot) {}

				@Override
				public void afterTestMethod(Method method, Throwable th) {}

				@Override
				public void afterTestMethodScreenshot(byte[] screenshot) {}

				@Override
				public void close() throws Exception {}

				@Override
				public void setTest(Object test) {}
				
			};
		};
		
	};
	
	private static ThreadLocal<Object> testThreadLocal = new ThreadLocal<Object>();
	
	private static byte[] takeScreenshot() {
		Object test = testThreadLocal.get();
		if (test instanceof WebTest) {
			WebDriver webDriver = ((WebTest) test).getWebDriver();
			if (webDriver instanceof TakesScreenshot) {
				for (int i=0; ; ++i) {
					try {
						return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
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
			}
		}
		return null;
	}
	
	private static class PageInvocationHandler implements InvocationHandler {
		
		private Page page;

		PageInvocationHandler(Page page) {
			this.page = page;
			collectorThreadLocal.get().onPageProxying(page);
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (Page.class.isAssignableFrom(method.getDeclaringClass())) {
				collectorThreadLocal.get().beforePageMethod(page, takeScreenshot(), method, args);
				try {
					Object res = method.invoke(page, args);
					collectorThreadLocal.get().afterPageMethod(page, takeScreenshot(), method, args, res, null);
					if (res instanceof Page) {
						Class<? extends Object> resClass = res.getClass();
						if (Proxy.isProxyClass(resClass) && this.equals(Proxy.getInvocationHandler(res))) {
							return res;
						}
						return Proxy.newProxyInstance(
								resClass.getClassLoader(), 
								allInterfaces(resClass).toArray(new Class[0]), 
								new PageInvocationHandler((Page) res));
					}
					
					return res;
				} catch (Throwable th) {
					collectorThreadLocal.get().afterPageMethod(page, takeScreenshot(), method, args, null, th);
					throw th;
				}
			}
			
			return method.invoke(page, args); // No recording for non-page methods.
		}
	};
	
	/**
	 * Creates a proxy for a page factory which in turn proxies pages created by the factory.
	 * Page proxies associate test executions and actor methods calls with invocations of page methods (steps). 
	 * @param actorFactory
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T proxyPageFactory(final T pageFactory) {
		Class<? extends Object> pageFactoryClass = pageFactory.getClass();
		return (T) Proxy.newProxyInstance(
				pageFactoryClass.getClassLoader(), 
				allInterfaces(pageFactoryClass).toArray(new Class[0]), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object ret = method.invoke(pageFactory, args);
						if (ret instanceof Page) {
							Class<? extends Object> retClass = ret.getClass();
							if (Proxy.isProxyClass(retClass) && this.equals(Proxy.getInvocationHandler(ret))) {
								return ret;
							}
							return Proxy.newProxyInstance(
									retClass.getClassLoader(), 
									allInterfaces(retClass).toArray(new Class[0]), 
									new PageInvocationHandler((Page) ret));
						}
						return ret;
					}
				});
	}		
	
	private static class ActorInvocationHandler implements InvocationHandler {
		
		private Actor actor;

		ActorInvocationHandler(Actor actor) {
			this.actor = actor;
			collectorThreadLocal.get().onActorProxying(actor);
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (Actor.class.isAssignableFrom(method.getDeclaringClass())) {
				collectorThreadLocal.get().beforeActorMethod(actor, takeScreenshot(), method, args);
				try {
					Object res = method.invoke(actor, args);
					collectorThreadLocal.get().afterActorMethod(actor, takeScreenshot(), method, args, res, null);
					if (res instanceof Actor) {
						Class<? extends Object> resClass = res.getClass();
						if (Proxy.isProxyClass(resClass) && this.equals(Proxy.getInvocationHandler(res))) {
							return res;
						}
						return Proxy.newProxyInstance(
								resClass.getClassLoader(), 
								allInterfaces(resClass).toArray(new Class[0]),  
								new ActorInvocationHandler((Actor) res));
					}
					
					return res;
				} catch (Throwable th) {
					collectorThreadLocal.get().afterActorMethod(actor, takeScreenshot(), method, args, null, th);
					throw th;
				}
			}
			
			return method.invoke(actor, args); // No recording for non-actor methods.
		}
	};
	
	/**
	 * Creates a proxy for an actor factory which in turn proxies actors created by the factory.
	 * Actor proxies associate test executions with invocations of actor methods (steps). 
	 * @param actorFactory
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T proxyActorFactory(final T actorFactory) {
		Class<? extends Object> actorFactoryClass = actorFactory.getClass();
		return (T) Proxy.newProxyInstance(
				actorFactoryClass.getClassLoader(), 
				allInterfaces(actorFactoryClass).toArray(new Class[0]),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object ret = method.invoke(actorFactory, args);
						if (ret instanceof Actor) {
							Class<? extends Object> retClass = ret.getClass();
							if (Proxy.isProxyClass(retClass) && this.equals(Proxy.getInvocationHandler(ret))) {
								return ret;
							}
							return Proxy.newProxyInstance(
									retClass.getClassLoader(), 
									allInterfaces(retClass).toArray(new Class[0]),  
									new ActorInvocationHandler((Actor) ret));
						}
						return ret;
					}
				});
	}
	
	static List<Class<?>> allInterfaces(Class<?> klass) {
		if (klass==null) {
			return Collections.emptyList();
		}
		List<Class<?>> ret = new ArrayList<Class<?>>(Arrays.asList(klass.getInterfaces()));
		Z: for (Class<?> i: allInterfaces(klass.getSuperclass())) {
			for (Class<?> ei: ret) {
				if (i.isAssignableFrom(ei)) {
					continue Z;
				}
			}
			ret.add(i);
		}
		return ret;
	}
	
	protected TestResultCollector testResultCollector;

	protected AbstractNasdanikaWebTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	public void setTestResultCollector(TestResultCollector testResultCollector) {
		this.testResultCollector = testResultCollector;		
	}
		
	static void delete(File file) throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File c: file.listFiles()) {
					delete(c);
				}
			}
			if (!file.delete()) {
				throw new IOException("Output directory cleanup failed - could not delete "+file.getAbsolutePath());				
			}
		} 
	}	
	
	protected abstract Collector createCollector(TestResultCollector testResultCollector) throws Exception;
			
	@Override
	public void run(RunNotifier notifier) {
		try {
			Collector prevCollector = collectorThreadLocal.get();
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
				delete(c);
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
			    	collectorThreadLocal.get().beforeTestMethod(method.getMethod(), getParameters());
			    	try {
			    		superStatement.evaluate();
			    		collectorThreadLocal.get().afterTestMethod(method.getMethod(), null);
			    	} catch (Throwable th) {
			    		collectorThreadLocal.get().afterTestMethod(method.getMethod(), th);
			    		throw th;
			    	}
				}
			}
			
		};
	}
	
	/**
	 * @return Test parameters if test is parameterized.
	 */
	protected Object[] getParameters() {
		return null;
	}
	
	@Override
	protected Statement methodInvoker(final FrameworkMethod method, final Object test) {		
		return new Statement() {

		    @Override
		    public void evaluate() throws Throwable {
		    	try {		    		
		    		testThreadLocal.set(test);
		    		collectorThreadLocal.get().setTest(test);
		    		collectorThreadLocal.get().beforeTestMethodScreenshot(takeScreenshot());
			    	method.invokeExplosively(test);
		    	} finally {
		    		collectorThreadLocal.get().afterTestMethodScreenshot(takeScreenshot());
		    		testThreadLocal.set(null);
		    	}
		    }
		    
		};
	}

}
