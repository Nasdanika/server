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
	
	/**
	 * Wraps invocable into a function.
	 */
	Function createFunction(Invocable invocable);
	
	Invocable createServiceMethodInvocable(
			Class<?> serviceClass, 
			String filter, 
			String methodName, 
			Class<?>... parameterTypes);
	
	Invocable createMethodInvocable(
			Object target, 
			String methodName, 
			Class<?>... parameterTypes);
	
	Function createParticipantFunction(String participantFilter, String operationName);
	
	/**
	 * Wraps participant into an interface.
	 * @param type Proxy interface. The interface methods return type shall be either void or {@link Promise}.
	 * @param participantFilter
	 * @return
	 */
	<T> T createParticipantProxy(Class<T> type, String participantFilter);			

	enum EngineSelectorType { EXTENSION, MIME_TYPE, NAME }
	
	Invocable createScriptInvocable(
			EngineSelectorType engineSelectorType, 
			String engineSelector, 
			String code,
			Map<String, Object> bindings,
			String[] parameterNames,
			Class<?>[] parameterTypes);
	
	Invocable createScriptInvocable(
			EngineSelectorType engineSelectorType, 
			String engineSelector,
			Reader codeReader,
			Map<String, Object> bindings,
			String[] parameterNames,
			Class<?>[] parameterTypes);
	
	Invocable createScriptInvocable(
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
	Promise submit(Invocable task);
	
	Promise schedule(Invocable task, long delay, TimeUnit unit);
	
	Promise scheduleAtFixedRate(Invocable task, long initialDelay, long period, TimeUnit unit);
	
	Promise scheduleWithFixedDelay(Invocable task, long initialDelay, long delay, TimeUnit unit);
	
	/**
	 * Creates a new function from the function. The new function accepts either
	 * values or promises as arguments and returns a promise which is fulfilled/rejected
	 * by the invocable's return value or thrown exception.
	 * @param func
	 * @return
	 */
	Function promised(Invocable invocable);
			
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
	 * Asynchronously chains invocables passing return
	 * value of each function as an argument to the next
	 * function. 
	 * @param invocables, the first function shall have zero length, i.e. no parameters or all parameters bound.
	 * @return
	 */
	Promise reduce(Invocable...invocables);
	
}
