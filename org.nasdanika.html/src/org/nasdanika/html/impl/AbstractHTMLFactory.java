package org.nasdanika.html.impl;

import java.util.Arrays;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.NamedContainer;

/**
 * This builder contains method implementations which are not dependent
 * on the underlying web framework.
 * @author Pavel
 *
 */
public abstract class AbstractHTMLFactory implements HTMLFactory {

	@Override
	public String ul(Iterable<String> items) {
		StringBuilder ret = new StringBuilder("<ul>");
		for (String item: items) {
			ret.append("<li>");
			ret.append(item);
			ret.append("</li>");
		}
		ret.append("</ul>");
		return ret.toString();
	}

	@Override
	public String ul(String... items) {
		return ul(Arrays.asList(items));
	}

	@Override
	public String ol(Iterable<String> items) {
		StringBuilder ret = new StringBuilder("<ol>");
		for (String item: items) {
			ret.append("<li>");
			ret.append(item);
			ret.append("</li>");
		}
		ret.append("</ol>");
		return ret.toString();
	}

	@Override
	public String ol(String... items) {
		return ol(Arrays.asList(items));
	}

	@Override
	public String link(String url, String text, String hint, String target) {
		StringBuilder ret = new StringBuilder("<a href='");
		ret.append(url);
		ret.append("'");
		if (hint!=null) {
			ret.append(" title='");
			ret.append(hint);
			ret.append("'");
		}
		if (target!=null) {
			ret.append(" target='");
			ret.append(target);
			ret.append("'");
		}
		ret.append(text);
		ret.append("</a>");
		return ret.toString();
	}
	
	@Override
	public String routeLink(
			String targetElement, 
			String path, 
			String text,
			String hint) {
		
		// Currently #router is hardcoded.
		StringBuilder ret = new StringBuilder("<a href='#router/");
		ret.append(targetElement==null ? "main" : targetElement);
		ret.append("/");
		ret.append(path);
		ret.append("'");
		if (hint!=null) {
			ret.append(" title='");
			ret.append(hint);
			ret.append("'");
		}
		ret.append(">");
		ret.append(text);
		ret.append("</a>");
		return ret.toString();
	}
	
	@Override
	public String tabs(NamedContainer... tabs) {
		return tabs(Arrays.asList(tabs));
	}
	
}
