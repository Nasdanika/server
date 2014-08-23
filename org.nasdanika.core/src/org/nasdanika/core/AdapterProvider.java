package org.nasdanika.core;

/**
 * Service interface for components which provide adapters.
 * @author Pavel Vlasov
 *
 */
public interface AdapterProvider<T, A> {

	/**
	 * Creates adapter. 
	 * @param target
	 * @return
	 */
	A createAdapter(T target);
	
	Class<A> getAdapterType();
	
}
