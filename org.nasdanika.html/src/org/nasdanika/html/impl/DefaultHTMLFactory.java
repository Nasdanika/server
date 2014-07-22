package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.html.Accordion;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
import org.nasdanika.html.ButtonGroup;
import org.nasdanika.html.ButtonToolbar;
import org.nasdanika.html.Form;
import org.nasdanika.html.Function;
import org.nasdanika.html.InputGroup;
import org.nasdanika.html.LinkGroup;
import org.nasdanika.html.ListGroup;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Navbar;
import org.nasdanika.html.Require;
import org.nasdanika.html.Table;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.UIElement;
import org.nasdanika.html.UIElement.Style;

/**
 * HTML factory which relies on Bootstrap styles and scripts.
 * @author Pavel
 *
 */
public class DefaultHTMLFactory extends AbstractHTMLFactory {
	
	private RouterApplicationRenderer routerApplicationRenderer = new RouterApplicationRenderer();

	@Override
	public AutoCloseable routerApplication(
			final Object title, 
			final Object initialRoute,
			final Object head, 
			final Object... body) {
		
		return new AutoCloseable() {
			
			@Override
			public void close() throws Exception {
				if (title instanceof AutoCloseable) {
					((AutoCloseable) title).close();
				}
				if (initialRoute instanceof AutoCloseable) {
					((AutoCloseable) initialRoute).close();
				}
				if (head instanceof AutoCloseable) {
					((AutoCloseable) head).close();
				}
				for (Object b: body) {
					if (b instanceof AutoCloseable) {
						((AutoCloseable) b).close();
					}
				}
				
			}
			
			@Override
			public String toString() {
				return routerApplicationRenderer.generate(new RouterApplicationConfig() {
					
					@Override
					public Object getTitle() {
						return title;
					}
					
					@Override
					public Object getInitialRoute() {
						return initialRoute;
					}
					
					@Override
					public Object getHead() {
						return head == null ? "" : head;
					}
					
					@Override
					public Object getBody() {
						StringBuilder bodyBuilder = new StringBuilder();
						for (Object b: body) {
							if (b!=null) {
								bodyBuilder.append(b);
							}
						}
						return bodyBuilder.toString();
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
		};
		
	}

	@Override
	public Navbar navbar(final Object brand, Object brandRef) {
		return new NavbarImpl(this, brand, brandRef);
	}

	@Override
	public ApplicationPanel applicationPanel() {
		return new ApplicationPanelImpl(this);
	}
	

	@Override
	public Table table() {
		return new TableImpl(this);
	}
	
	private List<String> scripts = new ArrayList<>();
	private List<String> stylesheets = new ArrayList<>();
	
	public List<String> getScripts() {
		return scripts;
	}
	
	public List<String> getStylesheets() {
		return stylesheets;
	}

	@Override
	public Tag panel(Style style, final Object header, final Object body, final Object footer) {
		Tag panel = div().addClass("panel").addClass("panel-"+style.name().toLowerCase());
		if (header!=null) {
			panel.content(div(tag("h3", header).addClass("panel-title")).addClass("panel-heading"));
		}
		
		if (body instanceof Table || body instanceof ListGroup || body instanceof LinkGroup) {
			panel.content(body);
		} else if (body!=null) {
			panel.content(div(body).addClass("panel-body"));
		}
		
		if (footer!=null) {
			panel.content(div(footer).addClass("panel-footer"));			
		}
		
		return panel;
	}

	@Override
	public Button button(Object... content) {
		return new ButtonImpl(this, false, content);
	}

	@Override
	public Tag label(Style style, Object... content) {
		return span(content).addClass("label").addClass("label-"+style.name().toLowerCase());
	}
	
	private static final String ALERT_CLOSE_BUTTON = "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>";
	
	@Override
	public Tag alert(Style style, boolean dismissable, Object... content) {
		if (dismissable) {
			return div(ALERT_CLOSE_BUTTON)
					.content(content)
					.addClass("alert")
					.addClass("alert-"+style.name().toLowerCase())
					.addClass("alert-dismissable");			
		}
		return div(content).addClass("alert").addClass("alert-"+style.name().toLowerCase());
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
	public InputGroup<?> inputGroup(Object control) {
		return new InputGroupImpl(this, control);
	}
	
	@Override
	public Accordion accordion() {
		return new AccordionImpl(this);
	}

	@Override
	public Form form() {
		return new FormImpl(this, false, false);
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
	public <T extends UIElement<?>> T tooltip(T element, Placement placement, String text) {
		element
			.attribute("data-toggle", "tooltip")
			.attribute("title", text)
			.attribute("data-placement", placement.name().toLowerCase());
		
		return element;
	}

	@Override
	public Tag input(InputType type, String name, String value, String id, String placeholder) {
		return tag("input")
				.attribute("type", type.code())
				.attribute("name", name)
				.attribute("value", value)
				.id(id)
				.attribute("placeholder", placeholder).addClass("form-control");		
	}

	@Override
	public Tabs tabs() {
		return new TabsImpl(this);
	}

	@Override
	public Tag glyphicon(Glyphicon glyphicon) {		
		return span("").addClass("glyphicon").addClass("glyphicon-"+glyphicon.code());
	}
	
	@Override
	public Tag div(Object... content) {
		return tag("div", content);
	}
	
	@Override
	public Tag span(Object... content) {
		return tag("span", content);
	}
	
	@Override
	public Modal modal() {
		return new ModalImpl(this);
	}
	
	@Override
	public Tag title(final Object title) {
		Object escapedTitle = new Object() {
			public String toString() {
				return StringEscapeUtils.escapeEcmaScript(String.valueOf(title));				
			};
		};
		return tag("script", "document.title=\"", escapedTitle, "\";");
	}
	
	@Override
	public Tag inject(final Object selector, Object... content) {
		final String topId = nextId()+"_inject_container";
		final String contentId = nextId()+"_inject_content";
		Object script = new AutoCloseable() {
			
			@Override
			public String toString() {
				return "if ($(\""+selector+"\").length>0) { $(\""+selector+"\").html($(\"#"+contentId+"\").html()); $(\"#"+topId+"\").remove(); }";
			}
									
			@Override
			public void close() throws Exception {
				if (selector instanceof AutoCloseable) {
					((AutoCloseable) selector).close();
				}
				
			}
		};
		return div(div(content).id(contentId), tag("script", script)).id(topId);
	}
	
	@Override
	public Breadcrumbs breadcrumbs() {
		return new BreadcrumbsImpl(this);
	}

	@Override
	public ButtonGroup buttonGroup(Button... buttons) {
		return new ButtonGroupImpl(this, buttons);
	}

	@Override
	public ButtonToolbar buttonToolbar(ButtonGroup... buttonGroups) {
		return new ButtonToolbarImpl(this, buttonGroups);
	}

	@Override
	public Function function(final Object... paramArgs) {
		return new Function() {
			
			List<Object> params = new ArrayList<>(Arrays.asList(paramArgs));
			List<Object> binds = new ArrayList<>();			
			List<Object> code = new ArrayList<>();

			@Override
			public void close() throws Exception {
				for (Object obj: code) {
					if (obj instanceof AutoCloseable) {
						((AutoCloseable) obj).close();
					}
				}
				for (Object obj: binds) {
					if (obj instanceof AutoCloseable) {
						((AutoCloseable) obj).close();
					}
				}				
				for (Object obj: params) {
					if (obj instanceof AutoCloseable) {
						((AutoCloseable) obj).close();
					}
				}				
			}

			@Override
			public Function code(Object... code) {
				for (Object obj: code) {
					if (obj != null) {
						this.code.add(obj);
					}
				}
				return this;
			}

			@Override
			public Function bind(Object... bind) {
				for (Object obj: bind) {
					if (obj != null) {
						this.binds.add(obj);
					}
				}
				return this;
			}
			
			@Override
			public Function parameter(Object... param) {
				for (Object obj: param) {
					if (obj != null) {
						this.params.add(obj);
					}
				}
				return this;
			}
			
			@Override
			public String toString() {
				StringBuilder ret = new StringBuilder("function(");
				Iterator<Object> pit = params.iterator();
				while (pit.hasNext()) {
					ret.append(pit.next());
					if (pit.hasNext()) {
						ret.append(",");
					}
				}
				ret.append(") {");
				for (Object c: code) {
					ret.append(c);
				}
				ret.append("}");
				if (!binds.isEmpty()) {
					ret.append(".bind(");
					Iterator<Object> bit = binds.iterator();
					while (bit.hasNext()) {
						ret.append(bit.next());
						if (bit.hasNext()) {
							ret.append(",");
						}
					}
					ret.append(")");
				}
				return ret.toString();
			}

		};
	}

	@Override
	public Require require(final Object function, final Object... moduleArg) {
		return new Require() {
			
			List<Object> modules = new ArrayList<>(Arrays.asList(moduleArg));

			@Override
			public void close() throws Exception {
				for (Object obj: modules) {
					if (obj instanceof AutoCloseable) {
						((AutoCloseable) obj).close();
					}
				}
				if (function instanceof AutoCloseable) {
					((AutoCloseable) function).close();
				}
			}

			@Override
			public Require module(Object... module) {
				for (Object obj: module) {
					if (obj!=null) {
						modules.add(obj);
					}
				}
				
				return this;
			}
			
			@Override
			public String toString() {
				StringBuilder ret = new StringBuilder("require([");
				Iterator<Object> mit = modules.iterator();
				while (mit.hasNext()) {
					ret.append("'").append(mit.next()).append("'");
					if (mit.hasNext()) {
						ret.append(",");
					}
				}
				ret.append("], ");
				ret.append(function);
				ret.append(")");
				return ret.toString();
			}
			
		};
	}
}
