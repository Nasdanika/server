package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MethodResult {

	final Method method;

	final MethodResult parent;

	final String id;

	MethodResult(String id, Method method, MethodResult parent) {
		this.id = id;
		this.method = method;
		this.parent = parent;
		if (parent!=null) {
			parent.childResults.add(this);
		}
	}
	
	@Override
	public String toString() {
		return getClass().getName()+ 
				" [method=" + method + 
				", start=" + start + 
				", finish=" + finish + 
				", failure=" + failure + "]";
	}

	long start = System.currentTimeMillis();
	
	ScreenshotEntry beforeScreenshot;
	
	long finish;
	
	ScreenshotEntry afterScreenshot;

	Throwable failure;
	
	List<MethodResult> childResults = new ArrayList<>();
	
	List<ScreenshotEntry> allScreenshots() {
		return collectAllScreenshots( new LinkedList<ScreenshotEntry>()); 
	}
	
	private LinkedList<ScreenshotEntry> collectAllScreenshots(LinkedList<ScreenshotEntry> collector) {
		if (beforeScreenshot!=null && (collector.isEmpty() || beforeScreenshot.getMaster()!=collector.getLast())) {
			collector.add(beforeScreenshot.getMaster());
		}
		
		for (MethodResult mr: childResults) {
			mr.collectAllScreenshots(collector);
		}
		
		if (afterScreenshot!=null && (collector.isEmpty() || afterScreenshot.getMaster()!=collector.getLast())) {
			collector.add(afterScreenshot.getMaster());
		}
		return collector;
	};
	
}
