package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for grouping tests, actors and pages into categories.
 * Category can be hierachical with forward slash (/) separating elements.
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
	String value();
	
}
