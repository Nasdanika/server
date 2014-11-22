package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

/**
 * Contains results of page use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class PageResult {

	private final Class<? extends Page<WebDriver>> pageClass;
	
	private String id;

	private int size;
	
	public String getId() {
		return id;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, int size) {
		this.pageClass = pageClass;
		this.size = size;
	}

	PageResult(Class<? extends Page<WebDriver>> pageClass, String id, int size) {
		this(pageClass, size);
		this.id = id;
	}
	
	public int size() {
		return size;
	}
	
	List<OperationResult<?>> results = new ArrayList<>();

	public List<OperationResult<?>> getResults() {
		return results;
	}
	
//	public Class<? extends Page<WebDriver>> getPageClass() {
//		return pageClass;
//	}
		
	@SuppressWarnings("unchecked")
	public Class<? extends Page<WebDriver>> getPageInterface() {
		if (pageClass.isInterface()) {
			return pageClass;
		}
		for (Class<?> i: pageClass.getInterfaces()) {
			if (Page.class.isAssignableFrom(i)) {
				return (Class<? extends Page<WebDriver>>) i;
			}
		}
		return pageClass;
	}
		
	public void merge(PageResult anotherResult) {
		results.addAll(anotherResult.getResults());
		if (this.size<anotherResult.size()) {
			this.size = anotherResult.size();
		}
	}
	
	public Map<Method, Integer> getCoverage() {
		Map<Method, Integer> ret = new HashMap<>();
		for (Method m: pageClass.getMethods()) {
			if (!Page.class.equals(m.getDeclaringClass())) {
				int counter = 0;
				for (OperationResult<?> r: results) {
					if (m.equals(r.getOperation())) {
						++counter;
					}
				}
				
				ret.put(m, counter);
			}
		}
		return ret;
	}
	
}
