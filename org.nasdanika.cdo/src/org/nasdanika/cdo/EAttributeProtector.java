package org.nasdanika.cdo;

import org.eclipse.emf.ecore.EAttribute;

/**
 * Interface for type-preserving protection of values of {@link EAttribute}s. Protection may be implemented, for example, as encryption or tokenization.  
 * @author Pavel Vlasov
 *
 */
public interface EAttributeProtector {
	
	/**
	 * Crypto-protector with default configuration. 
	 */
	EAttributeProtector CRYPTO_PROTECTOR = new EAttributeCryptoProtector();
	
	<T> T protect(EAttribute attribute, T value) throws Exception;
	
	<T> T unprotect(EAttribute attribute, T value) throws Exception;	

}
