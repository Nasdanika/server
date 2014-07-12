package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Button;
import org.nasdanika.html.ButtonGroup;
import org.nasdanika.html.ButtonToolbar;
import org.nasdanika.html.HTMLFactory;

class ButtonToolbarImpl extends UIElementImpl<ButtonToolbar> implements ButtonToolbar {
	
	private List<ButtonGroup> buttonGroups = new ArrayList<>();
	
	ButtonToolbarImpl(HTMLFactory factory, ButtonGroup... buttonGroups) {
		super(factory);
		addClass("btn-toolbar");
		attribute("role", "toolbar");
		add(buttonGroups);
	}

	@Override
	public ButtonGroup buttonGroup(Button... buttons) {
		ButtonGroup ret = factory.buttonGroup(buttons);
		buttonGroups.add(ret);
		return ret;
	}

	@Override
	public ButtonToolbar add(ButtonGroup... buttonGroups) {
		for (ButtonGroup g: buttonGroups) {
			if (g!=null) {
				this.buttonGroups.add(g);
			}
		}
		return this;
	}

	@Override
	public boolean isEmpty() {
		return buttonGroups.isEmpty();
	}
		
	@Override
	public String toString() {		
		StringBuilder sb = new StringBuilder("<").append("div").append(attributes()).append(">");
		for (ButtonGroup g: buttonGroups) {
			sb.append(g);
		}
		return sb.append("</").append("div").append(">").append(genLoadRemoteContentScript()).toString();
	}
	

}
