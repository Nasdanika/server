package org.nasdanika.webtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class PageResult {

	final Class<? extends Page> pageClass;

	PageResult(Class<? extends Page> pageClass) {
		this.pageClass = pageClass;
	}
	
	List<PageMethodResult> results = new ArrayList<>();

	public List<PageMethodResult> getResults() {
		return results;
	}
	
	public Class<? extends Page> getPageClass() {
		return pageClass;
	}
}
