package org.nasdanika.html.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringEscapeUtils;
import org.nasdanika.html.FontAwesome;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.UIElement;

/**
 * Base class for UI elements
 * @author Pavel
 *
 * @param <T>
 */
public abstract class UIElementImpl<T extends UIElement<?>> implements UIElement<T>, AutoCloseable {

	private static final String STYLE = "style";

	private static final String CLASS = "class";
	
	private static final String ID = "id";
	
	public Object getId() {
		return attributes.get(ID);
	}
	
	protected Map<String, Object> attributes = new HashMap<>();
	
	private Map<String, Object> styles = new HashMap<>();

	protected HTMLFactory factory;
	
	public UIElementImpl(HTMLFactory factory) {
		this.factory = factory;
	}
	
	/**
	 * Renders attributes
	 * @param excluded Attributes to exclude (already rendered by subclass).
	 */
	protected String attributes(String... excluded) {
		StringBuilder attributeBuilder = new StringBuilder();
		
		for (Entry<String, Object> a: attributes.entrySet()) {
			if (!STYLE.equals(a.getKey()) && !CLASS.equals(a.getKey()) && !Arrays.asList(excluded).contains(a.getKey())) {
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
				if (styleBuilder.length()>0 && !styleBuilder.toString().endsWith(";")) {
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
	public T background(org.nasdanika.html.UIElement.Color backgroundColor) {
		return style("background-color", backgroundColor.code);
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
	
	@Override
	public T ngApp() {
		return ngApp("");
	}
	
	@Override
	public T ngApp(Object appName) {
		return attribute("ng-app", appName);
	}
	
	@Override
	public T ngController(Object controllerName) {
		return attribute("ng-controller", controllerName);
	}
	
	@Override
	public T ngBind(Object expr) {
		return attribute("ng-bind", expr);
	}
	
	@Override
	public T ngClass(Object expr) {
		return attribute("ng-class", expr);
	}
	
	@Override
	public T ngHide(Object expr) {
		return attribute("ng-hide", expr);
	}
	
	@Override
	public T ngShow(Object expr) {
		return attribute("ng-show", expr);
	}
	
	@Override
	public FontAwesome<T> fontAwesome() {
		return new FontAwesome<T>() {

			@SuppressWarnings("unchecked")
			@Override
			public T getTarget() {
				return (T) UIElementImpl.this;
			}

			@Override
			public FontAwesome<T> brand(Brand brand) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+brand.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> chart(Chart chart) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+chart.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> currency(Currency currency) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+currency.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> directional(Directional directional) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+directional.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> fileType(FileType fileType) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+fileType.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> formControl(FormControl formControl) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+formControl.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> medical(Medical medical) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+medical.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> payment(Payment payment) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+payment.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> spinner(Spinner spinner) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+spinner.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> videoPlayer(VideoPlayer videoPlayer) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+videoPlayer.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> webApplication(WebApplication webApplication) {
				getTarget().addClass("fa");
				getTarget().addClass("fa-"+webApplication.name().replace('_', '-'));
				return this;
			}

			@Override
			public FontAwesome<T> fixedWidth() {
				getTarget().addClass("fa-fw");
				return this;
			}

			@Override
			public FontAwesome<T> li() {
				getTarget().addClass("fa-li");
				return this;
			}

			@Override
			public FontAwesome<T> ul() {
				getTarget().addClass("fa-ul");
				return this;
			}

			@Override
			public FontAwesome<T> spin() {
				getTarget().addClass("fa-spin");
				return this;
			}

			@Override
			public FontAwesome<T> pullLeft() {
				getTarget().addClass("pull-left", "fa-border");
				return this;
			}

			@Override
			public FontAwesome<T> pullRight() {
				getTarget().addClass("pull-right", "fa-border");
				return this;
			}
			
			@Override
			public FontAwesome<T> rotate(Rotate rotate) {
				switch (rotate) {
				case R180:
					getTarget().addClass("fa-rotate-90");
					break;
				case R270:
					getTarget().addClass("fa-rotate-180");
					break;
				case R90:
					getTarget().addClass("fa-rotate-270");
					break;
				default:
					break;
				
				}
				return this;
			}
			
			@Override
			public FontAwesome<T> flip(Flip flip) {
				getTarget().addClass("fa-flip-"+flip.name());
				return this;
			}

			@Override
			public FontAwesome<T> size(Size size) {
				switch (size) {
				case large:
					addClass("fa-lg");
					break;
				case x2:
					addClass("fa-2x");
					break;
				case x3:
					addClass("fa-3x");
					break;
				case x4:
					addClass("fa-4x");
					break;
				case x5:
					addClass("fa-5x");
					break;
				default:
					break;
				
				}
				return this;
			}
			
			@Override
			public String toString() {
				return getTarget().toString();
			}
			
		};
	}
}
