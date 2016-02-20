package org.nasdanika.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command method parameters with this annotation are provided values from extensions. Extensions are configured
 * with {@link CoreUtil}.injectProperties() method.
 * Parameter type can be of extension type or array. 
 * @author Pavel
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ExtensionParameter {
	
	/**
	 * Extension point name.
	 * @return
	 */
	String point();

	/**
	 * Configuration element(s) name to create executable extensions from.
	 * @return
	 */
	String configurationElement();
	
	/**
	 * Configuration element attribute containing class name of the extension.
	 * @return
	 */
	String classAttribute() default "class"; 
	
}
