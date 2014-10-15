package org.nasdanika.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;

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

	private static void injectProperty(Object target, String[] propertyPath, String value) throws Exception {
		if (propertyPath.length==1) {
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
		} else if (propertyPath.length>1) {
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
		StringBuilder sb = new StringBuilder();
		for (String pe: sa) {
			if (sb.length()>0) {
				sb.append(separator);
			}
			sb.append(pe);
		}
		return sb.toString();
	}

}
