package org.nasdanika.promise;

import org.nasdanika.core.Context;

/**
 * Deferred object.
 * @author Pavel Vlasov
 *
 */
public interface Deferred<C extends Context, F, R, N, P extends Promise<C,F,R,N>> {
	
	P getPromise();
	
	String getId();	
	
	void resolve(F value);
	
	void reject(R reason);
	
	void notify(N notification);

}
