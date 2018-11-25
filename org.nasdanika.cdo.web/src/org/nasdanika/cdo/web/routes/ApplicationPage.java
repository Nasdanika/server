package org.nasdanika.cdo.web.routes;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag;
import org.nasdanika.html.TagName;

/**
 * Application page with header, navigation bar, left panel, content panel, and footer. 
 * All elements are optional. 
 * @author Pavel Vlasov
 *
 */
public abstract class ApplicationPage {

	private HTMLFactory htmlFactory;
	private Tag html;
	private Tag head;
	private Tag body;

	public ApplicationPage(HTMLFactory htmlFactory) {
		this.htmlFactory = htmlFactory;
		head = htmlFactory.tag(TagName.head);
		body = htmlFactory.tag(TagName.body);
		html = htmlFactory.tag(TagName.html, head, body);
	}
	
	public ApplicationPage() {
		this(HTMLFactory.INSTANCE);
	}
	
	/**
	 * Adds external script to the header.
	 * @param url
	 */
	public void script(Object url) {
		head(htmlFactory.tag(TagName.script).attribute("scr", url));
	}
	
	/**
	 * Adds stylesheet to the header.
	 * @param url
	 */
	public void stylesheet(Object url) {
		head(htmlFactory.tag(TagName.link).attribute("rel", "stylesheet").attribute("scr", url));		
	}
	
	/**
	 * Adds content to html head element of the page.
	 * @param content
	 */
	public void head(Object... content) {
		head.content(content);
	}
	
	/**
	 * Adds page title.
	 * @param title
	 */
	public void title(Object title) {
		head(htmlFactory.tag(TagName.title, title));
	}
	
	@Override
	public String toString() {
		return "<!DOCTYPE html>"+System.lineSeparator()+html;
	}

}
