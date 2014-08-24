package org.nasdanika.webtest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Contains results of actor use throughout tests.
 * @author Pavel Vlasov
 *
 */
public class ActorResult {

	final Class<? extends Actor> actorClass;
	
	private String id;
	
	public String getId() {
		return id;
	}

	ActorResult(Class<? extends Actor> actorClass) {
		this.actorClass = actorClass;		
	}
	
	ActorResult(Class<? extends Actor> actorClass, String id) {
		this(actorClass);
		this.id = id;		
	}
	
	List<ActorMethodResult> results = new ArrayList<>();
	
	public List<ActorMethodResult> getResults() {
		return results;
	}
	
	public Class<? extends Actor> getActorClass() {
		return actorClass;
	}
	
	@SuppressWarnings("unchecked")
	public Class<? extends Actor> getActorInterface() {
		for (Class<?> i: actorClass.getInterfaces()) {
			if (Actor.class.isAssignableFrom(i)) {
				return (Class<? extends Actor>) i;
			}
		}
		return actorClass;
	}
	
	public boolean merge(ActorResult anotherResult) {
		if (anotherResult.getActorClass().getName().equals(actorClass.getName())) {
			results.addAll(anotherResult.getResults());
			return true;
		}
		return false;
	}
	
	public Map<Method, Integer> getCoverage() {
		Map<Method, Integer> ret = new HashMap<>();
		for (Method m: actorClass.getMethods()) {
			Method om = AbstractNasdanikaWebTestRunner.getOverridenInterfaceMethod(m, Actor.class);
			if (om!=null) { 
				int counter = 0;
				for (ActorMethodResult r: results) {
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
