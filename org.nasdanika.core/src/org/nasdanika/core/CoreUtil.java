package org.nasdanika.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private static final Pattern EXPANDER_PATTERN = Pattern.compile("\\$\\{(.+?)\\}");	
	
	/**
	 * Source of token values for interpolation.
	 * @author Pavel Vlasov.
	 *
	 */
	public interface TokenSource {
		
		Object get(String token);
		
	}

	/**
	 * Expands tokens in the form of <code>${token name}</code> to their values.
	 * If a token is not found expansion is not processed.
	 * @param input
	 * @param env
	 * @return
	 */
	public static String interpolate(String input, TokenSource tokenSource) {
		if (tokenSource==null) {
			return input;
		}
		Matcher matcher = EXPANDER_PATTERN.matcher(input);
		StringBuilder output = new StringBuilder();
		int i = 0;
		while (matcher.find()) {
		    String token = matcher.group();
			Object replacement = tokenSource.get(token.substring(2, token.length()-1));
		    if (replacement != null) {
			    output.append(input.substring(i, matcher.start())).append(replacement);			    
			    i = matcher.end();
		    }
		}
		output.append(input.substring(i, input.length()));
		return output.toString();
	}
	
	public static String interpolate(String input, final Map<String, Object> env) {
		return interpolate(input, new TokenSource() {

			@Override
			public Object get(String token) {
				return env==null ? null : env.get(token);
			}
			
		});
	}

	/**
	 * Expands tokens found in URL, InputStream, Reader or String. 
	 * @param input URL, InputStream, Reader or String.
	 * @param tokenSource Source of tokens.
	 * @return String with expanded tokens.
	 * @throws IOException
	 */
	public static String interpolate(Object input, TokenSource tokenSource) throws IOException {
		return interpolate(stringify(input), tokenSource);
	}

	/**
	 * Expands tokens found in URL, InputStream, Reader or String. 
	 * @param input URL, InputStream, Reader or String.
	 * @param env token to value map.
	 * @return String with expanded tokens.
	 * @throws IOException
	 */
	public static String interpolate(Object input, Map<String, Object> env) throws IOException {
		return interpolate(stringify(input), env);
	}
	
	/**
	 * Converts content of URL, InputStream or Reader to String.
	 * @param content URL, InputStream, Reader or String.
	 * @return
	 * @throws Exception
	 */
	public static String stringify(Object content) {
		if (content==null) {
			return null;
		}
		if (content instanceof String) {
			return (String) content;
		}
		if (content instanceof Reader) {
			try {
				StringWriter sw = new StringWriter();
				try (Reader reader = (Reader) content) {
					for (int ch = reader.read(); ch!=-1; ch = reader.read()) {
						sw.write(ch);
					}
				} 
				sw.close();
				return stringify(sw.toString());
			} catch (IOException e) {
				throw new NasdanikaException(e);
			}
		}
		if (content instanceof InputStream) {
			try (InputStream in = (InputStream) content) {
				return stringify(new InputStreamReader(in));
			} catch (IOException e) {
				throw new NasdanikaException(e);
			}
		}
		if (content instanceof URL) {
			try {
				return stringify(((URL) content).openStream());
			} catch (IOException e) {
				throw new NasdanikaException(e);
			}				
		}
		throw new IllegalArgumentException("Cannot stringify: "+content);
	}

	/**
	 * Injects properties from <code>property</code> elements into the target. 
	 * Property name may be a path separated by dots, e.g. <code>packageMap.org.nasdanika.core</code>. 
	 * If property path length is 1, e.g. <code>myProperty</code>, then value of the property is injected into the target through 
	 * a setter method, e.g. <code>setMyProperty()</code>, or through a field, e.g. <code>myProperty</code>. If method argument or field type is 
	 * not String, then constructor conversion is attempted. E.g. for <code>setMyProperty(int)</code> the method will attempt to construct <code>Integer</code>
	 * from the value string and then pass it to the setter.
	 * 
	 * <P/>
	 * 
	 * If property path length is more than 1, then a property is retrieved from the target through a getter or a field and then injection is performed recursively to the
	 * retrieved property. For example, <code>config.myProperty</code> property would be injected by reading <code>config</code> property of the target by invoking
	 * <code>getConfig()</code> method or reading <code>config</code> field. Then <code>myProperty</code> would be injected to the <code>config</code> property value.
	 * 
	 * <P/>
	 * 
	 * There is a special case for maps. If the target property type is {@link Map}, then property value is put to the map with remaining property path as a key, e.g.
	 * 
	 * given java code:
	 * <pre><code><span class="hljs-keyword">private</span> Map&lt;String, String&gt; packageMap = <span class="hljs-keyword">new</span> LinkedHashMap&lt;String, String&gt;();
	
public Map&lt;String, String&gt; getPackageMap() {
	return packageMap;
}
</code></pre>

<p>The property definition below puts <code>java</code> -&gt; <code>http://docs.oracle.com/javase/8/docs/api</code> entry to the <code>pacakgeMap</code>.</p>  
 
<pre><code>&lt;property
      name="packageMap.java"
      value="http://docs.oracle.com/javase/8/docs/api"&gt;
&lt;/property&gt;
</code></pre>  
	 * 
	 * 
	 * @param ce Configuration element
	 * @param target Target object, typically the return value of <code>createExecutableExtension()</code> method. 
	 * @return
	 * @throws Exception
	 */
	public static <T> T injectProperties(IConfigurationElement ce, final T target) throws Exception {
		for (IConfigurationElement cce: ce.getChildren()) {
			if ("property".equals(cce.getName())) {
				injectProperty(target, cce.getAttribute("name").split("\\."), cce.getAttribute("value"));
			}
		}
		return target;
	}

	@SuppressWarnings("unchecked")
	public static void injectProperty(Object target, String[] propertyPath, String value) throws Exception {
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
				
				// Array type conversion
				if (target.isArray()) {
					if (source.getClass().isArray()) {
						int length = Array.getLength(source);
						Class<?> targetComponentType = target.getComponentType();
						Object ret = Array.newInstance(targetComponentType, length);
						for (int i=0; i<length; ++i) {
							Object sourceElement = Array.get(source, i);
							@SuppressWarnings("resource")
							Converter rawConverter = (Converter) this;
							Object targetElement = rawConverter.convert(sourceElement, targetComponentType, context);
							Array.set(ret, i, targetElement);
						}
						return (T) ret;
					}
					
					if (source instanceof Collection) {
						Collection<?> sourceCollection = (Collection<?>) source;
						Class<?> targetComponentType = target.getComponentType();
						Object ret = Array.newInstance(targetComponentType, sourceCollection.size());
						int idx = 0;
						for (Object sourceElement: sourceCollection) {
							@SuppressWarnings("resource")
							Converter rawConverter = (Converter) this;
							Object targetElement = rawConverter.convert(sourceElement, targetComponentType, context);
							Array.set(ret, idx, targetElement);
						}
						return (T) ret;
					}
					
					Class<?> targetComponentType = target.getComponentType();
					Object ret = Array.newInstance(targetComponentType, 1);
					@SuppressWarnings("resource")
					Converter rawConverter = (Converter) this;
					Object targetElement = rawConverter.convert(source, targetComponentType, context);
					Array.set(ret, 0, targetElement);
					return (T) ret;
					
				}
				
				Class<?> box = PRIMITIVES_TO_BOXES_MAP.get(target);

				// Constructor conversion - last resort
				for (Constructor<?> c: (box==null ? target : box).getConstructors()) {
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
