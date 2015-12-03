package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation allows to specify in which context a page method shall be invoked. Applicable only to 
 * ContextAware drivers. If there is no method-level annotation, than class-level annotation is used, if any.
 * Annotations are taken from page implementation classes/methods, not from page interfaces, which shall be implementation-agnostic.
 * 
 * When Context annotation is specified at the class level, {@link WebTestUtil}.initElements(D driver, Class<T> pageClassToProxy, Object... args) method is executed in the 
 * specified context.
 * 
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Context {
	
	String value();

}
