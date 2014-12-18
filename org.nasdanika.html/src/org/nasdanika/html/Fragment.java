package org.nasdanika.html;

import java.util.List;

public interface Fragment extends Container<Fragment> {
	
	boolean isEmpty();
		
	List<Object> getContent();
	
}
