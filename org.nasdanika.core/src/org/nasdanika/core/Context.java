package org.nasdanika.core;

/**
 * Base interface for command contexts.
 * @author Pavel
 *
 */
public interface Context extends AutoCloseable, Adaptable {
	
//	interface Closeable<C extends Context> {
//		void close(C context) throws Exception;
//	}
//	
//	/**
//	 * Adds a resource to close when context is closed.
//	 * @param toClose
//	 */
//	void toClose(AutoCloseable... toClose);
//	
//	void toClose(Closeable<?>... toClose);
	
//	void executeLater(Command command);

}
