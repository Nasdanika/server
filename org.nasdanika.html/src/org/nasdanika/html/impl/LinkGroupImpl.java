package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.LinkGroup;
import org.nasdanika.html.Tag;

class LinkGroupImpl extends UIElementImpl<LinkGroup> implements LinkGroup {
	
	private List<Tag> items = new ArrayList<>();

	LinkGroupImpl(HTMLFactory factory) {
		super(factory);
		addClass("list-group");
	}

	@Override
	public LinkGroup item(Object content, Object href, Style style, boolean active) {
		Tag a = factory.tag("a", content).addClass("list-group-item").attribute("href", String.valueOf(href));
		if (style!=null && Style.DEFAULT!=style) {
			a.addClass("list-group-item-"+style.name().toLowerCase());
		}
		if (active) {
			a.addClass("active");
		}
		items.add(a);
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder("<div");
		ret.append(attributes());
		ret.append(">");
		for (Tag item: items) {
			ret.append(item);
		}
		ret.append("</div>");
		return ret.toString();
	}

	@Override
	public void close() throws Exception {
		for (Tag item: items) {
			item.close();
		}
	}

}
