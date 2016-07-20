package org.nasdanika.webtest;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.nasdanika.webtest.model.Descriptor;
import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public static void publishTestResults(Iterable<? extends TestResult> testResults) {
		for (IConfigurationElement ce : Platform.getExtensionRegistry().getConfigurationElementsFor("org.nasdanika.webtest.collectors")) {
			if ("test_result_listener".equals(ce.getName())) {
				try (TestResultListener trl = injectProperties(ce, (TestResultListener) ce.createExecutableExtension("class"))) {
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
	public static <T> T injectProperties(IConfigurationElement ce, final T target) throws Exception {
		for (IConfigurationElement cce : ce.getChildren()) {
			if ("property".equals(cce.getName())) {
				injectProperty(target, cce.getAttribute("name").split("\\."),
						cce.getAttribute("value"));
			}
		}
		return target;
	}

	private static void injectProperty(Object target, String[] propertyPath, String value) throws Exception {
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
						throw new NullPointerException("Cannot set property: "	+ mth + " returned null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath,	1, propertyPath.length), value);
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
	public static <D extends WebDriver> Collector<D> createCollector(Collector<D>... chain) throws Exception {
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
				collectors.add(injectProperties(ce,	(Collector<D>) ce.createExecutableExtension("class")));
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
			public void beforeTestMethodScreenshot(byte[] screenshot, JSONObject performance) {
				for (Collector<D> c : collectors) {
					c.beforeTestMethodScreenshot(screenshot, performance);
				}
			}

			@Override
			public void beforeTestMethod(Method method, int index, Object[] parameters) {
				for (Collector<D> c : collectors) {
					c.beforeTestMethod(method, index, parameters);
				}
			}

			@Override
			public void beforePageMethod(
					Page<D> page, 
					byte[] screenshot, 
					JSONObject performance,
					Method method, Object[] args) {
				for (Collector<D> c : collectors) {
					c.beforePageMethod(page, screenshot, performance, method, args);
				}
			}

			@Override
			public void beforeActorMethod(
					Actor<D> actor, 
					byte[] screenshot, 
					JSONObject performance,
					Method method, 
					Object[] args) {
				for (Collector<D> c : collectors) {
					c.beforeActorMethod(actor, screenshot, performance, method, args);
				}
			}

			@Override
			public void afterTestMethodScreenshot(byte[] screenshot, JSONObject performance) {
				for (Collector<D> c : collectors) {
					c.afterTestMethodScreenshot(screenshot, performance);
				}
			}

			@Override
			public void afterTestMethod(Method method, Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterTestMethod(method, th);
				}
			}

			@Override
			public void afterPageMethod(
					Page<D> page, 
					byte[] screenshot, 
					JSONObject performance,
					Method method, 
					Object[] args, 
					Object result, 
					Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterPageMethod(page, screenshot, performance, method, args, result, th);
				}
			}

			@Override
			public void afterActorMethod(Actor<D> actor, byte[] screenshot, JSONObject performance,	Method method, Object[] args, Object result, Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterActorMethod(actor, screenshot, performance, method, args, result, th);
				}
			}

			@Override
			public void setTest(Object test) {
				for (Collector<D> c : collectors) {
					c.setTest(test);
				}
			}

			@Override
			public void beforePageInitialization(Class<? extends Page<D>> pageClass, byte[] screenshot, JSONObject performance) {
				for (Collector<D> c : collectors) {
					c.beforePageInitialization(pageClass, screenshot, performance);
				}
			}

			@Override
			public void afterPageInitialization(Class<? extends Page<D>> pageClass, Page<D> page, byte[] screenshot, JSONObject performance, Throwable th) {
				for (Collector<D> c : collectors) {
					c.afterPageInitialization(pageClass, page, screenshot, performance, th);
				}
			}

			@Override
			public void onScreenshot(byte[] screenshot, String comment) {
				for (Collector<D> c : collectors) {
					c.onScreenshot(screenshot, comment);
				}
			}
			
			@Override
			public AnnotatedElement getCurrentOperation() {
				for (Collector<D> c : collectors) {
					AnnotatedElement ret = c.getCurrentOperation();
					if (ret != null) {
						return ret;
					}
				}
				return null;
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
	@SuppressWarnings("unchecked")
	public static <D extends WebDriver, T extends Page<D>> T initElements(D driver, Class<T> pageClassToProxy, Object... args) {
		doWait(driver, pageClassToProxy);
		AbstractNasdanikaWebTestRunner.beforePageInitialization(driver, pageClassToProxy);
		String originalContext = null;
		try {
			Context ctxAnn = pageClassToProxy.getAnnotation(Context.class);
			for (Class<?> cls = pageClassToProxy.getSuperclass(); ctxAnn==null && cls!=null && Page.class.isAssignableFrom(cls); cls=cls.getSuperclass()) {
				ctxAnn = cls.getAnnotation(Context.class);
			}
			
			if (ctxAnn!=null && driver instanceof ContextAware) {
				originalContext = ((ContextAware) driver).getContext();
				if (ctxAnn.value().equals(originalContext)) {
					originalContext = null; 
				} else {
					((ContextAware) driver).context(ctxAnn.value());
				}
			}
			T page = null;
			if (args.length==0) {
				page = PageFactory.initElements(driver, pageClassToProxy);
			} else {
				Object[] cArgs = new Object[args.length+1];
				cArgs[0] = driver;
				System.arraycopy(args, 0, cArgs, 1, args.length);
				Z: for (Constructor<?> constructor: pageClassToProxy.getConstructors()) {
					Class<?>[] pt = constructor.getParameterTypes();
					if (cArgs.length==pt.length) {
						for (int i=0; i<cArgs.length; ++i) {
							if (cArgs[i]!=null && !pt[i].isInstance(cArgs[i])) {
								continue Z;
							}
						}
						try {
							page = (T) constructor.newInstance(cArgs);
							PageFactory.initElements(driver, page);
						} catch (Exception e) {
							throw new WebTestException(e);
						}
						break;
					}
				}
				if (page == null) {
					throw new WebTestException("No constructor for "+pageClassToProxy+" which can accepts arguments "+Arrays.toString(cArgs));
				}
			}
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, pageClassToProxy, page, null);
			return page;
		} catch (Throwable th) {
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, pageClassToProxy, null, th);
			throw th;
		} finally {
			if (originalContext!=null && driver instanceof ContextAware) {
				((ContextAware) driver).context(originalContext);
			}			
		}
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
	@SuppressWarnings("unchecked")
	public static void initElements(WebDriver driver, Page<WebDriver> page) {
		doWait(driver, page.getClass());
		AbstractNasdanikaWebTestRunner.beforePageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass());
		try {
			PageFactory.initElements(driver, page);
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass(), page, null);
		} catch (Throwable th) {
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass(), page, th);
			throw th;
		}
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
	@SuppressWarnings("unchecked")
	public static void initElements(WebDriver driver, ElementLocatorFactory factory, Page<WebDriver> page) {
		doWait(driver, page.getClass());
		AbstractNasdanikaWebTestRunner.beforePageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass());
		try {
			PageFactory.initElements(factory, page);
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass(), page, null);
		} catch (Throwable th) {
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass(), page, th);
			throw th;
		}
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
	@SuppressWarnings("unchecked")
	public static void initElements(WebDriver driver, FieldDecorator decorator,	Page<WebDriver> page) {
		doWait(driver, page.getClass());
		AbstractNasdanikaWebTestRunner.beforePageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass());
		try {
			PageFactory.initElements(decorator, page);
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass(), page, null);
		} catch (Throwable th) {
			AbstractNasdanikaWebTestRunner.afterPageInitialization(driver, (Class<? extends Page<WebDriver>>) page.getClass(), page, th);
			throw th;
		}
	}

	/**
	 * Reusing annotations class to build By from Wait/Waits by creating
	 * FindBy/FindBys.
	 * 
	 * @author Pavel Vlasov
	 *
	 */
	private static class WaitAnnotations extends Annotations {

		private List<Wait> waitList = new ArrayList<>();
		private Class<?> pageClass;

		WaitAnnotations(Class<?> pageClass) {
			super(null);
			this.pageClass = pageClass;
			
			List<Class<?>> inheritanceChain = new ArrayList<Class<?>>();
			for (Class<?> cls = pageClass; cls!=null && Page.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
				inheritanceChain.add(cls);
			}
			Collections.reverse(inheritanceChain);
			for (Class<?> pCls: inheritanceChain) {				
				Wait wait = pCls.getAnnotation(Wait.class);
				if (wait!=null) {
					waitList.add(wait);
				}
				Waits waits = pCls.getAnnotation(Waits.class);
				if (waits!=null) {
					waitList.addAll(Arrays.asList(waits.value()));
				}
			}
		}

		public WaitAnnotations(Method pageMethod) {
			super(null);
			Wait wait = pageMethod.getAnnotation(Wait.class);
			if (wait!=null) {
				waitList.add(wait);
			}
			Waits waits = pageMethod.getAnnotation(Waits.class);
			if (waits!=null) {
				waitList.addAll(Arrays.asList(waits.value()));
			}
		}

//		private void assertValidAnnotations() {
//			if (wait != null && waits != null) {
//				throw new IllegalArgumentException(
//						"If you use a '@Waits' annotation, "
//								+ "you must not also use a '@Wait' annotation");
//			}
//		}

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
			for (Wait wait: waitList) {
				doWait(driver, wait);
			}
		}

		private void doWait(WebDriver driver, Wait wait) {
			String originalContext = null;
			try {
				String waitContext = wait.context();
				if (waitContext.length()==0) {
					Context ctxAnn = pageClass.getAnnotation(Context.class);
					for (Class<?> cls = pageClass.getSuperclass(); ctxAnn==null && cls!=null && Page.class.isAssignableFrom(cls); cls=cls.getSuperclass()) {
						ctxAnn = cls.getAnnotation(Context.class);
					}
					if (ctxAnn!=null) {
						waitContext = ctxAnn.value();
					}
				}
				
				if (waitContext.length()>0 && driver instanceof ContextAware) {
					originalContext = ((ContextAware) driver).getContext();
					if (waitContext.equals(originalContext)) {
						originalContext = null;
					} else {
						((ContextAware) driver).context(waitContext);
					}
				}
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
			} finally {
				if (originalContext!=null && driver instanceof ContextAware) {
					((ContextAware) driver).context(originalContext);
				}				
			}
		}

	}
	
	public static JSONObject capturePerformance(WebDriver webDriver) {
		if ("true".equals(System.getenv("NASDANIKA_WEBTEST_CAPTURE_PERFORMANCE")) && webDriver instanceof JavascriptExecutor) {
			try {
				Object perfData = ((JavascriptExecutor) webDriver).executeScript("return JSON.stringify(window.performance ? {timestamp: Date.now(), href: window.location.href, timing: window.performance.timing, entries: typeof window.performance.getEntries === 'function' && window.performance.getEntries()} : {timestamp: Date.now(), href: window.location.href});");				
				if (perfData instanceof String) {
					return new JSONObject((String) perfData);
				}
			} catch (Exception e) {
				System.err.println("Error reading performance data: "+e);
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public static void doWait(WebDriver driver, Class<?> pageClass) {
		new WaitAnnotations(pageClass).doWait(driver);
	}
	
	public static void doWait(WebDriver driver, Method pageMethod) {
		new WaitAnnotations(pageMethod).doWait(driver);
	}
		
	static void qualifiedNameAndTitleAndDescriptionAndLinksToJSON(Class<?> klass, JSONObject target) throws JSONException {
		target.put("qualifiedName", klass.getName());
		titleAndDescriptionAndLinksToJSON(klass, target);
		if (!target.has("title")) {
			String className = klass.getName().substring(klass.getName().lastIndexOf('.')+1);		
			StringBuilder titleBuilder = new StringBuilder();
			String[] scna = StringUtils.splitByCharacterTypeCamelCase(className);
			for (int i=0; i<scna.length; ++i) {
				if (i==0) {
					titleBuilder.append(StringUtils.capitalize(scna[i]));
				} else {
					titleBuilder.append(" ");
					if (scna[i].length()>1 && Character.isUpperCase(scna[i].charAt(1))) {
						titleBuilder.append(scna[i]);
					} else {
						titleBuilder.append(StringUtils.uncapitalize(scna[i]));
					}
				}
			}
			target.put("title", titleBuilder.toString());
		}
	}
		
	static void qualifiedNameAndTitleAndDescriptionAndLinksToDescriptor(Class<?> klass, Descriptor target) {
		target.setQualifiedName(klass.getName());
		titleAndDescriptionAndLinksToDescriptor(klass, target);
		if (isBlank(target.getTitle())) {
			String className = klass.getName().substring(klass.getName().lastIndexOf('.')+1);		
			StringBuilder titleBuilder = new StringBuilder();
			String[] scna = StringUtils.splitByCharacterTypeCamelCase(className);
			for (int i=0; i<scna.length; ++i) {
				if (i==0) {
					titleBuilder.append(StringUtils.capitalize(scna[i]));
				} else {
					titleBuilder.append(" ");
					if (scna[i].length()>1 && Character.isUpperCase(scna[i].charAt(1))) {
						titleBuilder.append(scna[i]);
					} else {
						titleBuilder.append(StringUtils.uncapitalize(scna[i]));
					}
				}
			}
			target.setTitle(titleBuilder.toString());
		}
	}	
	
	static String title(String name) {
		StringBuilder titleBuilder = new StringBuilder();
		String[] scna = StringUtils.splitByCharacterTypeCamelCase(name);
		for (int i=0; i<scna.length; ++i) {
			if (i==0) {
				titleBuilder.append(StringUtils.capitalize(scna[i]));
			} else {
				titleBuilder.append(" ");
				if (scna[i].length()>1 && Character.isUpperCase(scna[i].charAt(1))) {
					titleBuilder.append(scna[i]);
				} else {
					titleBuilder.append(StringUtils.uncapitalize(scna[i]));
				}
			}
		}
		return titleBuilder.toString();
	}

	static void titleAndDescriptionAndLinksToJSON(AnnotatedElement annotated, JSONObject target) throws JSONException {
		Title title = annotated.getAnnotation(Title.class);
		toJSON(title, target);
		toJSON(annotated.getAnnotation(Description.class), target);
		toJSON(annotated.getAnnotation(Links.class), target);
		toJSON(annotated.getAnnotation(Link.class), target);
	}

	static void titleAndDescriptionAndLinksToDescriptor(AnnotatedElement annotated, Descriptor target) {
		Title title = annotated.getAnnotation(Title.class);
		toDescriptor(title, target);
		toDescriptor(annotated.getAnnotation(Description.class), target);
		toDescriptor(annotated.getAnnotation(Links.class), target);
		toDescriptor(annotated.getAnnotation(Link.class), target);
	}

	static void toJSON(Title title, JSONObject target) throws JSONException {
		if (title!=null) {
			target.put("title", title.value());
		}
	}

	static void toJSON(Description description, JSONObject target) throws JSONException {
		if (description!=null) {
			JSONObject jd = new JSONObject();
			target.put("description", jd);
			if (!isBlank(description.url())) {
				jd.put("url", description.url());
			}
			if ("text/html".equalsIgnoreCase(description.contentType())) {
				jd.put("html", true);
			}
			JSONArray jdv = new JSONArray();
			jd.put("value", jdv);
			for (String v: description.value()) {
				jdv.put(v);
			}
		}
	}
	
	static void toJSON(Links links, JSONObject target) throws JSONException {
		if (links!=null) {
			JSONArray linksArray = new JSONArray();
			target.put("links", linksArray);
			for (Link link: links.value()) {
				JSONObject linkObj = new JSONObject();
				linkObj.put("value", link.value());
				linkObj.put("type", link.type());
				linksArray.put(linkObj);
			}
		}
	}	
	
	static void toJSON(Link link, JSONObject target) throws JSONException {
		if (link!=null) {
			JSONArray linksArray = new JSONArray();
			target.put("links", linksArray);
			JSONObject linkObj = new JSONObject();
			linkObj.put("value", link.value());
			linkObj.put("type", link.type());
			linksArray.put(linkObj);
		}
	}	
	
	static void toDescriptor(Title title, Descriptor target) {
		if (title!=null) {
			target.setTitle(title.value());
		}
	}

	static void toDescriptor(Description description, Descriptor target) {
		if (description!=null) {
			org.nasdanika.webtest.model.Description targetDescription = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createDescription();
			for (String ve: description.value()) {
				targetDescription.getValue().add(ve);
			}
			if (!isBlank(description.url())) {
				targetDescription.setUrl(description.url());
			}
			targetDescription.setContentType(description.contentType());
			target.setDescription(targetDescription);
		}
	}

	static void toDescriptor(Links links, Descriptor target) {
		if (links!=null) {
			for (Link link: links.value()) {
				org.nasdanika.webtest.model.Link linkModel = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createLink();
				target.getLinks().add(linkModel);
				linkModel.setType(link.type());
				linkModel.setValue(link.value());
			}
		}
	}
	
	static void toDescriptor(Link link, Descriptor target) {
		if (link!=null) {
			org.nasdanika.webtest.model.Link linkModel = org.nasdanika.webtest.model.ModelFactory.eINSTANCE.createLink();
			target.getLinks().add(linkModel);
			linkModel.setType(link.type());
			linkModel.setValue(link.value());
		}
	}

	public static List<Field> webElements(Class<?> clazz) {
		List<Field> ret = new ArrayList<>();
		for (Class<?> cls = clazz; cls!=null; cls = cls.getSuperclass()) {
			for (Field field: cls.getDeclaredFields()) {
				if (WebElement.class.isAssignableFrom(field.getType())) {
					ret.add(field);
				} 
			}
		}
		Collections.sort(ret, new Comparator<Field>() {

			@Override
			public int compare(Field o1, Field o2) {
				return o1.toString().compareTo(o2.toString());
			}
			
		});
		
		return ret;		
	}
	
	public static boolean isBlank(String str) {
		return str==null || str.trim().length()==0;
	}
	
	/**
	 * Wraps target into a page and then proxies it so its method invocations
	 * and screenshots are recorded.
	 * @param target
	 * @param webDriver
	 * @param proxyClassLoader ClassLoader which can load both the target class and the Page class.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T, D extends WebDriver> T proxy(
			final T target, 
			final D webDriver, 
			ClassLoader proxyClassLoader,
			String title) {
		if (target == null) {
			return null;
		}
		
		// Already implements Page, no need to mix-in.
		if (target instanceof Page<?>) {			
			return (T) proxyPage((Page<D>) target);
		}
		
		Class<? extends Object> targetClass = target.getClass();
		List<Class<?>> mixInInterfaces = allInterfaces(targetClass);
		mixInInterfaces.addAll(allInterfaces(Page.class));
				
		Page<D> toPageProxy = (Page<D>) Proxy.newProxyInstance(
				proxyClassLoader, 
				mixInInterfaces.toArray(new Class[0]),
				new MixInInvocationHandler<D, T>(webDriver, target, title));
		
		return (T) proxyPage(toPageProxy);
	}

	public static List<Class<?>> allInterfaces(Class<?> klass) {
		if (klass==null) {
			return Collections.emptyList();
		}
		List<Class<?>> ret = new ArrayList<>();
		if (klass.isInterface()) {
			ret.add(klass);
		} else {
			ret.addAll(Arrays.asList(klass.getInterfaces()));
			Z: for (Class<?> i: allInterfaces(klass.getSuperclass())) {
				for (Class<?> ei: ret) {
					if (i.isAssignableFrom(ei)) {
						continue Z;
					}
				}
				ret.add(i);
			}
		}
		return ret;
	}

	/**
	 * Proxies an object which implements {@link Page} interface. 
	 * @param page
	 * @return Proxy wired into the WebTest method invocation and screenshot capturing.
	 */
	@SuppressWarnings("unchecked")
	public static <D extends WebDriver> Page<D> proxyPage(Page<D> page) {
		Class<? extends Object> retClass = page.getClass();
		Page<D> proxy = (Page<D>) Proxy.newProxyInstance(
				retClass.getClassLoader(), 
				allInterfaces(retClass).toArray(new Class[0]), 
				new PageInvocationHandler((Page<WebDriver>) page, AbstractNasdanikaWebTestRunner.collectorThreadLocal.get()));
		if (page instanceof ProxyAware) {
			((ProxyAware<Object>) page).setProxy(proxy);
		}		
		return proxy;
	}
	
	/**
	 * Takes a <code>DURING</code> screenshot.
	 * @param comment
	 */
	public static void takeScreenshot(String comment) {
		byte[] ss = AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(null, null);
		if (ss!=null) {
			AbstractNasdanikaWebTestRunner.collectorThreadLocal.get().onScreenshot(ss, comment);
		}
	}
	
	/**
	 * Loads a skets from <code>location</code> as specified in {@link Sketch} annotation JavaDoc and
	 * stores it as <code>DURING</code> screenshot.
	 * @param location
	 * @param comment
	 */
	public static void takeSketch(String location, Dimension windowSize, String comment) {
		byte[] ss = AbstractNasdanikaWebTestRunner.takeSketch(null, location, windowSize);
		if (ss!=null) {
			AbstractNasdanikaWebTestRunner.collectorThreadLocal.get().onScreenshot(ss, comment);
		}
	}	

	/**
	 * Creates a proxy for a page factory which in turn proxies pages created by the factory.
	 * Page proxies associate test executions and actor methods calls with invocations of page methods (steps). 
	 * @param actorFactory
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T proxyPageFactory(T pageFactory) {
		if (pageFactory == null) {
			return null;
		}
		Class<? extends Object> pageFactoryClass = pageFactory.getClass();
		return (T) Proxy.newProxyInstance(
				pageFactoryClass.getClassLoader(), 
				allInterfaces(pageFactoryClass).toArray(new Class[0]), 
				new FilteringInvocationHandler<Object>(pageFactory) {
					
					@Override
					protected Object filter(Object obj) {
						if (obj instanceof Page) {
							Class<? extends Object> retClass = obj.getClass();
							if (Proxy.isProxyClass(retClass) && this.equals(Proxy.getInvocationHandler(obj))) {
								return obj;
							}
							return proxyPage((Page<WebDriver>) obj);
						}
						return super.filter(obj);
					}
					
				});
	}

	/**
	 * Creates a proxy for an actor factory which in turn proxies actors created by the factory.
	 * Actor proxies associate test executions with invocations of actor methods (steps). 
	 * @param actorFactory
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T proxyActorFactory(T actorFactory) {
		if (actorFactory==null) {
			return null;
		}
		
		Class<? extends Object> actorFactoryClass = actorFactory.getClass();
		return (T) Proxy.newProxyInstance(
				actorFactoryClass.getClassLoader(), 
				allInterfaces(actorFactoryClass).toArray(new Class[0]),
				new FilteringInvocationHandler<Object>(actorFactory) {
					
					@Override
					protected Object filter(Object obj) {
						if (obj instanceof Actor) {
							Class<? extends Object> retClass = obj.getClass();
							if (Proxy.isProxyClass(retClass) && this.equals(Proxy.getInvocationHandler(obj))) {
								return obj;
							}
							Object proxy = Proxy.newProxyInstance(
									retClass.getClassLoader(), 
									allInterfaces(retClass).toArray(new Class[0]),  
									new ActorInvocationHandler((Actor<WebDriver>) obj, AbstractNasdanikaWebTestRunner.collectorThreadLocal.get()));
							
							if (obj instanceof ProxyAware) {
								((ProxyAware<Object>) obj).setProxy(proxy);
							}
							return proxy;
						}
						return super.filter(obj);
					}
					
				});
	}
	
	
	// Copied from CoreUtil, uses {...} token format.
	private static final Pattern EXPANDER_PATTERN = Pattern.compile("\\{(.+?)\\}");	
	
	/**
	 * Source of token values for interpolation.
	 * @author Pavel Vlasov.
	 *
	 */
	public interface TokenSource {
		
		Object get(String token);
		
	}

	/**
	 * Expands tokens in the form of <code>{token name}</code> to their values.
	 * If a token is not found expansion is not processed.
	 * @param input
	 * @param env
	 * @return
	 */
	public static String interpolate(String input, TokenSource tokenSource) {
		if (tokenSource==null) {
			return input;
		}
		Matcher matcher = EXPANDER_PATTERN.matcher(input);
		StringBuilder output = new StringBuilder();
		int i = 0;
		while (matcher.find()) {
		    String token = matcher.group();
			Object replacement = tokenSource.get(token.substring(1, token.length()-1));
		    if (replacement != null) {
			    output.append(input.substring(i, matcher.start())).append(replacement);			    
			    i = matcher.end();
		    }
		}
		output.append(input.substring(i, input.length()));
		return output.toString();
	}
	
	public static String interpolate(String input, final Map<String, Object> env) {
		return interpolate(input, new TokenSource() {

			@Override
			public Object get(String token) {
				return env==null ? null : env.get(token);
			}
			
		});
	}

	/**
	 * Recursively deletes file or directory.
	 * @param file
	 * @throws IOException
	 */
	public static void delete(File file) throws IOException {
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File c: file.listFiles()) {
					delete(c);
				}
			}
			if (!file.delete()) {
				throw new IOException("Could not delete "+file.getAbsolutePath());				
			}
		} 
	}

	/**
	 * Creates a proxy instance of {@link SketchWebDriver}, which throws {@link PendingException} for all methods except the ones defined in {@link Object} class, <code>quit()</code>, and <code>getSelector()</code>.
	 * SketchWebDriver instances are "marker" or "discriminator" instances telling the page factory implementation to return pages which use {@link Sketch} annotation 
	 * and telling the WebTest framework to use sketches defined in a Sketch annotation with matching selector as screenshots. 
	 * @return
	 */
	public static SketchWebDriver createSketchWebDriver(final String selector) {
		return (SketchWebDriver) Proxy.newProxyInstance(
				SketchWebDriver.class.getClassLoader(), 
				new Class[] { SketchWebDriver.class }, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if (method.getDeclaringClass() == Object.class) {
							return method.invoke(this, args);
						}
						
						if ("quit".equals(method.getName()) && method.getParameterCount() == 0) {
							return null;
						}
						
						if (SketchWebDriver.class.isAssignableFrom(method.getDeclaringClass()) 
								&& "getSelector".equals(method.getName())
								&& method.getParameterCount() == 0) {
							return selector;
						}
						
						throw new PendingException(method.toString());
					}
				});
	}
	
}
