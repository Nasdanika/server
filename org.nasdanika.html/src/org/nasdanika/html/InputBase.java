package org.nasdanika.html;

/**
 * Base interface for Input, Select, and TextArea
 * @author Pavel
 *
 * @param <T>
 */
public interface InputBase<T extends InputBase<?>> extends UIElement<T> {
	
	T autofocus(boolean autofocus);
	T autofocus();

	T name(Object name);
	
	T required(boolean required);
	T required();
	
	T disabled(boolean disabled);
	T disabled();
		
	T form(Form... form);
		
	/**
	 * Adds AngularJS model attribute.
	 * @param expr
	 * @return
	 */
	T ngModel(Object expr);
	
}
