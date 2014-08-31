package org.nasdanika.webtest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility class
 * 
 * @author Pavel Vlasov
 *
 */
public class WebTestUtil {

	private WebTestUtil() {
		// Utility class.
	}

	/**
	 * Publishes test results to TestResultListener extensions and services.
	 * 
	 * @param testResults
	 */
	public static void publishTestResults(
			Iterable<? extends TestResult> testResults) {
		for (IConfigurationElement ce : Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor("org.nasdanika.webtest.collectors")) {
			if ("test_result_listener".equals(ce.getName())) {
				try (TestResultListener trl = injectProperties(ce,
						(TestResultListener) ce
								.createExecutableExtension("class"))) {
					for (TestResult tr : testResults) {
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
	 * 
	 * @param ce
	 * @param target
	 * @return
	 * @throws Exception
	 */
	public static <T> T injectProperties(IConfigurationElement ce,
			final T target) throws Exception {
		for (IConfigurationElement cce : ce.getChildren()) {
			if ("property".equals(cce.getName())) {
				injectProperty(target, cce.getAttribute("name").split("\\."),
						cce.getAttribute("value"));
			}
		}
		return target;
	}

	private static void injectProperty(Object target, String[] propertyPath,
			String value) throws Exception {
		if (propertyPath.length == 1) {
			String mName = "set"
					+ propertyPath[0].substring(0, 1).toUpperCase()
					+ propertyPath[0].substring(1);

			// Methods
			// String injection first
			for (Method mth : target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length == 1 && mth.getName().equals(mName)
						&& pTypes[0].isAssignableFrom(String.class)) {
					mth.invoke(target, value);
					return;
				}
			}

			// Constructor conversion
			for (Method mth : target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length == 1 && mth.getName().equals(mName)) {
					Class<?> pType = pTypes[0];
					for (Constructor<?> c : pType.getConstructors()) {
						if (c.getParameterTypes().length == 1
								&& c.getParameterTypes()[0].isInstance(value)) {
							mth.invoke(target, c.newInstance(value));
							return;
						}
					}
				}
			}

			// Fields
			for (Field fld : target.getClass().getFields()) {
				if (fld.getType().isAssignableFrom(String.class)) {
					fld.set(target, value);
					return;
				}
			}

			// Constructor conversion
			for (Field fld : target.getClass().getFields()) {
				for (Constructor<?> c : fld.getType().getConstructors()) {
					if (c.getParameterTypes().length == 1
							&& c.getParameterTypes()[0].isInstance(value)) {
						fld.set(target, c.newInstance(value));
						return;
					}
				}
			}

			throw new IllegalArgumentException("Cannot inject property "
					+ propertyPath[0] + " with value '" + value + "' into "
					+ target.getClass().getName());
		} else if (propertyPath.length > 1) {
			String mName = "get"
					+ propertyPath[0].substring(0, 1).toUpperCase()
					+ propertyPath[0].substring(1);
			// Method
			for (Method mth : target.getClass().getMethods()) {
				if (mth.getParameterTypes().length == 0
						&& mth.getName().equals(mName)) {
					Object nextTarget = mth.invoke(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "
								+ mth + " returned null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath,
							1, propertyPath.length), value);
					return;
				}
			}

			// Field
			for (Field fld : target.getClass().getFields()) {
				if (fld.getName().equals(propertyPath[0])) {
					Object nextTarget = fld.get(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "
								+ propertyPath[0] + " is null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath,
							1, propertyPath.length), value);
					return;
				}
			}

			throw new IllegalArgumentException("There is no property "
					+ propertyPath[0] + " in " + target.getClass().getName());
		}
	}

	/**
	 * Creates a collector which publishes to collectors provided by extensions
	 * and also to collectors passed in the chain argument.
	 * 
	 * @param chain
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@SafeVarargs
	public static <D extends WebDriver> Collector<D> createCollector(
			Collector<D>... chain) throws Exception {
		final List<Collector<D>> collectors = new ArrayList<>();
		for (Collector<D> c : chain) {
			if (c != null) {
				collectors.add(c);
			}
		}
		for (IConfigurationElement ce : Platform
				.getExtensionRegistry()
				.getConfigurationElementsFor("org.nasdanika.webtest.collectors")) {
			if ("collector".equals(ce.getName())) {
				collectors.add(injectProperties(ce,
						(Collector<D>) ce.createExecutableExtension("class")));
			}
		}

		// TODO - collect from CollectorFactory services.

		return new Collector<D>() {

			@Override
			public void close() throws Exception {
				for (Collector<D> c : collectors) {
					c.close();
				}
			}

			@Override
			public void onPageProxying(Page<D> page) {
				for (Collector<D> c : collectors) {
					c.onPageProxying(page);
				}
			}

			@Override
			public void onActorProxying(Actor<D> actor) {
				for (Collector<D> c : collectors) {
					c.onActorProxying(actor);
				}
			}

			@Override
			public void beforeTestMethodScreenshot(byte[] screenshot) {
				for (Collector<D> c : collectors) {
					c.beforeTestMethodScreenshot(screenshot);
				}
			}

			@Override
			public void beforeTestMethod(Method method, int index,
					Object[] parameters) {
				for (Collector<D> c : collectors) {
					c.beforeTestMethod(method, index, parameters);
				}
			}

			@Override
			public void beforePageMethod(Page<D> page, byte[] screenshot,
					Method method, Object[] args) {
				for (Collector<D> c : collectors) {
					c.beforePageMethod(page, screenshot, method, args);
				}
			}

			@Override
			public void beforeActorMethod(Actor<D> actor, byte[] screenshot,
					Method method, Object[] args) {
				for (Collector<D> c : collectors) {
					c.beforeActorMethod(actor, screenshot, method, args);
				}
			}

			@Override
			public void afterTestMethodScreenshot(byte[] screenshot) {
				for (Collector<D> c : collectors) {
					c.afterTestMethodScreenshot(screenshot);
				}
			}

			@Override
			public void afterTestMethod(Method method, Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterTestMethod(method, th);
				}
			}

			@Override
			public void afterPageMethod(Page<D> page, byte[] screenshot,
					Method method, Object[] args, Object result, Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterPageMethod(page, screenshot, method, args, result,
							th);
				}
			}

			@Override
			public void afterActorMethod(Actor<D> actor, byte[] screenshot,	Method method, Object[] args, Object result, Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterActorMethod(actor, screenshot, method, args, result,	th);
				}
			}

			@Override
			public void setTest(Object test) {
				for (Collector<D> c : collectors) {
					c.setTest(test);
				}
			}
		};
	}

	/**
	 * Performs waits if page class has {@link Wait} or {@link Waits}
	 * annotations and then invokes {@link PageFactory} method with the same
	 * signature.
	 * 
	 * @param driver
	 * @param pageClassToProxy
	 * @return
	 */
	public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
		doWait(driver, pageClassToProxy);
		return PageFactory.initElements(driver, pageClassToProxy);
	}

	/**
	 * Performs waits if page class has {@link Wait} or {@link Waits}
	 * annotations and then invokes {@link PageFactory} method with the same
	 * signature.
	 * 
	 * @param driver
	 * @param pageClassToProxy
	 * @return
	 */
	public static void initElements(WebDriver driver, Object page) {
		doWait(driver, page.getClass());
		PageFactory.initElements(driver, page);
	}

	/**
	 * Performs waits if page class has {@link Wait} or {@link Waits}
	 * annotations and then invokes {@link PageFactory}
	 * .initElements(ElementLocatorFactory factory, Object page) method.
	 * 
	 * @param driver
	 * @param pageClassToProxy
	 * @return
	 */
	public static void initElements(WebDriver driver,
			ElementLocatorFactory factory, Object page) {
		doWait(driver, page.getClass());
		PageFactory.initElements(factory, page);
	}

	/**
	 * Performs waits if page class has {@link Wait} or {@link Waits}
	 * annotations and then invokes {@link PageFactory}
	 * .initElements(FieldDecorator decorator, Object page) method.
	 * 
	 * @param driver
	 * @param pageClassToProxy
	 * @return
	 */
	public static void initElements(WebDriver driver, FieldDecorator decorator,
			Object page) {
		doWait(driver, page.getClass());
		PageFactory.initElements(decorator, page);
	}

	/**
	 * Reusing annotations class to build By from Wait/Waits by creating
	 * FindBy/FindBys.
	 * 
	 * @author Pavel Vlasov
	 *
	 */
	private static class WaitAnnotations extends Annotations {

		private Wait wait;
		private Waits waits;

		WaitAnnotations(Class<?> pageClass) {
			super(null);
			this.wait = pageClass.getAnnotation(Wait.class);
			this.waits = pageClass.getAnnotation(Waits.class);
		}

		public WaitAnnotations(Method pageMethod) {
			super(null);
			this.wait = pageMethod.getAnnotation(Wait.class);
			this.waits = pageMethod.getAnnotation(Waits.class);
		}

		private void assertValidAnnotations() {
			if (wait != null && waits != null) {
				throw new IllegalArgumentException(
						"If you use a '@Waits' annotation, "
								+ "you must not also use a '@Wait' annotation");
			}
		}

		private By buildBy(final Wait wait) {
			return buildByFromFindBy(new FindBy() {
				
				@Override
				public Class<? extends Annotation> annotationType() {
					return FindBy.class;
				}
				
				@Override
				public String xpath() {
					return wait.xpath();
				}
				
				@Override
				public String using() {
					return wait.using();
				}
				
				@Override
				public String tagName() {
					return wait.tagName();
				}
				
				@Override
				public String partialLinkText() {
					return wait.partialLinkText();
				}
				
				@Override
				public String name() {
					return wait.name();
				}
				
				@Override
				public String linkText() {
					return wait.linkText();
				}
				
				@Override
				public String id() {
					return wait.id();
				}
				
				@Override
				public How how() {
					return wait.how();
				}
				
				@Override
				public String css() {
					return wait.css();
				}
				
				@Override
				public String className() {
					return wait.className();
				}
			});
		}

		void doWait(WebDriver driver) {
			//assertValidAnnotations(); No harm to have both wait and waits.
			if (waits!=null) {
				for (Wait wait: waits.value()) {
					doWait(driver, wait);
				}
			}
			if (wait!=null) {
				doWait(driver, wait);
			}
		}

		private void doWait(WebDriver driver, Wait wait) {
			WebDriverWait wdw = new WebDriverWait(driver, wait.timeout());
			By locator = buildBy(wait);
			ExpectedCondition<?> condition;
			switch (wait.condition()) {
			case CLICKABLE:
				condition = ExpectedConditions.elementToBeClickable(locator);
			break;
			case INVISIBLE:
				condition = ExpectedConditions.invisibilityOfElementLocated(locator);
				break;
			case PRESENT:
				if (wait.all()) {
					condition = ExpectedConditions.presenceOfAllElementsLocatedBy(locator);
				} else {
					condition = ExpectedConditions.presenceOfElementLocated(locator);
				}
				break;
			case VISIBLE:
				if (wait.all()) {
					condition = ExpectedConditions.visibilityOfAllElementsLocatedBy(locator);
				} else {
					condition = ExpectedConditions.visibilityOfElementLocated(locator);
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected condition: "+wait.condition());
			
			}
			if (wait.not()) {
				condition = ExpectedConditions.not(condition);
			}
			wdw.until(condition);			
		}

	}

	private static void doWait(WebDriver driver, Class<?> pageClass) {
		new WaitAnnotations(pageClass).doWait(driver);
	}
	
	static void doWait(WebDriver driver, Method pageMethod) {
		new WaitAnnotations(pageMethod).doWait(driver);
	}
	
}
