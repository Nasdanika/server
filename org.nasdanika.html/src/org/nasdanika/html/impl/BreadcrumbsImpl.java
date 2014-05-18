package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;

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
			items.add(factory.tag("li", content).addClass("active"));
		} else {
			items.add(factory.tag("li", factory.link(href, content)));
		}
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<ol").append(attributes()).append(">");
		for (Tag item: items) {
			sb.append(item);
		}
		return sb.append("</ol>").append(genLoadRemoteContentScript()).toString();
	}

}
