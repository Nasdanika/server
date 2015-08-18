package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Accordion;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tag.TagName;

class AccordionImpl extends UIElementImpl<Accordion> implements	Accordion {

	private class Item implements AutoCloseable {
		Object title;
		Object[] content;
		Style style;
		private boolean initial;
		private Object location;
		
		Item(Object title, Object[] content, Object location, Style style, boolean initial) {
			super();
			this.title = title;
			this.content = content;
			this.location = location;
			this.style = style;
			this.initial = initial;
		}
		
		private Style getStyle() {
			if (style!=null) {
				return style;
			}
			
			if (AccordionImpl.this.style!=null) {
				return AccordionImpl.this.style;
			}
			
			return Style.DEFAULT;
		}
		
		@Override
		public String toString() {
			String id = factory.nextId()+"_collapse";
			StringBuilder ret = new StringBuilder();
			ret.append("<div class=\"panel panel-"+getStyle().name().toLowerCase()+"\">");
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
					String bodyId = factory.nextId()+"_panel_body";
					ret.append("<div class=\"panel-body\">");
						if (content!=null) {
							for (Object o: content) {
								if (o!=null) {
									ret.append(o);
								}
							}
						} 
					ret.append("</div>");
					if (location!=null) {
						ret.append(factory.tag(TagName.script, "nsdLoad(\"#"+bodyId+"\", \""+location+"\");"));
					}					
				ret.append("</div>");												
			ret.append("</div>");				
			return ret.toString();
		}

		@Override
		public void close() throws Exception {
			UIElementImpl.close(title);
			UIElementImpl.close(content);
			UIElementImpl.close(location);
		}
		
	}
	
	private List<Item> items = new ArrayList<>();
	private Style style;

	public AccordionImpl(HTMLFactory factory) {
		super(factory);
		id(factory.nextId()+"_accordion");
		addClass("panel-group");
	}
	
	@Override
	public Accordion item(Object title, Style style, Object... content) {
		items.add(new Item(title, content, null, style, items.isEmpty()));
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(renderComment()).append("<div").append(attributes()).append(">");
		for (Item item: items) {
			sb.append(item.toString());
		}
		sb.append("</div>");
		return sb.append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public void close() throws Exception {
		super.close();
		for (Item item: items) {
			item.close();
		}		
	}
	
	@Override
	public Accordion style(org.nasdanika.html.UIElement.Style style) {
		this.style = style;
		return this;
	}

	@Override
	public Accordion item(Object name, Object... content) {
		return item(name, null, content);
	}

	@Override
	public Accordion ajaxItem(Object name, Object location) {
		return ajaxItem(name, null, location);
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public Accordion ajaxItem(Object title,	Style style, Object location) {
		items.add(new Item(title, null, location, style, items.isEmpty()));
		return this;
	}

}
