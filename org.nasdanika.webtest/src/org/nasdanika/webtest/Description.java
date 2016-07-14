package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test/actor/page class/method description to display in report.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {

	/**
	 * Textual description.
	 * @return
	 */
	String[] value() default {};
	
	/**
	 * URL to load description from.
	 * @return
	 */
	String url() default "";
	
	/**
	 * Description content (MIME) type. Text by default. 
	 * @return
	 */
	String contentType() default "text/plain";
	
}
