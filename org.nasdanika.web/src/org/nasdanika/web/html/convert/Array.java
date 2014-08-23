package org.nasdanika.web.html.convert;

import java.util.ArrayList;

import org.nasdanika.core.Converter;
import org.nasdanika.html.HTMLFactory;
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
					for (int i=0, l= java.lang.reflect.Array.getLength(source); i<l; ++i) {
						items.add(context.toHTML(java.lang.reflect.Array.get(source,i), profile, environment));
					}
					return context.adapt(HTMLFactory.class).ol(items).toString();
				}
			};
		}
		
		return null;
	}

}
