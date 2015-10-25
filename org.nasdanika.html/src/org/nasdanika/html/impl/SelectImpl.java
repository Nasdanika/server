package org.nasdanika.html.impl;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.Select;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

class SelectImpl extends InputBaseImpl<Select> implements Select {
	
	public SelectImpl(HTMLFactory factory) {
		super(factory, TagName.select);
	}

	@Override
	public OptionGroup optionGroup(final String label) {
		OptionGroup ret = new OptionGroup() {
			
			private List<Tag> options = new ArrayList<>();
			private boolean disabled;

			@Override
			public Object produce(int indent) {
				Tag optGroup = factory.tag(TagName.optgroup).attribute("label", label);
				if (disabled) {
					optGroup.attribute("disabled", "disabled");
				}
				for (Tag option: options) {
					optGroup.content(option);
				}
				return optGroup.produce(indent);
			}
						
			/**
			 * Fall-back to mitigate misses during refactoring.
			 */
			@Override
			public String toString() {
				return stringify(this, 0);
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
			public Tag option(String value, boolean selected, boolean disabled, Object... content) {
				Tag option = factory.tag(TagName.option, content).attribute("value", value);
				if (selected) {
					option.attribute("selected", "selected");
				} else if (disabled) {
					option.attribute("disabled", "disabled");
				}
				options.add(option);
				return option;
			}

			@Override
			public OptionGroup option(String value, String label, boolean selected, boolean disabled) {
				option(value, selected, disabled, label);
				return this;
			}
		};
		this.content.add(ret);
		return ret;
	}
	
	@Override
	public Tag option(String value, boolean selected, boolean disabled, Object... optionContent) {
		Tag option = factory.tag(TagName.option, optionContent).attribute("value", value);
		if (selected) {
			option.attribute("selected", "selected");
		} else if (disabled) {
			option.attribute("disabled", "disabled");
		}
		this.content.add(option);
		return option;
	}

	@Override
	public Select option(String value, String label, boolean selected, boolean disabled) {
		option(value, selected, disabled, label);
		return this;
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
