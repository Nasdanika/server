package org.nasdanika.html.impl;

import java.util.List;

interface RouterApplicationConfig {

	Object getTitle();

	List<String> getScripts();
	
	List<String> getStylesheets();

	Object getHead();

	Object getInitialRoute();

	Object getBody();

}
