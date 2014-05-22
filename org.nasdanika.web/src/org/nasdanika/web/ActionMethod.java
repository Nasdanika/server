package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation tells router to wrap object method into an action.
 * ActionMethod may take WebContext parameter. If method returns value, this value is written to response. 
 * @author Pavel
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionMethod {
	
	/**
	 * Supported HTTP methods. Defaults to GET.
	 * @return
	 */
	RequestMethod[] value() default RequestMethod.GET;
	
	/**
	 * Pattern to match path. If not set then method
	 * is matched if path's second elements equals to method name.
	 * @return
	 */
	String pattern() default "";
	
	/**
	 * Priority in matching, use it for overlapping patterns. Defaults to 0.
	 * @return
	 */
	int priority() default 0;
	
	/**
	 * Response content type if not set by the method.
	 * @return
	 */
	String contentType() default "";

}
