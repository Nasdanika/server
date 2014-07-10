package org.nasdanika.core;

public interface Adaptable {
	
	<T> T adapt(Class<T> targetType);

}
