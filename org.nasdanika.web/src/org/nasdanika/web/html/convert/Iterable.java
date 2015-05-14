package org.nasdanika.web.html.convert;

import java.util.ArrayList;

import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.html.HTMLRenderer;

public class Iterable implements Converter<java.lang.Iterable<?>, HTMLRenderer, HttpServletRequestContext> {


	@Override
	public void close() throws Exception {
		// NOP
	}

	@Override
	public HTMLRenderer convert(
			final java.lang.Iterable<?> source,	
			Class<HTMLRenderer> target, 
			HttpServletRequestContext context) throws Exception {
		return new HTMLRenderer() {
			
			@Override
			public String render(HttpServletRequestContext context, String profile, java.util.Map<String, Object> environment) throws Exception {
				java.util.Collection<String> items = new ArrayList<>();
				for (Object e: source) {
					items.add(context.toHTML(e, profile, environment));
				}
				return context.adapt(HTMLFactory.class).ol(items).toString();
			}
		};
	}

}
