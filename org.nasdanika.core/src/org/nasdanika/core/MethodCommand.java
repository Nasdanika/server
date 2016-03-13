package org.nasdanika.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.ExtensionTracker;
import org.eclipse.core.runtime.dynamichelpers.IExtensionChangeHandler;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Wraps method for further wrapping into a command.
 * @author Pavel
 *
 * @param <C>
 * @param <R>
 */
public class MethodCommand<C extends Context, R> {
	
	/**
	 * Resolves argument value.
	 * @author Pavel Vlasov
	 *
	 */
	protected interface ArgumentResolver<C extends Context> {
		
		Object getValue(C context, Object[] args) throws Exception;
		
		void close();
		
	}
	
	private ArgumentResolver<C>[] argumentResolvers;
	protected BundleContext bundleContext;
	protected Method method;
	
	public Method getMethod() {
		return method;
	}
	
	@SuppressWarnings("unchecked")
	public MethodCommand(BundleContext bundleContext, Method method) throws Exception {
		this.bundleContext = bundleContext;
		this.method = method;
		Annotation[][] pa = method.getParameterAnnotations();
		Class<?>[] pt = method.getParameterTypes();
		argumentResolvers = new ArgumentResolver[pt.length];
		for (int i=0; i<pt.length; ++i) {
			argumentResolvers[i] = createArgumentResolver(pt[i], pa[i]);
		}
	}
	
	/**
	 * Creates an argument resolver for a parameter.
	 * This implementation handles {@link ServiceParameter}, {@link ExtensionParameter}, and {@link ContextParameter} annotations. Subclasses may override
	 * this method to handle additional annotations.
	 * @param parameterType
	 * @param parameterAnnotations
	 * @return
	 */
	protected ArgumentResolver<C> createArgumentResolver(final Class<?> parameterType, final Annotation[] parameterAnnotations) throws Exception {
		for (Annotation a: parameterAnnotations) {
			// Context parameter
			if (ContextParameter.class.isInstance(a)) {
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] args) throws Exception {
						if (parameterType.isInstance(context)) {
							return context;
						}
						
						return context.adapt(parameterType);
					}
					
					@Override
					public void close() {
						// NOP						
					}
				};
			}
		
			// Service parameter
			if (ServiceParameter.class.isInstance(a)) {
				@SuppressWarnings("unchecked")
				Class<Object> serviceType = (Class<Object>) (parameterType.isArray() ? parameterType.getComponentType() : parameterType);
				
				String filter = ((ServiceParameter) a).value();
				final ServiceTracker<Object, Object> serviceTracker;
				if (CoreUtil.isBlank(filter)) {
					serviceTracker = new ServiceTracker<Object, Object>(bundleContext, serviceType, null);				
				} else {
					Filter theFilter = bundleContext.createFilter("(&(" + Constants.OBJECTCLASS + "=" + serviceType.getName() + ")"+filter+")");
					serviceTracker = new ServiceTracker<Object, Object>(bundleContext, theFilter, null);
				}
				serviceTracker.open();
				
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] args) throws Exception {
						if (parameterType.isArray()) {
							Object[] services = serviceTracker.getServices();
							Object ret = Array.newInstance(parameterType.getComponentType(), services.length);
							System.arraycopy(services, 0, ret, 0, services.length);
							return ret;
						}
						
						return serviceTracker.getService();
					}
					
					@Override
					public void close() {
						serviceTracker.close();						
					}
				};
				
			}
						
			// Extension parameter
			if (ExtensionParameter.class.isInstance(a)) {			
				IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
				final ExtensionTracker extensionTracker = new ExtensionTracker(extensionRegistry);
		    	final ExtensionParameter extensionParameter = (ExtensionParameter) a;
				IExtensionPoint extensionPoint = extensionRegistry.getExtensionPoint(extensionParameter.point());  
				
				final List<Object> extensions = new ArrayList<>();
		    	
		    	IExtensionChangeHandler extensionChangeHandler = new IExtensionChangeHandler() {

		    		@Override
		    		public void addExtension(IExtensionTracker tracker, IExtension extension) {
		    			for (IConfigurationElement ce: extension.getConfigurationElements()) {
		    				try {
			    				if (extensionParameter.configurationElement().equals(ce.getName())) {
									Object instance = CoreUtil.injectProperties(ce, ce.createExecutableExtension(extensionParameter.classAttribute()));		    						
			    					synchronized (extensions) {
										extensions.add(instance);
			    					}

			    					tracker.registerObject(extension, instance, IExtensionTracker.REF_WEAK);
			    				}
		    				} catch (Exception e) {
		    					// TODO - proper logging
		    					System.err.println("Error adding extension");
		    					e.printStackTrace();
		    				}
		    			}
		    		}
		    		
		 			@Override
		    		public void removeExtension(IExtension extension, Object[] objects) {
		    			synchronized (extensions) {
			    			for (Object obj: objects) {
			    				extensions.remove(obj);
			    			}
		    			}
					}
		    		
		    	};    	
		    	
				extensionTracker.registerHandler(extensionChangeHandler, ExtensionTracker.createExtensionPointFilter(extensionPoint));
				for (IExtension ex: extensionPoint.getExtensions()) {
					extensionChangeHandler.addExtension(extensionTracker, ex);
				}
				
				return new ArgumentResolver<C>() {
					
					@Override
					public Object getValue(C context, Object[] args) throws Exception {
						synchronized (extensions) {
							if (parameterType.isArray()) {
								Object ret = Array.newInstance(parameterType.getComponentType(), extensions.size());
								int idx = 0;
								for (Object ext: extensions) {
									Array.set(ret, idx++, ext);
								}
								return ret;								
							}
							return extensions.isEmpty() ? null : extensions.get(0);
						}
					}
					
					@Override
					public void close() {
						extensionTracker.close();						
					}
				};
				
			}
		}
						
		return null;
	}

	public void close() {
		for (ArgumentResolver<C> ar: argumentResolvers) {
			if (ar!=null) {
				ar.close();
			}
		}				
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
		Object[] args = new Object[pt.length];
		for (int i=0,j=0; i<args.length; ++i) {
			Object arg = null;
			if (argumentResolvers[i]==null) {
				if (arguments!=null && j<arguments.length) {
					arg = arguments[j++];
				}
			} else {
				arg = argumentResolvers[i].getValue(context, arguments);
			}
			if (arg!=null && !pt[i].isInstance(arg)) {
				Object cArg = context.convert(arg, pt[i]);
				if (cArg==null) {
					throw new NasdanikaException("Cannot convert "+arg+" to "+pt[i]);
				}
				arg = cArg;
			}
			args[i] = arg;
		}
		return (R) method.invoke(target, args);
	}
	
	public Class<?>[] getParameterTypes() {
		List<Class<?>> ret = new ArrayList<>();
		Class<?>[] parameterTypes = method.getParameterTypes();
		for (int i=0; i<parameterTypes.length; ++i) {
			if (argumentResolvers[i]==null) {
				ret.add(parameterTypes[i]);
			}
		}
		return ret.toArray(new Class<?>[ret.size()]);
	}
	
	@SuppressWarnings("unchecked")
	public Class<R> getReturnType() {
		return (Class<R>) method.getReturnType();
	}


}
