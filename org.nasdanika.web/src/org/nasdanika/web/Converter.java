package org.nasdanika.web;

/**
 * Implementations of this interface are contributed by extensions.
 * @author Pavel
 *
 * @param <S>
 * @param <T>
 */
public interface Converter<S,T> {
	
	T convert(S source, Class<T> target, Context context) throws Exception;
	
}
