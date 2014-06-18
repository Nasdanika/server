package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Dropdown;
import org.nasdanika.html.Form;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Navbar;
import org.nasdanika.html.Tag;

class NavbarImpl extends UIElementImpl<Navbar> implements Navbar {
	
	private Object brand;

	NavbarImpl(HTMLFactory factory, Object brand) {
		super(factory);
		this.brand = brand;
	}
	
	private List<Object> leftItems = new ArrayList<>();
	private List<Object> rightItems = new ArrayList<>();
	
	private class ItemEntry {
		Object item;
		boolean active;
		
		ItemEntry(Object item, boolean active) {
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
	public Navbar item(Object item, boolean active, boolean right) {
		(right ? rightItems : leftItems).add(new ItemEntry(item, active));
		return this;
	}
	
	private static Object DIVIDER = new Object(); // Marker object.
	
	private class DropdownImpl extends UIElementImpl<DropdownImpl> implements Dropdown<DropdownImpl> {
		
		private Object name;
		private List<Object> items = new ArrayList<>();

		DropdownImpl(Object name) {
			super(NavbarImpl.this.factory);
			this.name = name;
		}
		
		private class Header implements AutoCloseable {
			Object header;
			
			Header(Object header) {
				this.header = header;
			}
			
			@Override
			public void close() throws Exception {
				NavbarImpl.this.close(header);				
			}
		}

		@Override
		public DropdownImpl item(Object... item) {
			items.add(factory.fragment(item));
			return this;
		}

		@Override
		public DropdownImpl divider() {
			items.add(DIVIDER);
			return this;
		}
		
		@Override
		public String toString() {
			Tag li = factory.tag("li").addClass("dropdown");
			li.content(factory.link("#", name, " ", factory.tag("b", "").addClass("caret")).addClass("dropdown-toggle").attribute("data-toggle", "dropdown"));
			Tag ul = factory.tag("ul").addClass("dropdown-menu");
			li.content(ul);
	        for (Object item: items) {
	        	if (item==DIVIDER) {
	        		ul.content(factory.tag("li", "").addClass("divider"));
	        	} else if (item instanceof Header) {
	        		ul.content(factory.tag("li", ((Header) item).header).addClass("dropdown-header"));
	        	} else {
	        		ul.content(factory.tag("li", item));
	        	}
	        }
			return li.toString()+genLoadRemoteContentScript();
		}

		@Override
		public DropdownImpl header(Object header) {
			items.add(new Header(header));
			return this;
		}
		
		@Override
		public void close() throws Exception {
			close(name);
			for (Object item: items) {
				close(item);
			}
		}

		@Override
		public boolean isDropdownEmpty() {
			return items.isEmpty();
		}
		
	}	
	
	@Override
	public Dropdown<?> dropdown(Object name, boolean right) {
		Dropdown<?> ret = new DropdownImpl(name);
		(right ? rightItems : leftItems).add(ret);
		return ret;
	}
	
	private NavbarRenderer navbarRenderer = new NavbarRenderer();
	private FormImpl form;
	
	@Override
	public String toString() {
		
		final String collapseTargetId = factory.nextId()+"_collapse";

		return navbarRenderer.generate(new NavbarConfig() {
			
			@Override
			public Object getBrand() {
				return brand;
			}
			
			@Override
			public String getLeftItems() {
				if (leftItems.isEmpty()) {
					return null;					
				}
				StringBuilder ret = new StringBuilder();
				for (Object item: leftItems) {
					ret.append(item.toString());
				}
				return ret.toString();
			}
			
			@Override
			public String getRightItems() {
				if (rightItems.isEmpty()) {
					return null;					
				}
				StringBuilder ret = new StringBuilder();
				for (Object item: rightItems) {
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
				return NavbarImpl.this.attributes("class", "role");
			}

			@Override
			public String getForm() {
				return form==null ? "" : form.toString();
			}
		})+genLoadRemoteContentScript();
	}

	@Override
	public void close() throws Exception {
		super.close();
		for (Object item: leftItems) {
			close(item);
		}
		for (Object item: rightItems) {
			close(item);
		}
		close(form);
	}

	@Override
	public Form form(boolean right) {
		form = new FormImpl(factory, right, false);
		return form;
	}

}
