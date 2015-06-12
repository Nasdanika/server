package org.nasdanika.cdo.web.doc;

import org.nasdanika.html.FontAwesome.Spinner;
import org.nasdanika.html.Form;
import org.nasdanika.html.FormInputGroup;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.HTMLFactory.Glyphicon;
import org.nasdanika.html.HTMLFactory.InputType;
import org.nasdanika.html.Input;
import org.nasdanika.html.Tabs;
import org.nasdanika.html.Tag;
import org.nasdanika.html.Tag.TagName;
import org.nasdanika.html.UIElement.Style;

/**
 * This class generates documentation panel HTML.
 * @author Pavel
 *
 */
public class DocumentationPanelFactory {

	private HTMLFactory htmlFactory;
	private String docRoutePath;

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
		Tag tocDIV = htmlFactory.div().id("toc");
		leftTabs.item(htmlFactory.glyphicon(Glyphicon.book)+"&nbsp;Content", tocDIV);
		
		Form searchForm = htmlFactory.form().style("padding-top", "3px");
		searchForm.inline();
		Input searchInput = htmlFactory.input(InputType.text)
				.id("searchText")
				.placeholder("Search query")
				.koDataBind("textInput", "query")
				.koDataBind("event", "{ keypress: searchKeyPress }");
		FormInputGroup searchGroup = searchForm.formInputGroup("Search", "searchText", searchInput, "Search query");
		searchGroup.rightButton(htmlFactory.glyphicon(Glyphicon.search)).koDataBind("click", "search").koDataBind("enable", "query");
		searchGroup.style("width", "100%");
		searchGroup.getInputGroup().style("width", "100%");
		
		Tag searchResultIcon = htmlFactory.tag("img")
				.style("margin-right", "3px")
				.koDataBind("attr", "{ src: icon }")
				.koDataBind("visible", "icon");
		
		Tag searchResultLink = htmlFactory.tag("a", "")
				.koDataBind("text", "name")
				.koDataBind("attr", "{ href: href }");
		
		Tag searchResultError = htmlFactory.alert(Style.DANGER, false)
				.koDataBind("text", "error")
				.koDataBind("visible", "error")
				.style("margin-right", "5px")
				.style("margin-top", "5px");
		
		Tag searchResult = htmlFactory.tag(TagName.li, searchResultIcon, searchResultLink);					
		Tag searchResults = htmlFactory.tag(TagName.ol, searchResult).koDataBind("foreach", "results");
		Tag searchContainer = htmlFactory.div(searchForm, searchResultError, searchResults).id("search-container");
		
		Tag searchModule = htmlFactory.tag(TagName.script, new SearchModuleGenerator().generate(docRoutePath));
		leftTabs.item(htmlFactory.glyphicon(Glyphicon.search)+"&nbsp;Search", searchContainer, searchModule);
		return leftTabs;
	}
	

}
