package org.nasdanika.webtest;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Base class for invocation handlers which proxy/replace return values of methods.
 * @author Pavel
 *
 */
public class FilteringInvocationHandler<T> implements InvocationHandler {
	
	protected T target;

	public FilteringInvocationHandler(T target) {
		this.target = target;
	}
	
	/**
	 * This implementation recursively replaces list and array elements, and map values with filtered
	 * objects.  
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Object filter(Object obj) {
		if (obj==null) {
			return null;		
		}
		if (obj.getClass().isArray()) {
			for (int i=0, l=Array.getLength(obj); i<l; ++i) {
				Array.set(obj, i, filter(Array.get(obj, i)));
			}			
		} else if (obj instanceof List) {
			ListIterator<Object> lit = ((List<Object>) obj).listIterator();
			while (lit.hasNext()) {
				lit.set(filter(lit.next()));
			}
		} else if (obj instanceof Map) {
			for (Entry<?, Object> e: ((Map<?, Object>) obj).entrySet()) {
				e.setValue(filter(e.getValue()));
			}
		}				
		
		return obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return filter(method.invoke(target, args));
	}

}
