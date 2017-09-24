package org.nasdanika.cdo.validation;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;

/**
 * Validator which uses JavaScript code which shall return true.
 * @author Pavel Vlasov
 *
 */
public class JavaScriptValidator implements Validator<EObject> {
	
	private String script;
	private String scriptRef;
	private String severity;
	private String message;
	private String feature;

	/**
	 * Script to evaluate.
	 * @param script
	 */
	public void setScript(String script) {
		this.script = script;
	}
	
	/**
	 * URL of the script to evaluate. Script is loaded from URL if it is not set explicitly.
	 * Either 'script' or 'scriptRef' shall be set.
	 * @param scriptRef
	 */
	public void setScriptRef(String scriptRef) {
		this.scriptRef = scriptRef;
	}
	
	/**
	 * Validation severity - 'WARNING' or 'ERROR', defaults to 'ERROR'
	 * @param severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	/**
	 * Validation message, defaults to 'Constraint violation: '+<code>condition</code>.
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Optional name of the structural feature (attribute or reference) being validated.
	 * @param feature
	 */
	public void setFeature(String feature) {
		this.feature = feature;
	}

	/**
	 * Evaluates condition with 'target' and 'context' bindings.
	 */
	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		try {
		    ScriptEngineManager factory = new ScriptEngineManager();
		    ScriptEngine engine = factory.getEngineByName("nashorn");
		    Bindings bindings = engine.createBindings();
		    bindings.put("target", eObject);
		    bindings.put("context", context);
		    Object value;
		    if (script != null) {
		    	value = engine.eval(script, bindings);
		    } else {
		    	try (Reader scriptReader = new InputStreamReader(new URL(scriptRef).openStream())) {
		    		value = engine.eval(scriptReader, bindings);
		    	}
		    }
						
			if (!Boolean.TRUE.equals(value)) {			 
				Object[] data = feature == null ? new Object[] { eObject } : new Object[] { eObject, eObject.eClass().getEStructuralFeature(feature) };
				diagnostics.add(new BasicDiagnostic(
						"WARNING".equals(severity) ? Diagnostic.WARNING : Diagnostic.ERROR, 
						getClass().getName(), 
						0, 
						message == null ? "JavaScript constraint violation" : message,
						data));
			}						
			
			return true;
		} catch (Exception e) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, getClass().getName(), 0, "Exception evaluating script: "+e, new Object[] { eObject, e, script, scriptRef}));
			return false;			
			
		}
	}

}
