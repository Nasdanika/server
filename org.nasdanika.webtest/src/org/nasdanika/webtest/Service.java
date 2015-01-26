package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * If a public field in a test class has this annotation, then the framework obtains a service of
 * field's type and injects the proxy into the field.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

	/**
	 * Service filter pattern. It can contain {0}...{n} tokens expanded with parameter values for parameterized tests. It allows to select
	 * different service implementations based on parameter.
	 * @return
	 */
	String filter() default "";
	
}
