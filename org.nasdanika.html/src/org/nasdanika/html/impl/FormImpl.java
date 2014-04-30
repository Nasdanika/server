package org.nasdanika.html.impl;

import org.nasdanika.html.Button;
import org.nasdanika.html.FieldSet;
import org.nasdanika.html.FieldWriter;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.InputGroup;

class FormImpl extends UIElementImpl<Form> implements Form {
	
	HTMLFactory builder;
	boolean horizontal;
	boolean inline;
	DeviceSize deviceSize;
	int labelWidth;
	private FieldWriter<Form> writer;

	FormImpl(HTMLFactory builder) {
		this.builder = builder;
		writer = new FieldWriterImpl<Form>(this, this);
		attribute("role", "form");
	}
	
	@Override
	public Form horizontal(DeviceSize deviceSize, int labelWidth) {
		horizontal = true;
		this.deviceSize = deviceSize;
		this.labelWidth = labelWidth;
		addClass("form-horizontal");
		return this;
	}

	@Override
	public Form inline(boolean inline) {
		this.inline = inline;
		addClass("form-inline");
		return this;
	}

	@Override
	public Form inline() {
		return inline(true);
	}

	@Override
	public Form content(String content) {
		return writer.content(content);
	}

	@Override
	public FormGroup<?> formGroup(String label, String controlId, String controlDefintion, String helpText) {
		return writer.formGroup(label, controlId, controlDefintion, helpText);
	}

	@Override
	public Form checkbox(String label, String checkboxDefinition, boolean inline) {
		return writer.checkbox(label, checkboxDefinition, inline);
	}

	@Override
	public Form radio(String label, String radioDefinition, boolean inline) {
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
	public FormInputGroup formInputGroup(String label, String controlId, String controlDefintion, String helpText) {
		return writer.formInputGroup(label, controlId, controlDefintion, helpText);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("<form")
			.append(attributes())
			.append(">")
			.append(writer.toString())
			.append("</form>")
			.toString();
	}

}
