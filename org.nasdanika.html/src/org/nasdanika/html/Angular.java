package org.nasdanika.html;

/**
 * Angular.js interface.
 * @author Pavel Vlasov
 *
 */
public interface Angular<T> extends AutoCloseable {
	
	/**
	 * Adds AngularJS application attribute with blank name.
	 * @return
	 */
	T app();
	
	/**
	 * Adds AngularJS application attribute.
	 * @param appName
	 * @return
	 */
	T app(Object appName);
	
	/**
	 * Adds AngularJS controller attribute.
	 * @param controllerName
	 * @return
	 */
	T controller(Object controllerName);
	
	T hide(Object expr);
	
	T show(Object expr);

	T repeat(Object expr);
	
	T clazz(Object expr);
	
	T cloak();
	
	T bind(Object expr);
	
	T bindHtml(Object expr);
	
	T click(Object expr);

	/**
	 * Custom directive
	 * @param directive
	 * @param value
	 * @return
	 */
	T directive(String directive, Object expr);
}
