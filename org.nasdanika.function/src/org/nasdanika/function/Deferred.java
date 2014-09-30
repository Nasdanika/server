package org.nasdanika.function;

/**
 * Deferred object.
 * @author Pavel Vlasov
 *
 */
public interface Deferred {
	
	Promise getPromise();
	
	void resolve(Object value);
	
	void reject(Object reason);
	
	void notify(Object notification);

}
