package org.nasdanika.codegen;

/**
 * Generation context.
 * @author Pavel Vlasov
 *
 */
public interface Context { // TODO - Autocloseable
	
	/**
	 * @param name
	 * @return Context property by name.
	 */
	Object get(String name);
	
	/**
	 * @param type
	 * @return Context service by type.
	 */
	<T> T get(Class<T> type); 
	
	/**
	 * @return {@link ClassLoader} to use for reflective operations. 
	 */
	ClassLoader getClassLoader();
	
	/**
	 * Creates a new sub-context for this context.
	 * @return
	 */
	default SubContext createSubContext() {
		return this instanceof SubContext ? ((SubContext) this).createSubContext() : new SubContext(this);
	}	
	
}
