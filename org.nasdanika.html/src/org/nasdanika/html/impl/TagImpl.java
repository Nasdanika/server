package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;

class TagImpl extends UIElementImpl<Tag> implements Tag {
	
	private List<Object> content = new ArrayList<>();
	
	protected List<Object> getContent() {
		return content;
	}
	
	private String tagName;

	TagImpl(HTMLFactory factory, String tagName, Object... content) {
		super(factory);
		this.tagName = tagName;
		for (Object c: content) {
			this.content.add(c);
		}
	}
	
	@Override
	public Tag content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}
	
	@Override
	public String toString() {		
		List<Object> theContent = getContent();
		if (theContent.isEmpty()) {
			return "<"+tagName+attributes()+"/>";
		}
		StringBuilder sb = new StringBuilder("<").append(tagName).append(attributes()).append(">");
		for (Object c: theContent) {
			sb.append(c);
		}
		return sb.append("</").append(tagName).append(">").toString();
	}

	@Override
	public void close() throws Exception {
		for (Object c: getContent()) {
			if (c instanceof AutoCloseable) {
				((AutoCloseable) c).close();
			}
		}
	}

}
