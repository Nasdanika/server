package org.nasdanika.promise;

import org.nasdanika.core.Context;

/**
 * Deferred object.
 * @author Pavel Vlasov
 *
 */
public interface Deferred<C extends Context, F, R, N> {
	
	Promise<C,F,R,N> getPromise();
	
	void resolve(F value);
	
	void reject(R reason);
	
	void notify(N notification);

}
