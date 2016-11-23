package org.nasdanika.codegen;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Interface to be implemented by low-level generator classes.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface IGenerator<T> {
	
	/**
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	T generate(Context context, IProgressMonitor monitor) throws Exception;

}
