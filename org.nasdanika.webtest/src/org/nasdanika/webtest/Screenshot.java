package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows to suppress screenshot on actor/page method or initialization by setting value to false or to introduce delay before
 * taking screenshot.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Screenshot {
	
	/**
	 * Indicates when to take a screenshot or when a screenshot was taken.
	 * @author Pavel Vlasov
	 *
	 */
	enum When { 
		
		/**
		 * Before method execution.
		 */
		BEFORE, 
		
		/**
		 * During method execution. This value shall not be used by clients - it is used internally by {@link WebTestUtil}.takeScreenshot(String) method.
		 */
		DURING, 
		
		/**
		 * After method execution.
		 */
		AFTER, 
		
		/**
		 * When method throws an exception.
		 */
		EXCEPTION 
		
	}

	When[] value() default {When.BEFORE, When.AFTER, When.EXCEPTION};
	
	/**
	 * Delay in milliseconds. This delay is added to the delay value returned by {@link WebTest}.getScreenshotDelay();
	 * @return
	 */
	long delay() default 0;
			
}
