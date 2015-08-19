package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Well;

class WellImpl extends UIElementImpl<Well> implements Well {
	
	WellImpl(HTMLFactory factory, Object[] content) {
		super(factory);
		for (Object c: content) {
			this.content.add(c);
		}
		addClass("well");
	}
	
	@Override
	public Well content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}
	
	@Override
	public Well small() {
		addClass("well-sm");
		return this;
	}
	
	@Override
	public Well large() {
		addClass("well-lg");
		return this;
	}
	
	private List<Object> content = new ArrayList<>();
	
	protected List<Object> getContent() {
		return content;
	}
	
	@Override
	public String toString() {		
		List<Object> theContent = getContent();
		if (theContent.isEmpty()) {
			return renderComment()+"<div"+attributes()+"/>";
		}
		StringBuilder sb = new StringBuilder(renderComment()).append("<div").append(attributes()).append(">");
		for (Object c: theContent) {
			try {
				sb.append(TagImpl.renderContent(c));
			} catch (Exception e) {
				sb.append(e.toString());
			}
		}
		return sb.append("</div>").append(genLoadRemoteContentScript()).toString();
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
