package org.nasdanika.html;

import java.util.List;

public interface Fragment extends Container<Fragment>, Producer {
	
	boolean isEmpty();
		
	List<Object> getContent();
	
}
