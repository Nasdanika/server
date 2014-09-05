package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

/**
 * Contains results of actor use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class ActorResult {

	private final Class<? extends Actor<WebDriver>> actorClass;
	
	private String id;
	
	public String getId() {
		return id;
	}

	ActorResult(Class<? extends Actor<WebDriver>> actorClass) {
		this.actorClass = actorClass;		
	}
	
	ActorResult(Class<? extends Actor<WebDriver>> actorClass, String id) {
		this(actorClass);
		this.id = id;		
	}
	
	List<ActorMethodResult> results = new ArrayList<>();
	
	public List<ActorMethodResult> getResults() {
		return results;
	}
	
	public Class<? extends Actor<WebDriver>> getActorClass() {
		return actorClass;
	}
	
	@SuppressWarnings("unchecked")
	public Class<? extends Actor<WebDriver>> getActorInterface() {
		if (actorClass.isInterface()) {
			return actorClass;
		}
		for (Class<?> i: actorClass.getInterfaces()) {
			if (Actor.class.isAssignableFrom(i)) {
				return (Class<? extends Actor<WebDriver>>) i;
			}
		}
		return actorClass;
	}
	
	public void merge(ActorResult anotherResult) {
		results.addAll(anotherResult.getResults());
	}
	
	public Map<Method, Integer> getCoverage() {
		Map<Method, Integer> ret = new HashMap<>();
		for (Method m: actorClass.getMethods()) {
			if (!Actor.class.equals(m.getDeclaringClass())) {
				int counter = 0;
				for (ActorMethodResult r: results) {
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
