package org.nasdanika.cdo.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * EObject validators registered with <code>org.nasdanika.cdo.validator</code> extension shall implement this interface.
 * @author Pavel Vlasov
 *
 */
public interface Validator<T extends EObject> {
	
	boolean validate(T eObject, DiagnosticChain diagnostics, Map<Object, Object> context);

}
