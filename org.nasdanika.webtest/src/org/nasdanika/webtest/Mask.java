package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation instructs the test runner to mask argument value.
 * The annotation shall be placed on the Page/Actor interface method parameter, not
 * implementation.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mask {
		
}
