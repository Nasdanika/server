package org.nasdanika.codegen;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Generators produce output with only context as input.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface IGenerator<T> extends WorkItem {
		
	/**
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	T generate(Context context, IProgressMonitor monitor) throws Exception;

}
