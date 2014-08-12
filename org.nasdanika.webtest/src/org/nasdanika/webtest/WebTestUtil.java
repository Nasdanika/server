package org.nasdanika.webtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Utility class 
 * @author Pavel Vlasov
 *
 */
public class WebTestUtil {
	
	private WebTestUtil() {
		// Utility class.
	}
	
	/**
	 * Publishes test results to TestResultListener extensions and services.
	 * @param testResults
	 */
	public static void publishTestResults(Iterable<? extends TestResult> testResults) {
		for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor("org.nasdanika.webtest.collectors")) {
			if ("test_result_listener".equals(ce.getName())) {
				try (TestResultListener trl = injectProperties(ce, (TestResultListener) ce.createExecutableExtension("class"))) {
					for (TestResult tr: testResults) {
						trl.addResult(tr);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}					
		}			
	}
	
	/**
	 * Injects properties from configuration element.
	 * @param ce
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public static <T> T injectProperties(IConfigurationElement ce, final T target) throws Exception {
		for (IConfigurationElement cce: ce.getChildren()) {
			if ("property".equals(cce.getName())) {
				injectProperty(target, cce.getAttribute("name").split("\\."), cce.getAttribute("value"));
			}
		}
		return target;
	}

	private static void injectProperty(Object target, String[] propertyPath, String value) throws Exception {
		if (propertyPath.length==1) {
			String mName = "set"+propertyPath[0].substring(0, 1).toUpperCase()+propertyPath[0].substring(1);
			
			// Methods
			// String injection first
			for (Method mth: target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length==1 && mth.getName().equals(mName) && pTypes[0].isAssignableFrom(String.class)) {
					mth.invoke(target, value);
					return;
				}								
			}
			
			// Constructor conversion 
			for (Method mth: target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length==1 && mth.getName().equals(mName)) {
					Class<?> pType = pTypes[0];
					for (Constructor<?> c: pType.getConstructors()) {
						if (c.getParameterTypes().length==1 && c.getParameterTypes()[0].isInstance(value)) {
							mth.invoke(target, c.newInstance(value));
							return;
						}
					}
				}								
			}
			
			// Fields
			for (Field fld: target.getClass().getFields()) {
				if (fld.getType().isAssignableFrom(String.class)) {
					fld.set(target, value);
					return;
				}								
			}
			
			// Constructor conversion 
			for (Field fld: target.getClass().getFields()) {
				for (Constructor<?> c: fld.getType().getConstructors()) {
					if (c.getParameterTypes().length==1 && c.getParameterTypes()[0].isInstance(value)) {
						fld.set(target, c.newInstance(value));
						return;
					}
				}
			}
			
			throw new IllegalArgumentException("Cannot inject property "+propertyPath[0]+" with value '"+value+"' into "+target.getClass().getName());
		} else if (propertyPath.length>1) {
			String mName = "get"+propertyPath[0].substring(0, 1).toUpperCase()+propertyPath[0].substring(1);
			// Method
			for (Method mth: target.getClass().getMethods()) {
				if (mth.getParameterTypes().length==0 && mth.getName().equals(mName)) {
					Object nextTarget = mth.invoke(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "+mth+" returned null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath, 1, propertyPath.length), value);
					return;
				}
			}
			
			// Field
			for (Field fld: target.getClass().getFields()) {
				if (fld.getName().equals(propertyPath[0])) {
					Object nextTarget = fld.get(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "+propertyPath[0]+" is null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath, 1, propertyPath.length), value);
					return;
				}
			}			
			
			throw new IllegalArgumentException("There is no property "+propertyPath[0]+" in "+target.getClass().getName());			
		}
	}

	/**
	 * Creates a collector which publishes to collectors provided by extensions and also
	 * to collectors passed in the chain argument.
	 * @param chain
	 * @return
	 * @throws Exception
	 */
	public static Collector createCollector(Collector... chain) throws Exception {
		final List<Collector> collectors = new ArrayList<>();
		for (Collector c: chain) {
			if (c!=null) {
				collectors.add(c);
			}
		}
		for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor("org.nasdanika.webtest.collectors")) {
			if ("collector".equals(ce.getName())) {
				collectors.add(injectProperties(ce, (Collector) ce.createExecutableExtension("class")));
			}					
		}	
		
		// TODO - collect from CollectorFactory services.
		
		return new Collector() {
			
			@Override
			public void close() throws Exception {
				for (Collector c: collectors) {
					c.close();
				}				
			}
			
			@Override
			public void onPageProxying(Page page) {
				for (Collector c: collectors) {
					c.onPageProxying(page);
				}
			}
			
			@Override
			public void onActorProxying(Actor actor) {
				for (Collector c: collectors) {
					c.onActorProxying(actor);
				}
			}
			
			@Override
			public void beforeTestMethodScreenshot(byte[] screenshot) {
				for (Collector c: collectors) {
					c.beforeTestMethodScreenshot(screenshot);
				}
			}
			
			@Override
			public void beforeTestMethod(Method method, Object[] parameters) {
				for (Collector c: collectors) {
					c.beforeTestMethod(method, parameters);
				}
			}
			
			@Override
			public void beforePageMethod(Page page, byte[] screenshot, Method method, Object[] args) {
				for (Collector c: collectors) {
					c.beforePageMethod(page, screenshot, method, args);
				}
			}
			
			@Override
			public void beforeActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args) {
				for (Collector c: collectors) {
					c.beforeActorMethod(actor, screenshot, method, args);
				}
			}
			
			@Override
			public void afterTestMethodScreenshot(byte[] screenshot) {
				for (Collector c: collectors) {
					c.afterTestMethodScreenshot(screenshot);
				}
			}
			
			@Override
			public void afterTestMethod(Method method, Throwable th) {
				for (Collector c: collectors) {
					c.afterTestMethod(method, th);
				}
			}
			
			@Override
			public void afterPageMethod(Page page, byte[] screenshot, Method method, Object[] args, Object result, Throwable th) {
				for (Collector c: collectors) {
					c.afterPageMethod(page, screenshot, method, args, result, th);
				}
			}
			
			@Override
			public void afterActorMethod(Actor actor, byte[] screenshot, Method method, Object[] args, Object result, Throwable th) {
				for (Collector c: collectors) {
					c.afterActorMethod(actor, screenshot, method, args, result, th);
				}
			}

			@Override
			public void setTest(Object test) {
				for (Collector c: collectors) {
					c.setTest(test);
				}
			}
		};
	}

}
