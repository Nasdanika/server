package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Generic link annotation to establish a reference to an external entity. For example, to link an actor class to
 * the story model actor, or a test method to an acceptance criterion.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Links.class)
public @interface Link {

	/**
	 * @return Link value, e.g. URL.
	 */
	String value();
	
	/**
	 * @return Optional link type.
	 */
	String type() default "";
	
	/**
	 * @return Optional comment.
	 */
	String comment() default "";
}
