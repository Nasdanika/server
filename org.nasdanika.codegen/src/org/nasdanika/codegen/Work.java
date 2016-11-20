package org.nasdanika.codegen;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Pavel Vlasov
 *
 */
public interface Work<T> {
	
	/**
	 * @return Total number of work units in this item.
	 */
	int size();
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	T execute(IProgressMonitor monitor) throws Exception;

}
