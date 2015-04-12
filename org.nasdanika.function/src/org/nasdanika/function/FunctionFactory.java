package org.nasdanika.function;

import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

import org.nasdanika.core.Command;
import org.nasdanika.core.Context;

/**
 * A factory for functional programming. 
 */
public interface FunctionFactory<C extends Context, F extends Function<C, Object, Object>> { 
	
	ServiceBinding createServiceBinding(String serviceType, String filter);
		
	F createServiceMethodFunction(
			Class<?> serviceClass, 
			String filter, 
			String methodName, 
			Class<?>... parameterTypes);

//	Function<C,Object,Object> createServiceMethodFunction(
//			String serviceClassName, 
//			String filter, 
//			String methodName, 
//			String... parameterTypeNames);
	
	F createObjectMethodFunction(
			Object target, 
			String methodName, 
			Class<?>... parameterTypes);
	
	F createJavaScriptFunction(
			String code,
			Map<String, Object> bindings,
			String... parameterNames);
	
	F createJavaScriptFunction(
			Reader codeReader,
			Map<String, Object> bindings,
			String... parameterNames);
	
	F createJavaScriptFunction(
			InputStream codeInputStream,
			Map<String, Object> bindings,
			String... parameterNames);
	
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
			String... parameterNames);
	
//	<R> Function<C,Object,R> createJavaFunction(
//			String code,
//			Class<?>[] parameterTypes,
//			String[] parameterNames,
//			Class<R> returnType,
//			Class<?>[] thrownExceptions);
//	
//	<R> Function<C,Object,R>  createJavaFunction(
//			Reader code,
//			Class<?>[] parameterTypes,
//			String[] parameterNames,
//			Class<R> returnType,
//			Class<?>[] thrownExceptions);
//	
//	<R> Function<C,Object,R>  createJavaFunction(
//			InputStream code,
//			Class<?>[] parameterTypes,
//			String[] parameterNames,
//			Class<R> returnType,
//			Class<?>[] thrownExceptions);
//	
//	/**
//	 * 
//	 * @param codeURL
//	 * @param preLoad If true URL content is loaded at function creation time, otherwise at function execution time.
//	 * @param parameterTypes
//	 * @param parameterNames
//	 * @param returnType
//	 * @param thrownExceptions
//	 * @return
//	 */
//	<R> Function<C,Object,R>  createJavaFunction(
//			URL codeURL,
//			boolean preLoad,
//			Class<?>[] parameterTypes,
//			String[] parameterNames,
//			Class<R> returnType,
//			Class<?>[] thrownExceptions);
	
	/**
	 * Wraps command into a function.
	 * @param command
	 * @param parameterTypes
	 * @param returnType
	 * @return
	 */
	<T,R> Function<C,T,R>  createCommandFunction(Command<C,T,R> command, Class<T>[] parameterTypes,	Class<R> returnType);
		
	/**
	 * Creates a special value indicating that argument shall be 
	 * evaluated by adapting context to the parameter type.
	 * @return
	 */
	Object createContextArgument();
	
}
