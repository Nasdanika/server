package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * If a public field in a test class has this annotation, then the framework obtains a service of
 * field's type, creates an actor factory proxy for it and injects the proxy into the field.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActorFactory {

	/**
	 * Service filter pattern. It can contain {0}...{n} tokens expanded with parameter values for parameterized tests. It allows to select
	 * different actor factory implementations based on parameter, e.g. Appium implementation when testing iOS device, Selendroid implementation when testing
	 * an older Android device, and a regular Selenium implementation for testing in a browser.
	 * @return
	 */
	String filter() default "";
	
}
