package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Route method parameters with this annotation are provided values from request parameter with a given name. 
 * Parameter type can be String, String[] or Collection. 
 * @author Pavel
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface QueryParameter {
	
	/**
	 * Query parameter name.
	 * @return
	 */
	String value();
	
}
