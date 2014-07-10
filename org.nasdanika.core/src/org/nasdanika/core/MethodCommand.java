package org.nasdanika.core;

import java.lang.reflect.Method;

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
	public R execute(C context, Object target) throws Exception {
		if (target!=null && !method.getDeclaringClass().isInstance(target)) {
			throw new IllegalArgumentException("Invalid target: "+method.getDeclaringClass().getName() +" is not assignable from "+target.getClass().getName());
		}
		Class<?>[] pt = method.getParameterTypes();
		Object[] args = new Object[pt.length];
		for (int i=0; i<pt.length; ++i) {
			if (referenceEntries[i]==null) {
				if (pt[i].isInstance(context)) {
					args[i] = context;
				}
			}
		}
		injectServiceReferences(args);
		return (R) method.invoke(target, args);
	}

}
