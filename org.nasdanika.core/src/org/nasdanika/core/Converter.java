package org.nasdanika.core;

/**
 * Implementations of this interface are contributed by extensions.
 * @author Pavel
 *
 * @param <S> Source type
 * @param <T> Target type
 * @param <C> Context type
 */
public interface Converter<S,T,C extends ConverterContext> extends AutoCloseable {
	
	T convert(S source, Class<T> target, C context) throws Exception;
	
}
