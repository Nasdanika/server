package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test/actor/page class/method title in report.
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
