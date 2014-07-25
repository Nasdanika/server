package org.nasdanika.html;

import org.nasdanika.html.UIElement.Style;


/**
 * Implementations of this class abstract HTML rendering code from underlying JavaScript/CSS frameworks and
 * rendering of low-level HTML primitives. 
 * @author Pavel
 *
 */
public interface HTMLFactory {
	
	/**
	 * Generates element ID.
	 * @return
	 */
	String nextId();
	
	/*******************
	 *  Simple API's   *
	 *******************/
	
	/**
	 * Creates a tag with a given name which attributes and styles can be manipulated
	 * with UIElement methods.
	 * @param tagName
	 * @param content
	 * @return
	 */
	Tag tag(String tagName, Object... content);
	
	Tag div(Object... content);
	
	Tag span(Object... content);
	
	enum InputType { 
		button,
		checkbox,
		color,
		date, 
		datetime, 
		datetime_local, 
		email,
		file,
		hidden,
		image,
		month, 
		number, 
		password,
		radio,
		range, 
		reset,
		search,
		submit,
		tel,
		text,
		time, 
		url,
		week;
	
		public String code() {
			return name().replace('_', '-');
		}
	}
	
	Fragment fragment(Object... content);
	
	/**
	 * A convenience method for creating form inputs
	 * @param type Input type
	 * @param name Input name - optional
	 * @param value Input value - optional
	 * @param id Control id - optional
	 * @param placeholder Placeholder - optional
	 * @return
	 */
	Input input(InputType type);
	
	Select select(String name, String id, String placeholder);

	Tag link(Object href, Object... content);
	
	Tag ul(Iterable<?> items);
	
	Tag ol(Iterable<?> items);
	
	Tabs tabs();
	
	Tag panel(UIElement.Style style, Object header, Object body, Object footer);

	/**
	 * Build a link for the in-page router.
	 * @param targetElement
	 * @param path
	 * @param text
	 * @param hint
	 * @return
	 */
	Tag routeLink(Object targetElement, Object path, Object... content);	
	
	/**
	 * Generates a router application
	 * @param title Application title.
	 * @param initialRoute Initial route to navigate.
	 * @param head Declarations to add to head, e.g. script and css references.
	 * @param body Application body.
	 * @return
	 */
	AutoCloseable routerApplication(
			Object title, 
			Object initialRoute, 
			Object head, 
			Object... body);

	Tag label(Style style, Object... content);
	
	Tag alert(Style style, boolean dismissable, Object... content);
	
	// TODO - code from InputStream/Reader, e.g. from class loader resource, escape for putting to attributes, e.g. onclick() 
	// String code(InputStream in, boolean escape);
	
	/****************************
	 *  Complex elements API's  *
	 ****************************/

	ListGroup listGroup();
	
	LinkGroup linkGroup();
	
	Navbar navbar(Object brand, Object brandRef);
	
	Table table();
			
	ApplicationPanel applicationPanel();
	
	Button button(Object... content);
	
	Form form();
	
	InputGroup<?> inputGroup(Object control);

	Accordion accordion();
	
	enum Placement { LEFT, TOP, RIGHT, BOTTOM }
	
	/**
	 * Adds attributes to the element, typically a button, to make it a popover. 
	 * This method does not initialize the popover, it shall be done through JavaScript <code>$(selector).popover();</code> e.g.
	 * <code>$('#my_popover_button').popover();</code>
	 * @param element Element
	 * @param placement popover placement.
	 * @param title popover title
	 * @param text popover text
	 * @return
	 */
	<T extends UIElement<?>> T popover(T element, Placement placement, String title, String text);
	
	/**
	 * Adds tooltip to the element. 
	 * This method does not initialize the tooltip, it shall be done through JavaScript <code>$(selector).tooltip();</code> e.g.
	 * <code>$('#my_button').tooltip();</code>
	 * @param element Element
	 * @param placement tooltip placement.
	 * @param text tooltip text
	 * @return
	 */
	<T extends UIElement<?>> T tooltip(T element, Placement placement, String text);
	
	enum Glyphicon {
		asterisk,
		plus,
		euro,
		minus,
		cloud,
		envelope,
		pencil,
		glass,
		music,
		search,
		heart,
		star,
		star_empty,
		user,
		film,
		th_large,
		th,
		th_list,
		ok,
		remove,
		zoom_in,
		zoom_out,
		off,
		signal,
		cog,
		trash,
		home,
		file,
		time,
		road,
		download_alt,
		download,
		upload,
		inbox,
		play_circle,
		repeat,
		refresh,
		list_alt,
		lock,
		flag,
		headphones,
		volume_off,
		volume_down,
		volume_up,
		qrcode,
		barcode,
		tag,
		tags,
		book,
		bookmark,
		print,
		camera,
		font,
		bold,
		italic,
		text_height,
		text_width,
		align_left,
		align_center,
		align_right,
		align_justify,
		list,
		indent_left,
		indent_right,
		facetime_video,
		picture,
		map_marker,
		adjust,
		tint,
		edit,
		share,
		check,
		move,
		step_backward,
		fast_backward,
		backward,
		play,
		pause,
		stop,
		forward,
		fast_forward,
		step_forward,
		eject,
		chevron_left,
		chevron_right,
		plus_sign,
		minus_sign,
		remove_sign,
		ok_sign,
		question_sign,
		info_sign,
		screenshot,
		remove_circle,
		ok_circle,
		ban_circle,
		arrow_left,
		arrow_right,
		arrow_up,
		arrow_down,
		share_alt,
		resize_full,
		resize_small,
		exclamation_sign,
		gift,
		leaf,
		fire,
		eye_open,
		eye_close,
		warning_sign,
		plane,
		calendar,
		random,
		comment,
		magnet,
		chevron_up,
		chevron_down,
		retweet,
		shopping_cart,
		folder_close,
		folder_open,
		resize_vertical,
		resize_horizontal,
		hdd,
		bullhorn,
		bell,
		certificate,
		thumbs_up,
		thumbs_down,
		hand_right,
		hand_left,
		hand_up,
		hand_down,
		circle_arrow_right,
		circle_arrow_left,
		circle_arrow_up,
		circle_arrow_down,
		globe,
		wrench,
		tasks,
		filter,
		briefcase,
		fullscreen,
		dashboard,
		paperclip,
		heart_empty,
		link,
		phone,
		pushpin,
		usd,
		gbp,
		sort,
		sort_by_alphabet,
		sort_by_alphabet_alt,
		sort_by_order,
		sort_by_order_alt,
		sort_by_attributes,
		sort_by_attributes_alt,
		unchecked,
		expand,
		collapse_down,
		collapse_up,
		log_in,
		flash,
		log_out,
		new_window,
		record,
		save,
		open,
		saved,
		import_icon,
		export,
		send,
		floppy_disk,
		floppy_saved,
		floppy_remove,
		floppy_save,
		floppy_open,
		credit_card,
		transfer,
		cutlery,
		header,
		compressed,
		earphone,
		phone_alt,
		tower,
		stats,
		sd_video,
		hd_video,
		subtitles,
		sound_stereo,
		sound_dolby,
		sound_5_1,
		sound_6_1,
		sound_7_1,
		copyright_mark,
		registration_mark,
		cloud_download,
		cloud_upload,
		tree_conifer,
		tree_deciduous;
		
		public String code() {
			if ("import_icon".equals(name())) {
				return "import";
			}
			return name().replace("_", "-");
		}
	}
	
	Tag glyphicon(Glyphicon glyphicon);
	
	Modal modal();
	
	/**
	 * Generates document.title = title script.
	 * @param title
	 * @return
	 */
	Tag title(Object title);
	
	/**
	 * Generates a DIV and a script to inject content into an element
	 * specified by selector, if such element exists. After injection the 
	 * content is removed from DOM tree. If target container does not exist then 
	 * nothing happens and the content remains where it is. This method can 
	 * be used in single page applications to update, say, breadcrumbs
	 * when a new content is loaded in one of page containers.   
	 * 
	 * @param selector
	 * @param content
	 * @return A DIV contai
	 */
	Tag inject(Object selector, Object... content);
	
	Breadcrumbs breadcrumbs();
	
	ButtonGroup buttonGroup(Button... buttons);
	
	ButtonToolbar buttonToolbar(ButtonGroup... buttonGroups);
	
	// --- JavaScript ---
	
	Function function(Object... param);
	
	/**
	 * Generates RequireJS <code>require([module list], function)</code> 
	 * @param function
	 * @param module
	 * @return
	 */
	Require require(Object function, Object... module);

	Carousel carousel();
	
}
