package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.ListGroup;
import org.nasdanika.html.UIElement;

class ListGroupImpl extends UIElementImpl<ListGroup> implements ListGroup {
	
	private HTMLFactory builder;
	private List<String> items = new ArrayList<>();

	ListGroupImpl(HTMLFactory builder) {
		this.builder = builder;
		addClass("list-group");
	}

	@Override
	public ListGroup item(String content, Style style) {
		UIElement<?> li = builder.tag("li", content).addClass("list-group-item");
		if (style!=null && Style.DEFAULT!=style) {
			li.addClass("list-group-item-"+style.name().toLowerCase());
		}
		items.add(li.toString());
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder("<ul");
		ret.append(attributes());
		ret.append(">");
		for (String item: items) {
			ret.append(item);
		}
		ret.append("</ul>");
		return ret.toString();
	}

}
