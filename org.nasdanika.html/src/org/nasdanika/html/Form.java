package org.nasdanika.html;


public interface Form extends UIElement<Form>, FieldWriter<Form> {
	
	/**
	 * Sets the form as horizontal.
	 * @param deviceSize Device size code to use in column width specifications.
	 * @param labelWidth Label column width.
	 * @return
	 */
	Form horizontal(DeviceSize deviceSize, int labelWidth);
	
	Form inline(boolean inline);
	
	Form inline();	
		
}
