package org.nasdanika.cdo.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * In addition to the "regular" diagnostic this class iterates over registered {@link Validator}s for the <code>eObject</code> and invokes their <code>validate()</code> method. 
 * @author Pavel Vlasov
 *
 */
public class DelegatingDiagnostician extends Diagnostician {
	
	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = super.validate(eObject, diagnostics, context);
		if (eObject != null) {
			for (Validator<EObject> validator: ValidatorRegistry.INSTANCE.getValidators(eObject.eClass())) {
				validator.validate(eObject, diagnostics, context);
			}
		}
		return result;
	}
	

}
