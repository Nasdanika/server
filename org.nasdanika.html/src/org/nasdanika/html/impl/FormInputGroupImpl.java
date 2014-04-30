package org.nasdanika.html.impl;

import org.nasdanika.html.Button;
import org.nasdanika.html.FormInputGroup;

class FormInputGroupImpl extends FormGroupImpl<FormInputGroup, InputGroupImpl> implements FormInputGroup {
		
	FormInputGroupImpl(FormImpl form, String label, String controlId, String controlDefintion, String helpText) {
		super(form, label, controlId, new InputGroupImpl(controlDefintion), helpText);
	}

	@Override
	public FormInputGroup leftAddOn(String addOn) {
		control.leftAddOn(addOn);
		return this;
	}

	@Override
	public FormInputGroup size(Size size) {
		control.size(size);
		return this;
	}

	@Override
	public Button leftButton(String text) {		
		return control.leftButton(text);
	}

	@Override
	public FormInputGroup rightAddOn(String addOn) {
		control.rightAddOn(addOn);
		return this;
	}

	@Override
	public Button rightButton(String text) {
		return control.rightButton(text);
	}
	
}
