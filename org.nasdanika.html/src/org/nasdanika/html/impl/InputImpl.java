package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.Form;
import org.nasdanika.html.Form.EncType;
import org.nasdanika.html.Form.Method;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Input;

class InputImpl extends UIElementImpl<Input> implements Input {
	
	private List<Object> content = new ArrayList<>();
	
	protected List<Object> getContent() {
		return content;
	}
	
	InputImpl(HTMLFactory factory, HTMLFactory.InputType type) {
		super(factory);
		attribute("type", type);
	}
	
	@Override
	public Input content(Object... content) {
		for (Object c: content) {
			this.content.add(c);
		}
		return this;
	}
	
	@Override
	public String toString() {		
		List<Object> theContent = getContent();
		if (theContent.isEmpty()) {
			return "<input"+attributes()+"/>";
		}
		StringBuilder sb = new StringBuilder("<input").append(attributes()).append(">");
		for (Object c: theContent) {
			sb.append(c);
		}
		return sb.append("</input>").append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public void close() throws Exception {
		super.close();
		for (Object c: getContent()) {
			if (c instanceof AutoCloseable) {
				((AutoCloseable) c).close();
			}
		}
	}

	@Override
	public Input autocomplete(boolean autocomplete) {
		return attribute("autocomplete", autocomplete ? "on" : "off");
	}

	@Override
	public Input autocomplete() {
		return autocomplete(true);
	}

	@Override
	public Input autofocus(boolean autofocus) {		
		return attribute("autofocus", autofocus ? Boolean.TRUE : null);
	}

	@Override
	public Input autofocus() {
		return autofocus(true);
	}

	@Override
	public Input form(Form... form) {
		String existingForm = (String) attributes.get("form");
		for (Form f: form) {
			if (f.getId()==null) {
				f.id(factory.nextId());
			}
			if (existingForm!=null && existingForm.trim().length()>0) {
				existingForm+=" ";
			}
			if (existingForm==null) {
				existingForm = f.getId().toString();
			} else {
				existingForm+= f.getId();
			}			
		}
		return this;
	}

	@Override
	public Input formaction(Object formaction) {
		return attribute("formaction", formaction);
	}

	@Override
	public Input formenctype(EncType formEncType) {
		return attribute("formenctype", formEncType.literal);
	}

	@Override
	public Input formmethod(Method formMethod) {
		return attribute("method", formMethod.name());
	}

	@Override
	public Input formnovalidate(boolean formnovalidate) {
		return attribute("formnovalidate", formnovalidate ? Boolean.TRUE : null);
	}

	@Override
	public Input formnovalidate() {
		return formnovalidate(true);
	}

	@Override
	public Input formtarget(Object formTarget) {
		return attribute("formtarget", formTarget);
	}

	@Override
	public Input dimensions(int width, int height) {
		return attribute("width", width).attribute("height", height);
	}

	@Override
	public Input list(Object dataListId) {
		return attribute("list", dataListId);
	}

	@Override
	public Input min(Object min) {
		return attribute("min", min);
	}

	@Override
	public Input max(Object max) {
		return attribute("max", max);
	}

	@Override
	public Input multiple(boolean multiple) {
		return attribute("multiple", multiple ? Boolean.TRUE : null);
	}

	@Override
	public Input multiple() {
		return multiple(true);
	}

	@Override
	public Input pattern(Object pattern) {
		return attribute("pattern", pattern);
	}

	@Override
	public Input name(Object name) {
		return attribute("name", name);
	}

	@Override
	public Input value(Object value) {
		return attribute("value", value);
	}

	@Override
	public Input placeholder(Object placeholder) {
		return attribute("placeholder", placeholder);
	}

	@Override
	public Input required(boolean required) {
		return attribute("required", required ? Boolean.TRUE : null);
	}

	@Override
	public Input required() {
		return required(true);
	}

	@Override
	public Input step(Object step) {
		return attribute("step", step);
	}

}
