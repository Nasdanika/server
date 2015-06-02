package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Fragment;

class FragmentImpl implements Fragment {
	
	private List<Object> content = new ArrayList<>(); 
	
	FragmentImpl(Object... content) {
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Object c: content) {
			try {
				sb.append(TagImpl.renderContent(c));
			} catch (Exception e) {
				sb.append(e.toString());
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
