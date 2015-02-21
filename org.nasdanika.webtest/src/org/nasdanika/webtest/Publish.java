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
	 * Publish URL. If not set, then the URL is taken from NASDANIKA_WEBTEST_PUBLISH_URL environment variable.
	 * If such variable is not defined, then report is not published. It allows to publish to different report
	 * servers in different test execution environments without having to touch test code.
	 * @return
	 */
	String url() default "";
	
	/**
	 * Security token. If not set, then the URL is taken from NASDANIKA_WEBTEST_PUBLISH_SECURITY_TOKEN environment variable. 
	 * @return
	 */
	String securityToken() default "";
	
	/**
	 * If true navigation timings are published to the server.
	 * @return
	 */
	boolean publishPerformance() default false;
	
}
