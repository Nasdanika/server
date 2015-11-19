package org.nasdanika.html;

/**
 * Knockout.js interface.
 * @author Pavel Vlasov
 *
 */
public interface Knockout<T> extends KnockoutControlFlow<T> {
	
	T visible(Object expression);
	T text(Object expression);
	T html(Object expression);
	T css(Object expression);
	T style(Object expression);
	T attr(Object expression);
	T click(Object expression);
	T event(Object expression);
	T submit(Object expression);
	T enable(Object expression);
	T disable(Object expression);
	T value(Object expression);
	T textInput(Object expression);
	T hasFocus(Object expression);
	T checked(Object expression);
	T options(Object expression);
	T selectedOptions(Object expression);
	T uniqueName(Object expression);
	T template(Object expression);

}
