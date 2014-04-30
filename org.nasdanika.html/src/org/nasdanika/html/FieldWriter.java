package org.nasdanika.html;


public interface FieldWriter<T extends FieldWriter<?>> {
		
	/**
	 * Adds content, e.g. control definitions.
	 * @param content
	 * @return
	 */
	T content(String content);
	
	/**
	 * Creates a form group with a label.
	 * @param label
	 * @param controlId
	 * @param controlDefintion
	 * @return
	 */
	FormGroup<?> formGroup(String label, String controlId, String controlDefintion, String helpText);
	
	InputGroup<?> inputGroup(String controlDefinition);
	
	FormInputGroup formInputGroup(String label, String controlId, String controlDefintion, String helpText);
	
	/**
	 * Creates a checkbox control with a label.
	 * @param label
	 * @param checkboxDefinition
	 * @param inline
	 * @return
	 */
	T checkbox(String label, String checkboxDefinition, boolean inline);
	
	/**
	 * Creates a radio control with a label.
	 * @param label
	 * @param checkboxDefinition
	 * @return
	 */
	T radio(String label, String radioDefinition, boolean inline);
	
	Button button(String text);
	
	FieldSet fieldset();
	
	/**
	 * Creates a new field writer backed by this writer configuration. The new writer
	 * is not added to this writer. This method can be used for wrapping of a group of fields
	 * into a container, e.g. a panel - create field writer, add fields, create a panel from 
	 * the writer, add panel to this writer using content() method.
	 * @return
	 */
	FieldWriter<?> fieldWriter();

}
