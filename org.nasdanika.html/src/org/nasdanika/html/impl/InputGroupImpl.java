package org.nasdanika.html.impl;

import org.nasdanika.html.Button;
import org.nasdanika.html.InputGroup;

class InputGroupImpl extends UIElementImpl<InputGroup<?>> implements InputGroup<InputGroup<?>> {

	private Button leftButton;
	private String leftAddOn;
	private Button rightButton;
	private String rightAddOn;
	private String control;

	InputGroupImpl(String control) {
		this.control = control;
		addClass("input-group");
	}
	
	@Override
	public InputGroup<?> size(Size size) {
		addClass("input-group-"+size.code);
		return this;
	}

	@Override
	public InputGroup<?> leftAddOn(String addOn) {
		if (leftButton!=null) {
			throw new IllegalStateException("Left button has already been created");
		}
		this.leftAddOn = addOn;
		return this;
	}

	@Override
	public Button leftButton(String text) {
		if (leftAddOn!=null) {
			throw new IllegalStateException("Left add-on has already been set");
		}
		this.leftButton = new ButtonImpl(text, true);
		return leftButton;
	}

	@Override
	public InputGroup<?> rightAddOn(String addOn) {
		if (rightButton!=null) {
			throw new IllegalStateException("Right button has already been created");
		}
		this.rightAddOn = addOn;
		return this;
	}

	@Override
	public Button rightButton(String text) {
		if (rightAddOn!=null) {
			throw new IllegalStateException("Right add-on has already been set");
		}
		this.rightButton = new ButtonImpl(text, true);
		return rightButton;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<div");
		sb.append(attributes());
		sb.append(">");
		if (leftAddOn!=null) {
			sb.append("<span class=\"input-group-addon\">"+leftAddOn+"</span>");
		} else if (leftButton!=null) {
			sb.append(leftButton.toString());
		}
		
		sb.append(control);
		
		if (rightAddOn!=null) {
			sb.append("<span class=\"input-group-addon\">"+rightAddOn+"</span>");
		} else if (rightButton!=null) {
			sb.append(rightButton.toString());
		}		
		sb.append("</div>");
		return sb.toString();
	}

}
