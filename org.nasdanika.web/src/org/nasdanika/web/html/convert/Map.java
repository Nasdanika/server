package org.nasdanika.web.html.convert;

import java.util.Map.Entry;

import org.nasdanika.core.Converter;
import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.RowContainer.Row;
import org.nasdanika.html.Table;
import org.nasdanika.web.HttpServletRequestContext;
import org.nasdanika.web.html.HTMLRenderer;

public class Map implements Converter<java.util.Map<?,?>, HTMLRenderer, HttpServletRequestContext> {

	@Override
	public void close() throws Exception {
		// NOP		
	}

	@Override
	public HTMLRenderer convert(final java.util.Map<?, ?> source,	Class<HTMLRenderer> target, HttpServletRequestContext context) throws Exception {
		return new HTMLRenderer() {
			
			@Override
			public String render(HttpServletRequestContext context, String profile, java.util.Map<String, Object> environment) throws Exception {
				Table table = context.adapt(HTMLFactory.class).table().bordered();
				Row header = table.row().style(Bootstrap.Style.INFO);
				header.header("Key");
				header.header("Value");
				for (Entry<?, ?> e: source.entrySet()) {
					Row row = table.row();
					row.cell(context.toHTML(e.getKey(), profile, environment));
					row.cell(context.toHTML(e.getValue(), profile, environment));					
				}
				return table.toString();
			}
		};
	}

}
