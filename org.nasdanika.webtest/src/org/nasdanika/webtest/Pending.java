package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Ignore;

/**
 * Pending methods are not executed but, unlike methods with {@link Ignore} annotation, are included into the report. This annotation may be used on methods which are
 * implemented against actor/page specification, but for which the implementation is not yet ready, e.g. page/actor methods being
 * used are stubs throwing {@link UnsupportedOperationException}. Pending annotations may have an expiration date specified in <code>until</code> element. 
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pending {

	/**
	 * @return Date after which pending annotation gets ignored and the test method
	 * gets executed. Format: yyyy-MM-dd
	 */
	String until() default "";
	
}
