package org.nasdanika.html;

/**
 * Knockout bindings which can be used on a regular and virtual elements.
 * @author Pavel
 *
 */
public interface KnockoutControlFlow<T> {

	T foreach(Object expression);
	T if_(Object expression);
	T ifnot(Object expression);
	T with(Object expression);
	T component(Object expression);

	/**
	 * Custom binding
	 * @param binding
	 * @param expression
	 * @return
	 */
	T bind(String binding, Object expression);
	
}
