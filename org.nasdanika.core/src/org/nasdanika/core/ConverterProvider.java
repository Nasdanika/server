package org.nasdanika.core;

public interface ConverterProvider {
	
	interface ConverterDescriptor<S,T,C extends ConverterContext> {
		Converter<S,T,C> getConverter();
		
		Class<S> getSourceType();
		
		Class<T> getTargetType();
		
		Class<C> getContextType();
		
		int getPriority();
		
		String getProfile();

	}
	
	Iterable<ConverterDescriptor<?,?,?>> getConverterDescriptors();

}
