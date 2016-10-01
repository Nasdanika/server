package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.nasdanika.cdo.boxing.Boxer;

/**
 * This annotation instructs the test runner to store argument value or method return value to the report model.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportValue {
	
	/**
	 * Boxer to use to store argument value to the model.
	 */
	Class<? extends Boxer> value() default DefaultArgumentBoxer.class;
		
}
