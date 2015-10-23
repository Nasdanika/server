package org.nasdanika.web;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.core.Context;

public class CompositeObjectPathResolver implements ObjectPathResolver<Object>, Cloneable {
	
	private List<ResolverEntry<?>> resolvers = new ArrayList<>();
	
	private class ResolverEntry<T> {
		Class<T> clazz;
		ObjectPathResolver<T> resolver;
		
		ResolverEntry(Class<T> clazz, ObjectPathResolver<T> resolver) {
			super();
			this.clazz = clazz;
			this.resolver = resolver;
		}		
	}
	
	public <T> void addResolver(Class<T> clazz, ObjectPathResolver<T> resolver) {
		resolvers.add(new ResolverEntry<>(clazz, resolver));
	}

	@SuppressWarnings("unchecked")
	@Override
	public String resolve(Object obj, ObjectPathResolver<Object> master, Context context) throws Exception {
		ResolverEntry<Object> candidate = null;
		for (ResolverEntry<?> r: resolvers) {
			if (r.clazz==null || r.clazz.isInstance(obj)) {
				if (candidate==null 
						|| candidate.clazz==null 
						|| candidate.clazz.isAssignableFrom(r.clazz)) {
					candidate = (ResolverEntry<Object>) r;
				}
			}
		}
		if (candidate!=null) {
			String ret = candidate.resolver.resolve(obj, this, context);
			if (ret!=null) {
				return ret;
			}
		}
		if (master!=null) {
			String ret = master.resolve(obj, null, context);
			if (ret!=null) {
				return ret;
			}
		}
		return context instanceof HttpServletRequestContext ? ((HttpServletRequestContext) context).getRootObjectsPaths().get(obj) : null;
	}
	
	@Override
	public CompositeObjectPathResolver clone() throws CloneNotSupportedException {
		CompositeObjectPathResolver ret = (CompositeObjectPathResolver) super.clone();
		ret.resolvers = new ArrayList<>(ret.resolvers); // Deep copy of resolvers list.
		return ret;
	}

}
