package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * If a public field in a test class has this annotation, then the framework obtains a service of
 * field's type, creates a page factory proxy for it and injects the proxy into the field.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageFactory {

	/**
	 * Service filter.
	 * @return
	 */
	String filter() default "";
	
}
