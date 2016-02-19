package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation tells router to wrap object method into a route.
 * ActionMethod may take HttpServletRequestContext parameter. If method returns value, this value is written to response. 
 * @author Pavel
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RouteMethod {
	
	/**
	 * Supported HTTP methods. 
	 * @return
	 */
	RequestMethod[] value() default {};
	
	/**
	 * Pattern to match path. If not set then method
	 * is matched if path's second elements equals to method name.
	 * @return
	 */
	String pattern() default "";
	
	/**
	 * Route method path. Takes precedence over pattern. May contain path parameter specs, e.g. <code>{something}</code>
	 * @return
	 */
	String path() default "";
	
	/**
	 * Priority in matching, use it for overlapping patterns. Defaults to 0.
	 * @return
	 */
	int priority() default 0;
	
	/**
	 * Response content type produced by the method. Used for route matching and for setting response content type if not set by the method.
	 * @return
	 */
	String produces() default "";
	
	/**
	 * Content types which this method can consume. Used for matching the method to request. Empty array matches any content type.
	 * @return
	 */
	String[] consumes() default {};
	
	/**
	 * Authorization action. If not set, the request method name is used, e.g. GET.
	 * @return
	 */
	String action() default "";
	
	/**
	 * Authorization qualifier. If not set, the route method name is used.
	 * @return
	 */
	String qualifier() default "";

}
