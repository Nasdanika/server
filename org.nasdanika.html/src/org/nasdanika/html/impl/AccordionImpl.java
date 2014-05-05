package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Accordion;
import org.nasdanika.html.HTMLFactory;

class AccordionImpl extends UIElementImpl<Accordion> implements	Accordion {

	private class Item implements AutoCloseable {
		Object title;
		Object body;
		Style style;
		private boolean initial;
		
		Item(Object title, Object body, Style style, boolean initial) {
			super();
			this.title = title;
			this.body = body;
			this.style = style==null ? Style.DEFAULT : style;
			this.initial = initial;
		}
		
		@Override
		public String toString() {
			String id = factory.nextId()+"_collapse";
			StringBuilder ret = new StringBuilder();
			ret.append("<div class=\"panel panel-"+style.name().toLowerCase()+"\">");
				ret.append("<div class=\"panel-heading\">");
					ret.append("<h4 class=\"panel-title\">");
						ret.append("<a data-toggle=\"collapse\" data-parent=\"#"+AccordionImpl.this.getId()+"\" href=\"#"+id+"\">");
							ret.append(title);
						ret.append("</a>");
					ret.append("</h4>");
				ret.append("</div>");
			
				ret.append("<div id=\""+id+"\" class=\"panel-collapse collapse");
				if (initial) {
					ret.append(" in");
				}
				ret.append("\">");
					ret.append("<div class=\"panel-body\">");
						ret.append(body);
					ret.append("</div>");
				ret.append("</div>");												
			ret.append("</div>");				
			return ret.toString();
		}

		@Override
		public void close() throws Exception {
			if (title instanceof AutoCloseable) {
				((AutoCloseable) title).close();
			}
			if (body instanceof AutoCloseable) {
				((AutoCloseable) body).close();
			}			
		}
		
	}
	
	private List<Item> items = new ArrayList<>();

	public AccordionImpl(HTMLFactory factory) {
		super(factory);
		id(factory.nextId()+"_accordion");
		addClass("panel-group");
	}
	
	@Override
	public Accordion item(Object title, Object body, Style style) {
		items.add(new Item(title, body, style, items.isEmpty()));
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<div").append(attributes()).append(">");
		for (Item item: items) {
			sb.append(item.toString());
		}
		sb.append("</div>");
		return sb.toString();
	}

	@Override
	public void close() throws Exception {
		for (Item item: items) {
			item.close();
		}		
	}

}
