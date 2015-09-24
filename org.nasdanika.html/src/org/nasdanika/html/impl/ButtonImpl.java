package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Button;
import org.nasdanika.html.HTMLFactory;

class ButtonImpl extends UIElementImpl<Button> implements Button {
	
	private List<Object> content = new ArrayList<>();
	private boolean isInputGroupButton;
	private Object forEachExpresion;

	ButtonImpl(HTMLFactory factory, boolean isInputGroupButton, Object... content) {
		super(factory);
		content(content);
		this.isInputGroupButton = isInputGroupButton;
	}
	
	private class DropdownItem implements AutoCloseable {
		
		Object content;

		DropdownItem(Object content) {
			this.content = content;
		}

		@Override
		public void close() throws Exception {
			if (content instanceof AutoCloseable) {
				((AutoCloseable) content).close();
			}			
		}
		
	}
	
	private class Divider extends DropdownItem {
		
		Divider() {
			super(null);
		}
		
	}

	private class Header extends DropdownItem {
		
		public Header(Object header) {
			super(header);
		}
		
	}

	private class Item extends DropdownItem {
		
		public Item(Object content) {
			super(content);
		}
		
	}
	
	private List<DropdownItem> items = new ArrayList<>();
	private Style style = Style.DEFAULT;
	private Size size = Size.DEFAULT;
	private boolean block;
	private boolean active;
	private boolean disabled;
	private boolean split;
	private boolean dropup;
	private Type type = Type.BUTTON;
	
	@Override
	public Button item(Object... item) {
		for (Object o: item) {
			items.add(new Item(o));
		}
		return this;
	}

	@Override
	public Button divider() {
		items.add(new Divider());
		return this;
	}

	@Override
	public Button header(Object header) {
		items.add(new Header(header));
		return this;
	}

	@Override
	public Button style(Style style) {
		this.style = style;
		return this;
	}

	@Override
	public Button size(Size size) {
		this.size = size;
		return this;
	}

	@Override
	public Button block(boolean block) {
		this.block = block;
		return this;
	}

	@Override
	public Button block() {		
		return block(true);
	}

	@Override
	public Button active(boolean active) {
		this.active = active;
		return this;
	}

	@Override
	public Button active() {
		return active(true);
	}

	@Override
	public Button disabled(boolean disabled) {
		this.disabled = disabled;
		return this;
	}

	@Override
	public Button disabled() {
		return disabled(true);
	}

	@Override
	public Button split(boolean split) {
		this.split = split;
		return this;
	}

	@Override
	public Button split() {		
		return split(true);
	}
	
	@Override
	public Button dropup() {
		return dropup(true);
	}
	
	@Override
	public Button dropup(boolean dropup) {
		this.dropup = dropup;
		return this;
	}
	
	@Override
	public Button type(Type type) {
		this.type = type;
		return this;
	}
	
	@Override
	public String toHTML() {
		// Simple button - no items
		if (items.isEmpty()) {
			StringBuilder sb = new StringBuilder(renderComment()).append("<button type=\"");
			sb.append(type.name().toLowerCase());
			sb.append("\" class=\"btn");
			buttonClasses(sb);
			
			String classMerge = merge("class");
			if (classMerge.length()>0) {
				sb.append(" ");
				sb.append(classMerge);
			}
			
			sb.append("\"");
			if (disabled) {
				sb.append(" disabled=\"disabled\"");
			}
			sb.append(attributes("class", "type", "disabled"));
			sb.append(">");
			for (Object c: content) {
				sb.append(toHTML(c));
			}
			sb.append("</button>");
			
			if (isInputGroupButton) {
				return "<span class=\"input-group-btn\">"+sb+"</span>";
			}
			
			return sb.append(genLoadRemoteContentScript()).toString();
		}				
						
		// Dropdown button 
		StringBuilder sb = new StringBuilder("<div class=\"");
		if (isInputGroupButton) {
			sb.append("input-group-btn");
		} else {
			sb.append("btn-group");
		}
		if (dropup) {
			sb.append(" dropup");
		}
		sb.append("\">");
		sb.append("<button type=\"");
		sb.append(type.name().toLowerCase());
		sb.append("\" class=\"btn");
		buttonClasses(sb);
		if (!split) {
			sb.append(" dropdown-toggle");
		}
		
		String classMerge = merge("class");
		if (classMerge.length()>0) {
			sb.append(" ");
			sb.append(classMerge);
		}
		
		sb.append("\"");
		if (disabled) {
			sb.append(" disabled=\"disabled\"");
		}
		
		if (!split) {
			sb.append("data-toggle=\"dropdown\"");
		}
		
		sb.append(attributes("class", "type", "disabled", "data-toggle"));
		sb.append(">");
		for (Object c: content) {
			sb.append(toHTML(c));
		}
		if (!split) {
			sb.append(" <span class=\"caret\"></span>");
		}
		sb.append("</button>");
		
		if (split) {
			sb.append("<button type=\"button\" class=\"btn");
			buttonClasses(sb);
			sb.append(" dropdown-toggle\" data-toggle=\"dropdown\">");
			
			sb.append("<span class=\"caret\"></span>");
			sb.append("<span class=\"sr-only\">Toggle Dropdown</span>");
			sb.append("</button>");
		}
		
		sb.append("<ul class=\"dropdown-menu\" role=\"menu\"");
		if (forEachExpresion!=null && forEachExpresion.toString().trim().length()>0) {
			sb.append(" data-bind=\"foreach: "+forEachExpresion+"\"");
		}
		sb.append(">");
		for (DropdownItem item: items) {
			if (item instanceof Item) {
				sb.append("<li>");
				sb.append(toHTML(((Item) item).content));
				sb.append("</li>");
			} else if (item instanceof Divider) {
				sb.append("<li class=\"divider\"></li>");
			} else {
				sb.append("<li class=\"dropdown-header\">");
				sb.append(toHTML(((Header) item).content));
				sb.append("</li>");
			}
		}
		sb.append("</ul>");
		sb.append("</div>");		
		
		return sb.toString();
	}

	private void buttonClasses(StringBuilder sb) {
		sb.append(" btn-"+style.name().toLowerCase());
		if (size!=Size.DEFAULT) {
			sb.append(" btn-"+size.code);
		}
		if (block) {
			sb.append(" btn-block");
		}
		
		if (active) {
			sb.append(" active");
		}
	}
	
	@Override
	public void close() throws Exception {
		super.close();
		close(content);
		close(items);
		close(forEachExpresion);
	}
	
	@Override
	public Button content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}

	@Override
	public boolean isDropdownEmpty() {
		return items.isEmpty();
	}

	@Override
	public Button koItemForEach(Object forEachExpression) {
		this.forEachExpresion = forEachExpression;
		return this;
	}
}
