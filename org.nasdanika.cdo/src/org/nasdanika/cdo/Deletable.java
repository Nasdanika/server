package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Object which handles its own deletion from the repository.
 * This interface is used by CDOViewRoute to process <code>$delete</code> invocation. 
 * For instances of <code>Deletable</code> their <code>delete()</code> method is invoked. 
 * Otherwise <code>EcoreUtil.delete(obj, true)</code> is invoked.
 * 
 * @author Pavel
 *
 * @param <C>
 */
public interface Deletable<C extends CDOTransactionContext<?>> {
	
	default void delete(C context) throws Exception {
		if (this instanceof EObject) {
			EcoreUtil.delete((EObject) this);
		}
	};

}
