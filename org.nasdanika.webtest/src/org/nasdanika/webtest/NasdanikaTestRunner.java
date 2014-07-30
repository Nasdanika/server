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
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * @author Pavel Vlasov
 *
 */
public class NasdanikaTestRunner extends BlockJUnit4ClassRunner implements TestResultSource {
	
	private static ThreadLocal<Collector> collectorThreadLocal = new ThreadLocal<Collector>() {
		
		protected Collector initialValue() {
			// NOP Collector to avoid exceptions.
			return new Collector() {

				@Override
				public void onPageProxying(Page page) {}

				@Override
				public void beforePageMethod(Page page, Method method, Object[] args) {}

				@Override
				public void afterPageMethod(Page page, Method method, Object[] args, Object result, Throwable th) {}

				@Override
				public void onActorProxying(Actor actor) {}

				@Override
				public void beforeActorMethod(Actor actor, Method method, Object[] args) {}

				@Override
				public void afterActorMethod(Actor actor, Method method, Object[] args, Object result, Throwable th) {}

				@Override
				public void beforeTestMethod(Object test, Method method) {}
				
				@Override
				public void afterTestMethod(Object test, Method method,	Throwable th) {}
				
			};
		};
		
	};
	
	private static class PageInvocationHandler implements InvocationHandler {
		
		private Page page;

		PageInvocationHandler(Page page) {
			this.page = page;
			collectorThreadLocal.get().onPageProxying(page);
		}
		
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (Page.class.isAssignableFrom(method.getDeclaringClass())) {
				collectorThreadLocal.get().beforePageMethod(page, method, args);
				try {
					Object res = method.invoke(page, args);
					collectorThreadLocal.get().afterPageMethod(page, method, args, res, null);
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
					collectorThreadLocal.get().afterPageMethod(page, method, args, null, th);
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
				collectorThreadLocal.get().beforeActorMethod(actor, method, args);
				try {
					Object res = method.invoke(actor, args);
					collectorThreadLocal.get().afterActorMethod(actor, method, args, res, null);
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
					collectorThreadLocal.get().afterActorMethod(actor, method, args, null, th);
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
	
	private NasdanikaTestSuite suite;

	public NasdanikaTestRunner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	@Override
	public void setSuite(NasdanikaTestSuite suite) {
		this.suite = suite;		
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
			
	@Override
	public void run(RunNotifier notifier) {
		
		AtomicLong counter = suite==null ? new AtomicLong() : suite.getCounter();
				
		try {
			File outputDir = suite == null ? configOutputDir(getTestClass().getJavaClass()) : suite.getOutputDir();	
			
			File screenshotsDir = new File(outputDir, "screenshots");
			if (!screenshotsDir.exists() && !screenshotsDir.mkdir()) {
				throw new IOException("Could not create screenshot output directory "+screenshotsDir.getAbsolutePath());			
			}
			
			Executor screenshotExecutor = suite==null ? Executors.newSingleThreadExecutor() : suite.getScreenshotExecutor();
			
			TestResult testResult = new TestResult(getTestClass().getJavaClass(), counter, screenshotsDir, screenshotExecutor);
			Collector prevCollector = collectorThreadLocal.get();
			collectorThreadLocal.set(testResult);
			try {
				super.run(notifier);
			} finally {
				collectorThreadLocal.set(prevCollector);
				if (suite==null) {
					((ExecutorService) screenshotExecutor).shutdown();
					((ExecutorService) screenshotExecutor).awaitTermination(1, TimeUnit.MINUTES);
					new ReportGenerator(getTestClass().getJavaClass(), outputDir, Collections.singleton(testResult)).generate();
				} else {
					suite.addResult(testResult);
				}
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
	protected Statement methodInvoker(final FrameworkMethod method, final Object test) {		
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
		    	try {
			    	collectorThreadLocal.get().beforeTestMethod(test, method.getMethod());
			    	if (!isPending) {
			    		method.invokeExplosively(test);
			    	}
		    		collectorThreadLocal.get().afterTestMethod(test, method.getMethod(), null);
		    	} catch (Throwable th) {
		    		collectorThreadLocal.get().afterTestMethod(test, method.getMethod(), th);
		    		throw th;
		    	}
		    }
		    
		};
	}

}
