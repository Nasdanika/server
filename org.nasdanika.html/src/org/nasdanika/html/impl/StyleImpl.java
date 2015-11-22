package org.nasdanika.html.impl;

import org.nasdanika.html.Style;
import org.nasdanika.html.UIElement;

class StyleImpl<T extends UIElement<T>> implements Style<T> {
	
	private T owner;

	public StyleImpl(T owner) {
		this.owner = owner;
	}
	
	protected T style(String name, Object value) {
		return owner.style(name, value);
	}

	@Override
	public T width(Object width) {
		return style("width", width);
	}

	@Override
	public T height(Object height) {
		return style("height", height);
	}

	@Override
	public Font<T> font() {
		return new Font<T>() {

			@Override
			public T size(Object size) {
				return style("font-size", size);
			}

			@Override
			public T family(Object family) {
				return style("font-family", family);
			}
			
		};
	};
	

}
