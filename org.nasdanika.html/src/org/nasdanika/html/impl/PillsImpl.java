package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Pills;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement;

class PillsImpl extends UIElementImpl<Pills> implements Pills {

	private String pillsId;

	PillsImpl(HTMLFactory factory) {
		super(factory);
		pillsId = factory.nextId()+"_pills";
	}
	
	private abstract class Pill implements AutoCloseable {
		int idx;
		Object name;
		
		@Override
		public void close() throws Exception {
			UIElementImpl.close(name);			
		}

		Pill(Object name, int idx) {
			super();
			this.name = name;
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
			Tag ret = factory.div(pillContent()).addClass("tab-pane").id(pillsId+"_"+idx);
			if (idx==0) {
				ret.addClass("active");
			}
			return ret;
		}
		
		protected abstract Tag link();
		
		protected abstract Object[] pillContent();
		
	}
	
	private class ContentPill extends Pill {
		
		ContentPill(Object name, int idx, Object[] content) {
			super(name, idx);
			this.content = content;
		}

		Object[] content;
		
		@Override
		public void close() throws Exception {
			super.close();
			for (Object c: content) {
				UIElementImpl.close(c);
			}
		}

		@Override
		protected Tag link() {
			Tag link = factory.link("#"+pillsId+"_"+idx, name).attribute("data-toggle", "pill");
			return link;
		}
		
		@Override
		protected Object[] pillContent() {
			return content;
		}
	}
	
	private class AjaxPill extends Pill {
		
		AjaxPill(Object name, int idx, Object location) {
			super(name, idx);
			this.location = location;
		}

		Object location;
		
		@Override
		public void close() throws Exception {
			super.close();
			UIElementImpl.close(location);
		}

		@Override
		protected Tag link() {
			Tag link = factory.link(location.toString(), name).attribute("data-target", "#"+pillsId+"_"+idx).attribute("data-toggle", "pillajax");
			return link;
		}
		
		@Override
		protected Object[] pillContent() {
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
	
	private List<Pill> pills = new ArrayList<>();

	@Override
	public void close() throws Exception {
		super.close();
		close(pills);
	}

	@Override
	public Pills item(Object name, Object... content) {
		pills.add(new ContentPill(name, pills.size(), content));
		return this;
	}

	@Override
	public Pills ajaxItem(Object name, Object location) {
		pills.add(new AjaxPill(name, pills.size(), location));
		return this;
	}
	
	private PillAjaxDataToggleScriptRenderer pillAjaxDataToggleScriptRenderer = new PillAjaxDataToggleScriptRenderer();
	private boolean stacked;
	
	@Override
	public Pills stacked() {
		return stacked(true);
	}
	
	@Override
	public Pills stacked(boolean stacked) {
		this.stacked = stacked;
		return this;
	}
			
	private Map<UIElement.DeviceSize, Integer> pillsWidth = new HashMap<>();
	
	@Override
	public Pills pillsWidth(UIElement.DeviceSize deviceSize, int width) {
		pillsWidth.put(deviceSize, width);
		return this;
	}
	
	public String toString() {
		if (isEmpty()) {
			return "";
		}
		
		Tag navUL = factory.tag("ul").addClass("nav").addClass("nav-pills");
		if (stacked) {
			navUL.addClass("nav-stacked");
		}
		
		boolean hasAjaxPills = false;
		for (Pill pill: pills) {
			navUL.content(pill.li());
			hasAjaxPills = hasAjaxPills || pill instanceof AjaxPill;
		}
		Tag contentDiv = factory.div().addClass("tab-content");
		for (Pill pill: pills) {
			contentDiv.content(pill.div());
		}
		
		StringBuilder sb = new StringBuilder(renderComment()).append("<div").append(attributes()).append(">");
		
		if (pillsWidth.isEmpty()) {
			sb.append(navUL);
		} else {
			Tag ulContainer = factory.div(navUL);
			for (Entry<UIElement.DeviceSize, Integer> pwe: pillsWidth.entrySet()) {
				ulContainer.grid().col(pwe.getKey(), pwe.getValue());
				contentDiv.grid().col(pwe.getKey(), 12 - pwe.getValue());
			}
			sb.append(ulContainer);
		}
		sb.append(contentDiv);

		if (hasAjaxPills) {
			sb.append(pillAjaxDataToggleScriptRenderer.generate(null));
		}		
		
		return sb.append("</div>").append(genLoadRemoteContentScript()).toString();
	};

	@Override
	public boolean isEmpty() {
		return pills.isEmpty();
	}

}
