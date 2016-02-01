package org.nasdanika.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be used on classes with {@link RouteMethod} annotations
 * processed by {@link DispatchingRoute} to mount class loader or bundle resources to
 * the class.
 * @author Pavel Vlasov
 *
 */
@Repeatable(Resources.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Resource {
	
	/**
	 * Resource URL path relative to the object path.
	 * @return
	 */
	String value();
	
	/**
	 * If this attribute is set resource(s) is loaded from 
	 * a bundle with matching symbolic name. Otherwise resource is loaded from the 
	 * class' classloader.
	 * @return
	 */
	String bundle() default "";
	
	/**
	 * Optional version range. If the range has only one attribute, then
	 * the bundle's version shall be greater or equal to the specified version, 
	 * if two versions are provided, then it should be inclusive/exclusive [first version, second version)
	 * @return
	 */
	String[] bundleVersion() default {};
	
	/**
	 * Resource classloader or bundle path. If not set, defaults to the URL path (value).
	 * If path ends with / then resource is considered a directory.
	 * Classloader resources are resolved relative to the annotated class.
	 */
	String path() default "";
	
}
