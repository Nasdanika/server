package org.nasdanika.cdo.web;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows to customize how EObject return value is converted to JSON.
 * @author Pavel Vlasov
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ResponseModel {
	
	/**
	 * Structural features to include into JSON object. By default all features are included.
	 * Feature names may be hierarchical, e.g. <code>accounts.transactions.amount</code> means amount attribute of transactions reference of accounts reference.
	 * @return
	 */
	String[] include() default {};
	
	/**
	 * Structural features to exclude from the JSON object. By default none are excluded.
	 * Feature names may be hierarchical, e.g. <code>accounts.transactions.amount</code> means amount attribute of transactions reference of accounts reference.
	 * @return
	 */
	String[] exclude() default {};
	
	/**
	 * References to convert to JSON by value. By default containment references are converted by value. 
	 * Reference names may be hierarchical, e.g. <code>accounts.transactions.amount</code> means amount attribute of transactions reference of accounts reference.
	 */
	String[] valueReferences() default {};
	
	/**
	 * References to convert to JSON by Object ID. By default no references are included by ID. 
	 * Reference names may be hierarchical, e.g. <code>accounts.transactions.amount</code> means amount attribute of transactions reference of accounts reference.
	 */	
	String[] idReferences() default {};
	
	/**
	 * References to convert to JSON by object path. By default non-containment references are converted by object path. 
	 * Reference names may be hierarchical, e.g. <code>accounts.transactions.amount</code> means amount attribute of transactions reference of accounts reference.
	 */	
	String[] pathReferences() default {};

}
