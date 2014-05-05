package org.nasdanika.web.html.convert;

import java.util.ArrayList;

import org.nasdanika.core.Converter;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class Array implements Converter<Object, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP		
	}

	@Override
	public HTMLRenderer convert(final Object source, Class<HTMLRenderer> target, WebContext context) throws Exception {
		if (source.getClass().isArray()) {
			return new HTMLRenderer() {
				
				@Override
				public String render(WebContext context, String profile, java.util.Map<String, Object> environment) throws Exception {
					java.util.Collection<String> items = new ArrayList<>();
					for (Object e: (Object[]) source) {
						items.add(context.toHTML(e, profile, environment));
					}
					return context.getHTMLFactory().ol(items).toString();
				}
			};
		}
		
		return null;
	}

}
