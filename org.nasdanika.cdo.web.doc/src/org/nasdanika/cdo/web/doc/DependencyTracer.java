package org.nasdanika.cdo.web.doc;

import java.util.HashSet;
import java.util.Set;

public abstract class DependencyTracer<T> {

	/**
	 * Traces dependencies from a set of starting objects
	 * @param from Starting object
	 * @param depth Trace depth. 0 - just the starting objects, -1 - infinite.
	 * @param chain Combine results with the chain.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Set<T> trace(Set<T> from, int depth, DependencyTracer<T>... chain) {
		Set<T> ret = createAccumulator();
		for (T f: from) {
			Set<T> acc = createAccumulator();
			trace(f, depth, chain, acc);
			ret.addAll(acc);
		}
		for (DependencyTracer<T> ch: chain) {
			if (ch != null) {
				ret.addAll(ch.trace(from, depth));
			}
		}
		return ret;
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<T> trace(T from, int depth, DependencyTracer<T>... chain) {
		Set<T> ret = createAccumulator();
		trace(from, depth, chain, ret);
		for (DependencyTracer<T> ch: chain) {
			if (ch != null) {
				ret.addAll(ch.trace(from, depth));
			}
		}
		return ret;
	}
	
	/**
	 * Creates accumulator set
	 * @return HashSet, subclasses may override to return, for example, TreeSet.
	 */
	protected Set<T> createAccumulator() {
		return new HashSet<T>();
	}
	
	private void trace(T from, int depth, DependencyTracer<T>[] chain, Set<T> accumulator) {
		if (accumulator.add(from)) {
			if (depth != 0) {
				for (T dep: getDependencies(from)) {
					trace(dep, depth == -1 ? depth : depth - 1, chain, accumulator);
				}
			}
		}
	}		
	
	
	/**
	 * @param obj
	 * @return Dependencies to trace.
	 */
	protected abstract Iterable<T> getDependencies(T obj);

}
