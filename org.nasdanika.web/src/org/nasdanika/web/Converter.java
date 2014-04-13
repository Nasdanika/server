package org.nasdanika.web;

/**
 * Implementations of this interface are contributed by extensions.
 * @author Pavel
 *
 * @param <S>
 * @param <T>
 */
public interface Converter<S,T> extends AutoCloseable {
	
	T convert(S source, Class<T> target, WebContext context) throws Exception;
	
}
