package org.nasdanika.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleContext;

/**
 * Wraps method for further wrapping into a command.
 * @author Pavel
 *
 * @param <C>
 * @param <R>
 */
public class MethodCommand<C extends Context, R> extends ParameterReferenceManager implements AutoCloseable {
	
	public MethodCommand(BundleContext context, Method method, ReferenceInfo[] referenceInfo) throws Exception {
		super(context, method, referenceInfo);
	}
	
	public MethodCommand(Method method, ReferenceInfo[] referenceInfo) throws Exception {
		super(method, referenceInfo);
	}
	
	public MethodCommand(BundleContext context, Method method) throws Exception {
		super(context, method);
	}
	
	public MethodCommand(Method method) throws Exception {
		super(method);
	}

	/**
	 * Injects service references, if any. Then invokes method and returns result.
	 */
	@SuppressWarnings("unchecked")
	public R execute(C context, Object target, Object[] arguments) throws Exception {
		if (target!=null && !method.getDeclaringClass().isInstance(target)) {
			throw new IllegalArgumentException("Invalid target: "+method.getDeclaringClass().getName() +" is not assignable from "+target.getClass().getName());
		}
		Class<?>[] pt = method.getParameterTypes();
		Annotation[][] pa = method.getParameterAnnotations();
		Object[] args = new Object[pt.length];
		for (int i=0,j=0; i<args.length; ++i) {
			if (referenceEntries[i]==null) {
				boolean isContextParameter = false;
				for (Annotation a: pa[i]) {
					if (ContextParameter.class.isInstance(a)) {
						isContextParameter = true;
						break;
					}
				}
				if (isContextParameter) {
					if (pt[i].isInstance(context)) {
						args[i] = context;
					} else {
						args[i] = context.adapt(pt[i]);
					}
				} else {					
					if (j<arguments.length) {
						Object arg = arguments[j++];
						if (arg!=null && !pt[i].isInstance(arg)) {
							Object cArg = context.convert(arg, pt[i]);
							if (cArg==null) {
								throw new NasdanikaException("Cannot convert "+arg+" to "+pt[i]);
							}
							arg = cArg;
						}
						args[i] = arg;
					}
				}
			}
		}
		injectServiceReferences(args);
		return (R) method.invoke(target, args);
	}
	
	public Class<?>[] getParameterTypes() {
		List<Class<?>> ret = new ArrayList<>();
		Class<?>[] parameterTypes = method.getParameterTypes();
		Annotation[][] pa = method.getParameterAnnotations();
		Z: for (int i=0; i<parameterTypes.length; ++i) {
			for (Annotation a: pa[i]) {
				if (Reference.class.isInstance(a) || ContextParameter.class.isInstance(a)) {
					continue Z;
				}
			}
			ret.add(parameterTypes[i]);
		}
		return ret.toArray(new Class<?>[ret.size()]);
	}
	
	@SuppressWarnings("unchecked")
	public Class<R> getReturnType() {
		return (Class<R>) method.getReturnType();
	}


}
