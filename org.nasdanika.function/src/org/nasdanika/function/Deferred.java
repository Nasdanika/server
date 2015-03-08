package org.nasdanika.function;

/**
 * Deferred object.
 * @author Pavel Vlasov
 *
 */
public interface Deferred<C, F extends Function<C>, P extends Promise<C,F,P>> {
	
	P getPromise();
	
	void resolve(Object value);
	
	void reject(Object reason);
	
	void notify(Object notification);

}
