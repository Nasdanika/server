package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.LinkGroup;
import org.nasdanika.html.UIElement;

class LinkGroupImpl extends UIElementImpl<LinkGroup> implements LinkGroup {
	
	private HTMLFactory builder;
	private List<String> items = new ArrayList<>();

	LinkGroupImpl(HTMLFactory builder) {
		this.builder = builder;
		addClass("list-group");
	}

	@Override
	public LinkGroup item(String content, String href, Style style, boolean active) {
		UIElement<?> a = builder.tag("a", content).addClass("list-group-item").attribute("href", href);
		if (style!=null && Style.DEFAULT!=style) {
			a.addClass("list-group-item-"+style.name().toLowerCase());
		}
		if (active) {
			a.addClass("active");
		}
		items.add(a.toString());
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder("<div");
		ret.append(attributes());
		ret.append(">");
		for (String item: items) {
			ret.append(item);
		}
		ret.append("</div>");
		return ret.toString();
	}

}
