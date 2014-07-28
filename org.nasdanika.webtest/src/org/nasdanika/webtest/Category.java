package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for grouping actors and pages into categories.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Category {

	/**
	 * Category path.
	 * @return
	 */
	String[] value() default {};
	
}
