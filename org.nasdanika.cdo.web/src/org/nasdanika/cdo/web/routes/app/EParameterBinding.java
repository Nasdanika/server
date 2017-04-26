package org.nasdanika.cdo.web.routes.app;

import org.eclipse.emf.ecore.EParameter;

/**
 * Holds argument value for EParameter. Bindings are closed after operation invocation.
 * Subclasses may override close() if needed.
 * @author Pavel Vlasov
 *
 */
public class EParameterBinding implements AutoCloseable {
	
	private Object value;
	private EParameter eParameter;

	/**
	 * 
	 * @param eParameter
	 * @param formBinding true if value has to come from a form (e.g. ``form`` or ``part`` binding).
	 * @param value
	 */
	public EParameterBinding(EParameter eParameter, Object value) {
		this.eParameter = eParameter;
		this.value = value;
	}
	
	public EParameter getEParameter() {
		return eParameter;
	}
	
	public Object getValue() {
		return value;
	}
	
	@Override
	public void close() throws Exception {
		// NOP			
	}
	
}