package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Button;
import org.nasdanika.html.ButtonGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;

class ButtonGroupImpl extends UIElementImpl<ButtonGroup> implements ButtonGroup {
	
	private List<Button> buttons = new ArrayList<>();
	private boolean vertical;
	private boolean justified;
	private org.nasdanika.html.UIElement.Size size;

	ButtonGroupImpl(HTMLFactory factory, Button... buttons) {
		super(factory);
		add(buttons);
	}

	@Override
	public Button button(Object... content) {
		Button ret = factory.button(content);
		buttons.add(ret);
		return ret;
	}

	@Override
	public ButtonGroup add(Button... buttons) {
		for (Button button: buttons) {
			if (button!=null) {
				this.buttons.add(button);
			}
		}
		return this;
	}

	@Override
	public boolean isEmpty() {
		return buttons.isEmpty();
	}

	@Override
	public ButtonGroup size(org.nasdanika.html.UIElement.Size size) {
		this.size = size;
		return this;
	}

	@Override
	public ButtonGroup vertical() {
		return vertical(true);
	}

	@Override
	public ButtonGroup vertical(boolean vertical) {
		this.vertical = vertical;
		return this;
	}

	@Override
	public ButtonGroup justified() {
		return justified(true);
	}

	@Override
	public ButtonGroup justified(boolean justified) {
		this.justified = justified;
		return this;
	}
	
	@Override
	public String produce() {
		Tag div = factory.div();
		((UIElementImpl<?>) div).merge(this);
		if (vertical) {
			div.addClass("btn-group-vertical");
		} else {
			div.addClass("btn-group");
		}
		if (justified) {
			div.addClass("btn-group-justified");
		}
		if (size!=null && !Size.DEFAULT.equals(size)) {
			div.addClass("btn-group-"+size.code);
		}
		
		for (Button button: buttons) {
			div.content(justified && button.isDropdownEmpty() ? factory.div(button).addClass("btn-group") : button); // Role menu - will it hurt?
		}

		return stringify(div.produce());
	}

}
