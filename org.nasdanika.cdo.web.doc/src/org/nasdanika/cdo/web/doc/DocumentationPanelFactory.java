package org.nasdanika.cdo.web.doc;

import org.nasdanika.html.Bootstrap;
import org.nasdanika.html.Bootstrap.Glyphicon;
import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;

/**
 * This class generates documentation panel HTML.
 * @author Pavel
 *
 */
public class DocumentationPanelFactory {

	protected HTMLFactory htmlFactory;
	protected String docRoutePath;

	public DocumentationPanelFactory(HTMLFactory htmlFactory, String docRoutePath) {
		this.htmlFactory = htmlFactory;
		this.docRoutePath = docRoutePath;
	}

	/**
	 * @return Tag for the left panel - tree, search.
	 */
	public Tag leftPanel() {
		Tag leftOverlay = htmlFactory.spinnerOverlay(Spinner.spinner).id("left-overlay").style("display", "none");				
		return htmlFactory.div(leftOverlay, leftTabs());
	}
	
	public Tag rightPanel() {
		return htmlFactory.div().id("doc-content");		
	}
	
	protected Tabs leftTabs() {
		Tabs leftTabs = htmlFactory.tabs();
		leftTabs.item(htmlFactory.glyphicon(Glyphicon.book)+"&nbsp;Content", htmlFactory.fragment(tocSearchDiv(), tocDiv()));
		
		Tag searchContainer = searchDiv();	
		Tag searchModule = htmlFactory.tag(TagName.script, "require(['"+docRoutePath+"/resources/js/left-panel.js'], function(tocTree) { /* NOP */ })");
		leftTabs.item(htmlFactory.glyphicon(Glyphicon.search)+"&nbsp;Search", htmlFactory.fragment(searchContainer, searchModule));
		return leftTabs;
	}

	protected Tag searchDiv() {
		Form searchForm = htmlFactory.form().style("padding-top", "3px");
		searchForm.inline();
		Input searchInput = htmlFactory.input(InputType.text)
				//.id("searchText")
				.placeholder("Search query")
				.knockout().textInput("query")
				.knockout().event("{ keypress: searchKeyPress }");
		FormInputGroup searchGroup = searchForm.formInputGroup("Search", searchInput, "Search query");
		
		searchGroup.rightButton(htmlFactory.glyphicon(Glyphicon.search))
			.knockout().click("search")
			.knockout().enable("query");
		
		searchGroup.style("width", "100%");
		searchGroup.getInputGroup().style("width", "100%");
		
		Tag searchResultError = htmlFactory.alert(Bootstrap.Style.DANGER, false)
				.knockout().text("error")
				.knockout().visible("error")
				.style("margin-right", "5px")
				.style("margin-top", "5px");
		
		Tag searchContainer = htmlFactory.div(searchForm, searchResultError, searchResultsList()).id("search-container");
		return searchContainer;
	}

	protected Tag searchResultsList() {
		Tag searchResultIcon = htmlFactory.tag("img")
				.style("margin-right", "3px")
				.knockout().attr("{ src: icon }")
				.knockout().if_("icon");
		
		Tag searchResultLink = htmlFactory.tag("a", "")
				.knockout().text("name")
				.knockout().attr("{ href: href }");
		
		Tag searchResult = htmlFactory.tag(TagName.li, searchResultIcon, searchResultLink);					
		Tag searchResults = htmlFactory.tag(TagName.ol, searchResult).knockout().foreach("results");
		return searchResults;
	}

	protected Tag tocDiv() {
		return htmlFactory.div().id("toc");
	}
	
	protected Tag tocSearchDiv() {
		Input searchText = htmlFactory.input(InputType.text).id("toc-search").style().width("100%").placeholder("Search the table of contents");
		return htmlFactory.div(searchText);
	}

}
