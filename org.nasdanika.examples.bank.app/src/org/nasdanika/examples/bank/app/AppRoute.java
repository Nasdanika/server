package org.nasdanika.examples.bank.app;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.nasdanika.html.Accordion;
import org.nasdanika.html.ApplicationPanel;
import org.nasdanika.html.Breadcrumbs;
import org.nasdanika.html.Button;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormGroup.Status;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.Fragment;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.HTMLFactory.Placement;
import org.nasdanika.html.Modal;
import org.nasdanika.html.Navbar;
import org.nasdanika.html.Table;
import org.nasdanika.html.Table.Row;
import org.nasdanika.html.UIElement.Color;
import org.nasdanika.html.UIElement.DeviceSize;
import org.nasdanika.html.UIElement.Event;
import org.nasdanika.html.UIElement.Size;
import org.nasdanika.html.UIElement.Style;
import org.nasdanika.web.Action;
import org.nasdanika.web.Route;
import org.nasdanika.web.WebContext;

/**
 * Route to demonstrate/test HTMLFactory capabilities
 * @author Pavel
 *
 */
public class AppRoute implements Route {

	@Override
	public Action execute(WebContext context) throws Exception {
		final HTMLFactory htmlFactory = context.getHTMLFactory();
		
		ApplicationPanel appPanel = htmlFactory.applicationPanel()
				.header("My application")
				.headerLink("#")
				.footer(
						htmlFactory.link("#", "Contact us"), 
						"&nbsp;&middot;&nbsp;", 
						htmlFactory.link("#", "Privacy Policy"))
				.width(800);
		
		Navbar navBar = htmlFactory.navbar("Welcome back, Joe Doe")
				.item(htmlFactory.link("#", "Accounts"), true, false)
				.item(htmlFactory.link("#", "Customer service"), false, true);
						
		navBar.dropdown("Transfer", false)
				.item(htmlFactory.link("#", "Internal"))
				.divider()
				.header("External transfers")
				.item(htmlFactory.link("#", "Wire"))
				.item(htmlFactory.link("#", "Payment Gateway"));
		
		Breadcrumbs breadcrumbs = htmlFactory.breadcrumbs()
				.item("#", "Home")
				.item("#", "My page")
				.item(null, "Details");
		
		appPanel.navigation(navBar, breadcrumbs);
		
		appPanel.contentPanel(
				htmlFactory.linkGroup()
					.item("Item 1", "#", Style.DEFAULT, true)
					.item("Item 2", "#", Style.DEFAULT, false)
					.item("Item 3", "#", Style.SUCCESS, false))
				.width(DeviceSize.LARGE, 2).id("side-panel");
				
		Accordion accordion = htmlFactory.accordion()
				.item("Item 1", "Item 1 body")
				.item("Item 2", Style.PRIMARY, "Item 2 body")
				.item("Item 3", Style.WARNING, "Item 3 body")
				.style(Style.SUCCESS);
		
		Fragment body = htmlFactory.fragment(accordion);
		
		// Button groups 
		Fragment buttonGroups = htmlFactory.fragment();
		buttonGroups.content(
				htmlFactory.buttonGroup(
						htmlFactory.button("A").on(Event.click, "alert('Here we go!!!');"),
						htmlFactory.button("B").style(Style.PRIMARY),
						htmlFactory.button("C")),
				"&nbsp;",
				htmlFactory.buttonGroup(
						htmlFactory.button("A").style(Style.WARNING),
						htmlFactory.button("B").style(Style.INFO),
						htmlFactory.button("C")).size(Size.LARGE),
				"&nbsp;",
				htmlFactory.buttonGroup(
						htmlFactory.button("A"),
						htmlFactory.button("B").style(Style.PRIMARY),
						htmlFactory.button("C")).vertical().size(Size.EXTRA_SMALL),
				"&nbsp;",
				htmlFactory.buttonGroup(
						htmlFactory.button("A"),
						htmlFactory.button("B").style(Style.PRIMARY),
						htmlFactory.button("C")
							.item(htmlFactory.link("#", "C1"))
							.divider()
							.header("C2")
							.item(htmlFactory.link("#", "C2.1"))
							.item(htmlFactory.link("#", "C2.2"))),
				"&nbsp;",
				htmlFactory.buttonGroup(
						htmlFactory.button("A"),
						htmlFactory.button("B").style(Style.PRIMARY),
						htmlFactory.button("C")
							.item(htmlFactory.link("#", "C1"))
							.divider()
							.header("C2")
							.item(htmlFactory.link("#", "C2.1"))
							.item(htmlFactory.link("#", "C2.2"))).vertical(),
				"<HR/>", 
				htmlFactory.label(Style.SUCCESS, "This is a button toolbar ", htmlFactory.glyphicon(Glyphicon.arrow_down)),
				"<P/>",
				htmlFactory.buttonToolbar(
						htmlFactory.buttonGroup(
								htmlFactory.button("A"),
								htmlFactory.button("B").style(Style.PRIMARY),
								htmlFactory.button("C")),
						htmlFactory.buttonGroup(
								htmlFactory.button("X"),
								htmlFactory.button("Y").style(Style.PRIMARY),
								htmlFactory.button("Z")
								.item(htmlFactory.link("#", "Z1"))
								.divider()
								.header("Z2")
								.item(htmlFactory.link("#", "Z2.1"))
								.item(htmlFactory.link("#", "Z2.2")))
						),
				"<HR/>", 
				htmlFactory.buttonGroup(
						htmlFactory.button("A"),
						htmlFactory.button("B").style(Style.PRIMARY),
						htmlFactory.button("C")
							.item(htmlFactory.link("#", "C1"))
							.divider()
							.header("C2")
							.item(htmlFactory.link("#", "C2.1"))
							.item(htmlFactory.link("#", "C2.2"))).justified()				
				);
		
		
		body.content(htmlFactory.panel(Style.INFO, "Button Groups &amp; Toolbars", buttonGroups, null));
		
		appPanel.contentPanel(body).width(DeviceSize.LARGE, 8);
		
		body.content(htmlFactory.tag("div", "").style("min-height", "200px"));
		
		Modal modal = htmlFactory.modal()
				.title("Hello")
				.body("World")
				.small()
				.footer(htmlFactory.button("Close").attribute("data-dismiss", "modal"));
		
		body.content(modal, modal.bind(htmlFactory.button("Open dialog")));
		
		body.content(htmlFactory.tag("div", "").style("min-height", "200px"));		
		
		body.content(htmlFactory.inject("#side-panel", "Hello!"));
		
		Button simpleButton = htmlFactory.button("Simple button").on(Event.click, "alert('Hello > & ');");
		body.content(simpleButton, "&nbsp;");
		
		Button styledDropDownButton = htmlFactory.button("Styled")
				.style(Style.PRIMARY)
				.item(htmlFactory.link("#", "Item 1"))
				.divider()
				.header("Section header")
				.item(htmlFactory.link("#", "Item 2"));
		
		body.content(styledDropDownButton, "&nbsp;");
				
		Button splitDropUpButton = htmlFactory.button("Split")
				.style(Style.SUCCESS)
				.dropup()
				.split()
				.item(htmlFactory.link("#", "Item 1"))
				.divider()
				.header("Section header")
				.item(htmlFactory.link("#", "Item 2"));
		
		body.content(splitDropUpButton, "&nbsp;");
		
		body.content("<p/>");
		
		Form form = htmlFactory.form();
		form.formGroup(
				"Login", 
				"login", 
				htmlFactory.input(InputType.text, "login", null, "login", "Enter login"),
				"Enter your login name").status(Status.SUCCESS);
		
		FormInputGroup passwordFormInputGroup = form.formInputGroup(
				"Password", 
				"password", 
				htmlFactory.input(InputType.password, "password", null, "password", "Enter password"),
				"Enter password").status(Status.ERROR).feedback();
		
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("html", true);
		passwordFormInputGroup.leftPopoverHelpButton(
				Placement.BOTTOM, 
				"Password", 
				"Minimum 6 symbols including <I>special</I> characters",
				options).style(Style.DANGER);
		
		
		form.formGroup(null, null, htmlFactory.button("Log in"), null);		
		
		FormInputGroup creditCardGroup = form.formInputGroup(
				"Credit card", 
				"credit_card", 
				htmlFactory.input(
						InputType.number, 
						"credit_card", 
						null, 
						"credit_card", 
						"Credit card number"), 
				"Invalid card number").status(Status.ERROR);
		
		creditCardGroup.leftAddOn(htmlFactory.glyphicon(Glyphicon.credit_card));
		creditCardGroup.rightButton("Stored cards")
			.item(htmlFactory.link("#", "Visa-1234"))
			.item(htmlFactory.link("#", "Master Card-6789")).style(Style.DANGER);
//		creditCardGroup.rightPopoverHelpButton(
//				Placement.BOTTOM, 
//				"Credit card number", 
//				"Typically 16 digits",
//				null);
		
		body.content(form);
		
		body.content("<hr/>");
		
//		InputGroup<?> inputGroup = htmlFactory.inputGroup(
//				htmlFactory.input(
//						InputType.number, 
//						"credit_card", 
//						null, 
//						"credit_card", 
//						"Credit card number"));
//		
//		inputGroup.leftAddOn(htmlFactory.glyphicon(Glyphicon.credit_card));
//		inputGroup.rightButton("Stored cards")
//			.item(htmlFactory.link("#", "Visa-1234"))
//			.item(htmlFactory.link("#", "Master Card-6789"));
//		
//		body.content(inputGroup);				

		body.content(
				htmlFactory.tooltip(
						htmlFactory.label(Style.SUCCESS, "Life is good!").id("life_is_good"),
						HTMLFactory.Placement.BOTTOM,
						"A <B>good</B> life is even <U>better</U>!!!"));
		body.content(htmlFactory.tag("script", "$('#life_is_good').tooltip({html:true});"));
		
		
		body.content("<p/>");
		
		body.content(htmlFactory.panel(Style.DEFAULT, null, "Simple panel", null)                              );
		body.content(htmlFactory.panel(Style.PRIMARY, "Panel header", "Panel with header", null)               );
		body.content(htmlFactory.panel(Style.WARNING, "Warning", "Something is fishy", "Proceed with caution!"));
		
		Button popoverButton = htmlFactory.button("Click me for information!").id("info_button").remoteContent("/test.html");
		htmlFactory.popover(popoverButton, Placement.RIGHT, null, "Some useful information");
		body.content(popoverButton);
		body.content(htmlFactory.tag("script", "$('#info_button').popover();"));	
		
		body.content("<p/>");
		
		Table transactionTable = htmlFactory.table();//.bordered();
		Row headerRow = transactionTable.row().background(Color.INFO);
		headerRow.header(htmlFactory.glyphicon(Glyphicon.calendar), " Date");
		headerRow.header("Description");
		headerRow.header(htmlFactory.glyphicon(Glyphicon.usd), " Amount");
		headerRow.header(htmlFactory.glyphicon(Glyphicon.usd), " Balance");
		
		Row transaction1 = transactionTable.row();
		transaction1.cell("05/04/2014");
		transaction1.cell("Utility payment");
		transaction1.cell("-80.00").attribute("align", "right");
		transaction1.cell("470.00").attribute("align", "right");
		
		Row transaction2 = transactionTable.row();
		transaction2.cell("05/03/2014");
		transaction2.cell("Direct deposit from SomeCorp");
		transaction2.cell("500.00").attribute("align", "right");
		transaction2.cell("550.00").attribute("align", "right");
		
		Row transaction3 = transactionTable.row().style(Style.WARNING); // below low balance threshold
		transaction3.cell("05/02/2014");
		transaction3.cell("...").remoteContent("/test.html");
		transaction3.cell("-100.00").attribute("align", "right");
		transaction3.cell("50.00").attribute("align", "right");
		
		body.content(htmlFactory.panel(Style.PRIMARY, "Unbilled transactions", transactionTable, null));
		
		body.content(
				htmlFactory.panel(
						Style.PRIMARY, 
						"Tasks", 
						htmlFactory.listGroup()
							.item("Wake up", Style.DEFAULT)
							.item("Brush teeth", Style.DEFAULT)
							.item("Eat breakfast", Style.INFO)
							.item("Drive to work", Style.DEFAULT), 
						null)
				);
		
		body.content(
				htmlFactory.tabs()
					.item("Tab 1", "Tab 1 content")
					.ajaxItem("Tab 2", "tab2.html")
				);
		
		body.content(htmlFactory.tag("div", "").style("min-height", "200px"));
		
		appPanel.contentPanel(
				htmlFactory.alert(Style.SUCCESS, true, "Offer of the day")
			).width(DeviceSize.LARGE, 2);
		
		body.content(
				htmlFactory.panel(
						Style.INFO, 
						null,
						new AutoCloseable() {
							
							@Override
							public String toString() {
								// Produce dynamic HTML
								return htmlFactory
										.label(Style.SUCCESS, new Date())
										.toString();
							}
							
							@Override
							public void close() throws Exception {
								// Close resources;								
							}
						}, 						 
						null));
		
		final AutoCloseable app = 
			htmlFactory.routerApplication(
				"My Application", 
				null, 
				null, 
				appPanel);
		
		// TODO Auto-generated method stub
		return new Action() {
			
			@Override
			public void close() throws Exception {
				app.close();				
			}
			
			@Override
			public Object execute() throws Exception {
				return app.toString();
			}
		};
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void close() throws Exception {
		// NOP
	}

}
