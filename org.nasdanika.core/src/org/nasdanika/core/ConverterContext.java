package org.nasdanika.core;

public interface ConverterContext extends Context {
	
	/**
	 * Converts source to target type in given extensionManager.
	 * @param source
	 * @param targetType
	 * @return source converted to target type or null if conversion is not possible.
	 * @throws Exception
	 */
	<T> T convert(Object source, Class<T> targetType) throws Exception;

}
