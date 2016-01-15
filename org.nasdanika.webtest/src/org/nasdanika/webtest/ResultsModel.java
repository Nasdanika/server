package org.nasdanika.webtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * If this annotation is present, test results are written into a model file and screenshots are saved into a screenshots directory next to the model file.
 * @author Pavel Vlasov
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ResultsModel {

	/**
	 * Results output directory. 
	 * Can be a template with 
	 * {packageName} expanding to the test class' package name,
	 * {className} expanding to test class short name e.g. String for java.lang.String,
	 * {packageHierarchy} expanding to the test class' package name with dots replaced with forward slashes, e.g. java/lang for java.lang.String,
	 * {classQualifiedName} expanding to the test class fully qualified name.
	 * 
	 * After token expansion forward slashes get replaced with the platform file separator.
	 * @return
	 */
	String outputDir() default "target/nasdanika-web-tests-results-model/{packageHierarchy}";
	
	String model() default "{className}.xml";
	
	String screenshotsDirectory() default "{className}Screenshots";
	
}
