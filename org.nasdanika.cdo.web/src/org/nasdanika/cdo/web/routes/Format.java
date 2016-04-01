package org.nasdanika.cdo.web.routes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows to customize how attributes of EObject return value are converted to JSON and how to JSON values are parsed to 
 * attribute values. SimpleDateFormat is used for dates, DecimalFormat for numbers, and MessageFormat for the rest. 
 * @author Pavel Vlasov
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface Format {
	
	/**
	 * Strings in the form <code>feature path</code> = <code>format</code>, e.g. <code>date=MM/dd/YYYY</code>
	 * Feature names may be hierarchical, e.g. <code>accounts.transactions.amount</code> means amount attribute of transactions reference of accounts reference.
	 */
	String[] value();
	
}
