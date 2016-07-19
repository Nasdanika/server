package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.openqa.selenium.WebDriver;

class ActorInvocationHandler extends FilteringInvocationHandler<Actor<WebDriver>> {
	
	private Collector<WebDriver> collector;

	ActorInvocationHandler(Actor<WebDriver> actor, Collector<WebDriver> collector) {
		super(actor);
		this.collector = collector;
		collector.onActorProxying(actor);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (isActorMethod(method)) {
			Method actorImplMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());
			Object test = AbstractNasdanikaWebTestRunner.testThreadLocal.get();
    		if (test instanceof WebTest) {
    			WebTestUtil.doWait(((WebTest<?>) test).getWebDriver(), actorImplMethod);
    		}
			Screenshot screenshotAnnotation = actorImplMethod.getAnnotation(Screenshot.class);
    		long delay = screenshotAnnotation==null ? 0 : screenshotAnnotation.delay();
    		if (test instanceof WebTest) {
    			delay += ((WebTest<?>) test).getScreenshotDelay();
    		}
    		if (AbstractNasdanikaWebTestRunner.shallTakeBeforeScreenshot(screenshotAnnotation)) {
    			if (delay>0) {
    				Thread.sleep(delay);
    			}
				collector.beforeActorMethod(target, AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(actorImplMethod, Screenshot.When.BEFORE), AbstractNasdanikaWebTestRunner.capturePerformance(), method, args);
    		} else {
				collector.beforeActorMethod(target, null, AbstractNasdanikaWebTestRunner.capturePerformance(), method, args);	    			
    		}
			
			try {
				Object res = method.invoke(target, args);
	    		if (AbstractNasdanikaWebTestRunner.shallTakeAfterScreenshot(screenshotAnnotation)) {
	    			if (delay>0) {
	    				Thread.sleep(delay);
	    			}
	    			collector.afterActorMethod(target, AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(actorImplMethod, Screenshot.When.AFTER), AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, res, null);
	    		} else {
	    			collector.afterActorMethod(target, null, AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, res, null);		    			
	    		}
	    		return filter(res);
			} catch (Throwable th) {
	    		if (AbstractNasdanikaWebTestRunner.shallTakeExceptionScreenshot(screenshotAnnotation)) {
	    			if (delay>0) {
	    				Thread.sleep(delay);
	    			}
	    			collector.afterActorMethod(target, AbstractNasdanikaWebTestRunner.takeScreenshotOrSketch(actorImplMethod, Screenshot.When.EXCEPTION), AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, null, th);
	    		} else {
	    			collector.afterActorMethod(target, null, AbstractNasdanikaWebTestRunner.capturePerformance(), method, args, null, th);		    			
	    		}
				throw th;
			}
		}
		
		return method.invoke(target, args); // No recording for non-actor methods.
	}

	private boolean isActorMethod(Method method) {
		if (Proxy.isProxyClass(target.getClass()) && Proxy.getInvocationHandler(target) instanceof MixInInvocationHandler) {
			List<Class<?>> allInterfaces = WebTestUtil.allInterfaces(((MixInInvocationHandler<?,?>) Proxy.getInvocationHandler(target)).getTarget().getClass());
			return allInterfaces.contains(method.getDeclaringClass());
		}
		return Actor.class.isAssignableFrom(method.getDeclaringClass()) && !Actor.class.equals(method.getDeclaringClass());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object filter(Object obj) {
		if (obj instanceof Actor) {
			Class<? extends Object> resClass = obj.getClass();
			if (Proxy.isProxyClass(resClass) && this.equals(Proxy.getInvocationHandler(obj))) {
				return obj;
			}
			Object proxy = Proxy.newProxyInstance(
					resClass.getClassLoader(), 
					WebTestUtil.allInterfaces(resClass).toArray(new Class[0]),  
					new ActorInvocationHandler((Actor<WebDriver>) obj, collector));
			if (obj instanceof ProxyAware) {
				((ProxyAware<Object>) obj).setProxy(proxy);
			}
			return proxy;
		}
		
		return super.filter(obj);
	}
}
