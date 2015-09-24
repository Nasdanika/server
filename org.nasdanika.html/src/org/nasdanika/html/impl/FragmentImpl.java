package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;

class FragmentImpl implements Fragment {
	
	private List<Object> content = new ArrayList<>();
	private HTMLFactory factory; 
	
	FragmentImpl(HTMLFactory factory, Object... content) {
		this.factory = factory;
		content(content);
	}

	@Override
	public Fragment content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}

	@Override
	public void close() throws Exception {
		for (Object c: content) {
			if (c instanceof AutoCloseable) {
				((AutoCloseable) c).close();
			}
		}
	}
	
	@Override
	public String toHTML() {
		StringBuilder sb = new StringBuilder();
		for (Object c: content) {
			try {
				sb.append(UIElementImpl.toHTML(c, factory instanceof AbstractHTMLFactory ? ((AbstractHTMLFactory) factory).getAdapter() : null));
			} catch (Exception e) {
				sb.append(e);
			}
		}
		return sb.toString();
	}
	
	@Override
	public boolean isEmpty() {
		return content.isEmpty();
	}
	
	@Override
	public List<Object> getContent() {
		return content;
	}

}
