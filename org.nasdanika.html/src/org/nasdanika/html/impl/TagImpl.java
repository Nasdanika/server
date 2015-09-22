package org.nasdanika.html.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.net.URL;
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
			return renderComment()+"<"+tagName+attributes()+"/>";
		}
		StringBuilder sb = new StringBuilder(renderComment()).append("<").append(tagName).append(attributes()).append(">");
		for (Object c: theContent) {
			try {
				sb.append(renderContent(c));
			} catch (Exception e) {
				sb.append(e.toString());
			}
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
	
	/**
	 * Special handling for input streams, readers, and URL's.
	 * @param content
	 * @return
	 */
	static Object renderContent(Object content) throws Exception {
		if (content instanceof InputStream) {
			return renderContent(new InputStreamReader((InputStream) content));
		}
		if (content instanceof Reader) {
			StringWriter sw = new StringWriter();
			for (int ch = ((Reader) content).read(); ch!=-1; ch = ((Reader) content).read()) {
				sw.write(ch);
			}
			((Reader) content).close();
			sw.close();
			return sw.toString();
		}
		
		if (content instanceof URL) {
			return renderContent(((URL) content).openStream());
		}

		return content==null ? "" : content; // Treat nulls as blanks.
	}

}
