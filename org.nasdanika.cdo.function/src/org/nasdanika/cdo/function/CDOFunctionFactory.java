package org.nasdanika.cdo.function;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.cdo.boxing.BoxUtil;
import org.nasdanika.cdo.boxing.BoxingFactory;
import org.nasdanika.cdo.boxing.ClassBox;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.core.Command;
import org.nasdanika.core.Context;
import org.nasdanika.function.Function;
import org.nasdanika.function.FunctionException;
import org.nasdanika.function.ServiceBinding;
import org.nasdanika.function.cdo.CDOTransactionContextFunctionFactory;

public class CDOFunctionFactory<CR, MC extends Context> implements CDOTransactionContextFunctionFactory<CR, MC> {
	
	private CDOTransactionContext<CR, MC> context;
	private Principal runAsPrincipal;

	public CDOFunctionFactory(CDOTransactionContext<CR, MC> context, Principal runAsPrincipal) {
		this.context = context;
		this.runAsPrincipal = runAsPrincipal;
	}

	@Override
	public ServiceBinding createServiceBinding(String serviceType, String filter) {
		CDOServiceBinding ret = FunctionFactory.eINSTANCE.createCDOServiceBinding();
		ret.setServiceType(serviceType);
		ret.setFilter(filter);
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createServiceMethodFunction(
			Class<?> serviceClass, 
			String filter, 
			String methodName,
			Class<?>... parameterTypes) {
		ServiceMethodFunction<CR, MC, Object, Object> ret = FunctionFactory.eINSTANCE.createServiceMethodFunction();
		ret.setRunAs(runAsPrincipal);
		ret.setServiceType(serviceClass.getName());
		ret.setFilter(filter);
		ret.setMethodName(methodName);
		for (Class<?> pt: parameterTypes) {			
			ClassBox<Object> classBox = BoxingFactory.eINSTANCE.createClassBox();
			classBox.set((Class<Object>) pt, context);
			ret.getParameterTypes().add(classBox);
		}
		return ret;
	}

//	@Override
//	public Function<CDOTransactionContext<CR, MC>, Object, Object> createServiceMethodFunction(
//			String serviceClassName, 
//			String filter, 
//			String methodName,
//			String... parameterTypeNames) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createObjectMethodFunction(
			Object target, 
			String methodName, 
			Class<?>... parameterTypes) {		
		ObjectMethodFunction<CR, MC, Object, Object> ret = FunctionFactory.eINSTANCE.createObjectMethodFunction();
		ret.setRunAs(runAsPrincipal);
		ret.setTarget(BoxUtil.box(target, context));
		ret.setMethodName(methodName);
		for (Class<?> pt: parameterTypes) {			
			ClassBox<Object> classBox = BoxingFactory.eINSTANCE.createClassBox();
			classBox.set((Class<Object>) pt, context);
			ret.getParameterTypes().add(classBox);
		}
		return ret;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			String code, 
			Map<String, Object> bindings, 
			String... parameterNames) {
		JavaScriptFunction<CR, MC, Object, Object> ret = FunctionFactory.eINSTANCE.createJavaScriptFunction();
		ret.setRunAs(runAsPrincipal);
		ret.setCode(code);
		if (bindings!=null) {
			for (Entry<String, Object> b: bindings.entrySet()) {				
				ret.getBindings().put(b.getKey(), BoxUtil.box(b.getValue(), context));
			}
		}
		for (String pn: parameterNames) {
			ret.getParameterNames().add(pn);
		}
		return ret;
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			Reader codeReader, 
			Map<String, Object> bindings, 
			String... parameterNames) {
		try {
			StringWriter sw = new StringWriter();
			for (int ch = codeReader.read(); ch!=-1; ch = codeReader.read()) {
				sw.write(ch);
			}
			codeReader.close();
			sw.close();
			return createJavaScriptFunction(sw.toString(), bindings, parameterNames);
		} catch (IOException e) {
			throw new FunctionException(e);
		}
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			InputStream codeInputStream, 
			Map<String, Object> bindings,
			String... parameterNames) {
		return createJavaScriptFunction(new InputStreamReader(codeInputStream), bindings, parameterNames);
	}

	@Override
	public Function<CDOTransactionContext<CR, MC>, Object, Object> createJavaScriptFunction(
			URL codeURL, 
			boolean preLoad, 
			Map<String, Object> bindings,
			String... parameterNames) {
		if (preLoad) {
			try {
				return createJavaScriptFunction(codeURL.openStream(), bindings, parameterNames);
			} catch (IOException e) {
				throw new FunctionException(e);
			}
		}
		
		JavaScriptFunction<CR, MC, Object, Object> ret = FunctionFactory.eINSTANCE.createJavaScriptFunction();
		ret.setRunAs(runAsPrincipal);
		ret.setCodeURL(codeURL.toString());
		if (bindings!=null) {
			for (Entry<String, Object> b: bindings.entrySet()) {				
				ret.getBindings().put(b.getKey(), BoxUtil.box(b.getValue(), context));
			}
		}
		for (String pn: parameterNames) {
			ret.getParameterNames().add(pn);
		}
		return ret;
	}

//	@Override
//	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
//			String code, Class<?>[] parameterTypes, String[] parameterNames,
//			Class<R> returnType, Class<?>[] thrownExceptions) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
//			Reader code, Class<?>[] parameterTypes, String[] parameterNames,
//			Class<R> returnType, Class<?>[] thrownExceptions) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
//			InputStream code, Class<?>[] parameterTypes,
//			String[] parameterNames, Class<R> returnType,
//			Class<?>[] thrownExceptions) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <R> Function<CDOTransactionContext<CR, MC>, Object, R> createJavaFunction(
//			URL codeURL, boolean preLoad, Class<?>[] parameterTypes,
//			String[] parameterNames, Class<R> returnType,
//			Class<?>[] thrownExceptions) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public <T, R> Function<CDOTransactionContext<CR, MC>, T, R> createCommandFunction(
			Command<CDOTransactionContext<CR, MC>, T, R> command,
			Class<T>[] parameterTypes, 
			Class<R> returnType) {
		CommandFunction<CR, MC, T, R> ret = FunctionFactory.eINSTANCE.createCommandFunction();
		ret.setRunAs(runAsPrincipal);
		ret.setTarget(BoxUtil.box(command, context));
		for (Class<T> pt: parameterTypes) {			
			ClassBox<T> classBox = BoxingFactory.eINSTANCE.createClassBox();
			classBox.set(pt, context);
			ret.getParameterTypes().add(classBox);
		}
		ClassBox<R> classBox = BoxingFactory.eINSTANCE.createClassBox();
		classBox.set(returnType, context);
		ret.setReturnType(classBox);
		
		return ret;
	}

	@Override
	public Object createContextArgument() {
		return FunctionFactory.eINSTANCE.createContextArgument();
	}

}
