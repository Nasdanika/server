package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nasdanika.html.ApplicationPanel;

class ApplicationPanelImpl extends UIElementImpl<ApplicationPanel> implements ApplicationPanel {

	private String navigation;
	private String header;
	private String headerLink;

	@Override
	public ApplicationPanel header(String header) {
		this.header = header;
		return this;
	}
	
	@Override
	public ApplicationPanel headerLink(String url) {
		this.headerLink = url;
		return this;
	}

	@Override
	public ApplicationPanel navigation(String navigation) {
		this.navigation = navigation;
		return this;
	}
	
	private List<ContentPanel> contentPanels = new ArrayList<>();
	private int minHeight;
	private int width;
	private org.nasdanika.html.UIElement.Style style = Style.DEFAULT;
	private String footer;
	
	private class ContentPanelImpl extends UIElementImpl<ContentPanel> implements ContentPanel {
		
		private Map<DeviceSize, Integer> sizeMap = new HashMap<>();
		private String content;
		
		ContentPanelImpl(String content) {
			this.content = content;
		}

		@Override
		public ContentPanel width(DeviceSize deviceSize, int width) {
			sizeMap.put(deviceSize, width);
			return this;
		}
		
		@Override
		public String toString() {
			StringBuilder ret = new StringBuilder("<div");
			if (sizeMap.isEmpty()) {
				// plain div
				ret.append(attributes());
			} else {
				ret.append(" class=\"");
				for (Entry<DeviceSize, Integer> se: sizeMap.entrySet()) {
					ret.append("col-"+se.getKey().code+"-"+se.getValue());
					ret.append(" ");
				}
				ret.append(merge("class"));
				ret.append("\"");
				ret.append(attributes("class"));
			}
			
			ret.append(">");			
			
			if (content!=null) {
				ret.append(content);
			}
			ret.append("</div>");
			return ret.toString();
		}
		
	}

	@Override
	public ContentPanel content(final String content) {
		ContentPanelImpl contentPanel = new ContentPanelImpl(content);
		contentPanels.add(contentPanel);
		return contentPanel;
	}

	@Override
	public ApplicationPanel footer(String footer) {
		this.footer = footer;
		return this;
	}

	@Override
	public ApplicationPanel style(org.nasdanika.html.UIElement.Style style) {
		this.style = style;
		return this;
	}

	@Override
	public ApplicationPanel width(int width) {
		this.width = width;
		return this;
	}

	@Override
	public ApplicationPanel minHeight(int minHeight) {
		this.minHeight = minHeight;
		return this;
	}
	
	private ApplicationPanelRenderer applicationPanelRenderer = new ApplicationPanelRenderer();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return applicationPanelRenderer.generate(new ApplicationPanelConfig() {
			
			@Override
			public int getWidth() {
				return width;
			}
			
			@Override
			public String getStyle() {
				return style.name().toLowerCase();
			}
			
			@Override
			public String getNavigation() {
				return navigation == null ? "" : navigation;
			}
			
			@Override
			public int getMinHeight() {
				return minHeight;
			}
			
			@Override
			public String getHeaderLink() {
				return headerLink;
			}
			
			@Override
			public String getHeader() {
				return header;
			}
			
			@Override
			public String getFooter() {
				return footer;
			}
			
			@Override
			public List<String> getContentPanels() {
				List<String> ret = new ArrayList<>();
				for (ContentPanel cp: contentPanels) {
					ret.add(cp.toString());
				}
				return ret;
			}
		});
	}

}
