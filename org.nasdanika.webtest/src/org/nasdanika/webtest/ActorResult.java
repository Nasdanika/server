package org.nasdanika.webtest;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains results of actor use throughout tests.
 * @author Pavel Vlasov
 *
 */
class ActorResult {

	final Class<? extends Actor> actorClass;

	ActorResult(Class<? extends Actor> actorClass) {
		this.actorClass = actorClass;
	}
	
	List<ActorMethodResult> results = new ArrayList<>();

}
