package org.nasdanika.function;

import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

/**
 * A session for functional programming. A session object shall typically be obtained by adapting a context.
 */
public interface FunctionFactory<C, F extends Function<C>, P extends Promise<C,F,P>> { 
	
	ServiceBinding createServiceBinding(String serviceType, String filter);
		
	F createServiceMethodFunction(
			Class<?> serviceClass, 
			String filter, 
			String methodName, 
			Class<?>... parameterTypes);

	F createServiceMethodFunction(
			String serviceClassName, 
			String filter, 
			String methodName, 
			String... parameterTypeNames);
	
	F createMethodFunction(
			Object target, 
			String methodName, 
			Class<?>... parameterTypes);
	
	F createJavaScriptFunction(
			String code,
			Map<String, Object> bindings,
			String[] parameterNames);
	
	F createJavaScriptFunction(
			Reader code,
			Map<String, Object> bindings,
			String[] parameterNames);
	
	F createJavaScriptFunction(
			InputStream code,
			Map<String, Object> bindings,
			String[] parameterNames);
	
	/**
	 * 
	 * @param codeURL
	 * @param preLoad If true URL content is loaded at function creation time, otherwise at function execution time
	 * @param bindings
	 * @param parameterNames
	 * @return
	 */
	F createJavaScriptFunction(
			URL codeURL,
			boolean preLoad,
			Map<String, Object> bindings,
			String[] parameterNames);
	
	F createJavaFunction(
			String code,
			Class<?>[] parameterTypes,
			String[] parameterNames,
			Class<?> returnType,
			Class<?>[] thrownExceptions);
	
	F createJavaFunction(
			Reader code,
			Class<?>[] parameterTypes,
			String[] parameterNames,
			Class<?> returnType,
			Class<?>[] thrownExceptions);
	
	F createJavaFunction(
			InputStream code,
			Class<?>[] parameterTypes,
			String[] parameterNames,
			Class<?> returnType,
			Class<?>[] thrownExceptions);
	
	/**
	 * 
	 * @param codeURL
	 * @param preLoad If true URL content is loaded at function creation time, otherwise at function execution time.
	 * @param parameterTypes
	 * @param parameterNames
	 * @param returnType
	 * @param thrownExceptions
	 * @return
	 */
	F createJavaFunction(
			URL codeURL,
			boolean preLoad,
			Class<?>[] parameterTypes,
			String[] parameterNames,
			Class<?> returnType,
			Class<?>[] thrownExceptions);
		
	Deferred<C,F,P> defer();
		
	/**
	 * Creates a special value indicating that argument shall be 
	 * evaluated by adapting context to the parameter type.
	 * @return
	 */
	Object createContextArgument();
		
//	/**
//	 * Creates a new function from the function. The new function accepts either
//	 * values or promises as arguments and returns a promise which is fulfilled/rejected
//	 * by the invocable's return value or thrown exception.
//	 * @param func
//	 * @return
//	 */
//	Function<C> promised(Function<C> func);
			
	/**
	 * @param promises
	 * @return A promise fulfilled with an array of fulfillment values of argument promises or rejected with a reason
	 * of the first rejected argument promise.
	 */
	P all(Object... valuesOrPromises);
	
	/**
	 * If valueOrPromise is a value, returns a promise fulfilled with that value, if valueOrPromise is a promise, returns the promise.
	 * @param valueOrPromise
	 * @return
	 */
	P when(Object valueOrPromise);
	
}
