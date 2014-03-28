package org.nasdanika.web;

public interface Route {

	Action navigate(Context context) throws Exception;
	
}
