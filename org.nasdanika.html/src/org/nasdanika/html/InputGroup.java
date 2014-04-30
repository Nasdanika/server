package org.nasdanika.html;

public interface InputGroup<T extends InputGroup<?>> extends UIElement<T> {

	/**
	 * Sets left add-on
	 * @param addOn
	 * @return
	 * @throws IllegalStateException if left button has already been created.
	 */
	T leftAddOn(String addOn);
	
	T size(Size size);
	
	/**
	 * Creates left button.
	 * @param text
	 * @return
	 * @throws IllegalStateException if left add-on has already been set. 
	 */
	Button leftButton(String text);
	
	/**
	 * Sets right add-on
	 * @param addOn
	 * @return
	 * @throws IllegalStateException if right button has already been created.
	 */
	T rightAddOn(String addOn);
	
	/**
	 * Creates rigth button.
	 * @param text
	 * @return
	 * @throws IllegalStateException if right add-on has already been set. 
	 */
	Button rightButton(String text);
	
}
