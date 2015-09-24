package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.TextArea;

class TextAreaImpl extends InputBaseImpl<TextArea> implements TextArea {
	
	public TextAreaImpl(HTMLFactory factory) {
		super(factory);
	}
	
	private List<Object> content = new ArrayList<>();
	
	protected List<Object> getContent() {
		return content;
	}
	
	@Override
	public TextArea content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}
	
	@Override
	public String toHTML() {		
		List<Object> theContent = getContent();
		StringBuilder sb = new StringBuilder(renderComment()).append("<textarea").append(attributes()).append(">");
		for (Object c: theContent) {
			sb.append(toHTML(c));
		}
		return sb.append("</textarea>").append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public TextArea placeholder(Object placeholder) {
		return attribute("placeholder", placeholder);
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

	@Override
	public TextArea cols(int cols) {
		return attribute("cols", cols);
	}

	@Override
	public TextArea rows(int rows) {
		return attribute("rows", rows);
	}

	@Override
	public TextArea maxLength(int maxLength) {
		return attribute("maxlength", maxLength);
	}

	@Override
	public TextArea readonly() {
		return readonly(true);
	}

	@Override
	public TextArea readonly(boolean readonly) {
		return attribute("readonly", readonly ? Boolean.TRUE : null);
	}

	@Override
	public TextArea wrap() {
		return wrap(true);
	}

	@Override
	public TextArea wrap(boolean wrap) {
		return attribute("wrap", wrap ? Boolean.TRUE : null);
	}
	
	
}
