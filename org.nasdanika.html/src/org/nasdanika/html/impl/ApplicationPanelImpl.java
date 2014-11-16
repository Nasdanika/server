package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.HTMLFactory;

class ApplicationPanelImpl extends UIElementImpl<ApplicationPanel> implements ApplicationPanel {

	ApplicationPanelImpl(HTMLFactory factory) {
		super(factory);
	}

	private List<Object> navigation = new ArrayList<>();
	private List<Object> header = new ArrayList<>();
	private Object headerLink;

	@Override
	public ApplicationPanel header(Object... header) {
		for (Object h: header) {
			this.header.add(h);
		}
		return this;
	}
	
	@Override
	public ApplicationPanel headerLink(Object url) {
		this.headerLink = url;
		return this;
	}

	@Override
	public ApplicationPanel navigation(Object... navigation) {
		for (Object h: navigation) {
			this.navigation.add(h);
		}
		return this;
	}
	
	private List<ContentPanel> contentPanels = new ArrayList<>();
	private int minHeight;
	private int width;
	private org.nasdanika.html.UIElement.Style style = Style.DEFAULT;
	private List<Object> footer = new ArrayList<>();
	
	private class ContentPanelImpl extends UIElementImpl<ContentPanel> implements ContentPanel {
		
		private Map<DeviceSize, Integer> sizeMap = new HashMap<>();
		private List<Object> content = new ArrayList<>();
		
		ContentPanelImpl(HTMLFactory factory, Object... content) {
			super(factory);
			for (Object c: content) {
				this.content.add(c);
			}
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
					ret.append("col-"+se.getKey().code+"-"+se.getValue()).append(" ");
				}
				ret.append(merge("class")).append("\"").append(attributes("class"));
			}
			
			ret.append(">");			

			for (Object c: content) {
				ret.append(c);
			}
			
			return ret.append("</div>").append(genLoadRemoteContentScript()).toString();
		}

		@Override
		public ContentPanel content(Object... content) {
			for (Object c: content) {
				this.content.add(c);
			}
			return this;
		}

		@Override
		public void close() throws Exception {
			for (Object c: content) {
				if (c instanceof AutoCloseable) {
					((AutoCloseable) c).close();
				}
			}		
		}
		
	}

	@Override
	public ContentPanel contentPanel(Object... content) {
		ContentPanelImpl contentPanel = new ContentPanelImpl(factory, content);
		contentPanels.add(contentPanel);
		return contentPanel;
	}

	@Override
	public ApplicationPanel footer(Object... footer) {
		for (Object f: footer) {
			this.footer.add(f);
		}
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
				StringBuilder sb = new StringBuilder();
				for (Object o: navigation) {
					sb.append(o);
				}
				return sb.toString();
			}
			
			@Override
			public int getMinHeight() {
				return minHeight;
			}
			
			@Override
			public Object getHeaderLink() {
				return headerLink;
			}
			
			@Override
			public String getHeader() {
				StringBuilder sb = new StringBuilder();
				for (Object o: header) {
					sb.append(o);
				}
				return sb.toString();
			}
			
			@Override
			public String getFooter() {
				StringBuilder sb = new StringBuilder();
				for (Object o: footer) {
					sb.append(o);
				}
				return sb.toString();
			}
			
			@Override
			public List<ContentPanel> getContentPanels() {
				return contentPanels;
			}

			@Override
			public String getAttributes() {
				return attributes();
			}
			
		})+genLoadRemoteContentScript();
	}

	@Override
	public void close() throws Exception {
		super.close();
		for (Object o: navigation) {
			if (o instanceof AutoCloseable) {
				((AutoCloseable) o).close();
			}
		}
		for (Object o: header) {
			if (o instanceof AutoCloseable) {
				((AutoCloseable) o).close();
			}
		}
		for (Object o: footer) {
			if (o instanceof AutoCloseable) {
				((AutoCloseable) o).close();
			}
		}
		if (headerLink instanceof AutoCloseable) {
			((AutoCloseable) headerLink).close();
		}
		for (ContentPanel cp: contentPanels) {
			cp.close();
		}		
	}

}
