package org.nasdanika.cdo.web.doc;

import java.util.Map;

public interface WikiLinkResolver {

	String resolve(String spec, String docRoutePath, Map<Object, Object> environment); 
	
}
