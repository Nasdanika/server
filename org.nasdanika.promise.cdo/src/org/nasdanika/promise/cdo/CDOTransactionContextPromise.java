/**
 */
package org.nasdanika.promise.cdo;

import java.util.concurrent.TimeUnit;

import org.nasdanika.cdo.CDOTransactionContext;
import org.nasdanika.core.Command;
import org.nasdanika.promise.Promise;

/**
 * Binding of Promise to CDOTransactionContext.
 */
public interface CDOTransactionContextPromise<CR, F, R, N> extends Promise<CDOTransactionContext<CR>, F, R, N> {
	
	@Override
	<TR> CDOTransactionContextPromise<CR, F, TR, N> timeout(long timeout, TimeUnit timeUnit, TR reason);

	@Override
	CDOTransactionContextPromise<CR, F, R, N> delay(long timeout, TimeUnit timeUnit);
		
	@Override
	<TF, TR, TN> CDOTransactionContextPromise<CR,TF,TR,TN> then(			
			Command<CDOTransactionContext<CR>,? super F,TF> onFulfill, 
			Command<CDOTransactionContext<CR>,? super R,TF> onReject, 
			Command<CDOTransactionContext<CR>,? super N,TN> onProgress);			
} 
