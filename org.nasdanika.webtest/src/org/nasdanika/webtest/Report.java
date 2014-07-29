package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Report configuration.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Report {

	/**
	 * Report output directory. Can be a template with {0} expanding to test class short name e.g. String for java.lang.String,
	 * {1} expanding to the fully qualified name, and {2} expanding to the fully qualified name with dots replaced with the file
	 * separator, e.g. java/lang/String. Default template is <code>nasdanika-web-tests/{2}</code>. In the template forward slashes 
	 * get replaced with the platform file separator.
	 * @return
	 */
	String outputDir() default "nasdanika-web-tests/{2}";
	
	/**
	 * Screenshot slide width in the carousel. 
	 * @return
	 */
	int slideWidth() default 800;
		
	// Style
	
	// Slide sizes
	
}
