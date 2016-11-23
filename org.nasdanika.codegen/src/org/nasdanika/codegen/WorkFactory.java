package org.nasdanika.codegen;

import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Creates work to be executed.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface WorkFactory<T> {
		
	/**
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	Work<T> createWork(Context context, IProgressMonitor monitor) throws Exception;
	
	/**
	 * @return Number of work factories to be invoked to create work.
	 */
	int getWorkFactorySize();

}
