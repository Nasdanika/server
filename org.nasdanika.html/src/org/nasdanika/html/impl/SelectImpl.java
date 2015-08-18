package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Select;
import org.nasdanika.html.Tag;

class SelectImpl extends InputBaseImpl<Select> implements Select {
	
	public SelectImpl(HTMLFactory factory) {
		super(factory);
	}
	
	private List<Object> items = new ArrayList<>();

	@Override
	public OptionGroup optionGroup(final String label) {
		OptionGroup ret = new OptionGroup() {
			
			private List<Tag> options = new ArrayList<>();
			private boolean disabled;

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder("<optgroup label=\"").append(label).append("\"");
				if (disabled) {
					sb.append(" disabled=\"disabled\"");
				}
				sb.append(">");
				for (Tag option: options) {
					sb.append(option);
				}
				return sb.append("</optgroup>").toString();
			}

			@Override
			public OptionGroup disabled(boolean disabled) {
				this.disabled = disabled;
				return this;
			}

			@Override
			public OptionGroup disabled() {
				return disabled(true);
			}

			@Override
			public OptionGroup option(String value, String label, boolean selected, boolean disabled) {
				Tag option = factory.tag("option", label).attribute("value", value);
				if (selected) {
					option.attribute("selected", "selected");
				} else if (disabled) {
					option.attribute("disabled", "disabled");
				}
				options.add(option);
				return this;
			}
		};
		items.add(ret);
		return ret;
	}

	@Override
	public Select option(String value, String label, boolean selected, boolean disabled) {
		Tag option = factory.tag("option", label).attribute("value", value);
		if (selected) {
			option.attribute("selected", "selected");
		} else if (disabled) {
			option.attribute("disabled", "disabled");
		}
		items.add(option);
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(renderComment()).append("<select").append(attributes()).append(">");
		for (Object item: items) {
			sb.append(item);
		}
		return sb.append("</select>").append(genLoadRemoteContentScript()).toString();
	}

	@Override
	public void close() throws Exception {
		super.close();
		close(items);	
	}

	@Override
	public Select multiple() {
		return multiple(true);
	}

	@Override
	public Select multiple(boolean multiple) {
		return attribute("multiple", multiple? Boolean.TRUE : null);
	}

	@Override
	public Select size(int size) {
		return attribute("size", size);
	}
	
}
