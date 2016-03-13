package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation tells router to mount object filed of type Route of its subtype as a route.
 * @author Pavel
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RouteField {
	
	/**
	 * Supported HTTP methods. Defaults to GET.
	 * @return
	 */
	RequestMethod[] value() default RequestMethod.GET;
	
	/**
	 * Path, if not set and pattern is not set, then defaults to the field name.
	 * @return
	 */
	String path() default "";
	
	/**
	 * Pattern to match path. If not set then field
	 * is matched if path's second elements equals to field name.
	 * @return
	 */
	String pattern() default "";
	
	/**
	 * Priority in matching, use it for overlapping patterns. Defaults to 0.
	 * @return
	 */
	int priority() default 0;
	
	/**
	 * Response content type if not set by the field.
	 * @return
	 */
	String contentType() default "";

}
