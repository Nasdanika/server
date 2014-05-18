package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;

class TabsImpl extends UIElementImpl<Tabs> implements Tabs {

	private String tabId;

	TabsImpl(HTMLFactory factory) {
		super(factory);
		tabId = factory.nextId()+"_tab";
	}
	
	private abstract class Tab implements AutoCloseable {
		int idx;
		Object name;
		Object hint;
		
		@Override
		public void close() throws Exception {
			TabsImpl.this.close(name);			
			TabsImpl.this.close(hint);			
		}

		Tab(Object name, Object hint, int idx) {
			super();
			this.name = name;
			this.hint = hint;
			this.idx = idx;
		}	
		
		Object li() {
			Tag ret = factory.tag("li");
			if (idx==0) {
				ret.addClass("active");
			}
			ret.content(link());			
			return ret;
		}
		
		Tag div() {
			Tag ret = factory.div(tabContent()).addClass("tab-pane").id(tabId+"_"+idx);
			if (idx==0) {
				ret.addClass("active");
			}
			return ret;
		}
		
		protected abstract Tag link();
		
		protected abstract Object[] tabContent();
		
	}
	
	private class ContentTab extends Tab {
		
		ContentTab(Object name, Object hint, int idx, Object[] content) {
			super(name, hint, idx);
			this.content = content;
		}

		Object[] content;
		
		@Override
		public void close() throws Exception {
			super.close();
			for (Object c: content) {
				TabsImpl.this.close(c);
			}
		}

		@Override
		protected Tag link() {
			Tag link = factory.link("#"+tabId+"_"+idx, name).attribute("data-toggle", "tab");
			if (hint!=null) {
				link.attribute("title", hint.toString());
			}
			return link;
		}
		
		@Override
		protected Object[] tabContent() {
			return content;
		}
	}
	
	private class AjaxTab extends Tab {
		
		AjaxTab(Object name, Object hint, int idx, Object location) {
			super(name, hint, idx);
			this.location = location;
		}

		Object location;
		
		@Override
		public void close() throws Exception {
			super.close();
			TabsImpl.this.close(location);
		}

		@Override
		protected Tag link() {
			Tag link = factory.link(location.toString(), name).attribute("data-target", "#"+tabId+"_"+idx).attribute("data-toggle", "tabajax");
			if (hint!=null) {
				link.attribute("title", hint.toString());
			}
			return link;
		}
		
		@Override
		protected Object[] tabContent() {
			return new Object[] {""};
		}
		
		@Override
		Tag div() {
			Tag ret = super.div();
			if (idx==0) {
				ret.remoteContent(location.toString()); // Loading active tab
			}
			return ret;
		}
	}
	
	private List<Tab> tabs = new ArrayList<>();

	@Override
	public void close() throws Exception {
		super.close();
		for (Tab tab: tabs) {
			tab.close();
		}		
	}

	@Override
	public Tabs tab(Object name, Object hint, Object... content) {
		tabs.add(new ContentTab(name, hint, tabs.size(), content));
		return this;
	}

	@Override
	public Tabs ajaxTab(Object name, Object hint, Object location) {
		tabs.add(new AjaxTab(name, hint, tabs.size(), location));
		return this;
	}
	
	private TabAjaxDataToggleScriptRenderer tabAjaxDataToggleScriptRenderer = new TabAjaxDataToggleScriptRenderer();
	
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		
		Tag ret = factory.div();
		Tag navUL = factory.tag("ul").addClass("nav").addClass("nav-tabs");
		ret.content(navUL);
		boolean hasAjaxTabs = false;
		for (Tab tab: tabs) {
			navUL.content(tab.li());
			hasAjaxTabs = hasAjaxTabs || tab instanceof AjaxTab;
		}
		Tag contentDiv = factory.div().addClass("tab-content");
		ret.content(contentDiv);
		for (Tab tab: tabs) {
			contentDiv.content(tab.div());
		}
		if (hasAjaxTabs) {
			ret.content(tabAjaxDataToggleScriptRenderer.generate(null));
		}		
		return ret.toString()+genLoadRemoteContentScript();
	};

	@Override
	public boolean isEmpty() {
		return tabs.isEmpty();
	}

}

