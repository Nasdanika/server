package org.nasdanika.function;

import java.io.InputStream;
import java.io.Reader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * A session for functional programming. A session object shall typically be obtained by adapting a context.
 */
public interface Session { 
	
	ServiceBinding createServiceBinding(String serviceType, String filter);
	
	Function createServiceMethodFunction(
			Class<?> serviceClass, 
			String filter, 
			String methodName, 
			Class<?>... parameterTypes);
	
	Function createMethodFunction(
			Object target, 
			String methodName, 
			Class<?>... parameterTypes);

	enum EngineSelectorType { EXTENSION, MIME_TYPE, NAME }
	
	Function createScriptFunction(
			EngineSelectorType engineSelectorType, 
			String engineSelector, 
			String code,
			Map<String, Object> bindings,
			String[] parameterNames,
			Class<?>[] parameterTypes);
	
	Function createScriptFunction(
			EngineSelectorType engineSelectorType, 
			String engineSelector,
			Reader codeReader,
			Map<String, Object> bindings,
			String[] parameterNames,
			Class<?>[] parameterTypes);
	
	Function createScriptFunction(
			EngineSelectorType engineSelectorType, 
			String engineSelector,
			InputStream codeInputStream,
			Map<String, Object> bindings,
			String[] parameterNames,
			Class<?>[] parameterTypes);
	
	Deferred createDeferred();
	
	/**
	 * Creates a special value indicating that parameter is unbound.
	 * @param optional
	 * @return
	 */
	Object createUnboundArgument(boolean optional);
	
	/**
	 * Creates a special value indicating that argument shall be 
	 * evaluated by adapting context to the parameter type.
	 * @return
	 */
	Object createContextArgument();
	
	/**
	 * If function length is greater than zero then resolve, reject, and notify functions are passed 
	 * to the function as arguments. 
	 * @param task
	 * @return
	 */
	Promise submit(Function task);
	
	Promise schedule(Function task, long delay, TimeUnit unit);
	
	Promise scheduleAtFixedRate(Function task, long initialDelay, long period, TimeUnit unit);
	
	Promise scheduleWithFixedDelay(Function task, long initialDelay, long delay, TimeUnit unit);
	
	/**
	 * Creates a new function from the function. The new function accepts either
	 * values or promises as arguments and returns a promise which is fulfilled/rejected
	 * by the original function's return value or thrown exception.
	 * @param func
	 * @return
	 */
	Function promised(Function func);
			
	/**
	 * @param promises
	 * @return A promise fulfilled with an array of fulfillment values of argument promises or rejected with a reason
	 * of the first rejected argument promise.
	 */
	Promise all(Promise... promises);
	
	/**
	 * If valueOrPromise is a value, returns a promise fulfilled with that value, if valueOrPromise is a promise, returns the promise.
	 * @param valueOrPromise
	 * @return
	 */
	Promise when(Object valueOrPromise);
	
	/**
	 * Asynchronously chains functions passing return
	 * value of each function as an argument to the next
	 * function. 
	 * @param functions, the first function shall have zero length, i.e. no parameters or all parameters bound.
	 * @return
	 */
	Promise reduce(Function...functions);
	
}
