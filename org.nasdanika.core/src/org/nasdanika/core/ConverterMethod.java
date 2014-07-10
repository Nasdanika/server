package org.nasdanika.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Mark method as a converter method. First method parameter is source, optional second is context.
 * Additional parameters with {@link Reference} annotation get injected with OGSi service instances. 
 * @author Pavel
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ConverterMethod {
	int value() default 0; // Priority
	String profile() default "";
}
