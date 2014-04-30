package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Dropdown;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Navbar;

class NavbarImpl extends UIElementImpl<Navbar> implements Navbar {
	
	private String brand;
	private HTMLFactory builder;

	NavbarImpl(HTMLFactory builder, String brand) {
		this.builder = builder;
		this.brand = brand;
	}
	
	private List<Object> items = new ArrayList<>();
	
	private class ItemEntry {
		String item;
		boolean active;
		
		ItemEntry(String item, boolean active) {
			super();
			this.item = item;
			this.active = active;
		}		
		
		@Override
		public String toString() {
			if (active) {
				return "<li class=\"active\">"+item+"</li>";
			}
			return "<li>"+item+"</li>";
		}
	}

	@Override
	public Navbar item(String item, boolean active) {
		items.add(new ItemEntry(item, active));
		return this;
	}
	
	private static Object DIVIDER = new Object(); // Marker object.
	
	private class DropdownImpl extends UIElementImpl<DropdownImpl> implements Dropdown<DropdownImpl> {
		
		private String name;
		private List<Object> items = new ArrayList<>();

		public DropdownImpl(String name) {
			this.name = name;
		}
		
		private class Header {
			String header;
			
			Header(String header) {
				this.header = header;
			}
		}

		@Override
		public DropdownImpl item(String item) {
			items.add(item);
			return this;
		}

		@Override
		public DropdownImpl divider() {
			items.add(DIVIDER);
			return this;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("<li class=\"dropdown\">");
			sb.append("<a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">"+name+" <b class=\"caret\"></b></a>");
	        sb.append("<ul class=\"dropdown-menu\">");
	        for (Object item: items) {
	        	if (item==DIVIDER) {
	        		sb.append("<li class=\"divider\"></li>");
	        	} else if (item instanceof Header) {
	        		sb.append(" <li class=\"dropdown-header\">"+((Header) item).header+"</li>");
	        	} else {
	        		sb.append("<li>");
	        		sb.append(item);
	        		sb.append("</li>");
	        	}
	        }
		    sb.append("</ul>");
	        sb.append("</li>");
			return sb.toString();
		}

		@Override
		public DropdownImpl header(String header) {
			items.add(new Header(header));
			return this;
		}
		
	}	
	
	@Override
	public Dropdown<?> dropdown(String name) {
		Dropdown<?> ret = new DropdownImpl(name);
		items.add(ret);
		return ret;
	}
	
	private NavbarRenderer navbarRenderer = new NavbarRenderer();
	
	@Override
	public String toString() {
		
		final String collapseTargetId = builder.nextId()+"_collapse";

		return navbarRenderer.generate(new NavbarConfig() {
			
			@Override
			public String getBrand() {
				return brand;
			}
			
			@Override
			public String getItems() {
				StringBuilder ret = new StringBuilder();
				for (Object item: items) {
					ret.append(item.toString());
				}
				return ret.toString();
			}
			
			@Override
			public String getCollapseTargetId() {
				return collapseTargetId;
			}
			
			@Override
			public String getAttributes() {
				NavbarImpl.this.attributes("class", "role");
				return null;
			}
		});
	}

}
