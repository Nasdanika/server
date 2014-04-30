package org.nasdanika.html.impl;

import java.util.List;


interface ApplicationPanelConfig {

	int getWidth();

	String getHeader();

	String getHeaderLink();

	int getMinHeight();

	String getNavigation();

	List<String> getContentPanels();

	String getFooter();

	String getStyle();

}
