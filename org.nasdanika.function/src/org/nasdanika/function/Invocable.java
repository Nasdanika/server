package org.nasdanika.function;

public interface Invocable {
	
	Object invoke(Object... args) throws Exception;
	
	Class<?>[] getParameterTypes();
	
	Class<?> getReturnType();

}
