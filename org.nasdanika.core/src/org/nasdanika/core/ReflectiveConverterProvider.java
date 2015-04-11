package org.nasdanika.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * Base class for classes which declare converter methods.
 * @author Pavel
 *
 */
public abstract class ReflectiveConverterProvider implements AutoCloseable, ConverterProvider {
	
	protected List<ConverterDescriptor<?,?,?>> descriptors = new ArrayList<>();
	
	@Override
	public Iterable<ConverterDescriptor<?, ?, ?>> getConverterDescriptors() {
		return descriptors;
	}
			
	protected ReflectiveConverterProvider() throws Exception {
		this(null);
	}
	
	protected ReflectiveConverterProvider(BundleContext context) throws Exception {
		if (context==null) {
			context = FrameworkUtil.getBundle(getClass()).getBundleContext();
		}
		final BundleContext theContext = context;
		for (final Method m: getClass().getMethods()) {
			final ConverterMethod cma = m.getAnnotation(ConverterMethod.class);
			if (cma!=null) {				
				descriptors.add(new ConverterDescriptor<Object, Object, Context>() {
					
					@SuppressWarnings("unchecked")
					Class<Object>[] parameterTypes = (Class<Object>[]) m.getParameterTypes();

					@Override
					public Converter<Object, Object, Context> getConverter() {
						class MethodConverter extends ParameterReferenceManager implements Converter<Object, Object, Context> {

							protected MethodConverter() throws Exception {
								super(theContext, m);
							}

							@Override
							public Object convert(Object source, Class<Object> target, Context context) throws Exception {
								Object[] args = new Object[parameterTypes.length];
								args[0] = source;
								if (args.length>1) {
									args[1] = context;
								}
								injectServiceReferences(args);
								return m.invoke(ReflectiveConverterProvider.this, args);
							}
							
						}
						return null;
					}

					@Override
					public Class<Object> getSourceType() {
						return parameterTypes[0];
					}

					@SuppressWarnings("unchecked")
					@Override
					public Class<Object> getTargetType() {
						return (Class<Object>) m.getReturnType();
					}

					@SuppressWarnings({ "unchecked", "rawtypes" })
					@Override
					public Class<Context> getContextType() {
						return parameterTypes.length>1 ? (Class) parameterTypes[1] : null;
					}

					@Override
					public int getPriority() {
						return cma.value();
					}

					@Override
					public String getProfile() {
						return cma.profile();
					}
				});
			}
		}
		descriptors = Collections.unmodifiableList(descriptors);
	}

	@Override
	public void close() throws Exception {
		for (ConverterDescriptor<?, ?, ?> d: descriptors) {
			((AutoCloseable) d.getConverter()).close();
		}
	}

}
