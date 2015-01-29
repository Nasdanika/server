package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation instructs the test runner to publish test results to a report server.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Publish {
	
	/**
	 * Report server URL.
	 * @return
	 */
	String url();
	
	/**
	 * Security token. 
	 * @return
	 */
	String securityToken();
	
	/**
	 * If true navigation timings are published to the server.
	 * @return
	 */
	boolean publishPerformance() default false;
	
}
