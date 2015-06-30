package org.nasdanika.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.Platform;
import org.nasdanika.core.ConverterProvider.ConverterDescriptor;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

public class CoreUtil {

	private CoreUtil() {
		// Utility class
	}
	
	public static Map<Class<?>, Class<?>> PRIMITIVES_TO_BOXES_MAP; 
	
	static {		
		Map<Class<?>, Class<?>> primitivesToBoxesMap = new HashMap<>();
		primitivesToBoxesMap.put(byte.class, Byte.class);
		primitivesToBoxesMap.put(short.class, Short.class);
		primitivesToBoxesMap.put(int.class, Integer.class);
		primitivesToBoxesMap.put(long.class, Long.class);
		primitivesToBoxesMap.put(float.class, Float.class);
		primitivesToBoxesMap.put(double.class, Double.class);
		primitivesToBoxesMap.put(boolean.class, Boolean.class);
		primitivesToBoxesMap.put(char.class, char.class);
		PRIMITIVES_TO_BOXES_MAP = Collections.unmodifiableMap(primitivesToBoxesMap);
	}	
	
	

	public static <T> T injectProperties(IConfigurationElement ce, final T target) throws Exception {
		for (IConfigurationElement cce: ce.getChildren()) {
			if ("property".equals(cce.getName())) {
				injectProperty(target, cce.getAttribute("name").split("\\."), cce.getAttribute("value"));
			}
		}
		return target;
	}

	@SuppressWarnings("unchecked")
	private static void injectProperty(Object target, String[] propertyPath, String value) throws Exception {
		if (target instanceof Map) {
			// Injection to a Map, e.g. some object has a method Map<String, String> getConfig(), 
			// then config.property_a -> 123 would put <property_a, 123> to the config map
			((Map<String, String>) target).put(join(propertyPath, "."), value);
		} else if (propertyPath.length==1) {
			String mName = "set"+propertyPath[0].substring(0, 1).toUpperCase()+propertyPath[0].substring(1);
			
			// Methods
			// String injection first
			for (Method mth: target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length==1 && mth.getName().equals(mName) && pTypes[0].isAssignableFrom(String.class)) {
					mth.invoke(target, value);
					return;
				}								
			}
			
			// Constructor conversion 
			for (Method mth: target.getClass().getMethods()) {
				Class<?>[] pTypes = mth.getParameterTypes();
				if (pTypes.length==1 && mth.getName().equals(mName)) {
					Class<?> pType = pTypes[0];
					Class<?> bType = PRIMITIVES_TO_BOXES_MAP.get(pType);
					if (bType!=null) {
						pType = bType;
					}
					for (Constructor<?> c: pType.getConstructors()) {
						if (c.getParameterTypes().length==1 && c.getParameterTypes()[0].isInstance(value)) {
							mth.invoke(target, c.newInstance(value));
							return;
						}
					}
				}								
			}
			
			// Fields
			for (Field fld: target.getClass().getFields()) {
				if (fld.getType().isAssignableFrom(String.class)) {
					fld.set(target, value);
					return;
				}								
			}
			
			// Constructor conversion 
			for (Field fld: target.getClass().getFields()) {
				for (Constructor<?> c: fld.getType().getConstructors()) {
					if (c.getParameterTypes().length==1 && c.getParameterTypes()[0].isInstance(value)) {
						fld.set(target, c.newInstance(value));
						return;
					}
				}
			}
			
			throw new IllegalArgumentException("Cannot inject property "+propertyPath[0]+" with value '"+value+"' into "+target.getClass().getName());
		} else {
			String mName = "get"+propertyPath[0].substring(0, 1).toUpperCase()+propertyPath[0].substring(1);
			// Method
			for (Method mth: target.getClass().getMethods()) {
				if (mth.getParameterTypes().length==0 && mth.getName().equals(mName)) {
					Object nextTarget = mth.invoke(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "+mth+" returned null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath, 1, propertyPath.length), value);
					return;
				}
			}
			
			// Field
			for (Field fld: target.getClass().getFields()) {
				if (fld.getName().equals(propertyPath[0])) {
					Object nextTarget = fld.get(target);
					if (nextTarget == null) {
						throw new NullPointerException("Cannot set property: "+propertyPath[0]+" is null");
					}
					injectProperty(nextTarget, Arrays.copyOfRange(propertyPath, 1, propertyPath.length), value);
					return;
				}
			}			
			
			throw new IllegalArgumentException("There is no property "+propertyPath[0]+" in "+target.getClass().getName());			
		}
	}
	
	public static boolean isBlank(String str) {
		return str==null || str.trim().length()==0;
	}

	public static String join(String[] sa, String separator) {
		return join(sa, separator, 0);
	}
	
	public static String join(String[] sa, String separator, int beginIndex) {
		StringBuilder sb = new StringBuilder();
		for (int i=beginIndex; i<sa.length; ++i) {
			if (sb.length()>0) {
				sb.append(separator);
			}
			sb.append(sa[i]);
		}
		return sb.toString();
	}
	
	public static final String CONVERT_ID = "org.nasdanika.core.convert";			
	
	protected static class ConverterServiceEntry<S,T,C extends Context> implements Converter<S,T,C> {
	
		private ServiceTracker<Converter<S,T,C>, Converter<S,T,C>> serviceTracker;		
		
		public ConverterServiceEntry(String filter) throws Exception {
			BundleContext context = FrameworkUtil.getBundle(CoreUtil.class).getBundleContext();
			if (filter==null || filter.trim().length()==0) {
				this.serviceTracker = new ServiceTracker<Converter<S,T,C>, Converter<S,T,C>>(context, Converter.class.getName(), null);				
			} else {
				filter = "(&(" + Constants.OBJECTCLASS + "=" + Converter.class.getName() + ")"+filter+")";
				this.serviceTracker = new ServiceTracker<Converter<S,T,C>, Converter<S,T,C>>(context, context.createFilter(filter), null);
			}
			this.serviceTracker.open();
		}
	
		@Override
		public void close() throws Exception {
			serviceTracker.close();			
		}
	
		@Override
		public T convert(S source, Class<T> target, C context) throws Exception {
			// TODO - iterate over the getTracked(), match profiles.
			for (Object c: serviceTracker.getServices()) {
				@SuppressWarnings("unchecked")
				T ret = ((Converter<S,T,C>) c).convert(source, target, context);
				if (ret!=null) {
					return ret;
				}
			}
			return null;
		}
		
	}
		
	/**
	 * Creates composite converter from extensions. 
	 * @return
	 * @throws Exception
	 */
	public static <S,T,C extends Context> Converter<S,T,C> createConverter() throws Exception {
		class ConverterEntry implements Comparable<ConverterEntry> {
			
			public ConverterEntry(Converter<S,T,C> converter) {
				this.converter = converter;
			}
			
			int priority;
			
			Class<?> source;
			Class<?> target;
			
			Converter<S,T,C> converter;

			@Override
			public int compareTo(ConverterEntry o) {
				if (source.isAssignableFrom(o.source) && !o.source.isAssignableFrom(source)) {
					return 1; // o is more specific.
				}
				
				if (o.source.isAssignableFrom(source) && !source.isAssignableFrom(o.source)) {
					return -1; // this is more specific.
				}
				
				if (o.priority != priority) {
					return o.priority - priority;
				}
				
				if (target.isAssignableFrom(o.target) && !o.target.isAssignableFrom(target)) {
					return -1; // o is more specific
				}
				
				if (o.target.isAssignableFrom(target) && !target.isAssignableFrom(o.target)) {
					return 1; // this is more specific
				}
				
				return 0;
			}
			
		}
		final List<ConverterEntry> ceList = new ArrayList<>();
		for (IConfigurationElement ce: Platform.getExtensionRegistry().getConfigurationElementsFor(CONVERT_ID)) {
			if ("converter".equals(ce.getName())) {					
				@SuppressWarnings("unchecked")
				ConverterEntry cEntry = new ConverterEntry((Converter<S,T,C>) injectProperties(ce, ce.createExecutableExtension("class")));
				
				String priorityStr = ce.getAttribute("priority");
				if (!CoreUtil.isBlank(priorityStr)) {
					cEntry.priority = Integer.parseInt(priorityStr);
				}
				
				IContributor contributor = ce.getContributor();		
				Bundle bundle = Platform.getBundle(contributor.getName());
				cEntry.source = (Class<?>) bundle.loadClass(ce.getAttribute("source").trim());
				cEntry.target = (Class<?>) bundle.loadClass(ce.getAttribute("target").trim());
				
				// TODO - match profile, navigate target class hierarchy
				
				ceList.add(cEntry);
			} else if ("converter_provider".equals(ce.getName())) {
				ConverterProvider cp = (ConverterProvider) CoreUtil.injectProperties(ce, ce.createExecutableExtension("class"));
				for (ConverterDescriptor<?, ?, ?> cd: cp.getConverterDescriptors()) {
					@SuppressWarnings("unchecked")
					ConverterEntry cEntry = new ConverterEntry((Converter<S,T,C>) cd.getConverter());
					cEntry.priority = cd.getPriority();
					cEntry.source = cd.getSourceType();
					cEntry.target = cd.getTargetType();
					// TODO - match profile.
					ceList.add(cEntry);
				}
			}
		}
		
		// TODO - services.
		
		Collections.sort(ceList);
					
		return new Converter<S,T,C>() {
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public T convert(S source, Class<T> target, C context) throws Exception {
				if (source == null) {
					return null;
				}
				if (target.isInstance(source)) {
					return (T) source;
				}
				for (ConverterEntry ce: ceList) {
					if (ce.source.isInstance(source) && target.isAssignableFrom(ce.target)) {
						T ret = ce.converter.convert(source, target, context);
						if (ret!=null) {
							return ret;
						}
					}
				}
				
				if (target.isEnum() && source instanceof String) {						
					return (T) Enum.valueOf((Class) target, (String) source);
				}

				// Constructor conversion - last resort
				for (Constructor<?> c: target.getConstructors()) {
					if (c.getParameterTypes().length==1 && c.getParameterTypes()[0].isInstance(source)) {
						return (T) c.newInstance(source);
					}
				}
				return null;
			}

			@Override
			public void close() throws Exception {
				for (ConverterEntry ce: ceList) {
					if (ce.converter!=null) {
						ce.converter.close();
					}
				}
			}
		};
		
	}

}
