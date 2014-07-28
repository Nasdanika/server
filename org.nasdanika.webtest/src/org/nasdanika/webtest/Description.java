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
@Target({ElementType.TYPE, ElementType.METHOD})
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
	 * Description format. HTML by default. If set to false, report generator HTML-escapes the description,
	 * adds new line characters between description strings and put resulting text into PRE tag. 
	 * @return
	 */
	boolean html() default true;
	
}
