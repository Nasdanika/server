package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.nasdanika.html.Accordion;
import org.nasdanika.html.AjaxNamedContainer;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.Button;
import org.nasdanika.html.ContentNamedContainer;
import org.nasdanika.html.Form;
import org.nasdanika.html.InputGroup;
import org.nasdanika.html.LinkGroup;
import org.nasdanika.html.ListGroup;
import org.nasdanika.html.NamedContainer;
import org.nasdanika.html.Navbar;
import org.nasdanika.html.Table;
import org.nasdanika.html.UIElement;
import org.nasdanika.html.UIElement.Style;

/**
 * HTML builder which relies on Bootstrap styles and scripts.
 * @author Pavel
 *
 */
public class DefaultHTMLBuilder extends AbstractHTMLBuilder {
	
	private static AtomicLong idCounter = new AtomicLong();
	
	@Override
	public String nextId() {
		return "nsd_"+Long.toString(idCounter.incrementAndGet(), Character.MAX_RADIX);
	}
	

	@Override
	public UIElement<UIElement<?>> tag(final String tagName, final String content) {
		return new UIElementImpl<UIElement<?>>() {
			
			@Override
			public String toString() {
				if (content==null) {
					return "<"+tagName+" "+attributes()+"/>";
				}
				return "<"+tagName+attributes()+">"+content+"</"+tagName+">";
			}
		};
	}
	
	private RouterApplicationRenderer routerApplicationRenderer = new RouterApplicationRenderer();

	@Override
	public String routerApplication(
			final String title, 
			final String initialRoute,
			final String head, 
			final String body) {
		return routerApplicationRenderer.generate(new RouterApplicationConfig() {
						
			@Override
			public String getTitle() {
				return title;
			}
			
			@Override
			public String getInitialRoute() {
				return initialRoute;
			}
			
			@Override
			public String getHead() {
				return head == null ? "" : head;
			}
			
			@Override
			public String getBody() {
				return body==null ? "" : body;
			}
			
			@Override
			public List<String> getScripts() {
				return scripts;
			}
			
			@Override
			public List<String> getStylesheets() {
				return stylesheets;
			}
			
		});
	}

	@Override
	public Navbar navbar(final String brand) {
		return new NavbarImpl(this, brand);
	}

	@Override
	public ApplicationPanel applicationPanel() {
		return new ApplicationPanelImpl();
	}
	

	@Override
	public Table table() {
		return new TableImpl();
	}

	@Override
	public ContentNamedContainer createContentNamedContainer(final String name, final String hint, final String content) {
		return new ContentNamedContainer() {
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public String getHint() {
				return hint;
			}
			
			@Override
			public String getContent() {
				return content;
			}
		};
	}

	@Override
	public AjaxNamedContainer createAjaxNamedContainer(final String name, final String hint, final String location) {
		return new AjaxNamedContainer() {
			
			@Override
			public String getName() {
				return name;
			}
			
			@Override
			public String getHint() {
				return hint;
			}
			
			@Override
			public String getLocation() {
				return location;
			}
		};
	}
	
	private TabAjaxDataToggleScriptRenderer tabAjaxDataToggleScriptRenderer = new TabAjaxDataToggleScriptRenderer();
	
	private List<String> scripts = new ArrayList<>();
	private List<String> stylesheets = new ArrayList<>();
	
	public List<String> getScripts() {
		return scripts;
	}
	
	public List<String> getStylesheets() {
		return stylesheets;
	}
	
	@Override
	public String tabs(Iterable<NamedContainer> tabs) {
		String tabId = "tab_"+Long.toString(idCounter.incrementAndGet(), Character.MAX_RADIX);
		
		boolean hasAjaxTabs = false;
		StringBuilder ret = new StringBuilder();
		ret.append("<ul class=\"nav nav-tabs\">");
		int idx = 0;
		for (NamedContainer tab: tabs) {
			if (idx==0) {
				ret.append("<li class=\"active\">");
			} else {
				ret.append("<li>");
			}
			
			ret.append("<a ");
			if (tab.getHint()!=null) {
				ret.append("title=\""+tab.getHint()+"\" ");
			}
			if (tab instanceof ContentNamedContainer) {
				ret.append("href=\"#" + tabId + "_" + idx + "\" data-toggle=\"tab\">");
			} else if (tab instanceof AjaxNamedContainer) {
				ret.append("href=\""+((AjaxNamedContainer) tab).getLocation()+"\" data-target=\"#" + tabId + "_" + idx + "\" data-toggle=\"tabajax\">");	
				hasAjaxTabs = true;
			} else {
				throw new IllegalArgumentException("Unexpected tab type: "+tab);
			}
			
			ret.append(tab.getName()+"</a></li>");
			
			++idx;
		}
		ret.append("</ul>");
		ret.append("<div class=\"tab-content\">");
		
		idx = 0;
		for (NamedContainer tab: tabs) {
			ret.append("<div class=\"tab-pane");
			
			if (idx==0) {
				ret.append(" active");
			}
			
			ret.append("\" id=\"");
			ret.append(tabId + "_" + idx);
			ret.append("\">");
			if (tab instanceof ContentNamedContainer) {
				ret.append(((ContentNamedContainer) tab).getContent());
			} else if (tab instanceof AjaxNamedContainer) {
				// NOP - should be loaded asynchronously.
			} else {
				throw new IllegalArgumentException("Unexpected tab type: "+tab);
			}
			ret.append("</div>");
			++idx;
		}
		ret.append("</div>");
		
		if (hasAjaxTabs) {
			ret.append(tabAjaxDataToggleScriptRenderer.generate(null));
		}
		
		return ret.toString();
	}

	@Override
	public String panel(Style style, String header, String body, String footer) {
		StringBuilder ret = new StringBuilder();
		ret.append("<div class=\"panel panel-"+style.name().toLowerCase()+"\">");
		if (header!=null) {
			ret.append("<div class=\"panel-heading\">");
			ret.append("<h3 class=\"panel-title\">"+header+"</h3>");
			ret.append("</div>");
		}
		
		if (body!=null) {
			ret.append("<div class=\"panel-body\">");
			ret.append(body);
			ret.append("</div>");
		}
								
		if (footer!=null) {
			ret.append("<div class=\"panel-footer\">"+footer+"</div>");
		}
		
		ret.append("</div>");				
		return ret.toString();
	}

	@Override
	public Button button(String text) {
		return new ButtonImpl(text, false);
	}

	@Override
	public String label(String content, Style style) {
		return "<span class=\"label label-"+style.name().toLowerCase()+"\">"+content+"</span>";
	}
	
	@Override
	public String alert(String content, Style style, boolean dismissable) {
		if (dismissable) {
			return "<div class=\"alert alert-"+style.name().toLowerCase()+" alert-dismissable\">" + 
					"<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" + 
					content + 
					"</div>";
		}
		return "<div class=\"alert alert-"+style.name().toLowerCase()+"\">"+content+"</div>";
	}
	
	@Override
	public ListGroup listGroup() {
		return new ListGroupImpl(this);
	}
		
	@Override
	public LinkGroup linkGroup() {
		return new LinkGroupImpl(this);
	}
	
	@Override
	public InputGroup<?> inputGroup(String control) {
		return new InputGroupImpl(control);
	}
	
	@Override
	public Accordion accordion() {
		return new AccordionImpl(this);
	}

	@Override
	public Form form() {
		return new FormImpl(this);
	}
	
	@Override
	public <T extends UIElement<?>> T popover(T element, Placement placement, String title, String text) {
		element
			.attribute("data-toggle", "popover")
			.attribute("data-content", text)
			.attribute("data-container", "body")
			.attribute("data-placement", placement.name().toLowerCase());
		if (title!=null) {
			element.attribute("data-original-title", title);
		}
		
		return element;
	}

	@Override
	public UIElement<?> input(InputType type, String name, String value, String id, String placeholder) {
		return tag("input", null)
				.attribute("type", type.code())
				.attribute("name", name)
				.attribute("value", value)
				.id(id)
				.attribute("placeholder", placeholder);
		
	}
}
