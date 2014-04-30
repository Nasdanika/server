package org.nasdanika.html;

import org.nasdanika.html.UIElement.Style;


/**
 * Implementations of this class abstract HTML rendering code from underlying JavaScript/CSS frameworks and
 * rendering of low-level HTML primitives. 
 * @author Pavel
 *
 */
public interface HTMLBuilder {
	
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
	UIElement<?> tag(String tagName, String content);
	
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
	
	/**
	 * A convenience method for creating form inputs
	 * @param type Input type
	 * @param name Input name - optional
	 * @param value Input value - optional
	 * @param id Control id - optional
	 * @param placeholder Placeholder - optional
	 * @return
	 */
	UIElement<?> input(InputType type, String name, String value, String id, String placeholder);
	
	String ul(Iterable<String> items);
	
	String ul(String... items);
	
	String ol(Iterable<String> items);
	
	String ol(String... items);	
	
	ContentNamedContainer createContentNamedContainer(String name, String hint, String content);
	
	AjaxNamedContainer createAjaxNamedContainer(String name, String hint, String location);

	String tabs(Iterable<NamedContainer> tabs);

	String tabs(NamedContainer... tabs);
	
	String panel(UIElement.Style style, String header, String body, String footer);
			
	String link(String url, String text, String hint, String target);

	/**
	 * Build a link for the in-page router.
	 * @param targetElement
	 * @param path
	 * @param text
	 * @param hint
	 * @return
	 */
	String routeLink(String targetElement, String path, String text, String hint);	
	
	/**
	 * Generates a router application
	 * @param title Application title.
	 * @param initialRoute Initial route to navigate.
	 * @param head Declarations to add to head, e.g. script and css references.
	 * @param body Application body.
	 * @return
	 */
	String routerApplication(String title, String initialRoute, String head, String body);

	ListGroup listGroup();
	
	LinkGroup linkGroup();
	
	String label(String content, Style style);
	
	String alert(String content, Style style, boolean dismissable);
	
	// TODO - code from InputStream/Reader, e.g. from class loader resource, escape for putting to attributes, e.g. onclick() 
	// String code(InputStream in, boolean escape);
	
	// TODO script(String) - wraps into <script> with proper new lines.
	
	/****************************
	 *  Complex elements API's  *
	 ****************************/

	Navbar navbar(String brand);
	
	Table table();
			
	ApplicationPanel applicationPanel();
	
	Button button(String text);
	
	Form form();
	
	InputGroup<?> inputGroup(String control);

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
	
}
