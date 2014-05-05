package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public String getId() {
		return attributes.get(ID);
	}
	
	private Map<String, String> attributes = new HashMap<>();
	
	private Map<String, String> styles = new HashMap<>();

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
		
		for (Entry<String, String> a: attributes.entrySet()) {
			if (!STYLE.equals(a.getKey()) && !CLASS.equals(a.getKey()) && !Arrays.asList(excluded).contains(a.getKey())) {
				if (attributeBuilder.length()>0) {
					attributeBuilder.append(" ");
				}
				attributeBuilder.append(a.getKey()+"=\""+a.getValue()+"\"");
			}
		}
		
		if (!Arrays.asList(excluded).contains(STYLE)) {
			StringBuilder styleBuilder = new StringBuilder();
			if (attributes.containsKey(STYLE)) {
				styleBuilder.append(attributes.get(STYLE));
			}
			for (Entry<String, String> se: styles.entrySet()) {
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
			for (String cls: classes) {
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
			for (Entry<String, String> se: styles.entrySet()) {
				if (styleBuilder.length()>0 && !styleBuilder.toString().endsWith(";")) {
					styleBuilder.append(";");
				}
				styleBuilder.append(se.getKey()+":"+se.getValue());
			}
			return styleBuilder.toString();
		}
		
		if (attributes.containsKey(attribute)) {
			return attributes.get(attribute);
		}
		
		return "";
	}
	
	@Override
	public T id(String id) {
		return attribute(ID, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T attribute(String name, String value) {
		if (value==null) {
			attributes.remove(name);
		} else {
			attributes.put(name, value);
		}
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T style(String name, String value) {
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
	
	private List<String> classes = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public T addClass(String clazz) {
		if (!classes.contains(clazz)) {
			classes.add(clazz);
		}
		return (T) this;
	}
	
	/**
	 * Helper method
	 * @param o
	 * @throws Exception
	 */
	protected void close(Object o) throws Exception {
		if (o instanceof AutoCloseable) {
			((AutoCloseable) o).close();
		}
	}

}
