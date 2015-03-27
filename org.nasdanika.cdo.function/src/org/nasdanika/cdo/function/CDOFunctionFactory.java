package org.nasdanika.cdo.function;

import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Command;
import org.nasdanika.core.Context;
import org.nasdanika.function.Function;
import org.nasdanika.function.ServiceBinding;
import org.nasdanika.function.cdo.CDOTransactionContextFunctionFactory;

public class CDOFunctionFactory<CR, MC extends Context> implements CDOTransactionContextFunctionFactory<CR, MC> {

	@Override
	public ServiceBinding createServiceBinding(String serviceType, String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createServiceMethodFunction(
			Class<?> serviceClass, String filter, String methodName,
			Class<?>... parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createServiceMethodFunction(
			String serviceClassName, String filter, String methodName,
			String... parameterTypeNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createMethodFunction(
			Object target, String methodName, Class<?>... parameterTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			String code, Map<String, Object> bindings, String[] parameterNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			Reader code, Map<String, Object> bindings, String[] parameterNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			InputStream code, Map<String, Object> bindings,
			String[] parameterNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			URL codeURL, boolean preLoad, Map<String, Object> bindings,
			String[] parameterNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
			String code, Class<?>[] parameterTypes, String[] parameterNames,
			Class<R> returnType, Class<?>[] thrownExceptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
			Reader code, Class<?>[] parameterTypes, String[] parameterNames,
			Class<R> returnType, Class<?>[] thrownExceptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
			InputStream code, Class<?>[] parameterTypes,
			String[] parameterNames, Class<R> returnType,
			Class<?>[] thrownExceptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
			URL codeURL, boolean preLoad, Class<?>[] parameterTypes,
			String[] parameterNames, Class<R> returnType,
			Class<?>[] thrownExceptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T, R> Function<CDOTransactionContext<CR, MC>, T, R> createCommandFunction(
			Command<CDOTransactionContext<CR, MC>, T, R> command,
			Class<?>[] parameterTypes, Class<R> returnType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object createContextArgument() {
		// TODO Auto-generated method stub
		return null;
	}

}
