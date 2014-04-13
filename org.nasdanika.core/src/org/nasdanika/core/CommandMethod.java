package org.nasdanika.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for command methods.
 * @author Pavel
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommandMethod {
	
	/**
	 * Command name. If blank (default) then method name is used as command name.
	 * @return
	 */
	String value() default "";
}
