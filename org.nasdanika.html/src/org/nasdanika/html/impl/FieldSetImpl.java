package org.nasdanika.html.impl;

import org.nasdanika.html.Button;
import org.nasdanika.html.FieldSet;
import org.nasdanika.html.FieldWriter;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.InputGroup;

class FieldSetImpl extends UIElementImpl<FieldSet> implements FieldSet {
	
	private FieldWriterImpl<FieldSet> writer;
	private boolean disabled;

	FieldSetImpl(FormImpl form) {
		writer = new FieldWriterImpl<FieldSet>(this, form);				
	}

	@Override
	public FieldSet content(String content) {
		return writer.content(content);
	}

	@Override
	public FormGroup<?> formGroup(String label, String controlId, String controlDefintion, String helpText) {
		return writer.formGroup(label, controlId, controlDefintion, helpText);
	}

	@Override
	public FieldSet checkbox(String label, String checkboxDefinition, boolean inline) {
		return writer.checkbox(label, checkboxDefinition, inline);
	}

	@Override
	public FieldSet radio(String label,	String radioDefinition, boolean inline) {
		return writer.radio(label, radioDefinition, inline);
	}

	@Override
	public Button button(String text) {
		return writer.button(text);
	}

	@Override
	public InputGroup<?> inputGroup(String control) {
		return writer.inputGroup(control);
	}

	@Override
	public FieldSet fieldset() {
		return writer.fieldset();
	}

	@Override
	public FieldWriter<?> fieldWriter() {
		return writer.fieldWriter();
	}

	@Override
	public FieldSet disabled(boolean disabled) {
		this.disabled = disabled;		
		return this;
	}

	@Override
	public FieldSet disabled() {
		return disabled(true);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<fieldset").append(attributes("disabled"));
		if (disabled) {
			sb.append(" disabled=\"disabled\"");
		}
		sb.append(">");
		sb.append(writer.toString());
		sb.append("</fieldset>");
		return sb.toString();
	}

	@Override
	public FormInputGroup formInputGroup(String label, String controlId, String controlDefintion, String helpText) {
		return writer.formInputGroup(label, controlId, controlDefintion, helpText);
	}

}
