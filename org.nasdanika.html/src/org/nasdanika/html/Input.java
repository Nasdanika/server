package org.nasdanika.html;

/**
 * A generic UI element. It doesn't add any functionality, only binds UIElement and Container generic parameter to self for convenience.
 * @author Pavel
 *
 */
public interface Input extends UIElement<Input>, Container<Input> {
	
	Input autocomplete(boolean autocomplete);
	Input autocomplete();
	
	Input autofocus(boolean autofocus);
	Input autofocus();
	
	Input form(Form... form);
	
	Input formaction(Object formaction);
	
	Input formenctype(Form.EncType formEncType);
	
	Input formmethod(Form.Method formMethod);
	
	Input formnovalidate(boolean formnovalidate);
	Input formnovalidate();
	
	Input formtarget(Object formTarget);
	
	Input dimensions(int width, int height);
	
	Input list(Object dataListId);
	
	Input min(Object min);
	Input max(Object max);
	
	Input multiple(boolean multiple);
	Input multiple();
	
	Input pattern(Object pattern);
	
	Input name(Object name);
	
	Input value(Object value);
	
	Input placeholder(Object placeholder);
	
	Input required(boolean required);
	Input required();
	
	Input step(Object step);	
	
	/**
	 * Adds AngularJS model attribute.
	 * @param expr
	 * @return
	 */
	Input ngModel(Object expr);

}
