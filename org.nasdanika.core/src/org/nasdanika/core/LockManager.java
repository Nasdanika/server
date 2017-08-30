package org.nasdanika.core;

import java.util.concurrent.locks.Lock;

/**
 * Interface for managing object locks.
 * @author Pavel Vlasov
 *
 * @param <T>
 */
public interface LockManager<T> {
	
	Lock getReadLock(T obj) throws Exception;
	
	Lock getWriteLock(T obj) throws Exception;

}
