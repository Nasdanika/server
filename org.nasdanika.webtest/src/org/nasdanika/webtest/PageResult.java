package org.nasdanika.webtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
class PageResult {

	final Class<? extends Page> pageClass;

	PageResult(Class<? extends Page> pageClass) {
		this.pageClass = pageClass;
	}
	
	List<PageMethodResult> results = new ArrayList<>();

}
