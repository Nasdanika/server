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
	public String produce() {		
		List<Object> theContent = getContent();
		if (theContent.isEmpty()) {
			return renderComment()+"<"+tagName+attributes()+"/>";
		}
		StringBuilder sb = new StringBuilder(renderComment()).append("<").append(tagName).append(attributes()).append(">");
		for (Object c: theContent) {
			sb.append(stringify(c));
		}
		return sb.append("</").append(tagName).append(">").append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public void close() throws Exception {
		super.close();
		for (Object c: getContent()) {
			if (c instanceof AutoCloseable) {
				((AutoCloseable) c).close();
			}
		}
	}

}
