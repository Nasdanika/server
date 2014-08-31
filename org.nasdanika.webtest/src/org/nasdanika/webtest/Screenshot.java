package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows to suppress screenshot on actor/page method by setting value to false or to introduce delay before
 * taking screenshot.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Screenshot {
	
	/**
	 * Indicates when to take a screenshot.
	 * @author Pavel Vlasov
	 *
	 */
	enum When { BEFORE, AFTER, EXCEPTION }

	When[] value() default {When.BEFORE, When.AFTER, When.EXCEPTION};
	
	/**
	 * Delay in milliseconds. This delay is added to the delay value returned by {@link WebTest}.getScreenshotDelay();
	 * @return
	 */
	long delay() default 0;
	
}
