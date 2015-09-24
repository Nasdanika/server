package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

class BreadcrumbsImpl extends UIElementImpl<Breadcrumbs> implements Breadcrumbs {

	public BreadcrumbsImpl(HTMLFactory factory) {
		super(factory);
		addClass("breadcrumb");
	}
	
	private List<Tag> items = new ArrayList<>();

	@Override
	public void close() throws Exception {
		super.close();
		close(items);
	}

	@Override
	public Breadcrumbs item(Object href, Object... content) {
		if (href==null) {
			items.add(factory.tag(TagName.li, content).addClass("active"));
		} else {
			items.add(factory.tag(TagName.li, factory.link(href, content)));
		}
		return this;
	}
	
	@Override
	public String produce() {
		StringBuilder sb = new StringBuilder(renderComment()).append("<ol").append(attributes()).append(">");
		for (Tag item: items) {
			sb.append(stringify(item));
		}
		return sb.append("</ol>").append(genLoadRemoteContentScript()).toString();
	}

}
