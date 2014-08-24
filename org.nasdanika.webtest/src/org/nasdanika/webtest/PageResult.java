package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class PageResult {

	final Class<? extends Page> pageClass;
	
	private String id;
	
	public String getId() {
		return id;
	}

	PageResult(Class<? extends Page> pageClass) {
		this.pageClass = pageClass;
	}

	PageResult(Class<? extends Page> pageClass, String id) {
		this(pageClass);
		this.id = id;
	}
	
	List<PageMethodResult> results = new ArrayList<>();

	public List<PageMethodResult> getResults() {
		return results;
	}
	
	public Class<? extends Page> getPageClass() {
		return pageClass;
	}
		
	@SuppressWarnings("unchecked")
	public Class<? extends Page> getPageInterface() {
		for (Class<?> i: pageClass.getInterfaces()) {
			if (Page.class.isAssignableFrom(i)) {
				return (Class<? extends Page>) i;
			}
		}
		return pageClass;
	}
		
	public boolean merge(PageResult anotherResult) {
		if (anotherResult.getPageClass().getName().equals(pageClass.getName())) {
			results.addAll(anotherResult.getResults());
			return true;
		}
		return false;
	}
	
	public Map<Method, Integer> getCoverage() {
		Map<Method, Integer> ret = new HashMap<>();
		for (Method m: pageClass.getMethods()) {
			Method om = AbstractNasdanikaWebTestRunner.getOverridenInterfaceMethod(m, Page.class);
			if (om!=null) { 
				int counter = 0;
				for (PageMethodResult r: results) {
					if (om.equals(r.getMethod())) {
						++counter;
					}
				}
				
				ret.put(om, counter);
			}
		}
		return ret;
	}
	
}
