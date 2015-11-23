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
	}
	
	private class BoxImpl implements Box<T> {
		
		private String category;

		public BoxImpl(String category) {
			this.category = category;
		}

		@Override
		public T left(Object spec) {
			return style(category+"-left", spec);
		}

		@Override
		public T right(Object spec) {
			return style(category+"-right", spec);
		}

		@Override
		public T top(Object spec) {
			return style(category+"-top", spec);
		}

		@Override
		public T bottom(Object spec) {
			return style(category+"-bottom", spec);
		}
		
		
	}

	@Override
	public T margin(Object spec) {
		return style("margin", spec);
	}
	
	private Box<T> marginBox = new BoxImpl("margin");

	@Override
	public Box<T> margin() {
		return marginBox;
	}

	@Override
	public T padding(Object spec) {
		return style("padding", spec);
	}

	private Box<T> paddingBox = new BoxImpl("padding");

	@Override
	public Box<T> padding() {
		return paddingBox;
	}

	@Override
	public T border(Object spec) {
		return style("border", spec);
	}

	private Box<T> borderBox = new BoxImpl("border");

	@Override
	public Box<T> border() {
		return borderBox;
	};
	

}
