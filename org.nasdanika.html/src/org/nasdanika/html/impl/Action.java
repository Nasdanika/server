package org.nasdanika.html.impl;

/**
 * Represents action
 * @author Pavel
 *
 */
public class Action {
	
	private String name;
	private String url;
	private String tooltip;

	public Action(String name, String url, String tooltip) {
		this.name = name;
		this.url = url;
		this.tooltip = tooltip;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getTooltip() {
		return tooltip;
	}

}
