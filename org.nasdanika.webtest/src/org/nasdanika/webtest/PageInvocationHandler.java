package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebDriver;

class PageInvocationHandler extends FilteringInvocationHandler<Page<WebDriver>> {
	
	private Collector<WebDriver> collector;

	PageInvocationHandler(Page<WebDriver> page, Collector<WebDriver> collector) {
		super(page);
		this.collector = collector;
		collector.onPageProxying(page);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (isPageMethod(method)) {
			Method pageImplMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
			WebDriver webDriver = null;
			Object test = AbstractNasdanikaWebTestRunner.testThreadLocal.get();
    		if (test instanceof WebTest) {
    			webDriver = ((WebTest<?>) test).getWebDriver();
    			WebTestUtil.doWait(webDriver, pageImplMethod);
    		}
			Screenshot screenshotAnnotation = pageImplMethod.getAnnotation(Screenshot.class);
    		long delay = screenshotAnnotation==null ? 0 : screenshotAnnotation.delay();
    		if (test instanceof WebTest) {
    			delay += ((WebTest<?>) test).getScreenshotDelay();
    		}
    		if (AbstractNasdanikaWebTestRunner.shallTakeBeforeScreenshot(screenshotAnnotation)) {
    			if (delay>0) {
    				Thread.sleep(delay);
    			}
				collector.beforePageMethod(target, AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(pageImplMethod, Screenshot.When.BEFORE), AbstractNasdanikaWebTestRunner.capturePerformance(), method, args);
    		} else {
				collector.beforePageMethod(target, null, AbstractNasdanikaWebTestRunner.capturePerformance(), method, args);
    		}
    		String originalContext = null;
			try {				
				Context ctxAnn = pageImplMethod.getAnnotation(Context.class);
				for (Class<?> cls = target.getClass(); ctxAnn==null && cls!=null && Page.class.isAssignableFrom(cls); cls=cls.getSuperclass()) {
					ctxAnn = cls.getAnnotation(Context.class);
				}
				if (ctxAnn!=null && webDriver instanceof ContextAware) {
					originalContext = ((ContextAware) webDriver).getContext();
					if (ctxAnn.value().equals(originalContext)) {
						originalContext = null; // So no switching back
					} else {
						((ContextAware) webDriver).context(ctxAnn.value());
					}
				}
				Object res = filter(method.invoke(target, args));
	    		if (AbstractNasdanikaWebTestRunner.shallTakeAfterScreenshot(screenshotAnnotation)) {
	    			if (delay>0) {
	    				Thread.sleep(delay);
	    			}
	    			collector.afterPageMethod(target, AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(pageImplMethod, Screenshot.When.AFTER), AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, res, null);
	    		} else {
	    			collector.afterPageMethod(target, null, AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, res, null);
	    		}
	    		return res;
			} catch (Throwable th) {
//				th.printStackTrace();
	    		if (AbstractNasdanikaWebTestRunner.shallTakeExceptionScreenshot(screenshotAnnotation)) {
	    			if (delay>0) {
	    				Thread.sleep(delay);
	    			}
	    			collector.afterPageMethod(target, AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(pageImplMethod, Screenshot.When.EXCEPTION), AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, null, th);
	    		} else {
	    			collector.afterPageMethod(target, null, AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, null, th);		    			
	    		}
				throw th;
			} finally {
				if (originalContext!=null && webDriver instanceof ContextAware) {
					((ContextAware) webDriver).context(originalContext);
				}				
			}
		}
		
		return method.invoke(target, args); // No recording for non-page methods.
	}

	private boolean isPageMethod(Method method) {
		if (Proxy.isProxyClass(target.getClass()) && Proxy.getInvocationHandler(target) instanceof MixInInvocationHandler) {
			List<Class<?>> allInterfaces = WebTestUtil.allInterfaces(((MixInInvocationHandler<?,?>) Proxy.getInvocationHandler(target)).getTarget().getClass());
			return allInterfaces.contains(method.getDeclaringClass());
		}
		return Page.class.isAssignableFrom(method.getDeclaringClass()) && !Page.class.equals(method.getDeclaringClass());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object filter(Object obj) {
		if (obj instanceof Page) {
			Class<? extends Object> resClass = obj.getClass();
			if (Proxy.isProxyClass(resClass) && this.equals(Proxy.getInvocationHandler(obj))) {
				return obj;
			}
			Object proxy = Proxy.newProxyInstance(
					resClass.getClassLoader(), 
					WebTestUtil.allInterfaces(resClass).toArray(new Class[0]), 
					new PageInvocationHandler((Page<WebDriver>) obj, collector));
			if (obj instanceof ProxyAware) {
				((ProxyAware<Object>) obj).setProxy(proxy);
			}			
			return proxy;
		}
		
		return super.filter(obj);
	}
}