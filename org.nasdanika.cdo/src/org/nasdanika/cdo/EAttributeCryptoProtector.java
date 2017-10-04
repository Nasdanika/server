package org.nasdanika.cdo;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.eclipse.emf.ecore.EAttribute;

/**
 * Protector which uses encryption.
 * @author Pavel Vlasov
 *
 */
public class EAttributeCryptoProtector implements EAttributeProtector {
	
	protected String getAlgorithm() {
		return "AES";
	}
	
	protected SecretKey getSecretKey(EAttribute attribute) throws Exception {
		byte[] key = getKeyBytes(attribute);
		byte[] aligned = new byte[] {-119, -24, 46, 4, 38, 60, 5, -13, -108, -108, 78, -55, 127, -116, -65, -24}; // Some random 128 bits for AES.
		
		for (int i=0; i < Math.min(key.length, aligned.length); ++i) {
			aligned[i] ^= key[i];
		}
		return new SecretKeySpec(aligned, getAlgorithm());
	}
		
	protected byte[] getKeyBytes(EAttribute attribute) throws Exception {
		String key = System.getProperty(EAttributeCryptoProtector.class.getName()+":key", attribute.getName());
		return key.getBytes(StandardCharsets.UTF_8);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T protect(EAttribute attribute, T value) throws Exception {
        Cipher cipher = Cipher.getInstance(getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(attribute));
        if (value instanceof byte[]) {
    	    return (T) cipher.doFinal((byte[]) value);        	
        }
        if (value instanceof String) {
    	    return (T) Base64.getEncoder().encodeToString(cipher.doFinal(((String) value).getBytes(StandardCharsets.UTF_8)));        	
        	
        }
		
		// TODO Add support of more types, e.g. multi-value attributes.
        
		return value; // Return as-is unprotected.
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unprotect(EAttribute attribute, T value) throws Exception {
        Cipher cipher = Cipher.getInstance(getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(attribute));
        if (value instanceof byte[]) {
    	    return (T) cipher.doFinal((byte[]) value);        	
        }
        if (value instanceof String) {
    	    return (T) new String(cipher.doFinal(Base64.getDecoder().decode((String) value)), StandardCharsets.UTF_8);        	        	
        }
        
		// TODO Add support of more types, e.g. multi-value attributes.
        
		return value; // Return as-is - was not protected.
	}

}
