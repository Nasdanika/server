package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * If a method or type is annotated with this annotation and the web driver is an instance of {@link SketchWebDriver}, the framework uses
 * sketches as screenshots. Applying the annotation to a type has the same semantic as applying it to all type constructors. 
 * 
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Sketch {

	/**
	 * Value is an alias for <code>after</code> sketch. If both <code>value</code> and <code>after</code> attributes are specified, <code>after</code> takes precedence. 
	 * @return
	 */
	String value() default ""; 
	
	/**
	 * Location of a sketch for the before screenshot. The location is resolved relative to the annotated method's declaring class, i.e. a sketch can be loaded from 
	 * a classloader resource, if the location is relative, or from a regular URL. If the location ends with <code>.png</code> then it is treated as a PNG file and 
	 * loaded AS-IS. If the location ends with <code>.plantuml</code> it is treated as a <a href="http://plantuml.com/">PlantUML</a> diagram specification, e.g. 
	 * a <a href="http://plantuml.com/salt.html">Salt</a> wireframe. The specification gets rendered to a PNG file. Otherwise the location is treated as a web browser URL which is
	 * retrieved using {@link PhantomJSDriver} behind the scenes. In this case classloader resources cannot be used as locations. 
	 * @return
	 */
	String before() default "";
	
	/**
	 * Location of a sketch for the after screenshot.
	 * @return
	 */
	String after() default "";
	
	/**
	 * Location of a sketch for the exception screenshot.
	 * @return
	 */
	String exception() default "";
	
	/**
	 * Optional window size. It is applicable only to locations retrieved by {@link PhantomJSDriver}. The attribute value shall be a two-dimensional array with the first element 
	 * specifying the window width, and the last - window height.
	 * @return
	 */
	int[] windowSize() default {};
		
}
