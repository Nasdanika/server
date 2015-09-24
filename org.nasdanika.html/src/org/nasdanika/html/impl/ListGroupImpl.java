package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.ListGroup;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

class ListGroupImpl extends UIElementImpl<ListGroup> implements ListGroup {
	
	private List<Tag> items = new ArrayList<>();

	ListGroupImpl(HTMLFactory factory) {
		super(factory);
		addClass("list-group");
	}

	@Override
	public ListGroup item(Object content, Style style) {
		Tag li = factory.tag(TagName.li, content).addClass("list-group-item");
		if (style!=null && Style.DEFAULT!=style) {
			li.addClass("list-group-item-"+style.name().toLowerCase());
		}
		items.add(li);
		return this;
	}
	
	@Override
	public String toHTML() {
		StringBuilder ret = new StringBuilder(renderComment()).append("<ul");
		ret.append(attributes());
		ret.append(">");
		for (Tag item: items) {
			ret.append(item.toHTML());
		}
		ret.append("</ul>");
		return ret.append(genLoadRemoteContentScript()).toString();
	}
	
	@Override
	public void close() throws Exception {
		super.close();
		for (Tag item: items) {
			item.close();
		}
	}

	@Override
	public int length() {
		return items.size();
	}

}
