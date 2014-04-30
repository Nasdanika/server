package org.nasdanika.html;

/**
 * Abstraction of a UI element. toString() produces HTML markup.
 * @author Pavel
 *
 */
public interface UIElement<T extends UIElement<?>> {
	
	enum Style { DEFAULT, PRIMARY, SUCCESS, INFO, WARNING, DANGER }
	
	enum Size { 
		EXTRA_SMALL("xs"), 
		SMALL("sm"), 
		DEFAULT(null), 
		LARGE("lg");
	
		public final String code;
		Size(String code) {
			this.code = code;
		}
		
	}
	
	enum Color { 
		
		GRAY_DARKER("#222"),
		GRAY_DARK("#333"),
		GRAY("#555"),
		GRAY_LIGHT("#999"),
		GRAY_LIGHTER("#eee"),

		PRIMARY("#428bca"),
		SUCCESS("#5cb85c"),
		INFO("#5bc0de"),
		WARNING("#f0ad4e"),
		DANGER("#d9534f");
		
		public final String code;
		Color(String code) {
			this.code = code;
		}
	}
	
	enum DeviceSize { 
		EXTRA_SMALL("xs"), 
		SMALL("sm"), 
		MEDIUM("md"), 
		LARGE("lg"); 
		
		public final String code;
	
		private DeviceSize(String code) {
			this.code = code;
		}
	}	
	
	/**
	 * Sets background color.
	 * @param backgroundColor
	 * @return
	 */
	T background(Color backgroundColor);

	/**
	 * Sets element id.
	 * @param id
	 * @return
	 */
	T id(String id);
	
	/**
	 * Sets element attribute
	 * @param name  if name is 'id' then value replaces value set through id() and vice versa. If attribute name is 'style' then
	 * this definition is merged with styles defined through style() method.
	 * @param value
	 * @return
	 * 
	 */
	T attribute(String name, String value);
	
	/**
	 * Sets style attribute
	 * @param name
	 * @param value
	 * @return
	 */
	T style(String name, String value);
	
	/**
	 * Adds class definition.
	 * @param clazz
	 * @return
	 */
	T addClass(String clazz);
	
}
