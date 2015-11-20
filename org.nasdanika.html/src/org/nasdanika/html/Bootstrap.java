package org.nasdanika.html;

/**
 * Helper interface for setting Bootstrap classes.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface Bootstrap<T> {

	enum Style { 
		DEFAULT, 
		PRIMARY, 
		SUCCESS, 
		INFO, 
		WARNING, 
		DANGER,
		/**
		 * Applies only to text color
		 */
		MUTED 
	}

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

	/**
	 * Bootstrap colors
	 * @author Pavel
	 *
	 */
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
		DANGER("#d9534f"),
		MUTED("#777");
		
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
	
	interface Grid<T> extends AutoCloseable {
		
		T container();
		T fluidContainer();
		T row();
		T col(Bootstrap.DeviceSize deviceSize, int width);
		
		/**
		 * Sets width for all device sizes
		 * @param width
		 * @return
		 */
		T col(int width);
		
		T colOffset(Bootstrap.DeviceSize deviceSize, int width);
		T colOffset(int width);

		T colPush(Bootstrap.DeviceSize deviceSize, int width);
		T colPush(int width);

		T colPull(Bootstrap.DeviceSize deviceSize, int width);
		T colPull(int width);

	}	
	
	Grid<T> grid();
	
	T background(Style style);
	
	T pullLeft();
	
	T pullRight();
	
	T centerBlock();
	
	T clearfix();
	
	interface Text<T> {
		
		T color(Style style);

		T left();
		
		T center();
		
		T right();
		
		T justify();
		
		T nowrap();
		
		T lowercase();
		
		T uppercase();
		
		T capitalize();		
		
	}
	
	Text<T> text();
	
	T show();
	
	T hidden();
	
	T visibleBlock(DeviceSize deviceSize);
	
	T visibleInline(DeviceSize deviceSize);
	
	T visibleInlineBlock(DeviceSize deviceSize);
	
	T hidden(DeviceSize deviceSize);

}
