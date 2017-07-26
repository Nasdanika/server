package org.nasdanika.core;

/**
 * Object which handles its own deletion from the repository.
 * This interface is used by CDOViewRoute to process <code>$delete</code> invocation. 
 * For instances of <code>Deletable</code> their <code>delete()</code> method is invoked. 
 * Otherwise <code>EcoreUtil.delete(obj, true)</code> is invoked 
 * @author Pavel
 *
 * @param <C>
 */
public interface Deletable<C extends Context> {
	
	void delete(C context) throws Exception;

}
