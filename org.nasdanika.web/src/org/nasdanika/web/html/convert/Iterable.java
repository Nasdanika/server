package org.nasdanika.web.html.convert;

import java.util.ArrayList;

import org.nasdanika.core.Converter;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class Iterable implements Converter<java.lang.Iterable<?>, HTMLRenderer, WebContext> {


	@Override
	public void close() throws Exception {
		// NOP
	}

	@Override
	public HTMLRenderer convert(
			final java.lang.Iterable<?> source,	
			Class<HTMLRenderer> target, 
			WebContext context) throws Exception {
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, java.util.Map<String, Object> environment) throws Exception {
				java.util.Collection<String> items = new ArrayList<>();
				for (Object e: source) {
					items.add(context.toHTML(e, profile, environment));
				}
				return context.getHTMLFactory().ol(items).toString();
			}
		};
	}

}
