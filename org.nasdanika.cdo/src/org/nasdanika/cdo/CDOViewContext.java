package org.nasdanika.cdo;

import java.util.List;
import java.util.concurrent.locks.Lock;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.view.CDOView;
import org.nasdanika.cdo.security.Principal;
import org.nasdanika.cdo.security.Realm;
import org.nasdanika.core.Context;
import org.nasdanika.core.LockManager;

public interface CDOViewContext<V extends CDOView, CR> extends Context, LockManager<CDOObject> {

	V getView();
	
	/**
	 * Returns Nasdanika CDO security principals. 
	 * @param masterContext Master or merged context, e.g. HttpContext merged with CDO View context. Master context can 
	 * be used to map a principal from the merged context (e.g. HTTP request principal) to Nasdanika CDO security principals.
	 * @return
	 */
	List<Principal> getPrincipals() throws Exception;
	
	/**
	 * Subject holds principal identity and can be used to obtain the principal from the context.
	 * @return
	 */
	CDOViewContextSubject<V,CR> getSubject() throws Exception;
	
	Realm<CR> getSecurityRealm();
	
	/**
	 * Authenticates user with provided credentials. 
	 * Associates user with context/session upon successfull authentication. 
	 * @param credentials
	 * @return authenticated principals if authentication was successful, or empty list.
	 */
	List<Principal> authenticate(CR credentials) throws Exception;
	
	/**
	 * Delegates to the object's cdoReadLock()
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	default Lock getReadLock(CDOObject obj) throws Exception {
		return obj.cdoReadLock();
	}
	
	/**
	 * Delegates to the object's cdoWriteLock()
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	default Lock getWriteLock(CDOObject obj) throws Exception {
		return obj.cdoWriteLock();
	}
	
}
