package org.nasdanika.html.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.html.Angular;
import org.nasdanika.html.FontAwesome;
import org.nasdanika.html.Grid;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Knockout;
import org.nasdanika.html.UIElement;

/**
 * Base class for UI elements
 * @author Pavel
 *
 * @param <T>
 */
public abstract class UIElementImpl<T extends UIElement<T>> implements UIElement<T>, AutoCloseable {

	private static final String STYLE = "style";

	private static final String DATA_BIND = "data-bind";
	
	private static final String CLASS = "class";
	
	private static final String ID = "id";
	
	public Object getId() {
		return attributes.get(ID);
	}
	
	protected Map<String, Object> attributes = new LinkedHashMap<>();
	
	private Map<String, Object> styles = new LinkedHashMap<>();
	
	private Map<String, Object> koDataBindEntries = new LinkedHashMap<>();

	protected HTMLFactory factory;
	
	public UIElementImpl(HTMLFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public String getAttribute(String name) {
		Object av = attributes.get(name);
		return av==null ? null : av.toString();
	}
	
	/**
	 * Renders attributes
	 * @param excluded Attributes to exclude (already rendered by subclass).
	 */
	protected String attributes(String... excluded) {
		StringBuilder attributeBuilder = new StringBuilder();
		
		for (Entry<String, Object> a: attributes.entrySet()) {
			if (!DATA_BIND.equals(a.getKey()) 
					&& !STYLE.equals(a.getKey()) 
					&& !CLASS.equals(a.getKey()) 
					&& !Arrays.asList(excluded).contains(a.getKey())) {
				if (attributeBuilder.length()>0) {
					attributeBuilder.append(" ");
				}				
				Object value = a.getValue();
				if (Boolean.TRUE.equals(value)) {
					// boolean attributes
					attributeBuilder.append(a.getKey());					
				} else {
					attributeBuilder.append(a.getKey()+"=\""+StringEscapeUtils.escapeHtml4(String.valueOf(value))+"\"");
				}
			}
		}
		
		if (!Arrays.asList(excluded).contains(STYLE)) {
			StringBuilder styleBuilder = new StringBuilder();
			if (attributes.containsKey(STYLE)) {
				styleBuilder.append(attributes.get(STYLE));
			}
			for (Entry<String, Object> se: styles.entrySet()) {
				if (styleBuilder.length()>0 && !styleBuilder.toString().trim().endsWith(";")) {
					styleBuilder.append(";");
				}
				styleBuilder.append(se.getKey()+":"+se.getValue());
			}
			if (styleBuilder.length()>0) {
				if (attributeBuilder.length()>0) {
					attributeBuilder.append(" ");
				}
				attributeBuilder.append(STYLE+"=\""+styleBuilder+"\"");				
			}
		}
		
		if (!Arrays.asList(excluded).contains(DATA_BIND)) {
			StringBuilder dataBindBuilder = new StringBuilder();
			if (attributes.containsKey(DATA_BIND)) {
				dataBindBuilder.append(attributes.get(DATA_BIND));
			}
			for (Entry<String, Object> se: koDataBindEntries.entrySet()) {
				if (dataBindBuilder.length()>0 && !dataBindBuilder.toString().trim().endsWith(",")) {
					dataBindBuilder.append(",");
				}
				dataBindBuilder.append(se.getKey()+":"+se.getValue());
			}
			if (dataBindBuilder.length()>0) {
				if (attributeBuilder.length()>0) {
					attributeBuilder.append(" ");
				}
				attributeBuilder.append(DATA_BIND+"=\""+dataBindBuilder+"\"");				
			}
		}
		
		if (!Arrays.asList(excluded).contains(CLASS)) {
			StringBuilder classBuilder = new StringBuilder();
			for (Object cls: classes) {
				if (classBuilder.length()>0) {
					classBuilder.append(" ");
				}
				classBuilder.append(cls);
			}
			if (attributes.containsKey(CLASS)) {
				if (classBuilder.length()>0) {
					classBuilder.append(" ");
				}
				classBuilder.append(attributes.get(CLASS));
			}
			if (classBuilder.length()>0) {
				if (attributeBuilder.length()>0) {
					attributeBuilder.append(" ");
				}
				attributeBuilder.append(CLASS+"=\""+classBuilder+"\"");				
			}
		}
		
		return attributeBuilder.length()==0 ? "" : " "+attributeBuilder.toString();
	}
	
	/**
	 * Merges value of given attribute, prepended by space, to the attribute definition being
	 * rendered by a subclass
	 * @param attribute
	 */
	protected String merge(String attribute) {
		if (STYLE.equals(attribute)) {
			StringBuilder styleBuilder = new StringBuilder();
			if (attributes.containsKey(STYLE)) {
				styleBuilder.append(attributes.get(STYLE));
			}
			for (Entry<String, Object> se: styles.entrySet()) {
				if (styleBuilder.length()>0 && !styleBuilder.toString().endsWith(";")) {
					styleBuilder.append(";");
				}
				styleBuilder.append(se.getKey()+":"+se.getValue());
			}
			return styleBuilder.toString();
		}
		
		if (attributes.containsKey(attribute)) {
			return StringEscapeUtils.escapeHtml4(String.valueOf(attributes.get(attribute)));
		}
		
		return "";
	}
	
	/**
	 * Merges attributes from the source element into this element.
	 * @param source
	 */
	protected void merge(UIElementImpl<?> source) {
		this.attributes.putAll(source.attributes);
		this.classes.addAll(source.classes);
		this.styles.putAll(source.styles);
	}
	
	@Override
	public T id(Object id) {
		return attribute(ID, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T attribute(String name, Object value) {
		if (value==null) {
			attributes.remove(name);
		} else {
			attributes.put(name, value);
		}
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T style(String name, Object value) {
		if (value==null) {
			styles.remove(name);
		} else {
			styles.put(name, value);
		}
		return (T) this;
	}
	
	@Override
	public T background(BootstrapColor backgroundColor) {
		return style("background-color", backgroundColor.code);
	}
	
	@Override
	public T background(HTMLColor backgroundColor) {
		return style("background-color", backgroundColor.name());
	}
	
	private List<Object> classes = new ArrayList<>();

	private Object remoteContent;
	
	@SuppressWarnings("unchecked")
	@Override
	public T addClass(Object... clazz) {
		for (Object clz: clazz) {
			if (!classes.contains(clz)) {
				classes.add(clz);
			}
		}
		return (T) this;
	}
	
	/**
	 * Helper method
	 * @param o
	 * @throws Exception
	 */
	protected static void close(Object o) throws Exception {
		if (o instanceof AutoCloseable) {
			((AutoCloseable) o).close();
		} else if (o!=null && o.getClass().isArray()) {
			for (Object e: (Object[]) o) {
				close(e);
			}
		} else if (o instanceof Iterable) {
			for (Object e: (Iterable<?>) o) {
				close(e);
			}
		}
	}
	
	@Override
	public void close() throws Exception {
		for (Object attr: attributes.values()) {
			close(attr);
		}		
		for (Object cls: classes) {
			close(cls);
		}		
		for (Object style: styles.values()) {
			close(style);
		}	
		close(remoteContent);
	}

	@Override
	public T on(Event event, Object handler) {		
		return on(event.name(), handler);
	}

	@Override
	public T on(String event, Object handler) {		
		return attribute("on"+event, handler);
	}

	@Override
	public T on(Event event, Reader handler) throws IOException {
		return on(event.name(), handler);
	}

	@Override
	public T on(String event, Reader handler) throws IOException {
		StringWriter sw = new StringWriter();
		char[] cbuf = new char[1024];
		int l;
		while ((l=handler.read(cbuf))!=-1) {
			sw.write(cbuf, 0, l);
		}
		sw.close();
		handler.close();
		return on(event, sw.toString());
	}

	@Override
	public T on(Event event, InputStream handler) throws IOException {
		return on(event.name(), handler);
	}

	@Override
	public T on(String event, InputStream handler) throws IOException {
		return on(event, new InputStreamReader(handler));
	}		

	@SuppressWarnings("unchecked")
	@Override
	public T remoteContent(Object href) {
		if (getId()==null) {
			id(factory.nextId());
		}
		this.remoteContent = href;
		return (T) this;
	}
	
	protected String genLoadRemoteContentScript() {
		if (remoteContent==null) {
			return "";
		}
		
		return factory.tag("script", "nsdLoad(\"#"+getId()+"\", \""+remoteContent+"\");").toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public FontAwesome<T> fontAwesome() {
		return new FontAwesomeImpl<T>((T) this);
	}
	
	@Override
	public Knockout<T> knockout() {
		return new Knockout<T>() {

			@Override
			public void close() throws Exception {
				UIElementImpl.this.close();
			}
			
			@Override
			public String toString() {
				return UIElementImpl.this.toString();
			}

			@Override
			public T visible(Object expression) {
				return bind("visible", expression);
			}

			@Override
			public T text(Object expression) {
				return bind("text", expression);
			}

			@Override
			public T html(Object expression) {
				return bind("html", expression);
			}

			@Override
			public T css(Object expression) {
				return bind("css", expression);
			}

			@Override
			public T style(Object expression) {
				return bind("style", expression);
			}

			@Override
			public T attr(Object expression) {
				return bind("attr", expression);
			}

			@Override
			public T foreach(Object expression) {
				return bind("foreach", expression);
			}

			@Override
			public T if_(Object expression) {
				return bind("if", expression);
			}

			@Override
			public T ifnot(Object expression) {
				return bind("ifnot", expression);
			}

			@Override
			public T with(Object expression) {
				return bind("with", expression);
			}

			@Override
			public T component(Object expression) {
				return bind("component", expression);
			}

			@Override
			public T click(Object expression) {
				return bind("click", expression);
			}

			@Override
			public T event(Object expression) {
				return bind("event", expression);
			}

			@Override
			public T submit(Object expression) {
				return bind("submit", expression);
			}

			@Override
			public T enable(Object expression) {
				return bind("enable", expression);
			}

			@Override
			public T disable(Object expression) {
				return bind("disable", expression);
			}

			@Override
			public T value(Object expression) {
				return bind("value", expression);
			}

			@Override
			public T textInput(Object expression) {
				return bind("textInput", expression);
			}

			@Override
			public T hasFocus(Object expression) {
				return bind("hasFocus", expression);
			}

			@Override
			public T checked(Object expression) {
				return bind("checked", expression);
			}

			@Override
			public T options(Object expression) {
				return bind("options", expression);
			}

			@Override
			public T selectedOptions(Object expression) {
				return bind("selectedOptions", expression);
			}

			@Override
			public T uniqueName(Object expression) {
				return bind("uniqueName", expression);
			}

			@Override
			public T template(Object expression) {
				return bind("template", expression);
			}

			@SuppressWarnings("unchecked")
			@Override
			public T bind(String binding, Object expression) {
				if (expression==null) {
					koDataBindEntries.remove(binding);
				} else {
					koDataBindEntries.put(binding, expression);
				}
				return (T) UIElementImpl.this;
			}
		};
	}
			
	@Override
	public Grid<T> grid() {
		return new Grid<T>() {

			@Override
			public T container() {
				return addClass("container");
			}

			@Override
			public T fluidContainer() {
				return addClass("container-fluid");
			}

			@Override
			public T row() {
				return addClass("row");
			}

			@Override
			public T col(DeviceSize deviceSize, int width) {
				return addClass("col-"+deviceSize.code+"-"+width);
			}

			@Override
			public void close() throws Exception {
				UIElementImpl.this.close();
			}
			
			@Override
			public String toString() {
				return UIElementImpl.this.toString();
			}
			
		};
	}
	
	@Override
	public Angular<T> angular() {
		return new Angular<T>() {
			
			@Override
			public T app() {
				return app("");
			}

			@Override
			public T app(Object appName) {
				return directive("app", appName);
			}

			@Override
			public T controller(Object controllerName) {				
				return directive("controller", controllerName);
			}

			@Override
			public T bind(Object expr) {
				return directive("bind", expr);
			}

			@Override
			public T bindHtml(Object expr) {
				return directive("bind-html", expr);
			}

			@Override
			public T clazz(Object expr) {
				return directive("class", expr);
			}

			@Override
			public T cloak() {
				return directive("cloak", true);
			}

			@Override
			public T hide(Object expr) {
				return directive("hide", expr);
			}

			@Override
			public T show(Object expr) {
				return directive("show", expr);
			}

			@Override
			public T repeat(Object expr) {
				return directive("repeat", expr);
			}

			@Override
			public T click(Object expr) {
				return directive("click", expr);
			}
						
			@Override
			public T directive(String directive, Object expr) {
				return attribute("ng-"+directive, expr);
			}

			@Override
			public void close() throws Exception {
				UIElementImpl.this.close();
			}
			
			@Override
			public String toString() {
				return UIElementImpl.this.toString();
			}

			@Override
			public T bindTemplate(Object expr) {
				return directive("bind-template", expr);
			}

			@Override
			public T blur(Object expr) {
				return directive("blur", expr);
			}

			@Override
			public T change(Object expr) {
				return directive("change", expr);
			}

			@Override
			public T checked(Object expr) {
				return directive("checked", expr);
			}

			@Override
			public T classEven(Object expr) {
				return directive("class-even", expr);
			}

			@Override
			public T classOdd(Object expr) {
				return directive("class-odd", expr);
			}

			@Override
			public T copy(Object expr) {
				return directive("copy", expr);
			}

			@Override
			public T csp() {
				return directive("csp", ""); 
			}

			@Override
			public T cut(Object expr) {
				return directive("cut", expr);
			}

			@Override
			public T dblClick(Object expr) {
				return directive("dblclick", expr);
			}

			@Override
			public T disabled(Object expr) {
				return directive("disabled", expr);
			}

			@Override
			public T focus(Object expr) {
				return directive("focus", expr);
			}

			@Override
			public T form(Object expr) {
				return directive("form", expr);
			}

			@Override
			public T href(Object expr) {
				return directive("href", expr);
			}

			@Override
			public T if_(Object expr) {
				return directive("if", expr);
			}

			@Override
			public T include(Object expr) {
				return directive("include", expr);
			}

			@Override
			public T init(Object expr) {
				return directive("init", expr);
			}

			@Override
			public T jq(Object expr) {
				return directive("jq", expr);
			}

			@Override
			public T keyDown(Object expr) {
				return directive("keydown", expr);
			}

			@Override
			public T keyPress(Object expr) {
				return directive("keypress", expr);
			}

			@Override
			public T keyUp(Object expr) {
				return directive("keyup", expr);
			}

			@Override
			public T list() {
				return directive("list", "");
			}

			@Override
			public T model(Object expr) {
				return directive("model", expr);
			}

			@Override
			public T modelOptions(Object expr) {
				return directive("model-options", expr);
			}

			@Override
			public T mouseDown(Object expr) {
				return directive("mousedown", expr);
			}

			@Override
			public T mouseEenter(Object expr) {
				return directive("mouseenter", expr);
			}

			@Override
			public T mouseLeave(Object expr) {
				return directive("mouseleave", expr);
			}

			@Override
			public T mouseMove(Object expr) {
				return directive("mousemove", expr);
			}

			@Override
			public T mouseOver(Object expr) {
				return directive("mouseover", expr);
			}

			@Override
			public T mouseUp(Object expr) {
				return directive("mouseup", expr);
			}

			@Override
			public T nonBindable() {
				return directive("non-bindable", "");
			}

			@Override
			public T open(Object expr) {
				return directive("open", expr);
			}

			@Override
			public T options(Object expr) {
				return directive("optins", expr);
			}

			@Override
			public T paste(Object expr) {
				return directive("paste", expr);
			}

			@Override
			public T readonly(Object expr) {
				return directive("readonly", expr);
			}

			@Override
			public T selected(Object expr) {
				return directive("selected", expr);
			}

			@Override
			public T src(Object expr) {
				return directive("src", expr); 
			}

			@Override
			public T srcset(Object expr) {
				return directive("srcset", expr);
			}

			@Override
			public T style(Object expr) {
				return directive("style", expr);
			}

			@Override
			public T submit(Object expr) {
				return directive("submit", expr);
			}

			@Override
			public T switch_(Object expr) {
				return directive("switch", expr);
			}

			@Override
			public T switchWhen(Object expr) {
				return directive("switch-when", expr);
			}

			@Override
			public T switchDefault() {
				return directive("switch-default", "");
			}

			@Override
			public T value(Object expr) {
				return directive("value", expr);
			}

			@Override
			public T required(Object expr) {
				return directive("required", expr);
			}

			@Override
			public T minLength(Object expr) {
				return directive("minlength", expr);
			}

			@Override
			public T maxLength(Object expr) {
				return directive("maxlength", expr);
			}

			@Override
			public T pattern(Object expr) {
				return directive("pattern", expr);
			}

			@Override
			public T trim(Object expr) {
				return directive("trim", expr);
			}
			
		};
	}
	
}



