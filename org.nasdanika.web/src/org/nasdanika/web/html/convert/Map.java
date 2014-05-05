package org.nasdanika.web.html.convert;

import java.util.Map.Entry;

import org.nasdanika.core.Converter;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.WebContext;
import org.nasdanika.web.html.HTMLRenderer;

public class Map implements Converter<java.util.Map<?,?>, HTMLRenderer, WebContext> {

	@Override
	public void close() throws Exception {
		// NOP		
	}

	@Override
	public HTMLRenderer convert(final java.util.Map<?, ?> source,	Class<HTMLRenderer> target, WebContext context) throws Exception {
		return new HTMLRenderer() {
			
			@Override
			public String render(WebContext context, String profile, java.util.Map<String, Object> environment) throws Exception {
				Table table = context.getHTMLFactory().table().bordered();
				Row header = table.row().style(Style.INFO);
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
