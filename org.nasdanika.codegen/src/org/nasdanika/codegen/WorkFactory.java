package org.nasdanika.codegen;

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
	Work<T> createWork(Context context) throws Exception;

}
