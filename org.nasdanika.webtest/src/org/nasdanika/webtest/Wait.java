package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.support.How;

/**
 * Used to mark a method on a Page Object to indicate that this method shall be
 * invoked after the wait condition is satisfied or to mark a page object class
 * to wait for conditions before initializing page objects with
 * {@link WebTestUtil}.initElements(...) methods.
 * 
 * <p>
 * You can either use this annotation by specifying both "how" and "using" or by
 * specifying one of the location strategies (eg: "id") with an appropriate
 * value to use. Both options will delegate down to the matching
 * {@link org.openqa.selenium.By} methods in By class.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Wait {

	// Location attributes.
	
	How how() default How.ID;

	String using() default "";

	String id() default "";

	String name() default "";

	String className() default "";

	String css() default "";

	String tagName() default "";

	String linkText() default "";

	String partialLinkText() default "";

	String xpath() default "";

	// Waiting attributes.
	
	enum Condition { VISIBLE, CLICKABLE, INVISIBLE, PRESENT }
	
	Condition condition() default Condition.VISIBLE;
	
	/**
	 * Negates condition.
	 * @return
	 */
	boolean not() default false;
	
	/**
	 * Indicates that ...All... methods shall be used where applicable, e.g. {@link org.openqa.selenium.support.ui.ExpectedConditions}.<code>visibilityOf<b>All</b>ElementsLocatedBy</code> instead
	 * of <code>visibilityOfElementLocatedBy()</code>  
	 * @return
	 */
	boolean all() default false;
	
	/**
	 * Timeout in seconds.
	 * @return
	 */
	long timeout() default 3;
}
